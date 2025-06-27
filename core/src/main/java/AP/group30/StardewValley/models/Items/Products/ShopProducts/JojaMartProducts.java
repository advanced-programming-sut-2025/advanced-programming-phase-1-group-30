package AP.group30.StardewValley.models.Items.Products.ShopProducts;

import AP.group30.StardewValley.models.Buildings.JojaMartCosts;

public class JojaMartProducts extends ShopProduct {
    private final JojaMartCosts type;

    public JojaMartProducts(int count, JojaMartCosts type) {
        super(count, type.getName(), type.getDailyLimit(), type.getCost(), type.getSeason());
        this.type = type;
    }

    public JojaMartCosts getType() {
        return type;
    }
}
