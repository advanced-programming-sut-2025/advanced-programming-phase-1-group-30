package models.Buildings;

public enum CarpenterCosts {
    WOOD("Wood", 10, 0, 0, 0, 0, Integer.MAX_VALUE),
    STONE("Stone", 20, 0, 0, 0, 0, Integer.MAX_VALUE),
    BARN("Barn", 6000, 350, 150, 7, 4, 1),
    BIG_BARN("Big Barn", 12000, 450, 200, 7, 4, 1),
    DELUXE_BARN("Deluxe Barn", 25000, 550, 300, 7, 4, 1),
    COOP("Coop", 4000, 300, 100, 6, 3, 1),
    BIG_COOP("Big Coop", 10000, 400, 150, 6, 3, 1),
    DELUXE_COOP("Deluxe Coop", 20000, 500, 200, 6, 3, 1),
    WELL("Well", 1000, 0, 75, 3, 3, 1),
    SHIPPING_BIN("Shipping Bin", 250, 150, 0, 1, 1, Integer.MAX_VALUE);

    private final String name;
    private final int cost;
    private final int wood;
    private final int stone;
    private final int length;
    private final int width;
    private final int dailyLimit;

    CarpenterCosts(String name, int cost, int wood, int stone, int length, int width, int dailyLimit) {
        this.name = name;
        this.cost = cost;
        this.wood = wood;
        this.stone = stone;
        this.length = length;
        this.width = width;
        this.dailyLimit = dailyLimit;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getWood() {
        return wood;
    }

    public int getStone() {
        return stone;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }
}

