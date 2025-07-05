package AP.group30.StardewValley.models.Items.Products;

public class ForagingSeed extends Product {
    private final ForagingSeedType type;
    private Crop crop;
    private boolean isFertilized;
    private boolean isWatered;

    public ForagingSeed(int count, ForagingSeedType type) {
        super(count, type.getName(), 0, type.getTexture());
        this.type = type;
        this.crop = new Crop(1, type.getCrop());
    }

    public ForagingSeedType getType() {
        return type;
    }
    public Crop getCrop() {
        return crop;
    }
    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public boolean isFertilized() {
        return isFertilized;
    }
    public void setFertilized(boolean fertilized) {
        isFertilized = fertilized;
    }
    public boolean isWatered() {
        return isWatered;
    }
    public void setWatered(boolean watered) {
        isWatered = watered;
    }
}
