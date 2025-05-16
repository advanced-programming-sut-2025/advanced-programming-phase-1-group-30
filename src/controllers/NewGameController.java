package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;

import models.Animals.Animal;
import models.App;
import models.Commands.Menus;
import models.Game;
import models.Commands.GameMenuCommands;
import models.Items.Gift;
import models.Items.Item;
import models.Items.Products.GiantCrop;
import models.Maps.Map;
import models.Maps.Tile;
import models.Maps.TileTypes;
import models.Maps.Weather;
import models.Players.Friendship;
import models.Players.NPC.NPC;
import models.Players.Player;
import models.Users.User;
import views.GameMenu;

public class NewGameController {
    public static void NewGame(String username1, String username2, String username3, Scanner scanner) {
        User user1 = null;
        User user2 = null;
        User user3 = null;
        Game game = new Game();
        App.setCurrentGame(game);
        App.getGames().add(game);
        ArrayList<Player> players = new ArrayList<>();
        Player playerX = new Player(App.getCurrentUser(),App.getCurrentUser().getUsername(), 0);
        User use = User.findUserByUsername(playerX.getUsername());
        use.setPlayer(playerX);
        players.add(playerX);
        use.setNumOfGames(App.getCurrentUser().getNumOfGames() + 1);
        if (username1 == null &&
            username2 == null &&
            username3 == null) {
            GameMenu.printResult("You should at least enter one user");
            return;
        }

        if (username1 != null) {
            user1 = User.findUserByUsername(username1);
            if (user1 == null) {
                GameMenu.printResult("Invalid User1");
                return;
            }
            if (user1.isInGame()) {
                GameMenu.printResult("User1 already in Game");
                return;
            }
            
            Player player1 = new Player(user1,user1.getUsername(), 1);
            user1.setPlayer(player1);
            user1.setNumOfGames(user1.getNumOfGames() + 1);
            players.add(player1);
        }

        if (username2 != null) {
            user2 = User.findUserByUsername(username2);
            if (user2 == null) {
                GameMenu.printResult("Invalid User2");
                return;
            }
            if (user2.isInGame()) {
                GameMenu.printResult("User2 already in Game");
                return;
            }

            Player player2 = new Player(user2,user2.getUsername(), 2);
            user2.setPlayer(player2);
            user2.setNumOfGames(user2.getNumOfGames() + 1);
            players.add(player2);
        }

        if (username3 != null) {
            user3 = User.findUserByUsername(username3);
            if (user3 == null) {
                GameMenu.printResult("Invalid User3");
                return;
            }
            if (user3.isInGame()) {
                GameMenu.printResult("User3 already in Game");
                return;
            }

            Player player3 = new Player(user3,user3.getUsername(), 3);
            user3.setPlayer(player3);
            user3.setNumOfGames(user3.getNumOfGames() + 1);
            players.add(player3);
        }
        if(user1 != null) {
            user1.changeInGame();
        }
        if(user2 != null) {
            user2.changeInGame();
        }
        if(user3 != null) {
            user3.changeInGame();
        }
        App.getMaps().add(new Map(1));
        App.getMaps().add(new Map(2));
        App.getMaps().add(new Map(3));
        App.getMaps().add(new Map(4));
        App.getMaps().add(new Map(-1));
        GameMenu.printResult("Please select your maps...");
        App.getCurrentGame().getGreatMap().setCityMap(App.getMaps().get(4));
        for (Player player : players) {
            boolean mapIsSelected = false;
            while (!mapIsSelected) {
                GameMenu.printResult("Choosing map and gender for " + player.getUsername());
                String command = scanner.nextLine();
                Matcher matcher = GameMenuCommands.GAME_MAP.regexMatcher(command);
                if (matcher.matches()) {
                    int mapNumber = Integer.parseInt(matcher.group("mapNumber"));
                    String gender = matcher.group("gender");
                    player.setGender(gender);
                    Map map = Map.getMapById(mapNumber);
                    if (map == null) GameMenu.printResult("Please choose between available maps");
                    player.setMap(map);
                    App.getCurrentGame().getGreatMap().getMaps().add(map);
                    mapIsSelected = true;
                    player.setX(1);
                    player.setY(1);
                    player.setCityY(-1);
                    player.setCityX(-1);
                }
                else {
                    GameMenu.printResult("Invalid command");
                }
            }
        }
        for (Player player : players) {
            for (Player p : players) {
                if (!player.equals(p)) {
                    player.getFriendships().put(p, new Friendship());
                }
            }
        }
        game.setPlayers(players);
        game.setTomorrowWeather(Weather.SUNNY);
        game.setCurrentPlayer(playerX);
        GameMenu.printResult("Starting new game...");
        MaintainerController.updateAllShops();
        MaintainerController.emptyShippingBin();
        MaintainerController.crowAttack();
    }

