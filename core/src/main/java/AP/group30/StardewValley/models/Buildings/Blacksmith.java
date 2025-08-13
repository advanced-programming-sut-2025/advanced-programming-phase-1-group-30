package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Maps.TileTypes;

public class Blacksmith extends Building {
    public Blacksmith(int height, int width, int startX, int startY) {
        super(height, width, startX, startY, 9, 16, TileTypes.BLACKSMITH, BuildingTexture.BLACKSMITH.getTexture());
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
