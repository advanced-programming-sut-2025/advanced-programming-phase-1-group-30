package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.TimeAndDate.Season;
import com.badlogic.gdx.graphics.Texture;

public enum ForagingCropType implements ItemsInteface {
    COMMON_MUSHROOM("common mushroom", Season.ALL, 40, 38, ItemTexture.WOOD.getTexture()),
    DAFFODIL("daffodil", Season.SPRING, 30, 0, ItemTexture.WOOD.getTexture()),
    DANDELION("dandelion", Season.SPRING, 40, 25, ItemTexture.WOOD.getTexture()),
    LEEK("leek", Season.SPRING, 60, 40, ItemTexture.WOOD.getTexture()),
    MOREL("morel", Season.SPRING, 150, 20, ItemTexture.WOOD.getTexture()),
    SALMONBERRY("salmonberry", Season.SPRING, 5, 25, ItemTexture.WOOD.getTexture()),
    SPRING_ONION("spring onion", Season.SPRING, 8, 13, ItemTexture.WOOD.getTexture()),
    WILD_HORSERADISH("wild horseradish", Season.SPRING, 50, 13, ItemTexture.WOOD.getTexture()),
    FIDDLEHEAD_FERN("fiddlehead fern", Season.SUMMER, 90, 25, ItemTexture.WOOD.getTexture()),
    GRAPE("grape", Season.SUMMER, 80, 38, ItemTexture.WOOD.getTexture()),
    RED_MUSHROOM("red mushroom", Season.SUMMER, 75, -50, ItemTexture.WOOD.getTexture()),
    SPICE_BERRY("spice berry", Season.SUMMER, 80, 25, ItemTexture.WOOD.getTexture()),
    SWEET_PEA("sweet pea", Season.SUMMER, 50, 0, ItemTexture.WOOD.getTexture()),
    BLACKBERRY("blackberry", Season.FALL, 25, 25, ItemTexture.WOOD.getTexture()),
    CHANTERELLE("chanterelle", Season.FALL, 160, 75, ItemTexture.WOOD.getTexture()),
    HAZELNUT("hazelnut", Season.FALL, 40, 38, ItemTexture.WOOD.getTexture()),
    PURPLE_MUSHROOM("purple mushroom", Season.FALL, 90, 30, ItemTexture.WOOD.getTexture()),
    WILD_PLUM("wild plum", Season.FALL, 80, 25, ItemTexture.WOOD.getTexture()),
    CROCUS("crocus", Season.WINTER, 60, 0, ItemTexture.WOOD.getTexture()),
    CRYSTAL_FRUIT("crystal fruit", Season.WINTER, 150, 63, ItemTexture.WOOD.getTexture()),
    HOLLY("holly", Season.WINTER, 80, -37, ItemTexture.WOOD.getTexture()),
    SNOW_YAM("snow yam", Season.WINTER, 100, 30, ItemTexture.WOOD.getTexture()),
    WINTER_ROOT("winter root", Season.WINTER, 70, 25, ItemTexture.WOOD.getTexture());

    private final String name;
    private final Season season;
    private final int baseSellPrice;
    private final int energy;
    private final Texture texture;

    private ForagingCropType(String name, Season season, int baseSellPrice, int energy, Texture texture) {
        this.name = name;
        this.season = season;
        this.baseSellPrice = baseSellPrice;
        this.energy = energy;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }
    public Season getSeason() {
        return season;
    }
    public int getBaseSellPrice() {
        return baseSellPrice;
    }
    public int getEnergy() {
        return energy;
    }
    public Texture getTexture() {
        return texture;
    }
    public int getPrice() {
        return baseSellPrice;
    }
}
