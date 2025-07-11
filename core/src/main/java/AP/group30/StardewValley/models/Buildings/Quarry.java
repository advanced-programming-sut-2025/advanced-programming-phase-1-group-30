package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Maps.TileTypes;

public class Quarry extends Building {
    public Quarry(int height, int width, int startX, int startY) {
        super(height, width, startX, startY, 9, 21, TileTypes.QUARRY, ItemTexture.WOOD.getTexture());
    }
}
