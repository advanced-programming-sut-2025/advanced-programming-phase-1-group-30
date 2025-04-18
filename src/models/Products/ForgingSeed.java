package models.Products;

import models.Product;

public class ForgingSeed extends Product {
    private final ForagingCropType type;

    public ForgingSeed(int count, ForagingCropType type) {
        super(count);
        this.type = type;
    }

    public ForagingCropType getType() {
        return type;
    }
}
