package models.Items.Products;
import java.util.ArrayList;

public class Crop extends Product{
    private final CropType type;
    private ArrayList<Integer> stages;
    private int currentStage = 0;
    private int daysPassed = 0;
    private boolean notNeedWaterAnymore = false;
    private boolean wateredToday = false;
    private int daysNotWatered = 0;
    private int regrowthTime = 0;

    public Crop(int count, CropType type) {
        super(count, type.getName(), type.getBaseSellPrice());
        this.type = type;
        stages = type.getStages();
    }

    public CropType getType() {
        return type;
    }

    public ArrayList<Integer> getStages() {
        return stages;
    }
    public int getCurrentStage() {
        return currentStage;
    }
    public void setCurrentStage(int currentStage) {
        this.currentStage = currentStage;
    }

    public int getDaysPassed() {
        return daysPassed;
    }

    public void setDaysPassed(int daysPassed) {
        this.daysPassed = daysPassed;
    }

    public boolean isNotNeedWaterAnymore() {
        return notNeedWaterAnymore;
    }

    public void setNotNeedWaterAnymore(boolean notNeedWaterAnymore) {
        this.notNeedWaterAnymore = notNeedWaterAnymore;
    }

    public boolean isWateredToday() {
        return wateredToday;
    }
    public void setWateredToday(boolean wateredToday) {
        this.wateredToday = wateredToday;
    }

    public int getDaysNotWatered() {
        return daysNotWatered;
    }

    public void setDaysNotWatered(int daysNotWatered) {
        this.daysNotWatered = daysNotWatered;
    }

    public int getRegrowthTime() {
        return regrowthTime;
    }

    public void setRegrowthTime(int regrowthTime) {
        this.regrowthTime = regrowthTime;
    }
}
