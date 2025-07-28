package AP.group30.StardewValley.controllers;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.models.Animals.*;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Buildings.*;
//import AP.group30.StardewValley.models.Commands.Menus;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Inventory.BackPackType;
import AP.group30.StardewValley.models.Items.Gift;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.Products.*;
import AP.group30.StardewValley.models.Items.Products.ShopProducts.ShopProduct;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.ArtisanGoods.ArtisanGood;
import AP.group30.StardewValley.models.Items.ArtisanGoods.ArtisanGoodType;
import AP.group30.StardewValley.models.Items.ArtisanGoods.ArtisanItemProsses;
import AP.group30.StardewValley.models.Items.Foods.Food;
import AP.group30.StardewValley.models.Items.Foods.FoodType;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProductType;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProduct;
import AP.group30.StardewValley.models.Items.Tools.*;
import AP.group30.StardewValley.models.Maps.*;
import AP.group30.StardewValley.models.Maps.Map;
import AP.group30.StardewValley.models.Players.Direction;
import AP.group30.StardewValley.models.Players.Friendship;
import AP.group30.StardewValley.models.Players.NPC.NPC;
import AP.group30.StardewValley.models.TimeAndDate.Season;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.models.Players.Trade;
import AP.group30.StardewValley.models.Users.User;
import AP.group30.StardewValley.views.GameMenu;
import AP.group30.StardewValley.views.GameScreen;
import AP.group30.StardewValley.views.StartMenus.RegisterMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import java.util.*;
import java.util.List;

