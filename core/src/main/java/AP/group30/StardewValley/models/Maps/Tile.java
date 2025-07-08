package AP.group30.StardewValley.models.Maps;

import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.Products.*;
import AP.group30.StardewValley.views.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
    private final Texture texture;

    public Tile(int x, int y, TileTypes type, boolean walkable, boolean isHarvestable, int id, Texture texture) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.walkable = walkable;
        if (id != -1){
            Tile.putItemInTile(this);
        }
        this.isHarvestable = isHarvestable;
        this.isPlanted = false;
        this.texture = texture;
    }
    public static Tile createTileFromType(int x, int y, String tileType, int id) {
        switch (tileType.toLowerCase()) {
            case "dirt":
                return new Tile(x, y, TileTypes.DIRT, true, true, id, TileTexture.DIRT.getTexture());
            case "grass":
                return new Tile(x, y, TileTypes.GRASS, true, true, id, TileTexture.GRASS.getTexture());
            case "river":
                return new Tile(x, y, TileTypes.WATER, false, false, id, TileTexture.RIVER.getTexture());
            case "hut":
                return new Tile(x, y, TileTypes.HUT, false, false, id, TileTexture.DIRT.getTexture());
            case "greenhouse":
                return new Tile(x, y, TileTypes.GREENHOUSE, false, false, id, TileTexture.DIRT.getTexture());
            case "quarry":
                return new Tile(x, y, TileTypes.QUARRY, true, false, id, TileTexture.DIRT.getTexture());
            case "blacksmith":
                return new Tile(x, y, TileTypes.BLACKSMITH, true, true, id, TileTexture.DIRT.getTexture());
            case "carpenters-shop":
                return new Tile(x, y, TileTypes.CARPENTERS_SHOP, true, true, id, TileTexture.DIRT.getTexture());
            case "jojomart":
                return new Tile(x, y, TileTypes.JOJOMART, true, false, id, TileTexture.DIRT.getTexture());
            case "pierres-store":
                return new Tile(x, y, TileTypes.PIERRES_GENERAL_STORE, true, false, id, TileTexture.DIRT.getTexture());
            case "fish-shop":
                return new Tile(x, y, TileTypes.FISH_SHOP, true, false, id, TileTexture.DIRT.getTexture());
            case "marnies-ranch":
                return new Tile(x, y, TileTypes.MARINES_RANCH, true, false, id, TileTexture.DIRT.getTexture());
            case "stardrop-saloon":
                return new Tile(x, y, TileTypes.THE_STARDROP_SALOON, true, false, id, TileTexture.DIRT.getTexture());
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
            int randomItem = random.nextInt(75);
            if (randomItem <= 43 || randomItem >= 47) {
                // Empty
            }
            else if (randomItem <= 45) {
                int x = random.nextInt(13);
                tile.setItem(new Tree(1, TreeType.getRandomTreeType(x), tile.getX() * 32 - 32, (60 - tile.getY()) * 32));
                tile.changeWalkable();
            }
            else {
                tile.setItem(new Stone(randomItem - 49, tile.getX() * 32 - 32, (60 - tile.getY()) * 32));
                tile.changeWalkable();
            }
        }
        if(tile.getType().equals(TileTypes.QUARRY)) {
            Random random = new Random();
            int randomItem = random.nextInt(67);
            int randomItem1 = random.nextInt(10);

            if(randomItem1 == 0) {
                if (randomItem < 2) {
                    tile.setItem(new ForagingMineral(1, ForagingMineralType.QUARTZ));
                    //tile.changeWalkable();
                } else if (randomItem < 4) {
                    tile.setItem(new ForagingMineral(1, ForagingMineralType.EARTH_CRYSTAL));
                    //tile.changeWalkable();
                } else if (randomItem < 6) {
                    tile.setItem(new ForagingMineral(1, ForagingMineralType.FROZEN_TEAR));
                    //tile.changeWalkable();
                } else if (randomItem < 8) {
                    tile.setItem(new ForagingMineral(1, ForagingMineralType.FIRE_QUARTZ));
                    //tile.changeWalkable();
                } else if (randomItem < 10) {
                    tile.setItem(new ForagingMineral(1, ForagingMineralType.EMERALD));
                    //tile.changeWalkable();
                } else if (randomItem < 12) {
                    tile.setItem(new ForagingMineral(1, ForagingMineralType.AQUAMARINE));
                    //tile.changeWalkable();
                } else if (randomItem < 14) {
                    tile.setItem(new ForagingMineral(1, ForagingMineralType.RUBY));
                    //tile.changeWalkable();
                } else if (randomItem < 16) {
                    tile.setItem(new ForagingMineral(1, ForagingMineralType.AMETHYST));
                    //tile.changeWalkable();
                } else if (randomItem < 18) {
                    tile.setItem(new ForagingMineral(1, ForagingMineralType.TOPAZ));
                    //tile.changeWalkable();
                } else if (randomItem < 20) {
                    tile.setItem(new ForagingMineral(1, ForagingMineralType.JADE));
                    //tile.changeWalkable();
                } else if (randomItem < 21) {
                    tile.setItem(new ForagingMineral(1, ForagingMineralType.DIAMOND));
                    //tile.changeWalkable();
                } else if (randomItem < 22) {
                    tile.setItem(new ForagingMineral(1, ForagingMineralType.PRISMATIC_SHARED));
                    //tile.changeWalkable();
                } else if (randomItem < 32) {
                    tile.setItem(new ForagingMineral(1, ForagingMineralType.COPPER));
                    //tile.changeWalkable();
                } else if (randomItem < 37) {
                    tile.setItem(new ForagingMineral(1, ForagingMineralType.IRON));
                    //tile.changeWalkable();
                } else if (randomItem < 40) {
                    tile.setItem(new ForagingMineral(1, ForagingMineralType.GOLD));
                    //tile.changeWalkable();
                } else if (randomItem < 42) {
                    tile.setItem(new ForagingMineral(1, ForagingMineralType.IRIDIUM));
                    //tile.changeWalkable();
                } else if (randomItem < 47) {
                    tile.setItem(new ForagingMineral(1, ForagingMineralType.COAL));
                    //tile.changeWalkable();
                } else if (randomItem < 67) {
                    tile.setItem(new ForagingMineral(1, ForagingMineralType.STONE));
                    //tile.changeWalkable();
                }
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

    public void render(SpriteBatch batch) {
        batch.draw(this.texture, x * 32, (60 - y) * 32, 32, 32);
    }
}
