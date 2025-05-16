package models.Buildings;

import models.Items.ItemsInteface;
import models.TimeAndDate.Season;

public enum BlacksmithCosts implements ItemsInteface {
    CopperOre("copper one", 75,Integer.MAX_VALUE, Season.ALL),
    IronOre("iron", 150, Integer.MAX_VALUE, Season.ALL),
    Coal("coal", 150, Integer.MAX_VALUE, Season.ALL),
    GoldOre("gold", 400, Integer.MAX_VALUE, Season.ALL),
    CopperTool("copper tool", 2000, 1, Season.ALL),
    IronTool("iron tool", 5000, 1, Season.ALL),
    GoldTool("gold tool", 10000, 1, Season.ALL),
    IridiumTool("iridium tool", 25000, 1, Season.ALL),
    CopperTrashCan("copper trash can", 1000, 1, Season.ALL),
    IronTrashCan("iron trash can", 2500, 1, Season.ALL),
    GoldTrashCan("gold trash can", 5000, 1, Season.ALL),
    IridiumTrashCan("iridium trash can", 12500, 1, Season.ALL);

    
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
