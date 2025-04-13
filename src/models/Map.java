package models;

import models.Buildings.Buildings;

import java.util.ArrayList;

public class Map {
    private final ArrayList<Tile> tiles = new ArrayList<>();
    private final ArrayList<Buildings> buildings = new ArrayList<>();
    
    public Map() {
    }
    
    public ArrayList<Tile> getTiles() {
        return tiles;
    }
    public ArrayList<Buildings> getBuildings() {
        return buildings;
    }
}
