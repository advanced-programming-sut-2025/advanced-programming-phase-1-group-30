package models.Items.Products.ShopProducts;

import models.Buildings.BlacksmithCosts;

public class BlacksmithProducts extends ShopProduct {
    private final BlacksmithCosts type;

    public BlacksmithProducts(int count, BlacksmithCosts type) {
        super(count, type.getName(), type.getDailyLimit(), type.getCost(), type.getSeason());
        this.type = type;
    }

    public BlacksmithCosts getType() {
        return type;
    }
}
