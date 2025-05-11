package models.Items;

import java.util.ArrayList;

import models.App;

public class Item {
    private final String name;
    private int count;
    private String quality;
    private double cof;
    public Item(int count, String name) {
        this.name = name;
        this.count = count;
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

    public static Item findItemByName(String name, ArrayList<Item> items) {
        for (Item item : items) {
            if (item.getName().matches(name)) return item;
        }
        return null;
    }
}