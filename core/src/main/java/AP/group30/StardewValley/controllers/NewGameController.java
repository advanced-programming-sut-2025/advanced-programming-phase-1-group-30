package AP.group30.StardewValley.controllers;

import java.util.*;
import java.util.regex.Matcher;

import AP.group30.StardewValley.models.Animals.Animal;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Game;
import AP.group30.StardewValley.models.Commands.GameMenuCommands;
import AP.group30.StardewValley.models.Items.Gift;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProductType;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.Products.GiantCrop;
import AP.group30.StardewValley.models.Maps.Map;
import AP.group30.StardewValley.models.Maps.Tile;
import AP.group30.StardewValley.models.Maps.TileTypes;
import AP.group30.StardewValley.models.Maps.Weather;
import AP.group30.StardewValley.models.Players.Friendship;
import AP.group30.StardewValley.models.Players.NPC.NPC;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.models.Users.User;
import AP.group30.StardewValley.views.GameMenu;
import AP.group30.StardewValley.views.PreGameMenu;

public class NewGameController {
    public static boolean NewGame(int numberOfPlayers, String username1, String username2, String username3,
                                  int mapNumber1, int mapNumber2, int mapNumber3, int mapNumber4) {
        User user1 = null;
        User user2 = null;
        User user3 = null;

        App.getMaps().add(new Map(1));
        App.getMaps().add(new Map(2));
        App.getMaps().add(new Map(3));
        App.getMaps().add(new Map(4));
        App.getMaps().add(new Map(-1));

        Game game = new Game();
        App.setCurrentGame(game);
        App.getGames().add(game);

        ArrayList<Player> players = new ArrayList<>();
        Player currentPlayer = new Player(App.getCurrentUser(), App.getCurrentUser().getUsername(), 0,
            App.getCurrentUser().getGender(), Map.getMapById(mapNumber1));
        App.getCurrentUser().setPlayer(currentPlayer);
        App.getCurrentUser().setNumOfGames(App.getCurrentUser().getNumOfGames() + 1);

        players.add(currentPlayer);

        if (numberOfPlayers >= 2) {
            if (username1.equals("username 1")) {
                PreGameMenu.printResult("Please enter username 1");
                return false;
            }

            user1 = User.findUserByUsername(username1);
            if (user1 == null) {
                PreGameMenu.printResult("Invalid User1");
                return false;
            }
            if (user1.isInGame()) {
                PreGameMenu.printResult("User1 already in Game");
                return false;
            }

            Player player1 = new Player(user1,user1.getUsername(), 1, user1.getGender(),
                Map.getMapById(mapNumber2));
            user1.setPlayer(player1);
            user1.setNumOfGames(user1.getNumOfGames() + 1);
            players.add(player1);
        }

        if (numberOfPlayers >= 3) {
            if (username2.equals("username 2")) {
                PreGameMenu.printResult("Please enter username 2");
                return false;
            }

            user2 = User.findUserByUsername(username2);
            if (user2 == null) {
                PreGameMenu.printResult("Invalid User2");
                return false;
            }
            if (user2.isInGame()) {
                PreGameMenu.printResult("User2 already in Game");
                return false;
            }

            Player player2 = new Player(user2,user2.getUsername(), 2, user2.getGender(),
                Map.getMapById(mapNumber3));
            user2.setPlayer(player2);
            user2.setNumOfGames(user2.getNumOfGames() + 1);
            players.add(player2);
        }

        if (numberOfPlayers >= 4) {
            if (username3.equals("username 3")) {
                PreGameMenu.printResult("Please enter username 3");
                return false;
            }

            user3 = User.findUserByUsername(username3);
            if (user3 == null) {
                PreGameMenu.printResult("Invalid User3");
                return false;
            }
            if (user3.isInGame()) {
                PreGameMenu.printResult("User3 already in Game");
                return false;
            }

            Player player3 = new Player(user3,user3.getUsername(), 3, user3.getGender(),
                Map.getMapById(mapNumber4));
            user3.setPlayer(player3);
            user3.setNumOfGames(user3.getNumOfGames() + 1);
            players.add(player3);
        }

        App.getCurrentUser().changeInGame();
        if(user1 != null) {
            user1.changeInGame();
        }
        if(user2 != null) {
            user2.changeInGame();
        }
        if(user3 != null) {
            user3.changeInGame();
        }

        App.getCurrentGame().getGreatMap().setCityMap(App.getMaps().get(4));

        for (Player player : players) {
            App.getCurrentGame().getGreatMap().getMaps().add(player.getMap());
            player.setX(70);
            player.setY(16);
            player.setCityY(-1);
            player.setCityX(-1);
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
        game.setCurrentPlayer(currentPlayer);
        MaintainerController.updateAllShops();
        return true;
    }

    public static void LoadGame(String idString) {
        int id = Integer.parseInt(idString);
        for(Game game : App.getGames()) {
            if(game.getId() == id) {
                App.getGames().add(game);
                for(Player player : game.getPlayers()) {
                    player.getUser().changeInGame();
                }
                App.setCurrentGame(game);
                GameMenu.printResult("Loading game with id " + id + "...");
                GameMenu.printResult("It's " + game.getCurrentPlayer().getUsername() + "'s turn");
                return;
            }
        }
        GameMenu.printResult("Game with id " + id + " doesn't exist");
    }

    public static void NextTurn(Scanner scanner) {
        MaintainerController.artisanProssesTimeChanger(1);

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
        App.getCurrentGame().setCurrentMap(nextPlayer.getMap());

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

                    currentPlayer.setHamsar(currentPlayer.getAskedMarriage());
                    currentPlayer.getAskedMarriage().setHamsar(currentPlayer);
                } else if (answer.equals("-reject")) {
                    currentPlayer.getAskedMarriage().getFriendships().get(currentPlayer).setLevel(0);
                    currentPlayer.getAskedMarriage().getFriendships().get(currentPlayer).setXp(0);
                    currentPlayer.getFriendships().get(currentPlayer.getAskedMarriage()).setLevel(0);
                    currentPlayer.getFriendships().get(currentPlayer.getAskedMarriage()).setXp(0);
                    currentPlayer.getAskedMarriage().setGotRejected(true);
                    GameMenu.printResult("Rejected. That was sad :(");
                    currentPlayer.getAskedMarriage().setDaysGotRejected(7);
                    currentPlayer.setAskedMarriage(null);
                }
            }
        }
        if (currentPlayer.isNewTalk() != null) {
            GameMenu.printResult(currentPlayer.isNewTalk() + " sent you a message! use talk history -u " + currentPlayer.isNewTalk());
            currentPlayer.setNewTalk(null);
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
                    gift.setRate(rate);
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
        Player.updateBuffs(players);

        for(Player player : players) {
            if(player.getFarming() >= 150){
                if(!player.getCraftingRecipes().contains(IndustrialProductType.BEE_HOUSE)){
                    player.getCraftingRecipes().add(IndustrialProductType.BEE_HOUSE);
                } else if(!player.getCraftingRecipes().contains(IndustrialProductType.SPRINKLER)){
                    player.getCraftingRecipes().add(IndustrialProductType.SPRINKLER);
                }
            } else if(player.getFarming() >= 250){
                if(!player.getCraftingRecipes().contains(IndustrialProductType.DELUXE_SCARECROW)){
                    player.getCraftingRecipes().add(IndustrialProductType.DELUXE_SCARECROW);
                } else if(!player.getCraftingRecipes().contains(IndustrialProductType.QUALITY_SPRINKLER)){
                    player.getCraftingRecipes().add(IndustrialProductType.QUALITY_SPRINKLER);
                }if(!player.getCraftingRecipes().contains(IndustrialProductType.CHEESE_PRESS)){
                    player.getCraftingRecipes().add(IndustrialProductType.CHEESE_PRESS);
                } else if(!player.getCraftingRecipes().contains(IndustrialProductType.PRESERVES_JAR)){
                    player.getCraftingRecipes().add(IndustrialProductType.PRESERVES_JAR);
                }

            } else if(player.getFarming() >= 350){
                if(!player.getCraftingRecipes().contains(IndustrialProductType.OIL_MAKER)){
                    player.getCraftingRecipes().add(IndustrialProductType.OIL_MAKER);
                } else if(!player.getCraftingRecipes().contains(IndustrialProductType.LOOM)){
                    player.getCraftingRecipes().add(IndustrialProductType.LOOM);
                }if(!player.getCraftingRecipes().contains(IndustrialProductType.KEG)){
                    player.getCraftingRecipes().add(IndustrialProductType.KEG);
                }
            } else if(player.getForaging() >= 150){
                if(!player.getCraftingRecipes().contains(IndustrialProductType.CHARCOAL_KILN)){
                    player.getCraftingRecipes().add(IndustrialProductType.CHARCOAL_KILN);
                }
            } else if(player.getForaging() >= 450){
                if(!player.getCraftingRecipes().contains(IndustrialProductType.MYSTIC_TREE_SEED)){
                    player.getCraftingRecipes().add(IndustrialProductType.MYSTIC_TREE_SEED);
                }
            } else if(player.getMining() >= 150){
                if(!player.getCraftingRecipes().contains(IndustrialProductType.CHERRY_BOMB)){
                    player.getCraftingRecipes().add(IndustrialProductType.CHERRY_BOMB);
                }
            } else if(player.getMining() >= 250){
                if(!player.getCraftingRecipes().contains(IndustrialProductType.BOMB)){
                    player.getCraftingRecipes().add(IndustrialProductType.BOMB);
                }
            } else if(player.getMining() >= 350){
                if(!player.getCraftingRecipes().contains(IndustrialProductType.MEGA_BOMB)){
                    player.getCraftingRecipes().add(IndustrialProductType.MEGA_BOMB);
                }
            }
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

                for(NPC npc :App.getCurrentGame().getNPCs()) {
                    if(player.getFriendshipsNPC().get(npc) >= 600){
                        Random random = new Random();
                        int random1 = random.nextInt(2);

                        if(random1 == 0){
                            int random2 = random.nextInt(3);
                            String gift = "";
                            if(random2 == 0){
                                gift = npc.getFavoriteGifts().get(0);
                            } else if(random2 == 1){
                                gift = npc.getFavoriteGifts().get(1);
                            } else if(random2 == 2){
                                gift = npc.getFavoriteGifts().get(2);
                            }
                            Item gifts = new Item(1,gift,15);
                            player.getBackPack().addItem(gifts);
                        }
                    }
                }

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
