package models.Animals;

import models.Items.Item;

public class Fish extends Item {
    private final FishType type;

    public Fish(int count, FishType type) {
        super(count, type.getDisplayName());
        this.type = type;
    }
    
    public FishType getType() {
        return type;
    }
}
