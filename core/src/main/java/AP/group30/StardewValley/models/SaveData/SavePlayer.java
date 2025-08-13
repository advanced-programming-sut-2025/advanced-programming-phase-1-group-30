package AP.group30.StardewValley.models.SaveData;

import AP.group30.StardewValley.models.Inventory.BackPack;
import AP.group30.StardewValley.models.Inventory.Refrigerator;
import AP.group30.StardewValley.models.Inventory.ShippingBin;
import AP.group30.StardewValley.models.Inventory.TrashCan;
import AP.group30.StardewValley.models.Items.ArtisanGoods.ArtisanItemProsses;
import AP.group30.StardewValley.models.Items.Foods.FoodType;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProductType;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Players.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SavePlayer {
    private int id;
    private int x;
    private int y;
    private final String username;
    private AP.group30.StardewValley.models.Maps.Map map;
    private float energy;
    private ShippingBin shippingBin;
    private BackPack backPack;
    private TrashCan trashCan;
    private Refrigerator refrigerator;
    private int money;
    private int selectionNumber;
    private boolean isPassedOut;
    private Item wield;
    private int farming;
    private int foraging;
    private int fishing;
    private int mining;
    private int maxEnergy;
    private ArrayList<Item> products;
    java.util.Map<Item, Integer> itemsBoughtToday;
    private ArrayList<IndustrialProductType> craftingRecipes;
    private ArrayList<IndustrialProductType> devices;
    private ArrayList<FoodType> recipes;
    private String gender;
    private boolean inCity;
    private int lastEnergy;
    private boolean energyBuff;
    private boolean levelBuff;
    private SaveUser user;
    private Direction direction;
    private ArrayList<ArtisanItemProsses> artisanItemsProsses;
    private boolean isMoving;
    private float stateTime;
    private boolean facingLeft;
    private float reactionTime;
    private String chat;

    public SavePlayer(boolean facingLeft, int id, int x, int y, String username,
                      AP.group30.StardewValley.models.Maps.Map map, float energy,
                      ShippingBin shippingBin, BackPack backPack, TrashCan trashCan, Refrigerator refrigerator,
                      int money, int selectionNumber, boolean isPassedOut, Item wield, int farming, int foraging,
                      int fishing, int mining, int maxEnergy, ArrayList<Item> products,
                      Map<Item, Integer> itemsBoughtToday, ArrayList<IndustrialProductType> craftingRecipes,
                      ArrayList<IndustrialProductType> devices, ArrayList<FoodType> recipes, String gender,
                      boolean inCity, int lastEnergy, boolean energyBuff, boolean levelBuff,
                      SaveUser user, Direction direction,
                      ArrayList<ArtisanItemProsses> artisanItemsProsses, boolean isMoving, float stateTime,
                      float reactionTime, String chat) {
        this.facingLeft = facingLeft;
        this.id = id;
        this.x = x;
        this.y = y;
        this.username = username;
        this.map = map;
        this.energy = energy;
        this.shippingBin = shippingBin;
        this.backPack = backPack;
        this.trashCan = trashCan;
        this.refrigerator = refrigerator;
        this.money = money;
        this.selectionNumber = selectionNumber;
        this.isPassedOut = isPassedOut;
        this.wield = wield;
        this.farming = farming;
        this.foraging = foraging;
        this.fishing = fishing;
        this.mining = mining;
        this.maxEnergy = maxEnergy;
        this.products = products;
        this.itemsBoughtToday = itemsBoughtToday;
        this.craftingRecipes = craftingRecipes;
        this.devices = devices;
        this.recipes = recipes;
        this.gender = gender;
        this.inCity = inCity;
        this.lastEnergy = lastEnergy;
        this.energyBuff = energyBuff;
        this.levelBuff = levelBuff;
        this.user = user;
        this.direction = direction;
        this.artisanItemsProsses = artisanItemsProsses;
        this.isMoving = isMoving;
        this.stateTime = stateTime;
        this.reactionTime = reactionTime;
        this.chat = chat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getUsername() {
        return username;
    }

    public AP.group30.StardewValley.models.Maps.Map getMap() {
        return map;
    }

    public void setMap(AP.group30.StardewValley.models.Maps.Map map) {
        this.map = map;
    }

    public float getEnergy() {
        return energy;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }

    public ShippingBin getShippingBin() {
        return shippingBin;
    }

    public void setShippingBin(ShippingBin shippingBin) {
        this.shippingBin = shippingBin;
    }

    public BackPack getBackPack() {
        return backPack;
    }

    public void setBackPack(BackPack backPack) {
        this.backPack = backPack;
    }

    public TrashCan getTrashCan() {
        return trashCan;
    }

    public void setTrashCan(TrashCan trashCan) {
        this.trashCan = trashCan;
    }

    public Refrigerator getRefrigerator() {
        return refrigerator;
    }

    public void setRefrigerator(Refrigerator refrigerator) {
        this.refrigerator = refrigerator;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getSelectionNumber() {
        return selectionNumber;
    }

    public void setSelectionNumber(int selectionNumber) {
        this.selectionNumber = selectionNumber;
    }

    public boolean isPassedOut() {
        return isPassedOut;
    }

    public void setPassedOut(boolean passedOut) {
        isPassedOut = passedOut;
    }

    public Item getWield() {
        return wield;
    }

    public void setWield(Item wield) {
        this.wield = wield;
    }

    public int getFarming() {
        return farming;
    }

    public void setFarming(int farming) {
        this.farming = farming;
    }

    public int getForaging() {
        return foraging;
    }

    public void setForaging(int foraging) {
        this.foraging = foraging;
    }

    public int getFishing() {
        return fishing;
    }

    public void setFishing(int fishing) {
        this.fishing = fishing;
    }

    public int getMining() {
        return mining;
    }

    public void setMining(int mining) {
        this.mining = mining;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public ArrayList<Item> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Item> products) {
        this.products = products;
    }

    public Map<Item, Integer> getItemsBoughtToday() {
        return itemsBoughtToday;
    }

    public void setItemsBoughtToday(Map<Item, Integer> itemsBoughtToday) {
        this.itemsBoughtToday = itemsBoughtToday;
    }

    public ArrayList<IndustrialProductType> getCraftingRecipes() {
        return craftingRecipes;
    }

    public void setCraftingRecipes(ArrayList<IndustrialProductType> craftingRecipes) {
        this.craftingRecipes = craftingRecipes;
    }

    public ArrayList<IndustrialProductType> getDevices() {
        return devices;
    }

    public void setDevices(ArrayList<IndustrialProductType> devices) {
        this.devices = devices;
    }

    public ArrayList<FoodType> getRecipes() {
        return recipes;
    }

    public void setRecipes(ArrayList<FoodType> recipes) {
        this.recipes = recipes;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isInCity() {
        return inCity;
    }

    public void setInCity(boolean inCity) {
        this.inCity = inCity;
    }

    public int getLastEnergy() {
        return lastEnergy;
    }

    public void setLastEnergy(int lastEnergy) {
        this.lastEnergy = lastEnergy;
    }

    public boolean isEnergyBuff() {
        return energyBuff;
    }

    public void setEnergyBuff(boolean energyBuff) {
        this.energyBuff = energyBuff;
    }

    public boolean isLevelBuff() {
        return levelBuff;
    }

    public void setLevelBuff(boolean levelBuff) {
        this.levelBuff = levelBuff;
    }

    public SaveUser getUser() {
        return user;
    }

    public void setUser(SaveUser user) {
        this.user = user;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public ArrayList<ArtisanItemProsses> getArtisanItemsProsses() {
        return artisanItemsProsses;
    }

    public void setArtisanItemsProsses(ArrayList<ArtisanItemProsses> artisanItemsProsses) {
        this.artisanItemsProsses = artisanItemsProsses;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public float getStateTime() {
        return stateTime;
    }

    public void setStateTime(float stateTime) {
        this.stateTime = stateTime;
    }

    public boolean isFacingLeft() {
        return facingLeft;
    }

    public void setFacingLeft(boolean facingLeft) {
        this.facingLeft = facingLeft;
    }

    public float getReactionTime() {
        return reactionTime;
    }

    public void setReactionTime(float reactionTime) {
        this.reactionTime = reactionTime;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }
}
