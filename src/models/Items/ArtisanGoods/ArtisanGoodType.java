package models.Items.ArtisanGoods;

import java.util.ArrayList;

import models.Items.Item;

public enum ArtisanGoodType {
    HONEY("Honey", "It's a sweet syrup produced by bees.", 75, 4 * 24, null, 350),
    CHEESE("Cheese", "It's your basic cheese.", 100, 3, null, 230),
    GOAT_CHEESE("Goat Cheese", "Soft cheese made from goat's milk.", 10075, 3, null, 400),
    BEER("Beer", "Drink in moderation.", 50, 1 * 24, null, 200),
    VINEGAR("Vinegar", "An aged fermented liquid used in many cooking recipes.", 13, 10, null, 100),
    COFFEE("Coffee", "It smells delicious. This is sure to give you a boost.", 75, 2, null, 150),
    JUICE("Juice", "A sweet, nutritious beverage.", 2 * 1, 4 * 24, null, 2.25 * 1), //TODO
    MEAD("Mead", "A fermented beverage made from honey.\nDrink in moderation.", 100, 10, null, 300),
    PALE_ALE("Pale Ale", "Drink in moderation.", 50, 3 * 24, null, 300),
    WINE("Wine", "Drink in moderation.", 1.75 * 1, 7 * 24, null, 3 * 1), //TODO
    DRIED_MUSHROOMS("Dried Mushrooms", "A package of gourmet mushrooms.", 50, 1 * 24, null, 7.5 * 1 + 25), //TODO
    DRIED_FRUIT("Dried Fruit", "Chewy pieces of dried fruit.", 75, 1 * 24, null, 7.5 * 1+ 25), //TODO
    RAISINS("Raisins", "It's said to be the Junimos' favorite food.", 125, 1 * 24, null, 600),
    COAL("Coal", "Turns 10 pieces of wood into one piece of coal.", 0, 1, null, 50);

    private final String name;
	private final String description;
	private final double energy;
    private final int processingTime;
    private final ArrayList<Item> ingredients;
    private final double sellPrice;

    private ArtisanGoodType(String name, String description, double energy, int processingTime,
            ArrayList<Item> ingredients, double sellPrice) {
        this.name = name;
        this.description = description;
        this.energy = energy;
        this.processingTime = processingTime;
        this.ingredients = ingredients;
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getEnergy() {
        return energy;
    }
    public int getProcessingTime() {
        return processingTime;
    }
    public ArrayList<Item> getIngredients() {
        return ingredients;
    }
    public double getSellPrice() {
        return sellPrice;
    }
}
