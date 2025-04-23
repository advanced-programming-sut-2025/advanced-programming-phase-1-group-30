package models;

import models.enums.TIleTypes;

import java.util.ArrayList;

public class Tile {
    private TIleTypes type;
    private Item item;
    private int x;
    private int y;
    private boolean walkable;

    public Tile(int x, int y) {
        this.type = TIleTypes.DIRT;
        this.x = x;
        this.y = y;
        this.walkable = true;
    }
    
    public TIleTypes getType() {
        return type;
    }
    public void setType(TIleTypes type) {
        this.type = type;
        switch (type) {
            case WATER: this.walkable = false; break;
            case BUILDING: this.walkable = false; break;
            case GRASS: this.walkable = true; break;
            case PLANTABLE: this.walkable = true; break;
            case DIRT: this.walkable = true; break;
            case QUARRY: this.walkable = true; break;
        }
    }

    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
}
