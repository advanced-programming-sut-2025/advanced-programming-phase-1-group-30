package AP.group30.StardewValley.models.Items.Products.ShopProducts;

import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.TimeAndDate.Season;
public class ShopProduct extends Item {
    private final int cost;
    private int soldToday;
    private final int sellLimit;
    private final Season season;

    public ShopProduct(int count, String name, int sellLimit, int cost, Season season) {
        super(count, name, cost);
        this.cost = cost;
        this.soldToday = 0;
        this.sellLimit = sellLimit;
        this.season = season;
    }

    public int getCost() {
        return cost;
    }

    public int getSoldToday() {
        return soldToday;
    }

    public void sold(int count) {
        this.soldToday += count;
    }

    public int getSellLimit() {
        return sellLimit;
    }

    public Season getSeason() {
        return season;
    }
}
