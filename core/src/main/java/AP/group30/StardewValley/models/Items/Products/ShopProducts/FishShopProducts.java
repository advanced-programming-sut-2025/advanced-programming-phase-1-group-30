package AP.group30.StardewValley.models.Items.Products.ShopProducts;

import AP.group30.StardewValley.models.Buildings.FishShopCosts;

public class FishShopProducts extends ShopProduct {
    private final FishShopCosts type;

    public FishShopProducts(int count, FishShopCosts type) {
        super(count, type.getName(), type.getDailyLimit(), type.getPrice(), type.getSeason());
        this.type = type;
    }

    public FishShopCosts getType() {
        return type;
    }
}
