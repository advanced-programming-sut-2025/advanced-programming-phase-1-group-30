package models.Maps;

import models.Animals.*;
import models.App;
import models.Buildings.Barn;
import models.Buildings.Building;
import models.Buildings.Coop;
import models.Buildings.GreenHouse;
import models.Items.Products.Stone;
import models.Items.Products.Tree;
import models.Players.Player;
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
    public static final String BLACK = "\u001B[30m";
    public static final String DARK_RED = "\u001B[31m";
    public static final String DARK_YELLOW = "\u001B[33m"; 
    public static final String DARK_BLUE = "\u001B[34m";    
    public static final String DARK_PURPLE = "\u001B[35m";    
    public static final String DARK_CYAN = "\u001B[36m";    
    public static final String LIGHT_GRAY = "\u001B[37m";
    public static final String BRIGHT_RED = "\u001B[91m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String BRIGHT_YELLOW = "\u001B[93m"; 
    public static final String BRIGHT_BLUE = "\u001B[94m";
    public static final String BRIGHT_PURPLE = "\u001B[95m"; 
    public static final String BRIGHT_CYAN = "\u001B[96m"; 
    public static final String WHITE = "\u001B[97m";

    private final int id;
    private final Tile[][]  tiles = new Tile[80][60];
    private final ArrayList<Building> buildings = new ArrayList<>();
    private boolean hasScareCrow = false;
    private final ArrayList<Barn> barns = new ArrayList<>();
    private final ArrayList<Coop> coops = new ArrayList<>();
    private GreenHouse greenHouse = null;

    public static void loadMap(Map mapInstance, int id) {
        try {
            InputStream inputStream;
            if(id == -1){
                inputStream = Map.class.getResourceAsStream("/resources/mapCity.json");;
            } else if (id == 2) {
                inputStream = Map.class.getResourceAsStream("/resources/map.json");
            } else if (id == 3) {
                inputStream = Map.class.getResourceAsStream("/resources/map(1).json");
            } else {
                inputStream = Map.class.getResourceAsStream("/resources/map(2).json");
            }
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
                    mapInstance.tiles[x][y] = Tile.createTileFromType(x, y, tileType, id);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map(int id) {
        this.id = id;
        loadMap(this, id);
    }

    public ArrayList<Building> getBuildings() {
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
                    System.out.print(LIGHT_YELLOW + "\u2B1B " + RESET);
                } else if (tiles[j][i].getType().equals(TileTypes.GRASS)) {
                    System.out.print(GREEN + "\u1F7E9" + RESET);
                } else if (tiles[j][i].getType().equals(TileTypes.WATER)) {
                    System.out.print(BLUE + "\u1F7E6" + RESET);
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
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (size >= (80 - x) || size > (60 - y)) {
            GameMenu.printResult("Can not print this part of the Map!");
        } else {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if (tiles[j][i].getType().equals(TileTypes.DIRT)) {
                        if (tiles[j][i].getItem() != null) {
                            if (tiles[j][i].getItem().getClass().equals(Stone.class)) {
                                System.out.print("\uD83E\uDEA8");
                            } else if (tiles[j][i].getItem().getClass().equals(Tree.class)) {
                                System.out.print("\uD83C\uDF33");
                            }
                        } else {
                            if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                                System.out.print(RED + "\uD83D\uDE00" + RESET);
                            } else
                                System.out.print("\uD83D\uDFE8");
                        }
                    } else if (tiles[j][i].getType().equals(TileTypes.GRASS)) {
                        if (tiles[j][i].getItem() != null) {
                            if (tiles[j][i].getItem().getClass().equals(Stone.class)) {
                                System.out.print("\uD83E\uDEA8");
                            } else if (tiles[j][i].getItem().getClass().equals(Tree.class)) {
                                System.out.print("\uD83C\uDF33");
                            }
                        } else {
                            if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                                System.out.print(RED + "\uD83D\uDE00" + RESET);
                            } else{
                                System.out.print("\uD83D\uDFE9");
                            }
                        }
                    } else if (tiles[j][i].getType().equals(TileTypes.WATER)) {
                        if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                            System.out.print(RED + "\uD83D\uDE00" + RESET);
                        } else
                            System.out.print("\uD83D\uDFE6");
                    } else if (tiles[j][i].getType().equals(TileTypes.HUT)) {
                        if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                            System.out.print(RED + "\uD83C\uDFE0" + RESET);
                        } else
                            System.out.print("\uD83C\uDFE0");
                    } else if (tiles[j][i].getType().equals(TileTypes.QUARRY)) {
                        if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                            System.out.print(RED + "\uD83D\uDE00" + RESET);
                        } else
                            System.out.print("\uD83D\uDFEB");
                    } else if (tiles[j][i].getType().equals(TileTypes.GREENHOUSE)) {
                        if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                            System.out.print(RED + "\uD83D\uDE00" + RESET);
                        } else
                            System.out.print("\uD83D\uDFEA");
                    }else if (tiles[j][i].getType().equals(TileTypes.BLACKSMITH)) {
                        if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                            System.out.print(RED + "\uD83D\uDE00" + RESET);
                        } else
                            System.out.print(DARK_BLUE + "⬛" + RESET);
                    }else if (tiles[j][i].getType().equals(TileTypes.FISH_SHOP)) {
                        if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                            System.out.print(RED + "\uD83D\uDE00" + RESET);
                        } else
                            System.out.print(DARK_YELLOW + "⬛" + RESET);
                    }else if (tiles[j][i].getType().equals(TileTypes.CARPENTERS_SHOP)) {
                        if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                            System.out.print(RED + "\uD83D\uDE00" + RESET);
                        } else
                            System.out.print(BRIGHT_CYAN + "⬛" + RESET);
                    }else if (tiles[j][i].getType().equals(TileTypes.JOJOMART)) {
                        if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                            System.out.print(RED + "\uD83D\uDE00" + RESET);
                        } else
                            System.out.print(BRIGHT_PURPLE + "⬛" + RESET);
                    }else if (tiles[j][i].getType().equals(TileTypes.MARINES_RANCH)) {
                        if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                            System.out.print(RED + "\uD83D\uDE00" + RESET);
                        } else
                            System.out.print(BRIGHT_GREEN + "⬛" + RESET);
                    }else if (tiles[j][i].getType().equals(TileTypes.PIERRES_GENERAL_STORE)) {
                        if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                            System.out.print(RED + "\uD83D\uDE00" + RESET);
                        } else
                            System.out.print(BRIGHT_RED + "⬛" + RESET);
                    }else if (tiles[j][i].getType().equals(TileTypes.THE_STARDROP_SALOON)) {
                        if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                            System.out.print(RED + "\uD83D\uDE00" + RESET);
                        } else
                            System.out.print(DARK_GREEN + "⬛" + RESET);
                    } else if (tiles[j][i].getType().equals(TileTypes.BARN)) {
                        if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                            System.out.print(RED + "\uD83D\uDE00" + RESET);
                            for (Animal animal : player.getAnimals()) {
                                if (animal.getX() == j && animal.getY() == i) {
                                    if (animal instanceof Sheep) {
                                        System.out.print("\uD83D\uDC11 ");
                                    } else if (animal instanceof Cow) {
                                        System.out.print("\uD83D\uDC04 ");
                                    } else {
                                        System.out.println("A ");
                                    }
                                }
                            }
                        } else
                            System.out.print(BRIGHT_BLUE + "⬛" + RESET);
                    } else if (tiles[j][i].getType().equals(TileTypes.COOP)) {
                        if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                            System.out.print(RED + "\uD83D\uDE00" + RESET);
                        } else {
                            int v = 0;
                            for (Animal animal : player.getAnimals()) {
                                if (animal.getX() == j && animal.getY() == i) {
                                    if (animal instanceof Chicken) {
                                        System.out.print("\uD83D\uDC14");
                                    } else if (animal instanceof Duck) {
                                        System.out.print("\uD83D\uDC04 ");
                                    } else {
                                        System.out.println("A ");
                                    }
                                    v = 1;
                                }
                            }

                            if (v == 0) {
                                System.out.print(LIGHT_GRAY + "⬛" + RESET);
                            }
                        }
                    } else {
                        if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                            System.out.print(RED + "\uD83D\uDE00" + RESET);
                        } else
                            System.out.print(RED + "⬛" + RESET);
                    }
                }
                System.out.println();
            }
        }
    }

    public void printCitysMap() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 80; j++) {
                boolean printed = false;
                for (Player player1 : App.getCurrentGame().getPlayers()) {
                    if (player1.getCityX() == i && player1.getCityY() == j) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                        printed = true;
                        break;
                    }
                }
                if (printed) {
                    continue;
                }
                if (tiles[j][i].getType().equals(TileTypes.DIRT)) {
                    if (tiles[j][i].getItem() != null) {
                        if (tiles[j][i].getItem().getClass().equals(Stone.class)) {
                            System.out.print("\uD83E\uDEA8");
                        } else if (tiles[j][i].getItem().getClass().equals(Tree.class)) {
                            System.out.print("\uD83C\uDF33");
                        }
                    } else {
                        if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                            System.out.print(RED + "\uD83D\uDE00" + RESET);
                        } else
                            System.out.print("\uD83D\uDFE8");
                    }
                } else if (tiles[j][i].getType().equals(TileTypes.GRASS)) {
                    if (tiles[j][i].getItem() != null) {
                        if (tiles[j][i].getItem().getClass().equals(Stone.class)) {
                            System.out.print("\uD83E\uDEA8");
                        } else if (tiles[j][i].getItem().getClass().equals(Tree.class)) {
                            System.out.print("\uD83C\uDF33");
                        }
                    } else {
                        if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                            System.out.print(RED + "\uD83D\uDE00" + RESET);
                        } else{
                            System.out.print("\uD83D\uDFE9");
                        }
                    }
                } else if (tiles[j][i].getType().equals(TileTypes.WATER)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print("\uD83D\uDFE6");
                } else if (tiles[j][i].getType().equals(TileTypes.HUT)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83C\uDFE0" + RESET);
                    } else
                        System.out.print("\uD83C\uDFDA\uFE0F");
                } else if (tiles[j][i].getType().equals(TileTypes.QUARRY)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print("\uD83D\uDFEB");
                } else if (tiles[j][i].getType().equals(TileTypes.GREENHOUSE)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print("\uD83D\uDFEA");
                }else if (tiles[j][i].getType().equals(TileTypes.BLACKSMITH)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print(DARK_BLUE + "⬛" + RESET);
                }else if (tiles[j][i].getType().equals(TileTypes.FISH_SHOP)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print(DARK_YELLOW + "⬛" + RESET);
                }else if (tiles[j][i].getType().equals(TileTypes.CARPENTERS_SHOP)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print(BRIGHT_CYAN + "⬛" + RESET);
                }else if (tiles[j][i].getType().equals(TileTypes.JOJOMART)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print(BRIGHT_PURPLE + "⬛" + RESET);
                }else if (tiles[j][i].getType().equals(TileTypes.MARINES_RANCH)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print(BRIGHT_GREEN + "⬛" + RESET);
                }else if (tiles[j][i].getType().equals(TileTypes.PIERRES_GENERAL_STORE)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print(BRIGHT_RED + "⬛" + RESET);
                }else if (tiles[j][i].getType().equals(TileTypes.THE_STARDROP_SALOON)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print(DARK_GREEN + "⬛" + RESET);
                } else if (tiles[j][i].getType().equals(TileTypes.BARN)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                        for (Animal animal : player.getAnimals()) {
                            if (animal.getX() == j && animal.getY() == i) {
                                if (animal instanceof Sheep) {
                                    System.out.print("\uD83D\uDC11 ");
                                } else if (animal instanceof Cow) {
                                    System.out.print("\uD83D\uDC04 ");
                                } else {
                                    System.out.println("A ");
                                }
                            }
                        }
                    } else
                        System.out.print(BRIGHT_BLUE + "⬛" + RESET);
                } else if (tiles[j][i].getType().equals(TileTypes.COOP)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else {
                        int v = 0;
                        for (Animal animal : player.getAnimals()) {
                            if (animal.getX() == j && animal.getY() == i) {
                                if (animal instanceof Chicken) {
                                    System.out.print("\uD83D\uDC14");
                                } else if (animal instanceof Duck) {
                                    System.out.print("\uD83D\uDC04 ");
                                } else {
                                    System.out.println("A ");
                                }
                                v = 1;
                            }
                        }

                        if (v == 0) {
                            System.out.print(LIGHT_GRAY + "⬛" + RESET);
                        }
                    }
                } else {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print(RED + "⬛" + RESET);
                }
            }
            System.out.println();
        }
    }
    public void printFullMap() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 80; j++) {
                if (tiles[j][i].getType().equals(TileTypes.DIRT)) {
                    if (tiles[j][i].getItem() != null) {
                        if (tiles[j][i].getItem().getClass().equals(Stone.class)) {
                            System.out.print("\uD83E\uDEA8");
                        } else if (tiles[j][i].getItem().getClass().equals(Tree.class)) {
                            System.out.print("\uD83C\uDF33");
                        }
                    } else {
                        if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                            System.out.print(RED + "\uD83D\uDE00" + RESET);
                        } else
                            System.out.print("\uD83D\uDFE8");
                    }
                } else if (tiles[j][i].getType().equals(TileTypes.GRASS)) {
                    if (tiles[j][i].getItem() != null) {
                        if (tiles[j][i].getItem().getClass().equals(Stone.class)) {
                            System.out.print("\uD83E\uDEA8");
                        } else if (tiles[j][i].getItem().getClass().equals(Tree.class)) {
                            System.out.print("\uD83C\uDF33");
                        }
                    } else {
                        if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                            System.out.print(RED + "\uD83D\uDE00" + RESET);
                        } else{
                            System.out.print("\uD83D\uDFE9");
                        }
                    }
                } else if (tiles[j][i].getType().equals(TileTypes.WATER)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print("\uD83D\uDFE6");
                } else if (tiles[j][i].getType().equals(TileTypes.HUT)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83C\uDFE0" + RESET);
                    } else
                        System.out.print("\uD83C\uDFDA\uFE0F");
                } else if (tiles[j][i].getType().equals(TileTypes.QUARRY)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print("\uD83D\uDFEB");
                } else if (tiles[j][i].getType().equals(TileTypes.GREENHOUSE)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print("\uD83D\uDFEA");
                }else if (tiles[j][i].getType().equals(TileTypes.BLACKSMITH)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print(DARK_BLUE + "⬛" + RESET);
                }else if (tiles[j][i].getType().equals(TileTypes.FISH_SHOP)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print(DARK_YELLOW + "⬛" + RESET);
                }else if (tiles[j][i].getType().equals(TileTypes.CARPENTERS_SHOP)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print(BRIGHT_CYAN + "⬛" + RESET);
                }else if (tiles[j][i].getType().equals(TileTypes.JOJOMART)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print(BRIGHT_PURPLE + "⬛" + RESET);
                }else if (tiles[j][i].getType().equals(TileTypes.MARINES_RANCH)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print(BRIGHT_GREEN + "⬛" + RESET);
                }else if (tiles[j][i].getType().equals(TileTypes.PIERRES_GENERAL_STORE)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print(BRIGHT_RED + "⬛" + RESET);
                }else if (tiles[j][i].getType().equals(TileTypes.THE_STARDROP_SALOON)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print(DARK_GREEN + "⬛" + RESET);
                } else if (tiles[j][i].getType().equals(TileTypes.BARN)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                        for (Animal animal : player.getAnimals()) {
                            if (animal.getX() == j && animal.getY() == i) {
                                if (animal instanceof Sheep) {
                                    System.out.print("\uD83D\uDC11 ");
                                } else if (animal instanceof Cow) {
                                    System.out.print("\uD83D\uDC04 ");
                                } else {
                                    System.out.println("A ");
                                }
                            }
                        }
                    } else
                        System.out.print(BRIGHT_BLUE + "⬛" + RESET);
                } else if (tiles[j][i].getType().equals(TileTypes.COOP)) {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else {
                        int v = 0;
                        for (Animal animal : player.getAnimals()) {
                            if (animal.getX() == j && animal.getY() == i) {
                                if (animal instanceof Chicken) {
                                    System.out.print("\uD83D\uDC14");
                                } else if (animal instanceof Duck) {
                                    System.out.print("\uD83D\uDC04 ");
                                } else {
                                    System.out.println("A ");
                                }
                                v = 1;
                            }
                        }

                        if (v == 0) {
                            System.out.print(LIGHT_GRAY + "⬛" + RESET);
                        }
                    }
                } else {
                    if (player.getX() == j && player.getY() == i && ((player.isInCity() && this.id == -1) || (!player.isInCity() && this.id != -1))) {
                        System.out.print(RED + "\uD83D\uDE00" + RESET);
                    } else
                        System.out.print(RED + "⬛" + RESET);
                }
            }
            System.out.println();
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public boolean hasScareCrow() {
        return hasScareCrow;
    }
    public void changeHasScareCrow() {
        this.hasScareCrow = !this.hasScareCrow;
    }

    public ArrayList<Coop> getCoops() {
        return coops;
    }

    public ArrayList<Barn> getBarns() {
        return barns;
    }

    public GreenHouse getGreenHouse() {
        return greenHouse;
    }
    public void createGreenHouse() {
        this.greenHouse = new GreenHouse();
    }
}