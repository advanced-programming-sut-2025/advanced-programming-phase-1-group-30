package models.Buildings;

import models.Items.ItemsInteface;
import models.TimeAndDate.Season;

public enum RanchCosts implements ItemsInteface {
    HAY("Hay", 50, 999999, null, 0, Season.ALL),
    MILK_PAIL("Milk Pail", 1000, 1, null, 0, Season.ALL),
    SHEARS("Shears", 1000, 1, null, 0, Season.ALL),
    CHICKEN("Chicken", 800, 2, BuildingsInfo.Coop, 1, Season.ALL),
    COW("Cow", 1500, 2, BuildingsInfo.Barn, 1, Season.ALL),
    GOAT("Goat", 4000, 2, BuildingsInfo.Barn, 2, Season.ALL),
    DUCK("Duck", 1200, 2, BuildingsInfo.Coop, 2, Season.ALL),
    SHEEP("Sheep", 8000, 2, BuildingsInfo.Barn, 3, Season.ALL),
    RABBIT("Rabbit", 8000, 2, BuildingsInfo.Coop, 3, Season.ALL),
    DINOSAUR("Dinosaur", 14000, 2, BuildingsInfo.Coop, 2, Season.ALL),
    PIG("Pig", 16000, 2, BuildingsInfo.Barn, 3, Season.ALL);


    private final String name;
    private final int cost;
    private final int dailyLimit;
    private final BuildingsInfo requiredBuilding;
    private final int requiredBuildingLevel;
    private final Season season;

    private RanchCosts(String name, int cost, int dailyLimit, BuildingsInfo requiredBuilding, int requiredBuildingLevel, Season season) {
        this.name = name;
        this.cost = cost;
        this.dailyLimit = dailyLimit;
        this.requiredBuilding = requiredBuilding;
        this.requiredBuildingLevel = requiredBuildingLevel;
        this.season = season;
    }

    public String getName() {
        return name;
    }
    
    public int getCost() {
        return cost;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }

    public BuildingsInfo getRequiredBuilding() {
        return requiredBuilding;
    }

    public int getRequiredBuildingLevel() {
        return requiredBuildingLevel;
    }

    public Season getSeason() {
        return season;
    }
}
