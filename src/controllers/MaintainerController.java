package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import models.App;
import models.Pair;
import models.Buildings.BlacksmithCosts;
import models.Buildings.CarpenterCosts;
import models.Buildings.FishShopCosts;
import models.Buildings.GeneralStoreCosts;
import models.Buildings.JojaMartCosts;
import models.Buildings.RanchCosts;
import models.Buildings.SaloonCosts;
import models.Items.Item;
import models.Items.ItemFactory;
import models.Items.ItemsInteface;
import models.Items.ArtisanGoods.ArtisanGood;
import models.Items.ArtisanGoods.ArtisanGoodType;
import models.Items.Foods.Food;
import models.Items.Foods.FoodType;
import models.Items.IndustrialProducts.IndustrialProduct;
import models.Items.IndustrialProducts.IndustrialProductType;
import models.Items.Products.AnimalProduct;
import models.Items.Products.AnimalProductType;
import models.Items.Products.Crop;
import models.Items.Products.CropType;
import models.Items.Products.ForagingCrop;
import models.Items.Products.ForagingCropType;
import models.Items.Products.ForagingMineral;
import models.Items.Products.ForagingMineralType;
import models.Items.Products.ForagingSeed;
import models.Items.Products.ForagingSeedType;
import models.Items.Products.ForagingTree;
import models.Items.Products.ForagingTreeType;
import models.Items.Products.Fruit;
import models.Items.Products.FruitType;
import models.Items.Products.Tree;
import models.Items.Products.TreeType;
import models.Items.Products.ShopProducts.BlacksmithProducts;
import models.Items.Products.ShopProducts.CarpenterProducts;
import models.Items.Products.ShopProducts.FishShopProducts;
import models.Items.Products.ShopProducts.GeneralStoreProducts;
import models.Items.Products.ShopProducts.JojaMartProducts;
import models.Items.Products.ShopProducts.RanchProducts;
import models.Items.Products.ShopProducts.SaloonProducts;
import models.Maps.Map;
import models.Players.Player;
import views.GameMenu;

public class MaintainerController {
    public static final List<Pair<Class<? extends Enum<?>>, ItemFactory<?>>> ITEM_TYPES = Arrays.asList(
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
        new Pair<>(TreeType.class, (ItemFactory<TreeType>) (count, recipe) -> new Tree(count, recipe)),
        new Pair<>(BlacksmithCosts.class, (ItemFactory<BlacksmithCosts>) (count, recipe) -> new BlacksmithProducts(count, recipe)),
        new Pair<>(CarpenterCosts.class, (ItemFactory<CarpenterCosts>) (count, recipe) -> new CarpenterProducts(count, recipe)),
        new Pair<>(FishShopCosts.class, (ItemFactory<FishShopCosts>) (count, recipe) -> new FishShopProducts(count, recipe)),
        new Pair<>(GeneralStoreCosts.class, (ItemFactory<GeneralStoreCosts>) (count, recipe) -> new GeneralStoreProducts(count, recipe)),
        new Pair<>(JojaMartCosts.class, (ItemFactory<JojaMartCosts>) (count, recipe) -> new JojaMartProducts(count, recipe)),
        new Pair<>(RanchCosts.class, (ItemFactory<RanchCosts>) (count, recipe) -> new RanchProducts(count, recipe)),
        new Pair<>(SaloonCosts.class, (ItemFactory<SaloonCosts>) (count, recipe) -> new SaloonProducts(count, recipe))
    );
    
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
        
        int chance;
        if (App.getCurrentGame().getCurrentPlayer().getMap().hasScareCrow()) chance = 8;
        else chance = 4;

        int randomNumber = random.nextInt(chance);
        if (randomNumber == 0) {
            GameMenu.printResult("You are under attack by CROWS!");
            randomNumber = random.nextInt(3) + 1;

            ArrayList<Item> products = App.getCurrentGame().getCurrentPlayer().getProducts();
            for (int i = 0; i < randomNumber; i++) {
                GameMenu.printResult("You loose " + products.get(i).getCount() + " " + products.get(i).getName());
                products.remove(i);
            }
        }
    }

    public static <T> String printingShopProducts(String name, T[] list) {
        StringBuilder sb = new StringBuilder();

        sb.append(name + " Products: ");
        
        for (int i = 0; i < list.length; i++) {
            sb.append(list[i]);
            if (i < list.length - 1) {
                sb.append("-");
            } else {
                sb.append("\n");
            }
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
}
