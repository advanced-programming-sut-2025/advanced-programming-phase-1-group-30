package models.Items.Products.ShopProducts;

import models.Buildings.RanchCosts;

public class RanchProducts extends ShopProduct {
    private final RanchCosts type;

    public RanchProducts(int count, RanchCosts type) {
        super(count, type.getName(), type.getDailyLimit(), type.getCost());
        this.type = type;
    }

    public RanchCosts getType() {
        return type;
    }
}

