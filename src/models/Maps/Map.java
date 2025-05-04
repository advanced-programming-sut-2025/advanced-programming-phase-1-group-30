package models.Maps;

import models.App;
import models.Buildings.Buildings;

import models.Items.Products.Stone;
import models.Items.Products.Tree;
import org.json.JSONArray;
import org.json.JSONObject;
import views.GameMenu;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class Map {
    // Constants
    public static final String RESET = "\u001B[0m";

    public static final String LIGHT_YELLOW = "\u001B[93m"; // Light Yellow for Dirt
    public static final String DARK_GREEN = "\u001B[32m";   // Dark Green for Greenhouse
    public static final String BLUE = "\u001B[34m";         // Blue for Water and Hut
    public static final String GRAY = "\u001B[90m";         // Gray for Quarry
    public static final String GREEN = "\u001B[92m";        // Regular Green for Grass
    public static final String RED = "\u001B[31m";          // Red for unknown

    private final int id;
    private final Tile[][]  tiles = new Tile[80][60];
    private final ArrayList<Buildings> buildings = new ArrayList<>();
    public static void loadMap(Map mapInstance) {
        try {
            InputStream inputStream = Map.class.getClassLoader().getResourceAsStream("map.json");
            if (inputStream == null) {
                throw new FileNotFoundException("map.json not found in resources!");
            }
            String content = new String(inputStream.readAllBytes());

            JSONObject json = new JSONObject(content);

            int width = json.getInt("width");
            int height = json.getInt("height");
            JSONArray tilesArray = json.getJSONArray("tiles");

            for (int y = 0; y < height; y++) {
                JSONArray row = tilesArray.getJSONArray(y);
                for (int x = 0; x < width; x++) {
                    String tileType = row.getString(x);

                    // You need to create the right Tile object based on the type
                    mapInstance.tiles[x][y] = Tile.createTileFromType(x, y, tileType);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Map(int id) {
        this.id = id;
        loadMap(this);
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
    public void printMap() {
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 80; j++) {
                if (tiles[j][i].getType().equals(TileTypes.DIRT)) {
                    System.out.print(LIGHT_YELLOW + "D " + RESET);
                } else if (tiles[j][i].getType().equals(TileTypes.GRASS)) {
                    System.out.print(GREEN + "G " + RESET);
                } else if (tiles[j][i].getType().equals(TileTypes.WATER)) {
                    System.out.print(BLUE + "W " + RESET);
                } else if (tiles[j][i].getType().equals(TileTypes.HUT)) {
                    System.out.print(BLUE + "H " + RESET);
                } else if (tiles[j][i].getType().equals(TileTypes.QUARRY)) {
                    System.out.print(GRAY + "Q " + RESET);
                } else if (tiles[j][i].getType().equals(TileTypes.GREENHOUSE)) {
                    System.out.print(DARK_GREEN + "X " + RESET);
                } else {
                    System.out.print(RED + "X " + RESET);
                }
            }
            System.out.println();
        }
    }
    public void printPartOfMap(int x, int y, int size) {
        if (size >= (80 - x) || size > (60 - y)) {
            GameMenu.printResult("Can not print this part of the Map!");
        } else {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if (tiles[j][i].getType().equals(TileTypes.DIRT)) {
                        if (tiles[j][i].getItem() != null) {
                            if (tiles[j][i].getItem().getClass().equals(Stone.class)) {
                                System.out.print("S ");
                            } else if (tiles[j][i].getItem().getClass().equals(Tree.class)) {
                                System.out.print("T ");
                            }
                        } else {
                            if (App.getCurrentGame().getCurrentPlayer().getX() == j && App.getCurrentGame().getCurrentPlayer().getY() == i) {
                                System.out.print("P ");
                            } else
                                System.out.print(LIGHT_YELLOW + "D " + RESET);
                        }
                    } else if (tiles[j][i].getType().equals(TileTypes.GRASS)) {
                        if (tiles[j][i].getItem() != null) {
                            if (tiles[j][i].getItem().getClass().equals(Stone.class)) {
                                System.out.print("S ");
                            } else if (tiles[j][i].getItem().getClass().equals(Tree.class)) {
                                System.out.print("T ");
                            }
                        } else {
                            if (App.getCurrentGame().getCurrentPlayer().getX() == j && App.getCurrentGame().getCurrentPlayer().getY() == i) {
                                System.out.print("P ");
                            } else
                                System.out.print(GREEN + "G " + RESET);
                        }
                    } else if (tiles[j][i].getType().equals(TileTypes.WATER)) {
                        if (App.getCurrentGame().getCurrentPlayer().getX() == j && App.getCurrentGame().getCurrentPlayer().getY() == i) {
                            System.out.print("P ");
                        } else
                            System.out.print(BLUE + "W " + RESET);
                    } else if (tiles[j][i].getType().equals(TileTypes.HUT)) {
                        if (App.getCurrentGame().getCurrentPlayer().getX() == j && App.getCurrentGame().getCurrentPlayer().getY() == i) {
                            System.out.print("P ");
                        } else
                            System.out.print(BLUE + "H " + RESET);
                    } else if (tiles[j][i].getType().equals(TileTypes.QUARRY)) {
                        if (App.getCurrentGame().getCurrentPlayer().getX() == j && App.getCurrentGame().getCurrentPlayer().getY() == i) {
                            System.out.print("P ");
                        } else
                            System.out.print(GRAY + "Q " + RESET);
                    } else if (tiles[j][i].getType().equals(TileTypes.GREENHOUSE)) {
                        if (App.getCurrentGame().getCurrentPlayer().getX() == j && App.getCurrentGame().getCurrentPlayer().getY() == i) {
                            System.out.print("P ");
                        } else
                            System.out.print(DARK_GREEN + "X " + RESET);
                    } else {
                        if (App.getCurrentGame().getCurrentPlayer().getX() == j && App.getCurrentGame().getCurrentPlayer().getY() == i) {
                            System.out.print("P ");
                        } else
                            System.out.print(RED + "X " + RESET);
                    }
                }
                System.out.println();
            }
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}