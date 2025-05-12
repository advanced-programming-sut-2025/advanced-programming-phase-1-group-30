package models.Items.Products.ShopProducts;

import models.Buildings.SaloonCosts;

public class SaloonProducts extends ShopProduct {
    private final SaloonCosts type;

    public SaloonProducts(int count, SaloonCosts type) {
        super(count, type.getName(), type.getDailyLimit(), type.getCost());
        this.type = type;
    }

    public SaloonCosts getType() {
        return type;
    }
}
