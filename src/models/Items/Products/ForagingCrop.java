package models.Items.Products;

public class ForagingCrop extends Product{
    private final ForagingCropType type;

    public ForagingCrop(int count, ForagingCropType type) {
        super(count, type.getName(), type.getBaseSellPrice());
        this.type = type;
    }

    public ForagingCropType getType() {
        return type;
    }
}
