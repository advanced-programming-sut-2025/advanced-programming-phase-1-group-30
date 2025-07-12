package AP.group30.StardewValley.models.Items.Products.ShopProducts;

import AP.group30.StardewValley.models.Buildings.RanchCosts;

public class RanchProducts extends ShopProduct {
    private final RanchCosts type;

    public RanchProducts(int count, RanchCosts type) {
        super(count, type.getName(), type.getDailyLimit(), type.getPrice(), type.getSeason(), type.getTexture());
        this.type = type;
    }

    public RanchCosts getType() {
        return type;
    }
}

