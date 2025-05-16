package models.Items.Products;

import java.util.ArrayList;
import java.util.Arrays;

import models.Items.ItemsInteface;
import models.TimeAndDate.Season;

public enum CropType implements ItemsInteface {
    BLUE_JAZZ("blue jazz", ForagingSeedType.JAZZ_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 2, 2)), 7, true, 0, 50, true, 45, 20, new ArrayList<Season>(Arrays.asList(Season.SPRING)), true),
    CARROT("carrot", ForagingSeedType.CARROT_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1)), 3, true, 0, 35, true, 75, 33, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    CAULIFLOWER("cauliflower", ForagingSeedType.CAULIFLOWER_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 4, 4, 1)), 12, true, 0, 175, true, 75, 33, new ArrayList<Season>(Arrays.asList(Season.SPRING)), true),
    COFFEE_BEAN("coffee bean", ForagingSeedType.COFFEE_BEAN, new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3, 2)), 10, false, 2, 15, false, 0, 0, new ArrayList<Season>(Arrays.asList(Season.SPRING, Season.SUMMER)), false),
    GARLIC("garlic", ForagingSeedType.GARLIC_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1)), 4, true, 0, 60, true, 20, 9, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    GREEN_BEAN("green bean", ForagingSeedType.BEAN_STARTER, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 3, 4)), 10, false, 3, 40, true, 25, 11, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    KALE("kale", ForagingSeedType.KALE_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 2, 1)), 6, true, 0, 110, true, 50, 22, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    PARSNIP("parsnip", ForagingSeedType.PARSNIP_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1)), 4, true, 0, 35, true, 25, 11, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    POTATO("potato", ForagingSeedType.POTATO_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 2, 1)), 6, true, 0, 80, true, 25, 11, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    RHUBARB("rhubarb", ForagingSeedType.RHUBARB_SEEDS, new ArrayList<Integer>(Arrays.asList(2, 2, 2, 3, 4)), 13, true, 0, 220, false, 0, 0, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    STRAWBERRY("strawberry", ForagingSeedType.STRAWBERRY_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 2, 2, 2)), 8, false, 4, 120, true, 50, 22, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    TULIP("tulip", ForagingSeedType.TULIP_BULB, new ArrayList<Integer>(Arrays.asList(1, 1, 2, 2)), 6, true, 0, 30, true, 45, 20, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    UNMILLED_RICE("unmilled rice", ForagingSeedType.RICE_SHOOT, new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3)), 8, true, 0, 30, true, 3, 1, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    BLUEBERRY("blueberry", ForagingSeedType.BLUEBERRY_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 3, 3, 4, 2)), 13, false, 4, 50, true, 25, 11, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    CORN("corn", ForagingSeedType.CORN_SEEDS, new ArrayList<Integer>(Arrays.asList(2, 3, 3, 3, 3)), 14, false, 4, 50, true, 25, 11, new ArrayList<Season>(Arrays.asList(Season.SUMMER, Season.FALL)), false),
    HOPS("hops", ForagingSeedType.HOPS_STARTER, new ArrayList<Integer>(Arrays.asList(1, 1, 2, 3, 4)), 11, false, 1, 25, true, 45, 20, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    HOT_PEPPER("hot pepper", ForagingSeedType.PEPPER_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1)), 5, false, 3, 40, true, 13, 5, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    MELON("melon", ForagingSeedType.MELON_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 3, 3)), 12, true, 0, 250, true, 113, 50, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), true),
    POPPY("poppy", ForagingSeedType.POPPY_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 2, 2)), 7, true, 0, 140, true, 45, 20, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    RADISH("radish", ForagingSeedType.RADISH_SEEDS, new ArrayList<Integer>(Arrays.asList(2, 1, 2, 1)), 6, true, 0, 90, true, 45, 20, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    RED_CABBAGE("red cabbage", ForagingSeedType.RED_CABBAGE_SEEDS, new ArrayList<Integer>(Arrays.asList(2, 1, 2, 2, 2)), 9, true, 0, 260, true, 75, 33, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    STARFRUIT("starfruit", ForagingSeedType.STARFRUIT_SEEDS, new ArrayList<Integer>(Arrays.asList(2, 3, 2, 3, 3)), 13, true, 0, 750, true, 125, 56, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    SUMMER_SPANGLE("summer spangle", ForagingSeedType.SPANGLE_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 1)), 8, true, 0, 90, true, 45, 20, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    SUMMER_SQUASH("summer squash", ForagingSeedType.SUMMER_SQUASH_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 2, 1)), 6, false, 3, 45, true, 63, 28, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    SUNFLOWER("sunflower", ForagingSeedType.SUNFLOWER_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 2)), 8, true, 0, 80, true, 45, 20, new ArrayList<Season>(Arrays.asList(Season.SUMMER, Season.FALL)), false),
    TOMATO("tomato", ForagingSeedType.TOMATO_SEEDS, new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 3)), 11, false, 4, 60, true, 20, 9, new ArrayList<Season>(Arrays.asList(Season.SUMMER)), false),
    WHEAT("wheat", ForagingSeedType.WHEAT_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1)), 4, true, 0, 25, false, 0, 0, new ArrayList<Season>(Arrays.asList(Season.SUMMER, Season.FALL)), false),
    AMARANTH("amaranth", ForagingSeedType.AMARANTH_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 2, 2)), 7, true, 0, 150, true, 50, 22, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    ARTICHOKE("artichoke", ForagingSeedType.ARTICHOKE_SEEDS, new ArrayList<Integer>(Arrays.asList(2, 2, 1, 2, 1)), 8, true, 0, 160, true, 30, 13, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    BEET("beet", ForagingSeedType.BEET_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 2, 2)), 6, true, 0, 100, true, 30, 13, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    BOK_CHOY("bok choy", ForagingSeedType.BOK_CHOY_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1)), 4, true, 0, 80, true, 25, 11, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    BROCCOLI("broccoli", ForagingSeedType.BROCCOLI_SEEDS, new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2)), 8, false, 4, 70, true, 63, 28, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    CRANBERRIES("cranberries", ForagingSeedType.CRANBERRY_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 1, 1, 2)), 7, false, 5, 75, true, 38, 17, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    EGGPLANT("eggplant", ForagingSeedType.EGGPLANT_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1)), 5, false, 5, 60, true, 20, 9, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    FAIRY_ROSE("fairy rose", ForagingSeedType.FAIRY_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 4, 4, 3)), 12, true, 0, 290, true, 45, 20, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    GRAPE("grape", ForagingSeedType.GRAPE_STARTER, new ArrayList<Integer>(Arrays.asList(1, 1, 2, 3, 3)), 10, false, 3, 80, true, 38, 17, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    PUMPKIN("pumpkin", ForagingSeedType.PUMPKIN_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 3)), 13, true, 0, 320, false, 0, 0, new ArrayList<Season>(Arrays.asList(Season.FALL)), true),
    YAM("yam", ForagingSeedType.YAM_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 3, 3, 3)), 10, true, 0, 160, true, 45, 20, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    SWEET_GEM_BERRY("Sweet Gem Berry", ForagingSeedType.RARE_SEED, new ArrayList<Integer>(Arrays.asList(2, 4, 6, 6, 6)), 24, true, 0, 3000, false, 0, 0, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    POWDERMELON("powdermelon", ForagingSeedType.POWDERMELON_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 2, 1, 2, 1)), 7, true, 0, 60, true, 63, 28, new ArrayList<Season>(Arrays.asList(Season.WINTER)), true),
    ANCIENT_FRUIT("ancient fruit", ForagingSeedType.ANCIENT_SEEDS, new ArrayList<Integer>(Arrays.asList(2, 7, 7, 7, 5)), 28, false, 7, 550, false, 0, 0, new ArrayList<Season>(Arrays.asList(Season.SPRING, Season.SUMMER, Season.FALL)), false),
    MUSHROOM("mushroom", ForagingSeedType.MUSHROOM_TREE_SEEDS, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1)), 12, false, 7, 20, true, 5, 5, new ArrayList<Season>(Arrays.asList(Season.SPRING, Season.SUMMER, Season.FALL)), false),
    APRICOT("apricot", ForagingSeedType.APRICOT_SAPLING, new ArrayList<>(Arrays.asList(7, 7, 7, 7)), 1, false, 1, 59, true, 38,0, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    CHERRY("cherry", ForagingSeedType.CHERRY_SAPLING, new ArrayList<>(Arrays.asList(7, 7, 7, 7)), 1, false, 1, 80, true, 38,0, new ArrayList<Season>(Arrays.asList(Season.SPRING)), false),
    BANANA("banana", ForagingSeedType.BANANA_SAPLING, new ArrayList<>(Arrays.asList(7, 7, 7, 7)), 1, false, 1, 150, true, 75,0, new ArrayList<Season>(Arrays.asList( Season.SUMMER)), false),
    MANGO("mango", ForagingSeedType.MANGO_SAPLING, new ArrayList<>(Arrays.asList(7, 7, 7, 7)), 1, false, 1, 130, true, 100, 0, new ArrayList<Season>(Arrays.asList( Season.SUMMER)), false),
    ORANGE("orange", ForagingSeedType.ORANGE_SAPLING, new ArrayList<>(Arrays.asList(7, 7, 7, 7)), 1, false, 1, 100, true, 38, 0, new ArrayList<Season>(Arrays.asList( Season.SUMMER)), false),
    PEACH("peach", ForagingSeedType.PEACH_SAPLING, new ArrayList<>(Arrays.asList(7, 7, 7, 7)), 1, false, 1, 140, true, 38, 0, new ArrayList<Season>(Arrays.asList( Season.SUMMER)), false),
    APPLE("apple", ForagingSeedType.APPLE_SAPLING, new ArrayList<>(Arrays.asList(7, 7, 7, 7)), 1, false, 1, 100, true, 38, 0, new ArrayList<Season>(Arrays.asList( Season.FALL)), false),
    POMEGRANATE("pomegranate", ForagingSeedType.POMEGRANATE_SAPLING, new ArrayList<>(Arrays.asList(7, 7, 7, 7)), 1, false, 1, 140, true,38, 0, new ArrayList<Season>(Arrays.asList(Season.FALL)), false),
    OAK_RESIN("oak resin", ForagingSeedType.OAK_TREE, new ArrayList<>(Arrays.asList(7, 7, 7, 7)), 1, false, 7, 150, false, 0,0, new ArrayList<Season>(Arrays.asList(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)), false),
    MAPLE_SYRUP("maple syrup", ForagingSeedType.MAPLE_SEEDS, new ArrayList<>(Arrays.asList(7, 7, 7, 7)), 1, false, 9, 200, false, 0,0, new ArrayList<Season>(Arrays.asList(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)), false),
    PINE_TAR("pine tar", ForagingSeedType.PINE_CONES, new ArrayList<>(Arrays.asList(7, 7, 7, 7)), 1, false, 5, 100, false, 0, 0, new ArrayList<Season>(Arrays.asList(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)), false),
    SAP("sap", ForagingSeedType.MAHOGANY_SEEDS, new ArrayList<>(Arrays.asList(7, 7, 7, 7)), 1, false, 1, 2, true, -2, 0, new ArrayList<Season>(Arrays.asList(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)), false),
    COMMON_MUSHROOM("common mushroom", ForagingSeedType.MUSHROOM_TREE_SEEDS, new ArrayList<>(Arrays.asList(7, 7, 7, 7)), 1, false, 1, 40, true, 38, 0, new ArrayList<Season>(Arrays.asList(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)), false),
    MYSTIC_SYRUP("mystic syrup", ForagingSeedType.MYSTIC_TREE_SEEDS, new ArrayList<>(Arrays.asList(7, 7, 7, 7)), 1, false, 7, 1000, true, 500, 0, new ArrayList<Season>(Arrays.asList(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)), false);

    private final String name;
    private final ForagingSeedType source;
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

    private CropType(String name, ForagingSeedType source, ArrayList<Integer> stages, int totalHarvestTime,
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
    public ForagingSeedType getSource() {
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
