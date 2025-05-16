package models.Buildings;

import models.Items.ItemsInteface;
import models.TimeAndDate.Season;

public enum GeneralStoreCosts implements ItemsInteface {
    RICE("rice", "A basic grain often served under vegetables.", 200, Integer.MAX_VALUE, Season.ALL),
    WHEAT_FLOUR("wheat flour", "A common cooking ingredient made from crushed wheat seeds.", 100, Integer.MAX_VALUE, Season.ALL),
    BOUQUET("bouquet", "A gift that shows your romantic interest.", 1000, 2, Season.ALL),
    WEDDING_RING("wedding ring", "It's used to ask for another farmer's hand in marriage.", 10000, 2, Season.ALL),
    DEHYDRATOR_RECIPE("dehydrator recipe", "A recipe to make Dehydrator.", 10000, 1, Season.ALL),
    GRASS_STARTER_RECIPE("grass starter recipe", "A recipe to make Grass Starter.", 1000, 1, Season.ALL),

    // Spring
    PARSNIP_SEEDS("parsnip seeds", "Plant these in the spring. Takes 4 days to mature.", 20, 5, Season.SPRING),
    BEAN_STARTER("bean starter", "Plant these in the spring. Takes 10 days to mature, keeps producing. Grows on a trellis.", 60, 5, Season.SPRING),
    CAULIFLOWER_SEEDS("cauliflower seeds", "Plant these in the spring. Takes 12 days to mature.", 80, 5, Season.SPRING),
    POTATO_SEEDS("potato seeds", "Plant these in the spring. Takes 6 days to mature. May yield multiple.", 50, 5, Season.SPRING),
    TULIP_BULB("tulip bulb", "Plant in spring. Takes 6 days to produce a colorful flower.", 20, 5, Season.SPRING),
    KALE_SEEDS("kale seeds", "Plant these in the spring. Takes 6 days to mature. Harvest with the scythe.", 70, 5, Season.SPRING),
    JAZZ_SEEDS("jazz seeds", "Plant in spring. Takes 7 days to produce a blue puffball flower.", 30, 5, Season.SPRING),
    GARLIC_SEEDS("garlic seeds", "Plant these in the spring. Takes 4 days to mature.", 40, 5, Season.SPRING),
    RICE_SHOOT("rice shoot", "Plant in spring. Takes 8 days. Grows faster near water. Harvest with scythe.", 40, 5, Season.SPRING),

    // Summer
    MELON_SEEDS("melon seeds", "Plant these in the summer. Takes 12 days to mature.", 80, 5, Season.SUMMER),
    TOMATO_SEEDS("tomato seeds", "Plant these in the summer. Takes 11 days to mature, continues to produce.", 50, 5, Season.SUMMER),
    BLUEBERRY_SEEDS("blueberry seeds", "Plant these in the summer. Takes 13 days to mature, continues to produce.", 80, 5, Season.SUMMER),
    PEPPER_SEEDS("pepper seeds", "Plant these in the summer. Takes 5 days to mature, continues to produce.", 40, 5, Season.SUMMER),
    WHEAT_SEEDS("wheat seeds", "Plant in summer or fall. Takes 4 days to mature. Harvest with scythe.", 10, 5, Season.SUMMER),
    RADISH_SEEDS("radish seeds", "Plant these in the summer. Takes 6 days to mature.", 40, 5, Season.SUMMER),
    POPPY_SEEDS("poppy seeds", "Plant in summer. Produces red flower in 7 days.", 100, 5, Season.SUMMER),
    SPANGLE_SEEDS("spangle seeds", "Plant in summer. Takes 8 days for vibrant tropical flower.", 50, 5, Season.SUMMER),
    HOPS_STARTER("hops starter", "Plant these in the summer. Takes 11 days, keeps producing. Trellis.", 60, 5, Season.SUMMER),
    CORN_SEEDS_SUMMER("corn seeds (summer)", "Plant in summer or fall. Takes 14 days. Keeps producing.", 150, 5, Season.SUMMER),
    SUNFLOWER_SEEDS_SUMMER("sunflower seeds (summer)", "Plant in summer or fall. Takes 8 days. Yields more seeds.", 200, 5, Season.SUMMER),
    RED_CABBAGE_SEEDS("red cabbage seeds", "Plant these in the summer. Takes 9 days to mature.", 100, 5, Season.SUMMER),

    // Fall
    EGGPLANT_SEEDS("eggplant seeds", "Plant these in the fall. Takes 5 days. Keeps producing.", 20, 5, Season.FALL),
    CORN_SEEDS_FALL("corn seeds (fall)", "Plant in summer or fall. Takes 14 days. Keeps producing.", 150, 5, Season.FALL),
    PUMPKIN_SEEDS("pumpkin seeds", "Plant these in the fall. Takes 13 days to mature.", 100, 5, Season.FALL),
    BOK_CHOY_SEEDS("bok choy seeds", "Plant these in the fall. Takes 4 days to mature.", 50, 5, Season.FALL),
    YAM_SEEDS("yam seeds", "Plant these in the fall. Takes 10 days to mature.", 60, 5, Season.FALL),
    CRANBERRY_SEEDS("cranberry seeds", "Plant in fall. Takes 7 days. Keeps producing.", 240, 5, Season.FALL),
    SUNFLOWER_SEEDS_FALL("sunflower seeds (fall)", "Plant in summer or fall. Takes 8 days. Yields more seeds.", 200, 5, Season.FALL),
    FAIRY_SEEDS("fairy seeds", "Plant in fall. Takes 12 days for mysterious flower.", 200, 5, Season.FALL),
    AMARANTH_SEEDS("amaranth seeds", "Plant these in the fall. Takes 7 days. Harvest with scythe.", 70, 5, Season.FALL),
    GRAPE_STARTER("grape starter", "Plant in fall. Takes 10 days. Keeps producing. Trellis.", 60, 5, Season.FALL),
    WHEAT_SEEDS_FALL("wheat seeds (fall)", "Plant in summer or fall. Takes 4 days to mature. Harvest with scythe.", 10, 5, Season.FALL),
    ARTICHOKE_SEEDS("artichoke seeds", "Plant in the fall. Takes 8 days to mature.", 30, 5, Season.FALL),

    LARGE_PACK("large pack", "Unlocks the 2nd row of inventory (12 more slots, total 24).", 2000, 1, Season.ALL),
    DELUXE_PACK("deluxe pack", "Unlocks the 3rd row of inventory (infinite slots).", 10000, 1, Season.ALL);

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
