package models.Items.Products;

import models.Maps.Tile;

public class ForagingCrop extends Product{
    private final ForagingCropType type;

    public ForagingCrop(int count, ForagingCropType type) {
        super(count, type.getName());
        this.type = type;
    }

    public ForagingCropType getType() {
        return type;
    }
}
