package models.Items.Tools;

public enum FishingPoleType {
    TRAINING_POLE("Training Pole", 8, 0.1),
    BAMBOO_POLE("Bamboo Pole", 8, 0.5),
    FIBERGLASS_POLE("Fiberglass Pole", 6, 0.9),
    IRIDIUM_POLE("Iridium Pole", 4, 1.2);

    private final String name;
    private final int energyUsed;
    private final double pole;

    private FishingPoleType(String name, int energyUsed, double pole) {
        this.name = name;
        this.energyUsed = energyUsed;
        this.pole = pole;
    }

    public String getName() {
        return name;
    }

    public int getEnergyUsed() {
        return energyUsed;
    }
    
    public double getPole() {
        return pole;
    }
}
