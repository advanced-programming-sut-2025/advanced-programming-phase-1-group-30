package models.Items.Products;

public class ForgingSeed extends Product {
    private final ForagingCropType type;

    public ForgingSeed(int count, ForagingCropType type) {
        super(count, type.getName());
        this.type = type;
    }

    public ForagingCropType getType() {
        return type;
    }
}
