package models.Buildings;

import models.Items.ItemsInteface;

public enum BlacksmithCosts implements ItemsInteface {
    CopperOre("Copper one", 75,Integer.MAX_VALUE),
    IronOre("Iron", 150, Integer.MAX_VALUE),
    Coal("Coal", 150, Integer.MAX_VALUE),
    GoldOre("Gold", 400, Integer.MAX_VALUE),
    CopperTool("Copper Tool", 2000, 1),
    IronTool("Iron Tool", 5000, 1),
    GoldTool("Gold Tool", 10000, 1),
    IridiumTool("Iridium Tool", 25000, 1),
    CopperTrashCan("Copper Trash Can", 1000, 1),
    IronTrashCan("Iron Trash Can", 2500, 1),
    GoldTrashCan("Gold Trash Can", 5000, 1),
    IridiumTrashCan("Iridium Trash Can", 12500, 1);

    
    private final String name;
    private final int cost;
    private final int dailyLimit;
    private BlacksmithCosts(String name, int cost, int dailyLimit) {
        this.name = name;
        this.cost = cost;
        this.dailyLimit = dailyLimit;
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
}
