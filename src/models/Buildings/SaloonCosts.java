package models.Buildings;

public enum SaloonCosts {
    Beer("Beer", 400, Integer.MAX_VALUE),
    Salad("Salad", 220, Integer.MAX_VALUE),
    Bread("Bread", 120, Integer.MAX_VALUE),
    Spaghetti("Spaghetti", 240, Integer.MAX_VALUE),
    Pizza("Pizza", 600, Integer.MAX_VALUE),
    Coffee("Coffee", 300, Integer.MAX_VALUE),
    HashbrownsRecipe("Hashbrowns Recipe", 50, 1),
    OmeletRecipe("Omelet Recipe", 100, 1),
    PancakesRecipe("Pancakes Recipe", 100, 1),
    BreadRecipe("Bread Recipe", 100, 1),
    TortillaRecipe("Tortilla Recipe", 100, 1),
    PizzaRecipe("Pizza Recipe", 150, 1),
    MakiRollRecipe("Maki Roll Recipe", 300, 1),
    TripleShotEspressoRecipe("Triple Shot Espresso Recipe", 5000, 1),
    CookieRecipe("Cookie Recipe", 300, 1);


    private final String name;
    private final int cost;
    private final int dailyLimit;

    SaloonCosts(String name, int cost, int dailyLimit) {
        this.name = name;
        this.cost = cost;
        this.dailyLimit = dailyLimit;
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
}
