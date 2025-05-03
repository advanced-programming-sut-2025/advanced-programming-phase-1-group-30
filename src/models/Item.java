package models;

public class Item {
    private final String name;
    private int count;

    public Item(int count, String name) {
        this.name = name;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void changeCount(int amount) {
        this.count += amount;
    }

    public String getName() {
        return name;
    }
}