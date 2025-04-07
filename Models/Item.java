package Models;

public class Item {
    private int count;

    public Item(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void chnageCount(int amount) {
        this.count += amount;
    }
}