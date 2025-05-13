package models.Items.Products;

import models.Maps.Tile;

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
