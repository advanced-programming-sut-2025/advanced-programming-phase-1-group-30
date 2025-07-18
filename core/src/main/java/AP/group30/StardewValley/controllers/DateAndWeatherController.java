package AP.group30.StardewValley.controllers;

import AP.group30.StardewValley.models.Animals.Animal;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.Products.GiantCrop;
import AP.group30.StardewValley.models.Items.Products.Tree;
import AP.group30.StardewValley.models.Maps.Tile;
import AP.group30.StardewValley.models.Maps.TileTexture;
import AP.group30.StardewValley.models.Maps.TileTypes;
import AP.group30.StardewValley.models.Maps.Weather;
import AP.group30.StardewValley.models.Players.Friendship;
import AP.group30.StardewValley.models.Players.NPC.NPC;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.models.TimeAndDate.Season;
import AP.group30.StardewValley.views.GameMenu;
import AP.group30.StardewValley.views.StartMenus.RegisterMenu;

import java.util.Random;

public class DateAndWeatherController {
    public static void Time() {
        GameMenu.printResult((App.getCurrentGame().getCurrentTime().getHour()) + ":"
                + App.getCurrentGame().getCurrentTime().getMinute());
    }

    public static void Date() {
        GameMenu.printResult(App.getCurrentGame().getCurrentTime().getSeason().getName() + " " + App.getCurrentGame().getCurrentTime().getDay() + "th");
    }

    public static void DateTime() {
        GameMenu.printResult(App.getCurrentGame().getCurrentTime().getSeason().getName() + " " + App.getCurrentGame().getCurrentTime().getDay() + "th " +
                App.getCurrentGame().getCurrentTime().getHour() + ":" + App.getCurrentGame().getCurrentTime().getMinute());
    }

    public static void DayOfTheWeek() {
        GameMenu.printResult(App.getCurrentGame().getCurrentTime().getDayOfWeek().getName());
    }

