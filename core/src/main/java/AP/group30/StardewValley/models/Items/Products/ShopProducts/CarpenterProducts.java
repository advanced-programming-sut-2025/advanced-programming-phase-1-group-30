package AP.group30.StardewValley.models.Items.Products.ShopProducts;

import AP.group30.StardewValley.models.Buildings.CarpenterCosts;

public class CarpenterProducts extends ShopProduct {
    private final CarpenterCosts type;

    public CarpenterProducts(int count, CarpenterCosts type) {
        super(count, type.getName(), type.getDailyLimit(), type.getCost(), type.getSeason());
        this.type = type;
    }

    public CarpenterCosts getType() {
        return type;
    }
}
