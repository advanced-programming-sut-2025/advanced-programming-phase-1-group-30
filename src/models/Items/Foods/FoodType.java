package models.Items.Foods;

import java.util.ArrayList;
import java.util.List;

import models.Items.Item;

public enum FoodType {
    FRIED_EGG("Fried egg", new ArrayList<>(List.of(new Item(1, "Egg", 0))), 50, "-", "Starter", 35),
    BAKED_FISH("Baked Fish", new ArrayList<>(List.of(new Item(1, "Sardine", 0), new Item(1, "Salmon", 0), new Item(1, "Wheat", 0))), 75, "-", "Starter", 100),
    SALAD("Salad", new ArrayList<>(List.of(new Item(1, "Leek", 0), new Item(1, "Dandelion", 0))), 113, "-", "Starter", 110),
    OLMELET("Olmelet", new ArrayList<>(List.of(new Item(1, "Egg", 0), new Item(1, "Milk", 0))), 100, "-", "Stardrop Saloon", 125),
    PUMPKIN_PIE("Pumpkin Pie", new ArrayList<>(List.of(new Item(1, "Pumpkin", 0), new Item(1, "Wheat Flour", 0), new Item(1, "Milk", 0), new Item(1, "Sugar", 0))), 225, "-", "Stardrop Saloon", 385),
    SPAGHETTI("Spaghetti", new ArrayList<>(List.of(new Item(1, "Wheat Flour", 0), new Item(1, "Tomato", 0))), 75, "-", "Stardrop Saloon", 120),
    PIZZA("Pizza", new ArrayList<>(List.of(new Item(1, "Wheat Flour", 0), new Item(1, "Tomato", 0), new Item(1, "Cheese", 0))), 150, "-", "Stardrop Saloon", 300),
    TORTILLA("Tortilla", new ArrayList<>(List.of(new Item(1, "Corn", 0))), 50, "-", "Stardrop Saloon", 50),
    MAKI_ROLL("Maki Roll", new ArrayList<>(List.of(new Item(1, "Any Fish", 0), new Item(1, "Rice", 0), new Item(1, "Fiber", 0))), 100, "-", "Stardrop Saloon", 220),
    TRIPLE_SHOT_ESPRESSO("Triple Shot Espresso", new ArrayList<>(List.of(new Item(3, "Coffee", 0))), 200, "Max Energy +100 (5 hours)", "Stardrop Saloon", 450),
    COOKIE("Cookie", new ArrayList<>(List.of(new Item(1, "Wheat Flour", 0), new Item(1, "Sugar", 0), new Item(1, "Egg", 0))), 90, "-", "Stardrop Saloon", 140),
    HASH_BROWNS("Hash Browns", new ArrayList<>(List.of(new Item(1, "Potato", 0), new Item(1, "Oil", 0))), 90, "Farming (5 hours)", "Stardrop Saloon", 120),
    PANCAKES("Pancakes", new ArrayList<>(List.of(new Item(1, "Wheat Flour", 0), new Item(1, "Egg", 0))), 90, "Foraging (11 hours)", "Stardrop Saloon", 80),
    FRUIT_SALAD("Fruit Salad", new ArrayList<>(List.of(new Item(1, "Blueberry", 0), new Item(1, "Melon", 0), new Item(1, "Apricot", 0))), 263, "-", "Stardrop Saloon", 450),
    RED_PLATE("Red Plate", new ArrayList<>(List.of(new Item(1, "Red Cabbage", 0), new Item(1, "Radish", 0))), 240, "Max Energy +50 (3 hours)", "Stardrop Saloon", 400),
    BREAD("Bread", new ArrayList<>(List.of(new Item(1, "Wheat Flour", 0))), 50, "-", "Stardrop Saloon", 60),
    SALMON_DINNER("Salmon Dinner", new ArrayList<>(List.of(new Item(1, "Salmon", 0), new Item(1, "Amaranth", 0), new Item(1, "Kale", 0))), 125, "-", "Leah reward", 300),
    VEGETABLE_MEDLEY("Vegetable Medley", new ArrayList<>(List.of(new Item(1, "Tomato", 0), new Item(1, "Beet", 0))), 165, "-", "Foraging Level 2", 120),
    FARMERS_LUNCH("Farmer's Lunch", new ArrayList<>(List.of(new Item(1, "Omelet", 0), new Item(1, "Parsnip", 0))), 200, "Farming (5 hours)", "Farming level 1", 150),
    SURVIVAL_BURGER("Survival Burger", new ArrayList<>(List.of(new Item(1, "Bread", 0), new Item(1, "Carrot", 0), new Item(1, "Eggplant", 0))), 125, "Foraging (5 hours)", "Foraging level 3", 180),
    DISH_O_THE_SEA("Dish O' the Sea", new ArrayList<>(List.of(new Item(2, "Sardine", 0), new Item(1, "Hash Browns", 0))), 150, "Fishing (5 hours)", "Fishing level 2", 220),
    SEAFORM_PUDDING("Seaform Pudding", new ArrayList<>(List.of(new Item(1, "Flounder", 0), new Item(1, "Midnight Carp", 0))), 175, "Fishing (10 hours)", "Fishing level 3", 300),
    MINERS_TREAT("Miner's Treat", new ArrayList<>(List.of(new Item(2, "Carrot", 0), new Item(1, "Sugar", 0), new Item(1, "Milk", 0))), 125, "Mining (5 hours)", "Mining level 1", 200);


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
