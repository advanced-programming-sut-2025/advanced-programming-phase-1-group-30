package models.Tools;

import java.util.ArrayList;

import models.Products.Stone;

public enum PickaxeType {
    TEST("test", 0, null);

    private final String name;
    private final int energyUsed;
    private final ArrayList<Stone> stonesCanDestroy;

    private PickaxeType(String name, int energyUsed, ArrayList<Stone> stonesCanDestroy) {
        this.name = name;
        this.energyUsed = energyUsed;
        this.stonesCanDestroy = stonesCanDestroy;
    }

    public String getName() {
        return name;
    }
    
    public int getEnergyUsed() {
        return energyUsed;
    }

    public ArrayList<Stone> getStonesCanDestroy() {
        return stonesCanDestroy;
    }
}
