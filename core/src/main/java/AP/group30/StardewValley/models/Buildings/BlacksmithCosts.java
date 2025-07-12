package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.TimeAndDate.Season;
import com.badlogic.gdx.graphics.Texture;

public enum BlacksmithCosts implements ItemsInteface {
    CopperOre("copper ore", 75,Integer.MAX_VALUE, Season.ALL, ItemTexture.WOOD.getTexture()),
    IronOre("iron", 150, Integer.MAX_VALUE, Season.ALL, ItemTexture.WOOD.getTexture()),
    Coal("coal", 150, Integer.MAX_VALUE, Season.ALL, ItemTexture.WOOD.getTexture()),
    GoldOre("gold", 400, Integer.MAX_VALUE, Season.ALL, ItemTexture.WOOD.getTexture()),
    CopperTool("copper tool", 2000, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    IronTool("iron tool", 5000, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    GoldTool("gold tool", 10000, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    IridiumTool("iridium tool", 25000, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    CopperTrashCan("copper trash can", 1000, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    IronTrashCan("iron trash can", 2500, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    GoldTrashCan("gold trash can", 5000, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    IridiumTrashCan("iridium trash can", 12500, 1, Season.ALL, ItemTexture.WOOD.getTexture());


    private final String name;
    private final int cost;
    private final int dailyLimit;
    private final Season season;
    private final Texture texture;

    private BlacksmithCosts(String name, int cost, int dailyLimit, Season season, Texture texture) {
        this.name = name;
        this.cost = cost;
        this.dailyLimit = dailyLimit;
        this.season = season;
        this.texture = texture;
    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return cost;
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
}