    public static void LoadGame(String idString) {
        int id = Integer.parseInt(idString);
        for(Game game : App.getGames()) {
            if(game.getId() == id) {
                App.getGames().add(game);
                for(Player player : game.getPlayers()) {
                    player.getUser().changeInGame();
                }
                App.setCurrentMenu(Menus.GameMenu);
                App.setCurrentGame(game);
                GameMenu.printResult("Loading game with id " + id + "...");
                GameMenu.printResult("It's " + game.getCurrentPlayer().getUsername() + "'s turn");
                return;
            }
        }
        GameMenu.printResult("Game with id " + id + " doesn't exist");
    }
    
    public static void NextTurn(Scanner scanner) {
        List<Player> players = App.getCurrentGame().getPlayers();
        Player currentPlayer = App.getCurrentGame().getCurrentPlayer();
        int totalPlayers = players.size();

        int nextSelection = (currentPlayer.getSelectionNumber() + 1) % totalPlayers;
        int startSelection = nextSelection;

        Player nextPlayer = null;

        do {
            Player candidate = players.get(nextSelection);
            if (!candidate.isPassedOut()) {
                nextPlayer = candidate;
                break;
            }
            nextSelection = (nextSelection + 1) % totalPlayers;
        } while (nextSelection != startSelection);

        if (nextPlayer == null) {
            GameMenu.printResult("All players are passed out. Ending round...");
            return; // Or trigger end-of-day logic
        }

        App.getCurrentGame().setCurrentPlayer(nextPlayer);

        currentPlayer = App.getCurrentGame().getCurrentPlayer();
        GameMenu.printResult("Current player: " + App.getCurrentGame().getCurrentPlayer().getUsername());
        if (currentPlayer.getAskedMarriage() != null) {
            GameMenu.printResult(currentPlayer.getAskedMarriage().getUsername() + " asked you to be soulmates for the rest of your lives!");
            String command = scanner.nextLine();
            Matcher matcher = GameMenuCommands.RESPOND.regexMatcher(command);
            if (matcher.matches()) {
                String answer = matcher.group("answer");
                if (answer.equals("-accept")) {
                    Item weddingRing = Item.findItemByName("wedding ring", currentPlayer.getAskedMarriage().getBackPack().getItems());
                    if (weddingRing.getCount() == 1) {
                        currentPlayer.getAskedMarriage().getBackPack().getItems().remove(weddingRing);
                    } else {
                        weddingRing.setCount(weddingRing.getCount() - 1);
                        currentPlayer.getBackPack().addItem(new Item(1, "wedding ring", weddingRing.getPrice()));
                    }
                    currentPlayer.getFriendships().get(currentPlayer.getAskedMarriage()).addXp(0, false, true);
                    currentPlayer.getAskedMarriage().getFriendships().get(currentPlayer).addXp(0, false, true);
                    GameMenu.printResult("Jingo jinge saz miad o az baloy Shiraz miad!");
                } else if (answer.equals("-reject")) {
                    currentPlayer.getAskedMarriage().getFriendships().get(currentPlayer).setLevel(0);
                    currentPlayer.getAskedMarriage().getFriendships().get(currentPlayer).setXp(0);
                    currentPlayer.getFriendships().get(currentPlayer.getAskedMarriage()).setLevel(0);
                    currentPlayer.getFriendships().get(currentPlayer.getAskedMarriage()).setXp(0);
                    currentPlayer.setAskedMarriage(null);
                    GameMenu.printResult("Rejected. That was sad :(");
                }
            }
        }
        for (Gift gift : currentPlayer.getGifts()) {
            if (gift.isRated()) {
                continue;
            }
            GameMenu.printResult("You have a gift that you should rate:");
            GameMenu.printResult("Rate this gift from 1 to 5: " + gift.getCount() + " " + gift.getName() + " from " + gift.getSentPlayer().getUsername());
            while (true) {
                String command = scanner.nextLine();
                Matcher matcher = GameMenuCommands.GIFT_RATE.regexMatcher(command);
                if (matcher.matches()) {
                    int rate = Integer.parseInt(matcher.group("rate"));
                    int xp = (rate - 3) * 30 + 15;
                    currentPlayer.getFriendships().get(gift.getSentPlayer()).addXp(xp, false, false);
                    if (rate < 3) {
                        GameMenu.printResult("What an Awful gift!");
                    } else
                        GameMenu.printResult("Thank you " + gift.getSentPlayer().getUsername() + "!!");
                    break;
                } else {
                    GameMenu.printResult("Rate it with the given format");
                }
            }
            gift.setRated(true);
        }

//        for (Player player : players) {
//            if (!player.isPassedOut()) {
//                App.getCurrentGame().setCurrentPlayer(player);
//                break;
//            }
//        }


        //next day
        int currentTime = App.getCurrentGame().getCurrentTime().getHour();
        if (currentTime == 21) {
            MaintainerController.updateAllShops();
            MaintainerController.emptyShippingBin();
            MaintainerController.crowAttack();

            for (Player player : App.getCurrentGame().getPlayers()) {
                if (player.isInCity()) {
                    player.setInCity(false);
                    player.setCityX(-1);
                    player.setCityY(-1);
                }
                player.setX(70);
                player.setY(8);

                player.setEnergy(player.getMaxEnergy());
                if (player.isPassedOut()) {
                    player.setEnergy((player.getMaxEnergy() * 3) / 4);
                    player.setPassedOut(false);
                }
                Tile[][] tiles = player.getMap().getTiles();
                if (App.getCurrentGame().getCurrentWeather().equals(Weather.STORM)) {
                    Random rand = new Random();

                    for (int i = 0; i < 3; i++) {
                        int x = rand.nextInt(60);
                        int y = rand.nextInt(60);

                        Tile tile = tiles[x][y];

                        if (tile.isPlanted() && !tile.getType().equals(TileTypes.GREENHOUSE)) {
                            tile.setPlanted(false);
                            tile.setItem(new Item(1, "coal", 15));
                            tile.setCrop(null);
                            tile.setType(TileTypes.DIRT);
                        }
                    }
                }
                int v = -1;
                int u = -1;
                for (int i = 0; i < tiles.length; i++) {
                    for (int j = 0; j < tiles[i].length; j++) {
                        if (tiles[i][j].isPlanted()) {
                            if (!(tiles[i][j].getCrop() instanceof GiantCrop)) {

                                if (!tiles[i][j].isReadyToHarvest()) {
                                    tiles[i][j].getCrop().setDaysPassed(tiles[i][j].getCrop().getDaysPassed() + 1);
                                    if (tiles[i][j].getCrop().isWateredToday()) {
                                        tiles[i][j].getCrop().setDaysNotWatered(0);
                                    }
                                    if (!tiles[i][j].getCrop().isWateredToday()) {
                                        tiles[i][j].getCrop().setDaysNotWatered(tiles[i][j].getCrop().getDaysNotWatered() + 1);
                                        if (tiles[i][j].getCrop().getDaysNotWatered() >= 2) {
                                            tiles[i][j].setCrop(null);
                                            tiles[i][j].setPlanted(false);
                                            tiles[i][j].setReadyToHarvest(false);
                                            tiles[i][j].setItem(null);
                                            tiles[i][j].setType(TileTypes.DIRT);
                                            continue;
                                        }
                                    }
                                    if (tiles[i][j].getCrop().isWateredToday()) {
                                        tiles[i][j].getCrop().setWateredToday(false);
                                    }
                                    if (tiles[i][j].getCrop().getCurrentStage() < tiles[i][j].getCrop().getStages().size()) {
                                        if (tiles[i][j].getCrop().getStages().get(tiles[i][j].getCrop().getCurrentStage()) == tiles[i][j].getCrop().getDaysPassed()) {
                                            if (tiles[i][j].getCrop().getCurrentStage() == tiles[i][j].getCrop().getStages().size()) {
                                                tiles[i][j].setReadyToHarvest(true);
                                            } else {
                                                tiles[i][j].getCrop().setDaysPassed(0);
                                            }
                                        }
                                    }
                                    if (tiles[i][j].getCrop().getCurrentStage() == tiles[i][j].getCrop().getStages().size()) {
                                        tiles[i][j].getCrop().setDaysPassed(tiles[i][j].getCrop().getDaysPassed() - 1);
                                        tiles[i][j].setReadyToHarvest(true);
                                    }
                                    if ((App.getCurrentGame().getCurrentWeather().equals(Weather.RAIN) || App.getCurrentGame().getCurrentWeather().equals(Weather.STORM)) && !tiles[i][j].getType().equals(TileTypes.GREENHOUSE)) {
                                        tiles[i][j].getCrop().setWateredToday(true);
                                    }
                                }
                            } else {
                                if (!tiles[i][j].isGiantCropCheck()) {
                                    Tile[] tiles1 = ((GiantCrop) tiles[i][j].getCrop()).getTiles();
                                    for (Tile tile : tiles1) {
                                        tile.setGiantCropCheck(true);
                                    }
                                    v = i;
                                    u = j;
                                    if (!tiles[i][j].isReadyToHarvest()) {
                                        tiles[i][j].getCrop().setDaysPassed(tiles[i][j].getCrop().getDaysPassed() + 1);
                                        if (tiles[i][j].getCrop().getCurrentStage() <= tiles[i][j].getCrop().getStages().size()) {
                                            if (tiles[i][j].getCrop().getStages().get(tiles[i][j].getCrop().getCurrentStage()) == tiles[i][j].getCrop().getDaysPassed()) {
                                                if (tiles[i][j].getCrop().getCurrentStage() == tiles[i][j].getCrop().getStages().size()) {
                                                    tiles[i][j].setReadyToHarvest(true);
                                                    for (Tile tile : tiles1) {
                                                        tile.setReadyToHarvest(true);
                                                    }
                                                } else {
                                                    tiles[i][j].getCrop().setCurrentStage(tiles[i][j].getCrop().getCurrentStage() + 1);
                                                    tiles[i][j].getCrop().setDaysPassed(0);
                                                }
                                            }
                                        }
                                        if (tiles[i][j].getCrop().getCurrentStage() == tiles[i][j].getCrop().getStages().size()) {
                                            tiles[i][j].setReadyToHarvest(true);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                for (Animal animal : player.getAnimals()) {
                    if (animal.isFedToday()) {
                        animal.produceProduct();
                        animal.setFedToday(false);
                    } else {
                        animal.setFriendship(Math.max(animal.getFriendship() - 20 , 0));
                    }
                    if (animal.isPetToday()) {
                        animal.setPetToday(false);
                    } else {
                        animal.setFriendship(Math.max(animal.getFriendship() / 200 - 10 , 0));
                    }
                    if (animal.isOut()) {
                        animal.setFriendship(Math.max(animal.getFriendship() - 20, 0));
                    }
                }
                for (java.util.Map.Entry<Player, Friendship> entry : player.getFriendships().entrySet()) {
                    if (entry.getValue().isTalkedToday()) {
                        entry.getValue().setTalkedToday(false);
                        entry.getValue().setSentGiftToday(false);
                    }
                }
            }
            for(Player players1 : App.getCurrentGame().getPlayers()){
                for(NPC npc : App.getCurrentGame().getNPCs()){
                    players1.getNPCMeetToday().put(npc,false);
                }
            }
            for(NPC npc : App.getCurrentGame().getNPCs()) {
                if(npc.getTillQuest3() == 0){
                    for(Player players1 : App.getCurrentGame().getPlayers()){
                        players1.getActivatedQuestNPC().get(npc).add(3);
                    }
                    npc.setTillQuest3(-1);
                } else if(npc.getTillQuest3() > 0){
                    npc.setTillQuest3(npc.getTillQuest3() - 1);
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
            if (App.getCurrentGame().getCurrentWeather().equals(Weather.STORM)) {
                GameMenu.printResult("Thor is angry at you!");
            }
        }
        else
            App.getCurrentGame().getCurrentTime().setHour(currentTime + 1);
    }
}
