package models.Players;

import controllers.NewGameController;
import models.Animals.Animal;
import models.App;
import models.Buildings.Building;
import models.Invetory.BackPack;
import models.Invetory.BackPackType;
import models.Invetory.Refrigerator;
import models.Invetory.ShippingBin;
import models.Invetory.ShippingBinType;
import models.Invetory.TrashCan;
import models.Invetory.TrashCanType;
import models.Items.Gift;
import models.Items.Item;
import models.Items.ArtisanGoods.ArtisanItemProsses;
import models.Items.Foods.FoodType;
import models.Items.IndustrialProducts.IndustrialProductType;
import models.Items.Products.ForagingSeed;
import models.Items.Products.ForagingSeedType;
import models.Items.Tools.*;
import models.Maps.Map;
import models.Players.NPC.NPC;
import models.Users.User;
import views.GameMenu;

import java.util.*;

public class Player {
    private int x;
    private int y;
    private int cityX;
    private int cityY;
    private final String username;
    private Map map;
    private int energy;
    private ShippingBin shippingBin;
    private BackPack backPack;
    private TrashCan trashCan;
    private Refrigerator refrigerator;
    private int money;
    private final HashMap<Player, Friendship> friendships = new HashMap<>();
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
    private ArrayList<IndustrialProductType> craftingRecipes = new ArrayList<>();
    private Building building;
    private ArrayList<FoodType> recipes;
    private HashMap<NPC,Integer> friendshipsNPC = new HashMap<>();
    private HashMap<NPC,ArrayList<Integer>> activatedQuestNPC = new HashMap<>();
    private HashMap<NPC,Boolean> NPCMeetToday  = new HashMap<>();
    private ArrayList<Gift> gifts = new ArrayList<>();
    private Player askedMarriage = null;
    private String gender;
    private boolean inCity;
    private Map savedMap;
    private int lastEnergy;
    private ArrayList<Item> shippingBinItems = new ArrayList<>();
    private boolean energyBuff = false;
    private boolean levelBuff = false;
    private HashMap<String, Integer> buffs = new HashMap<>();
    private User user;
    private String newTalk;
    private Player hamsar = null;
    private boolean gotRejected = false;
    private int daysGotRejected = -1;
    private ArrayList<ArtisanItemProsses> artisanItemsProsses = new ArrayList<>();

    public Player(User user,String username, int selectionNumber) {
        this.user = user;
        this.username = username;
        this.map = null;
        this.energy = 200;
        this.shippingBin = new ShippingBin(ShippingBinType.REGULAR, 70, 10);
        this.refrigerator = new Refrigerator();
        this.backPack = new BackPack(BackPackType.INITIAL_BACKPACK);
        this.backPack.addItem(new Axe(1, AxeType.NORMAL));
        this.backPack.addItem(new Hoe(1, HoeType.NORMAL));
        this.backPack.addItem(new Pickaxe(1, PickaxeType.NORMAL));
        this.backPack.addItem(new Basket(1, BasketType.NORMAL));
        this.backPack.addItem(new MilkPail(1, 10));
        this.backPack.addItem(new Scythe(1));
        this.trashCan = new TrashCan(TrashCanType.INITIAL_TRASHCAN);
        this.backPack.addItem(new ForagingSeed(10, ForagingSeedType.MELON_SEEDS)); //TODO tile & initial seed
        this.backPack.addItem(new Item(1, "bouquet", 10));
        this.backPack.addItem(new Item(1, "wedding ring", 10));
        this.backPack.addItem(new Item(1000, "wood", 10));
        this.backPack.addItem(new Item(1000, "stone", 20));
        this.backPack.addItem(new Item(50, "hay", 50));
        this.backPack.addItem(new ForagingSeed(1, ForagingSeedType.BEAN_STARTER));
        this.backPack.addItem(new Item(50, "speed-gro", 50));
        this.backPack.addItem(new Item(50, "deluxe retaining soil", 50));
        this.backPack.addItem(new Item(50, "copper bar", 50));
        this.money = 20000;
        this.selectionNumber = selectionNumber;
        this.maxEnergy = 200;
        this.building = new Building(0, 0, 0, 0, 9, 21); //TODO home!!!
        this.lastEnergy = maxEnergy;
        this.recipes = new ArrayList<>();
        this.inCity = false;
        for(int i = 0; i < 5; i++){
            this.friendshipsNPC.put(App.getCurrentGame().getNPCs().get(i), 0);
            this.activatedQuestNPC.put(App.getCurrentGame().getNPCs().get(i), new ArrayList<>(List.of(1)));
            this.NPCMeetToday.put(App.getCurrentGame().getNPCs().get(i), false);
        }
        this.buffs.put("triple shot espresso", -1);
        this.buffs.put("hash browns", -1);
        this.buffs.put("pancakes", -1);
        this.buffs.put("red plate", -1);
        this.buffs.put("farmer's lunch", -1);
        this.buffs.put("survival burger", -1);
        this.buffs.put("dish o' the Sea", -1);
        this.buffs.put("seaform pudding", -1);
        this.buffs.put("miner's treat", -1);
    }

    public String getUsername() {
        return username;
    }

    public boolean isGotRejected() {
        return gotRejected;
    }

    public int getDaysGotRejected() {
        return daysGotRejected;
    }

    public void setDaysGotRejected(int daysGotRejected) {
        this.daysGotRejected = daysGotRejected;
    }

