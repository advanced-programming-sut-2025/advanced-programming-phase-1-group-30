package models;

import java.util.ArrayList;

import models.Buildings.Blacksmith;
import models.Buildings.Carpenter;
import models.Buildings.FishShop;
import models.Buildings.GeneralStore;
import models.Buildings.JojaMart;
import models.Buildings.Ranch;
import models.Buildings.Saloon;
import models.Maps.GreatMap;
import models.Maps.Map;
import models.Maps.Weather;
import models.Players.NPC.*;
import models.Players.NPC.Sebastian;
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
    private ArrayList<NPC> NPCs = new ArrayList<>();
    private Map currentMap;

    private final Blacksmith blacksmith;
    private final Carpenter carpenter;
    private final FishShop fishShop;
    private final GeneralStore generalStore;
    private final JojaMart jojaMart;
    private final Ranch ranch;
    private final Saloon saloon;

    public Blacksmith getBlacksmith() {
        return blacksmith;
    }

    public Carpenter getCarpenter() {
        return carpenter;
    }

    public FishShop getFishShop() {
        return fishShop;
    }

    public GeneralStore getGeneralStore() {
        return generalStore;
    }

    public JojaMart getJojaMart() {
        return jojaMart;
    }

    public Ranch getRanch() {
        return ranch;
    }

    public Saloon getSaloon() {
        return saloon;
    }

    public Game() {
        this.map = null;
        this.currentTime = new Time();
        this.currentWeather = Weather.SUNNY;
        this.trades = null;
        this.NPCs.add(new Sebastian());
        this.NPCs.add(new Abigail());
        this.NPCs.add(new Harvey());
        this.NPCs.add(new Leah());
        this.NPCs.add(new Robin());
        this.blacksmith = new Blacksmith(0, 0, 0, 0);
        this.carpenter = new Carpenter(0, 0, 0, 0);
        this.fishShop = new FishShop(0, 0, 0, 0);
        this.generalStore = new GeneralStore(0, 0, 0, 0);
        this.jojaMart = new JojaMart(0, 0, 0, 0);
        this.ranch = new Ranch(0, 0, 0, 0);
        this.saloon = new Saloon(0, 0, 0, 0);
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

    public ArrayList<NPC> getNPCs() {
        return NPCs;
    }

    public Map getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(Map currentMap) {
        this.currentMap = currentMap;
    }

}
