package controllers;

import models.App;
import models.Items.Products.*;
import models.Items.Item;
import models.Items.Tools.*;
import models.Maps.Map;
import models.Maps.PathFinder;
import models.Maps.Tile;
import models.Maps.TileTypes;
import models.Players.Player;
import views.GameMenu;
import views.RegisterMenu;

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
    public static void upgradeTools(String name) {
        // TODO
    }
    public static void toolUse(String direction) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        Item wield = player.getWield();
        Tile[][] tiles = App.getMaps().get(player.getSelectionNumber()  - 1).getTiles();


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
                if(targetTile.getType().equals(TileTypes.DIRT)){
                    targetTile.setType(TileTypes.PLANTABLE);
                }
                player.setEnergy(player.getEnergy() - energyNeeded);
                GameMenu.printResult("The ground is now soft and ready to plant.");
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
                    if(targetTile.getItem() instanceof ForagingMineral){
                        Item newItem = Item.findItemByName(targetTile.getItem().getName());
                        if(newItem != null){
                            newItem.setCount(newItem.getCount() + 1);
                        }else{
                            if(player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()){
                                GameMenu.printResult("You don't have enough space in your backpack!");
                                return;
                            } else{
                                player.getBackPack().addItem(targetTile.getItem());
                            }
                        }
                        GameMenu.printResult(targetTile.getItem().getName() + " successfully added to your backpack");
                        targetTile.setItem(null);
                    }else{
                        GameMenu.printResult("You swing your pickaxe... but there's nothing to mine here!");
                        if(energyNeeded > 0){
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
                if(targetTile.getItem() instanceof Tree){
                    Item wood = new Item(12 ,"wood");
                    Item sap = new Item(2 ,"sap");

                    Item newWood = Item.findItemByName(wood.getName());
                    Item newSap = Item.findItemByName(sap.getName());

                    if(newWood != null){
                        newWood.setCount(newWood.getCount() + 1);
                    }else{
                        if(player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()){
                            GameMenu.printResult("You don't have enough space in your backpack!");
                            return;
                        } else{

                            if(newSap != null){
                            newSap.setCount(newSap.getCount() + 1);
                            }else{
                                if(player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()){
                                    GameMenu.printResult("You don't have enough space in your backpack!");
                                    return;
                                } else{
                                    player.getBackPack().addItem(sap);
                                }
                            }

                            player.getBackPack().addItem(wood);
                        }
                    }

                    targetTile.setItem(null);
                    GameMenu.printResult("You chop down the tree and collect 12 wood and 2 sap.");
                } else if(targetTile.getItem().equals(new Item(1,"branch"))){
                    targetTile.setItem(null);
                    GameMenu.printResult("You clear the branch from the ground.");
                } else{
                    GameMenu.printResult("You swing your axe, but nothing happens.");
                    if(energyNeeded > 0){
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
                    ((Basket) wield).setRemainingWater(((Basket) wield).getRemainingWater() - 1);
                    if(targetTile.getItem() instanceof ForgingSeed){
                       //Ab dadan TODO
                        GameMenu.printResult("You give the plants a refreshing splash!");
                    } else {
                        GameMenu.printResult("You spill some water on the ground.");
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
                    GameMenu.printResult("You harvested " + targetTile.getCrop() +" and added it to your backpack!");
                    Item newItem = Item.findItemByName(targetTile.getCrop().getName());

                    if(newItem != null){
                        newItem.setCount(newItem.getCount() + 1);
                    } else {
                        if(player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()){
                            GameMenu.printResult("You don't have enough space in your backpack!");
                            return;
                        } else{
                            player.getBackPack().addItem(targetTile.getCrop());
                        }
                    }
                    targetTile.setReadyToHarvest(false);
                    targetTile.setCrop(null);
                } else if(targetTile.getType().equals(TileTypes.GRASS)){
                    targetTile.setType(TileTypes.DIRT);
                    GameMenu.printResult("Tile type changed to Dirt!");
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
                seed.setFertilized(false);
                item.setCount(item.getCount() - 1);
                targetTile.setPlanted(true);
                if (item.getCount() == 0) {
                    player.getBackPack().getItems().remove(item);
                }
                tiles[newX][newY].setReadyToHarvest(false);
                tiles[newX][newY].setCrop(seed.getCrop());

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
        int X = Integer.parseInt(x);
        int Y = Integer.parseInt(y);
        if (tiles[X][Y].isPlanted()) {
            Tile targetTile = tiles[player.getX()][player.getY()];
            ForgingSeed seed = (ForgingSeed)targetTile.getItem();
            int daysRemaining = 0;
            for (int i = seed.getCrop().getCurrentStage(); i < seed.getCrop().getStages().size(); i++) {
                daysRemaining += seed.getCrop().getStages().get(i);
                daysRemaining -= seed.getCrop().getDaysPassed();
            }
            GameMenu.printResult("=== Seed: " + seed.getName() + " ===\n" +
                    "=== Current Stage: " + seed.getCrop().getCurrentStage() + " ===\n" +
                    "=== Days Remaining: " + daysRemaining + " ===\n" +
                    "=== Is Fertilized: " + seed.isFertilized() + " ===\n" +
                    "=== Watered Today: " + x + " ==="); // TODO
        }
    }
    public static void fertilize(String fetilizer, String direction) {
        Item item = Item.findItemByName(fetilizer);
        if (item == null) {
            GameMenu.printResult("No item with this name found in your backpack!");
        }
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
        if (newX < 0 || newX >= tiles.length || newY < 0 || newY >= tiles[0].length) {
            GameMenu.printResult("Out of bounds!");
            return;
        }
        if (tiles[newX][newY].isPlanted()) {
            tiles[newX][newY].setReadyToHarvest(true);
            ForgingSeed seed = (ForgingSeed) tiles[newX][newY].getItem();
            seed.setFertilized(true);
            GameMenu.printResult("Plant is ready to harvest!");
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
        for(CraftingRecipe recipe :App.getCurrentGame().getCurrentPlayer().getCraftingRecipes()){
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

        for(CraftingRecipe recipe : CraftingRecipe.values()){
            if(recipe.name.equals(name)){
                if(player.getCraftingRecipes().contains(recipe)){
                    for(Item items : recipe.ingredients){
                        Item ingredient = Item.findItemByName(items.getName());
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
                    CraftingItems crafted = new CraftingItems(1, recipe);

                    Item newItem = Item.findItemByName(crafted.getName());

                    if((newItem == null) && player.getBackPack().getType().getCapacity() == player.getBackPack().getItems().size()){
                        GameMenu.printResult("You don't have enough space in your backpack!");
                        return;
                    }

                    for(Item ingredient : recipe.ingredients){
                        Item item = Item.findItemByName(ingredient.getName());

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
        Tile[][] tiles = App.getMaps().get(player.getSelectionNumber()  - 1).getTiles();


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
        Item item =  Item.findItemByName(name);
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
        for(CraftingRecipe recipe : CraftingRecipe.values()){
            if(recipe.name.equals(name)){
                Item newItem = new CraftingItems(Integer.parseInt(count), recipe);
                Item itemBackpack = Item.findItemByName(newItem.getName());
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
