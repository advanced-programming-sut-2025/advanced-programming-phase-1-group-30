package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Maps.TileTypes;

public class JojaMart extends Building {

    public JojaMart(int height, int width, int startX, int startY) {
        super(height, width, startX, startY, 9, 21, TileTypes.JOJAMART, ItemTexture.JOJA.getTexture());
    }
    private final int startHour = 9;
    private final int endHour = 21;

    public int getStartHour() {
        return startHour;
    }
    public int getEndHour() {
        return endHour;
    }
}
