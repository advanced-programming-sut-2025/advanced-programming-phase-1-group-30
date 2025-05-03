package models.Products;

import models.Product;

public class Crop extends Product{
    private final CropType type;

    public Crop(int count, CropType type) {
        super(count, type.getName());
        this.type = type;
    }

    public CropType getType() {
        return type;
    }
}
