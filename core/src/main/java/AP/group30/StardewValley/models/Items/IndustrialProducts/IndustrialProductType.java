package AP.group30.StardewValley.models.Items.IndustrialProducts;

import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

public enum IndustrialProductType implements ItemsInteface {
    CHERRY_BOMB("cherry bomb", "Destroys everything within a 3-tile radius",
            new ArrayList<>(List.of(new Item(4, "copper ore", 0, ItemTexture.WOOD.getTexture()), new Item(1, "coal", 0, ItemTexture.WOOD.getTexture()))), 50, ItemTexture.WOOD.getTexture()),

    BOMB("bomb", "Destroys everything within a 5-tile radius",
            new ArrayList<>(List.of(new Item(4, "iron ore", 0, ItemTexture.WOOD.getTexture()), new Item(1, "coal", 0, ItemTexture.WOOD.getTexture()))), 50, ItemTexture.WOOD.getTexture()),

    MEGA_BOMB("mega bomb", "Destroys everything within a 7-tile radius",
            new ArrayList<>(List.of(new Item(4, "gold ore", 0, ItemTexture.WOOD.getTexture()), new Item(1, "coal", 0, ItemTexture.WOOD.getTexture()))), 50, ItemTexture.WOOD.getTexture()),

    SPRINKLER("sprinkler", "Water 4 adjacent tiles",
            new ArrayList<>(List.of(new Item(1, "copper bar", 0, ItemTexture.WOOD.getTexture()), new Item(1, "iron bar", 0, ItemTexture.WOOD.getTexture()))), 0, ItemTexture.WOOD.getTexture()),

    QUALITY_SPRINKLER("quality sprinkler", "Water 8 adjacent tiles",
            new ArrayList<>(List.of(new Item(1, "iron bar", 0, ItemTexture.WOOD.getTexture()), new Item(1, "gold bar", 0, ItemTexture.WOOD.getTexture()))), 0, ItemTexture.WOOD.getTexture()),

    IRIDIUM_SPRINKLER("iridium sprinkler", "Water 24 adjacent tiles",
            new ArrayList<>(List.of(new Item(1, "gold bar", 0, ItemTexture.WOOD.getTexture()), new Item(1, "iridium bar", 0, ItemTexture.WOOD.getTexture()))), 0, ItemTexture.WOOD.getTexture()),

    CHARCOAL_KILN("charcoal kiln", "Turns 10 wood into 1 coal",
            new ArrayList<>(List.of(new Item(20, "wood", 0, ItemTexture.WOOD.getTexture()), new Item(2, "copper bar", 0, ItemTexture.WOOD.getTexture()))), 0, ItemTexture.WOOD.getTexture()),

    FURNACE("furnace", "Turns ores and coal into bars",
            new ArrayList<>(List.of(new Item(20, "copper ore", 0, ItemTexture.WOOD.getTexture()), new Item(25, "stone", 0, ItemTexture.WOOD.getTexture()))), 0, ItemTexture.WOOD.getTexture()),

    SCARECROW("scarecrow", "Prevents crows from attacking within 8 tiles",
            new ArrayList<>(List.of(new Item(50, "wood", 0, ItemTexture.WOOD.getTexture()), new Item(1, "coal", 0, ItemTexture.WOOD.getTexture()), new Item(20, "fiber", 0, ItemTexture.WOOD.getTexture()))), 0, ItemTexture.WOOD.getTexture()),

    DELUXE_SCARECROW("deluxe scarecrow", "Prevents crows from attacking within 12 tiles",
            new ArrayList<>(List.of(new Item(50, "wood", 0, ItemTexture.WOOD.getTexture()), new Item(1, "coal", 0, ItemTexture.WOOD.getTexture()), new Item(20, "fiber", 0, ItemTexture.WOOD.getTexture()), new Item(1, "iridium ore", 0, ItemTexture.WOOD.getTexture()))), 0, ItemTexture.WOOD.getTexture()),

    BEE_HOUSE("bee house", "Produces honey when placed on the farm",
            new ArrayList<>(List.of(new Item(40, "wood", 0, ItemTexture.WOOD.getTexture()), new Item(8, "coal", 0, ItemTexture.WOOD.getTexture()), new Item(1, "iron bar", 0, ItemTexture.WOOD.getTexture()))), 0, ItemTexture.WOOD.getTexture()),

