package models.Products;

import models.enums.Season;

import java.util.ArrayList;

public enum TreeType {
    test("", null, null, 0, null, 0, 0, true, 0, null);

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
}
