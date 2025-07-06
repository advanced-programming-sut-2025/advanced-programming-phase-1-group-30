package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.TimeAndDate.Season;
import com.badlogic.gdx.graphics.Texture;

public enum RanchCosts implements ItemsInteface {
    HAY("hay", 50, 999999, null, 0, Season.ALL, ItemTexture.WOOD.getTexture()),
    MILK_PAIL("milk pail", 1000, 1, null, 0, Season.ALL, ItemTexture.WOOD.getTexture()),
    SHEARS("shears", 1000, 1, null, 0, Season.ALL, ItemTexture.WOOD.getTexture()),
    CHICKEN("chicken", 800, 2, BuildingsInfo.Coop, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    COW("cow", 1500, 2, BuildingsInfo.Barn, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    GOAT("goat", 4000, 2, BuildingsInfo.Barn, 2, Season.ALL, ItemTexture.WOOD.getTexture()),
    DUCK("duck", 1200, 2, BuildingsInfo.Coop, 2, Season.ALL, ItemTexture.WOOD.getTexture()),
    SHEEP("sheep", 8000, 2, BuildingsInfo.Barn, 3, Season.ALL, ItemTexture.WOOD.getTexture()),
    RABBIT("rabbit", 8000, 2, BuildingsInfo.Coop, 3, Season.ALL, ItemTexture.WOOD.getTexture()),
    DINOSAUR("dinosaur", 14000, 2, BuildingsInfo.Coop, 2, Season.ALL, ItemTexture.WOOD.getTexture()),
    PIG("pig", 16000, 2, BuildingsInfo.Barn, 3, Season.ALL, ItemTexture.WOOD.getTexture());


    private final String name;
    private final int cost;
    private final int dailyLimit;
    private final BuildingsInfo requiredBuilding;
    private final int requiredBuildingLevel;
    private final Season season;
    private final Texture texture;

    private RanchCosts(String name, int cost, int dailyLimit, BuildingsInfo requiredBuilding, int requiredBuildingLevel, Season season, Texture texture) {
        this.name = name;
        this.cost = cost;
        this.dailyLimit = dailyLimit;
        this.requiredBuilding = requiredBuilding;
        this.requiredBuildingLevel = requiredBuildingLevel;
        this.season = season;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }

    public BuildingsInfo getRequiredBuilding() {
        return requiredBuilding;
    }

    public int getRequiredBuildingLevel() {
        return requiredBuildingLevel;
    }

    public Season getSeason() {
        return season;
    }

    public Texture getTexture() {
        return texture;
    }
}
