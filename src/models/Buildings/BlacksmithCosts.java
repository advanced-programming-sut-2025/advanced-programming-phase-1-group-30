package models.Buildings;

import models.Items.ItemsInteface;
import models.TimeAndDate.Season;

public enum BlacksmithCosts implements ItemsInteface {
    CopperOre("Copper one", 75,Integer.MAX_VALUE, Season.ALL),
    IronOre("Iron", 150, Integer.MAX_VALUE, Season.ALL),
    Coal("Coal", 150, Integer.MAX_VALUE, Season.ALL),
    GoldOre("Gold", 400, Integer.MAX_VALUE, Season.ALL),
    CopperTool("Copper Tool", 2000, 1, Season.ALL),
    IronTool("Iron Tool", 5000, 1, Season.ALL),
    GoldTool("Gold Tool", 10000, 1, Season.ALL),
    IridiumTool("Iridium Tool", 25000, 1, Season.ALL),
    CopperTrashCan("Copper Trash Can", 1000, 1, Season.ALL),
    IronTrashCan("Iron Trash Can", 2500, 1, Season.ALL),
    GoldTrashCan("Gold Trash Can", 5000, 1, Season.ALL),
    IridiumTrashCan("Iridium Trash Can", 12500, 1, Season.ALL);

    
    private final String name;
    private final int cost;
    private final int dailyLimit;
    private final Season season;

    private BlacksmithCosts(String name, int cost, int dailyLimit, Season season) {
        this.name = name;
        this.cost = cost;
        this.dailyLimit = dailyLimit;
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

    public Season getSeason() {
        return season;
    }
}
