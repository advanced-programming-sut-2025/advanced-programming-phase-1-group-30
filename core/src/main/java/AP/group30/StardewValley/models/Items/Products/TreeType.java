package AP.group30.StardewValley.models.Items.Products;

import java.util.ArrayList;
import java.util.Arrays;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import com.badlogic.gdx.graphics.Texture;

public enum TreeType implements ItemsInteface {
    APRICOT_TREE("apricot tree", ForagingSeedType.APRICOT_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.APRICOT, ItemTexture.WOOD.getTexture()),
    CHERRY_TREE("cherry tree", ForagingSeedType.CHERRY_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.CHERRY, ItemTexture.WOOD.getTexture()),
    BANANA_TREE("banana tree", ForagingSeedType.BANANA_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.BANANA, ItemTexture.WOOD.getTexture()),
    MANGO_TREE("mango tree", ForagingSeedType.MANGO_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.MANGO, ItemTexture.WOOD.getTexture()),
    ORANGE_TREE("orange tree", ForagingSeedType.ORANGE_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.ORANGE, ItemTexture.WOOD.getTexture()),
    PEACH_TREE("peach tree", ForagingSeedType.PEACH_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.PEACH, ItemTexture.WOOD.getTexture()),
    APPLE_TREE("apple tree", ForagingSeedType.APPLE_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.APPLE, ItemTexture.WOOD.getTexture()),
    POMEGRANATE_TREE("pomegranate tree", ForagingSeedType.POMEGRANATE_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.POMEGRANATE, ItemTexture.WOOD.getTexture()),
    OAK_TREE("oak tree", ForagingSeedType.OAK_TREE, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.OAK_RESIN, ItemTexture.WOOD.getTexture()),
    MAPLE_TREE("maple tree", ForagingSeedType.MAPLE_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.MAPLE_SYRUP, ItemTexture.WOOD.getTexture()),
    PINE_TREE("pine tree", ForagingSeedType.PINE_CONES, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.PINE_TAR, ItemTexture.WOOD.getTexture()),
    MAHOGANY_TREE("mahogany tree", ForagingSeedType.MAHOGANY_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.SAP, ItemTexture.WOOD.getTexture()),
    MUSHROOM_TREE("mushroom tree", ForagingSeedType.MUSHROOM_TREE_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.COMMON_MUSHROOM, ItemTexture.WOOD.getTexture()),
    MYSTIC_TREE("mystic tree", ForagingSeedType.MYSTIC_TREE_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.MYSTIC_SYRUP, ItemTexture.WOOD.getTexture()),
    STUMP("stump", null, null, 0, null, ItemTexture.WOOD.getTexture());

    private final String name;
	private final ForagingSeedType source;
    private final ArrayList<Integer> stages;
    private final int totalHarvestTime;
    private final FruitType fruit;
    private final Texture texture;

    private TreeType(String name, ForagingSeedType source, ArrayList<Integer> stages, int totalHarvestTime,
            FruitType fruit, Texture texture) {
        this.name = name;
        this.source = source;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.fruit = fruit;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public ForagingSeedType getSource() {
        return source;
    }

    public ArrayList<Integer> getStages() {
        return stages;
    }

    public int getTotalHarvestTime() {
        return totalHarvestTime;
    }

    public FruitType getFruit() {
        return fruit;
    }

    public Texture getTexture() {
        return texture;
    }

    public static TreeType getRandomTreeType(int id) {
        if (id == 0) return APRICOT_TREE;
        if (id == 1) return CHERRY_TREE;
        if (id == 2) return BANANA_TREE;
        if (id == 3) return MANGO_TREE;
        if (id == 4) return ORANGE_TREE;
        if (id == 5) return PEACH_TREE;
        if (id == 6) return APPLE_TREE;
        if (id == 7) return POMEGRANATE_TREE;
        if (id == 8) return OAK_TREE;
        if (id == 9) return MAPLE_TREE;
        if (id == 10) return PINE_TREE;
        if (id == 11) return MAHOGANY_TREE;
        if (id == 12) return MUSHROOM_TREE;
        if (id == 13) return MYSTIC_TREE;

        return APRICOT_TREE;
    }
}
