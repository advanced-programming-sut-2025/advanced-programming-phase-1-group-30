package AP.group30.StardewValley.models.Items.ArtisanGoods;

import java.util.ArrayList;
import java.util.List;

import AP.group30.StardewValley.models.Animals.FishType;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProductType;
import AP.group30.StardewValley.models.Items.Products.CropType;
import com.badlogic.gdx.graphics.Texture;

public enum ArtisanGoodType implements ItemsInteface {
    HONEY("honey", "It's a sweet syrup produced by bees.", 75, 4 * 13, new ArrayList<>(), 350, IndustrialProductType.BEE_HOUSE, ItemTexture.WOOD.getTexture()),
    CHEESE("cheese", "It's your basic cheese.", 100, 3, new ArrayList<>(List.of(
        new Item(1, "milk", 0, ItemTexture.WOOD.getTexture()),
        new Item(1, "large milk", 0, ItemTexture.WOOD.getTexture())
    )), 230, IndustrialProductType.CHEESE_PRESS, ItemTexture.WOOD.getTexture()),
    GOAT_CHEESE("goat cheese", "Soft cheese made from goat's milk.", 100, 3, new ArrayList<>(List.of(
        new Item(1, "goat milk", 0, ItemTexture.WOOD.getTexture()),
        new Item(1, "Large Goat Milk", 0, ItemTexture.WOOD.getTexture())
    )), 400, IndustrialProductType.CHEESE_PRESS, ItemTexture.WOOD.getTexture()),
    BEER("beer", "Drink in moderation.", 50, 1 * 13, new ArrayList<>(List.of(new Item(1, "wheat", 0, ItemTexture.WOOD.getTexture()))), 200, IndustrialProductType.KEG, ItemTexture.WOOD.getTexture()),
    VINEGAR("vinegar", "An aged fermented liquid used in many cooking recipes.", 13, 10, new ArrayList<>(List.of(new Item(1, "rice", 0, ItemTexture.WOOD.getTexture()))), 100, IndustrialProductType.KEG, ItemTexture.WOOD.getTexture()),
    COFFEE("coffee", "It smells delicious. This is sure to give you a boost.", 75, 2, new ArrayList<>(List.of(new Item(5, "coffee bean", 0, ItemTexture.WOOD.getTexture()))), 150, IndustrialProductType.KEG, ItemTexture.WOOD.getTexture()),
    JUICE("juice", "A sweet, nutritious beverage.", 2 * CropType.GRAPE.getEnergy(), 4 * 13, new ArrayList<>(List.of(new Item(1, "grape", 0, ItemTexture.WOOD.getTexture()))), (int)2.25 * CropType.GRAPE.getPrice(), IndustrialProductType.KEG, ItemTexture.WOOD.getTexture()),
    MEAD("mead", "A fermented beverage made from honey.\nDrink in moderation.", 100, 10, new ArrayList<>(List.of(new Item(1, "honey", 0, ItemTexture.WOOD.getTexture()))), 300, IndustrialProductType.KEG, ItemTexture.WOOD.getTexture()),
    PALE_ALE("pale ale", "Drink in moderation.", 50, 3 * 13, new ArrayList<>(List.of(new Item(1, "hops", 0, ItemTexture.WOOD.getTexture()))), 300, IndustrialProductType.KEG, ItemTexture.WOOD.getTexture()),
    WINE("wine", "Drink in moderation.", 1.75 * CropType.TOMATO.getEnergy(), 7 * 13, new ArrayList<>(List.of(new Item(1, "tomato", 0, ItemTexture.WOOD.getTexture()))), 3 * CropType.TOMATO.getPrice(), IndustrialProductType.KEG, ItemTexture.WOOD.getTexture()),
    DRIED_MUSHROOMS("dried mushrooms", "A package of gourmet mushrooms.", 50, 13, new ArrayList<>(List.of(new Item(5, "mushroom", 0, ItemTexture.WOOD.getTexture()))), CropType.MUSHROOM.getPrice() + 25, IndustrialProductType.DEHYDRATOR, ItemTexture.WOOD.getTexture()),
    DRIED_FRUIT("dried fruit", "Chewy pieces of dried fruit.", 75, 13, new ArrayList<>(List.of(new Item(5, "tomato", 0, ItemTexture.WOOD.getTexture()))), CropType.TOMATO.getPrice() * 25, IndustrialProductType.DEHYDRATOR, ItemTexture.WOOD.getTexture()),
    RAISINS("raisins", "It's said to be the Junimos' favorite food.", 125, 13, new ArrayList<>(List.of(new Item(5, "grapes", 0, ItemTexture.WOOD.getTexture()))), 600, IndustrialProductType.DEHYDRATOR, ItemTexture.WOOD.getTexture()),
    COAL("coal", "Turns 10 pieces of wood into one piece of coal.", 0, 1, new ArrayList<>(List.of(new Item(10, "wood", 0, ItemTexture.WOOD.getTexture()))), 50, IndustrialProductType.CHARCOAL_KILN, ItemTexture.WOOD.getTexture()),
    CLOTH("cloth", "A bolt of fine wool cloth.", 0, 4, new ArrayList<>(List.of(new Item(1, "wool", 0, ItemTexture.WOOD.getTexture()))), 470, IndustrialProductType.LOOM, ItemTexture.WOOD.getTexture()),
    MAYONNAISE("mayonnaise", "It looks spreadable.", 50, 3, new ArrayList<>(List.of(
        new Item(1, "egg", 0, ItemTexture.WOOD.getTexture()),
        new Item(1, "large egg", 0, ItemTexture.WOOD.getTexture())
    )), 190, IndustrialProductType.MAYONNAISE_MACHINE, ItemTexture.WOOD.getTexture()),
    DUCK_MAYONNAISE("duck mayonnaise", "It's a rich, yellow mayonnaise.", 75, 3, new ArrayList<>(List.of(new Item(1, "duck egg", 0, ItemTexture.WOOD.getTexture()))), 37, IndustrialProductType.MAYONNAISE_MACHINE, ItemTexture.WOOD.getTexture()),
    DINOSAUR_MAYONNAISE("dinosaur mayonnaise", "It's thick and creamy, with a vivid green hue.\nIt smells like grass and leather.", 125, 3, new ArrayList<>(List.of(new Item(1, "dinosaur egg", 0, ItemTexture.WOOD.getTexture()))), 800, IndustrialProductType.MAYONNAISE_MACHINE, ItemTexture.WOOD.getTexture()),
    TRUFFLE_OIL("truffle oil", "A gourmet cooking ingredient.", 38, 6, new ArrayList<>(List.of(new Item(1, "truffle", 0, ItemTexture.WOOD.getTexture()))), 1065, IndustrialProductType.OIL_MAKER, ItemTexture.WOOD.getTexture()),
    OIL("oil", "All purpose cooking oil.", 13, 1 * 13, new ArrayList<>(List.of(
        new Item(1, "corn", 0, ItemTexture.WOOD.getTexture()),
        new Item(1, "sunflower seeds", 0, ItemTexture.WOOD.getTexture()),
        new Item(1, "sunflower", 0, ItemTexture.WOOD.getTexture())
    )), 100, IndustrialProductType.OIL_MAKER, ItemTexture.WOOD.getTexture()),
    PICKLES("pickles", "A jar of your home-made pickles.", 1.75 * CropType.PUMPKIN.getEnergy(), 6, new ArrayList<>(List.of(new Item(1, "pumpkin", 0, ItemTexture.WOOD.getTexture()))), 2 * CropType.PUMPKIN.getEnergy() + 50, IndustrialProductType.PRESERVES_JAR, ItemTexture.WOOD.getTexture()),
    JELLY("jelly", "Gooey.", CropType.CARROT.getEnergy() * 2, 3 * 13, new ArrayList<>(List.of(new Item(1, "carrot", 0, ItemTexture.WOOD.getTexture()))), CropType.CARROT.getPrice() + 50, IndustrialProductType.PRESERVES_JAR, ItemTexture.WOOD.getTexture()),
    SMOKED_FISH("smoked fish", "A whole fish, smoked to perfection.", 60, 1, new ArrayList<>(List.of(
        new Item(1, "salmon", 0, ItemTexture.WOOD.getTexture()),
        new Item(1, "coal", 0, ItemTexture.WOOD.getTexture())
    )), 2 * FishType.SALMON.getBasePrice(), IndustrialProductType.FISH_SMOKER, ItemTexture.WOOD.getTexture()),
    METAL_BAR("any metal bar", "Turns ore and coal into metal bars.", 0, 4, new ArrayList<>(List.of(
        new Item(5, "stone", 0, ItemTexture.WOOD.getTexture()),
        new Item(1, "coal", 0, ItemTexture.WOOD.getTexture())
    )), 25, IndustrialProductType.FURNACE, ItemTexture.WOOD.getTexture());


    private final String name;
	private final String description;
	private final double energy;
    private final int processingTime;
    private final ArrayList<Item> ingredients;
    private final int sellPrice;
    private final IndustrialProductType source;
    private final Texture texture;

    private ArtisanGoodType(String name, String description, double energy, int processingTime,
            ArrayList<Item> ingredients, int sellPrice, IndustrialProductType source,
                            Texture texture) {
        this.name = name;
        this.description = description;
        this.energy = energy;
        this.processingTime = processingTime;
        this.ingredients = ingredients;
        this.sellPrice = sellPrice;
        this.source = source;
        this.texture = texture;
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
    public int getPrice() {
        return sellPrice;
    }
    public IndustrialProductType getSource() {
        return source;
    }
    public Texture getTexture() {
        return texture;
    }
}
