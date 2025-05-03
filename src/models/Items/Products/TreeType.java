package models.Items.Products;

import java.util.ArrayList;

import models.TimeAndDate.Season;

public enum TreeType {
    APRICOT_TREE("Apricot Tree", null, null, 28, null, 1, 59, true, 38, null),
    CHERRY_TREE("Cherry Tree", null, null, 28, null, 1, 80, true, 38, null),
    BANANA_TREE("Banana Tree", null, null, 28, null, 1, 150, true, 75, null),
    MANGO_TREE("Mango Tree", null, null, 28, null, 1, 130, true, 100, null),
    ORANGE_TREE("Orange Tree", null, null, 28, null, 1, 100, true, 38, null),
    PEACH_TREE("Peach Tree", null, null, 28, null, 1, 140, true, 38, null),
    APPLE_TREE("Apple Tree", null, null, 28, null, 1, 100, true, 38, null),
    POMEGRANATE_TREE("Pomegranate Tree", null, null, 28, null, 1, 140, true, 38, null),
    OAK_TREE("Oak Tree", null, null, 28, null, 7, 150, false, 0, null),
    MAPLE_TREE("Maple Tree", null, null, 28, null, 9, 200, false, 0, null),
    PINE_TREE("Pine Tree", null, null, 28, null, 5, 100, false, 0, null),
    MAHOGANY_TREE("Mahogany Tree", null, null, 28, null, 1, 2, true, -2, null),
    MUSHROOM_TREE("Mushroom Tree", null, null, 28, null, 1, 40, true, 38, null),
    MYSTIC_TREE("Mystic Tree", null, null, 28, null, 7, 1000, true, 500, null);
    
    private final String name;
	private final ForgingSeedType source;
    private final ArrayList<Integer> stages;
    private final int totalHarvestTime;
    private final FruitType friut;
    private final int fruitHarvestCycle;
    private final int fruitBaseSellPrice;
    private final boolean isFruitEdible;
    private final int fruitEnergy;
    private final Season Season;

    private TreeType(String name, ForgingSeedType source, ArrayList<Integer> stages, int totalHarvestTime, FruitType friut,
            int fruitHarvestCycle, int fruitBaseSellPrice, boolean isFruitEdible, int fruitEnergy,
            Season season) {
        this.name = name;
        this.source = source;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.friut = friut;
        this.fruitHarvestCycle = fruitHarvestCycle;
        this.fruitBaseSellPrice = fruitBaseSellPrice;
        this.isFruitEdible = isFruitEdible;
        this.fruitEnergy = fruitEnergy;
        Season = season;
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
    public FruitType getFriut() {
        return friut;
    }
    public int getFruitHarvestCycle() {
        return fruitHarvestCycle;
    }
    public int getFruitBaseSellPrice() {
        return fruitBaseSellPrice;
    }
    public boolean isFruitEdible() {
        return isFruitEdible;
    }
    public int getFruitEnergy() {
        return fruitEnergy;
    }
    public Season getSeason() {
        return Season;
    }
    
    public static TreeType getRandomTreeType(int id) {
        if (id == 0) return APRICOT_TREE;
        if (id == 1) return CHERRY_TREE;
        if (id == 2) return BANANA_TREE;
        if (id == 3) return MANGO_TREE;
        if (id == 4) return ORANGE_TREE;
        if (id == 5) return PEACH_TREE;
        if (id == 6) return APPLE_TREE;
        if (id == 7) return POMEGRANATE_TREE;
        if (id == 8) return OAK_TREE;
        if (id == 9) return MAPLE_TREE;
        if (id == 10) return PINE_TREE;
        if (id == 11) return MAHOGANY_TREE;
        if (id == 12) return MUSHROOM_TREE;
        if (id == 13) return MYSTIC_TREE;

        return APRICOT_TREE;
    }
}
