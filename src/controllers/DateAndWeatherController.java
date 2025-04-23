package controllers;

import models.App;
import models.enums.Weather;
import views.GameMenu;

public class DateAndWeatherController {
    public static void Time() {}
    public static void Date() {}
    public static void DateTime() {}
    public static void DayOfTheWeek() {}
    public static void CheatAdvanceTime(String amount) {}
    public static void CheatAdvanceDate(String amount) {}
    public static void Season() {}
    public static void CheatThor(String x, String y) {}
    public static void Weather() {
        GameMenu.PrintResult(App.getCurrentGame().getCurrentWeather().name());
    }
    public static void WeatherForecast() {
        GameMenu.PrintResult(App.getCurrentGame().getTomorrowWeather().name());
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
