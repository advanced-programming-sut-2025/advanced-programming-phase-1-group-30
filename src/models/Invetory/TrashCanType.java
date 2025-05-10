package models.Invetory;

public enum TrashCanType {
    INITIAL_TRASHCAN(0),
    COPPER_TRASHCAN(15),
    IRON_TRASHCAN(30),
    GOLD_TRASHCAN(45),
    IRIDIUM_TRASHCAN(60);

    private final int profit;

    private TrashCanType(int profit) {
        this.profit = profit;
    }

    public int getProfit(int price) {
        return profit * price / 100;
    }
}
