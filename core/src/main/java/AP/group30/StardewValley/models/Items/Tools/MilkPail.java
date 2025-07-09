package AP.group30.StardewValley.models.Items.Tools;

import AP.group30.StardewValley.models.Items.ItemTexture;

public class MilkPail extends Tool {
    private final int cost = 0;
    private final int energyUsed = 0;
    private int capacity = 0;

    public MilkPail(int count, int capacity) {
        super(count, "Milk Pail", ItemTexture.MILK_PAIL.getTexture());
        this.capacity = capacity;
    }
    public int getCost() {
        return cost;
    }
    public int getEnergyUsed() {
        return energyUsed;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


}
