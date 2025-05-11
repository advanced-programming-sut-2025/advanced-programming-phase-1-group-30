package models.Animals;

import models.Buildings.RanchCosts;

public class Duck extends Animal {
    public Duck(int price, String name, int friendship, boolean fedToday, boolean petToday, int x, int y) {
        super(price, name, friendship, fedToday, petToday, x, y, RanchCosts.DUCK);
    }
}
