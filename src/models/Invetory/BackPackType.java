package models.Invetory;

public enum BackPackType {
    INITIAL_BACKPACK(12),
    BIG_BACKPACK(24),
    DELUX_BACKPACK(-1);

    private final int capacity;

    private BackPackType(int capacity) {
        this.capacity = capacity;
    }
    
    public int getCapacity() {
        return capacity;
    }
}
