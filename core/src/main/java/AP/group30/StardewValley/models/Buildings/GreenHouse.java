package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Maps.Tile;
import AP.group30.StardewValley.models.Maps.TileTypes;
import java.util.ArrayList;
public class GreenHouse extends Building {
//    private ArrayList<Tile> tiles = new ArrayList<>();

    public GreenHouse(int height, int width, int startX, int startY) {
        super(height, width, startX, startY, 9, 21, TileTypes.GREENHOUSE,
            GameAssetManager.assetManager.get(GameAssetManager.ruinedGreenhouse));
//        for(Tile[] tileRow :App.getCurrentGame().getCurrentPlayer().getMap().getTiles()){
//            for(Tile tile : tileRow){
//                if(tile.getType().equals(TileTypes.GREENHOUSE)){
////                    tile.changeWalkable();
//                    tiles.add(tile);
//                }
//            }
//        }
    }


//    public ArrayList<Tile> getTiles() {
//        return tiles;
//    }

    public void buildGreenhouse() {
        this.texture = GameAssetManager.assetManager.get(GameAssetManager.builtGreenhouse);
    }
}
