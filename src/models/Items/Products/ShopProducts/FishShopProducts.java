package models.Items.Products.ShopProducts;

import models.Buildings.FishShopCosts;

public class FishShopProducts extends ShopProduct {
    private final FishShopCosts type;

    public FishShopProducts(int count, FishShopCosts type) {
        super(count, type.getName(), type.getDailyLimit(), type.getPrice());
        this.type = type;
    }

    public FishShopCosts getType() {
        return type;
    }
}
