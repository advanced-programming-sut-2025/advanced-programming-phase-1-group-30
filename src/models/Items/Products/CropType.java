package models.Items.Products;

import java.util.ArrayList;

import models.TimeAndDate.Season;

public enum CropType {
    test("test", null, null, 0, true, 0, 0, true, 0, null, true);

    private final String name;
    private final ForgingSeedType source;
	private final ArrayList<Integer> stages;
    private final int totalHarvestTime;
    private final boolean oneTime;
	private final int regrowthTime;
    private final int baseSellPrice;
    private final boolean isEdible;
	private final int energy;
    private final Season Season;
    private final boolean CanBecomeGiant;
    
    private CropType(String name, ForgingSeedType source, ArrayList<Integer> stages, int totalHarvestTime, boolean oneTime,
            int regrowthTime, int baseSellPrice, boolean isEdible, int energy, Season season,
            boolean canBecomeGiant) {
        this.name = name;
        this.source = source;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.oneTime = oneTime;
        this.regrowthTime = regrowthTime;
        this.baseSellPrice = baseSellPrice;
        this.isEdible = isEdible;
        this.energy = energy;
        Season = season;
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
    public Season getSeason() {
        return Season;
    }
    public boolean isCanBecomeGiant() {
        return CanBecomeGiant;
    }
}
