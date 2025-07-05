package AP.group30.StardewValley.models.Items.Products;

public class ForagingCrop extends Product{
    private final ForagingCropType type;

    public ForagingCrop(int count, ForagingCropType type) {
        super(count, type.getName(), type.getBaseSellPrice(), type.getTexture());
        this.type = type;
    }

    public ForagingCropType getType() {
        return type;
    }
}