    CHEESE_PRESS("cheese press", "Turns milk into cheese",
            new ArrayList<>(List.of(new Item(45, "wood", 0, ItemTexture.WOOD.getTexture()), new Item(45, "stone", 0, ItemTexture.WOOD.getTexture()), new Item(1, "copper bar", 0, ItemTexture.WOOD.getTexture()))), 0, ItemTexture.WOOD.getTexture()),

    KEG("keg", "Turns fruits and vegetables into beverages",
            new ArrayList<>(List.of(new Item(30, "wood", 0, ItemTexture.WOOD.getTexture()), new Item(1, "copper bar", 0, ItemTexture.WOOD.getTexture()), new Item(1, "iron bar", 0, ItemTexture.WOOD.getTexture()))), 0, ItemTexture.WOOD.getTexture()),

    LOOM("loom", "Turns wool into cloth",
            new ArrayList<>(List.of(new Item(60, "wood", 0, ItemTexture.WOOD.getTexture()), new Item(30, "fiber", 0, ItemTexture.WOOD.getTexture()))), 0, ItemTexture.WOOD.getTexture()),

    MAYONNAISE_MACHINE("mayonnaise machine", "Turns eggs into mayonnaise",
            new ArrayList<>(List.of(new Item(15, "wood", 0, ItemTexture.WOOD.getTexture()), new Item(15, "stone", 0, ItemTexture.WOOD.getTexture()), new Item(1, "copper bar", 0, ItemTexture.WOOD.getTexture()))), 0, ItemTexture.WOOD.getTexture()),

    OIL_MAKER("oil maker", "Turns truffles into oil",
            new ArrayList<>(List.of(new Item(100, "wood", 0, ItemTexture.WOOD.getTexture()), new Item(1, "gold bar", 0, ItemTexture.WOOD.getTexture()), new Item(1, "iron bar", 0, ItemTexture.WOOD.getTexture()))), 0, ItemTexture.WOOD.getTexture()),

    PRESERVES_JAR("preserves jar", "Turns vegetables into pickles and fruits into jams",
            new ArrayList<>(List.of(new Item(50, "wood", 0, ItemTexture.WOOD.getTexture()), new Item(40, "stone", 0, ItemTexture.WOOD.getTexture()), new Item(8, "coal", 0, ItemTexture.WOOD.getTexture()))), 0, ItemTexture.WOOD.getTexture()),

    DEHYDRATOR("dehydrator", "Dries fruits or mushrooms",
            new ArrayList<>(List.of(new Item(30, "wood", 0, ItemTexture.WOOD.getTexture()), new Item(20, "stone", 0, ItemTexture.WOOD.getTexture()), new Item(30, "fiber", 0, ItemTexture.WOOD.getTexture()))), 0, ItemTexture.WOOD.getTexture()),

    GRASS_STARTER("grass starter", "Plant it on the ground to grow grass",
            new ArrayList<>(List.of(new Item(1, "wood", 0, ItemTexture.WOOD.getTexture()), new Item(1, "fiber", 0, ItemTexture.WOOD.getTexture()))), 0, ItemTexture.WOOD.getTexture()),

    FISH_SMOKER("fish smoker", "Turns any fish into smoked fish while preserving its quality",
            new ArrayList<>(List.of(new Item(50, "wood", 0, ItemTexture.WOOD.getTexture()), new Item(3, "iron bar", 0, ItemTexture.WOOD.getTexture()), new Item(10, "coal", 0, ItemTexture.WOOD.getTexture()))), 0, ItemTexture.WOOD.getTexture()),

    MYSTIC_TREE_SEED("mystic tree seed", "Can be planted to grow a mystic tree",
            new ArrayList<>(List.of(
                    new Item(5, "acorn", 0, ItemTexture.WOOD.getTexture()),
                    new Item(5, "maple seed", 0, ItemTexture.WOOD.getTexture()),
                    new Item(5, "pine cone", 0, ItemTexture.WOOD.getTexture()),
                    new Item(5, "mahogany seed", 0, ItemTexture.WOOD.getTexture()))), 100, ItemTexture.WOOD.getTexture());

    private final String name;
    private final String description;
    private final ArrayList<Item> ingredients;
    private final int sellPrice;
    private final Texture texture;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Item> getIngredients() {
        return ingredients;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public Texture getTexture() {
        return texture;
    }

    IndustrialProductType(String name, String description, ArrayList<Item> ingredients, int sellPrice, Texture texture) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.sellPrice = sellPrice;
        this.texture = texture;
    }
}
