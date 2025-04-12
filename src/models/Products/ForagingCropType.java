package models.Products;

import models.enums.Season;

public enum ForagingCropType {
    test("", null, 0, 0);

    private final String name;
    private final Season Season;
    private final int baseSellPrice;
    private final int Energy;

    private ForagingCropType(String name, Season season, int baseSellPrice, int energy) {
        this.name = name;
        Season = season;
        this.baseSellPrice = baseSellPrice;
        Energy = energy;
    }

    public String getName() {
        return name;
    }
    public Season getSeason() {
        return Season;
    }
    public int getBaseSellPrice() {
        return baseSellPrice;
    }
    public int getEnergy() {
        return Energy;
    }
}
