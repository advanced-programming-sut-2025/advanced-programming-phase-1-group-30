package AP.group30.StardewValley.models.Items.Products;

public class FruitTree extends Crop{
    private FruitType fruitType;
    public FruitTree(int count, CropType type, FruitType fruitType) {
        super(count, type);
        this.fruitType = fruitType;
    }
    public FruitType getFruitType() {
        return fruitType;
    }
    public void setFruitType(FruitType fruitType) {
        this.fruitType = fruitType;
    }
}
