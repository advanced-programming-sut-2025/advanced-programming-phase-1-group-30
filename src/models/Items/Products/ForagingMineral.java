package models.Items.Products;

public class ForagingMineral extends Product {
    private final ForagingMineralType type;

    public ForagingMineral(int count, ForagingMineralType type) {
        super(count, type.getName());
        this.type = type;
    }

    public ForagingMineralType getType() {
        return type;
    }
}
