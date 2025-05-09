package models.Items.Products;

import models.Maps.Tile;

public class ForagingTree extends Product {
    private final ForagingCropType type;

    public ForagingTree(int count, ForagingCropType type, Tile tile) {
        super(count, type.getName(), tile);
        this.type = type;
    }

    public ForagingCropType getType() {
        return type;
    }
}
