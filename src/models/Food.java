package models;

import models.Foods.FoodType;

public class Food extends Item{
    private final FoodType type;

    public Food(int count, FoodType type) {
        super(count);
        this.type = type;
    }

    public FoodType getType() {
        return type;
    }
}
