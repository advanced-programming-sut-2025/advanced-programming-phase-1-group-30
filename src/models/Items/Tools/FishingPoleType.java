package models.Items.Tools;

import java.util.ArrayList;

import models.Animals.FishType;

public enum FishingPoleType {
    TEST("test", 0,0, null);

    private final String name;
    private final int energyUsed;
    private final int cost;
    private final ArrayList<FishType> stonesCanDestroy;

    private FishingPoleType(String name, int energyUsed, int cost, ArrayList<FishType> stonesCanDestroy) {
        this.name = name;
        this.energyUsed = energyUsed;
        this.cost = cost;
        this.stonesCanDestroy = stonesCanDestroy;
    }

    public String getName() {
        return name;
    }

    public int getEnergyUsed() {
        return energyUsed;
    }

    public int getCost() {
        return cost;
    }
    
    public ArrayList<FishType> getStonesCanDestroy() {
        return stonesCanDestroy;
    }
}
