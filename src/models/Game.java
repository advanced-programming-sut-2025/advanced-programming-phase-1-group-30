package models;

import java.util.ArrayList;

import models.enums.Weather;

public class Game {
    private Map map;
    private Player currentPlayer;
    private Time currentTime;
    private Weather currentWeather;
    private Weather tomorrowWeather;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Trade> trades = new ArrayList<>();
    
    public Game(Map map, Player currentPlayer, Time currentTime, ArrayList<Player> players,
            ArrayList<Trade> trades) {
        this.map = map;
        this.currentPlayer = currentPlayer;
        this.currentTime = currentTime;
        this.currentWeather = Weather.SUNNY;
        this.players = players;
        this.trades = trades;
    }


    
    public Map getMap() {
        return map;
    }
    public void setMap(Map map) {
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
