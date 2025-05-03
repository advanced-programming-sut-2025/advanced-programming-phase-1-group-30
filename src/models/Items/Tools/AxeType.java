package models.Items.Tools;

public enum AxeType {
    TEST("test", 0);

    private final String name;
    private final int energyUsed;

    private AxeType(String name, int energyUsed) {
        this.name = name;
        this.energyUsed = energyUsed;
    }

    public String getName() {
        return name;
    }
    
    public int getEnergyUsed() {
        return energyUsed;
    }
}
