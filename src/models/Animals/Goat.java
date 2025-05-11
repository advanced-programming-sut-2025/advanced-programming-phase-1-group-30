package models.Animals;

import models.Buildings.RanchCosts;

public class Goat extends Animal {
    public Goat(int price, String name, int friendship, boolean fedToday, boolean petToday, int x, int y) {
        super(price, name, friendship, fedToday, petToday, x, y, RanchCosts.GOAT);
    }
}
