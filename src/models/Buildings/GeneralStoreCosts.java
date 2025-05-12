package models.Buildings;

import models.TimeAndDate.Season;

public enum GeneralStoreCosts {
    RICE("Rice", "A basic grain often served under vegetables.", 200, Integer.MAX_VALUE, Season.ALL),
    WHEAT_FLOUR("Wheat Flour", "A common cooking ingredient made from crushed wheat seeds.", 100, Integer.MAX_VALUE, Season.ALL),
    BOUQUET("Bouquet", "A gift that shows your romantic interest.", 1000, 2, Season.ALL),
    WEDDING_RING("Wedding Ring", "It's used to ask for another farmer's hand in marriage.", 10000, 2, Season.ALL),
    DEHYDRATOR_RECIPE("Dehydrator Recipe", "A recipe to make Dehydrator.", 10000, 1, Season.ALL),
    GRASS_STARTER_RECIPE("Grass Starter Recipe", "A recipe to make Grass Starter.", 1000, 1, Season.ALL),

    // Spring
    PARSNIP_SEEDS("Parsnip Seeds", "Plant these in the spring. Takes 4 days to mature.", 20, 5, Season.SPRING),
    BEAN_STARTER("Bean Starter", "Plant these in the spring. Takes 10 days to mature, keeps producing. Grows on a trellis.", 60, 5, Season.SPRING),
    CAULIFLOWER_SEEDS("Cauliflower Seeds", "Plant these in the spring. Takes 12 days to mature.", 80, 5, Season.SPRING),
    POTATO_SEEDS("Potato Seeds", "Plant these in the spring. Takes 6 days to mature. May yield multiple.", 50, 5, Season.SPRING),
    TULIP_BULB("Tulip Bulb", "Plant in spring. Takes 6 days to produce a colorful flower.", 20, 5, Season.SPRING),
    KALE_SEEDS("Kale Seeds", "Plant these in the spring. Takes 6 days to mature. Harvest with the scythe.", 70, 5, Season.SPRING),
    JAZZ_SEEDS("Jazz Seeds", "Plant in spring. Takes 7 days to produce a blue puffball flower.", 30, 5, Season.SPRING),
    GARLIC_SEEDS("Garlic Seeds", "Plant these in the spring. Takes 4 days to mature.", 40, 5, Season.SPRING),
    RICE_SHOOT("Rice Shoot", "Plant in spring. Takes 8 days. Grows faster near water. Harvest with scythe.", 40, 5, Season.SPRING),

    // Summer
    MELON_SEEDS("Melon Seeds", "Plant these in the summer. Takes 12 days to mature.", 80, 5, Season.SUMMER),
    TOMATO_SEEDS("Tomato Seeds", "Plant these in the summer. Takes 11 days to mature, continues to produce.", 50, 5, Season.SUMMER),
    BLUEBERRY_SEEDS("Blueberry Seeds", "Plant these in the summer. Takes 13 days to mature, continues to produce.", 80, 5, Season.SUMMER),
    PEPPER_SEEDS("Pepper Seeds", "Plant these in the summer. Takes 5 days to mature, continues to produce.", 40, 5, Season.SUMMER),
    WHEAT_SEEDS("Wheat Seeds", "Plant in summer or fall. Takes 4 days to mature. Harvest with scythe.", 10, 5, Season.SUMMER),
    RADISH_SEEDS("Radish Seeds", "Plant these in the summer. Takes 6 days to mature.", 40, 5, Season.SUMMER),
    POPPY_SEEDS("Poppy Seeds", "Plant in summer. Produces red flower in 7 days.", 100, 5, Season.SUMMER),
    SPANGLE_SEEDS("Spangle Seeds", "Plant in summer. Takes 8 days for vibrant tropical flower.", 50, 5, Season.SUMMER),
    HOPS_STARTER("Hops Starter", "Plant these in the summer. Takes 11 days, keeps producing. Trellis.", 60, 5, Season.SUMMER),
    CORN_SEEDS_SUMMER("Corn Seeds (Summer)", "Plant in summer or fall. Takes 14 days. Keeps producing.", 150, 5, Season.SUMMER),
    SUNFLOWER_SEEDS_SUMMER("Sunflower Seeds (Summer)", "Plant in summer or fall. Takes 8 days. Yields more seeds.", 200, 5, Season.SUMMER),
    RED_CABBAGE_SEEDS("Red Cabbage Seeds", "Plant these in the summer. Takes 9 days to mature.", 100, 5, Season.SUMMER),

    // Fall
    EGGPLANT_SEEDS("Eggplant Seeds", "Plant these in the fall. Takes 5 days. Keeps producing.", 20, 5, Season.FALL),
    CORN_SEEDS_FALL("Corn Seeds (Fall)", "Plant in summer or fall. Takes 14 days. Keeps producing.", 150, 5, Season.FALL),
    PUMPKIN_SEEDS("Pumpkin Seeds", "Plant these in the fall. Takes 13 days to mature.", 100, 5, Season.FALL),
    BOK_CHOY_SEEDS("Bok Choy Seeds", "Plant these in the fall. Takes 4 days to mature.", 50, 5, Season.FALL),
    YAM_SEEDS("Yam Seeds", "Plant these in the fall. Takes 10 days to mature.", 60, 5, Season.FALL),
    CRANBERRY_SEEDS("Cranberry Seeds", "Plant in fall. Takes 7 days. Keeps producing.", 240, 5, Season.FALL),
    SUNFLOWER_SEEDS_FALL("Sunflower Seeds (Fall)", "Plant in summer or fall. Takes 8 days. Yields more seeds.", 200, 5, Season.FALL),
    FAIRY_SEEDS("Fairy Seeds", "Plant in fall. Takes 12 days for mysterious flower.", 200, 5, Season.FALL),
    AMARANTH_SEEDS("Amaranth Seeds", "Plant these in the fall. Takes 7 days. Harvest with scythe.", 70, 5, Season.FALL),
    GRAPE_STARTER("Grape Starter", "Plant in fall. Takes 10 days. Keeps producing. Trellis.", 60, 5, Season.FALL),
    WHEAT_SEEDS_FALL("Wheat Seeds (Fall)", "Plant in summer or fall. Takes 4 days to mature. Harvest with scythe.", 10, 5, Season.FALL),
    ARTICHOKE_SEEDS("Artichoke Seeds", "Plant in the fall. Takes 8 days to mature.", 30, 5, Season.FALL);

    public final String name;
    public final String description;
    public final int price;
    public final int seasonPrice;
    public final int dailyLimit;
    public final Season season;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getSeasonPrice() {
        return seasonPrice;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }

    public Season getSeason() {
        return season;
    }

    GeneralStoreCosts(String name, String description, int price, int dailyLimit, Season season) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.dailyLimit = dailyLimit;
        this.season = season;
        this.seasonPrice = (price * 2 / 3);
    }
}
