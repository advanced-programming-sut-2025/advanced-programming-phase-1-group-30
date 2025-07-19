package AP.group30.StardewValley.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Maps.Tile;
import AP.group30.StardewValley.models.Maps.TileTypes;
import AP.group30.StardewValley.models.Pair;
import AP.group30.StardewValley.models.Buildings.Blacksmith;
import AP.group30.StardewValley.models.Buildings.BlacksmithCosts;
import AP.group30.StardewValley.models.Buildings.Carpenter;
import AP.group30.StardewValley.models.Buildings.CarpenterCosts;
import AP.group30.StardewValley.models.Buildings.FishShop;
import AP.group30.StardewValley.models.Buildings.FishShopCosts;
import AP.group30.StardewValley.models.Buildings.GeneralStore;
import AP.group30.StardewValley.models.Buildings.GeneralStoreCosts;
import AP.group30.StardewValley.models.Buildings.JojaMart;
import AP.group30.StardewValley.models.Buildings.JojaMartCosts;
import AP.group30.StardewValley.models.Buildings.Ranch;
import AP.group30.StardewValley.models.Buildings.RanchCosts;
import AP.group30.StardewValley.models.Buildings.Saloon;
import AP.group30.StardewValley.models.Buildings.SaloonCosts;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.ItemFactory;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.Items.ArtisanGoods.ArtisanGood;
import AP.group30.StardewValley.models.Items.ArtisanGoods.ArtisanGoodType;
import AP.group30.StardewValley.models.Items.ArtisanGoods.ArtisanItemProsses;
import AP.group30.StardewValley.models.Items.Foods.Food;
import AP.group30.StardewValley.models.Items.Foods.FoodType;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProduct;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProductType;
import AP.group30.StardewValley.models.Items.Products.AnimalProduct;
import AP.group30.StardewValley.models.Items.Products.AnimalProductType;
import AP.group30.StardewValley.models.Items.Products.Crop;
import AP.group30.StardewValley.models.Items.Products.CropType;
import AP.group30.StardewValley.models.Items.Products.ForagingCrop;
import AP.group30.StardewValley.models.Items.Products.ForagingCropType;
import AP.group30.StardewValley.models.Items.Products.ForagingMineral;
import AP.group30.StardewValley.models.Items.Products.ForagingMineralType;
import AP.group30.StardewValley.models.Items.Products.ForagingSeed;
import AP.group30.StardewValley.models.Items.Products.ForagingSeedType;
import AP.group30.StardewValley.models.Items.Products.ForagingTree;
import AP.group30.StardewValley.models.Items.Products.ForagingTreeType;
import AP.group30.StardewValley.models.Items.Products.Fruit;
import AP.group30.StardewValley.models.Items.Products.FruitType;
import AP.group30.StardewValley.models.Items.Products.Tree;
import AP.group30.StardewValley.models.Items.Products.TreeType;
import AP.group30.StardewValley.models.Items.Products.ShopProducts.BlacksmithProducts;
import AP.group30.StardewValley.models.Items.Products.ShopProducts.CarpenterProducts;
import AP.group30.StardewValley.models.Items.Products.ShopProducts.FishShopProducts;
import AP.group30.StardewValley.models.Items.Products.ShopProducts.GeneralStoreProducts;
import AP.group30.StardewValley.models.Items.Products.ShopProducts.JojaMartProducts;
import AP.group30.StardewValley.models.Items.Products.ShopProducts.RanchProducts;
import AP.group30.StardewValley.models.Items.Products.ShopProducts.SaloonProducts;
import AP.group30.StardewValley.models.Maps.Map;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.views.GameMenu;
import AP.group30.StardewValley.views.StartMenus.RegisterMenu;

