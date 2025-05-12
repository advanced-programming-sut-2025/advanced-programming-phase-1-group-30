package models.Items.Products;

public class Fruit extends Product{
    private final FruitType type;

    public Fruit(int count, FruitType type) {
        super(count, type.getName(), type.getBaseSellPrice());
        this.type = type;
    }

    public FruitType getType() {
        return type;
    }
}
