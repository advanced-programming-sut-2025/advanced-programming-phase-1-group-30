package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.TimeAndDate.Season;
import com.badlogic.gdx.graphics.Texture;

public enum GeneralStoreCosts implements ItemsInteface {
    RICE("rice", "A basic grain often served under vegetables.", 200, Integer.MAX_VALUE, Season.ALL, ItemTexture.WOOD.getTexture()),
    WHEAT_FLOUR("wheat flour", "A common cooking ingredient made from crushed wheat seeds.", 100, Integer.MAX_VALUE, Season.ALL, ItemTexture.WOOD.getTexture()),
    BOUQUET("bouquet", "A gift that shows your romantic interest.", 1000, 2, Season.ALL, ItemTexture.WOOD.getTexture()),
    WEDDING_RING("wedding ring", "It's used to ask for another farmer's hand in marriage.", 10000, 2, Season.ALL, ItemTexture.WOOD.getTexture()),
    DEHYDRATOR_RECIPE("dehydrator recipe", "A recipe to make Dehydrator.", 10000, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    GRASS_STARTER_RECIPE("grass starter recipe", "A recipe to make Grass Starter.", 1000, 1, Season.ALL, ItemTexture.WOOD.getTexture()),

    // Spring
    PARSNIP_SEEDS("parsnip seeds", "Plant these in the spring. Takes 4 days to mature.", 20, 5, Season.SPRING, ItemTexture.WOOD.getTexture()),
    BEAN_STARTER("bean starter", "Plant these in the spring. Takes 10 days to mature, keeps producing. Grows on a trellis.", 60, 5, Season.SPRING, ItemTexture.WOOD.getTexture()),
    CAULIFLOWER_SEEDS("cauliflower seeds", "Plant these in the spring. Takes 12 days to mature.", 80, 5, Season.SPRING, ItemTexture.WOOD.getTexture()),
    POTATO_SEEDS("potato seeds", "Plant these in the spring. Takes 6 days to mature. May yield multiple.", 50, 5, Season.SPRING, ItemTexture.WOOD.getTexture()),
    TULIP_BULB("tulip bulb", "Plant in spring. Takes 6 days to produce a colorful flower.", 20, 5, Season.SPRING, ItemTexture.WOOD.getTexture()),
    KALE_SEEDS("kale seeds", "Plant these in the spring. Takes 6 days to mature. Harvest with the scythe.", 70, 5, Season.SPRING, ItemTexture.WOOD.getTexture()),
    JAZZ_SEEDS("jazz seeds", "Plant in spring. Takes 7 days to produce a blue puffball flower.", 30, 5, Season.SPRING, ItemTexture.WOOD.getTexture()),
    GARLIC_SEEDS("garlic seeds", "Plant these in the spring. Takes 4 days to mature.", 40, 5, Season.SPRING, ItemTexture.WOOD.getTexture()),
    RICE_SHOOT("rice shoot", "Plant in spring. Takes 8 days. Grows faster near water. Harvest with scythe.", 40, 5, Season.SPRING, ItemTexture.WOOD.getTexture()),

    // Summer
    MELON_SEEDS("melon seeds", "Plant these in the summer. Takes 12 days to mature.", 80, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    TOMATO_SEEDS("tomato seeds", "Plant these in the summer. Takes 11 days to mature, continues to produce.", 50, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    BLUEBERRY_SEEDS("blueberry seeds", "Plant these in the summer. Takes 13 days to mature, continues to produce.", 80, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    PEPPER_SEEDS("pepper seeds", "Plant these in the summer. Takes 5 days to mature, continues to produce.", 40, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    WHEAT_SEEDS("wheat seeds", "Plant in summer or fall. Takes 4 days to mature. Harvest with scythe.", 10, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    RADISH_SEEDS("radish seeds", "Plant these in the summer. Takes 6 days to mature.", 40, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    POPPY_SEEDS("poppy seeds", "Plant in summer. Produces red flower in 7 days.", 100, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    SPANGLE_SEEDS("spangle seeds", "Plant in summer. Takes 8 days for vibrant tropical flower.", 50, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    HOPS_STARTER("hops starter", "Plant these in the summer. Takes 11 days, keeps producing. Trellis.", 60, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    CORN_SEEDS_SUMMER("corn seeds (summer)", "Plant in summer or fall. Takes 14 days. Keeps producing.", 150, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    SUNFLOWER_SEEDS_SUMMER("sunflower seeds (summer)", "Plant in summer or fall. Takes 8 days. Yields more seeds.", 200, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    RED_CABBAGE_SEEDS("red cabbage seeds", "Plant these in the summer. Takes 9 days to mature.", 100, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),

    // Fall
    EGGPLANT_SEEDS("eggplant seeds", "Plant these in the fall. Takes 5 days. Keeps producing.", 20, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    CORN_SEEDS_FALL("corn seeds (fall)", "Plant in summer or fall. Takes 14 days. Keeps producing.", 150, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    PUMPKIN_SEEDS("pumpkin seeds", "Plant these in the fall. Takes 13 days to mature.", 100, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    BOK_CHOY_SEEDS("bok choy seeds", "Plant these in the fall. Takes 4 days to mature.", 50, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    YAM_SEEDS("yam seeds", "Plant these in the fall. Takes 10 days to mature.", 60, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    CRANBERRY_SEEDS("cranberry seeds", "Plant in fall. Takes 7 days. Keeps producing.", 240, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    SUNFLOWER_SEEDS_FALL("sunflower seeds (fall)", "Plant in summer or fall. Takes 8 days. Yields more seeds.", 200, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    FAIRY_SEEDS("fairy seeds", "Plant in fall. Takes 12 days for mysterious flower.", 200, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    AMARANTH_SEEDS("amaranth seeds", "Plant these in the fall. Takes 7 days. Harvest with scythe.", 70, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    GRAPE_STARTER("grape starter", "Plant in fall. Takes 10 days. Keeps producing. Trellis.", 60, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    WHEAT_SEEDS_FALL("wheat seeds (fall)", "Plant in summer or fall. Takes 4 days to mature. Harvest with scythe.", 10, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    ARTICHOKE_SEEDS("artichoke seeds", "Plant in the fall. Takes 8 days to mature.", 30, 5, Season.FALL, ItemTexture.WOOD.getTexture()),

    LARGE_PACK("large pack", "Unlocks the 2nd row of inventory (12 more slots, total 24).", 2000, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    DELUXE_PACK("deluxe pack", "Unlocks the 3rd row of inventory (infinite slots).", 10000, 1, Season.ALL, ItemTexture.WOOD.getTexture());

    public final String name;
    public final String description;
    public final int price;
    public final int seasonPrice;
    public final int dailyLimit;
    public final Season season;
    private final Texture texture;

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

    public Texture getTexture() {
        return texture;
    }

    GeneralStoreCosts(String name, String description, int price, int dailyLimit, Season season, Texture texture) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.dailyLimit = dailyLimit;
        this.season = season;
        this.seasonPrice = (price * 2 / 3);
        this.texture = texture;
    }
}
