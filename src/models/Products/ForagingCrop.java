package models.Products;

import models.Product;

public class ForagingCrop extends Product{
    private final ForagingCropType type;

    public ForagingCrop(int count, ForagingCropType type) {
        super(count);
        this.type = type;
    }

    public ForagingCropType getType() {
        return type;
    }
}
