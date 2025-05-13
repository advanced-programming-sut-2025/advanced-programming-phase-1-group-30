package controllers;

import models.Animals.Animal;
import models.App;
import models.Items.Products.GiantCrop;
import models.Maps.Tile;
import models.Maps.Weather;
import models.Players.Friendship;
import models.Players.NPC.NPC;
import models.Players.Player;
import models.TimeAndDate.Season;
import views.GameMenu;

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
        if (x + App.getCurrentGame().getCurrentTime().getHour() > 22) {
            App.getCurrentGame().getCurrentTime().setHour((x - (22 - App.getCurrentGame().getCurrentTime().getHour())) + 9);
            for (Player player : App.getCurrentGame().getPlayers()) {
                player.setEnergy(player.getMaxEnergy());
                if (player.isPassedOut()) {
                    player.setEnergy((player.getMaxEnergy() * 3) / 4);
                }
                Tile[][] tiles = player.getMap().getTiles();
                int v = -1;
                int u = -1;
                for (int i = 0; i < tiles.length; i++) {
                    for (int j = 0; j < tiles[i].length; j++) {
                        if (tiles[i][j].isPlanted()) {
                            if (!(tiles[i][j].getCrop() instanceof GiantCrop)) {

                                if (!tiles[i][j].isReadyToHarvest()) {
                                    tiles[i][j].getCrop().setDaysPassed(tiles[i][j].getCrop().getDaysPassed() + 1);
                                }
                                if (tiles[i][j].isReadyToHarvest()) {

                                } else {
                                    if (tiles[i][j].getCrop().getCurrentStage() <= 4) {
                                        if (tiles[i][j].getCrop().getStages().get(tiles[i][j].getCrop().getCurrentStage()) == tiles[i][j].getCrop().getDaysPassed()) {
                                            if (tiles[i][j].getCrop().getCurrentStage() == 4) {
                                                tiles[i][j].setReadyToHarvest(true);
                                            } else {
                                                tiles[i][j].getCrop().setCurrentStage(tiles[i][j].getCrop().getCurrentStage() + 1);
                                                tiles[i][j].getCrop().setDaysPassed(0);
                                            }
                                        }
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
                                    }
                                    if (tiles[i][j].isReadyToHarvest()) {

                                    } else {
                                        if (tiles[i][j].getCrop().getCurrentStage() <= 4) {
                                            if (tiles[i][j].getCrop().getStages().get(tiles[i][j].getCrop().getCurrentStage()) == tiles[i][j].getCrop().getDaysPassed()) {
                                                if (tiles[i][j].getCrop().getCurrentStage() == 4) {
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
                                    }
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

                for (Animal animal : player.getAnimals()) {
                    if (animal.isFedToday()) {
                        animal.produceProduct();
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
            App.getCurrentGame().setCurrentWeather(App.getCurrentGame().getTomorrowWeather());
            DateAndWeatherController.setTWeather();
            if (App.getCurrentGame().getCurrentTime().getDay() == 28) {
                App.getCurrentGame().getCurrentTime().setDay(1);
                DateAndWeatherController.ChangeSeason();
            } else
                App.getCurrentGame().getCurrentTime().setDay(App.getCurrentGame().getCurrentTime().getDay() + 1);
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

        if (x + App.getCurrentGame().getCurrentTime().getDay() > 28) {
            App.getCurrentGame().getCurrentTime().setDay(x - (28 - App.getCurrentGame().getCurrentTime().getDay()));
            ChangeSeason();
        } else {
            App.getCurrentGame().getCurrentTime().setDay(App.getCurrentGame().getCurrentTime().getDay() + x);
        }
        GameMenu.printResult("Cheat code activated: " + x + " days passed");
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

    public static void CheatThor(String x, String y) {}

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
                return;
            }
        }
    }
}
