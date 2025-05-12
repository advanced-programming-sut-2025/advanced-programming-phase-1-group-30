package models.Items.Products;


public class ForagingTree extends Product {
    private final ForagingCropType type;

    public ForagingTree(int count, ForagingCropType type) {
        super(count, type.getName(), type.getBaseSellPrice());
        this.type = type;
    }

    public ForagingCropType getType() {
        return type;
    }
}
