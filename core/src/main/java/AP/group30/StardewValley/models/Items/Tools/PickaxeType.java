package AP.group30.StardewValley.models.Items.Tools;

public enum PickaxeType {
    NORMAL("normal pickaxe",5,0),
    COPPER("copper pickaxe", 4,1),
    IRON("iron pickaxe", 3,2),
    GOLD("gold pickaxe", 2,3),
    IRIDIUM("iridium pickaxe", 1,4);

    private final String name;
    private final int energyUsed;
    private final int level;

     PickaxeType(String name, int energyUsed, int level) {
        this.name = name;
        this.energyUsed = energyUsed;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getEnergyUsed() {
        return energyUsed;
    }

    public int getLevel() {
         return level;
    }
}
