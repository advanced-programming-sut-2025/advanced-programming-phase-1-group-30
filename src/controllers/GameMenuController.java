package controllers;

import models.App;
import models.Items.Item;
import models.Items.Products.ForgingSeed;
import models.Items.Tools.Tool;
import models.Maps.Map;
import models.Maps.PathFinder;
import models.Maps.Tile;
import models.Players.Player;
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
                GameMenu.printResult("Destination blocked. Moving to nearest reachable tile.");
            } else {
                GameMenu.printResult("No path found to destination or any nearby tile.");
                return;
            }
        }

        if (path.isEmpty()) {
            GameMenu.printResult("Are you NUTS??");
            return;
        }
        player.setX(path.getLast().getX());
        player.setY(path.getLast().getY());
        player.setEnergy(player.getEnergy() - (path.size() / 20));
        System.out.println(path.size());
        if (player.getEnergy() <= 0) {
            player.setPassedOut(true);
            GameMenu.printResult("Player passed out!");
        }
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

    public static void energyShow() {
        if (App.getCurrentGame().getCurrentPlayer().getEnergy() > 8000) {
            GameMenu.printResult("=== Cheat code activated: UNLIMITED ENERGY! ===");
        } else
            GameMenu.printResult("=== Player Energy: " + App.getCurrentGame().getCurrentPlayer().getEnergy() + " ===");
    }
    public static void cheatEnergySet(String value) {
        App.getCurrentGame().getCurrentPlayer().setEnergy(Integer.parseInt(value));
        GameMenu.printResult("=== Player energy set to: " + value + " ===");
    }
    public static void cheatUnlimitedEnergySet() {
        App.getCurrentGame().getCurrentPlayer().setEnergy(9999);
        GameMenu.printResult("=== Cheat code activated: UNLIMITED ENERGY! ===");
    }
    public static void inventoryShow() {
        for (Item item : App.getCurrentGame().getCurrentPlayer().getBackPack().getItems()) {
            GameMenu.printResult(item.getName() + " : " + item.getCount());
        }
        if (App.getCurrentGame().getCurrentPlayer().getBackPack().getItems().isEmpty()) {
            GameMenu.printResult("No Item is your backpack!");
        }
    }
    public static void inventoryTrash(String name, String number) {
        Item item = Item.findItemByName(name);
        if (item == null) {
            GameMenu.printResult("No item with this name found in your backpack");
            return;
        }

        if (number != null) {
            int numberInt = Integer.parseInt(number);

            if (item.getCount() <= numberInt) {
                App.getCurrentGame().getCurrentPlayer().getBackPack().removeItem(item);
                GameMenu.printResult(item.getName() + " successfully removed from your backpack");
            }
            else {
                item.changeCount(-1 * numberInt);
                GameMenu.printResult(numberInt + " numbers of " + item.getName() + " successfully removed from your backpack");
            }
            
        }
        else {
            App.getCurrentGame().getCurrentPlayer().getBackPack().removeItem(item);
            GameMenu.printResult(item.getName() + " successfully removed from your backpack");
        }
    }
    public static void ToolsEquip(String name) {
        for(Item items: App.getCurrentGame().getCurrentPlayer().getBackPack().getItems()){
            if(items.getName().equals(name)){
                App.getCurrentGame().getCurrentPlayer().setWield(items);
                GameMenu.printResult("You equipped " + name + ". It's now ready to use.");
                return;
            }
        }
        GameMenu.printResult("Oops!" + name + "'s not in your inventory.");
        return;
    }
    public static void ShowCurrentTool() {
        if(App.getCurrentGame().getCurrentPlayer().getWield() instanceof Tool){
            GameMenu.printResult(App.getCurrentGame().getCurrentPlayer().getWield().getName());
        } else{
            GameMenu.printResult("you're not wielding a tool.");
        }
    }
    public static void ShowAvailableTools() {
        for(Item items : App.getCurrentGame().getCurrentPlayer().getBackPack().getItems()){
            if(items instanceof Tool){
                GameMenu.printResult(items.getName());
            }
        }
    }
    public static void upgradeTools(String name) {}
    public static void toolUse(String direction) {}
    public static void craftInfo(String name) {}
    public static void plant(String seed1, String direction) { // TODO shokhm zade shode barresi beshe
        ForgingSeed seed = (ForgingSeed) ForgingSeed.findItemByName(seed1);
        Player player = App.getCurrentGame().getCurrentPlayer();
        Tile[][] tiles = App.getMaps().get(player.getSelectionNumber()  - 1).getTiles();

        int x = player.getX();
        int y = player.getY();
        int dx = 0, dy = 0;

        switch (direction) {
            case "w": dy = -1; break;      // up
            case "s": dy = 1; break;       // down
            case "a": dx = -1; break;      // left
            case "d": dx = 1; break;       // right
            case "Q": dx = -1; dy = -1; break; // up-left
            case "E": dx = 1; dy = -1; break;  // up-right
            case "Z": dx = -1; dy = 1; break;  // down-left
            case "C": dx = 1; dy = 1; break;   // down-right
            default:
                GameMenu.printResult("Invalid direction!");
                return;
        }

        int newX = x + dx;
        int newY = y + dy;

        // Bounds check
        if (newX < 0 || newX >= tiles.length || newY < 0 || newY >= tiles[0].length) {
            GameMenu.printResult("Out of bounds!");
            return;
        }

        Tile targetTile = tiles[newX][newY];
        Item item = Item.findItemByName(seed1);
        if (item == null) {
            GameMenu.printResult("No item with this name found in your backpack!");
            return;
        }
        if (item.getCount() > 0) {
            if (targetTile.isHarvestable() && targetTile.getItem() == null) {
                targetTile.setItem(seed);
                item.setCount(item.getCount() - 1);
                targetTile.setPlanted(true);
                if (item.getCount() == 0) {
                    player.getBackPack().getItems().remove(item);
                }
                GameMenu.printResult("Planted " + seed.getName() + " at (" + newX + ", " + newY + ")");
            } else {
                GameMenu.printResult("Tile is not farmable!");
            }
        } else {
            GameMenu.printResult("No item with this name found in your backpack!");
            return;
        }

    }


    public static void showPlant(String x, String y) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        Tile[][] tiles = App.getMaps().get(player.getSelectionNumber()  - 1).getTiles();
        if (tiles[player.getX()][player.getY()].isPlanted()) {
            Tile targetTile = tiles[player.getX()][player.getY()];
            Item item = targetTile.getItem();
            // TODO kood and How much time remainig and is watered or not
        }
    }
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
