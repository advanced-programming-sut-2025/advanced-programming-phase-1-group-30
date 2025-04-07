package Models.Products;

import Models.Product;

public class ForagingTree extends Product {
    private final ForagingCropType type;

    public ForagingTree(int count, ForagingCropType type) {
        super(count);
        this.type = type;
    }

    public ForagingCropType getType() {
        return type;
    }
}
