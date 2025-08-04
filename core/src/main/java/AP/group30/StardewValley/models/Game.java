package AP.group30.StardewValley.models;

import java.io.IOException;
import java.util.ArrayList;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.models.Buildings.*;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.Maps.GreatMap;
import AP.group30.StardewValley.models.Maps.Map;
import AP.group30.StardewValley.models.Maps.Weather;
import AP.group30.StardewValley.models.Players.NPC.*;
import AP.group30.StardewValley.models.Players.NPC.Sebastian;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.models.Players.Trade;
import AP.group30.StardewValley.models.TimeAndDate.Time;
import AP.group30.StardewValley.network.MessageClasses.PlayerJoin;
import AP.group30.StardewValley.network.NetworkClient;
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
    private ArrayList<Building> buildings = new ArrayList<>();
    private ArrayList<NPC> NPCs = new ArrayList<>();
    private Map currentMap;
    private Map cityMap = new Map(-1);

    private final Blacksmith blacksmith;
    private final Carpenter carpenter;
    private final FishShop fishShop;
    private final GeneralStore generalStore;
    private final JojaMart jojaMart;
    private final Ranch ranch;
    private final Saloon saloon;
    private Hut hut;
    private GreenHouse greenHouse;
    private java.util.Map<ItemsInteface, Integer> dailyShopCounter = new java.util.HashMap<>();

    public Blacksmith getBlacksmith() {
        return blacksmith;
    }

    public java.util.Map<ItemsInteface,Integer> getDailyShopCounter() {
        return dailyShopCounter;
    }

    public void incrementPurchase(ItemsInteface item) {
        int old = dailyShopCounter.getOrDefault(item, 0);
        dailyShopCounter.put(item, old + 1);
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




    public NetworkClient networkClient;
    private GameModel model;

    public GameModel getModel() {
        return model;
    }



    public Game() {
        this.id = App.getGames().size() + 1;
        this.currentTime = new Time();
        this.currentWeather = Weather.SUNNY;
        this.NPCs.add(new Sebastian());
        this.NPCs.add(new Abigail());
        this.NPCs.add(new Harvey());
        this.NPCs.add(new Leah());
        this.NPCs.add(new Robin());
        this.blacksmith = new Blacksmith(8, 10, 68, 33);
        this.carpenter = new Carpenter(9, 12, 8, 46);
        this.fishShop = new FishShop(8, 11, 28, 3);
        this.generalStore = new GeneralStore(11, 10, 34, 28);
        this.jojaMart = new JojaMart(8, 11, 5, 16);
        this.ranch = new Ranch(5, 14, 32, 54);
        this.saloon = new Saloon(7, 6, 70, 52);
        this.hut = new Hut(5, 12, 63, 51);
        this.greenHouse = new GreenHouse(8, 8, 31, 46);
        buildings.add(blacksmith);
        buildings.add(carpenter);
        buildings.add(fishShop);
        buildings.add(generalStore);
        buildings.add(jojaMart);
        buildings.add(ranch);
        buildings.add(saloon);

        networkClient = new NetworkClient();
        try {
            networkClient.connect("192.168.1.106", 54555, 54777); // adjust IP if needed
        } catch (IOException e) {
            e.printStackTrace();
        }

        model = new GameModel();
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

    public Map getCityMap() {
        return cityMap;
    }

    public void setCityMap(Map cityMap) {
        this.cityMap = cityMap;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public Hut getHut() {
        return hut;
    }

    public GreenHouse getGreenHouse() {
        return greenHouse;
    }
}
