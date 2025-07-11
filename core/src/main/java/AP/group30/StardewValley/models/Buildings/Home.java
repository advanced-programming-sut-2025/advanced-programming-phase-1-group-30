package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Maps.TileTypes;

public class Home extends Building {

    public Home(int lenght, int width, int startX, int startY) {
        super(lenght, width, startX, startY, 9, 21, TileTypes.HUT, GameAssetManager.assetManager.get(GameAssetManager.house));
        //TODO Auto-generated constructor stub
    }

}
