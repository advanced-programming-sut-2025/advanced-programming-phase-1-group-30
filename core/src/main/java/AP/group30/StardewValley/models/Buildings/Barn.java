package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Animals.Animal;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Maps.TileTypes;

import java.util.ArrayList;

public class Barn extends Building {
    private final int capacity;
    private int currentNumberOfAnimals;
    private final String type;
    private ArrayList<Animal> animals = new ArrayList<>();

    public Barn(int height, int width, int startX, int startY, int capacity, String type) {
        super(height, width, startX, startY, 9, 21, TileTypes.BARN, BuildingTexture.BARN.getTexture()); // TODO
        this.capacity = capacity;
        this.currentNumberOfAnimals = 0;
        this.type = type;
        switch (type) {
            case "regular": this.texture = BuildingTexture.BARN.getTexture(); break;
            case "big": this.texture = BuildingTexture.BIG_BARN.getTexture(); break;
            case "deluxe": this.texture = BuildingTexture.DELUXE_BARN.getTexture(); break;
        }
    }
    public int getCapacity() {
        return capacity;
    }
    public String getType() {
        return type;
    }
    public int getCurrentNumberOfAnimals() {
        return currentNumberOfAnimals;
    }
    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    public void setCurrentNumberOfAnimals(int currentNumberOfAnimals) {
        this.currentNumberOfAnimals = currentNumberOfAnimals + 1;
    }
}
