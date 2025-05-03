package models.Tools;

import java.util.ArrayList;

import models.enums.Fish;

public enum FishingPoleType {
    TEST("test", 0,0, null);

    private final String name;
    private final int energyUsed;
    private final int cost;
    private final ArrayList<Fish> stonesCanDestroy;

    private FishingPoleType(String name, int energyUsed, int cost, ArrayList<Fish> stonesCanDestroy) {
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
    
    public ArrayList<Fish> getStonesCanDestroy() {
        return stonesCanDestroy;
    }
}