    public static void cheatAdvanceTime(String amount) {
        int x = Integer.parseInt(amount);
        if (x >= 13) {
            GameMenu.printResult("You can't cheat more than 13 hours");
            return;
        }
        MaintainerController.artisanProssesTimeChanger(x);
        if (x + App.getCurrentGame().getCurrentTime().getHour() > 22) {
            App.getCurrentGame().setCurrentWeather(App.getCurrentGame().getTomorrowWeather());
            MaintainerController.updateAllShops();
            MaintainerController.emptyShippingBin();
            MaintainerController.crowAttack();
            App.getCurrentGame().getCurrentTime().setHour((x - (22 - App.getCurrentGame().getCurrentTime().getHour())) + 9);
            for (Player player : App.getCurrentGame().getPlayers()) {
                Tile[][] tiles = player.getMap().getTiles();
                for (int i = 0; i < tiles.length; i++) {
                    for (int j = 0; j < tiles[i].length; j++) {
                        if (tiles[i][j].isPlanted()) {
                            if (tiles[i][j].getCrop() instanceof GiantCrop) {
                                for (Tile tile : ((GiantCrop)tiles[i][j].getCrop()).getTiles()) {
                                    ((GiantCrop)tile.getCrop()).setChecked(false);
                                }
                            }
                        }
                    }
                }
                player.setEnergy(player.getMaxEnergy());
                if (player.isPassedOut()) {
                    player.setEnergy((player.getMaxEnergy() * 3) / 4);
                    player.setPassedOut(false);
                }
                if (player.isGotRejected()) {
                    player.setEnergy(player.getMaxEnergy() / 2);
                    player.setDaysGotRejected(player.getDaysGotRejected() - 1);
                    if (player.getDaysGotRejected() == 0) {
                        player.setGotRejected(false);
                    }
                }


                if (App.getCurrentGame().getCurrentWeather().equals(Weather.STORM)) {
                    Random rand = new Random();

                    for (int i = 0; i < 3; i++) {
                        int x1 = rand.nextInt(60);
                        int y = rand.nextInt(60);

                        Tile tile = tiles[x1][y];

                        if (tile.isPlanted()) {
                            tile.setPlanted(false);
                            tile.setItem(new Item(1, "coal", 15, ItemTexture.WOOD.getTexture()));
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
                                    if (tiles[i][j].getCrop().isWateredToday() || tiles[i][j].getCrop().isNotNeedWaterAnymore()) {
                                        tiles[i][j].getCrop().setDaysNotWatered(0);
                                    }
                                    if (!tiles[i][j].getCrop().isWateredToday()) {
                                        tiles[i][j].getCrop().setDaysNotWatered(tiles[i][j].getCrop().getDaysNotWatered() + 1);
                                        if (tiles[i][j].getCrop().getDaysNotWatered() >= 2) {
                                            RegisterMenu.gameScreen.getEntities().remove(tiles[i][j].getCrop());
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
                                        tiles[i][j].setTexture(TileTexture.PLANTABLE.getTexture());
                                    }

                                    if (tiles[i][j].getCrop().getCurrentStage() < tiles[i][j].getCrop().getStages().size() - 1) {
                                        if (tiles[i][j].getCrop().getStages().get(tiles[i][j].getCrop().getCurrentStage()) == tiles[i][j].getCrop().getDaysPassed()) {
                                            if (tiles[i][j].getCrop().getCurrentStage() == tiles[i][j].getCrop().getStages().size()) {
                                                tiles[i][j].setReadyToHarvest(true);
                                            } else {
                                                tiles[i][j].getCrop().setCurrentStage(tiles[i][j].getCrop().getCurrentStage() + 1);
                                                tiles[i][j].getCrop().setDaysPassed(0);
                                            }
                                        }
                                    } else if (tiles[i][j].getCrop().getCurrentStage() == tiles[i][j].getCrop().getStages().size() - 1) {
                                        tiles[i][j].setReadyToHarvest(true);
                                    }
                                    if (tiles[i][j].getCrop().getCurrentStage() == tiles[i][j].getCrop().getStages().size()) {
                                        tiles[i][j].setReadyToHarvest(true);
                                    }
                                    if ((App.getCurrentGame().getCurrentWeather().equals(Weather.RAIN) || App.getCurrentGame().getCurrentWeather().equals(Weather.STORM)) && !tiles[i][j].getType().equals(TileTypes.GREENHOUSE)) {
                                        tiles[i][j].getCrop().setWateredToday(true);
                                    }
                                }
                            } else {
                                Tile[] tiles1 = ((GiantCrop) tiles[i][j].getCrop()).getTiles();
                                if (!((GiantCrop)tiles[i][j].getCrop()).isChecked()) {
                                    v = i;
                                    u = j;
                                    if (!tiles[i][j].isReadyToHarvest()) {
                                        tiles[i][j].getCrop().setDaysPassed(tiles[i][j].getCrop().getDaysPassed() + 1);
                                        if (tiles[i][j].getCrop().getCurrentStage() <= tiles[i][j].getCrop().getStages().size()) {
                                            if (tiles[i][j].getCrop().getStages().get(tiles[i][j].getCrop().getCurrentStage()) == tiles[i][j].getCrop().getDaysPassed()) {
                                                if (tiles[i][j].getCrop().getCurrentStage() == tiles[i][j].getCrop().getStages().size() - 1) {
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
                                            for (Tile tile : tiles1) {
                                                tile.setReadyToHarvest(true);
                                            }
                                        }
                                    }
                                }
                                for (Tile tile1 : tiles1) {
                                    ((GiantCrop)tile1.getCrop()).setChecked(true);
                                }
                            }
                        }
                    }
                }

                if (v != -1) {
                    Tile[] tiles1 = tiles[v][u].getGiantCrop();
                    for (Tile tile : tiles1) {
                        tile.setGiantCropCheck(false);
                    }
                }

//                MaintainerController.randomPlanting(player);
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
                        animal.setFriendship(Math.max(animal.getFriendship() - 20 , 0));
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
            DateAndWeatherController.setTWeather();
            if (App.getCurrentGame().getCurrentTime().getDay() == 28) {
                App.getCurrentGame().getCurrentTime().setDay(1);
                DateAndWeatherController.ChangeSeason();
            } else
                App.getCurrentGame().getCurrentTime().setDay(App.getCurrentGame().getCurrentTime().getDay() + 1);
            if (App.getCurrentGame().getCurrentWeather().equals(Weather.STORM)) {
                GameMenu.printResult("Thor is angry at you!");
            }
        } else
            App.getCurrentGame().getCurrentTime().setHour(App.getCurrentGame().getCurrentTime().getHour() + x);
        GameMenu.printResult("Cheat code activated: " + x + " hours passed");
    }

    static void setTWeather() {
        Random random = new Random();
        int y = random.nextInt(8);
        switch (App.getCurrentGame().getCurrentTime().getSeason()) {
            case SPRING, SUMMER, FALL -> {
                switch (y) {
                    case 0, 1, 2, 3, 4:
                        App.getCurrentGame().setTomorrowWeather(Weather.SUNNY);
                        break;
                    case 5, 6:
                        App.getCurrentGame().setTomorrowWeather(Weather.RAIN);
                        break;
                    case 7:
                        App.getCurrentGame().setTomorrowWeather(Weather.STORM);
                        break;
                }
            }
            case WINTER -> {
                switch (y) {
                    case 0, 1, 2, 3, 4:
                        App.getCurrentGame().setTomorrowWeather(Weather.SUNNY);
                        break;
                    case 5, 6, 7:
                        App.getCurrentGame().setTomorrowWeather(Weather.SNOW);
                        break;
                }
            }
        }
    }

    public static void cheatAdvanceDate(String amount) {
        int x = Integer.parseInt(amount);
        if (x >= 28) {
            GameMenu.printResult("You can't cheat more than 28 days");
            return;
        }

        MaintainerController.artisanProssesTimeChanger(x * 13);
        if (x + App.getCurrentGame().getCurrentTime().getDay() > 28) {
            App.getCurrentGame().getCurrentTime().setDay(x - (28 - App.getCurrentGame().getCurrentTime().getDay()));
            ChangeSeason();
        } else {
            App.getCurrentGame().getCurrentTime().setDay(App.getCurrentGame().getCurrentTime().getDay() + x);
        }
        GameMenu.printResult("Cheat code activated: " + x + " days passed");
        MaintainerController.updateAllShops();
        MaintainerController.emptyShippingBin();
        MaintainerController.crowAttack();
    }

    static void ChangeSeason() {
        if (App.getCurrentGame().getCurrentTime().getSeason().getNumber() == 4) {
            App.getCurrentGame().getCurrentTime().setSeason(Season.SPRING);
        }
        else if (App.getCurrentGame().getCurrentTime().getSeason().getNumber() == 3) {
            App.getCurrentGame().getCurrentTime().setSeason(Season.WINTER);
        }
        else if (App.getCurrentGame().getCurrentTime().getSeason().getNumber() == 2) {
            App.getCurrentGame().getCurrentTime().setSeason(Season.FALL);
        }
        else if (App.getCurrentGame().getCurrentTime().getSeason().getNumber() == 1) {
            App.getCurrentGame().getCurrentTime().setSeason(Season.SUMMER);
        }
    }

    public static void Season() {
        GameMenu.printResult(App.getCurrentGame().getCurrentTime().getSeason().getName());
    }

    public static void cheatThor(String x, String y) {
        int x1 = Integer.parseInt(x);
        int y1 = Integer.parseInt(y);
        Tile[][] tiles = App.getCurrentGame().getCurrentPlayer().getMap().getTiles();
        Tile tile = tiles[x1][y1];

        if (tile.isPlanted() && !tile.getType().equals(TileTypes.GREENHOUSE)) {
            tile.setPlanted(false);
            tile.setItem(new Item(1, "coal", 15, ItemTexture.WOOD.getTexture()));
            tile.setCrop(null);
            tile.setType(TileTypes.DIRT);
            GameMenu.printResult("Your crop turned into coal by the power of odin's son!");
        }
        else if (tile.getItem() instanceof Tree) {
            tile.setItem(new Item(1, "coal", 15, ItemTexture.WOOD.getTexture()));
            tile.setType(TileTypes.DIRT);
        }
        GameMenu.printResult("Cheat code activated: Thor hits you with a lightning bolt!");

    }

    public static void Weather() {
        GameMenu.printResult(App.getCurrentGame().getCurrentWeather().getName());
    }

    public static void WeatherForecast() {
        GameMenu.printResult(App.getCurrentGame().getTomorrowWeather().getName());
    }

    public static void CheatWeatherSet(String weather) {
        for(Weather weather1 :Weather.values()){
            if(weather1.name.equals(weather)){
                App.getCurrentGame().setTomorrowWeather(weather1);
                GameMenu.printResult("Tomorrow's weather: " + weather);
                return;
            }
        }
        GameMenu.printResult("Incorrect weather");
    }
}
