package models.Items.Products;

import models.TimeAndDate.Season;

public enum ForgingSeedType {
    JAZZ_SEEDS("Jazz Seeds", Season.SPRING, CropType.BLUE_JAZZ),
    CARROT_SEEDS("Carrot Seeds", Season.SPRING, CropType.CARROT),
    CAULIFLOWER_SEEDS("Cauliflower Seeds", Season.SPRING, CropType.CAULIFLOWER),
    COFFEE_BEAN("Coffee Bean", Season.SPRING, CropType.COFFEE_BEAN),
    GARLIC_SEEDS("Garlic Seeds", Season.SPRING, CropType.GARLIC),
    BEAN_STARTER("Bean Starter", Season.SPRING, CropType.GREEN_BEAN),
    KALE_SEEDS("Kale Seeds", Season.SPRING, CropType.KALE),
    PARSNIP_SEEDS("Parsnip Seeds", Season.SPRING, CropType.PARSNIP),
    POTATO_SEEDS("Potato Seeds", Season.SPRING, CropType.POTATO),
    RHUBARB_SEEDS("Rhubarb Seeds", Season.SPRING, CropType.RHUBARB),
    STRAWBERRY_SEEDS("Strawberry Seeds", Season.SPRING, CropType.STRAWBERRY),
    TULIP_BULB("Tulip Bulb", Season.SPRING, CropType.TULIP),
    RICE_SHOOT("Rice Shoot", Season.SPRING, CropType.UNMILLED_RICE),
    BLUEBERRY_SEEDS("Blueberry Seeds", Season.SUMMER, CropType.BLUEBERRY),
    CORN_SEEDS("Corn Seeds", Season.SUMMER, CropType.CORN),
    HOPS_STARTER("Hops Starter", Season.SUMMER, CropType.HOPS),
    PEPPER_SEEDS("Pepper Seeds", Season.SUMMER, CropType.HOT_PEPPER),
    MELON_SEEDS("Melon Seeds", Season.SUMMER, CropType.MELON),
    POPPY_SEEDS("Poppy Seeds", Season.SUMMER, CropType.POPPY),
    RADISH_SEEDS("Radish Seeds", Season.SUMMER, CropType.RADISH),
    RED_CABBAGE_SEEDS("Red Cabbage Seeds", Season.SUMMER, CropType.RED_CABBAGE),
    STARFRUIT_SEEDS("Starfruit Seeds", Season.SUMMER, CropType.STARFRUIT),
    SPANGLE_SEEDS("Spangle Seeds", Season.SUMMER, CropType.SUMMER_SPANGLE),
    SUMMER_SQUASH_SEEDS("Summer Squash Seeds", Season.SUMMER, CropType.SUMMER_SQUASH),
    SUNFLOWER_SEEDS("Sunflower Seeds", Season.SUMMER, CropType.SUNFLOWER),
    TOMATO_SEEDS("Tomato Seeds", Season.SUMMER, CropType.TOMATO),
    WHEAT_SEEDS("Wheat Seeds", Season.SUMMER, CropType.WHEAT),
    AMARANTH_SEEDS("Amaranth Seeds", Season.FALL, CropType.AMARANTH),
    ARTICHOKE_SEEDS("Artichoke Seeds", Season.FALL, CropType.ARTICHOKE),
    BEET_SEEDS("Beet Seeds", Season.FALL, CropType.BEET),
    BOK_CHOY_SEEDS("Bok Choy Seeds", Season.FALL, CropType.BOK_CHOY),
    BROCCOLI_SEEDS("Broccoli Seeds", Season.FALL, CropType.BROCCOLI),
    CRANBERRY_SEEDS("Cranberry Seeds", Season.FALL, CropType.CRANBERRIES),
    EGGPLANT_SEEDS("Eggplant Seeds", Season.FALL, CropType.EGGPLANT),
    FAIRY_SEEDS("Fairy Seeds", Season.FALL, CropType.FAIRY_ROSE),
    GRAPE_STARTER("Grape Starter", Season.FALL, CropType.GRAPE),
    PUMPKIN_SEEDS("Pumpkin Seeds", Season.FALL, CropType.PUMPKIN),
    YAM_SEEDS("Yam Seeds", Season.FALL, CropType.YAM),
    RARE_SEED("Rare Seed", Season.FALL, CropType.SWEET_GEM_BERRY),
    POWDERMELON_SEEDS("Powdermelon Seeds", Season.WINTER, CropType.POWDERMELON),
    ANCIENT_SEEDS("Ancient Seeds", Season.ALL, CropType.ANCIENT_FRUIT),
    MIXED_SEEDS("Mixed Seeds", Season.ALL, null), // TODO

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
