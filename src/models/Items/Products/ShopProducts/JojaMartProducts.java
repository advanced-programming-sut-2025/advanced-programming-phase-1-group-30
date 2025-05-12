package models.Items.Products.ShopProducts;

import models.Buildings.JojaMartCosts;

public class JojaMartProducts extends ShopProduct {
    private final JojaMartCosts type;

    public JojaMartProducts(int count, JojaMartCosts type) {
        super(count, type.getName(), type.getDailyLimit(), type.getCost());
        this.type = type;
    }

    public JojaMartCosts getType() {
        return type;
    }
}
