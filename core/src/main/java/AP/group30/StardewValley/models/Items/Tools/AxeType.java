package AP.group30.StardewValley.models.Items.Tools;

public enum AxeType {
    NORMAL("normal axe", 5),
    COPPER("copper axe", 4),
    IRON("iron axe", 3),
    GOLD("gold axe", 2),
    IRIDIUM("iridium axe",1);

    private final String name;
    private final int energyUsed;

    AxeType(String name, int energyUsed) {
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