public class MaintainerController {
    private static final List<Pair<Class<? extends Enum<?>>, ItemFactory<?>>> ITEM_TYPES = Arrays.asList(
        new Pair<>(FoodType.class, (ItemFactory<FoodType>) (count, recipe) -> new Food(count, recipe)),
        new Pair<>(IndustrialProductType.class, (ItemFactory<IndustrialProductType>) (count, recipe) -> new IndustrialProduct(count, recipe)),
        new Pair<>(ArtisanGoodType.class, (ItemFactory<ArtisanGoodType>) (count, recipe) -> new ArtisanGood(count, recipe)),
        new Pair<>(AnimalProductType.class, (ItemFactory<AnimalProductType>) (count, recipe) -> new AnimalProduct(count, recipe)),
        new Pair<>(CropType.class, (ItemFactory<CropType>) (count, recipe) -> new Crop(count, recipe)),
        new Pair<>(ForagingCropType.class, (ItemFactory<ForagingCropType>) (count, recipe) -> new ForagingCrop(count, recipe)),
        new Pair<>(ForagingMineralType.class, (ItemFactory<ForagingMineralType>) (count, recipe) -> new ForagingMineral(count, recipe)),
        new Pair<>(ForagingTreeType.class, (ItemFactory<ForagingTreeType>) (count, recipe) -> new ForagingTree(count, recipe)),
        new Pair<>(ForagingSeedType.class, (ItemFactory<ForagingSeedType>) (count, recipe) -> new ForagingSeed(count, recipe)),
        new Pair<>(FruitType.class, (ItemFactory<FruitType>) (count, recipe) -> new Fruit(count, recipe)),
        new Pair<>(TreeType.class, (ItemFactory<TreeType>) (count, recipe) -> new Tree(count, recipe, 0, 0)),
        new Pair<>(BlacksmithCosts.class, (ItemFactory<BlacksmithCosts>) (count, recipe) -> new BlacksmithProducts(count, recipe)),
        new Pair<>(CarpenterCosts.class, (ItemFactory<CarpenterCosts>) (count, recipe) -> new CarpenterProducts(count, recipe)),
        new Pair<>(FishShopCosts.class, (ItemFactory<FishShopCosts>) (count, recipe) -> new FishShopProducts(count, recipe)),
        new Pair<>(GeneralStoreCosts.class, (ItemFactory<GeneralStoreCosts>) (count, recipe) -> new GeneralStoreProducts(count, recipe)),
        new Pair<>(JojaMartCosts.class, (ItemFactory<JojaMartCosts>) (count, recipe) -> new JojaMartProducts(count, recipe)),
        new Pair<>(RanchCosts.class, (ItemFactory<RanchCosts>) (count, recipe) -> new RanchProducts(count, recipe)),
        new Pair<>(SaloonCosts.class, (ItemFactory<SaloonCosts>) (count, recipe) -> new SaloonProducts(count, recipe))
    );

