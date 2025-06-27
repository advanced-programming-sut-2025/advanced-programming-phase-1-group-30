package AP.group30.StardewValley.models.Items.Products.ShopProducts;

import AP.group30.StardewValley.models.Buildings.RanchCosts;

public class RanchProducts extends ShopProduct {
    private final RanchCosts type;

    public RanchProducts(int count, RanchCosts type) {
        super(count, type.getName(), type.getDailyLimit(), type.getCost(), type.getSeason());
        this.type = type;
    }

    public RanchCosts getType() {
        return type;
    }
}

