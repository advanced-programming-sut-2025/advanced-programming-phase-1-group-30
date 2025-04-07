package Models.Tools;

public enum AxeType {
    NORMAL_AXE(0),
    COPPER_AXE(0),
    IRON_AXE(0),
    GOLD_AXE(0),
    IRIDIUM_AXE(0);

    private final int energyUsed;

    private AxeType(int energyUsed) {
        this.energyUsed = energyUsed;
    }

    public int getEnergyUsed() {
        return energyUsed;
    }
}
