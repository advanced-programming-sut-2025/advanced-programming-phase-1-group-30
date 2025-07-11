package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Maps.TileTypes;

public class FishShop extends Building {
    public FishShop(int height, int width, int startX, int startY) {
        super(height, width, startX, startY, 9, 17, TileTypes.FISH_SHOP, ItemTexture.FISH_SHOP.getTexture());
    }
    private final int startHour = 9;
    private final int endHour = 17;

    public int getStartHour() {
        return startHour;
    }
    public int getEndHour() {
        return endHour;
    }
}
