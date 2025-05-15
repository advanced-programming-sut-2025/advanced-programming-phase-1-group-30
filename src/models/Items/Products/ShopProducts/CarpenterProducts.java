package models.Items.Products.ShopProducts;

import models.Buildings.CarpenterCosts;

public class CarpenterProducts extends ShopProduct {
    private final CarpenterCosts type;

    public CarpenterProducts(int count, CarpenterCosts type) {
        super(count, type.getName(), type.getDailyLimit(), type.getCost());
        this.type = type;
    }

    public CarpenterCosts getType() {
        return type;
    }
}
