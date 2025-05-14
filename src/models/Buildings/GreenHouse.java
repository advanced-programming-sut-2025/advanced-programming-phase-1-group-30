package models.Buildings;

import models.App;
import models.Maps.Tile;
import models.Maps.TileTypes;
import java.util.ArrayList;
public class GreenHouse {
    private ArrayList<Tile> tiles = new ArrayList<>();

    public GreenHouse() {
        for(Tile[] tileRow :App.getCurrentGame().getCurrentPlayer().getMap().getTiles()){
            for(Tile tile : tileRow){
                if(tile.getType().equals(TileTypes.GREENHOUSE)){
                    tile.changeWalkable();
                    tiles.add(tile);
                }
            }
        }
    }


    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}
