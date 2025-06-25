package AP.group30.StardewValley.models.Items.ArtisanGoods;

import java.util.ArrayList;
import java.util.List;

import AP.group30.StardewValley.models.Animals.FishType;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProductType;
import AP.group30.StardewValley.models.Items.Products.CropType;

public enum ArtisanGoodType implements ItemsInteface {
    HONEY("honey", "It's a sweet syrup produced by bees.", 75, 4 * 13, new ArrayList<>(), 350, IndustrialProductType.BEE_HOUSE),
    CHEESE("cheese", "It's your basic cheese.", 100, 3, new ArrayList<>(List.of(
        new Item(1, "milk", 0),
        new Item(1, "large milk", 0)
    )), 230, IndustrialProductType.CHEESE_PRESS),
    GOAT_CHEESE("goat cheese", "Soft cheese made from goat's milk.", 100, 3, new ArrayList<>(List.of(
        new Item(1, "goat milk", 0),
        new Item(1, "Large Goat Milk", 0)
    )), 400, IndustrialProductType.CHEESE_PRESS),
    BEER("beer", "Drink in moderation.", 50, 1 * 13, new ArrayList<>(List.of(new Item(1, "wheat", 0))), 200, IndustrialProductType.KEG),
    VINEGAR("vinegar", "An aged fermented liquid used in many cooking recipes.", 13, 10, new ArrayList<>(List.of(new Item(1, "rice", 0))), 100, IndustrialProductType.KEG),
    COFFEE("coffee", "It smells delicious. This is sure to give you a boost.", 75, 2, new ArrayList<>(List.of(new Item(5, "coffee bean", 0))), 150, IndustrialProductType.KEG),
    JUICE("juice", "A sweet, nutritious beverage.", 2 * CropType.GRAPE.getEnergy(), 4 * 13, new ArrayList<>(List.of(new Item(1, "grape", 0))), 2.25 * CropType.GRAPE.getBaseSellPrice(), IndustrialProductType.KEG),
    MEAD("mead", "A fermented beverage made from honey.\nDrink in moderation.", 100, 10, new ArrayList<>(List.of(new Item(1, "honey", 0))), 300, IndustrialProductType.KEG),
    PALE_ALE("pale ale", "Drink in moderation.", 50, 3 * 13, new ArrayList<>(List.of(new Item(1, "hops", 0))), 300, IndustrialProductType.KEG),
    WINE("wine", "Drink in moderation.", 1.75 * CropType.TOMATO.getEnergy(), 7 * 13, new ArrayList<>(List.of(new Item(1, "tomato", 0))), 3 * CropType.TOMATO.getBaseSellPrice(), IndustrialProductType.KEG),
    DRIED_MUSHROOMS("dried mushrooms", "A package of gourmet mushrooms.", 50, 13, new ArrayList<>(List.of(new Item(5, "mushroom", 0))), CropType.MUSHROOM.getBaseSellPrice() + 25, IndustrialProductType.DEHYDRATOR),
    DRIED_FRUIT("dried fruit", "Chewy pieces of dried fruit.", 75, 13, new ArrayList<>(List.of(new Item(5, "tomato", 0))), CropType.TOMATO.getBaseSellPrice() * 25, IndustrialProductType.DEHYDRATOR),
    RAISINS("raisins", "It's said to be the Junimos' favorite food.", 125, 13, new ArrayList<>(List.of(new Item(5, "grapes", 0))), 600, IndustrialProductType.DEHYDRATOR),
    COAL("coal", "Turns 10 pieces of wood into one piece of coal.", 0, 1, new ArrayList<>(List.of(new Item(10, "wood", 0))), 50, IndustrialProductType.CHARCOAL_KILN),
    CLOTH("cloth", "A bolt of fine wool cloth.", 0, 4, new ArrayList<>(List.of(new Item(1, "wool", 0))), 470, IndustrialProductType.LOOM),
    MAYONNAISE("mayonnaise", "It looks spreadable.", 50, 3, new ArrayList<>(List.of(
        new Item(1, "egg", 0),
        new Item(1, "large egg", 0)
    )), 190, IndustrialProductType.MAYONNAISE_MACHINE),
    DUCK_MAYONNAISE("duck mayonnaise", "It's a rich, yellow mayonnaise.", 75, 3, new ArrayList<>(List.of(new Item(1, "duck egg", 0))), 37, IndustrialProductType.MAYONNAISE_MACHINE),
    DINOSAUR_MAYONNAISE("dinosaur mayonnaise", "It's thick and creamy, with a vivid green hue.\nIt smells like grass and leather.", 125, 3, new ArrayList<>(List.of(new Item(1, "dinosaur egg", 0))), 800, IndustrialProductType.MAYONNAISE_MACHINE),
    TRUFFLE_OIL("truffle oil", "A gourmet cooking ingredient.", 38, 6, new ArrayList<>(List.of(new Item(1, "truffle", 0))), 1065, IndustrialProductType.OIL_MAKER),
    OIL("oil", "All purpose cooking oil.", 13, 1 * 13, new ArrayList<>(List.of(
        new Item(1, "corn", 0),
        new Item(1, "sunflower seeds", 0),
        new Item(1, "sunflower", 0)
    )), 100, IndustrialProductType.OIL_MAKER),
    PICKLES("pickles", "A jar of your home-made pickles.", 1.75 * CropType.PUMPKIN.getEnergy(), 6, new ArrayList<>(List.of(new Item(1, "pumpkin", 0))), 2 * CropType.PUMPKIN.getEnergy() + 50, IndustrialProductType.PRESERVES_JAR),
    JELLY("jelly", "Gooey.", CropType.CARROT.getEnergy() * 2, 3 * 13, new ArrayList<>(List.of(new Item(1, "carrot", 0))), CropType.CARROT.getBaseSellPrice() + 50, IndustrialProductType.PRESERVES_JAR),
    SMOKED_FISH("smoked fish", "A whole fish, smoked to perfection.", 60, 1, new ArrayList<>(List.of(
        new Item(1, "salmon", 0),
        new Item(1, "coal", 0)
    )), 2 * FishType.SALMON.getBasePrice(), IndustrialProductType.FISH_SMOKER),
    METAL_BAR("any metal bar", "Turns ore and coal into metal bars.", 0, 4, new ArrayList<>(List.of(
        new Item(5, "stone", 0),
        new Item(1, "coal", 0)
    )), 25, IndustrialProductType.FURNACE);


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
