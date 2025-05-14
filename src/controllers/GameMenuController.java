package controllers;

import models.Animals.*;
import models.App;
import models.Buildings.*;
import models.Items.Gift;
import models.Items.Products.*;
import models.Items.Products.ShopProducts.ShopProduct;
import models.Items.Item;
import models.Items.Foods.Food;
import models.Items.Foods.FoodType;
import models.Items.IndustrialProducts.IndustrialProductType;
import models.Items.IndustrialProducts.IndustrialProduct;
import models.Items.Tools.*;
import models.Maps.Map;
import models.Maps.PathFinder;
import models.Maps.Tile;
import models.Maps.TileTypes;
import models.Maps.Weather;
import models.Players.Friendship;
import models.Players.NPC.NPC;
import models.Players.NPC.NPCDetail;
import models.Players.Player;
import models.Players.Trade;
import models.Users.User;
import views.GameMenu;
import views.RegisterMenu;
import java.util.*;

public class GameMenuController {
    public static void greenHouseBuild() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        Item wood = Item.findItemByName("wood", player.getBackPack().getItems());
        if (wood == null) {
            GameMenu.printResult("Not enough wood!");
        }
        if (wood.getCount() < 500) {
            GameMenu.printResult("Not enough wood!");
            return;
        }
        if (player.getMoney() < 1000) {
            GameMenu.printResult("Not enough money!");
            return;
        }
        player.setMoney(player.getMoney() - 1000);
        wood.setCount(wood.getCount() - 500);
        player.getMap().createGreenHouse();
    }

    public static void walk(String xStr, String yStr, Scanner scanner) {
        int x = Integer.parseInt(xStr);
        int y = Integer.parseInt(yStr);

        Tile[][] map = App.getCurrentGame().getCurrentPlayer().getMap().getTiles();
        Player player = App.getCurrentGame().getCurrentPlayer();
        Tile start = map[player.getX()][player.getY()];
        Tile target = map[x][y];

        List<Tile> path = PathFinder.findPath(map, start, target);

        if (path == null) {
            Tile alt = PathFinder.findNearestReachable(map, start, target);
            if (alt != null) {
                path = PathFinder.findPath(map, start, alt);
                GameMenu.printResult("Destination blocked.");
                return;
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
        if (player.getEnergy() <= 0) {
            player.setPassedOut(true);
            GameMenu.printResult("Player passed out!");
            NewGameController.NextTurn(scanner);
        }
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
        for (Item item : App.getCurrentGame().getCurrentPlayer().getBackPack().getItems()) {
            GameMenu.printResult(item.getName() + " : " + item.getCount());
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
    public static void upgradeTools(String name) {
        // TODO
    }
    public static void toolUse(String direction) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        Item wield = player.getWield();
        Tile[][] tiles = App.getCurrentGame().getCurrentPlayer().getMap().getTiles();


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

        if(wield instanceof Hoe){
            int energyNeeded = ((Hoe) wield).getType().getEnergyUsed();
            if(player.getFarming() == 450){
                energyNeeded -= 1;
            }
            if(player.getEnergy() > energyNeeded){
                if(targetTile.getType().equals(TileTypes.DIRT) || targetTile.getType().equals(TileTypes.GRASS)){
                    targetTile.setType(TileTypes.PLANTABLE);
                    GameMenu.printResult("The ground is now soft and ready to plant.");
                } else {
                    GameMenu.printResult("Not possible.");
                }
                player.setEnergy(player.getEnergy() - energyNeeded);
            }else{
                GameMenu.printResult("You don't have enough energy!");
            }

        }else if(wield instanceof Pickaxe){
            int energyNeeded = ((Pickaxe) wield).getType().getEnergyUsed();
            if(player.getMining() == 450){
                energyNeeded -= 1;
            }

            if(player.getEnergy() > energyNeeded){
                if(targetTile.getType().equals(TileTypes.PLANTABLE)){
                    targetTile.setType(TileTypes.DIRT);
                    GameMenu.printResult("Done!");
                } else if(targetTile.getType().equals(TileTypes.QUARRY)){
                    if(targetTile.getItem() != null) {
                        if (targetTile.getItem() instanceof ForagingMineral) {
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
                } else if(targetTile.isWalkable() && targetTile.getItem() != (null)){ // Change TODO
                    GameMenu.printResult("Poof! " + targetTile.getItem().getName() + " crumbled into nothing.");
                    targetTile.setItem(null);
                } else {
                    GameMenu.printResult("You swing your pickaxe, but nothing happens.");
                    if(energyNeeded > 0){
                        energyNeeded -= 1;
                    }
                }
                player.setEnergy(player.getEnergy() - energyNeeded);
            }else{
                GameMenu.printResult("You don't have enough energy!");
            }
        } else if(wield instanceof Axe){
            int energyNeeded = ((Axe) wield).getType().getEnergyUsed();
            if(player.getForaging() == 450){
                energyNeeded -= 1;
            }
            if(player.getEnergy() > energyNeeded){
                if(targetTile.getItem() != null) {
                    if (targetTile.getItem() instanceof Tree || ((ForgingSeed)targetTile.getItem()).getType().getTreeOrCrop() == 1) {
                        Item wood = new Item(12, "wood", 10);
                        Item sap = new Item(2, "sap", 10);

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
                                newSap.setCount(newSap.getCount() + 1);
                            } else {
                                player.getBackPack().addItem(sap);
                                newWood.setCount(newWood.getCount() + 1);
                            }
                        } else {
                            newWood.setCount(newWood.getCount() + 1);
                            newSap.setCount(newSap.getCount() + 1);
                        }
                        if (targetTile.getItem() != null && targetTile.getItem() instanceof ForgingSeed) {
                            if (((ForgingSeed) targetTile.getItem()).getType().getTreeOrCrop() == 1) {
                                targetTile.setItem(null);
                                targetTile.setCrop(null);
                                targetTile.setReadyToHarvest(false);
                                targetTile.setPlanted(false);
                                targetTile.setType(TileTypes.DIRT);
                            }
                        }

                        targetTile.setItem(null);
                        GameMenu.printResult("You chop down the tree and collect 12 wood and 2 sap.");
                    } else if (targetTile.getItem().equals(new Item(1, "Wood", 10))) {
                        targetTile.setItem(null);
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
                player.setEnergy(player.getEnergy() - energyNeeded);
            }else{
                GameMenu.printResult("You don't have enough energy!");
            }
        }else if(wield instanceof Basket){
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
                        if (targetTile.getItem() instanceof ForgingSeed) {
                            targetTile.getCrop().setWateredToday(true);
                            GameMenu.printResult("You give the plants a refreshing splash!");
                        } else {
                            GameMenu.printResult("You spill some water on the ground.");
                        }

                    } else {
                        GameMenu.printResult("You spilled some water on the ground.");
                    }
                }
                player.setEnergy(player.getEnergy() - energyNeeded);
            }else{
                GameMenu.printResult("You don't have enough energy!");
            }
        } else if(wield instanceof FishingPole){
            // darya
        } else if(wield instanceof Scythe){
            if(player.getEnergy() > 2){
                if(targetTile.isReadyToHarvest()){
                    ForgingSeed seed = (ForgingSeed) targetTile.getItem();
                    if (seed.getType().getTreeOrCrop() == 1) {
                        GameMenu.printResult("You collected " + targetTile.getCrop().getName() + " and added it to your backpack!");
                        Item newItem = Item.findItemByName(targetTile.getCrop().getName(), player.getBackPack().getItems());
                        if(newItem != null){
                            newItem.setCount(newItem.getCount() + targetTile.getCrop().getCount());
                        } else {
                            if(player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()){
                                GameMenu.printResult("You don't have enough space in your backpack!");
                                return;
                            } else{
                                player.getBackPack().addItem(targetTile.getCrop());
                            }
                        }
                        targetTile.setReadyToHarvest(false);
                        targetTile.getCrop().setDaysPassed(0);
                        targetTile.getCrop().setCurrentStage(0);
                        targetTile.getCrop().setDaysNotWatered(0);
                    } else {
                        GameMenu.printResult("You harvested " + targetTile.getCrop().getName() + " and added it to your backpack!");
                        Item newItem = Item.findItemByName(targetTile.getCrop().getName(), player.getBackPack().getItems());
                        targetTile.setPlanted(false);
                        if (newItem != null) {
                            newItem.setCount(newItem.getCount() + targetTile.getCrop().getCount());
                        } else {
                            if (player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()) {
                                GameMenu.printResult("You don't have enough space in your backpack!");
                                return;
                            } else {
                                player.getBackPack().addItem(targetTile.getCrop());
                            }
                        }
                        if (targetTile.getCrop() instanceof GiantCrop) {
                            Tile[] tiles1 = ((GiantCrop) targetTile.getCrop()).getTiles();
                            for (Tile tile : tiles1) {
                                tile.setReadyToHarvest(false);
                                tile.setCrop(null);
                                tile.setItem(null);
                                tile.setGiantCrop(false);
                                tile.setPlanted(false);
                            }
                        } else {
                            targetTile.setReadyToHarvest(false);
                            targetTile.setCrop(null);
                            targetTile.setItem(null);
                            targetTile.setGiantCrop(false);
                        }
                    }

                } else if(targetTile.getType().equals(TileTypes.GRASS)){
                    targetTile.setType(TileTypes.DIRT);
                    GameMenu.printResult("Tile type changed to Dirt!");
                } else {
                    GameMenu.printResult("Nothing here to harvest!");
                }
                player.setEnergy(player.getEnergy() - 2);
            }else{
                GameMenu.printResult("You don't have enough energy!");
            }
        } else if(wield instanceof MilkPail){
            if(player.getEnergy() > 4){
                // shir bedoshe TODO
                player.setEnergy(player.getEnergy() - 4);
            }else{
                GameMenu.printResult("You don't have enough energy!");
            }
        } else if(wield instanceof Shear){
            if(player.getEnergy() > 4){
                // pashm bezane TODO
                player.setEnergy(player.getEnergy() - 4);
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
        sb.append("Regrowth Time: " + craft.getName() + "\n");
        sb.append("Base Sell Price: " + craft.getBaseSellPrice() + "\n");
        sb.append("Is Edible: " + craft.isEdible() + "\n");
        sb.append("Base Energy: " + craft.getEnergy() + "\n");
        sb.append("Base Health: " + craft.getHealth() + "\n");
        sb.append(MaintainerController.arrayListToString("Season", craft.getSeasons()));
        sb.append("Can Become Giant: " + craft.isCanBecomeGiant());
        RegisterMenu.printResult(sb.toString());
    }
    public static void plant(String seed1, String direction) {
        ForgingSeed seed = (ForgingSeed) ForgingSeed.findItemByName(seed1, App.getCurrentGame().getCurrentPlayer().getBackPack().getItems());
        Player player = App.getCurrentGame().getCurrentPlayer();
        Tile[][] tiles = App.getCurrentGame().getCurrentPlayer().getMap().getTiles();

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
        // Check for plantable tile
        Tile targetTile = tiles[newX][newY];
        if (!targetTile.getType().equals(TileTypes.PLANTABLE)) {
            GameMenu.printResult("Tile is not plantable!");
            return;
        }
        Item item = Item.findItemByName(seed1, App.getCurrentGame().getCurrentPlayer().getBackPack().getItems());
        if (item == null) {
            GameMenu.printResult("No item with this name found in your backpack!");
            return;
        }
        if (item.getCount() > 0) {
            if (targetTile.isHarvestable() && targetTile.getItem() == null) {
                targetTile.setItem(seed);
                seed.setFertilized(false);
                item.setCount(item.getCount() - 1);
                targetTile.setPlanted(true);
                if (item.getCount() == 0) {
                    player.getBackPack().getItems().remove(item);
                }
                tiles[newX][newY].setReadyToHarvest(false);
                tiles[newX][newY].setCrop(seed.getCrop());

                GameMenu.printResult("Planted " + seed.getName() + " at (" + newX + ", " + newY + ")");
                CropType plantedCrop = seed.getCrop().getType();

                int[][] squareOffsets = {
                        {0, 0},       // current tile is top-left of square
                        {-1, 0},      // current tile is top-right
                        {0, -1},      // current tile is bottom-left
                        {-1, -1}      // current tile is bottom-right
                };
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
                            for (Tile tile : tiles1) {
                                if (giantCrop.getCurrentStage() < tile.getCrop().getCurrentStage()) {
                                    giantCrop.setCurrentStage(tile.getCrop().getCurrentStage());
                                    if (giantCrop.getDaysPassed() < tile.getCrop().getDaysPassed()) {
                                        giantCrop.setDaysPassed(tile.getCrop().getDaysPassed());
                                    }
                                }
                                tile.setGiantCrops(tiles1);
                                tile.setGiantCrop(true);
                                tile.setCrop(giantCrop);
                            }

                            break; // Stop after finding one
                        }
                    }
                }
            } else {
                GameMenu.printResult("Tile is not farmable!");
            }
        } else {
            GameMenu.printResult("No item with this name found in your backpack!");
        }
    }

    public static void showPlant(String x, String y) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        Tile[][] tiles = App.getCurrentGame().getCurrentPlayer().getMap().getTiles();
        int X = Integer.parseInt(x);
        int Y = Integer.parseInt(y);
        if (tiles[X][Y].isPlanted()) {
            Tile targetTile = tiles[X][Y];
            ForgingSeed seed = (ForgingSeed)targetTile.getItem();
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
                    "=== Watered Today: " + targetTile.getCrop().isWateredToday() + " ==="); // TODO
            if (targetTile.isReadyToHarvest()) {
                GameMenu.printResult("=== Ready to Harvest! ===");
            }
        } else {
            GameMenu.printResult("No seed is planted here!");
        }
    }

    public static void fertilize(String fetilizer, String direction) {
        Item item = Item.findItemByName(fetilizer, App.getCurrentGame().getCurrentPlayer().getBackPack().getItems());
        if (item == null) {
            GameMenu.printResult("No item with this name found in your backpack!");
        }
        Player player = App.getCurrentGame().getCurrentPlayer();
        Tile[][] tiles = App.getCurrentGame().getCurrentPlayer().getMap().getTiles();
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
        if (newX < 0 || newX >= tiles.length || newY < 0 || newY >= tiles[0].length) {
            GameMenu.printResult("Out of bounds!");
            return;
        }
        if (tiles[newX][newY].isPlanted()) {
            if (fetilizer.equals("speed-gro")) {
                if (tiles[newX][newY].getCrop().getCurrentStage() == 4) {
                    tiles[newX][newY].setReadyToHarvest(true);
                } else {
                    tiles[newX][newY].getCrop().setCurrentStage(tiles[newX][newY].getCrop().getCurrentStage() + 1);
                }
            } else if (fetilizer.equals("deluxe retaining soil")) {
                tiles[newX][newY].getCrop().setNotNeedWaterAnymore(true);
            }
            ForgingSeed seed = (ForgingSeed) tiles[newX][newY].getItem();
            seed.setFertilized(true);
            GameMenu.printResult("Fertilizer applied!");
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
    public static void showCraftingRecipes() {
        for(IndustrialProductType recipe :App.getCurrentGame().getCurrentPlayer().getCraftingRecipes()){
            GameMenu.printResult(recipe.name + ": " + recipe.description);
            StringBuilder ingredients = new StringBuilder();
            ingredients.append("ingredients :");
            for (Item items : recipe.ingredients){
                ingredients.append(items.getCount());
                ingredients.append(" ");
                ingredients.append(items.getName());
                ingredients.append(" ");
            }
            GameMenu.printResult(ingredients.toString());
        }
    }
    public static void crafting(String name) {
        Player player = App.getCurrentGame().getCurrentPlayer();

        for(IndustrialProductType recipe : IndustrialProductType.values()){
            if(recipe.name.equals(name)){
                if(player.getCraftingRecipes().contains(recipe)){
                    for(Item items : recipe.ingredients){
                        Item ingredient = Item.findItemByName(items.getName(), player.getBackPack().getItems());
                        if(ingredient == null){
                            GameMenu.printResult("You don't have necessary ingredients!");
                            return;
                        }else{
                            if(ingredient.getCount() < items.getCount()){
                                GameMenu.printResult("You don't have enough ingredients!");
                                return;
                            }
                        }
                    }
                    IndustrialProduct crafted = new IndustrialProduct(1, recipe);

                    Item newItem = Item.findItemByName(crafted.getName(), player.getBackPack().getItems());

                    if((newItem == null) && player.getBackPack().getType().getCapacity() == player.getBackPack().getItems().size()){
                        GameMenu.printResult("You don't have enough space in your backpack!");
                        return;
                    }

                    for(Item ingredient : recipe.ingredients){
                        Item item = Item.findItemByName(ingredient.getName(), player.getBackPack().getItems());

                        if(item.getCount() == ingredient.getCount()){
                            player.getBackPack().getItems().remove(item);
                        }else{
                            item.setCount(item.getCount() - ingredient.getCount());
                        }
                    }

                    if(newItem != null){
                        newItem.setCount(newItem.getCount() + 1);
                    } else {
                        player.getBackPack().getItems().add(crafted);
                    }
                    GameMenu.printResult("You have successfully crafted " + recipe.name + "!");
                } else{
                    GameMenu.printResult("Sorry! you don't have the recipe for " + recipe.name);
                }
                return;
            }
        }
        GameMenu.printResult(name + " cannot be crafted!");
    }
    public static void placeItem(String name, String direction) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        Tile[][] tiles = App.getCurrentGame().getCurrentPlayer().getMap().getTiles();


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


        if((targetTile.getType().equals(TileTypes.GRASS) || targetTile.getType().equals(TileTypes.DIRT))
                && targetTile.getItem() == null){
            targetTile.setItem(item);
            GameMenu.printResult("You have successfully placed " + item.getName() + " on x: " + newX + " y: " + newY + "!");
        } else{
            GameMenu.printResult("You can't place this item here!");
        }
    }
    public static void cheatAddItem(String name, String count) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        for(IndustrialProductType recipe : IndustrialProductType.values()){
            if(recipe.name.equals(name)){
                Item newItem = new IndustrialProduct(Integer.parseInt(count), recipe);
                Item itemBackpack = Item.findItemByName(newItem.getName(), player.getBackPack().getItems());
                if(itemBackpack == null){
                    if(player.getBackPack().getType().getCapacity() > player.getBackPack().getItems().size()){
                        player.getBackPack().getItems().add(newItem);
                    } else {
                        GameMenu.printResult("You don't have enough space in your backpack!");
                    }
                } else {
                    itemBackpack.setCount(itemBackpack.getCount() + Integer.parseInt(count));
                }
                GameMenu.printResult(count + " " + name + "added to your backpack!");
                return;
            }
        }
        GameMenu.printResult(name + "doesn't exist!");

    }
    
    public static void putRefrigerator(String item) {
        Item wantedItem = Item.findItemByName(item, App.getCurrentGame().getCurrentPlayer().getBackPack().getItems());

        if (wantedItem == null)
            GameMenu.printResult("No Item Found!");

        if (wantedItem.getClass() != Food.class)
            GameMenu.printResult("Item is not eatable");

        App.getCurrentGame().getCurrentPlayer().getBackPack().removeItem(wantedItem);
        App.getCurrentGame().getCurrentPlayer().getRefrigerator().addItem(wantedItem);
    }

    public static void pickRefrigerator(String item) {
        Item wantedItem = Item.findItemByName(item, App.getCurrentGame().getCurrentPlayer().getRefrigerator().getItems());

        if (wantedItem == null)
            GameMenu.printResult("No Item Found!");

        App.getCurrentGame().getCurrentPlayer().getBackPack().addItem(wantedItem);
        App.getCurrentGame().getCurrentPlayer().getRefrigerator().removeItem(wantedItem);
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

    public static void cooking(String name) {
        FoodType recipe = FoodType.getrecipeByName(name);
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (recipe == null)
            GameMenu.printResult("No recipe with given name were found!");

        boolean recipeLeared = false;
        for (FoodType foodType : App.getCurrentGame().getCurrentPlayer().getRecipes()) {
            if (foodType.equals(recipe)) recipeLeared = true;
        }
        if (!recipeLeared) {
            GameMenu.printResult("You didn't learn this recipe!");
            return;
        }
        if (player.getBackPack().getItems().size() >= player.getBackPack().getType().getCapacity()) {
            GameMenu.printResult("Your Backpack is full!!");
            return;
        }

        for (Item ingredient : recipe.getIngredients()) {
            Item refrigratorItem = Item.findItemByName(ingredient.getName(), App.getCurrentGame().getCurrentPlayer().getRefrigerator().getItems());
            Item backpackItem = Item.findItemByName(ingredient.getName(), App.getCurrentGame().getCurrentPlayer().getBackPack().getItems());

            if (backpackItem == null) {
                if (refrigratorItem == null)
                    GameMenu.printResult("You don't have any " + ingredient.getName());
                else {
                    if (refrigratorItem.getCount() < ingredient.getCount())
                        GameMenu.printResult("You don't have enough " + ingredient.getName());
                    else
                        GameMenu.printResult("You have enough " + ingredient.getName() + " in your refrigrator. Please move it to your backpack");
                }

                return;
            }
            else {
                if (backpackItem.getCount() < ingredient.getCount()) {
                    if (refrigratorItem == null)
                        GameMenu.printResult("You don't have enough " + ingredient.getName());
                    else {
                        if (refrigratorItem.getCount() < ingredient.getCount())
                            GameMenu.printResult("You don't have enough " + ingredient.getName());
                        else
                            GameMenu.printResult("You have enough " + ingredient.getName() + " in your refrigrator. Please move it to your backpack");
                    }

                    return;
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
        App.getCurrentGame().getCurrentPlayer().changeEnergy(3);
    }

    public static void eat(String name) {
        Food food = null;
        for (Item foodItem : App.getCurrentGame().getCurrentPlayer().getBackPack().getItems()) {
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
        
        App.getCurrentGame().getCurrentPlayer().changeEnergy(food.getType().getEnergy());
        GameMenu.printResult("Food eaten successfully");
    }
    public static void showCookingRecipe(){}

    public static void build(String name, String X, String Y){
        // TODO check the carpenter's shop for this shit
        int x = Integer.parseInt(X);
        int y = Integer.parseInt(Y);
        int barnORcoop = -1; // 1 for barn and 0 for coop
        Player player = App.getCurrentGame().getCurrentPlayer();
        Tile[][] tiles = App.getCurrentGame().getCurrentPlayer().getMap().getTiles();
        String normalized = name.trim().toUpperCase().replace(" ", "_");

        try {
            CarpenterCosts item = CarpenterCosts.valueOf(normalized);
            for (int i = x; i < item.getWidth() + x; i++) {
                for (int j = y - item.getLength(); j < y; j++) {
                    if (tiles[i][j].getItem() != null) {
                        GameMenu.printResult("Not enough space!");
                        return;
                    }
                }
            }
            Item item1 = Item.findItemByName("wood", player.getBackPack().getItems());
            Item item2 = Item.findItemByName("stone", player.getBackPack().getItems());
            if (item1 == null || item2 == null) {
                GameMenu.printResult("You don't have enough resources!");
                return;
            }
            if (item.getCost() > player.getMoney()) {
                GameMenu.printResult("You don't have enough money!");
                return;
            } else if (item.getWood() > item1.getCount()) {
                GameMenu.printResult("You don't have enough wood!");
                return;
            } else if (item.getStone() > item2.getCount()) {
                GameMenu.printResult("You don't have enough stone!");
                return;
            }
            switch (item) {
                case BARN -> {
                    Barn barn = new Barn(4, 7, x, y, 4, "regular");
                    player.getMap().getBarns().add(barn);
                    barnORcoop = 1;
                }
                case BIG_BARN -> {
                    Barn barn = new Barn(4, 7, x, y, 8, "big");
                    player.getMap().getBarns().add(barn);
                    barnORcoop = 1;
                }
                case DELUXE_BARN -> {
                    Barn barn = new Barn(4, 7, x, y, 12, "deluxe");
                    player.getMap().getBarns().add(barn);
                    barnORcoop = 1;
                }
                case COOP -> {
                    Coop coop = new Coop(3, 6, x, y, 4, "regular");
                    player.getMap().getCoops().add(coop);
                    barnORcoop = 0;
                }
                case BIG_COOP -> {
                    Coop coop = new Coop(3, 6, x, y, 8, "big");
                    player.getMap().getCoops().add(coop);
                    barnORcoop = 0;
                }
                case DELUXE_COOP -> {
                    Coop coop = new Coop(3, 6, x, y, 12, "regular");
                    player.getMap().getCoops().add(coop);
                    barnORcoop = 0;
                }
            }
            item1.setCount(item1.getCount() - item.getWood());
            item2.setCount(item2.getCount() - item.getStone());
            player.setMoney(player.getMoney() - item.getCost());
            for (int i = x; i < x + item.getWidth(); i++) {
                for (int j = y - item.getLength(); j < y; j++) {
                    if (barnORcoop == 1) {
                        tiles[i][j].setType(TileTypes.BARN);
                    } else if (barnORcoop == 0) {
                        tiles[i][j].setType(TileTypes.COOP);
                    }
                }
            }
            if (barnORcoop == 0) {
                GameMenu.printResult("Coop bought successfully!");
            } else if (barnORcoop == 1) {
                GameMenu.printResult("Barn bought successfully!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid item: " + name);
        }
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
        if (player.getMoney() < animal3.getCost()) {
            GameMenu.printResult("You don't have enough money!");
            return;
        }
        else if (player.getMoney() >= animal3.getCost()) {
            player.setMoney(player.getMoney() - animal3.getCost());
        }
        switch (animal3) {
            case CHICKEN -> {
                int check = 0;
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
                int check = 0;
                for (Coop coop : player.getMap().getCoops()) {
                    if (!coop.getType().equals("regular") && coop.getCapacity() > coop.getAnimals().size()) {
                        Animal animal = new Duck(1200, name, 0, false, false, coop.getStartX() + coop.getAnimals().size(), coop.getStartY() + coop.getAnimals().size());
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
                int check = 0;
                for (Coop coop : player.getMap().getCoops()) {
                    if (!coop.getType().equals("regular") && !coop.getType().equals("big") && coop.getCapacity() > coop.getAnimals().size()) {
                        Animal animal = new Rabbit(8000, name, 0, false, false, coop.getStartX() + coop.getAnimals().size(), coop.getStartY() + coop.getAnimals().size());
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
                int check = 0;
                for (Coop coop : player.getMap().getCoops()) {
                    if (!coop.getType().equals("regular") && !coop.getType().equals("deluxe") && coop.getCapacity() > coop.getAnimals().size()) {
                        Animal animal = new Dinosaur(800, name, 0, false, false, coop.getStartX() + coop.getAnimals().size(), coop.getStartY() + coop.getAnimals().size());
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
                int check = 0;
                for (Barn barn : player.getMap().getBarns()) {
                    if (barn.getCapacity() > barn.getAnimals().size()) {
                        Animal animal = new Cow(1500, name, 0, false, false, barn.getStartX() + barn.getAnimals().size(), barn.getStartY() + barn.getAnimals().size());
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
                int check = 0;
                for (Barn barn : player.getMap().getBarns()) {
                    if (!barn.getType().equals("regular") && barn.getCapacity() > barn.getAnimals().size()) {
                        Animal animal = new Goat(4000, name, 0, false, false, barn.getStartX() + barn.getAnimals().size(), barn.getStartY() + barn.getAnimals().size());
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
                int check = 0;
                for (Barn barn : player.getMap().getBarns()) {
                    if (!barn.getType().equals("regular") && !barn.getType().equals("big") && barn.getCapacity() > barn.getAnimals().size()) {
                        Animal animal = new Sheep(8000, name, 0, false, false, barn.getStartX() + barn.getAnimals().size(), barn.getStartY() + barn.getAnimals().size());
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
                int check = 0;
                for (Barn barn : player.getMap().getBarns()) {
                    if (!barn.getType().equals("regular") && !barn.getType().equals("big") && barn.getCapacity() > barn.getAnimals().size()) {
                        Animal animal = new Cow(16000, name, 0, false, false, barn.getStartX() + barn.getAnimals().size(), barn.getStartY() + barn.getAnimals().size());
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
    }
    public static void pet(String name) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        int playerX = player.getX();
        int playerY = player.getY();

        for (Animal animal : player.getAnimals()) {
            if (animal.getName().equals(name)) {
                int animalX = animal.getX();
                int animalY = animal.getY();


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
                    animal.setX(animal.getFirstX());
                    animal.setY(animal.getFirstY());
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
                    animal.setFriendship(Math.max(animal.getFriendship() + 10, 1000));
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
        for (Animal animal : player.getAnimals()) {
            if (animal.isProductReady()) {
                GameMenu.printResult("=== " + animal.getName() + " " + animal.name(animal) + "'s product is ready to collect! ===");
            }
        }
    }
    public static void collectProduce(String name){
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (Animal animal : player.getAnimals()) {
            if (animal.isProductReady()) {
                animal.collectProduct();
                return;
            }
        }
    }
    public static void sellAnimal(String name){
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (Animal animal : player.getAnimals()) {
            if (animal.getName().equals(name)) {
                float cost = (float) (animal.getPrice() * ((double) animal.getFriendship() / 1000 + 0.3));
                player.setMoney(player.getMoney() + (int) cost);
                player.getAnimals().remove(animal);
                if (animal.getBarn() != null) {
                    animal.getBarn().getAnimals().remove(animal);
                } else if (animal.getCoop() != null) {
                    animal.getCoop().getAnimals().remove(animal);
                }
                GameMenu.printResult("Sold " + animal.getName() + " for: " + cost);
                break;
            }
        }
    }
    public static void fishing(String fishingPole){
        ArrayList<FishType> fishTypes = new ArrayList<>();
        for (FishType fishType : FishType.values()) {
            if (fishType.getSeason().equals(App.getCurrentGame().getCurrentTime().getSeason()))
                fishTypes.add(fishType);
        }

        Random random = new Random();
        FishType fishType = fishTypes.get(random.nextInt(fishTypes.size()));

        double R = random.nextDouble();
        double M;
        if (App.getCurrentGame().getCurrentWeather().equals(Weather.SUNNY)) M = 1.5;
        else if (App.getCurrentGame().getCurrentWeather().equals(Weather.RAIN)) M = 1.2;
        else if (App.getCurrentGame().getCurrentWeather().equals(Weather.STORM)) M = 0.5;
        else M = 1.0;
        int skill = App.getCurrentGame().getCurrentPlayer().getFishing();

        int count = (int) Math.floor(R * M * (skill + 2)) + 1;
        count = Math.min(count, 6);

        //TODO fish quality
        //TODO legndary fish

        Item fish = new Fish(count, fishType);
        App.getCurrentGame().getCurrentPlayer().getBackPack().addItem(fish);
    }
   
    public static void artisanUse(String artisanName, String itemName) {
        IndustrialProductType recipe = null;
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (IndustrialProductType craftingRecipe : App.getCurrentGame().getCurrentPlayer().getCraftingRecipes()) {
            if (craftingRecipe.getName().equals(artisanName)) recipe = craftingRecipe;
        }

        if (recipe == null) {
            GameMenu.printResult("No recipe with given name were found!");
            return;
        }

        if (player.getBackPack().getItems().size() >= player.getBackPack().getType().getCapacity()) {
            GameMenu.printResult("Your Backpack is full!!");
            return;
        }

        for (Item ingredient : recipe.getIngredients()) {
            Item backpackItem = Item.findItemByName(ingredient.getName(), App.getCurrentGame().getCurrentPlayer().getBackPack().getItems());

            if (backpackItem == null) {
                GameMenu.printResult("You don't have any " + ingredient.getName());
                return;
            }
            else {
                if (backpackItem.getCount() < ingredient.getCount()) {
                    GameMenu.printResult("You don't have enough " + ingredient.getName());
                    return;
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

        App.getCurrentGame().getCurrentPlayer().getBackPack().addItem(new IndustrialProduct(1, recipe));
    }

    public static void artisanGet(String name) {
        //TODO need prossesing time??!

        Player player = App.getCurrentGame().getCurrentPlayer();
        Item item = Item.findItemByName(name, player.getBackPack().getItems());

        if (item == null) {
            GameMenu.printResult("No item with given name found!");
            return;
        }
        GameMenu.printResult("You got (*1)" + name);
    }

    public static void showAllProducts() {
        if (App.getCurrentGame().getCurrentPlayer().getBuilding() instanceof Blacksmith) {
            GameMenu.printResult(MaintainerController.printingShopProducts("Blacksmith", BlacksmithCosts.values()));
        } else if (App.getCurrentGame().getCurrentPlayer().getBuilding() instanceof Carpenter) {
            GameMenu.printResult(MaintainerController.printingShopProducts("Carpenter", CarpenterCosts.values()));
        } else if (App.getCurrentGame().getCurrentPlayer().getBuilding() instanceof FishShop) {
            GameMenu.printResult(MaintainerController.printingShopProducts("FishShop", FishShopCosts.values()));
        } else if (App.getCurrentGame().getCurrentPlayer().getBuilding() instanceof GeneralStore) {
            GameMenu.printResult(MaintainerController.printingShopProducts("GeneralStore", GeneralStoreCosts.values()));
        } else if (App.getCurrentGame().getCurrentPlayer().getBuilding() instanceof JojaMart) {
            GameMenu.printResult(MaintainerController.printingShopProducts("JojaMart", JojaMartCosts.values()));
        } else if (App.getCurrentGame().getCurrentPlayer().getBuilding() instanceof Ranch) {
            GameMenu.printResult(MaintainerController.printingShopProducts("Ranch", RanchCosts.values()));
        } else if (App.getCurrentGame().getCurrentPlayer().getBuilding() instanceof Saloon) {
            GameMenu.printResult(MaintainerController.printingShopProducts("Saloon", SaloonCosts.values()));
        } else {
            GameMenu.printResult("You are not int a store!");
        }
    }

    public static void showAvailableProducts() {}

    public static void purchase(String name, int amount){
        ShopProduct item = (ShopProduct) Item.findItemByName(name, App.getCurrentGame().getCurrentPlayer().getBuilding().getItems());

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
        // TODO reset daily limit in next day

        if (item.getCost() * amount > App.getCurrentGame().getCurrentPlayer().getMoney()) {
            GameMenu.printResult("You don't have enough money!");
            return;
        }
        
        if (amount == item.getCount()) App.getCurrentGame().getCurrentPlayer().getBuilding().removeItem(item);
        else item.changeCount(-1  * amount);

        App.getCurrentGame().getCurrentPlayer().setMoney(App.getCurrentGame().getCurrentPlayer().getMoney() - item.getCost() * amount);
        App.getCurrentGame().getCurrentPlayer().getBackPack().addItem(item);
        item.sold(amount);
        GameMenu.printResult("Item purchased successfully");
    }

    public static void cheatAddMoney(int amount){
        App.getCurrentGame().getCurrentPlayer().setMoney(App.getCurrentGame().getCurrentPlayer().getMoney() + amount);
        GameMenu.printResult("Cheart confirm successfully. Your money: " + App.getCurrentGame().getCurrentPlayer().getMoney());
    }

    public static void sell(String name, int amount){
        Player player = App.getCurrentGame().getCurrentPlayer();
        Item item = Item.findItemByName(name, player.getBackPack().getItems());

        if (item == null) {
            GameMenu.printResult("No item with given name found!");
            return;
        }

        if (item.getCount() < amount) {
            GameMenu.printResult("Not enough number of this Item. Only have + " + item.getCount());
            return;
        }

        //TODO be near shippingbin

        if (item.getCount() == amount)player.getBackPack().removeItem(item);
        else item.changeCount(-1  * amount);

        player.setMoney(player.getMoney() + (int) player.getShippingBin().getType().calculateNewPrice(item.getPrice() * amount));
        //TODO money will be got next day
        GameMenu.printResult("Item sold successfully!");
    }

    public static void friendships(){
        Player player = App.getCurrentGame().getCurrentPlayer();
        GameMenu.printResult("=== Friendships ===");
        for (java.util.Map.Entry<Player, Friendship> entry : player.getFriendships().entrySet()) {
            GameMenu.printResult(entry.getKey().getUsername() + ": " + entry.getValue().getLevel());
        }
    }
    public static void talk(String username, String message){
        String newMessage = message + " +++ sent at: " + App.getCurrentGame().getCurrentTime().getDay() + " " + App.getCurrentGame().getCurrentTime().getHour();
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (User.findUserByUsername(username) == null) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }
        Player otherPlayer = User.findUserByUsername(username).getPlayer();
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
        GameMenu.printResult("Message sent successfully!");
    }
    public static void talkHistory(String username){
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (User.findUserByUsername(username) == null) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }
        Player otherPlayer = User.findUserByUsername(username).getPlayer();
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
        for (Item item1 : otherPlayer.getBackPack().getItems()) {
            if (item1.getName().equals(gift.getName())) {
                Item.findItemByName(item, otherPlayer.getBackPack().getItems()).changeCount(amount);
                GameMenu.printResult("Gift sent to " + username + " successfully!");
                break;
            } else {
                otherPlayer.getBackPack().addItem(new Item(amount, item, item1.getPrice()));
                GameMenu.printResult("Gift sent to " + username + " successfully!");
                break;
            }
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
            GameMenu.printResult(gift.getSentPlayer().getUsername() + " sent you " + gift.getCount() + " " + gift.getName());
        }
    }
    public static void giftHistory(String username){
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (User.findUserByUsername(username) == null) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }
        Player otherPlayer = User.findUserByUsername(username).getPlayer();
        GameMenu.printResult("Gifts " + username + " sent to you: ");
        for (Gift gift : player.getGifts()) {
            if (gift.getSentPlayer().equals(otherPlayer)) {
                GameMenu.printResult(gift.getSentPlayer().getUsername() + " sent you " + gift.getCount() + " " + gift.getName());
            }
        }
        GameMenu.printResult("Gifts you sent to " + username + ": ");
        for (Gift gift : otherPlayer.getGifts()) {
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
        GameMenu.printResult("Nice job! You hugged each other.");
    }
    public static void flower(String username){
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (User.findUserByUsername(username) == null) {
            GameMenu.printResult("There is no one with this username!");
            return;
        }
        Player otherPlayer = User.findUserByUsername(username).getPlayer();
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
            otherPlayer.getBackPack().addItem(new Item(1, "bouquet", GeneralStoreCosts.BOUQUET.getPrice()));
        } else {
            otherBouquet.setCount(otherBouquet.getCount() + 1);
        }
        GameMenu.printResult("Awwwwww =^-^=");
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
        if (!Player.areAdjacent(player, otherPlayer)) {
            GameMenu.printResult("Player is not available!");
            return;
        }
        if (player.getGender().equals(otherPlayer.getGender())) {
            GameMenu.printResult("that's gay tbh");
        }
        if (player.getFriendships().get(otherPlayer).getLevel() < 4 || (player.getFriendships().get(otherPlayer).getLevel() == 3 &&
                player.getFriendships().get(player).getXp() < 400)) {
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
//        for (Trade trade : App.getCurrentGame().getTrades()) {
//            int check = 0;
//            int check2 = 0;
//            if (trade.getType().equals("offer")) {
//                check = 1;
//                if (trade.getMoneyOrItem().equals("money")) {
//                    check2 = 1;
//                }
//            } else {
//                if (trade.getMoneyOrItem().equals("money")) {
//                    check2 = 1;
//                }
//            }
//            if (check == 0 && check2 == 0) {
//                GameMenu.printResult(trade.getGetter().getUsername() + " wants " + trade.getRequestedItem().getName() + " in exchange for " + trade.getOfferedItem());
//            } else if (check == 1 && check2 == 0) {
//                GameMenu.printResult(trade.getGiver().getUsername() + " offers " + trade.getOfferedItem().getName() + " in exchange for " + trade.getRequestedItem());
//            } else if (check == 1 && check2 == 1) {
//                GameMenu.printResult(trade.getGiver().getUsername() + " offers " + trade.getOfferedItem().getName() + " in exchange for " + trade.getMoney());
//            } else if (check == 0 && check2 == 1) {
//                GameMenu.printResult(trade.getGetter().getUsername() + " wants " + trade.getRequestedItem().getName() + " in exchange for " + trade.getMoneyOrItem());
//            }
//        }
        for (Player player : players) {
            if (!player.equals(App.getCurrentGame().getCurrentPlayer())) {
                GameMenu.printResult(player.getUsername());
            }
        }
    }

    /**
     * Create an item↔money trade:
     *  - “offer”: you give items and ask for money in return
     *  - “request”: you offer money and ask for items in return
     */
    public static void trade(String username,
                             String type,    // "offer" or "request"
                             String item,    // item name (offered or requested)
                             String amount,  // item count
                             String price)   // money amount
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
                        other,        // getter
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
                        me,           // getter
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
                        other,           // getter
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
                        me,              // getter
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
    }

    // Helper to check item availability
    private static boolean hasEnoughItem(Player p, String name, int count) {
        Item it = Item.findItemByName(name, p.getBackPack().getItems());
        return it != null && it.getCount() >= count;
    }

    public static void tradeList(){
        Player player = App.getCurrentGame().getCurrentPlayer();
        int i = 0;
        for (Trade trade : App.getCurrentGame().getTrades()) {
            if (trade.getType().equals("offer") && trade.getMoneyOrItem().equals("item")) {
                if (trade.getGetter().equals(player)) {
                    GameMenu.printResult(i++ + ". " + trade.getGiver().getUsername() + " offered you " + trade.getOfferAmount() + " " + trade.getOfferedItem() + " with id of: " + trade.getId());
                }
            } else if (trade.getType().equals("request") && trade.getMoneyOrItem().equals("item")) {
                if (trade.getGiver().equals(player)) {
                    GameMenu.printResult(i++ + ". " + trade.getGetter().getUsername() + " requests " + trade.getRequestAmount() + " " + trade.getRequestedItem() + " from you" + " with id of: " + trade.getId());
                }
            } else if (trade.getType().equals("offer") && trade.getMoneyOrItem().equals("money")) {
                if (trade.getGiver().equals(player)) {
                    GameMenu.printResult(i++ + ". " + trade.getGiver().getUsername() + " offered you " + trade.getOfferedItem() + " for " + trade.getMoney() + " with id of: " + trade.getId());
                }
            } else if (trade.getType().equals("request") && trade.getMoneyOrItem().equals("money")) {
                if (trade.getGiver().equals(player)) {
                    GameMenu.printResult(i++ + ". " + trade.getGetter().getUsername() + " requests " + trade.getRequestedItem() + " for " + trade.getMoney() + " from you" + " with id of: " + trade.getId());
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
                        transferItem(giver, getter,
                                t.getOfferedItem(),  t.getOfferAmount());
                        transferItem(getter, giver,
                                t.getRequestedItem(), t.getRequestAmount());

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

                    it.remove();
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
                        it.remove();
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

        // Add to destination
        Item dst = Item.findItemByName(itemName, to.getBackPack().getItems());
        if (dst == null) {
            // assume constructor: Item(count, name, price)
            to.getBackPack().getItems().add(new Item(count, itemName, src.getPrice()));
        } else {
            dst.setCount(dst.getCount() + count);
        }
    }
    public static void tradeHistory() {
        Player me = App.getCurrentGame().getCurrentPlayer();
        List<Trade> trades = App.getCurrentGame().getTrades();

        if (trades.isEmpty()) {
            GameMenu.printResult("No pending trades right now.");
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
                if(npc.getTile().getX() - 1 <= player.getX() && player.getX() <= npc.getTile().getX() + 1 &&
                        npc.getTile().getX() - 1 <= player.getY() && player.getX() <= npc.getTile().getY() + 1){
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
    public static void giftNPC(String name, String item) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        for(NPC npc : App.getCurrentGame().getNPCs()){
            if(npc.getName().equals(name)){
                if(npc.getTile().getX() - 1 <= player.getX() && player.getX() <= npc.getTile().getX() + 1 &&
                        npc.getTile().getX() - 1 <= player.getY() && player.getX() <= npc.getTile().getY() + 1){
                    Item gift = Item.findItemByName(item, player.getBackPack().getItems());
                    if(gift == null){
                        GameMenu.printResult("You don't have this gift!");
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
                        GameMenu.printResult("Gift has been removed!");
                    }
                } else {
                    GameMenu.printResult("You are too far!");
                }
                return;
            }
        }
        GameMenu.printResult("Wrong name!");
    }
    public static void friendshipNPCList() {
        for(NPC npc : App.getCurrentGame().getNPCs()){
            GameMenu.printResult("Friendship level with " + npc.getName() + " : " + App.getCurrentGame().getCurrentPlayer().getFriendshipsNPC().get(npc));
        }
    }
    public static void questList() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        int counter = 0;
        for(NPC npc : App.getCurrentGame().getNPCs()){
            GameMenu.printResult(npc.getName() + " quests :");
            StringBuilder message = new StringBuilder();
            for(Integer active : player.getActivatedQuestNPC().get(npc)){
                if(npc.getName().equals("Sebastian")){
                    if (active == 1) {
                        message.append(counter++);
                        message.append("Request :");
                        message.append("50 iron ore");
                        message.append("\n");
                        message.append("Reward :");
                        message.append("2 diamond");
                    } else if (active == 2) {
                        message.append(counter++);
                        message.append("Request :");
                        message.append("pumpkin pie");
                        message.append("\n");
                        message.append("Reward :");
                        message.append("5000 coin");
                    } else if (active == 3) {
                        message.append(counter++);
                        message.append("Request :");
                        message.append("150 stones");
                        message.append("\n");
                        message.append("Reward :");
                        message.append("50 quartz");
                    }
                } else if(npc.getName().equals("Abigail")){
                    if (active == 1) {
                        message.append(counter++);
                        message.append("Request :");
                        message.append("1 gold bar");
                        message.append("\n");
                        message.append("Reward :");
                        message.append("1 friendship level");
                    } else if (active == 2) {
                        message.append(counter++);
                        message.append("Request :");
                        message.append("1 pumpkin");
                        message.append("\n");
                        message.append("Reward :");
                        message.append("500 coin");
                    } else if (active == 3) {
                        message.append(counter++);
                        message.append("Request :");
                        message.append("50 wheat");
                        message.append("\n");
                        message.append("Reward :");
                        message.append("1 Iridium Sprinkler");
                    }
                } else if (npc.getName().equals("Harvey")){
                    if (active == 1) {
                        message.append(counter++);
                        message.append("Request :");
                        message.append("12 of any plant");
                        message.append("\n");
                        message.append("Reward :");
                        message.append("750 coin");
                    } else if (active == 2) {
                        message.append(counter++);
                        message.append("Request :");
                        message.append("1 salmon");
                        message.append("\n");
                        message.append("Reward :");
                        message.append("1 friendship level");
                    } else if (active == 3) {
                        message.append(counter++);
                        message.append("Request :");
                        message.append("1 bottle of wine");
                        message.append("\n");
                        message.append("Reward :");
                        message.append("5 salad");
                    }
                } else if (npc.getName().equals("Leah")){
                    if (active == 1) {
                        message.append(counter++);
                        message.append("Request :");
                        message.append("10 wood");
                        message.append("\n");
                        message.append("Reward :");
                        message.append("500 coin");
                    } else if (active == 2) {
                        message.append(counter++);
                        message.append("Request :");
                        message.append("1 salmon");
                        message.append("\n");
                        message.append("Reward :");
                        message.append("1 cooking recipe (dinner salmon)");
                    } else if (active == 3) {
                        message.append(counter++);
                        message.append("Request :");
                        message.append("200 wood");
                        message.append("\n");
                        message.append("Reward :");
                        message.append("3 deluxe scarecrows");
                    }
                } else if (npc.getName().equals("Robin")){
                    if (active == 1) {
                        message.append(counter++);
                        message.append("Request :");
                        message.append("80 wood");
                        message.append("\n");
                        message.append("Reward :");
                        message.append("1000 coin");
                    } else if (active == 2) {
                        message.append(counter++);
                        message.append("Request :");
                        message.append("10 iron bar");
                        message.append("\n");
                        message.append("Reward :");
                        message.append("3 beehives");
                    } else if (active == 3) {
                        message.append(counter++);
                        message.append("Request :");
                        message.append("1000 wood");
                        message.append("\n");
                        message.append("Reward :");
                        message.append("25000 coin");
                    }
                }

                GameMenu.printResult(message.toString());
            }
        }
    }
    public static void questFinish(String indexString) {
        int index = Integer.parseInt(indexString);
        Player player = App.getCurrentGame().getCurrentPlayer();
        for(NPC npc : App.getCurrentGame().getNPCs()){
            int counter = 1;
            if(npc.getTile().getX() - 1 <= player.getX() && player.getX() <= npc.getTile().getX() + 1 &&
                    npc.getTile().getX() - 1 <= player.getY() && player.getX() <= npc.getTile().getY() + 1) {
                for(NPC npcQuest : App.getCurrentGame().getNPCs()){
                    for (Integer questCounter : player.getActivatedQuestNPC().get(npcQuest)){
                        counter++;
                        if(counter == index){
                            if(questCounter == 1){
                                npc.quest1();
                            } else if(questCounter == 2){
                                npc.quest2();
                            } else if(questCounter == 3){
                                npc.quest3();
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
}
