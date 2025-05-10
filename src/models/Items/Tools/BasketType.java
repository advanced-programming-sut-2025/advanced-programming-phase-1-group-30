package models.Items.Tools;

public enum BasketType {
    NORMAL("normal wateringCan",0,40),
    COPPER("copper wateringCan",1,55),
    IRON("iron wateringCan",2,70),
    GOLD("gold wateringCan",3,85),
    IRIDIUM("iridium wateringCan",4,100);

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
