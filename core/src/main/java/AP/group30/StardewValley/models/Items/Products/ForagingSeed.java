package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.GameObjects;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Maps.Map;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ForagingSeed extends Product {
    private final ForagingSeedType type;
    private Crop crop;
    private boolean isFertilized;
    private boolean isWatered;
    private int y, x;

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
