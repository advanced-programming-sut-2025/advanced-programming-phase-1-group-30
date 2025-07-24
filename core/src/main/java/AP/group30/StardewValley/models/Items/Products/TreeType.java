package AP.group30.StardewValley.models.Items.Products;

import java.util.ArrayList;
import java.util.Arrays;

import AP.group30.StardewValley.models.Items.Products.TreeTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import com.badlogic.gdx.graphics.Texture;

public enum TreeType implements ItemsInteface {
    APRICOT_TREE("apricot tree", ForagingSeedType.APRICOT_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.APRICOT, TreeTexture.APRICOT_TREE.getSpringTexture(), TreeTexture.APRICOT_TREE.getSummerTexture(), TreeTexture.APRICOT_TREE.getFallTexture(), TreeTexture.APRICOT_TREE.getWinterTexture()),
    CHERRY_TREE("cherry tree", ForagingSeedType.CHERRY_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.CHERRY, TreeTexture.CHERRY_TREE.getSpringTexture(), TreeTexture.CHERRY_TREE.getSummerTexture(), TreeTexture.APRICOT_TREE.getFallTexture(), TreeTexture.APRICOT_TREE.getWinterTexture()),
    BANANA_TREE("banana tree", ForagingSeedType.BANANA_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.BANANA, TreeTexture.BANANA_TREE.getSpringTexture(), TreeTexture.BANANA_TREE.getSummerTexture(), TreeTexture.BANANA_TREE.getFallTexture(), TreeTexture.BANANA_TREE.getWinterTexture()),
    MANGO_TREE("mango tree", ForagingSeedType.MANGO_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.MANGO, TreeTexture.MANGO_TREE.getSpringTexture(), TreeTexture.MANGO_TREE.getSummerTexture(), TreeTexture.MANGO_TREE.getFallTexture(), TreeTexture.MANGO_TREE.getWinterTexture()),
    ORANGE_TREE("orange tree", ForagingSeedType.ORANGE_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.ORANGE, TreeTexture.ORANGE_TREE.getSpringTexture(), TreeTexture.ORANGE_TREE.getSummerTexture(), TreeTexture.ORANGE_TREE.getFallTexture(), TreeTexture.ORANGE_TREE.getWinterTexture()),
    PEACH_TREE("peach tree", ForagingSeedType.PEACH_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.PEACH, TreeTexture.PEACH_TREE.getSpringTexture(), TreeTexture.PEACH_TREE.getSummerTexture(), TreeTexture.PEACH_TREE.getFallTexture(), TreeTexture.PEACH_TREE.getWinterTexture()),
    APPLE_TREE("apple tree", ForagingSeedType.APPLE_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.APPLE, TreeTexture.APPLE_TREE.getSpringTexture(), TreeTexture.APPLE_TREE.getSummerTexture(), TreeTexture.APPLE_TREE.getFallTexture(), TreeTexture.APPLE_TREE.getWinterTexture()),
    POMEGRANATE_TREE("pomegranate tree", ForagingSeedType.POMEGRANATE_SAPLING, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.POMEGRANATE, TreeTexture.POMEGRANATE_TREE.getSpringTexture(), TreeTexture.POMEGRANATE_TREE.getSummerTexture(), TreeTexture.POMEGRANATE_TREE.getFallTexture(), TreeTexture.POMEGRANATE_TREE.getWinterTexture()),
    OAK_TREE("oak tree", ForagingSeedType.OAK_TREE, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.OAK_RESIN, TreeTexture.OAK_TREE.getSpringTexture(), TreeTexture.OAK_TREE.getSummerTexture(), TreeTexture.OAK_TREE.getFallTexture(), TreeTexture.OAK_TREE.getWinterTexture()),
    MAPLE_TREE("maple tree", ForagingSeedType.MAPLE_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.MAPLE_SYRUP, TreeTexture.MAPLE_TREE.getSpringTexture(), TreeTexture.MAPLE_TREE.getSummerTexture(), TreeTexture.MAPLE_TREE.getFallTexture(), TreeTexture.MAPLE_TREE.getWinterTexture()),
    PINE_TREE("pine tree", ForagingSeedType.PINE_CONES, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.PINE_TAR, TreeTexture.PINE_TREE.getSpringTexture(), TreeTexture.PINE_TREE.getSummerTexture(), TreeTexture.PINE_TREE.getFallTexture(), TreeTexture.PINE_TREE.getWinterTexture()),
    MAHOGANY_TREE("mahogany tree", ForagingSeedType.MAHOGANY_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.SAP, TreeTexture.MAHOGANY_TREE.getSpringTexture(), TreeTexture.MAHOGANY_TREE.getSummerTexture(), TreeTexture.MAHOGANY_TREE.getFallTexture(), TreeTexture.MAHOGANY_TREE.getWinterTexture()),
    MUSHROOM_TREE("mushroom tree", ForagingSeedType.MUSHROOM_TREE_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.COMMON_MUSHROOM, TreeTexture.MUSHROOM_TREE.getSpringTexture(), TreeTexture.MUSHROOM_TREE.getSummerTexture(), TreeTexture.MUSHROOM_TREE.getFallTexture(), TreeTexture.MAHOGANY_TREE.getWinterTexture()),
    MYSTIC_TREE("mystic tree", ForagingSeedType.MYSTIC_TREE_SEEDS, new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7)), 28, FruitType.MYSTIC_SYRUP, TreeTexture.MYSTIC_TREE.getSpringTexture(), TreeTexture.MYSTIC_TREE.getSummerTexture(), TreeTexture.MYSTIC_TREE.getFallTexture(), TreeTexture.MYSTIC_TREE.getWinterTexture()),
    TREE("wild tree", null, null, -1, null, TreeTexture.TREE.getSpringTexture(), TreeTexture.TREE.getSummerTexture(), TreeTexture.TREE.getFallTexture(), TreeTexture.TREE.getWinterTexture()),
    STUMP("stump", null, null, 0, null, TreeTexture.TREE.getSpringTexture(), TreeTexture.TREE.getSummerTexture(), TreeTexture.TREE.getFallTexture(), TreeTexture.TREE.getWinterTexture()),;

    private final String name;
	private final ForagingSeedType source;
    private final ArrayList<Integer> stages;
    private final int totalHarvestTime;
    private final FruitType fruit;
    private final Texture springTexture;
    private final Texture summerTexture;
    private final Texture fallTexture;
    private final Texture winterTexture;

    private TreeType(String name, ForagingSeedType source, ArrayList<Integer> stages, int totalHarvestTime,
            FruitType fruit, Texture springTexture, Texture summerTexture, Texture fallTexture, Texture winterTexture) {
        this.name = name;
        this.source = source;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.fruit = fruit;
        this.springTexture = springTexture;
        this.summerTexture = summerTexture;
        this.fallTexture = fallTexture;
        this.winterTexture = winterTexture;
    }

    public String getName() {
        return name;
    }

    @Override
    public Texture getTexture() {
        return null;
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

    public Texture getSpringTexture() {
        return springTexture;
    }

    public Texture getSummerTexture() {
        return summerTexture;
    }

    public Texture getFallTexture() {
        return fallTexture;
    }

    public Texture getWinterTexture() {
        return winterTexture;
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
//        if (id == 10) return PINE_TREE;
//        if (id == 11) return MAHOGANY_TREE;
//        if (id == 12) return MUSHROOM_TREE;
        else return TREE;
    }

    public int getPrice() {
        return 20;
    }
}
