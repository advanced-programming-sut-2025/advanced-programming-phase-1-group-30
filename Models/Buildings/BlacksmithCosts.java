package Models.Buildings;

public enum BlacksmithCosts {
    CopperOre(75,999999),
    IronOre(150, 999999),
    Coal(150, 999999),
    GoldOre(400, 999999),
    CopperTool(2000, 1),
    IronTool(5000, 1),
    GoldTool(10000, 1),
    IridiumTool(25000, 1),
    CopperTrashCan(1000, 1),
    IronTrashCan(2500, 1),
    GoldTrashCan(5000, 1),
    IridiumTrashCan(12500, 1);
    private final int cost;
    private final int dailyLimit;
    private BlacksmithCosts(int cost, int dailyLimit) {
        this.cost = cost;
        this.dailyLimit = dailyLimit;
    }
    public int getCost() {
        return cost;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }
}
