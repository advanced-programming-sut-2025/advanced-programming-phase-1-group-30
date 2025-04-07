package Models.Products;

import Models.Product;

public class Crop extends Product{
    private final CropType type;

    public Crop(int count, CropType type) {
        super(count);
        this.type = type;
    }

    public CropType getType() {
        return type;
    }
}
