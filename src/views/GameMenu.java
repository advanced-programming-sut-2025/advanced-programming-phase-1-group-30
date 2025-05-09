package views;

import controllers.DateAndWeatherController;
import controllers.GameMenuController;
import controllers.NewGameController;
import models.Commands.GameMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class GameMenu implements AppMenu {
    public static void printResult(String result) {
        System.out.println(result);
    }
  
    @Override
    public void check(String command, Scanner scanner) {
        Matcher matcher;

        matcher = GameMenuCommands.GAME_NEW.regexMatcher(command);
        if (matcher.matches()) {
            String username1 = matcher.group("username1");
            String username2 = matcher.group("username2");
            String username3 = matcher.group("username3");

            NewGameController.NewGame(username1, username2, username3, scanner);
            return;
        }
        matcher = GameMenuCommands.LOAD_GAME.regexMatcher(command);
        if (matcher.matches()) {
            NewGameController.LoadGame();
            return;
        }
        matcher = GameMenuCommands.EXIT_GAME.regexMatcher(command);
        if (matcher.matches()) {
            NewGameController.ExitGame();
            return;
        }
        matcher = GameMenuCommands.NEXT_TURN.regexMatcher(command);
        if (matcher.matches()) {
            NewGameController.NextTurn();
            return;
        }
        matcher = GameMenuCommands.TIME.regexMatcher(command);
        if (matcher.matches()) {
            DateAndWeatherController.Time();
            return;
        }
        matcher = GameMenuCommands.DATE.regexMatcher(command);
        if (matcher.matches()) {
            DateAndWeatherController.Date();
            return;
        }
        matcher = GameMenuCommands.DATETIME.regexMatcher(command);
        if (matcher.matches()) {
            DateAndWeatherController.DateTime();
            return;
        }
        matcher = GameMenuCommands.DAY_OF_THE_WEEK.regexMatcher(command);
        if (matcher.matches()) {
            DateAndWeatherController.DayOfTheWeek();
            return;
        }
        matcher = GameMenuCommands.SEASON.regexMatcher(command);
        if (matcher.matches()) {
            DateAndWeatherController.Season();
            return;
        }
        matcher = GameMenuCommands.WEATHER.regexMatcher(command);
        if (matcher.matches()) {
            DateAndWeatherController.Weather();
            return;
        }
        matcher = GameMenuCommands.WEATHER_FORECAST.regexMatcher(command);
        if (matcher.matches()) {
            DateAndWeatherController.WeatherForecast();
            return;
        }
        matcher = GameMenuCommands.PRINT_MAP.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.printMap(matcher.group("x"), matcher.group("y"), matcher.group("size"));
            return;
        }
        matcher = GameMenuCommands.HELPREADINGMAP.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.helpReadingMap();
            return;
        }
        matcher = GameMenuCommands.WALK.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.walk(matcher.group("x"), matcher.group("y"));
            return;
        }
        matcher = GameMenuCommands.INVENTORY_SHOW.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.inventoryShow();
            return;
        }
        matcher = GameMenuCommands.INVENTORY_TRASH.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.inventoryTrash(matcher.group("itemName"), matcher.group("number"));
            return;
        }
        matcher = GameMenuCommands.EQUIP_TOOL.regexMatcher(command);
        if(matcher.matches()){
            String name = matcher.group("name");
            GameMenuController.ToolsEquip(name);
            return;
        }
        matcher = GameMenuCommands.CURRENT_TOOL.regexMatcher(command);
        if(matcher.matches()){
            GameMenuController.ShowCurrentTool();
            return;
        }
        matcher = GameMenuCommands.AVAILABLE_TOOLS.regexMatcher(command);
        if(matcher.matches()){
            GameMenuController.ShowAvailableTools();
            return;
        }
        matcher = GameMenuCommands.PLANT.regexMatcher(command);
        if(matcher.matches()){
            String seed = matcher.group("seed");
            String direction = matcher.group("direction");
            GameMenuController.plant(seed, direction);
            return;
        }
        matcher = GameMenuCommands.SHOW_PLANT.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.showPlant(matcher.group("x"), matcher.group("y"));
            return;
        }
        matcher = GameMenuCommands.ENERGY_SHOW.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.energyShow();
            return;
        }
        matcher = GameMenuCommands.ENERGY_SET.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.cheatEnergySet(matcher.group("value"));
            return;
        }
        matcher = GameMenuCommands.ENERGY_UNLIMITED.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.cheatUnlimitedEnergySet();
            return;
        }
        matcher = GameMenuCommands.CRAFT_INFO.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.craftInfo(matcher.group("craftName"));
            return;
        }
        System.out.println("Invalid command.");
    }
}
