package models.Invetory;

import java.util.ArrayList;

import models.Items.Item;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<>();

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }
}
