package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Maps.Tile;
import AP.group30.StardewValley.models.Maps.TileTypes;
import java.util.ArrayList;
public class GreenHouse extends Building {
    private boolean built = false;

    public GreenHouse(int height, int width, int startX, int startY) {
        super(height, width, startX, startY, 9, 21, TileTypes.GREENHOUSE,
            GameAssetManager.assetManager.get(GameAssetManager.ruinedGreenhouse));
    }

    public boolean isBuilt() {
        return built;
    }

    public void buildGreenhouse() {
        this.texture = GameAssetManager.assetManager.get(GameAssetManager.builtGreenhouse);
        built = true;
        App.getCurrentGame().getCurrentPlayer().getMap().getBuildings().add(this);
    }
}
