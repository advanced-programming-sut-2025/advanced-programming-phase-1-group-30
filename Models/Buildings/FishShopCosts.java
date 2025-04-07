package Models.Buildings;

public enum FishShopCosts {
    FISH_SMOKER_RECIPE("A recipe to make Fish Smoker", 10000, -1, 1),
    TROUT_SOUP("Pretty salty.", 250, -1, 1),
    BAMBOO_POLE("Use in the water to catch fish.", 500, -1, 1),
    TRAINING_ROD("It's a lot easier to use than other rods, but can only catch basic fish.", 25, -1, 1),
    FIBERGLASS_ROD("Use in the water to catch fish.", 1800, 2, 1),
    IRIDIUM_ROD("Use in the water to catch fish.", 7500, 4, 1);

    public final String description;
    public final int price;
    public final int fishingSkillRequired; // -1 means no requirement
    public final int dailyLimit;

    FishShopCosts(String description, int price, int fishingSkillRequired, int dailyLimit) {
        this.description = description;
        this.price = price;
        this.fishingSkillRequired = fishingSkillRequired;
        this.dailyLimit = dailyLimit;
    }
}
