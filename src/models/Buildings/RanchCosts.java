package models.Buildings;

public enum RanchCosts {
    HAY(50, 999999, null, 0),
    MILK_PAIL(1000, 1, null, 0),
    SHEARS(1000, 1, null, 0),
    CHICKEN(800, 2, BuildingsInfo.Coop, 1),
    COW(1500, 2, BuildingsInfo.Barn, 1),
    GOAT(4000, 2, BuildingsInfo.Barn, 2),
    DUCK(1200, 2, BuildingsInfo.Coop, 2),
    SHEEP(8000, 2, BuildingsInfo.Barn, 3),
    RABBIT(8000, 2, BuildingsInfo.Coop, 3),
    DINOSAUR(14000, 2, BuildingsInfo.Coop, 2),
    PIG(16000, 2, BuildingsInfo.Barn, 3);
    private final int cost;
    private final int dailyLimit;
    private BuildingsInfo requiredBuilding;
    private int requiredBuildingLevel;
    private RanchCosts(int cost, int dailyLimit, BuildingsInfo requiredBuilding, int requiredBuildingLevel) {
        this.cost = cost;
        this.dailyLimit = dailyLimit;
        this.requiredBuilding = requiredBuilding;
        this.requiredBuildingLevel = requiredBuildingLevel;
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
}
