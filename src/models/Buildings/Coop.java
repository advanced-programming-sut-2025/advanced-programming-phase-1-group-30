package models.Buildings;

import models.Animals.Animal;

import java.util.ArrayList;

public class Coop extends Building {
    private final int capacity;
    private int currentNumberOfAnimals;
    private final String type;
    private ArrayList<Animal> animals = new ArrayList<>();

    public Coop(int height, int width, int startX, int startY, int capacity, String type) {
        super(height, width, startX, startY, 9, 21);
        this.type = type;
        this.capacity = capacity;
        this.currentNumberOfAnimals = 0;
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
