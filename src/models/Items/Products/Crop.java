package models.Items.Products;
import java.util.ArrayList;
import models.Maps.Tile;

public class Crop extends Product{
    private final CropType type;
    private ArrayList<Integer> stages = new ArrayList<>();
    private int currentStage = 0;
    private int daysPassed = 0;


    public Crop(int count, CropType type, Tile tile) {
        super(count, type.getName(), tile);
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
}
