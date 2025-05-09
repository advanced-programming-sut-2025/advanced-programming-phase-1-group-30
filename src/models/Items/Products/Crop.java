package models.Items.Products;

import models.Maps.Tile;

public class Crop extends Product{
    private final CropType type;

    public Crop(int count, CropType type, Tile tile) {
        super(count, type.getName(), tile);
        this.type = type;
    }

    public CropType getType() {
        return type;
    }
}
