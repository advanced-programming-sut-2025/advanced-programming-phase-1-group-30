package models.Items.Products;

import models.TimeAndDate.Season;

public enum ForgingSeedType {
    JAZZ_SEEDS("Jazz Seeds", Season.SPRING),
    CARROT_SEEDS("Carrot Seeds", Season.SPRING),
    CAULIFLOWER_SEEDS("Cauliflower Seeds", Season.SPRING),
    COFFEE_BEAN("Coffee Bean", Season.SPRING),
    GARLIC_SEEDS("Garlic Seeds", Season.SPRING),
    BEAN_STARTER("Bean Starter", Season.SPRING),
    KALE_SEEDS("Kale Seeds", Season.SPRING),
    PARSNIP_SEEDS("Parsnip Seeds", Season.SPRING),
    POTATO_SEEDS("Potato Seeds", Season.SPRING),
    RHUBARB_SEEDS("Rhubarb Seeds", Season.SPRING),
    STRAWBERRY_SEEDS("Strawberry Seeds", Season.SPRING),
    TULIP_BULB("Tulip Bulb", Season.SPRING),
    RICE_SHOOT("Rice Shoot", Season.SPRING),
    BLUEBERRY_SEEDS("Blueberry Seeds", Season.SUMMER),
    CORN_SEEDS("Corn Seeds", Season.SUMMER),
    HOPS_STARTER("Hops Starter", Season.SUMMER),
    PEPPER_SEEDS("Pepper Seeds", Season.SUMMER),
    MELON_SEEDS("Melon Seeds", Season.SUMMER),
    POPPY_SEEDS("Poppy Seeds", Season.SUMMER),
    RADISH_SEEDS("Radish Seeds", Season.SUMMER),
    RED_CABBAGE_SEEDS("Red Cabbage Seeds", Season.SUMMER),
    STARFRUIT_SEEDS("Starfruit Seeds", Season.SUMMER),
    SPANGLE_SEEDS("Spangle Seeds", Season.SUMMER),
    SUMMER_SQUASH_SEEDS("Summer Squash Seeds", Season.SUMMER),
    SUNFLOWER_SEEDS("Sunflower Seeds", Season.SUMMER),
    TOMATO_SEEDS("Tomato Seeds", Season.SUMMER),
    WHEAT_SEEDS("Wheat Seeds", Season.SUMMER),
    AMARANTH_SEEDS("Amaranth Seeds", Season.FALL),
    ARTICHOKE_SEEDS("Artichoke Seeds", Season.FALL),
    BEET_SEEDS("Beet Seeds", Season.FALL),
    BOK_CHOY_SEEDS("Bok Choy Seeds", Season.FALL),
    BROCCOLI_SEEDS("Broccoli Seeds", Season.FALL),
    CRANBERRY_SEEDS("Cranberry Seeds", Season.FALL),
    EGGPLANT_SEEDS("Eggplant Seeds", Season.FALL),
    FAIRY_SEEDS("Fairy Seeds", Season.FALL),
    GRAPE_STARTER("Grape Starter", Season.FALL),
    PUMPKIN_SEEDS("Pumpkin Seeds", Season.FALL),
    YAM_SEEDS("Yam Seeds", Season.FALL),
    RARE_SEED("Rare Seed", Season.FALL),
    POWDERMELON_SEEDS("Powdermelon Seeds", Season.WINTER),
    ANCIENT_SEEDS("Ancient Seeds", Season.ALL),
    MIXED_SEEDS("Mixed Seeds", Season.ALL),

    APRICOT_SAPLING("Apricot Sapling", Season.SPRING),
    CHERRY_SAPLING("Cherry Sapling", Season.SPRING),
    BANANA_SAPLING("Banana Sapling", Season.SUMMER),
    MANGO_SAPLING("Mango Sapling", Season.SUMMER),
    ORANGE_SAPLING("Orange Sapling", Season.SUMMER),
    PEACH_SAPLING("Peach Sapling", Season.SUMMER),
    APPLE_SAPLING("Apple Sapling", Season.FALL),
    POMEGRANATE_SAPLING("Pomegranate Sapling", Season.FALL),
    ACORNS("Acorns", Season.ALL),
    MAPLE_SEEDS("Maple Seeds", Season.ALL),
    PINE_CONES("Pine Cones", Season.ALL),
    MAHOGANY_SEEDS("Mahogany Seeds", Season.ALL),
    MUSHROOM_TREE_SEEDS("Mushroom Tree Seeds", Season.ALL),
    MYSTIC_TREE_SEEDS("Mystic Tree Seeds", Season.ALL);
  
    private final String name;
    private final Season season;
    private final CropType crop;

    private ForgingSeedType(String name, Season season, CropType crop) {
        this.name = name;
        this.season = season;
        this.crop = crop;
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
}
