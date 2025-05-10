package models.Items.Products;

import models.Maps.Tile;

public class ForagingCrop extends Product{
    private final ForagingCropType type;

    public ForagingCrop(int count, ForagingCropType type, Tile tile) {
        super(count, type.getName(), tile);
        this.type = type;
    }

    public ForagingCropType getType() {
        return type;
    }
}
