package models.Items.Products.ShopProducts;

import models.Items.Item;
public class ShopProduct extends Item {
    private final int cost;
    private int soldToday;
    private final int sellLimit;

    public ShopProduct(int count, String name, int sellLimit, int cost) {
        super(count, name, cost);
        this.cost = cost;
        this.soldToday = 0;
        this.sellLimit = sellLimit;
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

}
