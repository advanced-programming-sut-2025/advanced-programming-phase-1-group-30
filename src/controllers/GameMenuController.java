package controllers;

import models.Animals.*;
import models.App;
import models.Buildings.Barn;
import models.Buildings.CarpenterCosts;
import models.Buildings.Coop;
import models.Buildings.RanchCosts;
import models.Game;
import models.Invetory.BackPack;
import models.Invetory.Inventory;
import models.Items.Item;
import models.Items.Products.CropType;
import models.Items.Products.ForagingCropType;
import models.Items.Products.ForgingSeed;
import models.Items.Tools.Tool;
import models.Maps.Map;
import models.Maps.PathFinder;
import models.Maps.Tile;
import models.Maps.TileTypes;
import models.Players.Player;
import models.TimeAndDate.Season;
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
    public static void upgradeTools(String name) {}
    public static void toolUse(String direction) {}
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
        // Check for harvesability
        Tile targetTile = tiles[newX][newY];
        if (!targetTile.getType().equals(TileTypes.PLANTABLE)) {
            GameMenu.printResult("Tile is not harvestable!");
            return;
        }
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

    }
    public static void showCraftingRecipes() {}
    public static void crafting(String name) {}
    public static void placeItem(String name, String direction) {}
    public static void cheatAddItem(String name, String count) {}
    public static void putRefrigerator(String item) {}
    public static void pickRefrigerator(String item) {}
    public static void showCookingRecipe(){}
    public static void cooking(String name) {}
    public static void eat(String name) {}
    public static void build(String name, String X, String Y){
        // TODO check the carpenter's shop for this shit
        int x = Integer.parseInt(X);
        int y = Integer.parseInt(Y);
        int barnORcoop = -1; // 1 for barn and 0 for coop
        Player player = App.getCurrentGame().getCurrentPlayer();
        Tile[][] tiles = App.getMaps().get(player.getSelectionNumber()  - 1).getTiles();
        String normalized = name.trim().toUpperCase().replace(" ", "_");

        try {
            CarpenterCosts item = CarpenterCosts.valueOf(normalized);
            for (int i = x; i < item.getWidth(); i++) {
                for (int j = y; j < item.getLength(); j++) {
                    if (tiles[i][j].getItem() != null) {
                        GameMenu.printResult("Not enough space!");
                        return;
                    }
                }
            }
            Item item1 = Item.findItemByName("wood");
            Item item2 = Item.findItemByName("stone");
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
            for (int i = x; i < item.getWidth(); i++) {
                for (int j = y; j < item.getLength(); j++) {
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
                    if (coop.getCapacity() > coop.getCurrentNumberOfAnimals()) {
                        Animal animal = new Chicken(800, name, 0, false, false, coop.getStartX() + coop.getCurrentNumberOfAnimals(), coop.getStartY() + coop.getCurrentNumberOfAnimals());
                        coop.getAnimals().add(animal);
                        animal.setCoop(coop);
                        coop.setCurrentNumberOfAnimals(coop.getCurrentNumberOfAnimals());
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
                    if (!coop.getType().equals("regular") && coop.getCapacity() > coop.getCurrentNumberOfAnimals()) {
                        Animal animal = new Duck(1200, name, 0, false, false, coop.getStartX() + coop.getCurrentNumberOfAnimals(), coop.getStartY() + coop.getCurrentNumberOfAnimals());
                        coop.getAnimals().add(animal);
                        animal.setCoop(coop);
                        coop.setCurrentNumberOfAnimals(coop.getCurrentNumberOfAnimals());
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
                    if (!coop.getType().equals("regular") && !coop.getType().equals("big") && coop.getCapacity() > coop.getCurrentNumberOfAnimals()) {
                        Animal animal = new Rabbit(8000, name, 0, false, false, coop.getStartX() + coop.getCurrentNumberOfAnimals(), coop.getStartY() + coop.getCurrentNumberOfAnimals());
                        coop.getAnimals().add(animal);
                        animal.setCoop(coop);
                        coop.setCurrentNumberOfAnimals(coop.getCurrentNumberOfAnimals());
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
                    if (!coop.getType().equals("regular") && !coop.getType().equals("deluxe") && coop.getCapacity() > coop.getCurrentNumberOfAnimals()) {
                        Animal animal = new Dinosaur(800, name, 0, false, false, coop.getStartX() + coop.getCurrentNumberOfAnimals(), coop.getStartY() + coop.getCurrentNumberOfAnimals());
                        coop.getAnimals().add(animal);
                        coop.setCurrentNumberOfAnimals(coop.getCurrentNumberOfAnimals());
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
                    if (barn.getCapacity() > barn.getCurrentNumberOfAnimals()) {
                        Animal animal = new Cow(1500, name, 0, false, false, barn.getStartX() + barn.getCurrentNumberOfAnimals(), barn.getStartY() + barn.getCurrentNumberOfAnimals());
                        barn.getAnimals().add(animal);
                        animal.setBarn(barn);
                        player.getAnimals().add(animal);
                        barn.setCurrentNumberOfAnimals(barn.getCurrentNumberOfAnimals());
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
                    if (!barn.getType().equals("regular") && barn.getCapacity() > barn.getCurrentNumberOfAnimals()) {
                        Animal animal = new Goat(4000, name, 0, false, false, barn.getStartX() + barn.getCurrentNumberOfAnimals(), barn.getStartY() + barn.getCurrentNumberOfAnimals());
                        barn.getAnimals().add(animal);
                        animal.setBarn(barn);
                        player.getAnimals().add(animal);
                        barn.setCurrentNumberOfAnimals(barn.getCurrentNumberOfAnimals());
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
                    if (!barn.getType().equals("regular") && !barn.getType().equals("big") && barn.getCapacity() > barn.getCurrentNumberOfAnimals()) {
                        Animal animal = new Sheep(8000, name, 0, false, false, barn.getStartX() + barn.getCurrentNumberOfAnimals(), barn.getStartY() + barn.getCurrentNumberOfAnimals());
                        barn.getAnimals().add(animal);
                        animal.setBarn(barn);
                        player.getAnimals().add(animal);
                        barn.setCurrentNumberOfAnimals(barn.getCurrentNumberOfAnimals());
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
                    if (!barn.getType().equals("regular") && !barn.getType().equals("big") && barn.getCapacity() > barn.getCurrentNumberOfAnimals()) {
                        Animal animal = new Cow(16000, name, 0, false, false, barn.getStartX() + barn.getCurrentNumberOfAnimals(), barn.getStartY() + barn.getCurrentNumberOfAnimals());
                        barn.getAnimals().add(animal);
                        animal.setBarn(barn);
                        player.getAnimals().add(animal);
                        barn.setCurrentNumberOfAnimals(barn.getCurrentNumberOfAnimals());
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
    public static void pet(String name){
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (Animal animal : player.getAnimals()) {
            if (animal.getName().equals(name)) {
                animal.setFriendship(Math.min(animal.getFriendship() + 15, 1000));
                if (animal instanceof Cow) {
                    GameMenu.printResult("mowwwww!");
                } else if (animal instanceof Sheep) {
                    GameMenu.printResult("shazoooom!");
                } else
                    GameMenu.printResult("Animal pet successfully!");
            }
        }
    }
    public static void cheatSetFriendship(String name, String amount) {
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
            GameMenu.printResult("=== Animal: " + animal.getClass() + " " + animal.getName() + " ===");
            GameMenu.printResult("=== Friendship: " + animal.getFriendship() + " ===");
            GameMenu.printResult("=== Is fed today: " + animal.isFedToday() + " ===");
            GameMenu.printResult("=== Is pet today: " + animal.isPetToday() + " ===");
            GameMenu.printResult("");
        }
    }
    public static void shepherdAnimals(String name, String x, String y){
    }
    public static void feedHay(String name){
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (Animal animal : player.getAnimals()) {
            if (animal.getName().equals(name)) {
                animal.setFedToday(true);
            }
        }
    }
    public static void produces(){
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (Animal animal : player.getAnimals()) {
            if (animal.isProductReady()) {
                GameMenu.printResult("=== " + animal.getName() + " " + animal.getClass() + "'s product is ready to collect! ===");
            }
        }
    }
    public static void collectProduce(String name){}
    public static void sellAnimal(String name){
        Player player = App.getCurrentGame().getCurrentPlayer();
        for (Animal animal : player.getAnimals()) {
            if (animal.getName().equals(name)) {
                float cost = (float) (animal.getPrice() * ((double) animal.getFriendship() / 1000 + 0.3));
                player.setMoney(player.getMoney() + (int)cost);
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
