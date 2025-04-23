package controllers;

import models.App;
import models.Game;
import models.enums.Season;
import views.GameMenu;

public class DateAndWeatherController {
    public static void Time() {
        GameMenu.PrintResult((App.getCurrentGame().getCurrentTime().getHour()) + ":"
                + App.getCurrentGame().getCurrentTime().getMinute());
    }
    public static void Date() {
        GameMenu.PrintResult(App.getCurrentGame().getCurrentTime().getSeason().getName() + " " + App.getCurrentGame().getCurrentTime().getDay() + "th");
    }
    public static void DateTime() {
        GameMenu.PrintResult(App.getCurrentGame().getCurrentTime().getSeason().getName() + " " + App.getCurrentGame().getCurrentTime().getDay() + "th " +
                App.getCurrentGame().getCurrentTime().getHour() + ":" + App.getCurrentGame().getCurrentTime().getMinute());
    }
    public static void DayOfTheWeek() {
        GameMenu.PrintResult(App.getCurrentGame().getCurrentTime().getDayOfWeek().getName());
    }
    public static void CheatAdvanceTime(String amount) {
        int x = Integer.parseInt(amount);
        if (x >= 13) {
            GameMenu.PrintResult("You can't cheat more than 13 hours");
            return;
        }
        if (x + App.getCurrentGame().getCurrentTime().getHour() > 22) {
            App.getCurrentGame().getCurrentTime().setHour((x - (22 - App.getCurrentGame().getCurrentTime().getHour())) + 9);
            if (App.getCurrentGame().getCurrentTime().getDay() == 28) {
                App.getCurrentGame().getCurrentTime().setDay(1);
                ChangeSeason();
            } else
                App.getCurrentGame().getCurrentTime().setDay(App.getCurrentGame().getCurrentTime().getDay() + 1);
        } else
            App.getCurrentGame().getCurrentTime().setHour(App.getCurrentGame().getCurrentTime().getHour() + x);
        GameMenu.PrintResult("Cheat code activated: " + x + " hours passed");
    }
    public static void CheatAdvanceDate(String amount) {
        int x = Integer.parseInt(amount);
        if (x >= 28) {
            GameMenu.PrintResult("You can't cheat more than 28 days");
            return;
        }
        if (x + App.getCurrentGame().getCurrentTime().getDay() > 28) {
            App.getCurrentGame().getCurrentTime().setDay(x - (28 - App.getCurrentGame().getCurrentTime().getDay()));
            ChangeSeason();
        }
    }

    private static void ChangeSeason() {
        if (App.getCurrentGame().getCurrentTime().getSeason().getNumber() == 4) {
            App.getCurrentGame().getCurrentTime().setSeason(Season.SPRING);
        } else if (App.getCurrentGame().getCurrentTime().getSeason().getNumber() == 3) {
            App.getCurrentGame().getCurrentTime().setSeason(Season.WINTER);
        } else if (App.getCurrentGame().getCurrentTime().getSeason().getNumber() == 2) {
            App.getCurrentGame().getCurrentTime().setSeason(Season.FALL);
        } else if (App.getCurrentGame().getCurrentTime().getSeason().getNumber() == 1) {
            App.getCurrentGame().getCurrentTime().setSeason(Season.SUMMER);
        }
    }

    public static void Season() {
        GameMenu.PrintResult(App.getCurrentGame().getCurrentTime().getSeason().getName());
    }
    public static void CheatThor(String x, String y) {}
    public static void Weather() {}
    public static void WeatherForecast() {}
    public static void CheatWeatherSet(String type) {}
    public static void GreenHouseBuild() {}
}
