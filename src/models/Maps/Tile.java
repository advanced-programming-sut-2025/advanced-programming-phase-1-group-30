package models.Maps;

import models.Items.Item;
import models.Items.Products.Stone;
import models.Items.Products.Tree;
import models.Items.Products.TreeType;

import java.util.Objects;
import java.util.Random;

public class Tile {
    private TileTypes type;
    private Item item;
    private final int x;
    private final int y;
    private boolean walkable;

    public Tile(int x, int y, TileTypes type, boolean walkable) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.walkable = walkable;
        Tile.putItemInTile(this);
    }
    public static Tile createTileFromType(int x, int y, String tileType) {
        switch (tileType.toLowerCase()) {
            case "dirt":
                return new Tile(x, y, TileTypes.DIRT, true);
            case "grass":
                return new Tile(x, y, TileTypes.GRASS, true);
            case "river":
                return new Tile(x, y, TileTypes.WATER, false);
            case "hut":
                return new Tile(x, y, TileTypes.HUT, false);
            case "greenhouse":
                return new Tile(x, y, TileTypes.GREENHOUSE, false);
            case "quarry":
                return new Tile(x, y, TileTypes.QUARRY, false);
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
    public void changeWalkable() {
        this.walkable = !this.walkable;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tile other = (Tile) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static void putItemInTile(Tile tile) {
        if (tile.walkable) {
            Random random = new Random();
            int randomItem = random.nextInt(10);

            if (0 <= randomItem && randomItem <= 4) {
                // Empty
            }
            else if (5 <= randomItem && randomItem <= 8) {
                tile.setItem(new Tree(1, TreeType.test));
                tile.changeWalkable();
            }
            else if (9 <= randomItem && randomItem <= 9) {
                tile.setItem(new Stone(1));
                tile.changeWalkable();
            }
        }
    }
}