package models.Items.Products;

import java.util.ArrayList;
import java.util.Arrays;

import models.TimeAndDate.Season;

public enum CropType {
    BLUE_JAZZ("Blue Jazz", ForgingSeedType.JAZZ_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 2, 2)), 7, true, -1, 50, true, 45, 20, new ArrayList<Season>(Arrays.asList(Season.SPRING)), true),
    CARROT("Carrot", ForgingSeedType.CARROT_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1)), 3, true, -1, 35, true, 75, 33, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    CAULIFLOWER("Cauliflower", ForgingSeedType.CAULIFLOWER_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 4, 4, 1)), 12, true, -1, 175, true, 75, 33, new ArrayList<Season>(Arrays.asList(Season.SPRING)), true),
    COFFEE_BEAN("Coffee Bean", ForgingSeedType.COFFEE_BEAN, new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3, 2)), 10, false, 2, 15, false, -1, -1, new ArrayList<Season>(Arrays.asList(Season.SPRING, Season.SUMMER)), false),
    GARLIC("Garlic", ForgingSeedType.GARLIC_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1)), 4, true, -1, 60, true, 20, 9, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    GREEN_BEAN("Green Bean", ForgingSeedType.BEAN_STARTER, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 3, 4)), 10, false, 3, 40, true, 25, 11, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    KALE("Kale", ForgingSeedType.KALE_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 2, 1)), 6, true, -1, 110, true, 50, 22, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    PARSNIP("Parsnip", ForgingSeedType.PARSNIP_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1)), 4, true, -1, 35, true, 25, 11, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    POTATO("Potato", ForgingSeedType.POTATO_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 2, 1)), 6, true, -1, 80, true, 25, 11, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    RHUBARB("Rhubarb", ForgingSeedType.RHUBARB_SEEDS, new ArrayList<Integer>(Arrays.asList(2, 2, 2, 3, 4)), 13, true, -1, 220, false, -1, -1, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    STRAWBERRY("Strawberry", ForgingSeedType.STRAWBERRY_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 2, 2, 2)), 8, false, 4, 120, true, 50, 22, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    TULIP("Tulip", ForgingSeedType.TULIP_BULB, new ArrayList<Integer>(Arrays.asList(1, 1, 2, 2)), 6, true, -1, 30, true, 45, 20, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    UNMILLED_RICE("Unmilled Rice", ForgingSeedType.RICE_SHOOT, new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3)), 8, true, -1, 30, true, 3, 1, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    BLUEBERRY("Blueberry", ForgingSeedType.BLUEBERRY_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 3, 3, 4, 2)), 13, false, 4, 50, true, 25, 11, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    CORN("Corn", ForgingSeedType.CORN_SEEDS, new ArrayList<Integer>(Arrays.asList(2, 3, 3, 3, 3)), 14, false, 4, 50, true, 25, 11, new ArrayList<Season>(Arrays.asList(Season.SUMMER, Season.FALL)), false),
    HOPS("Hops", ForgingSeedType.HOPS_STARTER, new ArrayList<Integer>(Arrays.asList(1, 1, 2, 3, 4)), 11, false, 1, 25, true, 45, 20, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    HOT_PEPPER("Hot Pepper", ForgingSeedType.PEPPER_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1)), 5, false, 3, 40, true, 13, 5, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    MELON("Melon", ForgingSeedType.MELON_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 3, 3)), 12, true, -1, 250, true, 113, 50, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), true),
    POPPY("Poppy", ForgingSeedType.POPPY_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 2, 2)), 7, true, -1, 140, true, 45, 20, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    RADISH("Radish", ForgingSeedType.RADISH_SEEDS, new ArrayList<Integer>(Arrays.asList(2, 1, 2, 1)), 6, true, -1, 90, true, 45, 20, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    RED_CABBAGE("Red Cabbage", ForgingSeedType.RED_CABBAGE_SEEDS, new ArrayList<Integer>(Arrays.asList(2, 1, 2, 2, 2)), 9, true, -1, 260, true, 75, 33, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    STARFRUIT("Starfruit", ForgingSeedType.STARFRUIT_SEEDS, new ArrayList<Integer>(Arrays.asList(2, 3, 2, 3, 3)), 13, true, -1, 750, true, 125, 56, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    SUMMER_SPANGLE("Summer Spangle", ForgingSeedType.SPANGLE_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 1)), 8, true, -1, 90, true, 45, 20, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    SUMMER_SQUASH("Summer Squash", ForgingSeedType.SUMMER_SQUASH_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 2, 1)), 6, false, 3, 45, true, 63, 28, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    SUNFLOWER("Sunflower", ForgingSeedType.SUNFLOWER_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 2)), 8, true, -1, 80, true, 45, 20, new ArrayList<Season>(Arrays.asList(Season.SUMMER, Season.FALL)), false),
    TOMATO("Tomato", ForgingSeedType.TOMATO_SEEDS, new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 3)), 11, false, 4, 60, true, 20, 9, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    WHEAT("Wheat", ForgingSeedType.WHEAT_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1)), 4, true, -1, 25, false, -1, -1, new ArrayList<Season>(Arrays.asList(Season.SUMMER, Season.FALL)), false),
    AMARANTH("Amaranth", ForgingSeedType.AMARANTH_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 2, 2)), 7, true, -1, 150, true, 50, 22, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    ARTICHOKE("Artichoke", ForgingSeedType.ARTICHOKE_SEEDS, new ArrayList<Integer>(Arrays.asList(2, 2, 1, 2, 1)), 8, true, -1, 160, true, 30, 13, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    BEET("Beet", ForgingSeedType.BEET_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 2, 2)), 6, true, -1, 100, true, 30, 13, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    BOK_CHOY("Bok Choy", ForgingSeedType.BOK_CHOY_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1)), 4, true, -1, 80, true, 25, 11, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    BROCCOLI("Broccoli", ForgingSeedType.BROCCOLI_SEEDS, new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2)), 8, false, 4, 70, true, 63, 28, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    CRANBERRIES("Cranberries", ForgingSeedType.CRANBERRY_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 1, 1, 2)), 7, false, 5, 75, true, 38, 17, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    EGGPLANT("Eggplant", ForgingSeedType.EGGPLANT_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1)), 5, false, 5, 60, true, 20, 9, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    FAIRY_ROSE("Fairy Rose", ForgingSeedType.FAIRY_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 4, 4, 3)), 12, true, -1, 290, true, 45, 20, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    GRAPE("Grape", ForgingSeedType.GRAPE_STARTER, new ArrayList<Integer>(Arrays.asList(1, 1, 2, 3, 3)), 10, false, 3, 80, true, 38, 17, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    PUMPKIN("Pumpkin", ForgingSeedType.PUMPKIN_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 3)), 13, true, -1, 320, false, -1, -1, new ArrayList<Season>(Arrays.asList(Season.FALL)), true),
    YAM("Yam", ForgingSeedType.YAM_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 3, 3, 3)), 10, true, -1, 160, true, 45, 20, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    SWEET_GEM_BERRY("Sweet Gem Berry", ForgingSeedType.RARE_SEED, new ArrayList<Integer>(Arrays.asList(2, 4, 6, 6, 6)), 24, true, -1, 3000, false, -1, -1, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    POWDERMELON("Powdermelon", ForgingSeedType.POWDERMELON_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 1, 2, 1)), 7, true, -1, 60, true, 63, 28, new ArrayList<Season>(Arrays.asList(Season.WINTER)), true),
    ANCIENT_FRUIT("Ancient Fruit", ForgingSeedType.ANCIENT_SEEDS, new ArrayList<Integer>(Arrays.asList(2, 7, 7, 7, 5)), 28, false, 7, 550, false, -1, -1, new ArrayList<Season>(Arrays.asList(Season.SPRING, Season.SUMMER, Season.FALL)), false);

    private final String name;
    private final ForgingSeedType source;
	private final ArrayList<Integer> stages;
    private final int totalHarvestTime;
    private final boolean oneTime;
	private final int regrowthTime;
    private final int baseSellPrice;
    private final boolean isEdible;
	private final int energy;
	private final int health;
    private final ArrayList<Season> seasons;
    private final boolean CanBecomeGiant;

    private CropType(String name, ForgingSeedType source, ArrayList<Integer> stages, int totalHarvestTime,
            boolean oneTime, int regrowthTime, int baseSellPrice, boolean isEdible, int energy, int health,
            ArrayList<Season> seasons, boolean canBecomeGiant) {
        this.name = name;
        this.source = source;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.oneTime = oneTime;
        this.regrowthTime = regrowthTime;
        this.baseSellPrice = baseSellPrice;
        this.isEdible = isEdible;
        this.energy = energy;
        this.health = health;
        this.seasons = seasons;
        CanBecomeGiant = canBecomeGiant;
    }

    public String getName() {
        return name;
    }
    public ForgingSeedType getSource() {
        return source;
    }
    public ArrayList<Integer> getStages() {
        return stages;
    }
    public int getTotalHarvestTime() {
        return totalHarvestTime;
    }
    public boolean isOneTime() {
        return oneTime;
    }
    public int getRegrowthTime() {
        return regrowthTime;
    }
    public int getBaseSellPrice() {
        return baseSellPrice;
    }
    public boolean isEdible() {
        return isEdible;
    }
    public int getEnergy() {
        return energy;
    }
    public int getHealth() {
        return health;
    }
    public ArrayList<Season> getSeasons() {
        return seasons;
    }
    public boolean isCanBecomeGiant() {
        return CanBecomeGiant;
    }
    
}
