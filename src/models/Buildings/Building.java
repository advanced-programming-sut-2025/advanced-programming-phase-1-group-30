package models.Buildings;

import java.util.ArrayList;

import models.Items.Item;

public class Building {

    private int height;
    private int width;
    private int startX;
    private int startY;

    private final int startHour;
    private final int endHour;

    private ArrayList<Item> items;

    public Building(int height, int width, int startX, int startY, int startHour, int endHour) {
        this.height = height;
        this.width = width;
        this.startX = startX;
        this.startY = startY;

        this.startHour = startHour;
        this.endHour = endHour;

        this.items = new ArrayList<>();
    }
  
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public void addItem(Item item) {
        this.items.add(item);
    }
    public void removeItem(Item item) {
        this.items.remove(item);
    }
    public void removeItems() {
        this.items = new ArrayList<>();
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }
}
