package models.Items.Products;

import models.Items.Item;

import java.util.ArrayList;
import java.util.List;

public enum CraftingRecipe {
    CHERRY_BOMB("cherry bomb", "Destroys everything within a 3-tile radius",
            new ArrayList<>(List.of(new Item(4, "copper ore"), new Item(1, "coal"))), 50),

    BOMB("Bomb", "Destroys everything within a 5-tile radius",
            new ArrayList<>(List.of(new Item(4, "iron ore"), new Item(1, "coal"))), 50),

    MEGA_BOMB("mega bomb", "Destroys everything within a 7-tile radius",
            new ArrayList<>(List.of(new Item(4, "gold ore"), new Item(1, "coal"))), 50),

    SPRINKLER("sprinkler", "Water 4 adjacent tiles",
            new ArrayList<>(List.of(new Item(1, "copper bar"), new Item(1, "iron bar"))), 0),

    QUALITY_SPRINKLER("quality sprinkler", "Water 8 adjacent tiles",
            new ArrayList<>(List.of(new Item(1, "iron bar"), new Item(1, "gold bar"))), 0),

    IRIDIUM_SPRINKLER("iridium sprinkler", "Water 24 adjacent tiles",
            new ArrayList<>(List.of(new Item(1, "gold bar"), new Item(1, "iridium bar"))), 0),

    CHARCOAL_KILN("charcoal kiln", "Turns 10 wood into 1 coal",
            new ArrayList<>(List.of(new Item(20, "wood"), new Item(2, "copper bar"))), 0),

    FURNACE("Furnace", "Turns ores and coal into bars",
            new ArrayList<>(List.of(new Item(20, "copper ore"), new Item(25, "stone"))), 0),

    SCARECROW("Scarecrow", "Prevents crows from attacking within 8 tiles",
            new ArrayList<>(List.of(new Item(50, "wood"), new Item(1, "coal"), new Item(20, "fiber"))), 0),

    DELUXE_SCARECROW("Deluxe Scarecrow", "Prevents crows from attacking within 12 tiles",
            new ArrayList<>(List.of(new Item(50, "wood"), new Item(1, "coal"), new Item(20, "fiber"), new Item(1, "iridium ore"))), 0),

    BEE_HOUSE("Bee House", "Produces honey when placed on the farm",
            new ArrayList<>(List.of(new Item(40, "wood"), new Item(8, "coal"), new Item(1, "iron bar"))), 0),

    CHEESE_PRESS("Cheese Press", "Turns milk into cheese",
            new ArrayList<>(List.of(new Item(45, "wood"), new Item(45, "stone"), new Item(1, "copper bar"))), 0),

    KEG("Keg", "Turns fruits and vegetables into beverages",
            new ArrayList<>(List.of(new Item(30, "wood"), new Item(1, "copper bar"), new Item(1, "iron bar"))), 0),

    LOOM("Loom", "Turns wool into cloth",
            new ArrayList<>(List.of(new Item(60, "wood"), new Item(30, "fiber"))), 0),

    MAYONNAISE_MACHINE("Mayonnaise Machine", "Turns eggs into mayonnaise",
            new ArrayList<>(List.of(new Item(15, "wood"), new Item(15, "stone"), new Item(1, "copper bar"))), 0),

    OIL_MAKER("Oil Maker", "Turns truffles into oil",
            new ArrayList<>(List.of(new Item(100, "wood"), new Item(1, "gold bar"), new Item(1, "iron bar"))), 0),

    PRESERVES_JAR("Preserves Jar", "Turns vegetables into pickles and fruits into jams",
            new ArrayList<>(List.of(new Item(50, "wood"), new Item(40, "stone"), new Item(8, "coal"))), 0),

    DEHYDRATOR("Dehydrator", "Dries fruits or mushrooms",
            new ArrayList<>(List.of(new Item(30, "wood"), new Item(20, "stone"), new Item(30, "fiber"))), 0),

    GRASS_STARTER("Grass Starter", "Plant it on the ground to grow grass",
            new ArrayList<>(List.of(new Item(1, "wood"), new Item(1, "fiber"))), 0),

    FISH_SMOKER("Fish Smoker", "Turns any fish into smoked fish while preserving its quality",
            new ArrayList<>(List.of(new Item(50, "wood"), new Item(3, "iron bar"), new Item(10, "coal"))), 0),

    MYSTIC_TREE_SEED("Mystic Tree Seed", "Can be planted to grow a mystic tree",
            new ArrayList<>(List.of(
                    new Item(5, "acorn"),
                    new Item(5, "maple seed"),
                    new Item(5, "pine cone"),
                    new Item(5, "mahogany seed"))), 100);

    public final String name;
    public final String description;
    public final ArrayList<Item> ingredients;
    public final int sellPrice;

    CraftingRecipe(String name, String description, ArrayList<Item> ingredients, int sellPrice) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.sellPrice = sellPrice;
    }
}
