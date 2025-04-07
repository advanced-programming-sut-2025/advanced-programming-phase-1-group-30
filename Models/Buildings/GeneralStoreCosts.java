package Models.Buildings;

public enum GeneralStoreCosts {
    RICE("A basic grain often served under vegetables.", 200, Integer.MAX_VALUE, Season.All),
    WHEAT_FLOUR("A common cooking ingredient made from crushed wheat seeds.", 100, Integer.MAX_VALUE, Season.All),
    BOUQUET("A gift that shows your romantic interest.", 1000, 2, Season.All),
    WEDDING_RING("It's used to ask for another farmer's hand in marriage.", 10000, 2, Season.All),
    DEHYDRATOR_RECIPE("A recipe to make Dehydrator.", 10000, 1, Season.All),
    GRASS_STARTER_RECIPE("A recipe to make Grass Starter.", 1000, 1, Season.All),

    // Spring
    PARSNIP_SEEDS("Plant these in the spring. Takes 4 days to mature.", 20, 5, Season.Spring),
    BEAN_STARTER("Plant these in the spring. Takes 10 days to mature, keeps producing. Grows on a trellis.", 60, 5, Season.Spring),
    CAULIFLOWER_SEEDS("Plant these in the spring. Takes 12 days to mature.", 80, 5, Season.Spring),
    POTATO_SEEDS("Plant these in the spring. Takes 6 days to mature. May yield multiple.", 50, 5, Season.Spring),
    TULIP_BULB("Plant in spring. Takes 6 days to produce a colorful flower.", 20, 5, Season.Spring),
    KALE_SEEDS("Plant these in the spring. Takes 6 days to mature. Harvest with the scythe.", 70, 5, Season.Spring),
    JAZZ_SEEDS("Plant in spring. Takes 7 days to produce a blue puffball flower.", 30, 5, Season.Spring),
    GARLIC_SEEDS("Plant these in the spring. Takes 4 days to mature.", 40, 5, Season.Spring),
    RICE_SHOOT("Plant in spring. Takes 8 days. Grows faster near water. Harvest with scythe.", 40, 5, Season.Spring),

    // Summer
    MELON_SEEDS("Plant these in the summer. Takes 12 days to mature.", 80, 5, Season.Summer),
    TOMATO_SEEDS("Plant these in the summer. Takes 11 days to mature, continues to produce.", 50, 5, Season.Summer),
    BLUEBERRY_SEEDS("Plant these in the summer. Takes 13 days to mature, continues to produce.", 80, 5, Season.Summer),
    PEPPER_SEEDS("Plant these in the summer. Takes 5 days to mature, continues to produce.", 40, 5, Season.Summer),
    WHEAT_SEEDS("Plant in summer or fall. Takes 4 days to mature. Harvest with scythe.", 10, 5, Season.Summer),
    RADISH_SEEDS("Plant these in the summer. Takes 6 days to mature.", 40, 5, Season.Summer),
    POPPY_SEEDS("Plant in summer. Produces red flower in 7 days.", 100, 5, Season.Summer),
    SPANGLE_SEEDS("Plant in summer. Takes 8 days for vibrant tropical flower.", 50, 5, Season.Summer),
    HOPS_STARTER("Plant these in the summer. Takes 11 days, keeps producing. Trellis.", 60, 5, Season.Summer),
    CORN_SEEDS_SUMMER("Plant in summer or fall. Takes 14 days. Keeps producing.", 150, 5, Season.Summer),
    SUNFLOWER_SEEDS_SUMMER("Plant in summer or fall. Takes 8 days. Yields more seeds.", 200, 5, Season.Summer),
    RED_CABBAGE_SEEDS("Plant these in the summer. Takes 9 days to mature.", 100, 5, Season.Summer),

    // Fall
    EGGPLANT_SEEDS("Plant these in the fall. Takes 5 days. Keeps producing.", 20, 5, Season.Fall),
    CORN_SEEDS_FALL("Plant in summer or fall. Takes 14 days. Keeps producing.", 150, 5, Season.Fall),
    PUMPKIN_SEEDS("Plant these in the fall. Takes 13 days to mature.", 100, 5, Season.Fall),
    BOK_CHOY_SEEDS("Plant these in the fall. Takes 4 days to mature.", 50, 5, Season.Fall),
    YAM_SEEDS("Plant these in the fall. Takes 10 days to mature.", 60, 5, Season.Fall),
    CRANBERRY_SEEDS("Plant in fall. Takes 7 days. Keeps producing.", 240, 5, Season.Fall),
    SUNFLOWER_SEEDS_FALL("Plant in summer or fall. Takes 8 days. Yields more seeds.", 200, 5, Season.Fall),
    FAIRY_SEEDS("Plant in fall. Takes 12 days for mysterious flower.", 200, 5, Season.Fall),
    AMARANTH_SEEDS("Plant these in the fall. Takes 7 days. Harvest with scythe.", 70, 5, Season.Fall),
    GRAPE_STARTER("Plant in fall. Takes 10 days. Keeps producing. Trellis.", 60, 5, Season.Fall),
    WHEAT_SEEDS_FALL("Plant in summer or fall. Takes 4 days to mature. Harvest with scythe.", 10, 5, Season.Fall),
    ARTICHOKE_SEEDS("Plant in the fall. Takes 8 days to mature.", 30, 5, Season.Fall);

    public final String description;
    public final int price;
    public final int seasonPrice;
    public final int dailyLimit;
    public final Season season;

    GeneralStoreCosts(String description, int price, int dailyLimit, Season season) {
        this.description = description;
        this.price = price;
        this.dailyLimit = dailyLimit;
        this.season = season;
        this.seasonPrice = (price * 2 / 3);
    }
}
