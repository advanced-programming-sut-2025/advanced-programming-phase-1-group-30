package models.Items.Products;

public class ForgingSeed extends Product {
    private final ForgingSeedType type;

    public ForgingSeed(int count, ForgingSeedType type) {
        super(count, type.getName());
        this.type = type;
    }

    public ForgingSeedType getType() {
        return type;
    }
}
