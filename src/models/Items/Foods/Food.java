package models.Items.Foods;

import models.Items.Item;

public class Food extends Item {
    private final FoodType type;

    public Food(int count, FoodType type) {
        super(count, type.getName(), type.getSellPrice());
        this.type = type;
    }

    public FoodType getType() {
        return type;
    }
}
