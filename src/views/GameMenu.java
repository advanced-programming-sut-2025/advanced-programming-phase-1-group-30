package views;

import controllers.DateAndWeatherController;
import controllers.LoginMenuController;
import controllers.NewGameController;
import models.enums.Commands.GameMenuCommands;
import models.enums.Commands.LoginMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class GameMenu implements AppMenu {
    public static void PrintResult(String string) {
        System.out.println(string);
    }
    @Override
    public void check(String command, Scanner scanner) {
        Matcher matcher;

        matcher = GameMenuCommands.GAME_NEW.regexMatcher(command);
        if (matcher.matches()) {
            NewGameController.NewGame(matcher.group("username1"), matcher.group("username2"), matcher.group("username3"));
            return;
        }
        matcher = GameMenuCommands.LOAD_GAME.regexMatcher(command);
        if (matcher.matches()) {
            NewGameController.LoadGame();
            return;
        }
        matcher = GameMenuCommands.GAME_MAP.regexMatcher(command);
        if (matcher.matches()) {
            NewGameController.GameMap(matcher.group("mapNumber"));
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
    }
}
