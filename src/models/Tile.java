package models;

import java.util.ArrayList;

public class Tile {
    private TIleTypes type;
    private final ArrayList<Tile> neighborTiles = new ArrayList<>();
    private Item item;
}
