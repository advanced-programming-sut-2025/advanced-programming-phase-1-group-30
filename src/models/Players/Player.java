package models.Players;

import models.Animals.Animal;
import models.Buildings.Building;
import models.Invetory.BackPack;
import models.Invetory.BackPackType;
import models.Invetory.Refrigerator;
import models.Invetory.ShippingBin;
import models.Invetory.ShippingBinType;
import models.Invetory.TrashCan;
import models.Invetory.TrashCanType;
import models.Items.Products.CraftingRecipe;
import models.Items.Item;
import models.Items.Foods.FoodType;
import models.Items.Products.ForgingSeed;
import models.Items.Products.ForgingSeedType;
import models.Items.Tools.*;
import models.Maps.Map;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private int x;
    private int y;
    private final String username;
    private Map map;
    private int energy;
    private ShippingBin shippingBin;
    private BackPack backPack;
    private TrashCan trashCan;
    private Refrigerator refrigerator;
    private int money;
    private final HashMap<Player, Integer> friendships = new HashMap<>();
    private final ArrayList<Skills> skills = new ArrayList<>();
    private int selectionNumber;
    private boolean isPassedOut = false;
    private Item wield = null;
    private int farming = 0;
    private int foraging = 0;
    private int fishing = 0;
    private int mining = 0;
    private int maxEnergy;
    private final ArrayList<Item> products = new ArrayList<>();
    java.util.Map<Item, Integer> itemsBoughtToday = new HashMap<>();
    private final ArrayList<Animal> playerAnimals = new ArrayList<>();
    private ArrayList<CraftingRecipe> craftingRecipes = new ArrayList<>();
    private Building building;
    private ArrayList<FoodType> recipes = new ArrayList<>();

    public Player(String username, int selectionNumber) {
        this.username = username;
        this.map = null;
        this.energy = 200;

        this.shippingBin = new ShippingBin(ShippingBinType.REGULAR);
        this.refrigerator = new Refrigerator();
        this.backPack = new BackPack(BackPackType.INITIAL_BACKPACK);
        this.backPack.addItem(new Axe(1, AxeType.NORMAL));
        this.backPack.addItem(new Hoe(1, HoeType.NORMAL));
        this.backPack.addItem(new Pickaxe(1, PickaxeType.NORMAL));
        this.backPack.addItem(new Basket(1, BasketType.NORMAL));
        this.backPack.addItem(new Scythe(1));
        this.trashCan = new TrashCan(TrashCanType.INITIAL_TRASHCAN);
        this.backPack.addItem(new ForgingSeed(1, ForgingSeedType.BLUEBERRY_SEEDS, null)); //TODO tile & initial seed
        this.money = 0;
        this.selectionNumber = selectionNumber;
        this.maxEnergy = 200;
        this.building = new Building(0, 0, 0, 0); //TODO home!!!
        this.recipes = null;
    }

    public String getUsername() {
        return username;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void changeEnergy(int amount) {
        this.energy += amount;
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

    public HashMap<Player, Integer> getFriendships() {
        return friendships;
    }
    public boolean isPassedOut() {
        return isPassedOut;
    }

    public void setPassedOut(boolean passedOut) {
        isPassedOut = passedOut;
    }
    
    public ArrayList<Skills> getSkills() {
        return skills;
    }

    public int getSelectionNumber() {
        return selectionNumber;
    }

    public void setSelectionNumber(int selectionNumber) {
        this.selectionNumber = selectionNumber;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
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

    public void increaseFarming(int increase) {
        this.farming += increase;
        if(this.foraging > 450){
            this.foraging = 450;
        }
    }

    public int getForaging() {
        return foraging;
    }

    public void increaseForaging(int increase) {
        this.foraging += increase;
        if(this.foraging > 450){
            this.foraging = 450;
        }
    }

    public int getFishing() {
        return fishing;
    }

    public void increaseFishing(int increase) {
        this.fishing += increase;
        if(this.fishing > 450){
            this.fishing = 450;
        }
    }

    public int getMining() {
        return mining;
    }

    public void increaseMining(int increase) {
        this.mining += increase;
        if(this.mining > 450){
            this.mining = 450;
        }
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public TrashCan getTrashCan() {
        return trashCan;
    }

    public void setTrashCan(TrashCan trashCan) {
        this.trashCan = trashCan;
    }

    public ArrayList<Item> getProducts() {
        return products;
    }

    public void addProduct(Item product) {
        this.products.add(product);
    }

    public void removedProduct(Item product) {
        this.products.remove(product);
    }

    public java.util.Map<Item, Integer> getItemsBoughtToday() {
        return itemsBoughtToday;
    }
    public ArrayList<Animal> getAnimals() {
        return playerAnimals;
    }
    public ArrayList<CraftingRecipe> getCraftingRecipes() {
        return craftingRecipes;
    }
    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public ArrayList<FoodType> getRecipes() {
        return recipes;
    }

    public void addRecipe(FoodType recipe) {
        this.recipes.add(recipe);
    }
}
