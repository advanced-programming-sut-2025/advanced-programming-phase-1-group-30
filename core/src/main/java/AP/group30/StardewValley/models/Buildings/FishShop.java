package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Maps.TileTypes;

public class FishShop extends Building {
    public FishShop(int height, int width, int startX, int startY) {
        super(height, width, startX, startY, 9, 17, TileTypes.FISH_SHOP, BuildingTexture.FISH_SHOP.getTexture());
    }

    public int getStartHour() {
        int startHour = 9;
        return startHour;
    }
    public int getEndHour() {
        int endHour = 17;
        return endHour;
    }
}
