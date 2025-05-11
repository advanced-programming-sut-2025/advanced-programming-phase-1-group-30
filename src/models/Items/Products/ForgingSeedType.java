package models.Items.Products;

import models.TimeAndDate.Season;

public enum ForgingSeedType {
    JAZZ_SEEDS("Jazz Seeds", Season.SPRING, null),
    CARROT_SEEDS("Carrot Seeds", Season.SPRING, null),
    CAULIFLOWER_SEEDS("Cauliflower Seeds", Season.SPRING, null),
    COFFEE_BEAN("Coffee Bean", Season.SPRING, null),
    GARLIC_SEEDS("Garlic Seeds", Season.SPRING, null),
    BEAN_STARTER("Bean Starter", Season.SPRING, null),
    KALE_SEEDS("Kale Seeds", Season.SPRING, null),
    PARSNIP_SEEDS("Parsnip Seeds", Season.SPRING, null),
    POTATO_SEEDS("Potato Seeds", Season.SPRING, null),
    RHUBARB_SEEDS("Rhubarb Seeds", Season.SPRING, null),
    STRAWBERRY_SEEDS("Strawberry Seeds", Season.SPRING, null),
    TULIP_BULB("Tulip Bulb", Season.SPRING, null),
    RICE_SHOOT("Rice Shoot", Season.SPRING, null),
    BLUEBERRY_SEEDS("Blueberry Seeds", Season.SUMMER, null),
    CORN_SEEDS("Corn Seeds", Season.SUMMER, null),
    HOPS_STARTER("Hops Starter", Season.SUMMER, null),
    PEPPER_SEEDS("Pepper Seeds", Season.SUMMER, null),
    MELON_SEEDS("Melon Seeds", Season.SUMMER, null),
    POPPY_SEEDS("Poppy Seeds", Season.SUMMER, null),
    RADISH_SEEDS("Radish Seeds", Season.SUMMER, null),
    RED_CABBAGE_SEEDS("Red Cabbage Seeds", Season.SUMMER, null),
    STARFRUIT_SEEDS("Starfruit Seeds", Season.SUMMER, null),
    SPANGLE_SEEDS("Spangle Seeds", Season.SUMMER, null),
    SUMMER_SQUASH_SEEDS("Summer Squash Seeds", Season.SUMMER, null),
    SUNFLOWER_SEEDS("Sunflower Seeds", Season.SUMMER, null),
    TOMATO_SEEDS("Tomato Seeds", Season.SUMMER, null),
    WHEAT_SEEDS("Wheat Seeds", Season.SUMMER, null),
    AMARANTH_SEEDS("Amaranth Seeds", Season.FALL, null),
    ARTICHOKE_SEEDS("Artichoke Seeds", Season.FALL, null),
    BEET_SEEDS("Beet Seeds", Season.FALL, null),
    BOK_CHOY_SEEDS("Bok Choy Seeds", Season.FALL, null),
    BROCCOLI_SEEDS("Broccoli Seeds", Season.FALL, null),
    CRANBERRY_SEEDS("Cranberry Seeds", Season.FALL, null),
    EGGPLANT_SEEDS("Eggplant Seeds", Season.FALL, null),
    FAIRY_SEEDS("Fairy Seeds", Season.FALL, null),
    GRAPE_STARTER("Grape Starter", Season.FALL, null),
    PUMPKIN_SEEDS("Pumpkin Seeds", Season.FALL, null),
    YAM_SEEDS("Yam Seeds", Season.FALL, null),
    RARE_SEED("Rare Seed", Season.FALL, null),
    POWDERMELON_SEEDS("Powdermelon Seeds", Season.WINTER, null),
    ANCIENT_SEEDS("Ancient Seeds", Season.ALL, null),
    MIXED_SEEDS("Mixed Seeds", Season.ALL, null),

    APRICOT_SAPLING("Apricot Sapling", Season.SPRING, null),
    CHERRY_SAPLING("Cherry Sapling", Season.SPRING, null),
    BANANA_SAPLING("Banana Sapling", Season.SUMMER, null),
    MANGO_SAPLING("Mango Sapling", Season.SUMMER, null),
    ORANGE_SAPLING("Orange Sapling", Season.SUMMER, null),
    PEACH_SAPLING("Peach Sapling", Season.SUMMER, null),
    APPLE_SAPLING("Apple Sapling", Season.FALL, null),
    POMEGRANATE_SAPLING("Pomegranate Sapling", Season.FALL, null),
    ACORNS("Acorns", Season.ALL, null),
    MAPLE_SEEDS("Maple Seeds", Season.ALL, null),
    PINE_CONES("Pine Cones", Season.ALL, null),
    MAHOGANY_SEEDS("Mahogany Seeds", Season.ALL, null),
    MUSHROOM_TREE_SEEDS("Mushroom Tree Seeds", Season.ALL, null),
    MYSTIC_TREE_SEEDS("Mystic Tree Seeds", Season.ALL, null);
  
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
