package models.Items.Tools;

public class Shear extends Tool {
    private final int cost = 0;
    private final int energyUsed = 0;
    
    public Shear(int count) {
        super(count, "Shear");
    }
    public int getCost() {
        return cost;
    }
    public int getEnergyUsed() {
        return energyUsed;
    }
}
