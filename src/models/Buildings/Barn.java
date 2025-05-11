package models.Buildings;

import models.Animals.Animal;
import java.util.ArrayList;

public class Barn extends Buildings{
    private final int capacity;
    private int currentNumberOfAnimals;
    private final String type;
    private ArrayList<Animal> animals;

    public Barn(int length, int width, int startX, int startY, int capacity, String type) {
        super(length, width, startX, startY);
        this.capacity = capacity;
        this.currentNumberOfAnimals = 0;
        this.type = type;
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
