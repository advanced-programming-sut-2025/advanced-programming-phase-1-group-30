package models.Items.Products;

import models.Items.ItemsInteface;
import models.TimeAndDate.Season;

public enum ForagingSeedType implements ItemsInteface {
    JAZZ_SEEDS("jazz seeds", Season.SPRING, CropType.BLUE_JAZZ, null, 0),
    CARROT_SEEDS("carrot seeds", Season.SPRING, CropType.CARROT, null, 0),
    CAULIFLOWER_SEEDS("cauliflower seeds", Season.SPRING, CropType.CAULIFLOWER, null, 0),
    COFFEE_BEAN("coffee bean", Season.SPRING, CropType.COFFEE_BEAN, null, 0),
    GARLIC_SEEDS("garlic seeds", Season.SPRING, CropType.GARLIC, null, 0),
    BEAN_STARTER("bean starter", Season.SPRING, CropType.GREEN_BEAN, null, 0),
    KALE_SEEDS("kale seeds", Season.SPRING, CropType.KALE, null, 0),
    PARSNIP_SEEDS("parsnip seeds", Season.SPRING, CropType.PARSNIP, null, 0),
    POTATO_SEEDS("potato seeds", Season.SPRING, CropType.POTATO, null, 0),
    RHUBARB_SEEDS("rhubarb seeds", Season.SPRING, CropType.RHUBARB, null, 0),
    STRAWBERRY_SEEDS("strawberry seeds", Season.SPRING, CropType.STRAWBERRY, null, 0),
    TULIP_BULB("tulip bulb", Season.SPRING, CropType.TULIP, null, 0),
    RICE_SHOOT("rice shoot", Season.SPRING, CropType.UNMILLED_RICE, null, 0),
    BLUEBERRY_SEEDS("blueberry seeds", Season.SUMMER, CropType.BLUEBERRY, null, 0),
    CORN_SEEDS("corn seeds", Season.SUMMER, CropType.CORN, null, 0),
    HOPS_STARTER("hops starter", Season.SUMMER, CropType.HOPS, null, 0),
    PEPPER_SEEDS("pepper seeds", Season.SUMMER, CropType.HOT_PEPPER, null, 0),
    MELON_SEEDS("melon seeds", Season.SUMMER, CropType.MELON, null, 0),
    POPPY_SEEDS("poppy seeds", Season.SUMMER, CropType.POPPY, null, 0),
    RADISH_SEEDS("radish seeds", Season.SUMMER, CropType.RADISH, null, 0),
    RED_CABBAGE_SEEDS("red cabbage seeds", Season.SUMMER, CropType.RED_CABBAGE, null, 0),
    STARFRUIT_SEEDS("starfruit seeds", Season.SUMMER, CropType.STARFRUIT, null, 0),
    SPANGLE_SEEDS("spangle seeds", Season.SUMMER, CropType.SUMMER_SPANGLE, null, 0),
    SUMMER_SQUASH_SEEDS("summer squash seeds", Season.SUMMER, CropType.SUMMER_SQUASH, null, 0),
    SUNFLOWER_SEEDS("sunflower seeds", Season.SUMMER, CropType.SUNFLOWER, null, 0),
    TOMATO_SEEDS("tomato seeds", Season.SUMMER, CropType.TOMATO, null, 0),
    WHEAT_SEEDS("wheat seeds", Season.SUMMER, CropType.WHEAT, null, 0),
    AMARANTH_SEEDS("amaranth seeds", Season.FALL, CropType.AMARANTH, null, 0),
    ARTICHOKE_SEEDS("artichoke seeds", Season.FALL, CropType.ARTICHOKE, null, 0),
    BEET_SEEDS("beet seeds", Season.FALL, CropType.BEET, null, 0),
    BOK_CHOY_SEEDS("bok choy seeds", Season.FALL, CropType.BOK_CHOY, null, 0),
    BROCCOLI_SEEDS("broccoli seeds", Season.FALL, CropType.BROCCOLI, null, 0),
    CRANBERRY_SEEDS("cranberry seeds", Season.FALL, CropType.CRANBERRIES, null, 0),
    EGGPLANT_SEEDS("eggplant seeds", Season.FALL, CropType.EGGPLANT, null, 0),
    FAIRY_SEEDS("fairy seeds", Season.FALL, CropType.FAIRY_ROSE, null, 0),
    GRAPE_STARTER("grape starter", Season.FALL, CropType.GRAPE, null, 0),
    PUMPKIN_SEEDS("pumpkin seeds", Season.FALL, CropType.PUMPKIN, null, 0),
    YAM_SEEDS("yam seeds", Season.FALL, CropType.YAM, null, 0),
    RARE_SEED("rare seed", Season.FALL, CropType.SWEET_GEM_BERRY, null, 0),
    POWDERMELON_SEEDS("powdermelon seeds", Season.WINTER, CropType.POWDERMELON, null, 0),
    ANCIENT_SEEDS("ancient seeds", Season.ALL, CropType.ANCIENT_FRUIT, null, 0),
    MIXED_SEEDS("mixed seeds", Season.ALL, CropType.ANCIENT_FRUIT, null, 0), // TODO

