package controllers;

import models.App;
import models.Map;
import models.PathFinder;
import models.Player;
import models.Tile;
import views.GameMenu;

import java.util.*;

public class GameMenuController {
    public static void greenHouseBuild() {}
    public static void walk(String xStr, String yStr) {
        int x = Integer.parseInt(xStr);
        int y = Integer.parseInt(yStr);

        Tile[][] map = App.getMaps().get(App.getCurrentGame().getCurrentPlayer().getSelectionNumber() - 1).getTiles();
        Player player = App.getCurrentGame().getCurrentPlayer();
        Tile start = map[player.getX()][player.getY()];
        Tile target = map[x][y];

        List<Tile> path = PathFinder.findPath(map, start, target);

        if (path == null) {
            Tile alt = PathFinder.findNearestReachable(map, start, target);
            if (alt != null) {
                path = PathFinder.findPath(map, start, alt);
                System.out.println("Destination blocked. Moving to nearest reachable tile.");
            } else {
                System.out.println("No path found to destination or any nearby tile.");
                return;
            }
        }

        // You write this method to update player pos
        player.setX(path.getLast().getX());
        player.setY(path.getLast().getY());
    }

    public static void printMap(String x, String y, String size) {
        int X = Integer.parseInt(x);
        int Y = Integer.parseInt(y);
        int Size = Integer.parseInt(size);
        App.getMaps().get(0).printPartOfMap(X, Y, Size);
    }
    public static void helpReadingMap() {
        GameMenu.printResult("=== Map Legend ===");
        GameMenu.printResult(Map.GREEN + "G -> Grass" + Map.RESET);
        GameMenu.printResult(Map.LIGHT_YELLOW + "D -> Dirt" + Map.RESET);
        GameMenu.printResult(Map.BLUE + "R -> River (not walkable)" + Map.RESET);
        GameMenu.printResult(Map.BLUE + "H -> Hut (not walkable)" + Map.RESET);
        GameMenu.printResult(Map.GRAY + "Q -> Quarry (not walkable)" + Map.RESET);
        GameMenu.printResult(Map.DARK_GREEN + "Q -> Greenhouse (not walkable)" + Map.RESET);
        GameMenu.printResult("P -> Player (not walkable)");
        GameMenu.printResult("==================");
    }

    public static void energyShow() {}
    public static void cheatEnergySet(String value) {}
    public static void cheatUnlimitedEnergySet() {}
    public static void inventoryShow() {}
    public static void inventoryTrash(String name, String number) {}
    public static void toolsEquip(String name) {}
    public static void showCurrentTool() {}
    public static void showAvailableTools() {}
    public static void upgradeTools(String name) {}
    public static void toolUse(String direction) {}
    public static void craftInfo(String name) {}
    public static void plant(String seed, String direction) {}
    public static void showPlant(String x, String y) {}
    public static void fertilize(String fetilizer, String direction) {}
    public static void howMuchWater() {}
    public static void showCraftingRecipes() {}
    public static void crafting(String name) {}
    public static void flaceItem(String name, String direction) {}
    public static void cheatAddItem(String name, String count) {}
    public static void putRefrigerator(String item) {}
    public static void pickRefrigerator(String item) {}
    public static void showCookingRecipe(){}
    public static void cooking(String name) {}
    public static void eat(String name) {}
    public static void build(String name, String x, String y){}
    public static void buyAnimal(String animal, String name) {}
    public static void pet(String name){}
    public static void cheatSetFriendship(String name, String amount) {}
    public static void animals() {}
    public static void shepherdAnimals(String name, String x, String y){}
    public static void feedHay(String name){}
    public static void produces(){}
    public static void collectProduce(String name){}
    public static void sellAnimal(String name){}
    public static void fishing(String fishingPole){}
    public static void artisanUse(String artisanName, String itemName) {}
    public static void artisanGet(String name) {}
    public static void showAllProducts() {}
    public static void showAvailableProducts() {}
    public static void purchase(String name, String amount){}
    public static void cheatAddMoney(String amount){}
    public static void sell(String name, String amount){}
    public static void friendship(){}
    public static void talk(String username, String message){}
    public static void talkHistory(String username){}
    public static void gift(String Username, String item, String amount){}
    public static void giftList(){}
    public static void giftRate(String giftNumber, String rate){}
    public static void giftHistory(String username){}
    public static void hug(String username){}
    public static void flower(String username){}
    public static void askMarriage(String username, String ring){}
    public static void respond(String username){}
    public static void startTrade() {}
    public static void trade(String username, String type, String item, String amount, String price){}
    public static void tradeProducts(String username, String type, String item, String amount, String targetItem, String targetAmount){}
    public static void tradeList(){}
    public static void tradeResponse(String id){}
    public static void tradeHistory(){}
    public static void meetNPC(String name) {}
    public static void giftNPC(String name, String item) {}
    public static void friendshipNPCList() {}
    public static void questList() {}
    public static void questFinish(String index) {}
    public static void passOut() {}
}
