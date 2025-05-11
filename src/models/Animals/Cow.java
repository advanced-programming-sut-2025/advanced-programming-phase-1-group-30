package models.Animals;

import models.Buildings.RanchCosts;

public class Cow extends Animal {
    public Cow(int price, String name, int friendship, boolean fedToday, boolean petToday, int x, int y) {
        super(price, name, friendship, fedToday, petToday, x, y, RanchCosts.COW);
    }
}
