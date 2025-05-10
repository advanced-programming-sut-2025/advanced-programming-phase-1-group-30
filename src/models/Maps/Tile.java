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
    private boolean isHarvestable;
    private boolean isPlanted;
    private boolean isReadyToHarvest;

    public Tile(int x, int y, TileTypes type, boolean walkable, boolean isHarvestable) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.walkable = walkable;
        Tile.putItemInTile(this);
        this.isHarvestable = isHarvestable;
        this.isPlanted = false;
    }
    public static Tile createTileFromType(int x, int y, String tileType) {
        switch (tileType.toLowerCase()) {
            case "dirt":
                return new Tile(x, y, TileTypes.DIRT, true, true);
            case "grass":
                return new Tile(x, y, TileTypes.GRASS, true, true);
            case "river":
                return new Tile(x, y, TileTypes.WATER, false, false);
            case "hut":
                return new Tile(x, y, TileTypes.HUT, false, false);
            case "greenhouse":
                return new Tile(x, y, TileTypes.GREENHOUSE, false, false);
            case "quarry":
                return new Tile(x, y, TileTypes.QUARRY, true, false);
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
            case WATER, BUILDING: this.walkable = false; break;
            case GRASS, PLANTABLE, DIRT, QUARRY: this.walkable = true; break;
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

    public boolean isHarvestable() {
        return isHarvestable;
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
        if (tile.getType().equals(TileTypes.DIRT)) {
            Random random = new Random();
            int randomItem = random.nextInt(55);

            if (0 <= randomItem && randomItem <= 35) {
                // Empty
            }
            else if (36 <= randomItem && randomItem <= 49) {
                tile.setItem(new Tree(1, TreeType.getRandomTreeType(randomItem - 36)));
                tile.changeWalkable();
            }
            else if (50 <= randomItem && randomItem <= 54) {
                tile.setItem(new Stone(randomItem - 49));
                tile.changeWalkable();
            }
        }
    }

    public boolean isPlanted() {
        return isPlanted;
    }

    public void setPlanted(boolean planted) {
        isPlanted = planted;
    }

    public void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }

    public void setHarvestable(boolean harvestable) {
        isHarvestable = harvestable;
    }

    public boolean isReadyToHarvest() {
        return isReadyToHarvest;
    }

    public void setReadyToHarvest(boolean readyToHarvest) {
        isReadyToHarvest = readyToHarvest;
    }
}