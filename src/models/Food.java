package models;

import models.Foods.FoodType;

public class Food extends Item {
    private final FoodType type;

    public Food(int count, FoodType type) {
        super(count, type.getName());
        this.type = type;
    }

    public FoodType getType() {
        return type;
    }
}
