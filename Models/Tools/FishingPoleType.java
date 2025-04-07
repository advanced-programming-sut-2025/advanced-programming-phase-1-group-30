package Models.Tools;

import java.util.ArrayList;

import Models.Fish;

public enum FishingPoleType {
    NORMAL_PICKAXE(0,0, null),
    COPPER_PICKAXE(0, 0,null),
    IRON_PICKAXE(0, 0,null),
    GOLD_PICKAXE(0, 0,null),
    IRIDIUM_PICKAXE(0, 0,null);

    private final int energyUsed;
    private final int cost;
    private final ArrayList<Fish> stonesCanDestroy;

    private FishingPoleType(int energyUsed, int cost, ArrayList<Fish> stonesCanDestroy) {
        this.energyUsed = energyUsed;
        this.cost = cost;
        this.stonesCanDestroy = stonesCanDestroy;
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
