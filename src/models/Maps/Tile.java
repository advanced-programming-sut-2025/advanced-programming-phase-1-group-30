package models.Maps;

import models.Items.Item;
import models.Items.Products.Crop;
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
    private boolean readyToHarvest;
    private Tile[] giantCrop = new Tile[4];
    private boolean isGiantCrop = false;
    private boolean giantCropCheck = false;
    private Crop crop;

    public Tile(int x, int y, TileTypes type, boolean walkable, boolean isHarvestable, int id) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.walkable = walkable;
        if (id != -1){
            Tile.putItemInTile(this);
        }
        this.isHarvestable = isHarvestable;
        this.isPlanted = false;
    }
    public static Tile createTileFromType(int x, int y, String tileType, int id) {
        switch (tileType.toLowerCase()) {
            case "dirt":
                return new Tile(x, y, TileTypes.DIRT, true, true, id);
            case "grass":
                return new Tile(x, y, TileTypes.GRASS, true, true, id);
            case "river":
                return new Tile(x, y, TileTypes.WATER, false, false, id);
            case "hut":
                return new Tile(x, y, TileTypes.HUT, false, false, id);
            case "greenhouse":
                return new Tile(x, y, TileTypes.GREENHOUSE, false, false, id);
            case "quarry":
                return new Tile(x, y, TileTypes.QUARRY, true, false, id);
            case "blacksmith":
                return new Tile(x, y, TileTypes.BLACKSMITH, true, true, id);
            case "carpenters-shop":
                return new Tile(x, y, TileTypes.CARPENTERS_SHOP, true, true, id);
            case "jojomart":
                return new Tile(x, y, TileTypes.JOJOMART, false, false, id);
            case "pierres-store":
                return new Tile(x, y, TileTypes.PIERRES_GENERAL_STORE, false, false, id);
            case "fish-shop":
                return new Tile(x, y, TileTypes.FISH_SHOP, false, false, id);
            case "marnies-ranch":
                return new Tile(x, y, TileTypes.MARINES_RANCH, true, false, id);
            case "stardrop-saloon":
                return new Tile(x, y, TileTypes.THE_STARDROP_SALOON, true, false, id);
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
            case WATER, BUILDING, GREENHOUSE: this.walkable = false; break;
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
                // Emptygit
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

    public boolean isReadyToHarvest() {
        return readyToHarvest;
    }

    public void setReadyToHarvest(boolean readyToHarvest) {
        this.readyToHarvest = readyToHarvest;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public Tile[] getGiantCrop() {
        return giantCrop;
    }

    public boolean isGiantCrop() {
        return isGiantCrop;
    }

    public void setGiantCrop(boolean giantCrop) {
        isGiantCrop = giantCrop;
    }

    public boolean isGiantCropCheck() {
        return giantCropCheck;
    }

    public void setGiantCropCheck(boolean giantCropCheck) {
        this.giantCropCheck = giantCropCheck;
    }

    public void setGiantCrops(Tile[] giantCrop) {
        this.giantCrop = giantCrop;
    }
}