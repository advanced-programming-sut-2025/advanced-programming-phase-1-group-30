package models;

import java.util.ArrayList;

import models.enums.Weather;

public class Game {
    private GreatMap map;
    private Player currentPlayer;
    private Time currentTime;
    private Weather currentWeather;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Trade> trades = new ArrayList<>();
    
    public Game(ArrayList<Player> players) {
        this.map = null;
        this.currentPlayer = App.getCurrentUser().getPlayer();
        this.currentTime = new Time();
        this.currentWeather = Weather.SUNNY;
        this.players = players;
        this.trades = null;
    }
    
    public GreatMap getMap() {
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
}
