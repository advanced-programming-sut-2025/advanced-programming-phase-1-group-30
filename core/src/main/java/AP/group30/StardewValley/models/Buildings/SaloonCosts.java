package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.TimeAndDate.Season;
import com.badlogic.gdx.graphics.Texture;

public enum SaloonCosts implements ItemsInteface {
    Beer("beer", 400, Integer.MAX_VALUE, Season.ALL, ItemTexture.BEER.getTexture()),
    Salad("salad", 220, Integer.MAX_VALUE, Season.ALL, ItemTexture.SALAD.getTexture()),
    Bread("bread", 120, Integer.MAX_VALUE, Season.ALL, ItemTexture.BREAD.getTexture()),
    Spaghetti("spaghetti", 240, Integer.MAX_VALUE, Season.ALL, ItemTexture.SPAGHETTI.getTexture()),
    Pizza("pizza", 600, Integer.MAX_VALUE, Season.ALL, ItemTexture.PIZZA.getTexture()),
    Coffee("coffee", 300, Integer.MAX_VALUE, Season.ALL, ItemTexture.COFFEE.getTexture()),
    HashbrownsRecipe("hashbrowns recipe", 50, 1, Season.ALL, ItemTexture.HASH_BROWNS.getTexture()),
    OmeletRecipe("omelet recipe", 100, 1, Season.ALL, ItemTexture.OMELET.getTexture()),
    PancakesRecipe("pancakes recipe", 100, 1, Season.ALL, ItemTexture.PANCAKES.getTexture()),
    BreadRecipe("bread recipe", 100, 1, Season.ALL, ItemTexture.BREAD.getTexture()),
    TortillaRecipe("tortilla recipe", 100, 1, Season.ALL, ItemTexture.TORTILLA.getTexture()),
    PizzaRecipe("pizza recipe", 150, 1, Season.ALL, ItemTexture.PIZZA.getTexture()),
    MakiRollRecipe("maki roll recipe", 300, 1, Season.ALL, ItemTexture.MAKI_ROLL.getTexture()),
    TripleShotEspressoRecipe("triple shot espresso recipe", 5000, 1, Season.ALL, ItemTexture.TRIPLE_SHOT_ESPRESSO.getTexture()),
    CookieRecipe("cookie recipe", 300, 1, Season.ALL, ItemTexture.COOKIE.getTexture());


    private final String name;
    private final int cost;
    private final int dailyLimit;
    private final Season season;
    private final Texture texture;

    SaloonCosts(String name, int cost, int dailyLimit, Season season, Texture texture) {
        this.name = name;
        this.cost = cost;
        this.dailyLimit = dailyLimit;
        this.season = season;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return cost;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }

    public Season getSeason() {
        return season;
    }

    public Texture getTexture() {
        return texture;
    }
}
