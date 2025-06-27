package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.TimeAndDate.Season;

public enum SaloonCosts implements ItemsInteface {
    Beer("beer", 400, Integer.MAX_VALUE, Season.ALL),
    Salad("salad", 220, Integer.MAX_VALUE, Season.ALL),
    Bread("bread", 120, Integer.MAX_VALUE, Season.ALL),
    Spaghetti("spaghetti", 240, Integer.MAX_VALUE, Season.ALL),
    Pizza("pizza", 600, Integer.MAX_VALUE, Season.ALL),
    Coffee("coffee", 300, Integer.MAX_VALUE, Season.ALL),
    HashbrownsRecipe("hashbrowns recipe", 50, 1, Season.ALL),
    OmeletRecipe("omelet recipe", 100, 1, Season.ALL),
    PancakesRecipe("pancakes recipe", 100, 1, Season.ALL),
    BreadRecipe("bread recipe", 100, 1, Season.ALL),
    TortillaRecipe("tortilla recipe", 100, 1, Season.ALL),
    PizzaRecipe("pizza recipe", 150, 1, Season.ALL),
    MakiRollRecipe("maki roll recipe", 300, 1, Season.ALL),
    TripleShotEspressoRecipe("triple shot espresso recipe", 5000, 1, Season.ALL),
    CookieRecipe("cookie recipe", 300, 1, Season.ALL);


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
