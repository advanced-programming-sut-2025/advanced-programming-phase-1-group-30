package models.Buildings;

import models.Items.ItemsInteface;
import models.TimeAndDate.Season;

public enum SaloonCosts implements ItemsInteface {
    Beer("Beer", 400, Integer.MAX_VALUE, Season.ALL),
    Salad("Salad", 220, Integer.MAX_VALUE, Season.ALL),
    Bread("Bread", 120, Integer.MAX_VALUE, Season.ALL),
    Spaghetti("Spaghetti", 240, Integer.MAX_VALUE, Season.ALL),
    Pizza("Pizza", 600, Integer.MAX_VALUE, Season.ALL),
    Coffee("Coffee", 300, Integer.MAX_VALUE, Season.ALL),
    HashbrownsRecipe("Hashbrowns Recipe", 50, 1, Season.ALL),
    OmeletRecipe("Omelet Recipe", 100, 1, Season.ALL),
    PancakesRecipe("Pancakes Recipe", 100, 1, Season.ALL),
    BreadRecipe("Bread Recipe", 100, 1, Season.ALL),
    TortillaRecipe("Tortilla Recipe", 100, 1, Season.ALL),
    PizzaRecipe("Pizza Recipe", 150, 1, Season.ALL),
    MakiRollRecipe("Maki Roll Recipe", 300, 1, Season.ALL),
    TripleShotEspressoRecipe("Triple Shot Espresso Recipe", 5000, 1, Season.ALL),
    CookieRecipe("Cookie Recipe", 300, 1, Season.ALL);


    private final String name;
    private final int cost;
    private final int dailyLimit;
    private final Season season;

    SaloonCosts(String name, int cost, int dailyLimit, Season season) {
        this.name = name;
        this.cost = cost;
        this.dailyLimit = dailyLimit;
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }

    public Season getSeason() {
        return season;
    }
}
