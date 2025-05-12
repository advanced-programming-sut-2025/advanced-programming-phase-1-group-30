package models.Items.ArtisanGoods;

import java.util.ArrayList;
import java.util.List;

import models.Items.Item;
import models.Items.IndustrialProducts.IndustrialProductType;

public enum ArtisanGoodType {
    HONEY("Honey", "It's a sweet syrup produced by bees.", 75, 4 * 24, new ArrayList<>(), 350, IndustrialProductType.BEE_HOUSE),
    CHEESE("Cheese", "It's your basic cheese.", 100, 3, new ArrayList<>(List.of(
        new Item(1, "Milk", 0),
        new Item(1, "Large Milk", 0)
    )), 230, IndustrialProductType.CHEESE_PRESS),
    GOAT_CHEESE("Goat Cheese", "Soft cheese made from goat's milk.", 100, 3, new ArrayList<>(List.of(
        new Item(1, "Goat Milk", 0),
        new Item(1, "Large Goat Milk", 0)
    )), 400, IndustrialProductType.CHEESE_PRESS),
    BEER("Beer", "Drink in moderation.", 50, 1 * 24, new ArrayList<>(List.of(new Item(1, "Wheat", 0))), 200, IndustrialProductType.KEG),
    VINEGAR("Vinegar", "An aged fermented liquid used in many cooking recipes.", 13, 10, new ArrayList<>(List.of(new Item(1, "Rice", 0))), 100, IndustrialProductType.KEG),
    COFFEE("Coffee", "It smells delicious. This is sure to give you a boost.", 75, 2, new ArrayList<>(List.of(new Item(5, "Coffee Bean", 0))), 150, IndustrialProductType.KEG),
    JUICE("Juice", "A sweet, nutritious beverage.", 2, 4 * 24, new ArrayList<>(List.of(new Item(1, "Any Vegetable", 0))), 2.25, IndustrialProductType.KEG),
    MEAD("Mead", "A fermented beverage made from honey.\nDrink in moderation.", 100, 10, new ArrayList<>(List.of(new Item(1, "Honey", 0))), 300, IndustrialProductType.KEG),
    PALE_ALE("Pale Ale", "Drink in moderation.", 50, 3 * 24, new ArrayList<>(List.of(new Item(1, "Hops", 0))), 300, IndustrialProductType.KEG),
    WINE("Wine", "Drink in moderation.", 1.75, 7 * 24, new ArrayList<>(List.of(new Item(1, "Any Fruit", 0))), 3, IndustrialProductType.KEG),
    DRIED_MUSHROOMS("Dried Mushrooms", "A package of gourmet mushrooms.", 50, 24, new ArrayList<>(List.of(new Item(5, "Any Mushroom", 0))), 25, IndustrialProductType.DEHYDRATOR),
    DRIED_FRUIT("Dried Fruit", "Chewy pieces of dried fruit.", 75, 24, new ArrayList<>(List.of(new Item(5, "Any Fruit (except Grapes)", 0))), 25, IndustrialProductType.DEHYDRATOR),
    RAISINS("Raisins", "It's said to be the Junimos' favorite food.", 125, 24, new ArrayList<>(List.of(new Item(5, "Grapes", 0))), 600, IndustrialProductType.DEHYDRATOR),
    COAL("Coal", "Turns 10 pieces of wood into one piece of coal.", 0, 1, new ArrayList<>(List.of(new Item(10, "Wood", 0))), 50, IndustrialProductType.CHARCOAL_KILN),
    CLOTH("Cloth", "A bolt of fine wool cloth.", 0, 4, new ArrayList<>(List.of(new Item(1, "Wool", 0))), 470, IndustrialProductType.LOOM),
    MAYONNAISE("Mayonnaise", "It looks spreadable.", 50, 3, new ArrayList<>(List.of(
        new Item(1, "Egg", 0),
        new Item(1, "Large Egg", 0)
    )), 190, IndustrialProductType.MAYONNAISE_MACHINE),
    DUCK_MAYONNAISE("Duck Mayonnaise", "It's a rich, yellow mayonnaise.", 75, 3, new ArrayList<>(List.of(new Item(1, "Duck Egg", 0))), 37, IndustrialProductType.MAYONNAISE_MACHINE),
    DINOSAUR_MAYONNAISE("Dinosaur Mayonnaise", "It's thick and creamy, with a vivid green hue.\nIt smells like grass and leather.", 125, 3, new ArrayList<>(List.of(new Item(1, "Dinosaur Egg", 0))), 800, IndustrialProductType.MAYONNAISE_MACHINE),
    TRUFFLE_OIL("Truffle Oil", "A gourmet cooking ingredient.", 38, 6, new ArrayList<>(List.of(new Item(1, "Truffle", 0))), 1065, IndustrialProductType.OIL_MAKER),
    OIL("Oil", "All purpose cooking oil.", 13, 1 * 24, new ArrayList<>(List.of(
        new Item(1, "Corn", 0),
        new Item(1, "Sunflower Seeds", 0),
        new Item(1, "Sunflower", 0)
    )), 100, IndustrialProductType.OIL_MAKER),
    PICKLES("Pickles", "A jar of your home-made pickles.", 1.75, 6, new ArrayList<>(List.of(new Item(1, "Any Vegetable", 0))), 50, IndustrialProductType.PRESERVES_JAR),
    JELLY("Jelly", "Gooey.", 2, 3 * 24, new ArrayList<>(List.of(new Item(1, "Any Fruit", 0))), 50, IndustrialProductType.PRESERVES_JAR),
    SMOKED_FISH("Smoked Fish", "A whole fish, smoked to perfection.", 1.5, 1, new ArrayList<>(List.of(
        new Item(1, "Any Fish", 0),
        new Item(1, "Coal", 0)
    )), 2, IndustrialProductType.FISH_SMOKER),
    METAL_BAR("Any metal bar", "Turns ore and coal into metal bars.", 0, 4, new ArrayList<>(List.of(
        new Item(5, "Any Ore", 0),
        new Item(1, "Coal", 0)
    )), 2, IndustrialProductType.FURNACE);


    private final String name;
	private final String description;
	private final double energy;
    private final int processingTime;
    private final ArrayList<Item> ingredients;
    private final double sellPrice;
    private final IndustrialProductType source;

    private ArtisanGoodType(String name, String description, double energy, int processingTime,
            ArrayList<Item> ingredients, double sellPrice, IndustrialProductType source) {
        this.name = name;
        this.description = description;
        this.energy = energy;
        this.processingTime = processingTime;
        this.ingredients = ingredients;
        this.sellPrice = sellPrice;
        this.source = source;
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
    public IndustrialProductType getSource() {
        return source;
    }
}
