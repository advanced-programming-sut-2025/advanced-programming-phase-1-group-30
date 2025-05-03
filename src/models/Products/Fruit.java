package models.Products;

import models.Product;

public class Fruit extends Product{
    private final FruitType type;

    public Fruit(int count, FruitType type) {
        super(count, type.getName());
        this.type = type;
    }

    public FruitType getType() {
        return type;
    }
}
