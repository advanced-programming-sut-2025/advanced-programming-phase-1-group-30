package views;

import controllers.DateAndWeatherController;
import controllers.GameMenuController;
import controllers.NewGameController;
import models.Commands.GameMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class GameMenu implements AppMenu {
    public static void printResult(String result) {
        System.out.println(result);
    }
  
    @Override
    public void check(String command, Scanner scanner) {
        Matcher matcher;

        matcher = GameMenuCommands.GAME_NEW.regexMatcher(command);
        if (matcher.matches()) {
            String username1 = matcher.group("username1");
            String username2 = matcher.group("username2");
            String username3 = matcher.group("username3");

            NewGameController.NewGame(username1, username2, username3, scanner);
            return;
        }
        matcher = GameMenuCommands.LOAD_GAME.regexMatcher(command);
        if (matcher.matches()) {
            NewGameController.LoadGame();
            return;
        }
        matcher = GameMenuCommands.EXIT_GAME.regexMatcher(command);
        if (matcher.matches()) {
            NewGameController.ExitGame();
            return;
        }
        matcher = GameMenuCommands.NEXT_TURN.regexMatcher(command);
        if (matcher.matches()) {
            NewGameController.NextTurn();
            return;
        }
        matcher = GameMenuCommands.TIME.regexMatcher(command);
        if (matcher.matches()) {
            DateAndWeatherController.Time();
            return;
        }
        matcher = GameMenuCommands.CHEAT_TIME.regexMatcher(command);
        if (matcher.matches()) {
            DateAndWeatherController.cheatAdvanceTime(matcher.group("X"));
            return;
        }
        matcher = GameMenuCommands.DATE.regexMatcher(command);
        if (matcher.matches()) {
            DateAndWeatherController.Date();
            return;
        }
        matcher = GameMenuCommands.DATETIME.regexMatcher(command);
        if (matcher.matches()) {
            DateAndWeatherController.DateTime();
            return;
        }
        matcher = GameMenuCommands.DAY_OF_THE_WEEK.regexMatcher(command);
        if (matcher.matches()) {
            DateAndWeatherController.DayOfTheWeek();
            return;
        }
        matcher = GameMenuCommands.SEASON.regexMatcher(command);
        if (matcher.matches()) {
            DateAndWeatherController.Season();
            return;
        }
        matcher = GameMenuCommands.WEATHER.regexMatcher(command);
        if (matcher.matches()) {
            DateAndWeatherController.Weather();
            return;
        }
        matcher = GameMenuCommands.WEATHER_FORECAST.regexMatcher(command);
        if (matcher.matches()) {
            DateAndWeatherController.WeatherForecast();
            return;
        }
        matcher = GameMenuCommands.PRINT_MAP.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.printMap(matcher.group("x"), matcher.group("y"), matcher.group("size"));
            return;
        }
        matcher = GameMenuCommands.HELPREADINGMAP.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.helpReadingMap();
            return;
        }
        matcher = GameMenuCommands.WALK.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.walk(matcher.group("x"), matcher.group("y"));
            return;
        }
        matcher = GameMenuCommands.INVENTORY_SHOW.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.inventoryShow();
            return;
        }
        matcher = GameMenuCommands.INVENTORY_TRASH.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.inventoryTrash(matcher.group("itemName"), matcher.group("number"));
            return;
        }
        matcher = GameMenuCommands.EQUIP_TOOL.regexMatcher(command);
        if(matcher.matches()){
            String name = matcher.group("name");
            GameMenuController.ToolsEquip(name);
            return;
        }
        matcher = GameMenuCommands.CURRENT_TOOL.regexMatcher(command);
        if(matcher.matches()){
            GameMenuController.ShowCurrentTool();
            return;
        }
        matcher = GameMenuCommands.AVAILABLE_TOOLS.regexMatcher(command);
        if(matcher.matches()){
            GameMenuController.ShowAvailableTools();
            return;
        }
        matcher = GameMenuCommands.Tool_Use.regexMatcher(command);
        if(matcher.matches()){
            String direction = matcher.group("direction");
            GameMenuController.toolUse(direction);
            return;
        }
        matcher = GameMenuCommands.PLANT.regexMatcher(command);
        if(matcher.matches()){
            String seed = matcher.group("seed");
            String direction = matcher.group("direction");
            GameMenuController.plant(seed, direction);
            return;
        }
        matcher = GameMenuCommands.SHOW_PLANT.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.showPlant(matcher.group("x"), matcher.group("y"));
            return;
        }
        matcher = GameMenuCommands.ENERGY_SHOW.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.energyShow();
            return;
        }
        matcher = GameMenuCommands.ENERGY_SET.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.cheatEnergySet(matcher.group("value"));
            return;
        }
        matcher = GameMenuCommands.ENERGY_UNLIMITED.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.cheatUnlimitedEnergySet();
            return;
        }
        matcher = GameMenuCommands.CRAFT_INFO.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.craftInfo(matcher.group("craftName"));
            return;
        }

        matcher = GameMenuCommands.HOWMUCH_WATER.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.howMuchWater();
            return;
        }
        matcher = GameMenuCommands.CRAFTING_SHOW_RECIPES.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.showCraftingRecipes();
            return;
        }
        matcher = GameMenuCommands.CRAFTING_CRAFT.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.crafting(matcher.group("itemName"));
            return;
        }
        matcher = GameMenuCommands.PLACE_ITEM.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.placeItem(matcher.group("itemName"), matcher.group("direction"));
            return;
        }

        matcher = GameMenuCommands.COOKING_REFRIGERATOR.regexMatcher(command);
        if (matcher.matches()) {
            if (matcher.group("action").equals("put"))
                GameMenuController.putRefrigerator(matcher.group("item"));
            else if (matcher.group("action").equals("pick"))
                GameMenuController.putRefrigerator(matcher.group("item"));
            else
                printResult("You should just put or pick!");
            return;
        }
        matcher = GameMenuCommands.COOKING_SHOW_RECIPES.regexMatcher(command);
        if (matcher.matches()) {
            if (matcher.group("all") == null)
                GameMenuController.showCookingRecipe(false);
            else
                GameMenuController.showCookingRecipe(true);
            return;
        }
        matcher = GameMenuCommands.COOKING_ADD_RECIPE.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.addCookingRecipe(matcher.group("name"));
            return;
        }
        matcher = GameMenuCommands.COOKING_PREPARE.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.cooking(matcher.group("recipeName"));
            return;
        }
        matcher = GameMenuCommands.EAT.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.eat(matcher.group("foodName"));
            return;
        }
        matcher = GameMenuCommands.FISHING.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.fishing(matcher.group("fishingPole"));
            return;
        }
        matcher = GameMenuCommands.BUILD.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.build(matcher.group("buildingName"), matcher.group("x"), matcher.group("y"));
            return;
        }
        matcher = GameMenuCommands.BUY_ANIMAL.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.buyAnimal(matcher.group("animal"), matcher.group("name"));
            return;
        }
        matcher = GameMenuCommands.PET.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.fishing(matcher.group("name"));
            return;
        }
        matcher = GameMenuCommands.CHEAT_SET_FRIENDSHIP.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.cheatSetFriendship(matcher.group("animalName"), matcher.group("amount"));
            return;
        }
        matcher = GameMenuCommands.SHEPHERD_ANIMALS.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.shepherdAnimals(matcher.group("animalName"), matcher.group("x"), matcher.group("y"));
            return;
        }
        matcher = GameMenuCommands.FEED_HAY.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.feedHay(matcher.group("animalName"));
            return;
        }
        matcher = GameMenuCommands.PRODUCES.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.produces();
            return;
        }
        matcher = GameMenuCommands.COLLECT_PRODUCE.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.collectProduce(matcher.group("name"));
            return;
        }
        matcher = GameMenuCommands.SELL_ANIMAL.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.sellAnimal(matcher.group("name"));
            return;
        }
        matcher = GameMenuCommands.SHOW_ALL_PRODUCTS.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.showAllProducts();
            return;
        }
        matcher = GameMenuCommands.SHOW_ALL_AVAILABLE_PRODUCTS.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.showAllProducts(); //TODO only availabls
            return;
        }
        matcher = GameMenuCommands.PURCHASE.regexMatcher(command);
        if (matcher.matches()) {
            // TODO -n is null
            GameMenuController.purchase(matcher.group("productName"), Integer.parseInt(matcher.group("count")));
            return;
        }
        matcher = GameMenuCommands.CHEAT_ADD_DOLLARS.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.cheatAddMoney(Integer.parseInt(matcher.group("count")));
            return;
        }
        matcher = GameMenuCommands.SELL.regexMatcher(command);
        if (matcher.matches()) {
            // TODO -n is null
            GameMenuController.sell(matcher.group("productName"), Integer.parseInt(matcher.group("count")));
            return;
        }
        matcher = GameMenuCommands.ARTISAN_USE.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.artisanUse(matcher.group("artisanName"), matcher.group("itemName"));
            return;
        }
        matcher = GameMenuCommands.ARTISAN_GET.regexMatcher(command);
        if (matcher.matches()) {
            GameMenuController.artisanGet(matcher.group("artisanName"));
            return;
        }


        System.out.println("Invalid command.");
    }
}