public class GameMenuController {
    public static String greenHouseBuild() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        Item wood = Item.findItemByName("wood", player.getBackPack().getItems());
        if (wood == null) {
            return "You need 50 woods!";
        }
        if (wood.getCount() < 500) {
            return "You need 50 woods!";
        }
        if (player.getMoney() < 1000) {
            return "You need 1000 golds!";
        }
        player.setMoney(player.getMoney() - 1000);
        wood.setCount(wood.getCount() - 500);
        App.getCurrentGame().getGreenHouse().buildGreenhouse();
        return "";
    }

    public static void walk(String xStr, String yStr, Scanner scanner) {
        int x = Integer.parseInt(xStr);
        int y = Integer.parseInt(yStr);
        Player player = App.getCurrentGame().getCurrentPlayer();
        Tile[][] map;
        Tile start;
        Tile target;
        if (player.isInCity()) {
            map = App.getMaps().get(4).getTiles();
            start = map[player.getCityX()][player.getCityY()];
            target = map[x][y];
        } else {
            map = App.getCurrentGame().getCurrentPlayer().getMap().getTiles();
            start = map[player.getX()][player.getY()];
            target = map[x][y];
        }

        List<Tile> path = PathFinder.findPath(map, start, target);
        if (path == null || path.isEmpty()) {
            Tile alt = PathFinder.findNearestReachable(map, start, target);
            if (alt != null) {
                path = PathFinder.findPath(map, start, alt);
                GameMenu.printResult("Destination blocked.");
            } else {
                GameMenu.printResult("No path found to destination or any nearby tile.");
                return;
            }
        }

        Tile current = start;
        int dx1 = 0, dy1 = 0;
        double energy = player.getEnergy();

        for (int i = 0; i < path.size(); i++) {
            Tile next = path.get(i);
            int dx2 = next.getX() - current.getX();
            int dy2 = next.getY() - current.getY();

            boolean isTurn = (i > 0) && (dx1 != dx2 || dy1 != dy2);
            double stepCost = isTurn ? 11 : 1;

            energy -= stepCost / 20;

            if (energy <= 0) {
                if (!player.isInCity()) {
                    player.setX(current.getX());
                    player.setY(current.getY());
                } else {
                    player.setCityX(current.getX());
                    player.setCityY(current.getY());
                }

                player.setEnergy(0);
                player.setPassedOut(true);
                GameMenu.printResult("Player passed out at (" + current.getX() + ", " + current.getY() + ")!");
                NewGameController.NextTurn(scanner);
                return;
            }

            // Move to next tile
            if (!player.isInCity()) {
                player.setX(next.getX());
                player.setY(next.getY());
            } else {
                player.setCityX(next.getX());
                player.setCityY(next.getY());
            }

            dx1 = dx2;
            dy1 = dy2;
            current = next;
        }
        if (player.isInCity()) {
            switch (map[player.getCityX()][player.getCityY()].getType()) {
                case JOJAMART -> player.setBuilding(App.getCurrentGame().getJojaMart());
                case FISH_SHOP -> player.setBuilding(App.getCurrentGame().getFishShop());
                case MARINES_RANCH -> player.setBuilding(App.getCurrentGame().getRanch());
                case BLACKSMITH -> player.setBuilding(App.getCurrentGame().getBlacksmith());
                case CARPENTERS_SHOP -> player.setBuilding(App.getCurrentGame().getCarpenter());
                case THE_STARDROP_SALOON -> player.setBuilding(App.getCurrentGame().getSaloon());
                case PIERRES_GENERAL_STORE -> player.setBuilding(App.getCurrentGame().getGeneralStore());
                default -> player.setBuilding(null);
            }
        }

        player.setEnergy((int)energy);
        GameMenu.printResult("You are at: " + current.getX() + " " + current.getY());
    }
    public static void printMap(String x, String y, String size) {
        int X = Integer.parseInt(x);
        int Y = Integer.parseInt(y);
        int Size = Integer.parseInt(size);
        App.getCurrentGame().getCurrentPlayer().getMap().printPartOfMap(X, Y, Size);
    }

    public static void helpReadingMap() {
        GameMenu.printResult("=== Map guide ===");
        GameMenu.printResult(Map.GREEN + "⬛ -> Grass" + Map.RESET);
        GameMenu.printResult(Map.LIGHT_YELLOW + "⬛ -> Dirt" + Map.RESET);
        GameMenu.printResult(Map.BLUE + "⬛ -> Water (not walkable)" + Map.RESET);
        GameMenu.printResult(Map.BLUE + "⬛ -> Hut (not walkable)" + Map.RESET);
        GameMenu.printResult(Map.GRAY + "⬛ -> Quarry (not walkable)" + Map.RESET);
        GameMenu.printResult(Map.DARK_GREEN + "⬛ -> Greenhouse (not walkable)" + Map.RESET);
        GameMenu.printResult(Map.RED + "\uD83D\uDE00 -> Player" + Map.RESET);
        GameMenu.printResult("==================");
    }
    public static void energyShow() {
        if (App.getCurrentGame().getCurrentPlayer().getEnergy() > 8000) {
            GameMenu.printResult("=== Player Energy: UNLIMITED ENERGY! ===");
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
        int counter = 1;
        for (Item item : App.getCurrentGame().getCurrentPlayer().getBackPack().getItems()) {
            GameMenu.printResult(counter++ + "- " + item.getName() + " : " + item.getCount());
        }
        if (App.getCurrentGame().getCurrentPlayer().getBackPack().getItems().isEmpty()) {
            GameMenu.printResult("No Item is your backpack!");
        }
    }

    public static void inventoryTrash(String name, String number) {
        Item item = Item.findItemByName(name, App.getCurrentGame().getCurrentPlayer().getBackPack().getItems());
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
            if(items.getName().toLowerCase().equals(name.toLowerCase())){
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

    public static boolean upgradeTools(String name, Label errorLabel) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if(player.isInCity()){
            Map citymap = App.getMaps().get(4);
            Item item = Item.findItemByName(name,player.getBackPack().getItems());
            if(item != null){
                if(item instanceof Tool) {
                    int price;
                    String need;
                    if (item.getName().contains("normal")) {
                        price = 2000;
                        need = "copper bar";
                    } else if (item.getName().contains("copper")) {
                        price = 5000;
                        need = "iron bar";
                    } else if (item.getName().contains("iron")) {
                        price = 10000;
                        need = "gold bar";
                    } else if (item.getName().contains("gold")) {
                        price = 25000;
                        need = "iridium bar";
                    } else {
                        GameMenu.printResult("Tool is not upgradable!");
                        errorLabel.setText("Tool is not upgradable!");
                        return false;
                    }
                    Item found = Item.findItemByName(need, player.getBackPack().getItems());
                    if(found == null){
                        GameMenu.printResult("You don't have the ingredient " + need + " in your backpack.");
                        errorLabel.setText("You don't have the ingredient " + need + " in your backpack.");
                        return false;
                    } else {
                        if(found.getCount() >= 5){
                            if(player.getMoney() >= price){
                                player.setMoney(player.getMoney() - price);
                                if(found.getCount() == 5){
                                    player.getBackPack().removeItem(found);
                                } else {
                                    found.setCount(found.getCount() - 5);
                                }

                                if(item instanceof Axe){
                                    player.getBackPack().getItems().remove(item);
                                    player.getBackPack().addItem(new Axe(1, Axe.getNextAxeType(((Axe) item).getType())));
                                } else if(item instanceof Pickaxe){
                                    player.getBackPack().getItems().remove(item);
                                    player.getBackPack().addItem(new Pickaxe(1, Pickaxe.getNextPickaxeType(((Pickaxe) item).getType())));
                                } else if(item instanceof Hoe){
                                    player.getBackPack().getItems().remove(item);
                                    player.getBackPack().addItem(new Hoe(1, Hoe.getNextHoeType(((Hoe) item).getType())));
                                } else if(item instanceof Basket){
                                    player.getBackPack().getItems().remove(item);
                                    player.getBackPack().addItem(new Basket(1, Basket.getNextBasketType(((Basket) item).getType())));
                                }
                                GameMenu.printResult("Your tool has been upgraded successfully!");
                                return true;
                            } else {
                                GameMenu.printResult("You need " + price + " gold to upgrade!");
                                errorLabel.setText("You need " + price + " gold to upgrade!");
                            }
                        } else {
                            GameMenu.printResult("You need 5 " + found.getName() + " in your backpack.");
                        }
                        return false;
                    }
                } else {
                    GameMenu.printResult("item has to be a tool.");
                    errorLabel.setText("item has to be a tool");
                    return false;
                }
            } else {
                GameMenu.printResult("You don't have " + item.getName() + " in your backpack.");
                errorLabel.setText("You don't have " + item.getName() + " in your backpack.");
                return false;
            }
        }
        return false;
    }
    public static void toolUse(Direction direction, int playerX, int playerY, SpriteBatch batch, Tile[][] tiles) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        Item wield = player.getWield();

        if(player.isInCity()){
            GameMenu.printResult("You can't use tools in city!");
            return;
        }


        int y;
        if(RegisterMenu.gameScreen.getGreenhouseScreen().isVisible()) {
            y = playerY / 32;
            switch (direction) {
                case NORTH:
                    y += 2;
                    break;
                case SOUTH:
                    y -= 2;
                    break;
            }
        } else {
            y = 60 - (playerY / 32);
        }
        int x = playerX / 32;
        int dx = 0, dy = 0;
        if (player.getWield() instanceof Axe) {
            switch (direction) {
                case NORTH:
                    dy = -1;
                    x = (playerX + 16) / 32;
                    break;
                case SOUTH:
                    dy = +2;
                    x = (playerX + 8) / 32;
                    break;
                case WEST:
                    dx = -1;
                    break;
                case EAST:
                    dx = 2;
                    break;
                default:
                    GameMenu.printResult("Invalid direction!");
                    return;
            }
        } else {
            switch (direction) {
                case NORTH:
                    dy = -1;
                    x = (playerX + 16) / 32;
                    break;
                case SOUTH:
                    dy = +1;
                    x = (playerX + 8) / 32;
                    break;
                case WEST:
                    dx = -1;
                    break;
                case EAST:
                    dx = 2;
                    break;
                default:
                    GameMenu.printResult("Invalid direction!");
                    return;
            }
        }

        int newX = x + dx;
        int newY = y + dy;

        if (newX < 0 || newX >= tiles.length || newY < 0 || newY >= tiles[0].length) {
            System.out.println(newX + " " + newY);
            GameMenu.printResult("Out of bounds!");
            return;
        }

        Tile targetTile = tiles[newX][newY];
        Tile targetTile2 = tiles[x][newY];
        double rate = 1;
        if(App.getCurrentGame().getCurrentWeather().equals(Weather.SUNNY)){
            rate = 2;
        } else if(App.getCurrentGame().getCurrentWeather().equals(Weather.RAIN) ||
                App.getCurrentGame().getCurrentWeather().equals(Weather.STORM)){
            rate = 1.5;
        }

        if(wield instanceof Hoe){
            int energyNeeded = ((Hoe) wield).getType().getEnergyUsed();
            if(player.getFarming() == 450){
                energyNeeded -= 1;
            }
            if(player.getEnergy() > energyNeeded){
                if (targetTile.getItem() == null) {
                    if (targetTile.getType().equals(TileTypes.DIRT) || targetTile.getType().equals(TileTypes.GRASS)) {
                        targetTile.setType(TileTypes.PLANTABLE);
                        targetTile.setTexture(TileTexture.PLANTABLE.getTexture());
                        GameMenu.printResult("The ground is now soft and ready to plant.");
                        player.increaseFarming(5);
                    } else {
                        GameMenu.printResult("Not possible.");
                    }
                    player.setEnergy((float)(player.getEnergy() - rate * energyNeeded));
                } else {
                    GameMenu.printResult("Not possible.");
                }
            }else{
                GameMenu.printResult("You don't have enough energy!");
            }

        } else if (wield instanceof Pickaxe) {
            int energyNeeded = ((Pickaxe) wield).getType().getEnergyUsed();
            if (player.getMining() == 450){
                energyNeeded -= 1;
            }

            if (player.getEnergy() > energyNeeded) {
                if (targetTile.getType().equals(TileTypes.PLANTABLE)) {
                    targetTile.setType(TileTypes.DIRT);
                    targetTile.setTexture(TileTexture.DIRT.getTexture());
                    GameMenu.printResult("Done!");
                } else if (targetTile.getType().equals(TileTypes.QUARRY)) {
                    int cof = 1;
                    if(player.getMining() >= 250){
                        cof = 2;
                    }
                    if(targetTile.getItem() != null) {
                        if (targetTile.getItem() instanceof ForagingMineral) {
                            Item newItem = Item.findItemByName(targetTile.getItem().getName(), player.getBackPack().getItems());
                            if (newItem != null) {
                                newItem.setCount(newItem.getCount() + 2 * cof);
                            } else {
                                if (player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()) {
                                    GameMenu.printResult("You don't have enough space in your backpack!");
                                    return;
                                } else {
                                    player.getBackPack().addItem(targetTile.getItem());
                                }
                            }
                            GameMenu.printResult(targetTile.getItem().getName() + " successfully added to your backpack");
                            player.increaseMining(10);
                            if(RegisterMenu.gameScreen.getGreenhouseScreen().isVisible()){
                                RegisterMenu.gameScreen.getGreenhouseScreen().entities.remove(targetTile.getItem());
                            }   else {
                                RegisterMenu.gameScreen.entities.remove(targetTile.getItem());
                            }
                            targetTile.setItem(null);
                        } else {
                            GameMenu.printResult("You swing your pickaxe... but there's nothing to mine here!");
                            if (energyNeeded > 0) {
                                energyNeeded -= 1;
                            }
                        }
                    } else{
                        GameMenu.printResult("You swing your pickaxe... but there's nothing to mine here!");
                        if (energyNeeded > 0) {
                            energyNeeded -= 1;
                        }
                    }
                } else if(targetTile.getType().equals(TileTypes.HUT) && targetTile.getItem() != (null)) {
                    Item newItem = Item.findItemByName(targetTile.getItem().getName(), player.getBackPack().getItems());
                    if (newItem != null) {
                        newItem.setCount(newItem.getCount() + 1);
                    } else {
                        if (player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()) {
                            GameMenu.printResult("You don't have enough space in your backpack!");
                            return;
                        } else {
                            player.getBackPack().addItem(targetTile.getItem());
                        }
                    }
                    GameMenu.printResult(targetTile.getItem().getName() + " successfully added to your backpack");
                    targetTile.setItem(null);
                } else if (targetTile.getItem() != null) {
                    if (targetTile.getItem() instanceof Stone) {
                        Item stone = new Item(5, "stone", 10, ItemTexture.STONE.getTexture());
                        Item newStone = Item.findItemByName(stone.getName(), player.getBackPack().getItems());

                        if (newStone == null) {
                            if (player.getBackPack().getItems().size() + 1 == player.getBackPack().getType().getCapacity()) {
                                GameMenu.printResult("You don't have enough space in your backpack!");
                                return;
                            } else {
                                player.getBackPack().addItem(stone);
                            }
                        } else {
                            newStone.setCount(newStone.getCount() + 5);
                        }
                        GameScreen.stones.remove(targetTile.getItem());
                        RegisterMenu.gameScreen.getEntities().remove(targetTile.getItem());
                        targetTile.setItem(null);
                        GameMenu.printResult("Collected Stone!");
                    }
                } else {
                    GameMenu.printResult("You swing your pickaxe, but nothing happens.");
                    if(energyNeeded > 0){
                        energyNeeded -= 1;
                    }
                }
                player.setEnergy(player.getEnergy() - (int) rate * energyNeeded);
            }else{
                GameMenu.printResult("You don't have enough energy!");
            }
        } else if(wield instanceof Axe){
            int energyNeeded = ((Axe) wield).getType().getEnergyUsed();
            if(player.getForaging() == 450){
                energyNeeded -= 1;
            }
            if(player.getEnergy() > energyNeeded){

                if(targetTile.getItem() != null && (targetTile.getItem() instanceof ForagingSeed || targetTile.getItem() instanceof Tree)) {
                    if (targetTile.getItem() instanceof Tree || ((ForagingSeed)targetTile.getItem()).getType().getTreeOrCrop() == 1) {
                        Item wood = new Item(12, "wood", 10, ItemTexture.WOOD.getTexture());
                        Item sap = new Item(2, "sap", 10, ItemTexture.WOOD.getTexture());

                        Item newWood = Item.findItemByName(wood.getName(), player.getBackPack().getItems());
                        Item newSap = Item.findItemByName(sap.getName(), player.getBackPack().getItems());

                        if (newWood == null && newSap == null) {
                            if (player.getBackPack().getItems().size() + 1 == player.getBackPack().getType().getCapacity()) {
                                GameMenu.printResult("You don't have enough space in your backpack!");
                                return;
                            } else {
                                player.getBackPack().addItem(sap);
                                player.getBackPack().addItem(wood);
                            }
                        } else if (newWood == null || newSap == null) {
                            if (player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()) {
                                GameMenu.printResult("You don't have enough space in your backpack!");
                                return;
                            }
                            if (newWood == null) {
                                player.getBackPack().addItem(wood);
                                newSap.setCount(newSap.getCount() + 2);
                            } else {
                                player.getBackPack().addItem(sap);
                                newWood.setCount(newWood.getCount() + 12);
                            }
                        } else {
                            newWood.setCount(newWood.getCount() + 12);
                            newSap.setCount(newSap.getCount() + 2);
                        }
//                        if (targetTile.getItem() != null && targetTile.getItem() instanceof ForagingSeed) {
//                            if (((ForagingSeed) targetTile.getItem()).getType().getTreeOrCrop() == 1) {
//                                targetTile.setItem(null);
//                                targetTile.setCrop(null);
//                                targetTile.setReadyToHarvest(false);
//                                targetTile.setPlanted(false);
//                                targetTile.setType(TileTypes.DIRT);
//                            }
//                        }

                        GameScreen.trees.remove(targetTile.getItem());
                        ((GameScreen)Main.getMain().getScreen()).entities.remove(targetTile.getItem());
                        targetTile.setItem(null);
                        GameMenu.printResult("You chop down the tree and collect 12 wood and 2 sap.");
                        player.increaseForaging(10);
                    } else if (targetTile.getItem().equals(new Item(1, "Wood", 10, ItemTexture.WOOD.getTexture()))) {
                        targetTile.setItem(null);
                        GameMenu.printResult("You clear the branch from the ground.");
                    } else {
                        GameMenu.printResult("You swing your axe, but nothing happens.");
                        if (energyNeeded > 0) {
                            energyNeeded -= 1;
                        }
                    }
                } else if(direction.equals(Direction.WEST) && targetTile2.getItem() != null && (targetTile2.getItem() instanceof ForagingSeed || targetTile2.getItem() instanceof Tree)) {
                    if (targetTile2.getItem() instanceof Tree || ((ForagingSeed)targetTile2.getItem()).getType().getTreeOrCrop() == 1) {
                        Item wood = new Item(12, "wood", 10, ItemTexture.WOOD.getTexture());
                        Item sap = new Item(2, "sap", 10, ItemTexture.WOOD.getTexture());

                        Item newWood = Item.findItemByName(wood.getName(), player.getBackPack().getItems());
                        Item newSap = Item.findItemByName(sap.getName(), player.getBackPack().getItems());

                        if (newWood == null && newSap == null) {
                            if (player.getBackPack().getItems().size() + 1 == player.getBackPack().getType().getCapacity()) {
                                GameMenu.printResult("You don't have enough space in your backpack!");
                                return;
                            } else {
                                player.getBackPack().addItem(sap);
                                player.getBackPack().addItem(wood);
                            }
                        } else if (newWood == null || newSap == null) {
                            if (player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()) {
                                GameMenu.printResult("You don't have enough space in your backpack!");
                                return;
                            }
                            if (newWood == null) {
                                player.getBackPack().addItem(wood);
                                newSap.setCount(newSap.getCount() + 2);
                            } else {
                                player.getBackPack().addItem(sap);
                                newWood.setCount(newWood.getCount() + 12);
                            }
                        } else {
                            newWood.setCount(newWood.getCount() + 12);
                            newSap.setCount(newSap.getCount() + 2);
                        }
                        if (targetTile2.getItem() != null && targetTile2.getItem() instanceof ForagingSeed) {
                            if (((ForagingSeed) targetTile.getItem()).getType().getTreeOrCrop() == 1) {
                                targetTile2.setItem(null);
                                targetTile2.setCrop(null);
                                targetTile2.setReadyToHarvest(false);
                                targetTile2.setPlanted(false);
                                targetTile2.setType(TileTypes.DIRT);
                            }
                        }

                        GameScreen.trees.remove(targetTile2.getItem());
                        RegisterMenu.gameScreen.getEntities().remove(targetTile2.getItem());
                        targetTile2.setItem(null);
                        GameMenu.printResult("You chop down the tree and collect 12 wood and 2 sap.");
                        player.increaseForaging(10);
                    } else if (targetTile2.getItem().equals(new Item(1, "Wood", 10, ItemTexture.WOOD.getTexture()))) {
                        targetTile2.setItem(null);
                        GameMenu.printResult("You clear the branch from the ground.");
                    } else {
                        GameMenu.printResult("You swing your axe, but nothing happens.");
                        if (energyNeeded > 0) {
                            energyNeeded -= 1;
                        }
                    }
                } else {
                    GameMenu.printResult("You swing your axe, but nothing happens.");
                    if (energyNeeded > 0) {
                        energyNeeded -= 1;
                    }
                }
                player.setEnergy(player.getEnergy() - (int) rate * energyNeeded);
            }else{
                GameMenu.printResult("You don't have enough energy!");
            }
        } else if(wield instanceof Basket){
            int energyNeeded = ((Basket) wield).getType().getEnergyUsed();
            if(player.getFarming() == 450){
                energyNeeded -= 1;
            }

            if(player.getEnergy() > energyNeeded){
                if(targetTile.getType().equals(TileTypes.WATER)){
                    ((Basket) wield).setRemainingWater(((Basket) wield).getType().getCapacity());
                    GameMenu.printResult("Splash! Your bucket is full and ready to go.");
                } else {
                    if (((Basket) wield).getRemainingWater() <= 0) {
                        System.out.println("Basket is empty!");
                        return;
                    }
                    ((Basket) wield).setRemainingWater(((Basket) wield).getRemainingWater() - 1);
                    if(targetTile.getItem() != null) {
                        if (targetTile.getItem() instanceof ForagingSeed) {
                            targetTile.getCrop().setWateredToday(true);
                            GameMenu.printResult("You give the plants a refreshing splash!");
                            targetTile.setTexture(TileTexture.WATERED.getTexture());
                            player.increaseFarming(5);
                        } else {
                            GameMenu.printResult("You spill some water on the ground.");
                        }

                    } else {
                        GameMenu.printResult("You spilled some water on the ground.");
                    }
                }
                player.setEnergy(player.getEnergy() - (int) rate * energyNeeded);
            }else{
                GameMenu.printResult("You don't have enough energy!");
            }
        } else if(wield instanceof FishingPole){
            // darya TODO
            //skill fishing
        } else if(wield instanceof Scythe){
            if(player.getEnergy() > 2){
                if(targetTile.isReadyToHarvest()){
                    ForagingSeed seed = (ForagingSeed) targetTile.getItem();
                    if (seed.getType().getTreeOrCrop() == 1) {
                        Item newItem = Item.findItemByName(targetTile.getCrop().getName(), player.getBackPack().getItems());
                        if(newItem != null){
                            newItem.setCount(newItem.getCount() + targetTile.getCrop().getCount());

                            GameMenu.printResult("You collected " + targetTile.getCrop().getName() + " and added it to your backpack!");
                            targetTile.getCrop().setRegrowthTime(targetTile.getCrop().getRegrowthTime() + 1);
                            player.increaseFarming(5);
                        } else {
                            if(player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()){
                                GameMenu.printResult("You don't have enough space in your backpack!");
                                return;
                            } else{
                                player.getBackPack().addItem(targetTile.getCrop());
                                player.increaseFarming(5);
                                targetTile.getCrop().setRegrowthTime(targetTile.getCrop().getRegrowthTime() + 1);
                                GameMenu.printResult("You collected " + targetTile.getCrop().getName() + " and added it to your backpack!");
                            }
                        }
                        if (targetTile.getCrop().getType().getRegrowthTime() == targetTile.getCrop().getRegrowthTime()) {
                            targetTile.setReadyToHarvest(false);
                            if (RegisterMenu.gameScreen.getGreenhouseScreen().isVisible()){
                                RegisterMenu.gameScreen.getGreenhouseScreen().entities.remove(targetTile.getCrop());
                            } else {
                                RegisterMenu.gameScreen.getEntities().remove(targetTile.getCrop());
                            }
                            targetTile.setTexture(TileTexture.PLANTABLE.getTexture());
                            targetTile.setType(TileTypes.PLANTABLE);
                            targetTile.setCrop(null);
                            targetTile.setItem(null);
                            targetTile.setGiantCrop(false);
                            targetTile.setPlanted(false);
                            return;
                        }

                        targetTile.setReadyToHarvest(false);
                        targetTile.getCrop().setDaysPassed(0);
                        targetTile.getCrop().setCurrentStage(0);
                        targetTile.getCrop().setDaysNotWatered(0);
                    } else {
                        Item newItem = Item.findItemByName(targetTile.getCrop().getName(), player.getBackPack().getItems());
                        if (newItem != null) {
                            newItem.setCount(newItem.getCount() + targetTile.getCrop().getCount());
                            GameMenu.printResult("You harvested " + targetTile.getCrop().getName() + " and added it to your backpack!");
                            player.increaseFarming(5);
                        } else {
                            if (player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()) {
                                GameMenu.printResult("You don't have enough space in your backpack!");
                                return;
                            } else {
                                player.getBackPack().addItem(targetTile.getCrop());
                                player.increaseFarming(5);
                                GameMenu.printResult("You harvested " + targetTile.getCrop().getName() + " and added it to your backpack!");

                            }
                        }
                        if (targetTile.getCrop() instanceof GiantCrop) {
                            Tile[] tiles1 = ((GiantCrop) targetTile.getCrop()).getTiles();
                            for (Tile tile : tiles1) {
                                tile.setReadyToHarvest(false);
                                RegisterMenu.gameScreen.getEntities().remove(tile.getCrop());
                                tile.setCrop(null);
                                tile.setItem(null);
                                tile.setGiantCrop(false);
                                tile.setPlanted(false);
                            }
                        } else {
                            if (targetTile.getCrop().getRegrowthTime() >= targetTile.getCrop().getType().getRegrowthTime() - 1) {
                                targetTile.setReadyToHarvest(false);
                                if (RegisterMenu.gameScreen.getGreenhouseScreen().isVisible()){
                                    RegisterMenu.gameScreen.getGreenhouseScreen().entities.remove(targetTile.getCrop());
                                } else {
                                    RegisterMenu.gameScreen.getEntities().remove(targetTile.getCrop());
                                }
                                targetTile.setCrop(null);
                                targetTile.setItem(null);
                                targetTile.setGiantCrop(false);
                                targetTile.setPlanted(false);
                            } else {
                                targetTile.setReadyToHarvest(false);
                                targetTile.getCrop().setDaysPassed(0);
                                targetTile.getCrop().setCurrentStage(0);
                                targetTile.getCrop().setDaysNotWatered(0);
                                targetTile.getCrop().setRegrowthTime(targetTile.getCrop().getRegrowthTime() + 1);
                            }

                        }

                    }

                } else if(targetTile.getType().equals(TileTypes.GRASS)){
                    targetTile.setType(TileTypes.DIRT);
                    GameMenu.printResult("Tile type changed to Dirt!");
                } else {
                    GameMenu.printResult("Nothing here to harvest!");
                }
                player.setEnergy(player.getEnergy() - 2 * (int) rate);
            }else{
                GameMenu.printResult("You don't have enough energy!");
            }
        } else if(wield instanceof MilkPail){
            if(player.getEnergy() > 4){
                // shir bedoshe TODO
                player.setEnergy(player.getEnergy() - 4 * (int) rate);
            }else{
                GameMenu.printResult("You don't have enough energy!");
            }
        } else if(wield instanceof Shear){
            if(player.getEnergy() > 4){
                // pashm bezane TODO
                player.setEnergy(player.getEnergy() - 4 * (int) rate);
            }else{
                GameMenu.printResult("You don't have enough energy!");
            }
        }
    }

    public static void craftInfo(String name) {
        boolean isCraftAvailable = false;
        CropType craft = null;
        for (CropType cropType : CropType.values()) {
            if (cropType.getName().toLowerCase().equals(name)) {
                craft = cropType;
                isCraftAvailable = true;
            }
        }
        if (!isCraftAvailable) {
            GameMenu.printResult("No craft with given name were found!");
            return;
        }

        StringBuilder sb = new StringBuilder();

        sb.append("Name: " + craft.getName() + "\n");
        sb.append(MaintainerController.arrayListToString("Stages", craft.getStages()));
        sb.append("Total Harvest Time: " + craft.getTotalHarvestTime() + "\n");
        sb.append("One Time: " + craft.isOneTime() + "\n");
        sb.append("Regrowth Time: " + craft.getRegrowthTime() + "\n");
        sb.append("Base Sell Price: " + craft.getPrice() + "\n");
        sb.append("Is Edible: " + craft.isEdible() + "\n");
        sb.append("Base Energy: " + craft.getEnergy() + "\n");
        sb.append("Base Health: " + craft.getHealth() + "\n");
        sb.append(MaintainerController.arrayListToString("Season", craft.getSeasons()));
        sb.append("Can Become Giant: " + craft.isCanBecomeGiant());
        RegisterMenu.printResult(sb.toString());
    }
    public static Crop plant(String seed1, Direction direction, Tile[][] tiles) {
        ForagingSeed seed;
        Player player = App.getCurrentGame().getCurrentPlayer();

        int x, y;
        if(RegisterMenu.gameScreen.getGreenhouseScreen().isVisible()) {
            y = (int) (player.getY() - Gdx.graphics.getHeight() / 3.93f) / 32;
            x = (int) (player.getX() - Gdx.graphics.getWidth() / 2.5f) /32;
            switch (direction) {
                case NORTH:
                    y += 2;
                    break;
                case SOUTH:
                    y -= 2;
                    break;
            }
        } else {
            y = 60 - (player.getY() / 32);
            x = player.getX() / 32;
        }
        int dx = 0, dy = 0;

        switch (direction) {
            case NORTH: dy = -1; break;      // up
            case SOUTH: dy = 1; break;       // down
            case WEST: dx = -1; break;      // left
            case EAST: dx = 1; break;       // right
//            case "Q": dx = -1; dy = -1; break; // up-left
//            case "E": dx = 1; dy = -1; break;  // up-right
//            case "Z": dx = -1; dy = 1; break;  // down-left
//            case "C": dx = 1; dy = 1; break;   // down-right
            default:
                GameMenu.printResult("Invalid direction!");
                return null;
        }

        int newX = x + dx;
        int newY = y + dy;
        System.out.println(newX + " " + newY);

        // Bounds check
        if (newX < 0 || newX >= tiles.length || newY < 0 || newY >= tiles[0].length) {
            GameMenu.printResult("Out of bounds!");
            return null;
        }
        // Check for plantable tile
        Tile targetTile = tiles[newX][newY];

        if (seed1.equals("mixed seeds") && (Item.findItemByName(seed1, player.getBackPack().getItems()) != null)) {
            Season currentSeason = App.getCurrentGame().getCurrentTime().getSeason();

            // Filter seeds based on season
            List<ForagingSeedType> seasonalSeeds = new ArrayList<>();
            for (ForagingSeedType type : ForagingSeedType.values()) {
                if (type.getSeason() == currentSeason) {
                    seasonalSeeds.add(type);
                }
            }

            if (seasonalSeeds.isEmpty()) {
                GameMenu.printResult("No available seeds for the current season.");
                return null;
            }

            // Pick a random type
            Random rand = new Random();
            ForagingSeedType chosenType = seasonalSeeds.get(rand.nextInt(seasonalSeeds.size()));

            // Create a ForagingSeed instance from the type
            seed = new ForagingSeed(1, chosenType);
        } else {
            seed = (ForagingSeed) Item.findItemByName(seed1, player.getBackPack().getItems());
        }
        if (!(targetTile.getType().equals(TileTypes.PLANTABLE) || ((targetTile.getType().equals(TileTypes.GREENHOUSE) && player.getMap().getGreenHouse() != null)))) {
            GameMenu.printResult("Tile is not plantable!");
            return null;
        }
        Item item = Item.findItemByName(seed1, App.getCurrentGame().getCurrentPlayer().getBackPack().getItems());
        if (item == null) {
            GameMenu.printResult("No item with this name found in your backpack!");
            return null;
        }
        if (item.getCount() > 0) {
            if (targetTile.getItem() == null) {
                targetTile.setItem(seed);
                seed.setFertilized(false);
                item.setCount(item.getCount() - 1);
                targetTile.setPlanted(true);
                if (item.getCount() == 0) {
                    player.getBackPack().getItems().remove(item);
                }
                tiles[newX][newY].setReadyToHarvest(false);
                CropType plantedCrop = seed.getCrop().getType();
                Crop crop = new Crop(1, plantedCrop);
                if (RegisterMenu.gameScreen.getGreenhouseScreen().isVisible()){
                    crop.setPosition(targetTile.getX(), targetTile.getY());
                } else {
                    crop.setPosition(targetTile.getX(), 60 - targetTile.getY());
                }
                tiles[newX][newY].setCrop(crop);
                GameMenu.printResult("Planted " + seed.getName() + " at (" + newX + ", " + newY + ")");
                if (RegisterMenu.gameScreen.getGreenhouseScreen().isVisible()){
                    RegisterMenu.gameScreen.getGreenhouseScreen().entities.add(tiles[newX][newY].getCrop());
                } else {
                    RegisterMenu.gameScreen.entities.add(tiles[newX][newY].getCrop());
                }

                int[][] squareOffsets = {
                        {0, 0},       // current tile is top-left of square
                        {-1, 0},      // current tile is top-right
                        {0, -1},      // current tile is bottom-left
                        {-1, -1}      // current tile is bottom-right
                };

                if(targetTile.getType().equals(TileTypes.PLANTABLE)) {
                    if (seed.getCrop().getType().isCanBecomeGiant()) {
                        for (int[] offset : squareOffsets) {
                            int baseX = newX + offset[0];
                            int baseY = newY + offset[1];

                            // Bounds check
                            if (baseX < 0 || baseY < 0 || baseX + 1 >= tiles.length || baseY + 1 >= tiles[0].length)
                                continue;

                            Tile t1 = tiles[baseX][baseY];
                            Tile t2 = tiles[baseX + 1][baseY];
                            Tile t3 = tiles[baseX][baseY + 1];
                            Tile t4 = tiles[baseX + 1][baseY + 1];

                            if (t1.isPlanted() && t2.isPlanted() && t3.isPlanted() && t4.isPlanted() &&
                                    t1.getCrop() != null && t2.getCrop() != null && t3.getCrop() != null && t4.getCrop() != null &&
                                    t1.getCrop().getType().equals(plantedCrop) &&
                                    t2.getCrop().getType().equals(plantedCrop) &&
                                    t3.getCrop().getType().equals(plantedCrop) &&
                                    t4.getCrop().getType().equals(plantedCrop)) {
                                Tile[] tiles1 = {t1, t2, t3, t4};
                                GiantCrop giantCrop = new GiantCrop(10, t1.getCrop().getType(), tiles1);
                                giantCrop.setPosition(baseX, 59 - baseY);
                                RegisterMenu.gameScreen.entities.add(giantCrop);
                                for (Tile tile : tiles1) {
                                    if (giantCrop.getCurrentStage() < tile.getCrop().getCurrentStage()) {
                                        giantCrop.setCurrentStage(tile.getCrop().getCurrentStage());
                                        if (giantCrop.getDaysPassed() < tile.getCrop().getDaysPassed()) {
                                            giantCrop.setDaysPassed(tile.getCrop().getDaysPassed());
                                        }
                                    }
                                    RegisterMenu.gameScreen.getEntities().remove(tile.getCrop());
                                    tile.setGiantCrops(tiles1);
                                    tile.setGiantCrop(true);
                                    tile.setCrop(giantCrop);
                                }
                                    GameMenu.printResult("Now you have a giant " + giantCrop.getName() + " !");

                                break; // Stop after finding one
                            }
                        }
                    }
                }
            } else {
                GameMenu.printResult("Tile is not farmable!");
                return null;
            }
        } else {
            GameMenu.printResult("No item with this name found in your backpack!");
            return null;
        }
        return seed.getCrop();
    }

    public static void showPlant(String x, String y) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        Tile[][] tiles = App.getCurrentGame().getCurrentPlayer().getMap().getTiles();
        int X = Integer.parseInt(x);
        int Y = Integer.parseInt(y);
        if (tiles[X][Y].isPlanted()) {
            Tile targetTile = tiles[X][Y];
            ForagingSeed seed = (ForagingSeed)targetTile.getItem();
            int daysRemaining = 0;
            for (int i = targetTile.getCrop().getCurrentStage(); i < targetTile.getCrop().getStages().size(); i++) {
                daysRemaining += targetTile.getCrop().getStages().get(i);
            }
            daysRemaining -= targetTile.getCrop().getDaysPassed();
            if (targetTile.isGiantCrop()) {
                GameMenu.printResult("=== GiantCrop!! ===");

            }
            GameMenu.printResult("=== Seed: " + targetTile.getCrop().getName() + " ===\n" +
                    "=== Current Stage: " + targetTile.getCrop().getCurrentStage() + " ===\n" +
                    "=== Days Remaining: " + daysRemaining + " ===\n" +
                    "=== Is Fertilized: " + seed.isFertilized() + " ===\n" +
                    "=== Watered Today: " + targetTile.getCrop().isWateredToday() + " ===\n" +
                    "=== Total Times Harvestes: " + targetTile.getCrop().getRegrowthTime() + " ==="); // TODO
            if (targetTile.isReadyToHarvest()) {
                GameMenu.printResult("=== Ready to Harvest! ===");
            }
        } else {
            GameMenu.printResult("No seed is planted here!");
        }
    }

    public static void fertilize(String fetilizer, Direction direction, Tile[][] tiles) {
        Item item = Item.findItemByName(fetilizer, App.getCurrentGame().getCurrentPlayer().getBackPack().getItems());
        if (item == null) {
            GameMenu.printResult("No item with this name found in your backpack!");
            return;
        }

        Player player = App.getCurrentGame().getCurrentPlayer();
        int x, y;
        if(RegisterMenu.gameScreen.getGreenhouseScreen().isVisible()) {
            y = (int) (player.getY() - Gdx.graphics.getHeight() / 3.93f) / 32;
            x = (int) (player.getX() - Gdx.graphics.getWidth() / 2.5f) /32;
            switch (direction) {
                case NORTH:
                    y += 2;
                    break;
                case SOUTH:
                    y -= 2;
                    break;
            }
        } else {
            y = 60 - (player.getY() / 32);
            x = player.getX() / 32;
        }
        int dx = 0, dy = 0;

        if(player.isInCity()){
            GameMenu.printResult("You cant fertilize in city!");
            return;
        }

        switch (direction) {
            case NORTH: dy = -1; break;      // up
            case SOUTH: dy = 1; break;       // down
            case WEST: dx = -1; break;      // left
            case EAST: dx = 1; break;       // right
//            case "Q": dx = -1; dy = -1; break; // up-left
//            case "E": dx = 1; dy = -1; break;  // up-right
//            case "Z": dx = -1; dy = 1; break;  // down-left
//            case "C": dx = 1; dy = 1; break;   // down-right
            default:
                GameMenu.printResult("Invalid direction!");
                return;
        }

        int newX = x + dx;
        int newY = y + dy;
        if (newX < 0 || newX >= tiles.length || newY < 0 || newY >= tiles[0].length) {
            GameMenu.printResult("Out of bounds!");
            return;
        }
        if (tiles[newX][newY].isPlanted()) {
            if (fetilizer.equals("speed-gro")) {
                if (tiles[newX][newY].getCrop().getCurrentStage() == tiles[newX][newY].getCrop().getStages().size() - 1) {
                    tiles[newX][newY].setReadyToHarvest(true);
                } else {
                    tiles[newX][newY].getCrop().setCurrentStage(tiles[newX][newY].getCrop().getCurrentStage() + 1);
                }
            } else if (fetilizer.equals("deluxe retaining soil")) {
                tiles[newX][newY].getCrop().setNotNeedWaterAnymore(true);

            }
            ForagingSeed seed = (ForagingSeed) tiles[newX][newY].getItem();
            seed.setFertilized(true);
            GameMenu.printResult("Fertilizer applied!");
            item.setCount(item.getCount() - 1);
            if (item.getCount() == 0) {
                player.getBackPack().getItems().remove(item);
            }
        } else {
            GameMenu.printResult("There is no PLANT at (" + newX + ", " + newY + ")!!");
        }
    }
    public static void howMuchWater() {
        for(Item items : App.getCurrentGame().getCurrentPlayer().getBackPack().getItems()) {
            if(items instanceof Basket) {
                GameMenu.printResult(items.getName() + " Remaining water: " + ((Basket) items).getRemainingWater() + "/" + ((Basket) items).getType().getCapacity());
            }
        }
    }
    public static void craftAddRecipe(String itemName) {
        IndustrialProductType item = null;
        for (IndustrialProductType industrialProductType : IndustrialProductType.values()) {
            if (industrialProductType.getName().equals(itemName)) item = industrialProductType;
        }

        if (item == null) GameMenu.printResult("No recipe with given name were found!");
        else {
            App.getCurrentGame().getCurrentPlayer().addCraftingRecipe(item);
            GameMenu.printResult(itemName + " added successfully!");
        }
    }
    public static void showCraftingRecipes() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        Tile tiles = App.getCurrentGame().getCurrentPlayer().getMap().getTiles()[player.getX()][player.getY()];

        if(!tiles.getType().equals(TileTypes.HUT)){
            GameMenu.printResult("Crafting doesn't work outside of your home!");
            return;
        }

        for(IndustrialProductType recipe :App.getCurrentGame().getCurrentPlayer().getCraftingRecipes()){
            GameMenu.printResult(recipe.getName() + ": " + recipe.getDescription());
            StringBuilder ingredients = new StringBuilder();
            ingredients.append("    ingredients :");
            for (Item items : recipe.getIngredients()){
                ingredients.append(" ");
                ingredients.append(items.getCount());
                ingredients.append(" ");
                ingredients.append(items.getName());
            }
            GameMenu.printResult(ingredients.toString());
            return;
        }
        GameMenu.printResult("You dont have any crafting recipes!");
    }
    public static String crafting(IndustrialProductType recipe) {
        Player player = App.getCurrentGame().getCurrentPlayer();
//        Tile tiles = App.getCurrentGame().getCurrentPlayer().getMap().getTiles()[player.getX()][player.getY()];

//        if(!tiles.getType().equals(TileTypes.HUT)){
//            GameMenu.printResult("Crafting doesn't work outside of your home!");
//            return;
//        }

//        for(IndustrialProductType recipe : IndustrialProductType.values()){
//            if(recipe.getName().equals(name)){
//                if(player.getCraftingRecipes().contains(recipe)){
                    for(Item items : recipe.getIngredients()){
                        Item ingredient = Item.findItemByName(items.getName(), player.getBackPack().getItems());
                        if(ingredient == null){
//                            GameMenu.printResult("You don't have necessary ingredients!");
                            return "You don't have necessary ingredients!";
                        }else{
                            if(ingredient.getCount() < items.getCount()){
//                                GameMenu.printResult("You don't have enough ingredients!");
                                return "You don't have enough ingredients!";
                            }
                        }
                    }
                    IndustrialProduct crafted = new IndustrialProduct(1, recipe);

                    Item newItem = Item.findItemByName(crafted.getName(), player.getBackPack().getItems());

                    if((newItem == null) && player.getBackPack().getType().getCapacity() == player.getBackPack().getItems().size()){
//                        GameMenu.printResult("You don't have enough space in your backpack!");
                        return "You don't have enough space in your backpack!";
                    }

                    for(Item ingredient : recipe.getIngredients()){
                        Item item = Item.findItemByName(ingredient.getName(), player.getBackPack().getItems());

                        if(item.getCount() == ingredient.getCount()){
                            player.getBackPack().getItems().remove(item);
                        }else{
                            item.setCount(item.getCount() - ingredient.getCount());
                        }
                    }

                    if (recipe.equals(IndustrialProductType.BEE_HOUSE) ||
                        recipe.equals(IndustrialProductType.KEG) ||
                        recipe.equals(IndustrialProductType.CHEESE_PRESS) ||
                        recipe.equals(IndustrialProductType.DEHYDRATOR) ||
                        recipe.equals(IndustrialProductType.CHARCOAL_KILN) ||
                        recipe.equals(IndustrialProductType.LOOM) ||
                        recipe.equals(IndustrialProductType.MAYONNAISE_MACHINE) ||
                        recipe.equals(IndustrialProductType.OIL_MAKER) ||
                        recipe.equals(IndustrialProductType.PRESERVES_JAR) ||
                        recipe.equals(IndustrialProductType.FISH_SMOKER) ||
                        recipe.equals(IndustrialProductType.FURNACE))
                        player.addDevice(recipe);
                    else {
                        if (newItem != null) {
                            newItem.setCount(newItem.getCount() + 1);
                        } else {
                            player.getBackPack().getItems().add(crafted);
                        }
                    }
//                    GameMenu.printResult("You have successfully crafted " + recipe.getName() + "!");
                    player.setEnergy(player.getEnergy() - 2);
//                    player.getMap().changeHasScareCrow();
                    return "You have successfully crafted " + recipe.getName() + "!";
//                } else{
//                    GameMenu.printResult("Sorry! you don't have the recipe for " + recipe.getName());
//                }
//                return;
//            }
//        }
//        GameMenu.printResult(name + " cannot be crafted!");
    }
    public static void placeItem(String name, String direction) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        Tile[][] tiles = App.getCurrentGame().getCurrentPlayer().getMap().getTiles();
        Tile tile1 = App.getCurrentGame().getCurrentPlayer().getMap().getTiles()[player.getX()][player.getY()];

        if(!tile1.getType().equals(TileTypes.HUT)){
            GameMenu.printResult("Crafting doesn't work outside of your home!");
            return;
        }


        int x = player.getX();
        int y = player.getY();
        int dx = 0, dy = 0;


        switch (direction) {
            case "w": dy = -1; break;
            case "s": dy = 1; break;
            case "a": dx = -1; break;
            case "d": dx = 1; break;
            case "Q": dx = -1; dy = -1; break;
            case "E": dx = 1; dy = -1; break;
            case "Z": dx = -1; dy = 1; break;
            case "C": dx = 1; dy = 1; break;
            default:
                GameMenu.printResult("Invalid direction!");
                return;
        }

        int newX = x + dx;
        int newY = y + dy;

        if (newX < 0 || newX >= tiles.length || newY < 0 || newY >= tiles[0].length) {
            GameMenu.printResult("Out of bounds!");
            return;
        }

        Tile targetTile = tiles[newX][newY];
        Item item =  Item.findItemByName(name, player.getBackPack().getItems());
        if(item == null){
            GameMenu.printResult("Item not found!");
            return;
        }

        if(targetTile.getItem() == null){
            targetTile.setItem(item);
            GameMenu.printResult("You have successfully placed " + item.getName() + " on x: " + newX + " y: " + newY + "!");
        } else{
            GameMenu.printResult("You can't place this item here!");
        }
    }
    public static void cheatAddItem(String name, String count) {
        MaintainerController.cheatAddItem(name, Integer.parseInt(count));
    }

    public static String putRefrigerator(Item item) {
        Player player = App.getCurrentGame().getCurrentPlayer();

        if (item.getClass() != Food.class) {
            return "Item is not eatable";
        }

        if (player.getRefrigerator().getItems().size() + 1 > player.getRefrigerator().getCAPTIYITY()) {
            return "Refrigerator is full!";
        }

        player.getBackPack().removeItem(item);
        player.getRefrigerator().addItem(item);
        return null;
    }

    public static String pickRefrigerator(Item item) {
        Player player = App.getCurrentGame().getCurrentPlayer();

        if (player.getBackPack().getItems().size() + 1 > player.getBackPack().getType().getCapacity()) {
            return "Backpack is full!";
        }
        player.getBackPack().addItem(item);
        player.getRefrigerator().removeItem(item);
        return null;
    }

    public static void showCookingRecipe(boolean isAll) {
        StringBuilder sb = new StringBuilder();

        if (isAll) {
            ArrayList<FoodType> recipes = App.getCurrentGame().getCurrentPlayer().getRecipes();
            for (int i = 0; i < recipes.size(); i++) {
                sb.append(recipes.get(i).getName());
                if (i < recipes.size() - 1) {
                    sb.append("-");
                }
                else sb.append("\n");
            }
        }

        else {
            FoodType[] recipes = FoodType.values();
            for (int i = 0; i < recipes.length; i++) {
                sb.append(recipes[i].getName());
                if (i < recipes.length - 1) {
                    sb.append("-");
                }
                else sb.append("\n");
            }
        }

        GameMenu.printResult(sb.toString());
    }

    public static void addCookingRecipe(String name) {
        FoodType recipe = null;
        for (int i = 0; i < FoodType.values().length; i++) {
            if (FoodType.values()[i].getName().equals(name)) recipe = FoodType.values()[i];
        }

        if (recipe == null) GameMenu.printResult("No recipe with given name were found!");

        App.getCurrentGame().getCurrentPlayer().addRecipe(recipe);
        GameMenu.printResult("Recipe added successfully!");
    }

    public static String cooking(FoodType recipe) {
        Player player = App.getCurrentGame().getCurrentPlayer();

        if (player.getBackPack().getItems().size() >= player.getBackPack().getType().getCapacity()) {
            return "Your Backpack is full!!";
        }
//        if (player.getEnergy() <= 3) {
//            player.setEnergy(0);
//            player.setPassedOut(true);
//            GameMenu.printResult("You have a carismatic passing out! WHILE COOKING");
//            NewGameController.NextTurn(scanner);
//            return;
//        } //TODO Next Turn??!

        for (Item ingredient : recipe.getIngredients()) {
            Item refrigratorItem = Item.findItemByName(ingredient.getName(), App.getCurrentGame().getCurrentPlayer().getRefrigerator().getItems());
            Item backpackItem = Item.findItemByName(ingredient.getName(), App.getCurrentGame().getCurrentPlayer().getBackPack().getItems());

            if (backpackItem == null) {
                if (refrigratorItem == null)
                    return "You don't have any " + ingredient.getName();
                else {
                    if (refrigratorItem.getCount() < ingredient.getCount())
                        return "You don't have enough " + ingredient.getName();
                    else
                        return "You have enough " + ingredient.getName() + " in your refrigerator. Please move it to your backpack";
                }
            }
            else {
                if (backpackItem.getCount() < ingredient.getCount()) {
                    if (refrigratorItem == null)
                        return "You don't have enough " + ingredient.getName();
                    else {
                        if (refrigratorItem.getCount() < ingredient.getCount())
                            return "You don't have enough " + ingredient.getName();
                        else
                            return "You have enough " + ingredient.getName() + " in your refrigrator. Please move it to your backpack";
                    }
                }
            }
        }

        for (Item ingredient : recipe.getIngredients()) {
            Item backpackItem = Item.findItemByName(ingredient.getName(), App.getCurrentGame().getCurrentPlayer().getBackPack().getItems());

            if (ingredient.getCount() == backpackItem.getCount())
                App.getCurrentGame().getCurrentPlayer().getBackPack().removeItem(backpackItem);
            else
                backpackItem.changeCount(-1 * ingredient.getCount());
        }

        App.getCurrentGame().getCurrentPlayer().getBackPack().addItem(new Food(1, recipe));
        App.getCurrentGame().getCurrentPlayer().changeEnergy(-3);
        return null;
    }

    public static void eat(String name) {
        Food food = null;
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (Item foodItem : player.getBackPack().getItems()) {
            if (foodItem.getClass() == Food.class && foodItem.getName().equals(name))
                food = (Food) foodItem;
        }

        if (food == null) {
            GameMenu.printResult("No food with given name were found!");
            return;
        }
        food.changeCount(-1);
        if (food.getCount() == 0)
            App.getCurrentGame().getCurrentPlayer().getBackPack().removeItem(food);
        GameMenu.printResult("Food eaten successfully");
        if (food.getName().equals("red plate")) {
            GameMenu.printResult("You got buffed for 3 hours! Max energy set to " + (player.getMaxEnergy() + 50));
            player.changeEnergy(50);
            player.setMaxEnergy(player.getMaxEnergy() + 50);
            player.getBuffs().put("red plate", 3);
        } else if (food.getName().equals("triple shot espresso")) {
            GameMenu.printResult("You got buffed for 5 hours! Max energy set to " + (player.getMaxEnergy() + 100));
            player.changeEnergy(100);
            player.setMaxEnergy(player.getMaxEnergy() + 100);
            player.getBuffs().put("triple shot espresso", 5);
        } else if (food.getName().equals("hash browns")) {
            GameMenu.printResult("You got buffed for 5 hours!  Farming  skill level added by 1!");
            player.getBuffs().put("hash browns", 5);
            player.setFarming(player.getFarming() + 1);
        } else if (food.getName().equals("pancakes")) {
            GameMenu.printResult("You got buffed for 11 hours! Foraging  skill level added by 1!");
            player.getBuffs().put("pancakes", 11);
            player.setForaging(player.getForaging() + 1);
        } else if (food.getName().equals("farmer's lunch")) {
            GameMenu.printResult("You got buffed for 5 hours! Farming  skill level added by 1!");
            player.getBuffs().put("farmer's lunch", 5);
            player.setFarming(player.getFarming() + 1);
        } else if (food.getName().equals("survival burger")) {
            GameMenu.printResult("You got buffed for 5 hours! Foraging  skill level added by 1!");
            player.getBuffs().put("survival burger", 5);
            player.setForaging(player.getForaging() + 1);
        } else if (food.getName().equals("dish o' the sea")) {
            GameMenu.printResult("You got buffed for 5 hours! Fishing  skill level added by 1!");
            player.getBuffs().put("dish o' the sea", 5);
            player.setFishing(player.getFishing() + 1);
        } else if (food.getName().equals("seaform pudding")) {
            GameMenu.printResult("You got buffed for 10 hours! Fishing  skill level added by 1!");
            player.getBuffs().put("seaform pudding", 10);
            player.setFishing(player.getFishing() + 1);
        } else if (food.getName().equals("miner's treat")) {
            GameMenu.printResult("You got buffed for 5 hours! Mining  skill level added by 1!");
            player.getBuffs().put("miner's treat", 5);
            player.setMining(player.getMining() + 1);
        }

        App.getCurrentGame().getCurrentPlayer().setEnergy(Math.min(player.getEnergy() + food.getType().getEnergy(), App.getCurrentGame().getCurrentPlayer().getMaxEnergy()));
    }
    public static void showCookingRecipe(){}

    public static boolean build(String name, float X, float Y){
        // TODO check the carpenter's shop for this shit
        int x = (int)(X / 32);
        int y = (int)(60 - Y / 32);
        int barnORcoop = -1; // 1 for barn and 0 for coop
        Player player = App.getCurrentGame().getCurrentPlayer();
        Tile[][] tiles = App.getCurrentGame().getCurrentPlayer().getMap().getTiles();
        String normalized = name.trim().toUpperCase().replace(" ", "_");

        try {
            CarpenterCosts item = CarpenterCosts.valueOf(normalized);
            for (int i = x; i < item.getWidth() + x; i++) {
                for (int j = y - item.getHeight(); j < y; j++) {
                    if (tiles[i][j].getItem() != null) {
                        GameMenu.printResult("Not enough space!");
                        return false;
                    }
                    if (!(tiles[i][j].getType().equals(TileTypes.DIRT)) && !(tiles[i][j].getType().equals(TileTypes.GRASS))){
                        GameMenu.printResult("Invalid Coordinates! The tile type is " + tiles[i][j].getType());
                        return false;
                    }
                }
            }
            Item item1 = Item.findItemByName("wood", player.getBackPack().getItems());
            Item item2 = Item.findItemByName("stone", player.getBackPack().getItems());
            if (item1 == null || item2 == null) {
                GameMenu.printResult("You don't have enough resources!");
                return false;
            }
            if (item.getPrice() > player.getMoney()) {
                GameMenu.printResult("You don't have enough money!");
                return false;
            } else if (item.getWood() > item1.getCount()) {
                GameMenu.printResult("You don't have enough wood!");
                return false;
            } else if (item.getStone() > item2.getCount()) {
                GameMenu.printResult("You don't have enough stone!");
                return false;
            }
            Barn barn = null;
            Coop coop = null;
            switch (item) {
                case BARN -> {
                    barn = new Barn(4, 7, x, y, 4, "regular");
                    player.getMap().getBarns().add(barn);
                    barnORcoop = 1;
                }
                case BIG_BARN -> {
                    barn = new Barn(4, 7, x, y, 8, "big");
                    player.getMap().getBarns().add(barn);
                    barnORcoop = 1;
                }
                case DELUXE_BARN -> {
                    barn = new Barn(4, 7, x, y, 12, "deluxe");
                    player.getMap().getBarns().add(barn);
                    barnORcoop = 1;
                }
                case COOP -> {
                    coop = new Coop(3, 6, x, y, 4, "regular");
                    player.getMap().getCoops().add(coop);
                    barnORcoop = 0;
                }
                case BIG_COOP -> {
                    coop = new Coop(3, 6, x, y, 8, "big");
                    player.getMap().getCoops().add(coop);
                    barnORcoop = 0;
                }
                case DELUXE_COOP -> {
                    coop = new Coop(3, 6, x, y, 12, "deluxe");
                    player.getMap().getCoops().add(coop);
                    barnORcoop = 0;
                }
            }
            item1.setCount(item1.getCount() - item.getWood());
            item2.setCount(item2.getCount() - item.getStone());
            for (int i = x; i < x + item.getWidth(); i++) {
                for (int j = (60 - y) - item.getHeight(); j < (60 - y); j++) {
                    if (barnORcoop == 1) {
                        tiles[i][j].setType(TileTypes.BARN);
                    } else if (barnORcoop == 0) {
                        tiles[i][j].setType(TileTypes.COOP);
                    }
                }
            }
            if (coop == null) {
                RegisterMenu.gameScreen.getEntities().add(barn);
                player.getMap().getBuildings().add(barn);
            } else {
                RegisterMenu.gameScreen.getEntities().add(coop);
                player.getMap().getBuildings().add(coop);
            }
            if (barnORcoop == 0) {
                GameMenu.printResult("Coop bought successfully!");
            } else if (barnORcoop == 1) {
                GameMenu.printResult("Barn bought successfully!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid item: " + name);
        }
        return true;
    }
//    public int animalX(ArrayList<Coop> coops) {
//        int x = 0;
//        for (Coop coop : coops) {
//            for (Animal animal : coop.getAnimals()) {
//                if (animal.getX() == x) {
//
//                }
//            }
//        }
//    }
    public static void buyAnimal(String animal1, String name) {
        // TODO go to marnie's ranch
        String animal2 = animal1.toUpperCase().replace(" ", "_");
        RanchCosts animal3 = RanchCosts.valueOf(animal2);
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (Animal animal : player.getAnimals()) {
            if (animal.getName().equals(name)) {
                GameMenu.printResult("Choose a different name!");
                return;
            }
        }
        int check = 0;
        switch (animal3) {
            case CHICKEN -> {
                for (Coop coop : player.getMap().getCoops()) {
                    if (coop.getCapacity() > coop.getAnimals().size()) {
                        Animal animal = new Chicken(800, name, 0, false, false, coop.getStartX() + coop.getAnimals().size(), coop.getStartY() - coop.getAnimals().size() - 1);
                        coop.getAnimals().add(animal);
                        animal.setCoop(coop);
                        coop.setCurrentNumberOfAnimals(coop.getAnimals().size());
                        player.getAnimals().add(animal);
                        check = 1;
                        break;
                    }
                }
                if (check == 0) {
                    GameMenu.printResult("You don't have enough space!");
                }
            }
            case DUCK -> {
                for (Coop coop : player.getMap().getCoops()) {
                    if (!coop.getType().equals("regular") && coop.getCapacity() > coop.getAnimals().size()) {
                        Animal animal = new Duck(1200, name, 0, false, false, coop.getStartX() + coop.getAnimals().size(), coop.getStartY() - coop.getAnimals().size() - 1);
                        coop.getAnimals().add(animal);
                        animal.setCoop(coop);
                        coop.setCurrentNumberOfAnimals(coop.getAnimals().size());
                        player.getAnimals().add(animal);
                        check = 1;
                        break;
                    }
                }
                if (check == 0) {
                    GameMenu.printResult("You don't have enough space!");
                }
            }
            case RABBIT -> {
                for (Coop coop : player.getMap().getCoops()) {
                    if (!coop.getType().equals("regular") && !coop.getType().equals("big") && coop.getCapacity() > coop.getAnimals().size()) {

                        Animal animal = new Rabbit(8000, name, 0, false, false, coop.getStartX() + coop.getAnimals().size(), coop.getStartY() - coop.getAnimals().size() - 1);
                        coop.getAnimals().add(animal);
                        animal.setCoop(coop);
                        coop.setCurrentNumberOfAnimals(coop.getAnimals().size());
                        player.getAnimals().add(animal);
                        check = 1;
                        break;
                    }
                }
                if (check == 0) {
                    GameMenu.printResult("You don't have enough space!");
                }
            }
            case DINOSAUR -> {
                for (Coop coop : player.getMap().getCoops()) {
                    if (!coop.getType().equals("regular") && !coop.getType().equals("deluxe") && coop.getCapacity() > coop.getAnimals().size()) {

                        Animal animal = new Dinosaur(800, name, 0, false, false, coop.getStartX() + coop.getAnimals().size(), coop.getStartY() - coop.getAnimals().size() - 1);
                        coop.getAnimals().add(animal);
                        coop.setCurrentNumberOfAnimals(coop.getAnimals().size());
                        player.getAnimals().add(animal);
                        check = 1;
                        break;
                    }
                }
                if (check == 0) {
                    GameMenu.printResult("You don't have enough space!");
                }
            }
            case COW -> {
                for (Barn barn : player.getMap().getBarns()) {
                    if (barn.getCapacity() > barn.getAnimals().size()) {
                        Animal animal = new Cow(1500, name, 0, false, false, barn.getStartX() + barn.getAnimals().size(), barn.getStartY() - barn.getAnimals().size() - 1);
                        barn.getAnimals().add(animal);
                        animal.setBarn(barn);
                        player.getAnimals().add(animal);
                        barn.setCurrentNumberOfAnimals(barn.getAnimals().size());
                        check = 1;
                        break;
                    }
                }
                if (check == 0) {
                    GameMenu.printResult("You don't have enough space!");
                }
            }
            case GOAT -> {
                for (Barn barn : player.getMap().getBarns()) {
                    if (!barn.getType().equals("regular") && barn.getCapacity() > barn.getAnimals().size()) {

                        Animal animal = new Goat(4000, name, 0, false, false, barn.getStartX() + barn.getAnimals().size(), barn.getStartY() - barn.getAnimals().size() - 1);
                        barn.getAnimals().add(animal);
                        animal.setBarn(barn);
                        player.getAnimals().add(animal);
                        barn.setCurrentNumberOfAnimals(barn.getAnimals().size());
                        check = 1;
                        break;
                    }
                }
                if (check == 0) {
                    GameMenu.printResult("You don't have enough space!");
                }
            }
            case SHEEP -> {
                for (Barn barn : player.getMap().getBarns()) {
                    if (!barn.getType().equals("regular") && !barn.getType().equals("big") && barn.getCapacity() > barn.getAnimals().size()) {

                        Animal animal = new Sheep(8000, name, 0, false, false, barn.getStartX() + barn.getAnimals().size(), barn.getStartY() - barn.getAnimals().size() - 1);
                        barn.getAnimals().add(animal);
                        animal.setBarn(barn);
                        player.getAnimals().add(animal);
                        barn.setCurrentNumberOfAnimals(barn.getAnimals().size());
                        check = 1;
                        break;
                    }
                }
                if (check == 0) {
                    GameMenu.printResult("You don't have enough space!");
                }
            }
            case PIG -> {
                for (Barn barn : player.getMap().getBarns()) {
                    if (!barn.getType().equals("regular") && !barn.getType().equals("big") && barn.getCapacity() > barn.getAnimals().size()) {

                        Animal animal = new Pig(16000, name, 0, false, false, barn.getStartX() + barn.getAnimals().size(), barn.getStartY() - barn.getAnimals().size() - 1);
                        barn.getAnimals().add(animal);
                        animal.setBarn(barn);
                        player.getAnimals().add(animal);
                        barn.setCurrentNumberOfAnimals(barn.getAnimals().size());
                        check = 1;
                        break;
                    }
                }
                if (check == 0) {
                    GameMenu.printResult("You don't have enough space!");
                }
            }
        }

        if (player.getMoney() < animal3.getPrice()) {
            GameMenu.printResult("You don't have enough money!");
            return;
        }
        else if (player.getMoney() >= animal3.getPrice()) {
            player.setMoney(player.getMoney() - animal3.getPrice());
        }

        if (check == 1) {
            GameMenu.printResult("Animal bought successfully!");
        }
    }
    public static void pet(String name) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        int playerX = player.getX();
        int playerY = player.getY();

        for (Animal animal : player.getAnimals()) {
            if (animal.getName().equals(name)) {
                float animalX = animal.getX();
                float animalY = animal.getY();


                boolean isAdjacent = Math.abs(playerX - animalX) <= 1 &&
                        Math.abs(playerY - animalY) <= 1 &&
                        !(playerX == animalX && playerY == animalY);

                if (!isAdjacent) {
                    GameMenu.printResult("You must stand next to the animal to pet it.");
                    return;
                }


                animal.setFriendship(Math.min(animal.getFriendship() + 15, 1000));

                if (animal instanceof Cow) {
                    GameMenu.printResult("mowwwww!");
                } else if (animal instanceof Sheep) {
                    GameMenu.printResult("shazoooom!");
                } else {
                    GameMenu.printResult("Animal pet successfully!");
                }
                animal.setPetToday(true);
                return;
            }
        }

        GameMenu.printResult("No such animal found.");
    }

    public static void cheatSetFriendship(String name, String amount) {
        if (Integer.parseInt(amount) > 1000) {
            GameMenu.printResult("Invalid amount.");
            return;
        }
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (Animal animal : player.getAnimals()) {
            if (animal.getName().equals(name)) {
                animal.setFriendship(Integer.parseInt(amount));
                GameMenu.printResult("Animal friendship set to " + amount);
                break;
            }
        }
    }
    public static void animals() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (Animal animal : player.getAnimals()) {
            GameMenu.printResult("=== Animal: " + animal.name(animal) + " " + animal.getName() + " ===");
            GameMenu.printResult("=== Friendship: " + animal.getFriendship() + " ===");
            GameMenu.printResult("=== Is fed today: " + animal.isFedToday() + " ===");
            GameMenu.printResult("=== Is pet today: " + animal.isPetToday() + " ===");
            GameMenu.printResult("");
        }
    }
    public static void shepherdAnimals(String name, String x, String y){
        Player player = App.getCurrentGame().getCurrentPlayer();
        Tile[][] tiles = player.getMap().getTiles();
        Weather w = App.getCurrentGame().getCurrentWeather();
        if (w.equals(Weather.RAIN) || w.equals(Weather.SNOW) || w.equals(Weather.STORM)) {
            GameMenu.printResult("Weather is not great for sheperding animal!");
            return;
        }
        for (Animal animal : player.getAnimals()) {
            if (animal.getName().equals(name)) {
                if (!animal.isOut()) {
                    if (tiles[Integer.parseInt(x)][Integer.parseInt(y)].isWalkable()) {
                        animal.setX(Integer.parseInt(x));
                        animal.setY(Integer.parseInt(y));
                        animal.setFedToday(true);
                        animal.setOut(true);
                        animal.setFriendship(Math.min(animal.getFriendship() + 8, 1000));
                        GameMenu.printResult("Animal is out!");
                    } else {
                        GameMenu.printResult("Tile is not walkable!");
                    }
                } else {
                    animal.setX((int)animal.getFirstX());
                    animal.setY((int)animal.getFirstY());
                    animal.setOut(false);
                    GameMenu.printResult("Animal back to safety!");
                }
                break;
            }
        }
    }
    public static void feedHay(String name){
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (Animal animal : player.getAnimals()) {
            if (animal.getName().equals(name)) {
                Item hay = Item.findItemByName("hay", player.getBackPack().getItems());
                if (hay != null && hay.getCount() > 0) {
                    hay.setCount(hay.getCount() - 1);
                    animal.setFedToday(true);
                    animal.setFriendship(Math.min(animal.getFriendship() + 10, 1000));
                    GameMenu.printResult("Animal fed successfully!");
                } else {
                    GameMenu.printResult("Not enough hay!");
                }
                return;
            }
        }
    }
    public static void produces(){
        Player player = App.getCurrentGame().getCurrentPlayer();
        GameMenu.printResult("+++ Ready Products +++");
        for (Animal animal : player.getAnimals()) {
            if (animal.isProductReady()) {
                GameMenu.printResult("=== " + animal.getName() + " " + animal.name(animal) + "'s product is ready to collect! ===");
            }
        }
    }
    public static void collectProduce(String name){
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (Animal animal : player.getAnimals()) {
            if (animal.getName().equals(name)) {
                if (animal.isProductReady()) {
                    System.out.println("yes");
                    animal.collectProduct();
                    return;
                } else {
                    GameMenu.printResult("Product is not ready!");
                }
            }
        }
    }
    public static void sellAnimal(Animal animal){
        Player player = App.getCurrentGame().getCurrentPlayer();
        float cost = (float) (animal.getPrice() * ((double) animal.getFriendship() / 1000 + 0.3));
        player.setMoney(player.getMoney() + (int) cost);
        player.getAnimals().remove(animal);
        if (animal.getBarn() != null) {
            animal.getBarn().getAnimals().remove(animal);
        } else if (animal.getCoop() != null) {
            animal.getCoop().getAnimals().remove(animal);
        }
        GameMenu.printResult("Sold " + animal.getName() + " for: " + cost);
    }
    public static void fishing(){
        Player player = App.getCurrentGame().getCurrentPlayer();

        ArrayList<FishType> fishTypes = new ArrayList<>();
        for (FishType fishType : FishType.values()) {
            if (fishType.getSeason().equals(App.getCurrentGame().getCurrentTime().getSeason())) {
                if (fishType.isLegendary()) {
                    if (player.getFishing() == 450) fishTypes.add(fishType);
                } else fishTypes.add(fishType);
            }
        }

        Random random = new Random();
        FishType fishType = fishTypes.get(random.nextInt(fishTypes.size()));

        double R = random.nextDouble();
        double M;
        if (App.getCurrentGame().getCurrentWeather().equals(Weather.SUNNY)) M = 1.5;
        else if (App.getCurrentGame().getCurrentWeather().equals(Weather.RAIN)) M = 1.2;
        else if (App.getCurrentGame().getCurrentWeather().equals(Weather.STORM)) M = 0.5;
        else M = 1.0;
        int skill = player.getFishing() / 100;
        FishingPole fishingPole = (FishingPole) player.getWield();
        double pole = fishingPole.getType().getPole();

        int count = (int) Math.floor(R * M * (skill + 2)) + 1;
        count = Math.min(count, 6);

        double fishQuality = Math.floor((R * (skill + 2) * pole) / (7 - M));

        Fish fish = new Fish(count, fishType);

        if (fishQuality <= 0.5) {
            fish.setCof(1);
        }
        else if (0.5 < fishQuality && fishQuality <= 0.7) {
            fish.setCof(1.25);
        }
        else if (0.7 < fishQuality && fishQuality <= 0.9) {
            fish.setCof(1.5);
        }
        else {
            fish.setCof(2);
        }

        if (player.getBackPack().getItems().size() + 1 > player.getBackPack().getType().getCapacity()) {
            return;
        }
        App.getCurrentGame().getCurrentPlayer().getBackPack().addItem(fish);
        App.getCurrentGame().getCurrentPlayer().changeEnergy(-1 * fishingPole.getType().getEnergyUsed());
        App.getCurrentGame().getCurrentPlayer().increaseFishing(5);
    }

    public static String artisanUse(ArtisanGoodType item) {
        Player player = App.getCurrentGame().getCurrentPlayer();

        if (player.getBackPack().getItems().size() >= player.getBackPack().getType().getCapacity())
            return "Your Backpack is full!!";

        for (Item ingredient : item.getIngredients()) {
            Item backpackItem = Item.findItemByName(ingredient.getName(), App.getCurrentGame().getCurrentPlayer().getBackPack().getItems());

            if (backpackItem == null)
                return "You don't have any " + ingredient.getName();
            else {
                if (backpackItem.getCount() < ingredient.getCount())
                    return "You don't have enough " + ingredient.getName();
            }
        }

        for (Item ingredient : item.getIngredients()) {
            Item backpackItem = Item.findItemByName(ingredient.getName(), App.getCurrentGame().getCurrentPlayer().getBackPack().getItems());

            if (ingredient.getCount() == backpackItem.getCount())
                App.getCurrentGame().getCurrentPlayer().getBackPack().removeItem(backpackItem);
            else
                backpackItem.changeCount(-1 * ingredient.getCount());
        }

        App.getCurrentGame().getCurrentPlayer().addArtisanItemProsses(new ArtisanItemProsses(new ArtisanGood(1, item)));
        return null;
    }

    public static void artisanGet(ArtisanItemProsses artisanItemProsses) {
        App.getCurrentGame().getCurrentPlayer().getArtisanItemsProsses().remove(artisanItemProsses);

        String artisanItemName = artisanItemProsses.getArtisanGood().getName();
        boolean itemInBackPack = false;
        for (Item item: App.getCurrentGame().getCurrentPlayer().getBackPack().getItems()) {
            if (item.getName().equals(artisanItemName)) {
                item.setCount(item.getCount() + 1);
                itemInBackPack = true;
            }
        }

        if (!itemInBackPack)
            App.getCurrentGame().getCurrentPlayer().getBackPack().addItem(artisanItemProsses.getArtisanGood());
    }

    public static void showAllProducts() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (!player.isInCity()) {
            GameMenu.printResult("You are not in the city!");
            return;
        }
        Tile[][] tiles = App.getCurrentGame().getCurrentMap().getTiles();
        switch (tiles[player.getCityX()][player.getCityY()].getType()) {
            case BLACKSMITH ->
                    GameMenu.printResult(MaintainerController.printingShopProducts("Blacksmith", BlacksmithCosts.values()));
            case CARPENTERS_SHOP ->
                    GameMenu.printResult(MaintainerController.printingShopProducts("Carpenter", CarpenterCosts.values()));
            case FISH_SHOP ->
                    GameMenu.printResult(MaintainerController.printingShopProducts("FishShop", FishShopCosts.values()));
            case PIERRES_GENERAL_STORE ->
                    GameMenu.printResult(MaintainerController.printingShopProducts("GeneralStore", GeneralStoreCosts.values()));
            case JOJAMART ->
                    GameMenu.printResult(MaintainerController.printingShopProducts("JojaMart", JojaMartCosts.values()));
            case MARINES_RANCH ->
                    GameMenu.printResult(MaintainerController.printingShopProducts("Ranch", RanchCosts.values()));
            case THE_STARDROP_SALOON ->
                    GameMenu.printResult(MaintainerController.printingShopProducts("Saloon", SaloonCosts.values()));
            case null, default -> GameMenu.printResult("You are not in a store!");
        }
    }

    public static void showAvailableProducts() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (!player.isInCity()) {
            GameMenu.printResult("You are not in the city!");
            return;
        }
        Tile[][] tiles = App.getMaps().get(4).getTiles();
        switch (tiles[player.getCityX()][player.getCityY()].getType()) {
            case BLACKSMITH ->
                    GameMenu.printResult(MaintainerController.printingShopProducts2("Blacksmith", App.getCurrentGame().getBlacksmith().getItems()));
            case CARPENTERS_SHOP ->
                    GameMenu.printResult(MaintainerController.printingShopProducts2("Carpenter", App.getCurrentGame().getCarpenter().getItems()));
            case FISH_SHOP ->
                    GameMenu.printResult(MaintainerController.printingShopProducts2("FishShop", App.getCurrentGame().getFishShop().getItems()));
            case PIERRES_GENERAL_STORE ->
                    GameMenu.printResult(MaintainerController.printingShopProducts2("GeneralStore", App.getCurrentGame().getGeneralStore().getItems()));
            case JOJAMART ->
                    GameMenu.printResult(MaintainerController.printingShopProducts2("JojaMart", App.getCurrentGame().getJojaMart().getItems()));
            case MARINES_RANCH ->
                    GameMenu.printResult(MaintainerController.printingShopProducts2("Ranch", App.getCurrentGame().getRanch().getItems()));
            case THE_STARDROP_SALOON ->
                    GameMenu.printResult(MaintainerController.printingShopProducts2("Saloon", App.getCurrentGame().getSaloon().getItems()));
            case null, default -> GameMenu.printResult("You are not in a store!");
        }
    }

    public static void purchase(String name, String count){
        int amount;
        if (count != null) amount = Integer.parseInt(count);
        else amount = 1;
        Player player = App.getCurrentGame().getCurrentPlayer();

        if (player.getBuilding() == null) {
            GameMenu.printResult("You are not in a store!");
            return;
        }
        if (player.getBuilding().equals(App.getCurrentGame().getCarpenter())) {
            GameMenu.printResult("Use this command to buy items: \n" +
                    "build -a <building name> -l <x , y> (place where you want to build the building in your farm)");
            return;
        }

        if (player.getBuilding().equals(App.getCurrentGame().getRanch())) {
            GameMenu.printResult("Use this command to buy items: \n" +
                    "buy animal -a <animal> -n <name> (place where you want to build the building in your farm)");
            return;
        }

        if (App.getCurrentGame().getCurrentTime().getHour() < player.getBuilding().getStartHour() ||
            App.getCurrentGame().getCurrentTime().getHour() > player.getBuilding().getEndHour()) {

                GameMenu.printResult("Store is closed! The working our is from " + player.getBuilding().getStartHour() + " to " + player.getBuilding().getEndHour());
                return;
        }

        ShopProduct item = (ShopProduct) Item.findItemByName(name, player.getBuilding().getItems());

        if (item == null) {
            GameMenu.printResult("No item with given name found!");
            return;
        }

        if (item.getCount() < amount) {
            GameMenu.printResult("Not enough number of this Item. Only have + " + item.getCount());
            return;
        }

        if (item.getSoldToday() + amount > item.getSellLimit()) {
            GameMenu.printResult("Daily Limit Reached");
            return;
        }

        if (item.getCost() * amount > player.getMoney()) {
            GameMenu.printResult("You don't have enough money!");
            return;
        }

        if (player.getBuilding().getClass() == FishShop.class) {
            FishingPole fishingPole = null;
            for (Item item2 : player.getBackPack().getItems()) {
                if (item2.getClass() == FishingPole.class) {
                    fishingPole = (FishingPole) item2;
                    break;
                }
            }

            if (name.equals("Training Pole")) {
                if (fishingPole == null) {
                    player.getBackPack().addItem(new FishingPole(1, FishingPoleType.TRAINING_POLE));
                    player.setMoney(player.getMoney() - item.getCost());
                    if (amount == item.getCount()) player.getBuilding().removeItem(item);
                    else item.changeCount(-1  * amount);
                    item.sold(amount);
                    GameMenu.printResult("Fishing pole bought successfully");
                }
                else
                    GameMenu.printResult("You can't buy this fishing pole! Becuase you have better one!");
                return;
            }
            else if (name.equals("Bamboo Pole")) {
                if (fishingPole != null) {
                    player.getBackPack().removeItem(fishingPole);
                    player.getBackPack().addItem(new FishingPole(1, FishingPoleType.BAMBOO_POLE));
                    player.setMoney(player.getMoney() - item.getCost());
                    if (amount == item.getCount()) player.getBuilding().removeItem(item);
                    else item.changeCount(-1  * amount);
                    item.sold(amount);
                    GameMenu.printResult("Fishing pole bought successfully");
                }
                else
                    GameMenu.printResult("You can't buy this fishing pole! You should first buy training one!");
                return;
            }
            else if (name.equals("Fiberglass Pole")) {
                if (fishingPole != null && player.getFishing() / 100 >= 2) {
                    player.getBackPack().removeItem(fishingPole);
                    player.getBackPack().addItem(new FishingPole(1, FishingPoleType.FIBERGLASS_POLE));
                    player.setMoney(player.getMoney() - item.getCost());
                    if (amount == item.getCount()) player.getBuilding().removeItem(item);
                    else item.changeCount(-1  * amount);
                    item.sold(amount);
                    GameMenu.printResult("Fishing pole bought successfully");
                }
                else
                    GameMenu.printResult("You can't buy this fishing pole! Your fishing skill must be at lest 2!");
                return;
            }
            else if (name.equals("Iridium Pole")) {
                if (fishingPole != null && player.getFishing() / 100 >= 4) {
                    player.getBackPack().removeItem(fishingPole);
                    player.getBackPack().addItem(new FishingPole(1, FishingPoleType.IRIDIUM_POLE));
                    player.setMoney(player.getMoney() - item.getCost());
                    if (amount == item.getCount()) player.getBuilding().removeItem(item);
                    else item.changeCount(-1  * amount);
                    item.sold(amount);
                    GameMenu.printResult("Fishing pole bought successfully");
                }
                else
                    GameMenu.printResult("You can't buy this fishing pole! Your fishing skill must be at lest 4!");
                return;
            }

            if (amount == item.getCount()) player.getBuilding().removeItem(item);
            else item.changeCount(-1  * amount);

            player.getBackPack().addItem(new Item(amount, name, item.getCost(), ItemTexture.WOOD.getTexture()));
            item.sold(amount);
            GameMenu.printResult("Item purchased successfully");
            return;
        }

        if (player.getBuilding().getClass() == GeneralStore.class) {
            if (name.equals("Large pack")) {
                if (player.getBackPack().getType().equals(BackPackType.INITIAL_BACKPACK)) {
                    player.getBackPack().setType(BackPackType.BIG_BACKPACK);
                    player.setMoney(player.getMoney() - item.getCost() * amount);
                    item.sold(amount);
                    GameMenu.printResult("Backpack upgraded to Large Backpack successfully");
                }
                else
                    GameMenu.printResult("You can't updateGreenBar your backpack!");
                return;
            }
            if (name.equals("Deluxe pack")) {
                if (player.getBackPack().getType().equals(BackPackType.BIG_BACKPACK)) {
                    player.getBackPack().setType(BackPackType.DELUX_BACKPACK);
                    player.setMoney(player.getMoney() - item.getCost() * amount);
                    item.sold(amount);
                    GameMenu.printResult("Backpack upgraded to Delux Backpack successfully");
                }
                else
                    GameMenu.printResult("You can't updateGreenBar your backpack!");
                return;
            }

            if (player.getBackPack().getType().getCapacity() < player.getBackPack().getItems().size() + 1) {
                GameMenu.printResult("You don't have enough space in your backpack!");
                return;
            }

            if (amount == item.getCount()) player.getBuilding().removeItem(item);
            else item.changeCount(-1  * amount);

            if (item.getSeason().equals(Season.ALL) || item.getSeason().equals(App.getCurrentGame().getCurrentTime().getSeason())) {
                GeneralStoreCosts generalItem = null;
                for (GeneralStoreCosts generalItem2 : GeneralStoreCosts.values()) {
                    if (generalItem2.getName().equals(item.getName())) generalItem = generalItem2;
                }
                player.setMoney(player.getMoney() - generalItem.getSeasonPrice() * amount);
            } else {
                player.setMoney(player.getMoney() - item.getCost() * amount);
            }

            player.getBackPack().addItem(new Item(amount, name, item.getCost(), ItemTexture.WOOD.getTexture()));
            item.sold(amount);
            GameMenu.printResult("Item purchased successfully");
            return;
        }

        if (!item.getSeason().equals(Season.ALL) && !item.getSeason().equals(App.getCurrentGame().getCurrentTime().getSeason())) {
            GameMenu.printResult("You can buy " + name + " in " + item.getSeason().getName() + ", not in " + App.getCurrentGame().getCurrentTime().getSeason().getName());
            return;
        }

        if (player.getBackPack().getType().getCapacity() < player.getBackPack().getItems().size() + 1) {
            GameMenu.printResult("You don't have enough space in your backpack!");
            return;
        }

        if (amount == item.getCount()) player.getBuilding().removeItem(item);
        else item.changeCount(-1  * amount);

        player.setMoney(player.getMoney() - item.getCost() * amount);
        player.getBackPack().addItem(new Item(amount, name, item.getCost(), ItemTexture.WOOD.getTexture()));
        item.sold(amount);
        GameMenu.printResult("Item purchased successfully");
    }

    public static void cheatAddMoney(int amount){
        App.getCurrentGame().getCurrentPlayer().setMoney(App.getCurrentGame().getCurrentPlayer().getMoney() + amount);
        GameMenu.printResult("Cheart confirm successfully. Your money: " + App.getCurrentGame().getCurrentPlayer().getMoney());
    }

    public static void sell(String name, String count){
        Player player = App.getCurrentGame().getCurrentPlayer();
        Item item = Item.findItemByName(name, player.getBackPack().getItems());

        if (item == null) {
            GameMenu.printResult("No item with given name found!");
            return;
        }

        if (item.getClass() == Axe.class ||
            item.getClass() == Basket.class ||
            item.getClass() == FishingPole.class ||
            item.getClass() == Hoe.class ||
            item.getClass() == MilkPail.class ||
            item.getClass() == Pickaxe.class ||
            item.getClass() == Scythe.class ||
            item.getClass() == Shear.class) {
            GameMenu.printResult("You can't sell any tool!!!");
            return;
        }

        int amount;
        if (count != null) amount = Integer.parseInt(count);
        else amount = item.getCount();

        if (item.getCount() < amount) {
            GameMenu.printResult("Not enough number of this Item. Only have + " + item.getCount());
            return;
        }

        int dx = Math.abs(player.getX() - player.getShippingBin().getX());
        int dy = Math.abs(player.getY() - player.getShippingBin().getY());
        if (!((dx <= 1 && dy <= 1) && !(dx == 0 && dy == 0))) {
            GameMenu.printResult("You should be near the shipping bin!");
            return;
        }

        if (item.getCount() == amount) player.getBackPack().removeItem(item);
        else item.changeCount(-1  * amount);

        player.getShippingBin().addItem(item);

        GameMenu.printResult("Item sold successfully!");
    }

    public static void friendships(){
        Player player = App.getCurrentGame().getCurrentPlayer();
        GameMenu.printResult("=== Friendships ===");
        for (java.util.Map.Entry<Player, Friendship> entry : player.getFriendships().entrySet()) {
            GameMenu.printResult(entry.getKey().getUsername() + ": " + entry.getValue().getLevel() + " xp: " + entry.getValue().getXp());
        }
    }
    public static void talk(String username, String message){
        String newMessage = "\"" + message + "\"" + " => sent at: " + App.getCurrentGame().getCurrentTime().getDay() + "th " + App.getCurrentGame().getCurrentTime().getSeason().getName() + " " + App.getCurrentGame().getCurrentTime().getHour() + " o'clock";
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (User.findUserByUsername(username) == null) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }
        Player otherPlayer = User.findUserByUsername(username).getPlayer();
        if (player.equals(otherPlayer)) {
            GameMenu.printResult("You can't talk to yourself!");
            return;
        }
        player.getFriendships().get(otherPlayer).getTalkHistory().add(newMessage);
        if (!Player.areAdjacent(player, otherPlayer)) {
            GameMenu.printResult("Player is not available to talk!");
            return;
        }
        otherPlayer.getFriendships().get(player).getTalkHistory().add(newMessage);
        if (!player.getFriendships().get(otherPlayer).isTalkedToday()) {
            player.getFriendships().get(otherPlayer).addXp(20, false, false);
            otherPlayer.getFriendships().get(player).addXp(20, false, false);
            player.getFriendships().get(otherPlayer).setTalkedToday(true);
            otherPlayer.getFriendships().get(player).setTalkedToday(true);
        }
        if (otherPlayer.equals(player.getHamsar())) {
            player.setEnergy(Math.min(player.getMaxEnergy(), player.getEnergy() + 50));
            GameMenu.printResult("Sent a message to love of my life!");
        } else
            GameMenu.printResult("Message sent successfully!");
        otherPlayer.setNewTalk(player.getUsername());
    }
    public static void talkHistory(String username){
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (User.findUserByUsername(username) == null) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }
        Player otherPlayer = User.findUserByUsername(username).getPlayer();
        if (player.equals(otherPlayer)) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }
        ArrayList<String> talkHistory = player.getFriendships().get(otherPlayer).getTalkHistory();
        for (String message : talkHistory) {
            GameMenu.printResult(message);
        }
    }
    public static void gift(String username, String item, String amountx){
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (User.findUserByUsername(username) == null) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }
        Player otherPlayer = User.findUserByUsername(username).getPlayer();
        if (player.equals(otherPlayer)) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }
        if (!Player.areAdjacent(player, otherPlayer)) {
            GameMenu.printResult("Player is not available to talk!");
            return;
        }
        if (player.getFriendships().get(otherPlayer).getLevel() < 1) {
            GameMenu.printResult("Hanooz zoode!");
            return;
        }
        Item gift = Item.findItemByName(item, player.getBackPack().getItems());
        int amount = Integer.parseInt(amountx);
        if (gift == null || gift.getCount() < amount) {
            GameMenu.printResult("Not enough number of this Item");
            return;
        }
        int x = 0;
        for (Item item1 : otherPlayer.getBackPack().getItems()) {
            if (item1.getName().equals(gift.getName())) {
                Item.findItemByName(item, otherPlayer.getBackPack().getItems()).changeCount(amount);
                GameMenu.printResult("Gift sent to " + username + " successfully!");
                x = 1;
                break;
            }
        }
        if (x == 0) {
            otherPlayer.getBackPack().addItem(new Item(amount, item, gift.getPrice(), ItemTexture.WOOD.getTexture()));
            GameMenu.printResult("Gift sent to " + username + " successfully!");
        }
        if (otherPlayer.equals(player.getHamsar())) {
            player.setEnergy(Math.min(player.getMaxEnergy(), player.getEnergy() + 50));
            GameMenu.printResult("Logic taamol ba hamsar baraye gift!!!");
        }
        gift.changeCount(-amount);
        if (gift.getCount() == 0) {
            player.getBackPack().removeItem(gift);
        }
        otherPlayer.getGifts().add(new Gift(amount, item, player, (int) gift.getPrice()));
    }
    public static void giftList(){
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (Gift gift : player.getGifts()) {
            GameMenu.printResult(gift.getSentPlayer().getUsername() + " sent you " + gift.getCount() + " " + gift.getName() + " and you gave it " + gift.getRate() + " out of 5!");
        }
    }
    public static void giftHistory(String username){
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (User.findUserByUsername(username) == null) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }
        Player otherPlayer = User.findUserByUsername(username).getPlayer();
        if (player.equals(otherPlayer)) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }
        GameMenu.printResult("Gifts " + username + " sent to you: ");
        for (Gift gift : player.getGifts()) {
            if (gift.getSentPlayer().equals(otherPlayer)) {
                GameMenu.printResult(gift.getSentPlayer().getUsername() + " sent you " + gift.getCount() + " " + gift.getName());
            }
        }
        GameMenu.printResult("Gifts you sent to " + username + ": ");
        for (Gift gift : player.getGifts()) {
            if (gift.getSentPlayer().equals(player)) {
                GameMenu.printResult("You sent " + gift.getSentPlayer().getUsername() + " " + gift.getCount() + " " + gift.getName());
            }
        }
    }
    public static void hug(String username){
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (User.findUserByUsername(username) == null) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }
        Player otherPlayer = User.findUserByUsername(username).getPlayer();
        if (player.equals(otherPlayer)) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }
        if (player.getFriendships().get(otherPlayer).getLevel() < 2) {
            GameMenu.printResult("Hanooz zoode!");
            return;
        }
        if (!Player.areAdjacent(player, otherPlayer)) {
            GameMenu.printResult("Player is not available to hug!");
            return;
        }
        player.getFriendships().get(otherPlayer).addXp(60, false, false);
        otherPlayer.getFriendships().get(player).addXp(60, false, false);
        if (otherPlayer.equals(player.getHamsar())) {
            player.setEnergy(Math.min(player.getMaxEnergy(), player.getEnergy() + 50));
            GameMenu.printResult("Bia too baghalam");
        } else
            GameMenu.printResult("Nice job! You hugged each other.");
    }
    public static void flower(String username){
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (User.findUserByUsername(username) == null) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }
        Player otherPlayer = User.findUserByUsername(username).getPlayer();
        if (player.equals(otherPlayer)) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }
        if (!Player.areAdjacent(player, otherPlayer)) {
            GameMenu.printResult("Player is not available!");
            return;
        }
        if (player.getFriendships().get(otherPlayer).getLevel() < 2 || (player.getFriendships().get(otherPlayer).getLevel() == 2 &&
                player.getFriendships().get(player).getXp() < 300)) {
            GameMenu.printResult("Hanooz zoode!");
            return;
        }
        Item bouquet = Item.findItemByName("bouquet", player.getBackPack().getItems());
        if (bouquet == null) {
            GameMenu.printResult("There is no bouquet in your inventory!");
            return;
        }
        bouquet.setCount(bouquet.getCount() - 1);
        if (bouquet.getCount() == 0) {
            player.getBackPack().removeItem(bouquet);
        }
        Item otherBouquet = Item.findItemByName("bouquet", otherPlayer.getBackPack().getItems());
        if (otherBouquet == null) {
            otherPlayer.getBackPack().addItem(new Item(1, "bouquet", GeneralStoreCosts.BOUQUET.getPrice(), ItemTexture.WOOD.getTexture()));
        } else {
            otherBouquet.setCount(otherBouquet.getCount() + 1);
        }
        if (otherPlayer.equals(player.getHamsar())) {
            player.setEnergy(Math.min(player.getMaxEnergy(), player.getEnergy() + 50));
            GameMenu.printResult("Awwwwww =^-^=");
        } else
            GameMenu.printResult("One step closer!");
        player.getFriendships().get(otherPlayer).addXp(0, true, false);
        otherPlayer.getFriendships().get(player).addXp(0, true, false);
    }
    public static void askMarriage(String username, String ring){
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (User.findUserByUsername(username) == null) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }
        Player otherPlayer = User.findUserByUsername(username).getPlayer();
        if (player.equals(otherPlayer)) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }
        if (!Player.areAdjacent(player, otherPlayer)) {
            GameMenu.printResult("Player is not available!");
            return;
        }
        if (player.getGender().equals(otherPlayer.getGender())) {
            GameMenu.printResult("that's gay tbh");
            return;
        }
        if (player.getFriendships().get(otherPlayer).getLevel() < 3 &&
                player.getFriendships().get(player).getXp() < 400) {
            GameMenu.printResult("Hanooz zoode!");
            return;
        }
        Item weddingRing = Item.findItemByName("wedding ring", player.getBackPack().getItems());
        if (weddingRing == null) {
            GameMenu.printResult("There is no wedding ring in your inventory!");
            return;
        }
        otherPlayer.setAskedMarriage(player);
        GameMenu.printResult("Marriage has been asked!");
    }
    public static void startTrade() {
        GameMenu.printResult("=== Trading Menu ===");
        GameMenu.printResult("These players are ready to trade.");
        ArrayList<Player> players = App.getCurrentGame().getPlayers();
        for (Player player : players) {
            if (!player.equals(App.getCurrentGame().getCurrentPlayer())) {
                GameMenu.printResult(player.getUsername());
            }
        }
    }

    public static void trade(String username,
                             String type,
                             String item,
                             String amount,
                             String price)
    {
        Player me    = App.getCurrentGame().getCurrentPlayer();
        Player other = Optional.ofNullable(User.findUserByUsername(username))
                .map(User::getPlayer)
                .orElse(null);
        if (other == null) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }

        int itemCount  = Integer.parseInt(amount);
        int moneyCount = Integer.parseInt(price);
        int nextId     = App.getCurrentGame().getTrades().size() + 1;

        switch (type) {
            case "offer":
                // I → other: items for money
                if (!hasEnoughItem(me,   item, itemCount)) {
                    GameMenu.printResult("You don’t have enough " + item + " to offer!");
                    return;
                }
                App.getCurrentGame().getTrades().add(new Trade(
                        me,           // giver
                        other,// getter
                        "offer",
                        item,         // offeredItem
                        itemCount,    // offerAmount
                        true,         // getsMoney (yes, this trade involves money)
                        moneyCount,   // money (what the getter must pay)
                        null,         // requestedItem
                        0,            // requestAmount
                        nextId
                ));
                break;

            case "request":
                // I ← other: money for items
                if (me.getMoney() < moneyCount) {
                    GameMenu.printResult("You don’t have enough money to request that!");
                    return;
                }
                App.getCurrentGame().getTrades().add(new Trade(
                        other,        // giver (they must have the items)
                        me,
                        "request",
                        null,         // offeredItem
                        0,            // offerAmount
                        true,         // getsMoney
                        moneyCount,   // money (what I will pay)
                        item,         // requestedItem
                        itemCount,    // requestAmount
                        nextId
                ));
                break;

            default:
                GameMenu.printResult("Invalid trade type: " + type);
                return;
        }

        GameMenu.printResult("Trade #" + nextId + " created.");
    }

    /**
     * Create an item↔item trade:
     *  - “offer”: you give item A and ask for item B
     *  - “request”: you ask for item A and offer item B
     */
    public static void tradeProducts(String username,
                                     String type,
                                     String item,
                                     String amount,
                                     String targetItem,
                                     String targetAmount)
    {
        Player me    = App.getCurrentGame().getCurrentPlayer();
        Player other = Optional.ofNullable(User.findUserByUsername(username))
                .map(User::getPlayer)
                .orElse(null);
        if (other == null) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }

        int offerCount   = Integer.parseInt(amount);
        int requestCount = Integer.parseInt(targetAmount);
        int nextId       = App.getCurrentGame().getTrades().size() + 1;

        switch (type) {
            case "offer":
                // I → other: item for targetItem
                if (!hasEnoughItem(me, item, offerCount)) {
                    GameMenu.printResult("You don’t have enough " + item + " to offer!");
                    return;
                }
                App.getCurrentGame().getTrades().add(new Trade(
                        me,              // giver
                        other,
                        "offer",
                        item,            // offeredItem
                        offerCount,      // offerAmount
                        false,           // getsMoney (no money involved)
                        0,               // money
                        targetItem,      // requestedItem
                        requestCount,    // requestAmount
                        nextId
                ));
                break;

            case "request":
                // I ← other: targetItem for item
                if (!hasEnoughItem(other, item, offerCount)) {
                    GameMenu.printResult(
                            other.getUsername() + " doesn’t have enough " + item + "!"
                    );
                    return;
                }
                App.getCurrentGame().getTrades().add(new Trade(
                        other,           // giver
                        me,
                        "request",
                        item,            // offeredItem (from other)
                        offerCount,      // offerAmount
                        false,           // getsMoney
                        0,               // money
                        targetItem,      // requestedItem (I will send)
                        requestCount,    // requestAmount
                        nextId
                ));
                break;

            default:
                GameMenu.printResult("Invalid trade type: " + type);
        }
        GameMenu.printResult("Trade #" + nextId + " created.");
    }

    // Helper to check item availability
    private static boolean hasEnoughItem(Player p, String name, int count) {
        Item it = Item.findItemByName(name, p.getBackPack().getItems());
        return it != null && it.getCount() >= count;
    }

    public static void tradeList(){
        Player player = App.getCurrentGame().getCurrentPlayer();
        int i = 1;
        for (Trade trade : App.getCurrentGame().getTrades()) {
            if (trade.getType().equals("offer") && !trade.isGetsMoney()) {
                if (trade.getGetter().equals(player)) {
                    GameMenu.printResult(i++ + ". " + trade.getGiver().getUsername() + " offered " + trade.getGetter().getUsername() + " " +  trade.getOfferAmount() + " " + trade.getOfferedItem() + " in exchange for " + trade.getRequestAmount() + " " + trade.getRequestedItem() + " with id of: " + trade.getId());
                }
            } else if (trade.getType().equals("request") && !trade.isGetsMoney()) {
                if (trade.getGiver().equals(player)) {
                    GameMenu.printResult(i++ + ". " + trade.getGetter().getUsername() + " requests " + trade.getRequestAmount() + " " + trade.getRequestedItem() + " in exchange for " + trade.getOfferAmount() + " " + trade.getOfferedItem() + " from " + trade.getGiver().getUsername() + " with id of: " + trade.getId());
                }
            } else if (trade.getType().equals("offer") && trade.isGetsMoney()) {
                if (trade.getGetter().equals(player)) {
                    GameMenu.printResult(i++ + ". " + trade.getGiver().getUsername() + " offered " + trade.getGetter().getUsername() + " " + trade.getOfferAmount() + " " + trade.getOfferedItem() + " for " + trade.getMoney() + "$ with id of: " + trade.getId());
                }
            } else if (trade.getType().equals("request") && trade.isGetsMoney()) {
                if (trade.getGiver().equals(player)) {
                    GameMenu.printResult(i++ + ". " + trade.getGetter().getUsername() + " requests " + trade.getRequestedItem() + " for " + trade.getMoney() + "$ from " + trade.getGiver().getUsername() + " with id of: " + trade.getId());
                }
            }
        }
        if (i == 0) {
            GameMenu.printResult("There is no trade for you!");
        }
    }
    public static void tradeResponse(String id, String answer) {
        Player me = App.getCurrentGame().getCurrentPlayer();
        int tradeId = Integer.parseInt(id);
        ArrayList<Trade> trades = App.getCurrentGame().getAllTrades();

        switch (answer) {
            case "-accept":
                for (Iterator<Trade> it = App.getCurrentGame().getTrades().iterator(); it.hasNext(); ) {
                    Trade t = it.next();
                    if (t.getId() != tradeId) continue;
                    if (!t.getGiver().equals(me) && !t.getGetter().equals(me)) continue;

                    Player giver  = t.getGiver();
                    Player getter = t.getGetter();

                    // 1) ITEM ↔ ITEM
                    if (!t.isGetsMoney()
                            && t.getOfferedItem()   != null
                            && t.getRequestedItem()!= null)
                    {
                        transferItem(getter, giver,
                                t.getRequestedItem(), t.getRequestAmount());
                        transferItem(giver, getter,
                                t.getOfferedItem(), t.getOfferAmount());


                        // 2) ITEM (giver) ↔ MONEY (getter)
                    } else if ( t.isGetsMoney()
                            && t.getOfferedItem() != null
                            && t.getMoney()       > 0)
                    {
                        // giver sends items → getter
                        transferItem(giver, getter,
                                t.getOfferedItem(), t.getOfferAmount());
                        // getter pays money → giver
                        transferMoney(getter, giver,
                                t.getMoney());

                        // 3) MONEY (giver) ↔ ITEM (getter)
                    } else if ( t.isGetsMoney()
                            && t.getRequestedItem() != null
                            && t.getMoney()          > 0)
                    {
                        // giver pays money → getter
                        transferMoney(giver, getter,
                                t.getMoney());
                        // getter sends item → giver
                        transferItem(getter, giver,
                                t.getRequestedItem(),
                                t.getRequestAmount());

                    } else {
                        throw new IllegalStateException(
                                "Trade #" + tradeId + " has invalid configuration"
                        );
                    }
                    t.setAccepted(true);
                    trades.add(t);
                    it.remove();
                    t.getGiver().getFriendships().get(t.getGetter()).addXp(50, false, false);
                    t.getGetter().getFriendships().get(t.getGiver()).addXp(50, false, false);
                    GameMenu.printResult("Trade #" + tradeId + " completed.");
                    break;
                }
                break;

            case "-reject":
                for (Iterator<Trade> it = App.getCurrentGame().getTrades().iterator(); it.hasNext(); ) {
                    Trade t = it.next();
                    if (t.getId() == tradeId
                            && (t.getGiver().equals(me) || t.getGetter().equals(me)))
                    {
                        t.setAccepted(false);
                        trades.add(t);
                        it.remove();
                        t.getGiver().getFriendships().get(t.getGetter()).addXp(-30, false, false);
                        t.getGetter().getFriendships().get(t.getGiver()).addXp(-30, false, false);
                        GameMenu.printResult("Trade #" + tradeId + " rejected.");
                        break;
                    }
                }
                break;

            default:
                GameMenu.printResult("Unknown response: " + answer);
        }
    }

    private static void transferItem(Player from, Player to, String itemName, int count) {
        // Remove from source
        Item src = Item.findItemByName(itemName, from.getBackPack().getItems());
        if (src == null || src.getCount() < count) {
            throw new IllegalStateException(from.getUsername() + " lacks " + count + "x " + itemName);
        }
        src.setCount(src.getCount() - count);
        if (src.getCount() == 0) {
            from.getBackPack().getItems().remove(src);
        }

        // Add to destination
        Item dst = Item.findItemByName(itemName, to.getBackPack().getItems());
        if (dst == null) {
            // assume constructor: Item(count, name, price)
            to.getBackPack().getItems().add(new Item(count, itemName, src.getPrice(), ItemTexture.WOOD.getTexture()));
        } else {
            dst.setCount(dst.getCount() + count);
        }
    }
    public static void tradeHistory() {
        Player me = App.getCurrentGame().getCurrentPlayer();
        List<Trade> trades = App.getCurrentGame().getAllTrades();

        if (trades.isEmpty()) {
            GameMenu.printResult("No trades has been submitted.");
            return;
        }

        for (Trade t : trades) {
            boolean iAmGiver  = t.getGiver().equals(me);
            boolean iAmGetter = t.getGetter().equals(me);
            if (!iAmGiver && !iAmGetter) {
                continue;  // skip unrelated
            }

            String role      = iAmGiver  ? "You offered" : "You requested";
            Player counter   = iAmGiver  ? t.getGetter() : t.getGiver();
            StringBuilder s  = new StringBuilder();
            s.append("Trade #").append(t.getId()).append(": ").append(role).append(" ");

            // 1) ITEM ↔ MONEY
            if (t.isGetsMoney() && t.getOfferedItem() != null) {
                // giver gives item, getter gives money
                s.append(t.getOfferAmount())
                        .append("× ").append(t.getOfferedItem())
                        .append(" ↔ $").append(t.getMoney());

                // 2) MONEY ↔ ITEM
            } else if (t.isGetsMoney() && t.getRequestedItem() != null) {
                // giver gives money, getter gives item
                s.append("$").append(t.getMoney())
                        .append(" ↔ ")
                        .append(t.getRequestAmount())
                        .append("× ").append(t.getRequestedItem());

                // 3) ITEM ↔ ITEM
            } else if (!t.isGetsMoney()
                    && t.getOfferedItem()   != null
                    && t.getRequestedItem() != null) {
                s.append(t.getOfferAmount())
                        .append("× ").append(t.getOfferedItem())
                        .append(" ↔ ")
                        .append(t.getRequestAmount())
                        .append("× ").append(t.getRequestedItem());

                // fallback (shouldn’t happen)
            } else {
                s.append("[Invalid trade data]");
            }

            s.append(" with ").append(counter.getUsername())
                    .append(" [Pending]");
            GameMenu.printResult(s.toString());
        }
    }
    private static void transferMoney(Player from, Player to, int amount) {
        from.adjustMoney(-amount);
        to.adjustMoney(+amount);
    }
    public static void meetNPC(String name) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        for(NPC npc : App.getCurrentGame().getNPCs()){
            if(npc.getName().equals(name)){
                if(npc.getTile().getX() - 1 <= player.getCityX() && player.getCityX() <= npc.getTile().getX() + 1 &&
                        npc.getTile().getX() - 1 <= player.getCityY() && player.getCityY() <= npc.getTile().getY() + 1){
                    npc.talk();
                    if(!player.getNPCMeetToday().get(npc)){
                        player.getNPCMeetToday().put(npc, true);
                        player.getFriendshipsNPC().put(npc,player.getFriendshipsNPC().get(npc) + 20);
                        if(player.getFriendshipsNPC().get(npc) >= 200 && player.getFriendshipsNPC().get(npc) < 220 && !npc.isQuest2()){
                            player.getActivatedQuestNPC().get(npc).add(2);
                        }
                    }
                } else {
                    GameMenu.printResult("You are too far!");
                }
                return;
            }
        }
        GameMenu.printResult("Wrong name!");
    }
    public static String giftNPC(String name, String item) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        for(NPC npc : App.getCurrentGame().getNPCs()){
            if(npc.getName().equals(name)){
                Item gift = Item.findItemByName(item, player.getBackPack().getItems());
                if(gift == null){
                    return "You don't have this gift!";
                } else {
                    if(gift.getCount() == 1){
                        player.getBackPack().removeItem(gift);
                    } else {
                        gift.setCount(gift.getCount() - 1);
                    }
                    int liked = 1;
                    for(String favorite : npc.getDetail().favoriteGiftsName){
                        if (favorite.equals(gift.getName())) {
                            liked = 4;
                            break;
                        }
                    }
                    player.getFriendshipsNPC().put(npc,player.getFriendshipsNPC().get(npc) + 50 * liked);
                    if(liked == 1){
                        if(player.getFriendshipsNPC().get(npc) >= 200 && player.getFriendshipsNPC().get(npc) < 250 && !npc.isQuest2()){
                            player.getActivatedQuestNPC().get(npc).add(2);
                        }
                    } else {
                        if(player.getFriendshipsNPC().get(npc) >= 200 && player.getFriendshipsNPC().get(npc) < 400 && !npc.isQuest2()){
                            player.getActivatedQuestNPC().get(npc).add(2);
                        }
                    }
                    return "You gave " + item + " to " + npc.getName();
                }
            }
        }
        return "Wrong name!";
    }
    public static void friendshipNPCList() {
        for(NPC npc : App.getCurrentGame().getNPCs()){
            GameMenu.printResult("Friendship rate with " + npc.getName() + " : " + App.getCurrentGame().getCurrentPlayer().getFriendshipsNPC().get(npc) + " leve: " + App.getCurrentGame().getCurrentPlayer().getFriendshipsNPC().get(npc) /200);
        }
    }
    public static void questList() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        int counter = 1;
        for(NPC npc : App.getCurrentGame().getNPCs()){
            GameMenu.printResult(npc.getName() + " quests :");
            StringBuilder message = new StringBuilder();
            for(Integer active : player.getActivatedQuestNPC().get(npc)){
                if(npc.getName().equals("Sebastian")){
                    if (active.equals(1)) {
                        message.append(counter++ + "- ");
                        message.append("Reward :");
                        message.append("50 iron ore");
                        message.append("\n");
                        message.append("    Reward :");
                        message.append("2 diamond");
                    } else if (active.equals(2)) {
                        message.append(counter++ + "- ");
                        message.append("Reward :");
                        message.append("pumpkin pie");
                        message.append("\n");
                        message.append("    Reward :");
                        message.append("5000 coin");
                    } else if (active.equals(3)) {
                        message.append(counter++ + "- ");
                        message.append("Reward :");
                        message.append("150 stones");
                        message.append("\n");
                        message.append("    Reward :");
                        message.append("50 quartz");
                    }
                } else if(npc.getName().equals("Abigail")){
                    if (active.equals(1)) {
                        message.append(counter++ + "- ");
                        message.append("Reward :");
                        message.append("1 gold bar");
                        message.append("\n");
                        message.append("    Reward :");
                        message.append("1 friendship level");
                    } else if (active.equals(2)) {
                        message.append(counter++ + "- ");
                        message.append("Reward :");
                        message.append("1 pumpkin");
                        message.append("\n");
                        message.append("    Reward :");
                        message.append("500 coin");
                    } else if (active.equals(3)) {
                        message.append(counter++ + "- ");
                        message.append("Reward :");
                        message.append("50 wheat");
                        message.append("\n");
                        message.append("    Reward :");
                        message.append("1 Iridium Sprinkler");
                    }
                } else if (npc.getName().equals("Harvey")){
                    if (active.equals(1)) {
                        message.append(counter++ + "- ");
                        message.append("Reward :");
                        message.append("12 of any plant");
                        message.append("\n");
                        message.append("    Reward :");
                        message.append("750 coin");
                    } else if (active.equals(2)) {
                        message.append(counter++ + "- ");
                        message.append("Reward :");
                        message.append("1 salmon");
                        message.append("\n");
                        message.append("    Reward :");
                        message.append("1 friendship level");
                    } else if (active.equals(3)) {
                        message.append(counter++ + "- ");
                        message.append("Reward :");
                        message.append("1 bottle of wine");
                        message.append("\n");
                        message.append("    Reward :");
                        message.append("5 salad");
                    }
                } else if (npc.getName().equals("Leah")){
                    if (active.equals(1)) {
                        message.append(counter++ + "- ");
                        message.append("Reward :");
                        message.append("10 wood");
                        message.append("\n");
                        message.append("    Reward :");
                        message.append("500 coin");
                    } else if (active.equals(2)) {
                        message.append(counter++ + "- ");
                        message.append("Reward :");
                        message.append("1 salmon");
                        message.append("\n");
                        message.append("    Reward :");
                        message.append("1 cooking recipe (dinner salmon)");
                    } else if (active.equals(3)) {
                        message.append(counter++ + "- ");
                        message.append("Reward :");
                        message.append("200 wood");
                        message.append("\n");
                        message.append("    Reward :");
                        message.append("3 deluxe scarecrows");
                    }
                } else if (npc.getName().equals("Robin")){
                    if (active.equals(1)) {
                        message.append(counter++ + "- ");
                        message.append("Reward :");
                        message.append("80 wood");
                        message.append("\n");
                        message.append("    Reward :");
                        message.append("1000 coin");
                    } else if (active.equals(2)) {
                        message.append(counter++ + "- ");
                        message.append("Reward :");
                        message.append("10 iron bar");
                        message.append("\n");
                        message.append("    Reward :");
                        message.append("3 beehives");
                    } else if (active.equals(3)) {
                        message.append(counter++ + "- ");
                        message.append("Reward :");
                        message.append("1000 wood");
                        message.append("\n");
                        message.append("    Reward :");
                        message.append("25000 coin");
                    }
                }
                message.append("\n");
            }
            GameMenu.printResult(message.toString());
        }
    }

    public static String questInfo(NPC npc, Integer active) {
            StringBuilder message = new StringBuilder();
                if(npc.getName().equals("Sebastian")){
                    if (active.equals(1)) {
                        message.append("50 iron ore");
                        message.append("    ");
                        message.append("2 diamond");
                    } else if (active.equals(2)) {
                        message.append("pumpkin pie");
                        message.append("    ");
                        message.append("5000 coin");
                    } else if (active.equals(3)) {
                        message.append("150 stones");
                        message.append("    ");
                        message.append("50 quartz");
                    }
                } else if(npc.getName().equals("Abigail")){
                    if (active.equals(1)) {
                        message.append("1 gold bar");
                        message.append("    ");
                        message.append("1 friendship level");
                    } else if (active.equals(2)) {
                        message.append("1 pumpkin");
                        message.append("    ");
                        message.append("500 coin");
                    } else if (active.equals(3)) {
                        message.append("50 wheat");
                        message.append("    ");
                        message.append("1 Iridium Sprinkler");
                    }
                } else if (npc.getName().equals("Harvey")){
                    if (active.equals(1)) {
                        message.append("12 of any plant");
                        message.append("    ");
                        message.append("750 coin");
                    } else if (active.equals(2)) {
                        message.append("1 salmon");
                        message.append("    ");
                        message.append("1 friendship level");
                    } else if (active.equals(3)) {
                        message.append("1 bottle of wine");
                        message.append("    ");
                        message.append("5 salad");
                    }
                } else if (npc.getName().equals("Leah")){
                    if (active.equals(1)) {
                        message.append("10 wood");
                        message.append("    ");
                        message.append("500 coin");
                    } else if (active.equals(2)) {
                        message.append("1 salmon");
                        message.append("    ");
                        message.append("1 cooking recipe (dinner salmon)");
                    } else if (active.equals(3)) {
                        message.append("200 wood");
                        message.append("    ");
                        message.append("3 deluxe scarecrows");
                    }
                } else if (npc.getName().equals("Robin")){
                    if (active.equals(1)) {
                        message.append("80 wood");
                        message.append("    ");
                        message.append("1000 coin");
                    } else if (active.equals(2)) {
                        message.append("10 iron bar");
                        message.append("    ");
                        message.append("3 beehives");
                    } else if (active.equals(3)) {
                        message.append("1000 wood");
                        message.append("    ");
                        message.append("25000 coin");
                    }
                }
                return (message.toString());
            }

    public static void questFinish(String indexString) {
        int index = Integer.parseInt(indexString);
        Player player = App.getCurrentGame().getCurrentPlayer();
        for(NPC npc : App.getCurrentGame().getNPCs()){
            int counter = 0;
            if(npc.getTile().getX() - 1 <= player.getCityX() && player.getCityX() <= npc.getTile().getX() + 1 &&
                    npc.getTile().getX() - 1 <= player.getCityY() && player.getCityY() <= npc.getTile().getY() + 1) {
                for(NPC npcQuest : App.getCurrentGame().getNPCs()){
                    for (Integer questCounter : player.getActivatedQuestNPC().get(npcQuest)){
                        counter++;
                        if(counter == index){
                            if(questCounter == 1){
                                npcQuest.quest1();
                            } else if(questCounter == 2){
                                npcQuest.quest2();
                            } else if(questCounter == 3){
                                npcQuest.quest3();
                            }
                            return;
                        }
                    }
                }
                GameMenu.printResult("Out of bound index!");
                return;
            }
        }
        GameMenu.printResult("You have to be next to the NPC you want!");
    }

    public static void printCityMap() {
        App.getMaps().get(4).printCitysMap();
    }
    public static void printPlayerFullMap(){
        App.getCurrentGame().getCurrentPlayer().getMap().printFullMap();
    }
    public static void printGreatMap(){
        GameMenuController.printCityMap();
        GameMenu.printResult("");
        Player temp = App.getCurrentGame().getCurrentPlayer();
        for(Player player : App.getCurrentGame().getPlayers()){
            App.getCurrentGame().setCurrentPlayer(player);
            GameMenuController.printPlayerFullMap();
            GameMenu.printResult("");
        }
        App.getCurrentGame().setCurrentPlayer(temp);
    }
    public static void goToCity(){
        Player player = App.getCurrentGame().getCurrentPlayer();

        if (!player.isInCity()) {
            player.setInCity(true);
            Map map = App.getMaps().get(4); // City map
            int x = 0;
            int y = 0;

            while (true) {
                Tile tile = map.getTiles()[x][y];

                if ((tile.getType().equals(TileTypes.GRASS) || tile.getType().equals(TileTypes.DIRT))
                        && tile.getItem() == null) {

                    boolean occupied = false;
                    for (Player otherPlayer : App.getCurrentGame().getPlayers()) {
                        if (otherPlayer != player && otherPlayer.isInCity()) {
                            if (otherPlayer.getCityX() == x && otherPlayer.getCityY() == y) {
                                occupied = true;
                                break;
                            }
                        }
                    }

                    if (!occupied) {
                        player.setCityX(x);
                        player.setCityY(y);
                        player.setX(-1);
                        player.setY(-1);
                        GameMenu.printResult("You are in the city now!");
                        App.getCurrentGame().setCurrentMap(App.getMaps().get(4));
                        return;
                    }

                    // ❗ If occupied, try next tile (x++)
                }

                x++;
                if (x == 80) { // Assuming 80 is width
                    y++;
                    x = 0;
                }

                // Optional: prevent infinite loop
                if (y >= map.getTiles()[0].length) {
                    GameMenu.printResult("No available city tile found.");
                    return;
                }
            }

        } else {
            GameMenu.printResult("You are already in the city!");
        }
    }
    public static void goToFarm() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (player.isInCity()) {
            player.setInCity(false); // ✅ leaving the city

            // 🔄 Switch to the player's personal farm map
            Tile[][] tiles = player.getMap().getTiles();

            int x = 0;
            int y = 0;

            while (true) {
                Tile tile = tiles[x][y];

                if ((tile.getType().equals(TileTypes.GRASS) || tile.getType().equals(TileTypes.DIRT))
                        && tile.getItem() == null) {
                    player.setX(x);
                    player.setY(y);
                    player.setCityX(-1);
                    player.setCityY(-1);
                    GameMenu.printResult("You are in your farm now!");
                    App.getCurrentGame().setCurrentMap(player.getMap());
                    return;
                }

                x++;
                if (x == tiles.length) {
                    x = 0;
                    y++;
                    if (y == tiles[0].length) {
                        GameMenu.printResult("No valid tile found on your farm!");
                        return;
                    }
                }
            }

        } else {
            GameMenu.printResult("You are already in your farm!");
        }
    }

    public static void exitGame(){
        for(Player player : App.getCurrentGame().getPlayers()){
            if(player.getMoney() > player.getUser().getMaxMoney()){
                player.getUser().setMaxMoney(player.getMoney());
            }
            player.getUser().changeInGame();
        }
        App.setCurrentGame(null);
//        App.setCurrentMenu(Menus.MainMenu);
        GameMenu.printResult("You exited the game!");
        GameMenu.printResult("Redirecting to AP.group30.StardewValley.Main Menu");
    }

}