    public static void randomPlanting(Player player) {
        Tile[][] tiles = player.getMap().getTiles();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                Tile targetTile = tiles[i][j];
                Random rand = new Random();
                int x = rand.nextInt(100);
                if ((targetTile.getType().equals(TileTypes.DIRT) || targetTile.getType().equals(TileTypes.GRASS)) && x == 85 && targetTile.getItem() == null) {
                    ForagingSeedType randomSeed = ForagingSeedType.values()[new Random().nextInt(ForagingSeedType.values().length)];
                    ForagingSeed seed = new ForagingSeed(1, randomSeed);
                    targetTile.setItem(seed);
                    seed.setFertilized(false);
                    targetTile.setPlanted(true);
                    targetTile.setReadyToHarvest(false);
                    targetTile.setCrop(seed.getCrop());
                    targetTile.setType(TileTypes.PLANTABLE);
                }
            }
        }
    }

    public static void loadMap(){
        Map map = new Map(1);
        map.printMap();
    }

    public static <T> String arrayListToString(String name, ArrayList<T> list) {
        StringBuilder sb = new StringBuilder();

        sb.append(name + ": ");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append("-");
            }
            else sb.append("\n");
        }

        return sb.toString();
    }

    public static void crowAttack() {
        Random random = new Random();
        Player player = App.getCurrentGame().getCurrentPlayer();

        int chance;
        if (App.getCurrentGame().getCurrentPlayer().getMap().hasScareCrow()) chance = 8;
        else chance = 4;

        int randomNumber = random.nextInt(chance);
        if (randomNumber == 0) {
            GameMenu.printResult("You are under attack by CROWS!");

            for (int i = 0; i < 80; i++) {
                for (int j = 0; j < 60; j++) {
                    Tile tile = player.getMap().getTiles()[i][j];
                    if (tile.isPlanted()) {
                        randomNumber = random.nextInt(10);
                        if (randomNumber == 0) {
                            GameMenu.printResult("You lose " + tile.getItem().getName());
                            tile.setPlanted(false);
                            tile.setReadyToHarvest(false);
                            RegisterMenu.gameScreen.entities.remove(tile.getCrop());
                            tile.setCrop(null);
                            tile.setItem(null);
                            tile.setType(TileTypes.DIRT);
                        }
                    }
                }
            }
        }
    }

    public static <T> String printingShopProducts(String name, T[] list) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ");
        sb.append(name).append(" Products: ===\n");

        for (T item : list) {
            String formatted = item.toString().toLowerCase().replace('_', ' ');
            sb.append(formatted).append("\n");
        }

        return sb.toString();
    }


    public static <T> String printingShopProducts2(String name, ArrayList<Item> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ");
        sb.append(name + " Products: ===\n");

        for (int i = 0; i < list.size(); i++) {
            String count;
            if (list.get(i).getCount() > 1000) {
                count = "unlimited";
            } else
                count = String.valueOf(list.get(i).getCount());
            sb.append(list.get(i).getName() + ": " + count + "      price: " + (int)list.get(i).getPrice() + "g\n");
        }

        return sb.toString();
    }

    public static boolean cheatAddItem(String name, int count) {
        Player player = App.getCurrentGame().getCurrentPlayer();


        for (Pair<Class<? extends Enum<?>>, ItemFactory<?>> entry : ITEM_TYPES) {
            Class<? extends Enum<?>> enumClass = entry.getKey();
            ItemFactory<?> factory = entry.getValue();

            for (Object constant : enumClass.getEnumConstants()) {
                ItemsInteface recipe = (ItemsInteface) constant;
                if (recipe.getName().equals(name)) {
                    Item newItem = ((ItemFactory<ItemsInteface>) factory).create(count, recipe);

                    Item itemBackpack = Item.findItemByName(newItem.getName(), player.getBackPack().getItems());

                    if (itemBackpack == null) {
                        if (player.getBackPack().getType().getCapacity() > player.getBackPack().getItems().size()) {
                            player.getBackPack().getItems().add(newItem);
                        } else {
                            GameMenu.printResult("You don't have enough space in your backpack!");
                            return false;
                        }
                    } else {
                        itemBackpack.setCount(itemBackpack.getCount() + count);
                    }

                    GameMenu.printResult(count + " " + name + " added to your backpack!");
                    return true;
                }
            }
        }

        GameMenu.printResult("Item " + name + " not found in any category.");
        return false;
    }

    public static void updateAllShops() {
        updateBlacksmith();
        updateCarpenter();
        updateFishShop();
        updateGeneralStore();
        updateJojaMart();
        updateRanch();
        updateSaloon();
    }

    private static void updateBlacksmith() {
        Blacksmith blacksmith =  App.getCurrentGame().getBlacksmith();
        blacksmith.removeItems();
        ArrayList<BlacksmithCosts> items = new ArrayList<>(List.of(BlacksmithCosts.values()));
        Collections.shuffle(items);
        Random rand = new Random();

        for (int i = 0; i < rand.nextInt(items.size()); i++) {
            BlacksmithCosts type = items.get(i);
            int count = 1 + Math.max(rand.nextInt(type.getDailyLimit()), 10);
            blacksmith.addItem(new BlacksmithProducts(count, type));
        }
    }

    private static void updateCarpenter() {
        Carpenter carpenter = App.getCurrentGame().getCarpenter();
        carpenter.removeItems();
        ArrayList<CarpenterCosts> items = new ArrayList<>(List.of(CarpenterCosts.values()));
        Collections.shuffle(items);
        Random rand = new Random();

        for (int i = 0; i < items.size(); i++) {
            CarpenterCosts type = items.get(i);
//            int count = 1 + Math.max(rand.nextInt(type.getDailyLimit()), 10);
            carpenter.addItem(new CarpenterProducts(type.getDailyLimit(), type));
        }
    }

    private static void updateFishShop() {
        FishShop fishShop = App.getCurrentGame().getFishShop();
        fishShop.removeItems();
        ArrayList<FishShopCosts> items = new ArrayList<>(List.of(FishShopCosts.values()));
        Collections.shuffle(items);
        Random rand = new Random();

        for (int i = 0; i < rand.nextInt(items.size()); i++) {
            FishShopCosts type = items.get(i);
            int count = 1 + Math.max(rand.nextInt(type.getDailyLimit()), 10);
            fishShop.addItem(new FishShopProducts(count, type));
        }
    }

    private static void updateGeneralStore() {
        GeneralStore store = App.getCurrentGame().getGeneralStore();
        store.removeItems();
        ArrayList<GeneralStoreCosts> items = new ArrayList<>(List.of(GeneralStoreCosts.values()));
        Collections.shuffle(items);
        Random rand = new Random();

        for (int i = 0; i < rand.nextInt(items.size()); i++) {
            GeneralStoreCosts type = items.get(i);
            int count = 1 + Math.max(rand.nextInt(type.getDailyLimit()), 10);
            store.addItem(new GeneralStoreProducts(count, type));
        }
    }

    private static void updateJojaMart() {
        JojaMart jojaMart = App.getCurrentGame().getJojaMart();
        jojaMart.removeItems();
        ArrayList<JojaMartCosts> items = new ArrayList<>(List.of(JojaMartCosts.values()));
        Collections.shuffle(items);
        Random rand = new Random();

        for (int i = 0; i < Math.min(rand.nextInt(items.size()) + 5, items.size()); i++) {
            JojaMartCosts type = items.get(i);
            int count = 1 + Math.max(rand.nextInt(type.getDailyLimit()), 10);
            if (type.getSeason().equals(App.getCurrentGame().getCurrentTime().getSeason())) jojaMart.addItem(new JojaMartProducts(count, type));
        }
    }

    private static void updateRanch() {
        Ranch ranch = App.getCurrentGame().getRanch();
        ranch.removeItems();
        ArrayList<RanchCosts> items = new ArrayList<>(List.of(RanchCosts.values()));
        Collections.shuffle(items);
        Random rand = new Random();

        for (int i = 0; i < rand.nextInt(items.size()); i++) {
            RanchCosts type = items.get(i);
            int count = 1 + Math.max(rand.nextInt(type.getDailyLimit()), 10);
            ranch.addItem(new RanchProducts(count, type));
        }
    }

    private static void updateSaloon() {
        Saloon saloon = App.getCurrentGame().getSaloon();
        saloon.removeItems();
        ArrayList<SaloonCosts> items = new ArrayList<>(List.of(SaloonCosts.values()));
        Collections.shuffle(items);
        Random rand = new Random();

        for (int i = 0; i < rand.nextInt(items.size()); i++) {
            SaloonCosts type = items.get(i);
            int count = 1 + Math.max(rand.nextInt(type.getDailyLimit()), 10);
            saloon.addItem(new SaloonProducts(count, type));
        }
    }

    public static void emptyShippingBin() {
        for (Player player : App.getCurrentGame().getPlayers()) {
            if (player.getShippingBin().getItems() == null) continue;

            int money = 0;
            for (Item item : player.getShippingBin().getItems()) {
                money += (int) player.getShippingBin().getType().calculateNewPrice(item.getPrice() * item.getCount(), item.getCof());
            }

            player.setMoney(player.getMoney() + money);
            player.getShippingBin().setItems(new ArrayList<>());
        }
        GameMenu.printResult("Shipping Bins were emptied!");
    }

    public static void artisanProssesTimeChanger(int amount) {
        for (Player player : App.getCurrentGame().getPlayers()) {
            for (ArtisanItemProsses artisanItemProsses : player.getArtisanItemsProsses()) {
                artisanItemProsses.changeRemainingTime(amount);
                if (artisanItemProsses.getRemainingTime() == 0)
                    GameMenu.printResult(player.getUsername() + "! Your " + artisanItemProsses.getArtisanGood().getName() + " is ready!");
            }
        }
    }
}
