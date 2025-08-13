package AP.group30.StardewValley.models.SaveData;

import AP.group30.StardewValley.models.Maps.Map;
import AP.group30.StardewValley.models.Maps.Weather;
import AP.group30.StardewValley.models.TimeAndDate.Time;

import java.util.ArrayList;

public class SaveGame {
    private int id;
    private SavePlayer currentPlayer;
    private Time currentTime;
    private Weather currentWeather;
    private Weather tomorrowWeather;
    private ArrayList<SavePlayer> players;
    private Map currentMap;

    public SaveGame(int id, Time currentTime, SavePlayer currentPlayer, Weather currentWeather, Weather tomorrowWeather,
                    ArrayList<SavePlayer> players, Map currentMap) {
        this.id = id;
        this.currentTime = currentTime;
        this.currentPlayer = currentPlayer;
        this.currentWeather = currentWeather;
        this.tomorrowWeather = tomorrowWeather;
        this.players = players;
        this.currentMap = currentMap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SavePlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(SavePlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Time getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Time currentTime) {
        this.currentTime = currentTime;
    }

    public Map getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(Map currentMap) {
        this.currentMap = currentMap;
    }

    public Weather getTomorrowWeather() {
        return tomorrowWeather;
    }

    public void setTomorrowWeather(Weather tomorrowWeather) {
        this.tomorrowWeather = tomorrowWeather;
    }

    public ArrayList<SavePlayer> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<SavePlayer> players) {
        this.players = players;
    }

    public Weather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(Weather currentWeather) {
        this.currentWeather = currentWeather;
    }
}
