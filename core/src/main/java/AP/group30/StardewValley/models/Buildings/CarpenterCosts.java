package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.TimeAndDate.Season;
import com.badlogic.gdx.graphics.Texture;

public enum CarpenterCosts implements ItemsInteface {
    WOOD("wood", 10, 0, 0, 0, 0, Integer.MAX_VALUE, Season.ALL, ItemTexture.WOOD.getTexture()),
    STONE("stone", 20, 0, 0, 0, 0, Integer.MAX_VALUE, Season.ALL, ItemTexture.WOOD.getTexture()),
    BARN("barn", 6000, 350, 150, 5, 7, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    BIG_BARN("big barn", 12000, 450, 200, 5, 7, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    DELUXE_BARN("deluxe barn", 25000, 550, 300, 5, 7, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    COOP("coop", 4000, 300, 100, 4, 6, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    BIG_COOP("big coop", 10000, 400, 150, 4, 6, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    DELUXE_COOP("deluxe coop", 20000, 500, 200, 4, 6, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    WELL("well", 1000, 0, 75, 1, 1, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    SHIPPING_BIN("shipping bin", 250, 150, 0, 1, 1, Integer.MAX_VALUE, Season.ALL, ItemTexture.WOOD.getTexture());

    private final String name;
    private final int price;
    private final int wood;
    private final int stone;
    private final int height;
    private final int width;
    private final int dailyLimit;
    private final Season season;
    private final Texture texture;

    CarpenterCosts(String name, int price, int wood, int stone, int height, int width, int dailyLimit, Season season, Texture texture) {
        this.name = name;
        this.price = price;
        this.wood = wood;
        this.stone = stone;
        this.height = height;
        this.width = width;
        this.dailyLimit = dailyLimit;
        this.season = season;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public int getWood() {
        return wood;
    }

    public int getStone() {
        return stone;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
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

    @Override
    public int getPrice() {
        return price;
    }
}

