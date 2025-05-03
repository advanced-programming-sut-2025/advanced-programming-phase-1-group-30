package models.Items.Tools;

public enum BasketType {
    TEST("test", 0, 0);
    
    private final String name;
    private final int energyUsed;
    private final int capacity;


    private BasketType(String name, int energyUsed, int capacity) {
        this.name = name;
        this.energyUsed = energyUsed;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }


    public int getEnergyUsed() {
        return energyUsed;
    }
}
