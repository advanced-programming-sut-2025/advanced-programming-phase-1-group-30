package AP.group30.StardewValley.models.Items.Products.ShopProducts;

import AP.group30.StardewValley.models.Buildings.JojaMartCosts;

public class JojaMartProducts extends ShopProduct {
    private final JojaMartCosts type;

    public JojaMartProducts(int count, JojaMartCosts type) {
        super(count, type.getName(), type.getDailyLimit(), type.getPrice(), type.getSeason(), type.getTexture());
        this.type = type;
    }

    public JojaMartCosts getType() {
        return type;
    }
}
