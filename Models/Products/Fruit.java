package Models.Products;

import Models.Product;

public class Fruit extends Product{
    private final FruitType type;

    public Fruit(int count, FruitType type) {
        super(count);
        this.type = type;
    }

    public FruitType getType() {
        return type;
    }
}