    public void setGotRejected(boolean gotRejected) {
        this.gotRejected = gotRejected;
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

    public HashMap<Player, Friendship> getFriendships() {
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
    public static void updateBuffs(List<Player> players) {
        for (Player player : players) {

            for (java.util.Map.Entry<String, Integer> entry : player.getBuffs().entrySet()) {
                String buffName = entry.getKey();
                int timeLeft = entry.getValue();

                if (timeLeft > 1) {
                    // Decrement buff duration
                    entry.setValue(timeLeft - 1);
                } else if (timeLeft == -1) {
                    //nothing
                } else {
                    entry.setValue(-1);
                    GameMenu.printResult(player.getUsername() + "'s buff \"" + buffName + "\" is over!");

                    // Revert buff effect
                    switch (buffName) {
                        case "red plate" -> {
                            player.setMaxEnergy(player.getMaxEnergy() - 50);
                            GameMenu.printResult("Max energy decreased by 50.");
                        }
                        case "triple shot espresso" -> {
                            player.setMaxEnergy(player.getMaxEnergy() - 100);
                            GameMenu.printResult("Max energy decreased by 100.");
                        }
                        case "hash browns", "farmer's lunch" -> {
                            player.setFarming(player.getFarming() - 1);
                            GameMenu.printResult("Farming skill decreased by 1.");
                        }
                        case "pancakes", "survival burger" -> {
                            player.setForaging(player.getForaging() - 1);
                            GameMenu.printResult("Foraging skill decreased by 1.");
                        }
                        case "dish o' the sea", "seaform pudding" -> {
                            player.setFishing(player.getFishing() - 1);
                            GameMenu.printResult("Fishing skill decreased by 1.");
                        }
                        case "miner's treat" -> {
                            player.setMining(player.getMining() - 1);
                            GameMenu.printResult("Mining skill decreased by 1.");
                        }
                    }
                }
            }
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
    public ArrayList<IndustrialProductType> getCraftingRecipes() {
        return craftingRecipes;
    }
    public void addCraftingRecipe(IndustrialProductType craftingRecipe) {
        this.craftingRecipes.add(craftingRecipe);
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


    public HashMap<NPC, Integer> getFriendshipsNPC() {
        for(int i = 0; i < 5 ; i++){
            if(this.friendshipsNPC.get(App.getCurrentGame().getNPCs().get(i)) > 799){
                this.friendshipsNPC.put(App.getCurrentGame().getNPCs().get(i), 799);
            }
        }
        return friendshipsNPC;
    }


    public HashMap<NPC, ArrayList<Integer>> getActivatedQuestNPC() {
        return activatedQuestNPC;
    }


    public HashMap<NPC, Boolean> getNPCMeetToday() {
        return NPCMeetToday;
    }

    public ArrayList<Gift> getGifts() {
        return gifts;
    }

    public Player getAskedMarriage() {
        return askedMarriage;
    }

    public void setAskedMarriage(Player askedMarriage) {
        this.askedMarriage = askedMarriage;
    }

    public static boolean areAdjacent(Player player, Player otherPlayer) {
        if (player.inCity && otherPlayer.inCity) {
            int dx = Math.abs(player.getCityX() - otherPlayer.getCityX());
            int dy = Math.abs(player.getCityY() - otherPlayer.getCityY());
            return (dx <= 1 && dy <= 1) && !(dx == 0 && dy == 0);
        } else {
            return false;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public void adjustMoney(int delta) {
        if (money + delta < 0) {
            throw new IllegalStateException(
                    getUsername() + " does not have enough money (needed " + (-delta) + ")."
            );
        }
        money += delta;
    }

    public boolean isInCity() {
        return inCity;
    }

    public void setInCity(boolean inCity) {
        this.inCity = inCity;
    }

    public Map getSavedMap() {
        return savedMap;
    }

    public void setSavedMap(Map savedMap) {
        this.savedMap = savedMap;
    }

    public int getCityX() {
        return cityX;
    }

    public void setCityX(int cityX) {
        this.cityX = cityX;
    }

    public int getCityY() {
        return cityY;
    }

    public void setCityY(int cityY) {
        this.cityY = cityY;
    }

    public int getLastEnergy() {
        return lastEnergy;
    }

    public void setLastEnergy(int lastEnergy) {
        this.lastEnergy = lastEnergy;
    }
    public static void checkUsedEnergy(Player player, Scanner scanner) {
        if (player.lastEnergy - player.energy > 50) {
            player.lastEnergy = player.energy;
            GameMenu.printResult("You used your maximum energy possible for your turn!");
            NewGameController.NextTurn(scanner);
        }
    }
    public ArrayList<Item> getShippingBinItems() {
        return this.shippingBinItems;
    }

    public void resetShippingBinItems() {
        this.shippingBinItems = new ArrayList<>();
    }

    public void addShippingBinItem(Item shippingBinItem) {
        this.shippingBinItems.add(shippingBinItem);
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

    public HashMap<String, Integer> getBuffs() {
        return buffs;
    }

    public void setFarming(int farming) {
        this.farming = farming;
    }

    public void setForaging(int foraging) {
        this.foraging = foraging;
    }

    public void setFishing(int fishing) {
        this.fishing = fishing;
    }

    public void setMining(int mining) {
        this.mining = mining;
    }
    public User getUser() {
        return user;
    }

    public String isNewTalk() {
        return newTalk;
    }

    public void setNewTalk(String newTalk) {
        this.newTalk = newTalk;
    }

    public Player getHamsar() {
        return hamsar;
    }

    public void setHamsar(Player hamsar) {
        this.hamsar = hamsar;
    }

    public ArrayList<ArtisanItemProsses> getArtisanItemsProsses() {
        return artisanItemsProsses;
    }

    public void addArtisanItemProsses(ArtisanItemProsses artisanItemProsses) {
        this.artisanItemsProsses.add(artisanItemProsses);
    }

    public void removeArtisanItemProsses(ArtisanItemProsses artisanItemProsses) {
        this.artisanItemsProsses.remove(artisanItemProsses);
    }
}