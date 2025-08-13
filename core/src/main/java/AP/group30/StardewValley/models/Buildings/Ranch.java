package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Maps.TileTypes;

public class Ranch extends Building {
    public Ranch(int height, int width, int startX, int startY) {
        super(height, width, startX, startY, 9, 16, TileTypes.MARINES_RANCH, BuildingTexture.RANCH.getTexture());
    }

    private RanchCosts ranchItems;

    public RanchCosts getRanchItems() {
        return ranchItems;
    }
    public int getStartHour() {
        int startHour = 9;
        return startHour;
    }
    public int getEndHour() {
        int endHour = 16;
        return endHour;
    }
}
