package AP.group30.StardewValley.models.Items.Tools;

public enum HoeType {
    NORMAL("normal hoe", 5),
    COPPER("copper hoe", 4),
    IRON("iron hoe", 3),
    GOLD("gold hoe", 2),
    IRIDIUM("iridium hoe", 1);

    private final String name;
    private final int energyUsed;

    HoeType(String name, int energyUsed) {
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
