package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.TimeAndDate.Season;
import com.badlogic.gdx.graphics.Texture;

public enum FruitType implements ItemsInteface {
    APRICOT("apricot", 1, 59, true, 38, Season.SPRING, ItemTexture.WOOD.getTexture()),
    CHERRY("cherry", 1, 80, true, 38, Season.SPRING, ItemTexture.WOOD.getTexture()),
    BANANA("banana", 1, 150, true, 75, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    MANGO("mango", 1, 130, true, 100, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    ORANGE("orange", 1, 100, true, 38, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    PEACH("peach", 1, 140, true, 38, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    APPLE("apple", 1, 100, true, 38, Season.FALL, ItemTexture.WOOD.getTexture()),
    POMEGRANATE("pomegranate", 1, 140, true, 38, Season.FALL, ItemTexture.WOOD.getTexture()),
    OAK_RESIN("oak resin", 7, 150, false, 0, Season.ALL, ItemTexture.WOOD.getTexture()),
    MAPLE_SYRUP("maple syrup", 9, 200, false, 0, Season.ALL, ItemTexture.WOOD.getTexture()),
    PINE_TAR("pine tar", 5, 100, false, 0, Season.ALL, ItemTexture.WOOD.getTexture()),
    SAP("sap", 1, 2, true, -2, Season.ALL, ItemTexture.WOOD.getTexture()),
    COMMON_MUSHROOM("common mushroom", 1, 40, true, 38, Season.ALL, ItemTexture.WOOD.getTexture()),
    MYSTIC_SYRUP("mystic syrup", 7, 1000, true, 500, Season.ALL, ItemTexture.WOOD.getTexture());

    private final String name;
    private final int harvestCycle;
    private final int baseSellPrice;
    private final boolean isFruitEdible;
    private final int energy;
    private final Season season;
    private final Texture texture;

    private FruitType(String name, int harvestCycle, int baseSellPrice, boolean isFruitEdible, int energy,
            Season season, Texture texture) {
        this.name = name;
        this.harvestCycle = harvestCycle;
        this.baseSellPrice = baseSellPrice;
        this.isFruitEdible = isFruitEdible;
        this.energy = energy;
        this.season = season;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }
    public int getHarvestCycle() {
        return harvestCycle;
    }
    public int getBaseSellPrice() {
        return baseSellPrice;
    }
    public boolean isFruitEdible() {
        return isFruitEdible;
    }
    public int getEnergy() {
        return energy;
    }
    public Season getSeason() {
        return season;
    }
    public Texture getTexture() {
        return texture;
    }
}
