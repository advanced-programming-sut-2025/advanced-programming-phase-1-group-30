package Models.Buildings;

public enum RanchCosts {
    Hay(50, 999999, null, 0),
    MilkPail(1000, 1, null, 0),
    Shears(1000, 1, null, 0),
    Chicken(800, 2, BuildingsInfo.Coop, 1),
    Cow(1500, 2, BuildingsInfo.Barn, 1),
    Goat(4000, 2, BuildingsInfo.Barn, 2),
    Duck(1200, 2, BuildingsInfo.Coop, 2),
    Sheep(8000, 2, BuildingsInfo.Barn, 3),
    Rabbit(8000, 2, BuildingsInfo.Coop, 3),
    Dinosaur(14000, 2, BuildingsInfo.Coop, 2),
    Pig(16000, 2, BuildingsInfo.Barn, 3);
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
