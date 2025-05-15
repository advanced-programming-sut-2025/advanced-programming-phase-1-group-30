package models.Items.Products;

import java.util.ArrayList;
import java.util.Arrays;

import models.Items.ItemsInteface;

public enum TreeType implements ItemsInteface {
    APRICOT_TREE("Apricot Tree", ForagingSeedType.APRICOT_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.APRICOT),
    CHERRY_TREE("Cherry Tree", ForagingSeedType.CHERRY_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.CHERRY),
    BANANA_TREE("Banana Tree", ForagingSeedType.BANANA_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.BANANA),
    MANGO_TREE("Mango Tree", ForagingSeedType.MANGO_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.MANGO),
    ORANGE_TREE("Orange Tree", ForagingSeedType.ORANGE_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.ORANGE),
    PEACH_TREE("Peach Tree", ForagingSeedType.PEACH_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.PEACH),
    APPLE_TREE("Apple Tree", ForagingSeedType.APPLE_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.APPLE),
    POMEGRANATE_TREE("Pomegranate Tree", ForagingSeedType.POMEGRANATE_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.POMEGRANATE),
    OAK_TREE("Oak Tree", ForagingSeedType.OAK_TREE, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.OAK_RESIN),
    MAPLE_TREE("Maple Tree", ForagingSeedType.MAPLE_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.MAPLE_SYRUP),
    PINE_TREE("Pine Tree", ForagingSeedType.PINE_CONES, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.PINE_TAR),
    MAHOGANY_TREE("Mahogany Tree", ForagingSeedType.MAHOGANY_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.SAP),
    MUSHROOM_TREE("Mushroom Tree", ForagingSeedType.MUSHROOM_TREE_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.COMMON_MUSHROOM),
    MYSTIC_TREE("Mystic Tree", ForagingSeedType.MYSTIC_TREE_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.MYSTIC_SYRUP),
    STUMP("Stump", null, null, 0, null);

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
