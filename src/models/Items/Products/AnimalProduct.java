package models.Items.Products;

import models.Maps.Tile;

public class AnimalProduct extends Product{
    private final AnimalProductType type;

    public AnimalProduct(int count, AnimalProductType type) {
        super(count, type.getName());
        this.type = type;
    }

    public AnimalProductType getType() {
        return type;
    }
}
