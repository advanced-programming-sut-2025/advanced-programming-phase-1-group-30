package models.Buildings;

public enum RanchCosts {
    HAY("Hay", 50, 999999, null, 0),
    MILK_PAIL("Milk Pail", 1000, 1, null, 0),
    SHEARS("Shears", 1000, 1, null, 0),
    CHICKEN("Chicken", 800, 2, BuildingsInfo.Coop, 1),
    COW("Cow", 1500, 2, BuildingsInfo.Barn, 1),
    GOAT("Goat", 4000, 2, BuildingsInfo.Barn, 2),
    DUCK("Duck", 1200, 2, BuildingsInfo.Coop, 2),
    SHEEP("Sheep", 8000, 2, BuildingsInfo.Barn, 3),
    RABBIT("Rabbit", 8000, 2, BuildingsInfo.Coop, 3),
    DINOSAUR("Dinosaur", 14000, 2, BuildingsInfo.Coop, 2),
    PIG("Pig", 16000, 2, BuildingsInfo.Barn, 3);


    private final String name;
    private final int cost;
    private final int dailyLimit;
    private BuildingsInfo requiredBuilding;
    private int requiredBuildingLevel;

    private RanchCosts(String name, int cost, int dailyLimit, BuildingsInfo requiredBuilding, int requiredBuildingLevel) {
        this.name = name;
        this.cost = cost;
        this.dailyLimit = dailyLimit;
        this.requiredBuilding = requiredBuilding;
        this.requiredBuildingLevel = requiredBuildingLevel;
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
}
