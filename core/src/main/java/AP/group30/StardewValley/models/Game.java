package AP.group30.StardewValley.models;

import java.util.ArrayList;

import AP.group30.StardewValley.models.Buildings.Blacksmith;
import AP.group30.StardewValley.models.Buildings.Carpenter;
import AP.group30.StardewValley.models.Buildings.FishShop;
import AP.group30.StardewValley.models.Buildings.GeneralStore;
import AP.group30.StardewValley.models.Buildings.JojaMart;
import AP.group30.StardewValley.models.Buildings.Ranch;
import AP.group30.StardewValley.models.Buildings.Saloon;
import AP.group30.StardewValley.models.Maps.GreatMap;
import AP.group30.StardewValley.models.Maps.Map;
import AP.group30.StardewValley.models.Maps.Weather;
import AP.group30.StardewValley.models.Players.NPC.*;
import AP.group30.StardewValley.models.Players.NPC.Sebastian;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.models.Players.Trade;
import AP.group30.StardewValley.models.TimeAndDate.Time;
import com.badlogic.gdx.assets.AssetManager;


public class Game {
    private int id;
    private GreatMap map = new GreatMap();
    private Player currentPlayer;
    private Time currentTime;
    private Weather currentWeather;
    private Weather tomorrowWeather;
    private ArrayList<Player> players;
    private ArrayList<Trade> trades = new ArrayList<>();
    private ArrayList<Trade> allTrades = new ArrayList<>();
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
        this.id = App.getGames().size() + 1;
        this.currentTime = new Time();
        this.currentWeather = Weather.SUNNY;
//        this.NPCs.add(new Sebastian());
//        this.NPCs.add(new Abigail());
//        this.NPCs.add(new Harvey());
//        this.NPCs.add(new Leah());
//        this.NPCs.add(new Robin());
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

    public int getId() {
        return id;
    }

    public ArrayList<Trade> getAllTrades() {
        return allTrades;
    }
}
