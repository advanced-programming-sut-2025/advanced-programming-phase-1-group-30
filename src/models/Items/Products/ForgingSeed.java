package models.Items.Products;

import models.Maps.Tile;

public class ForgingSeed extends Product {
    private final ForgingSeedType type;

    public ForgingSeed(int count, ForgingSeedType type, Tile tile) {
        super(count, type.getName(), tile);
        this.type = type;
    }

    public ForgingSeedType getType() {
        return type;
    }
}
