package models.Items.Products;

public class ForgingSeed extends Product {
    private final ForgingSeedType type;
    private Crop crop;
    private boolean isFertilized;
    private boolean isWatered;

    public ForgingSeed(int count, ForgingSeedType type) {
        super(count, type.getName(), 0);
        this.type = type;
        this.crop = new Crop(1, type.getCrop());
    }

    public ForgingSeedType getType() {
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
