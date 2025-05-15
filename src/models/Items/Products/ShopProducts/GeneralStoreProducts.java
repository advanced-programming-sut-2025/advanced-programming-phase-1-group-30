package models.Items.Products.ShopProducts;

import models.Buildings.GeneralStoreCosts;

public class GeneralStoreProducts extends ShopProduct {
    private final GeneralStoreCosts type;

    public GeneralStoreProducts(int count, GeneralStoreCosts type) {
        super(count, type.getName(), type.getDailyLimit(), type.getPrice(), type.getSeason());
        this.type = type;
    }

    public GeneralStoreCosts getType() {
        return type;
    }
}
