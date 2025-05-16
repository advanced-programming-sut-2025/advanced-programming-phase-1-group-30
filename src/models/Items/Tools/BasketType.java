package models.Items.Tools;

public enum BasketType {
    NORMAL("normal watering can",0,300),
    COPPER("copper watering can",1,55),
    IRON("iron watering can",2,70),
    GOLD("gold watering can",3,85),
    IRIDIUM("iridium watering can",4,100);

    private final String name;
    private final int energyUsed;
    private final int capacity;


    BasketType(String name, int energyUsed, int capacity) {
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
