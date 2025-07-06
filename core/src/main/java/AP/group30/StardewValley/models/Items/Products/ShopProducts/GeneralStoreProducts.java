package AP.group30.StardewValley.models.Items.Products.ShopProducts;

import AP.group30.StardewValley.models.Buildings.GeneralStoreCosts;

public class GeneralStoreProducts extends ShopProduct {
    private final GeneralStoreCosts type;

    public GeneralStoreProducts(int count, GeneralStoreCosts type) {
        super(count, type.getName(), type.getDailyLimit(), type.getPrice(), type.getSeason(), type.getTexture());
        this.type = type;
    }

    public GeneralStoreCosts getType() {
        return type;
    }
}
