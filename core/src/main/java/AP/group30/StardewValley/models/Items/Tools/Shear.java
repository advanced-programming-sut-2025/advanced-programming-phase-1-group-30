package AP.group30.StardewValley.models.Items.Tools;

import AP.group30.StardewValley.models.Items.ItemTexture;

public class Shear extends Tool {
    private final int cost = 0;
    private final int energyUsed = 0;

    public Shear(int count) {
        super(count, "Shear", ItemTexture.WOOD.getTexture());
    }
    public int getCost() {
        return cost;
    }
    public int getEnergyUsed() {
        return energyUsed;
    }
}
