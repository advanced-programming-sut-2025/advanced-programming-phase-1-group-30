package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;

import models.Animals.Animal;
import models.App;
import models.Game;
import models.Commands.GameMenuCommands;
import models.Items.Products.ForgingSeed;
import models.Items.Products.ForgingSeedType;
import models.Maps.Map;
import models.Maps.Tile;
import models.Maps.Weather;
import models.Players.Player;
import models.Users.User;
import views.GameMenu;

public class NewGameController {
    public static void NewGame(String username1, String username2, String username3, Scanner scanner) {
        User user1 = null;
        User user2 = null;
        User user3 = null;
        ArrayList<Player> players = new ArrayList<>();
        Player playerX = new Player(App.getCurrentUser().getUsername(), 1);
        players.add(playerX);
        if (username1 == null &&
            username2 == null &&
            username3 == null) GameMenu.printResult("You should at least enter one user");

        if (username1 != null) {
            user1 = User.findUserByUsername(username1);
            if (user1 == null) GameMenu.printResult("Invalid User1");
            if (user1.isInGame()) GameMenu.printResult("User1 already in Game");
            
            Player player1 = new Player(user1.getUsername(), 2);
            user1.setPlayer(player1);
            user1.changeInGame();
            players.add(player1);
        }

        if (username2 != null) {
            user2 = User.findUserByUsername(username2);
            if (user2 == null) GameMenu.printResult("Invalid User2");
            if (user2.isInGame()) GameMenu.printResult("User2 already in Game");

            Player player2 = new Player(user2.getUsername(), 3);
            user2.setPlayer(player2);
            user2.changeInGame();
            players.add(player2);
        }

        if (username3 != null) {
            user3 = User.findUserByUsername(username3);
            if (user3 == null) GameMenu.printResult("Invalid User3");
            if (user3.isInGame()) GameMenu.printResult("User3 already in Game");

            Player player3 = new Player(user3.getUsername(), 4);
            user3.setPlayer(player3);
            user3.changeInGame();
            players.add(player3);
        }
        App.getMaps().add(new Map(1));
        GameMenu.printResult("Please select your maps...");

        for (Player player : players) {
            boolean mapIsSelected = false;
            while (!mapIsSelected) {
                GameMenu.printResult("Choosing map for " + player.getUsername());
                String command = scanner.nextLine();
                Matcher matcher = GameMenuCommands.GAME_MAP.regexMatcher(command);
                if (matcher.matches()) {
                    int mapNumber = Integer.parseInt(matcher.group("mapNumber"));
                    Map map = Map.getMapById(mapNumber);
                    if (map == null) GameMenu.printResult("Please choose between available maps");
                    player.setMap(map);
                    mapIsSelected = true;
                    player.setX(1);
                    player.setY(1);
                }
                else {
                    GameMenu.printResult("Invalid command");
                }
            }
        }
        Game game = new Game(players);
        game.setTomorrowWeather(Weather.SUNNY);
        game.setCurrentPlayer(playerX);
        App.setCurrentGame(game);
        GameMenu.printResult("Starting new game...");
    }

    public static void LoadGame() {}
    public static void ExitGame() {}
    public static void NextTurn() {
        List<Player> players = App.getCurrentGame().getPlayers();
        Player currentPlayer = App.getCurrentGame().getCurrentPlayer();

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);

            if (player.getSelectionNumber() == currentPlayer.getSelectionNumber() + 1) {
                if (player.isPassedOut()) continue;
                App.getCurrentGame().setCurrentPlayer(player);
                return;
            }
        }
        for (Player player : players) {
            if (!player.isPassedOut()) {
                App.getCurrentGame().setCurrentPlayer(player);
                return;
            }
        }
        int currentTime = App.getCurrentGame().getCurrentTime().getHour();
        if (currentTime == 21) {
            for (Player player : App.getCurrentGame().getPlayers()) {
                player.setEnergy(player.getMaxEnergy());
                if (player.isPassedOut()) {
                    player.setEnergy((player.getMaxEnergy() * 3) / 4);
                }
            }
            for (Player player : App.getCurrentGame().getPlayers()) {
                Tile[][] tiles = player.getMap().getTiles();
                for (int i = 0; i < tiles.length; i++) {
                    for (int j = 0; j < tiles[i].length; j++) {
                        if (tiles[i][j].isPlanted()) {
                            ForgingSeed seed = (ForgingSeed)tiles[i][j].getItem();
                            tiles[i][j].getCrop().setDaysPassed(tiles[i][j].getCrop().getDaysPassed() + 1);
                            if (tiles[i][j].getCrop().getStages().get(tiles[i][j].getCrop().getCurrentStage()) == tiles[i][j].getCrop().getDaysPassed()) {
                                if (tiles[i][j].getCrop().getStages().size() < tiles[i][j].getCrop().getCurrentStage()) {
                                    tiles[i][j].setReadyToHarvest(true);
                                } else
                                    tiles[i][j].getCrop().setCurrentStage(tiles[i][j].getCrop().getCurrentStage() + 1);
                            }
                        }
                    }
                }
                for (Animal animal : player.getAnimals()) {
                    if (animal.isFedToday()) {

                    }
                }

            }
            App.getCurrentGame().getCurrentTime().setHour(9);
            App.getCurrentGame().setCurrentWeather(App.getCurrentGame().getTomorrowWeather());
            DateAndWeatherController.setTWeather();
            if (App.getCurrentGame().getCurrentTime().getDay() == 28) {
                App.getCurrentGame().getCurrentTime().setDay(1);
                DateAndWeatherController.ChangeSeason();
            } else
                App.getCurrentGame().getCurrentTime().setDay(App.getCurrentGame().getCurrentTime().getDay() + 1);
        } else
            App.getCurrentGame().getCurrentTime().setHour(currentTime + 1);
    }
}
