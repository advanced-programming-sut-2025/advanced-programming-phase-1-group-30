package AP.group30.StardewValley.models.Items.Products;

import java.util.ArrayList;
import java.util.Arrays;

import AP.group30.StardewValley.models.Items.ItemsInteface;

public enum TreeType implements ItemsInteface {
    APRICOT_TREE("apricot tree", ForagingSeedType.APRICOT_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.APRICOT),
    CHERRY_TREE("cherry tree", ForagingSeedType.CHERRY_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.CHERRY),
    BANANA_TREE("banana tree", ForagingSeedType.BANANA_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.BANANA),
    MANGO_TREE("mango tree", ForagingSeedType.MANGO_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.MANGO),
    ORANGE_TREE("orange tree", ForagingSeedType.ORANGE_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.ORANGE),
    PEACH_TREE("peach tree", ForagingSeedType.PEACH_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.PEACH),
    APPLE_TREE("apple tree", ForagingSeedType.APPLE_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.APPLE),
    POMEGRANATE_TREE("pomegranate tree", ForagingSeedType.POMEGRANATE_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.POMEGRANATE),
    OAK_TREE("oak tree", ForagingSeedType.OAK_TREE, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.OAK_RESIN),
    MAPLE_TREE("maple tree", ForagingSeedType.MAPLE_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.MAPLE_SYRUP),
    PINE_TREE("pine tree", ForagingSeedType.PINE_CONES, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.PINE_TAR),
    MAHOGANY_TREE("mahogany tree", ForagingSeedType.MAHOGANY_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.SAP),
    MUSHROOM_TREE("mushroom tree", ForagingSeedType.MUSHROOM_TREE_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.COMMON_MUSHROOM),
    MYSTIC_TREE("mystic tree", ForagingSeedType.MYSTIC_TREE_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.MYSTIC_SYRUP),
    STUMP("stump", null, null, 0, null);

    private final String name;
	private final ForagingSeedType source;
    private final ArrayList<Integer> stages;
    private final int totalHarvestTime;
    private final FruitType fruit;

    private TreeType(String name, ForagingSeedType source, ArrayList<Integer> stages, int totalHarvestTime,
            FruitType fruit) {
        this.name = name;
        this.source = source;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.fruit = fruit;
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
