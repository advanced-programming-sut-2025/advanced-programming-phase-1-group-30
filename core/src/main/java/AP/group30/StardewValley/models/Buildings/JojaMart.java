package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Maps.TileTypes;

public class JojaMart extends Building {

    public JojaMart(int height, int width, int startX, int startY) {
        super(height, width, startX, startY, 9, 21, TileTypes.JOJAMART, BuildingTexture.JOJA.getTexture());
    }

    public int getStartHour() {
        int startHour = 9;
        return startHour;
    }
    public int getEndHour() {
        int endHour = 21;
        return endHour;
    }
}
