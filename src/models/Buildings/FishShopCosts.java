package models.Buildings;

import models.Items.ItemsInteface;
import models.TimeAndDate.Season;

public enum FishShopCosts implements ItemsInteface {

    FISH_SMOKER_RECIPE("A recipe to make Fish Smoker", "Use this recipe to craft a Fish Smoker.", 10000, -1, 1, Season.ALL),
    TROUT_SOUP("trout soup", "Pretty salty.", 250, -1, 1, Season.ALL),
    BAMBOO_POLE("bamboo pole", "Use in the water to catch fish.", 500, -1, 1, Season.ALL),
    TRAINING_ROD("training rod", "It's a lot easier to use than other rods, but can only catch basic fish.", 25, -1, 1, Season.ALL),
    FIBERGLASS_ROD("fiberglass rod", "Use in the water to catch fish.", 1800, 2, 1, Season.ALL),
    IRIDIUM_ROD("iridium rod", "Use in the water to catch fish.", 7500, 4, 1, Season.ALL);


    private final String name;
    private final String description;
    private final int price;
    private final int fishingSkillRequired; // -1 means no requirement
    private final int dailyLimit;
    private final Season season;

    public Season getSeason() {
        return season;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getFishingSkillRequired() {
        return fishingSkillRequired;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }

    FishShopCosts(String name, String description, int price, int fishingSkillRequired, int dailyLimit, Season season) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.fishingSkillRequired = fishingSkillRequired;
        this.dailyLimit = dailyLimit;
        this.season = season;
    }
}
