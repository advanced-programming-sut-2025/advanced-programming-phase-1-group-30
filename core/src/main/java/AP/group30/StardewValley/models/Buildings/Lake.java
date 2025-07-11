package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Maps.TileTexture;
import AP.group30.StardewValley.models.Maps.TileTypes;

public class Lake extends Building {

    public Lake(int height, int width, int startX, int startY) {
        super(height, width, startX, startY, 9, 21, TileTypes.WATER, TileTexture.RIVER.getTexture());
    }
}
