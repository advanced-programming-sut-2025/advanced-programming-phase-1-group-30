package models.Items.Products;

import models.TimeAndDate.Season;

public enum ForgingSeedType {
    JAZZ_SEEDS("Jazz Seeds", Season.SPRING, CropType.BLUE_JAZZ, null, 0),
    CARROT_SEEDS("Carrot Seeds", Season.SPRING, CropType.CARROT, null, 0),
    CAULIFLOWER_SEEDS("Cauliflower Seeds", Season.SPRING, CropType.CAULIFLOWER, null, 0),
    COFFEE_BEAN("Coffee Bean", Season.SPRING, CropType.COFFEE_BEAN, null, 0),
    GARLIC_SEEDS("Garlic Seeds", Season.SPRING, CropType.GARLIC, null, 0),
    BEAN_STARTER("Bean Starter", Season.SPRING, CropType.GREEN_BEAN, null, 0),
    KALE_SEEDS("Kale Seeds", Season.SPRING, CropType.KALE, null, 0),
    PARSNIP_SEEDS("Parsnip Seeds", Season.SPRING, CropType.PARSNIP, null, 0),
    POTATO_SEEDS("Potato Seeds", Season.SPRING, CropType.POTATO, null, 0),
    RHUBARB_SEEDS("Rhubarb Seeds", Season.SPRING, CropType.RHUBARB, null, 0),
    STRAWBERRY_SEEDS("Strawberry Seeds", Season.SPRING, CropType.STRAWBERRY, null, 0),
    TULIP_BULB("Tulip Bulb", Season.SPRING, CropType.TULIP, null, 0),
    RICE_SHOOT("Rice Shoot", Season.SPRING, CropType.UNMILLED_RICE, null, 0),
    BLUEBERRY_SEEDS("Blueberry Seeds", Season.SUMMER, CropType.BLUEBERRY, null, 0),
    CORN_SEEDS("Corn Seeds", Season.SUMMER, CropType.CORN, null, 0),
    HOPS_STARTER("Hops Starter", Season.SUMMER, CropType.HOPS, null, 0),
    PEPPER_SEEDS("Pepper Seeds", Season.SUMMER, CropType.HOT_PEPPER, null, 0),
    MELON_SEEDS("Melon Seeds", Season.SUMMER, CropType.MELON, null, 0),
    POPPY_SEEDS("Poppy Seeds", Season.SUMMER, CropType.POPPY, null, 0),
    RADISH_SEEDS("Radish Seeds", Season.SUMMER, CropType.RADISH, null, 0),
    RED_CABBAGE_SEEDS("Red Cabbage Seeds", Season.SUMMER, CropType.RED_CABBAGE, null, 0),
    STARFRUIT_SEEDS("Starfruit Seeds", Season.SUMMER, CropType.STARFRUIT, null, 0),
    SPANGLE_SEEDS("Spangle Seeds", Season.SUMMER, CropType.SUMMER_SPANGLE, null, 0),
    SUMMER_SQUASH_SEEDS("Summer Squash Seeds", Season.SUMMER, CropType.SUMMER_SQUASH, null, 0),
    SUNFLOWER_SEEDS("Sunflower Seeds", Season.SUMMER, CropType.SUNFLOWER, null, 0),
    TOMATO_SEEDS("Tomato Seeds", Season.SUMMER, CropType.TOMATO, null, 0),
    WHEAT_SEEDS("Wheat Seeds", Season.SUMMER, CropType.WHEAT, null, 0),
    AMARANTH_SEEDS("Amaranth Seeds", Season.FALL, CropType.AMARANTH, null, 0),
    ARTICHOKE_SEEDS("Artichoke Seeds", Season.FALL, CropType.ARTICHOKE, null, 0),
    BEET_SEEDS("Beet Seeds", Season.FALL, CropType.BEET, null, 0),
    BOK_CHOY_SEEDS("Bok Choy Seeds", Season.FALL, CropType.BOK_CHOY, null, 0),
    BROCCOLI_SEEDS("Broccoli Seeds", Season.FALL, CropType.BROCCOLI, null, 0),
    CRANBERRY_SEEDS("Cranberry Seeds", Season.FALL, CropType.CRANBERRIES, null, 0),
    EGGPLANT_SEEDS("Eggplant Seeds", Season.FALL, CropType.EGGPLANT, null, 0),
    FAIRY_SEEDS("Fairy Seeds", Season.FALL, CropType.FAIRY_ROSE, null, 0),
    GRAPE_STARTER("Grape Starter", Season.FALL, CropType.GRAPE, null, 0),
    PUMPKIN_SEEDS("Pumpkin Seeds", Season.FALL, CropType.PUMPKIN, null, 0),
    YAM_SEEDS("Yam Seeds", Season.FALL, CropType.YAM, null, 0),
    RARE_SEED("Rare Seed", Season.FALL, CropType.SWEET_GEM_BERRY, null, 0),
    POWDERMELON_SEEDS("Powdermelon Seeds", Season.WINTER, CropType.POWDERMELON, null, 0),
    ANCIENT_SEEDS("Ancient Seeds", Season.ALL, CropType.ANCIENT_FRUIT, null, 0),
    MIXED_SEEDS("Mixed Seeds", Season.ALL, null, null, 0), // TODO

    APRICOT_SAPLING("Apricot Sapling", Season.SPRING, CropType.COFFEE_BEAN, FruitType.APRICOT, 1),
    CHERRY_SAPLING("Cherry Sapling", Season.SPRING, CropType.COFFEE_BEAN, FruitType.CHERRY, 1),
    BANANA_SAPLING("Banana Sapling", Season.SUMMER, CropType.COFFEE_BEAN, FruitType.BANANA, 1),
    MANGO_SAPLING("Mango Sapling", Season.SUMMER, CropType.COFFEE_BEAN, FruitType.MANGO, 1),
    ORANGE_SAPLING("Orange Sapling", Season.SUMMER, CropType.COFFEE_BEAN, FruitType.ORANGE, 1),
    PEACH_SAPLING("Peach Sapling", Season.SUMMER, CropType.COFFEE_BEAN, FruitType.PEACH, 1),
    APPLE_SAPLING("Apple Sapling", Season.FALL, CropType.COFFEE_BEAN, FruitType.APPLE, 1),
    POMEGRANATE_SAPLING("Pomegranate Sapling", Season.FALL, CropType.COFFEE_BEAN, FruitType.POMEGRANATE, 1),
    OAK_TREE("Acorns", Season.ALL, CropType.COFFEE_BEAN, FruitType.OAK_RESIN,1),
    MAPLE_SEEDS("Maple Seeds", Season.ALL, CropType.COFFEE_BEAN, FruitType.MAPLE_SYRUP, 1),
    PINE_CONES("Pine Cones", Season.ALL, CropType.COFFEE_BEAN, FruitType.PINE_TAR, 1),
    MAHOGANY_SEEDS("Mahogany Seeds", Season.ALL, CropType.COFFEE_BEAN, FruitType.SAP, 1),
    MUSHROOM_TREE_SEEDS("Mushroom Tree Seeds", Season.ALL, CropType.COFFEE_BEAN, FruitType.COMMON_MUSHROOM, 1),
    MYSTIC_TREE_SEEDS("Mystic Tree Seeds", Season.ALL, CropType.COFFEE_BEAN, FruitType.MAPLE_SYRUP, 1);
  
    private final String name;
    private final Season season;
    private final CropType crop;
    private final FruitType fruit;
    private final int treeOrCrop; // 0 for crop, 1 for tree


    private ForgingSeedType(String name, Season season, CropType crop, FruitType fruit, int treeOrCrop) {
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
