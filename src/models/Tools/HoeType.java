package models.Tools;

public enum HoeType {
    NORMAL_HOE(0),
    COPPER_HOE(0),
    IRON_HOE(0),
    GOLD_HOE(0),
    IRIDIUM_HOE(0);

    private final int energyUsed;

    private HoeType(int energyUsed) {
        this.energyUsed = energyUsed;
    }

    public int getEnergyUsed() {
        return energyUsed;
    }
}
