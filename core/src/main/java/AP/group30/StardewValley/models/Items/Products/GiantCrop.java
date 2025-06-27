package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.Maps.Tile;

public class GiantCrop extends Crop {
    private Tile[] tiles;
    public GiantCrop(int count, CropType type, Tile[] tiles) {
        super(count, type);
        this.tiles = tiles;
    }

    public Tile[] getTiles() {
        return tiles;
    }
}
