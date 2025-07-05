package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.TimeAndDate.Season;
import com.badlogic.gdx.graphics.Texture;

public enum FishShopCosts implements ItemsInteface {

    FISH_SMOKER_RECIPE("A recipe to make Fish Smoker", "Use this recipe to craft a Fish Smoker.", 10000, -1, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    TROUT_SOUP("trout soup", "Pretty salty.", 250, -1, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    BAMBOO_POLE("bamboo pole", "Use in the water to catch fish.", 500, -1, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    TRAINING_ROD("training rod", "It's a lot easier to use than other rods, but can only catch basic fish.", 25, -1, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    FIBERGLASS_ROD("fiberglass rod", "Use in the water to catch fish.", 1800, 2, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    IRIDIUM_ROD("iridium rod", "Use in the water to catch fish.", 7500, 4, 1, Season.ALL, ItemTexture.WOOD.getTexture());


    private final String name;
    private final String description;
    private final int price;
    private final int fishingSkillRequired; // -1 means no requirement
    private final int dailyLimit;
    private final Season season;
    private final Texture texture;

    public Season getSeason() {
        return season;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getFishingSkillRequired() {
        return fishingSkillRequired;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }

    public Texture getTexture() {
        return texture;
    }

    FishShopCosts(String name, String description, int price, int fishingSkillRequired, int dailyLimit, Season season, Texture texture) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.fishingSkillRequired = fishingSkillRequired;
        this.dailyLimit = dailyLimit;
        this.season = season;
        this.texture = texture;
    }
}
