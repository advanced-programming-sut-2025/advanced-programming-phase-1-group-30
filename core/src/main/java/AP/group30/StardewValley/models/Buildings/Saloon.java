package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Maps.TileTypes;

public class Saloon extends Building {

    public Saloon(int height, int width, int startX, int startY) {
        super(height, width, startX, startY, 12, 12, TileTypes.THE_STARDROP_SALOON, BuildingTexture.SALOON.getTexture());
    }

    public int getStartHour() {
        int startHour = 12;
        return startHour;
    }
    public int getEndHour() {
        int endHour = 20;
        return endHour;
    }
}
