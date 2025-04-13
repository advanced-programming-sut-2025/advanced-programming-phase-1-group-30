package models;

import java.util.ArrayList;

public class Tile {
    private TIleTypes type;
    private final ArrayList<Tile> neighborTiles = new ArrayList<>();
    private Item item;

    public Tile(TIleTypes type, Item item) {
        this.type = type;
        this.item = item;
    }
    
    public TIleTypes getType() {
        return type;
    }
    public void setType(TIleTypes type) {
        this.type = type;
    }
    public ArrayList<Tile> getNeighborTiles() {
        return neighborTiles;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
}
