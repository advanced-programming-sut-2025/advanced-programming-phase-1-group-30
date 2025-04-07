package Models.Tools;

import java.util.ArrayList;

import Models.StoneType;

public enum PickaxeType {
    NORMAL_PICKAXE(0, null),
    COPPER_PICKAXE(0, null),
    IRON_PICKAXE(0, null),
    GOLD_PICKAXE(0, null),
    IRIDIUM_PICKAXE(0, null);

    private final int energyUsed;
    private final ArrayList<StoneType> stonesCanDestroy;

    private PickaxeType(int energyUsed, ArrayList<StoneType> stonesCanDestroy) {
        this.energyUsed = energyUsed;
        this.stonesCanDestroy = stonesCanDestroy;
    }

    public int getEnergyUsed() {
        return energyUsed;
    }

    public ArrayList<StoneType> getStonesCanDestroy() {
        return stonesCanDestroy;
    }
}
