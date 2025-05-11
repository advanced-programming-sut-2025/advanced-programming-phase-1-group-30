package models.Items.Foods;

import java.util.ArrayList;

import models.Items.Item;

public enum FoodType {
    FRIED_EGG("Fried egg", null, 50, "-", "Starter", 35),
    BAKED_FISH("Baked Fish", null, 75, "-", "Starter", 100),
    SALAD("Salad", null, 113, "-", "Starter", 110),
    OLMELET("Olmelet", null, 100, "-", "Stardrop Saloon", 125),
    PUMPKIN_PIE("pumpkin pie", null, 225, "-", "Stardrop Saloon", 385),
    SPAGHETTI("spaghetti", null, 75, "-", "Stardrop Saloon", 120),
    PIZZA("pizza", null, 150, "-", "Stardrop Saloon", 300),
    TORTILLA("Tortilla", null, 50, "-", "Stardrop Saloon", 50),
    MAKI_ROLL("Maki Roll", null, 100, "-", "Stardrop Saloon", 220),
    TRIPLE_SHOT_ESPRESSO("Triple Shot Espresso", null, 200, "-", "Stardrop Saloon", 450),
    COOKIE("Cookie", null, 90, "-", "Stardrop Saloon", 140),
    HASH_BROWNS("hash browns", null, 90, "-", "Stardrop Saloon", 120),
    PANCAKES("pancakes", null, 90, "-", "Stardrop Saloon", 80),
    FRUIT_SALAD("fruit salad", null, 263, "-", "Stardrop Saloon", 450),
    RED_PLATE("red plate", null, 240, "-", "Stardrop Saloon", 400),
    BREAD("bread", null, 50, "-", "Stardrop Saloon", 60),
    SALMON_DINNER("salmon dinner", null, 125, "-", "Leah reward", 300),
    VEGETABLE_MEDLEY("vegetable medley", null, 165, "-", "Foraging Level 2", 120),
    FARMERS_LUNCH("farmer's lunch", null, 200, "-", "Farming level 1", 150),
    SURVIVAL_BURGER("survival burger", null, 125, "-", "Foraging level 3", 180),
    DISH_O_THE_SEA("dish O' the Sea", null, 150, "-", "Fishing level 2", 220),
    SEAFOAM_PUDDING("seaform Pudding", null, 175, "-", "Fishing level 3", 300),
    MINERS_TREAT("miner's treat", null, 125, "-", "Mining level 1", 200);

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
