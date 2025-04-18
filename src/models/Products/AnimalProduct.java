package models.Products;

import models.Product;

public class AnimalProduct extends Product{
    private final AnimalProductType type;

    public AnimalProduct(int count, AnimalProductType type) {
        super(count);
        this.type = type;
    }

    public AnimalProductType getType() {
        return type;
    }
}
