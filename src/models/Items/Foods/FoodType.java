package models.Items.Foods;

import java.util.ArrayList;
import java.util.List;

import models.Items.Item;
import models.Items.ItemsInteface;

public enum FoodType implements ItemsInteface {
    FRIED_EGG("fried egg", new ArrayList<>(List.of(new Item(1, "egg", 0))), 50, "-", "starter", 35),
    BAKED_FISH("baked fish", new ArrayList<>(List.of(new Item(1, "sardine", 0), new Item(1, "salmon", 0), new Item(1, "wheat", 0))), 75, "-", "starter", 100),
    SALAD("salad", new ArrayList<>(List.of(new Item(1, "leek", 0), new Item(1, "dandelion", 0))), 113, "-", "starter", 110),
    OLMELET("olmelet", new ArrayList<>(List.of(new Item(1, "egg", 0), new Item(1, "milk", 0))), 100, "-", "stardrop saloon", 125),
    PUMPKIN_PIE("pumpkin pie", new ArrayList<>(List.of(new Item(1, "pumpkin", 0), new Item(1, "wheat flour", 0), new Item(1, "milk", 0), new Item(1, "sugar", 0))), 225, "-", "stardrop saloon", 385),
    SPAGHETTI("spaghetti", new ArrayList<>(List.of(new Item(1, "wheat flour", 0), new Item(1, "tomato", 0))), 75, "-", "stardrop saloon", 120),
    PIZZA("pizza", new ArrayList<>(List.of(new Item(1, "wheat flour", 0), new Item(1, "tomato", 0), new Item(1, "cheese", 0))), 150, "-", "stardrop saloon", 300),
    TORTILLA("tortilla", new ArrayList<>(List.of(new Item(1, "corn", 0))), 50, "-", "stardrop saloon", 50),
    MAKI_ROLL("maki roll", new ArrayList<>(List.of(new Item(1, "any fish", 0), new Item(1, "rice", 0), new Item(1, "fiber", 0))), 100, "-", "stardrop saloon", 220),
    TRIPLE_SHOT_ESPRESSO("triple shot espresso", new ArrayList<>(List.of(new Item(3, "coffee", 0))), 200, "Max Energy +100 (5 hours)", "stardrop saloon", 450),
    COOKIE("cookie", new ArrayList<>(List.of(new Item(1, "wheat flour", 0), new Item(1, "sugar", 0), new Item(1, "egg", 0))), 90, "-", "stardrop saloon", 140),
    HASH_BROWNS("hash browns", new ArrayList<>(List.of(new Item(1, "potato", 0), new Item(1, "oil", 0))), 90, "Farming (5 hours)", "stardrop saloon", 120),
    PANCAKES("pancakes", new ArrayList<>(List.of(new Item(1, "wheat flour", 0), new Item(1, "egg", 0))), 90, "Foraging (11 hours)", "stardrop saloon", 80),
    FRUIT_SALAD("fruit salad", new ArrayList<>(List.of(new Item(1, "blueberry", 0), new Item(1, "melon", 0), new Item(1, "apricot", 0))), 263, "-", "stardrop saloon", 450),
    RED_PLATE("red plate", new ArrayList<>(List.of(new Item(1, "red cabbage", 0), new Item(1, "radish", 0))), 240, "Max Energy +50 (3 hours)", "stardrop saloon", 400),
    BREAD("bread", new ArrayList<>(List.of(new Item(1, "wheat flour", 0))), 50, "-", "stardrop saloon", 60),
    SALMON_DINNER("salmon dinner", new ArrayList<>(List.of(new Item(1, "salmon", 0), new Item(1, "amaranth", 0), new Item(1, "kale", 0))), 125, "-", "Leah reward", 300),
    VEGETABLE_MEDLEY("vegetable medley", new ArrayList<>(List.of(new Item(1, "tomato", 0), new Item(1, "beet", 0))), 165, "-", "Foraging Level 2", 120),
    FARMERS_LUNCH("farmer's lunch", new ArrayList<>(List.of(new Item(1, "omelet", 0), new Item(1, "parsnip", 0))), 200, "Farming (5 hours)", "Farming level 1", 150),
    SURVIVAL_BURGER("survival burger", new ArrayList<>(List.of(new Item(1, "bread", 0), new Item(1, "carrot", 0), new Item(1, "eggplant", 0))), 125, "Foraging (5 hours)", "Foraging level 3", 180),
    DISH_O_THE_SEA("dish o' the sea", new ArrayList<>(List.of(new Item(2, "sardine", 0), new Item(1, "hash browns", 0))), 150, "Fishing (5 hours)", "Fishing level 2", 220),
    SEAFORM_PUDDING("seaform pudding", new ArrayList<>(List.of(new Item(1, "flounder", 0), new Item(1, "midnight carp", 0))), 175, "Fishing (10 hours)", "Fishing level 3", 300),
    MINERS_TREAT("Miner's Treat", new ArrayList<>(List.of(new Item(2, "carrot", 0), new Item(1, "sugar", 0), new Item(1, "milk", 0))), 125, "Mining (5 hours)", "Mining level 1", 200);


    private final String name;
    private final ArrayList<Item> ingredients;
    private final int energy;
    private final String buff;
    private final String source;
    private final int sellPrice;

    private FoodType(String name, ArrayList<Item> ingredients, int energy, String buff, String source, int sellPrice) {
        this.name = name;
        this.ingredients = ingredients;
        this.energy = energy;
        this.buff = buff;
        this.source = source;
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
    }
    public ArrayList<Item> getIngredients() {
        return ingredients;
    }
    public int getEnergy() {
        return energy;
    }
    public String getBuff() {
        return buff;
    }
    public String getSource() {
        return source;
    }
    public int getSellPrice() {
        return sellPrice;
    }

    public static FoodType getrecipeByName(String name) {
        for (FoodType recipe : FoodType.values()) {
            if (recipe.name.equals(name)) return recipe;
        }

        return null;
    }
}
