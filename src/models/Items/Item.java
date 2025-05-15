package models.Items;

import java.util.ArrayList;

import models.Items.Products.ShopProducts.ShopProduct;

public class Item implements ItemsInteface {
    private final String name;
    private int count;
    private String quality;
    private double cof;
    private double price;

    public Item(int count, String name, double price) {
        this.name = name;
        this.count = count;
        this.cof = 1;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void changeCount(int amount) {
        this.count += amount;
    }

    public String getName() {
        return name;
    }
    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public void setCof(double cof) {
        this.cof = cof;
    }

    public double getCof() {
        return cof;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static Item findItemByName(String name, ArrayList<Item> items) {
        for (Item item : items) {
            if (item.getName().matches(name)) return item;
        }
        return null;
    }

    public static ShopProduct findShopProductByName(String name, ArrayList<ShopProduct> items) {
        for (ShopProduct item : items) {
            if (item.getName().matches(name)) return item;
        }
        return null;
    }
}