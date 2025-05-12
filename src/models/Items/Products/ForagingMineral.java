package models.Items.Products;

import models.Maps.Tile;

public class ForagingMineral extends Product {
    private final ForagingMineralType type;

    public ForagingMineral(int count, ForagingMineralType type) {
        super(count, type.getName());
        this.type = type;
    }

    public ForagingMineralType getType() {
        return type;
    }
}
