package models.Tools;

import models.Tool;

public class MilkPail extends Tool {
    private final int cost = 0;
    private final int energyUsed = 0;
    private int capacity = 0;
    
    public MilkPail(int count, int capacity) {
        super(count);
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
