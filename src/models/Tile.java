package models;

import models.enums.TileTypes;

public class Tile {
    private TileTypes type;
    private Item item;
    private final int x;
    private final int y;
    private boolean walkable;

    public Tile(int x, int y, TileTypes type) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.walkable = true;
    }
    public static Tile createTileFromType(int x, int y, String tileType) {
        switch (tileType.toLowerCase()) {
            case "dirt":
                return new Tile(x, y, TileTypes.DIRT);
            case "grass":
                return new Tile(x, y, TileTypes.GRASS);
            case "river":
                return new Tile(x, y, TileTypes.WATER);
            case "hut":
                return new Tile(x, y, TileTypes.HUT);
            case "greenhouse":
                return new Tile(x, y, TileTypes.GREENHOUSE);
            case "quarry":
                return new Tile(x, y, TileTypes.QUARRY);
            default:
                throw new IllegalArgumentException("Unknown tile type: " + tileType);
        }
    }

    public TileTypes getType() {
        return type;
    }
    public void setType(TileTypes type) {
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

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public boolean isWalkable() {
        return walkable;
    }
    public void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }
}