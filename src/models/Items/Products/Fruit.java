package models.Items.Products;

import models.Maps.Tile;

public class Fruit extends Product{
    private final FruitType type;

    public Fruit(int count, FruitType type, Tile tile) {
        super(count, type.getName(), tile);
        this.type = type;
    }

    public FruitType getType() {
        return type;
    }
}
