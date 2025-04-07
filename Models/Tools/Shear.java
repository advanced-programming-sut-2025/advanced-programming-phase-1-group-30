package Models.Tools;

import Models.Tool;

public class Shear extends Tool {
    private final int cost = 0;
    private final int energyUsed = 0;
    
    public Shear(int count) {
        super(count);
    }
    public int getCost() {
        return cost;
    }
    public int getEnergyUsed() {
        return energyUsed;
    }
}
