package AP.group30.StardewValley.models.Items.Products.ShopProducts;

import AP.group30.StardewValley.models.Buildings.SaloonCosts;

public class SaloonProducts extends ShopProduct {
    private final SaloonCosts type;

    public SaloonProducts(int count, SaloonCosts type) {
        super(count, type.getName(), type.getDailyLimit(), type.getPrice(), type.getSeason(), type.getTexture());
        this.type = type;
    }

    public SaloonCosts getType() {
        return type;
    }
}
