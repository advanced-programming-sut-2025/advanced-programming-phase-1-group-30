package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Maps.TileTypes;

public class Hut extends Building {
    public Hut(int height, int width, int startX, int startY) {
        super(height, width, startX, startY, 9, 21, TileTypes.HUT, GameAssetManager.assetManager.get(GameAssetManager.house));
    }
}
