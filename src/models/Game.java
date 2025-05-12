package models;

import java.util.ArrayList;

import models.Maps.GreatMap;
import models.Maps.Weather;
import models.Players.Player;
import models.Players.Trade;
import models.TimeAndDate.Time;

public class Game {
    private GreatMap map;
    private Player currentPlayer;
    private Time currentTime;
    private Weather currentWeather;
    private Weather tomorrowWeather;
    private ArrayList<Player> players;
    private ArrayList<Trade> trades = new ArrayList<>();

    public Game(ArrayList<Player> players) {
        this.map = null;
        this.currentPlayer = App.getCurrentUser().getPlayer();
        this.currentTime = new Time();
        this.currentWeather = Weather.SUNNY;
        this.players = players;
    }
    
    public GreatMap getGreatMap() {
        return map;
    }
    public void setMap(GreatMap map) {
        this.map = map;
    }
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    public Time getCurrentTime() {
        return currentTime;
    }
    public void setCurrentTime(Time currentTime) {
        this.currentTime = currentTime;
    }
    public Weather getCurrentWeather() {
        return currentWeather;
    }
    public void setCurrentWeather(Weather currentWeather) {
        this.currentWeather = currentWeather;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    public ArrayList<Trade> getTrades() {
        return trades;
    }
    public void setTrades(ArrayList<Trade> trades) {
        this.trades = trades;
    }
    public Weather getTomorrowWeather() {
        return tomorrowWeather;
    }
    public void setTomorrowWeather(Weather tomorrowWeather) {
        this.tomorrowWeather = tomorrowWeather;
    }
}
