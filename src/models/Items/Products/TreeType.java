package models.Items.Products;

import java.util.ArrayList;
import java.util.Arrays;

public enum TreeType {
    APRICOT_TREE("Apricot Tree", ForgingSeedType.APRICOT_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.APRICOT),
    CHERRY_TREE("Cherry Tree", ForgingSeedType.CHERRY_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.CHERRY),
    BANANA_TREE("Banana Tree", ForgingSeedType.BANANA_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.BANANA),
    MANGO_TREE("Mango Tree", ForgingSeedType.MANGO_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.MANGO),
    ORANGE_TREE("Orange Tree", ForgingSeedType.ORANGE_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.ORANGE),
    PEACH_TREE("Peach Tree", ForgingSeedType.PEACH_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.PEACH),
    APPLE_TREE("Apple Tree", ForgingSeedType.APPLE_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.APPLE),
    POMEGRANATE_TREE("Pomegranate Tree", ForgingSeedType.POMEGRANATE_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.POMEGRANATE),
    OAK_TREE("Oak Tree", ForgingSeedType.ACORNS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.OAK_RESIN),
    MAPLE_TREE("Maple Tree", ForgingSeedType.MAPLE_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.MAPLE_SYRUP),
    PINE_TREE("Pine Tree", ForgingSeedType.PINE_CONES, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.PINE_TAR),
    MAHOGANY_TREE("Mahogany Tree", ForgingSeedType.MAHOGANY_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.SAP),
    MUSHROOM_TREE("Mushroom Tree", ForgingSeedType.MUSHROOM_TREE_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.COMMON_MUSHROOM),
    MYSTIC_TREE("Mystic Tree", ForgingSeedType.MYSTIC_TREE_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.MYSTIC_SYRUP);

    private final String name;
	private final ForgingSeedType source;
    private final ArrayList<Integer> stages;
    private final int totalHarvestTime;
    private final FruitType friut;

    private TreeType(String name, ForgingSeedType source, ArrayList<Integer> stages, int totalHarvestTime,
            FruitType friut) {
        this.name = name;
        this.source = source;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.friut = friut;
    }

    public String getName() {
        return name;
    }

    public ForgingSeedType getSource() {
        return source;
    }

    public ArrayList<Integer> getStages() {
        return stages;
    }

    public int getTotalHarvestTime() {
        return totalHarvestTime;
    }

    public FruitType getFriut() {
        return friut;
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
