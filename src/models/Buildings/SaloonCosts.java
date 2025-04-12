package models.Buildings;

public enum SaloonCosts {
    Beer(400, Integer.MAX_VALUE),
    Salad(220, Integer.MAX_VALUE),
    Bread(120, Integer.MAX_VALUE),
    Spaghetti(240, Integer.MAX_VALUE),
    Pizza(600, Integer.MAX_VALUE),
    Coffee(300, Integer.MAX_VALUE),
    HashbrownsRecipe(50, 1),
    OmeletRecipe(100, 1),
    PancakesRecipe(100, 1),
    BreadRecipe(100, 1),
    TortillaRecipe(100, 1),
    PizzaRecipe(150, 1),
    MakiRollRecipe(300, 1),
    TripleShotEspressoRecipe(5000, 1),
    CookieRecipe(300, 1);

    private final int cost;
    private final int dailyLimit;

    SaloonCosts(int cost, int dailyLimit) {
        this.cost = cost;
        this.dailyLimit = dailyLimit;
    }

    public int getCost() {
        return cost;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }
}
