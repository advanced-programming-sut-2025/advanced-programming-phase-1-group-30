package Models.Buildings;

public enum CarpenterCosts {
    Wood(10, 0, 0, 0, 0, Integer.MAX_VALUE),
    Stone(20, 0, 0, 0, 0, Integer.MAX_VALUE),
    Barn(6000, 350, 150, 7, 4, 1),
    BigBarn(12000, 450, 200, 7, 4, 1),
    DeluxeBarn(25000, 550, 300, 7, 4, 1),
    Coop(4000, 300, 100, 6, 3, 1),
    BigCoop(10000, 400, 150, 6, 3, 1),
    DeluxeCoop(20000, 500, 200, 6, 3, 1),
    Well(1000, 0, 75, 3, 3, 1),
    ShippingBin(250, 150, 0, 1, 1, Integer.MAX_VALUE);

    private final int cost;
    private final int wood;
    private final int stone;
    private final int length;
    private final int width;
    private final int dailyLimit;

    CarpenterCosts(int cost, int wood, int stone, int length, int width, int dailyLimit) {
        this.cost = cost;
        this.wood = wood;
        this.stone = stone;
        this.length = length;
        this.width = width;
        this.dailyLimit = dailyLimit;
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

