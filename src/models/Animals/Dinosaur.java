package models.Animals;

import models.Buildings.RanchCosts;

public class Dinosaur extends Animal {
    public Dinosaur(int price, String name, int friendship, boolean fedToday, boolean petToday, int x, int y) {
        super(price, name, friendship, fedToday, petToday, x, y, RanchCosts.DINOSAUR);
    }
}
