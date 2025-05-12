package models.Items.Products.ShopProducts;

public class CarpenterProducts extends ShopProduct {
    private final CarpenterProducts type;

    public CarpenterProducts(int count, CarpenterProducts type) {
        super(count, type.getName(), type.getSellLimit(), type.getCost());
        this.type = type;
    }

    public CarpenterProducts getType() {
        return type;
    }
}
