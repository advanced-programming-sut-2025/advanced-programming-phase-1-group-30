package AP.group30.StardewValley.models.Items.Products;

public class Fruit extends Product{
    private final FruitType type;

    public Fruit(int count, FruitType type) {
        super(count, type.getName(), type.getPrice(), type.getTexture());
        this.type = type;
    }

    public FruitType getType() {
        return type;
    }
}
