package AP.group30.StardewValley.models.Inventory;

public enum BackPackType {
    INITIAL_BACKPACK(36),
    BIG_BACKPACK(24),
    DELUX_BACKPACK(36);

    private final int capacity;

    private BackPackType(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
