package models.Items.Products;

import models.TimeAndDate.Season;

public enum FruitType {
    APRICOT("Apricot", 1, 59, true, 38, Season.SPRING),
    CHERRY("Cherry", 1, 80, true, 38, Season.SPRING),
    BANANA("Banana", 1, 150, true, 75, Season.SUMMER),
    MANGO("Mango", 1, 130, true, 100, Season.SUMMER),
    ORANGE("Orange", 1, 100, true, 38, Season.SUMMER),
    PEACH("Peach", 1, 140, true, 38, Season.SUMMER),
    APPLE("Apple", 1, 100, true, 38, Season.FALL),
    POMEGRANATE("Pomegranate", 1, 140, true, 38, Season.FALL),
    OAK_RESIN("Oak Resin", 7, 150, false, 0, Season.ALL),
    MAPLE_SYRUP("Maple Syrup", 9, 200, false, 0, Season.ALL),
    PINE_TAR("Pine Tar", 5, 100, false, 0, Season.ALL),
    SAP("Sap", 1, 2, true, -2, Season.ALL),
    COMMON_MUSHROOM("Common Mushroom", 1, 40, true, 38, Season.ALL),
    MYSTIC_SYRUP("Mystic Syrup", 7, 1000, true, 500, Season.ALL);

    private final String name;
    private final int harvestCycle;
    private final int baseSellPrice;
    private final boolean isFruitEdible;
    private final int energy;
    private final Season season;

    private FruitType(String name, int harvestCycle, int baseSellPrice, boolean isFruitEdible, int energy,
            Season season) {
        this.name = name;
        this.harvestCycle = harvestCycle;
        this.baseSellPrice = baseSellPrice;
        this.isFruitEdible = isFruitEdible;
        this.energy = energy;
        this.season = season;
    }

    public String getName() {
        return name;
    }
    public int getHarvestCycle() {
        return harvestCycle;
    }
    public int getBaseSellPrice() {
        return baseSellPrice;
    }
    public boolean isFruitEdible() {
        return isFruitEdible;
    }
    public int getEnergy() {
        return energy;
    }
    public Season getSeason() {
        return season;
    }
}
