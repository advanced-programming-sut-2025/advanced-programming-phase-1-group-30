package AP.group30.StardewValley.models.Animals;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.TimeAndDate.Season;
import com.badlogic.gdx.graphics.Texture;

public enum FishType {
    SALMON("salmon", 75, Season.FALL, false, ItemTexture.WOOD.getTexture()),
    SARDINE("sardine", 40, Season.FALL, false, ItemTexture.WOOD.getTexture()),
    SHAD("shad", 60, Season.FALL, false, ItemTexture.WOOD.getTexture()),
    BLUE_DISCUS("blue discus", 120, Season.FALL, false, ItemTexture.WOOD.getTexture()),
    MIDNIGHT_CARP("midnight carp", 150, Season.WINTER, false, ItemTexture.WOOD.getTexture()),
    SQUID("squid", 80, Season.WINTER, false, ItemTexture.WOOD.getTexture()),
    TUNA("tuna", 100, Season.WINTER, false, ItemTexture.WOOD.getTexture()),
    PERCH("perch", 55, Season.WINTER, false, ItemTexture.WOOD.getTexture()),
    FLOUNDER("flounder", 100, Season.SPRING, false, ItemTexture.WOOD.getTexture()),
    LIONFISH("lionfish", 100, Season.SPRING, false, ItemTexture.WOOD.getTexture()),
    HERRING("herring", 30, Season.SPRING, false, ItemTexture.WOOD.getTexture()),
    GHOSTFISH("ghostfish", 45, Season.SPRING, false, ItemTexture.WOOD.getTexture()),
    TILAPIA("tilapia", 75, Season.SUMMER, false, ItemTexture.WOOD.getTexture()),
    DORADO("dorado", 100, Season.SUMMER, false, ItemTexture.WOOD.getTexture()),
    SUNFISH("sunfish", 30, Season.SUMMER, false, ItemTexture.WOOD.getTexture()),
    RAINBOW_TROUT("rainbow trout", 65, Season.SUMMER, false, ItemTexture.WOOD.getTexture()),

    // Legendary Fish
    LEGEND("legend", 5000, Season.SPRING, true, ItemTexture.WOOD.getTexture()),
    GLACIERFISH("glacierfish", 1000, Season.WINTER, true, ItemTexture.WOOD.getTexture()),
    ANGLER("angler", 900, Season.FALL, true, ItemTexture.WOOD.getTexture()),
    CRIMSONFISH("crimsonfish", 1500, Season.SUMMER, true, ItemTexture.WOOD.getTexture());

    private final String displayName;
    private final int basePrice;
    private final Season season;
    private final boolean legendary;
    private final Texture texture;

    FishType(String displayName, int basePrice, Season season, boolean legendary, Texture texture) {
        this.displayName = displayName;
        this.basePrice = basePrice;
        this.season = season;
        this.legendary = legendary;
        this.texture = texture;
    }

    public String getDisplayName() {
        return displayName;
    }
    public int getBasePrice() {
        return basePrice;
    }
    public Season getSeason() {
        return season;
    }

    public boolean isLegendary() {
        return legendary;
    }

    public Texture getTexture() {
        return texture;
    }
}
