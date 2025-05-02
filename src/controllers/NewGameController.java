package controllers;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;

import models.App;
import models.Game;
import models.Map;
import models.Player;
import models.User;
import models.enums.Commands.GameMenuCommands;
import models.enums.Weather;
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
        for (Player player : App.getCurrentGame().getPlayers()) {
            if (player.getSelectionNumber() == App.getCurrentGame().getCurrentPlayer().getSelectionNumber() + 1) {
                App.getCurrentGame().setCurrentPlayer(player);
            } else {
                App.getCurrentGame().setCurrentPlayer(App.getCurrentGame().getPlayers().get(0));
            }
        }
        int currentTime = App.getCurrentGame().getCurrentTime().getHour();
        if (currentTime == 21) {
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
