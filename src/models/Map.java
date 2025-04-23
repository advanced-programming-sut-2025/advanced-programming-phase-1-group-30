package models;

import models.Buildings.Buildings;
import models.enums.TIleTypes;

import java.util.ArrayList;

public class Map {
    private final int id;
    private final Tile[][]  tiles = new Tile[80][60];
    private final ArrayList<Buildings> buildings = new ArrayList<>();
    
    public Map(int id) {
        this.id = id;
        for (int i = 0; i < 80; i++) {
            for (int j = 0; j < 60; j++) {
                Tile tile = new Tile(i, j);
                tiles[i][j] = tile;
            }
        }
        // Quarry tiles
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 9; j++) {
                tiles[i][j].setType(TIleTypes.QUARRY);
            }
        }
        // GreenHouse tiles
        for (int i = 24; i < 30; i++) {
            for (int j = 2; j < 9; j++) {
                tiles[i][j].setType(TIleTypes.BUILDING);
            }
        }
        // Hut
        for (int i = 64; i < 72; i++) {
            for (int j = 5; j < 12; j++) {
                tiles[i][j].setType(TIleTypes.BUILDING);
            }
        }
        // Little lake
        for (int i = 73; i < 79; i++) {
            for (int j = 30; j < 38; j++) {
                tiles[i][j].setType(TIleTypes.WATER);
            }
        }
        // Big lake
        for (int i = 35; i < 45; i++) {
            for (int j = 47; j < 56; j++) {
                tiles[i][j].setType(TIleTypes.WATER);
            }
        }
        for (int i = 0; i < 80; i++) {
            for (int j = 0; j < 60; j++) {
                if (tiles[i][j].getType() == TIleTypes.DIRT) {
                    tiles[i][j].setItem(null);
                }
            }
        }
    }

    public ArrayList<Buildings> getBuildings() {
        return buildings;
    }

    public static Map getMapById(int id) {
        for (Map map : App.getMaps()) {
            if (id == map.id) return map;
        }

        return null;
    }
}
