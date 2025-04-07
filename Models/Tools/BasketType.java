package Models.Tools;

public enum BasketType {
    NORMAL_BASKET(0, 0),
    COPPER_BASKET(0, 0),
    IRON_BASKET(0, 0),
    GOLD_BASKET(0, 0),
    IRIDIUM_BASKET(0, 0);

    private final int energyUsed;
    private final int capacity;


    private BasketType(int energyUsed, int capacity) {
        this.energyUsed = energyUsed;
        this.capacity = capacity;
    }


    public int getCapacity() {
        return capacity;
    }


    public int getEnergyUsed() {
        return energyUsed;
    }
}
