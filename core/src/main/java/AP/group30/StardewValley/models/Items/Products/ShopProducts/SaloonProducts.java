package AP.group30.StardewValley.models.Items.Products.ShopProducts;

import AP.group30.StardewValley.models.Buildings.SaloonCosts;

public class SaloonProducts extends ShopProduct {
    private final SaloonCosts type;

    public SaloonProducts(int count, SaloonCosts type) {
        super(count, type.getName(), type.getDailyLimit(), type.getCost(), type.getSeason());
        this.type = type;
    }

    public SaloonCosts getType() {
        return type;
    }
}