    APRICOT_SAPLING("apricot sapling", Season.SPRING, CropType.APRICOT, FruitType.APRICOT, 1),
    CHERRY_SAPLING("cherry sapling", Season.SPRING, CropType.CHERRY, FruitType.CHERRY, 1),
    BANANA_SAPLING("banana sapling", Season.SUMMER, CropType.BANANA, FruitType.BANANA, 1),
    MANGO_SAPLING("mango sapling", Season.SUMMER, CropType.MANGO, FruitType.MANGO, 1),
    ORANGE_SAPLING("orange sapling", Season.SUMMER, CropType.ORANGE, FruitType.ORANGE, 1),
    PEACH_SAPLING("peach sapling", Season.SUMMER, CropType.PEACH, FruitType.PEACH, 1),
    APPLE_SAPLING("apple sapling", Season.FALL, CropType.APPLE, FruitType.APPLE, 1),
    POMEGRANATE_SAPLING("pomegranate sapling", Season.FALL, CropType.POMEGRANATE, FruitType.POMEGRANATE, 1),
    OAK_TREE("acorns", Season.ALL, CropType.OAK_RESIN, FruitType.OAK_RESIN,1),
    MAPLE_SEEDS("maple seeds", Season.ALL, CropType.MAPLE_SYRUP, FruitType.MAPLE_SYRUP, 1),
    PINE_CONES("pine cones", Season.ALL, CropType.PINE_TAR, FruitType.PINE_TAR, 1),
    MAHOGANY_SEEDS("mahogany seeds", Season.ALL, CropType.SAP, FruitType.SAP, 1),
    MUSHROOM_TREE_SEEDS("mushroom tree seeds", Season.ALL, CropType.COMMON_MUSHROOM, FruitType.COMMON_MUSHROOM, 1),
    MYSTIC_TREE_SEEDS("mystic tree seeds", Season.ALL, CropType.MAPLE_SYRUP, FruitType.MAPLE_SYRUP, 1);
  
    private final String name;
    private final Season season;
    private final CropType crop;
    private final FruitType fruit;
    private final int treeOrCrop; // 0 for crop, 1 for tree


    private ForagingSeedType(String name, Season season, CropType crop, FruitType fruit, int treeOrCrop) {
        this.name = name;
        this.season = season;
        this.crop = crop;
        this.fruit = fruit;
        this.treeOrCrop = treeOrCrop;
    }
    
    public String getName() {
        return name;
    }
    public Season getSeason() {
        return season;
    }
    public CropType getCrop() {
        return crop;
    }

    public FruitType getFruit() {
        return fruit;
    }

    public int getTreeOrCrop() {
        return treeOrCrop;
    }
}
