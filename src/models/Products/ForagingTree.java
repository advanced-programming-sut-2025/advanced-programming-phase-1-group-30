package models.Products;

import models.Product;

public class ForagingTree extends Product {
    private final ForagingCropType type;

    public ForagingTree(int count, ForagingCropType type) {
        super(count, type.getName());
        this.type = type;
    }

    public ForagingCropType getType() {
        return type;
    }
}
