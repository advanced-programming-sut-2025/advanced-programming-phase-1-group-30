package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Items.Foods.FoodType;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.TimeAndDate.Season;
import com.badlogic.gdx.graphics.Texture;

public enum SaloonCosts implements ItemsInteface {
    Beer("beer", null, 400, Integer.MAX_VALUE, Season.ALL, ItemTexture.BEER.getTexture()),
    Salad("salad", null, 220, Integer.MAX_VALUE, Season.ALL, ItemTexture.SALAD.getTexture()),
    Bread("bread", null, 120, Integer.MAX_VALUE, Season.ALL, ItemTexture.BREAD.getTexture()),
    Spaghetti("spaghetti", null, 240, Integer.MAX_VALUE, Season.ALL, ItemTexture.SPAGHETTI.getTexture()),
    Pizza("pizza", null, 600, Integer.MAX_VALUE, Season.ALL, ItemTexture.PIZZA.getTexture()),
    Coffee("coffee", null, 300, Integer.MAX_VALUE, Season.ALL, ItemTexture.COFFEE.getTexture()),
    HashBrownsRecipe("hash browns recipe", FoodType.HASH_BROWNS, 50, 1, Season.ALL, ItemTexture.HASH_BROWNS.getTexture()),
    OmeletRecipe("omelet recipe", FoodType.OMELET, 100, 1, Season.ALL, ItemTexture.OMELET.getTexture()),
    PancakesRecipe("pancakes recipe", FoodType.PANCAKES, 100, 1, Season.ALL, ItemTexture.PANCAKES.getTexture()),
    BreadRecipe("bread recipe", FoodType.BREAD, 100, 1, Season.ALL, ItemTexture.BREAD.getTexture()),
    TortillaRecipe("tortilla recipe", FoodType.TORTILLA, 100, 1, Season.ALL, ItemTexture.TORTILLA.getTexture()),
    PizzaRecipe("pizza recipe", FoodType.PIZZA, 150, 1, Season.ALL, ItemTexture.PIZZA.getTexture()),
    MakiRollRecipe("maki roll recipe", FoodType.MAKI_ROLL, 300, 1, Season.ALL, ItemTexture.MAKI_ROLL.getTexture()),
    TripleShotEspressoRecipe("triple shot espresso recipe", FoodType.TRIPLE_SHOT_ESPRESSO, 5000, 1, Season.ALL, ItemTexture.TRIPLE_SHOT_ESPRESSO.getTexture()),
    CookieRecipe("cookie recipe", FoodType.COOKIE, 300, 1, Season.ALL, ItemTexture.COOKIE.getTexture()),
    FriedEggRecipe("fried egg recipe", FoodType.FRIED_EGG, 300, 1, Season.ALL, ItemTexture.FRIED_EGG.getTexture()),
    BakedFishRecipe("baked fish recipe", FoodType.BAKED_FISH, 300, 1, Season.ALL, ItemTexture.BAKED_FISH.getTexture()),
    SaladRecipe("salad recipe", FoodType.SALAD, 300, 1, Season.ALL, ItemTexture.SALAD.getTexture()),
    PumpkinPieRecipe("pumpkin pie recipe", FoodType.PUMPKIN_PIE, 300, 1, Season.ALL, ItemTexture.PUMPKIN_PIE.getTexture()),
    spaghettiRecipe("spaghetti recipe", FoodType.SPAGHETTI, 300, 1, Season.ALL, ItemTexture.SPAGHETTI.getTexture()),
    FruitSaladRecipe("fruit salad recipe", FoodType.FRUIT_SALAD, 300, 1, Season.ALL, ItemTexture.FRUIT_SALAD.getTexture()),
    RedPlateRecipe("red plate recipe", FoodType.RED_PLATE, 300, 1, Season.ALL, ItemTexture.RED_PLATE.getTexture()),
    SalmonDinnerRecipe("salmon dinner recipe", FoodType.SALMON_DINNER, 300, 1, Season.ALL, ItemTexture.SALMON_DINNER.getTexture()),
    VegetableMedleyRecipe("vegetable medley recipe", FoodType.VEGETABLE_MEDLEY, 300, 1, Season.ALL, ItemTexture.VEGETABLE_MEDLEY.getTexture()),
    FarmerLunchRecipe("farmer's lunch recipe", FoodType.FARMERS_LUNCH, 300, 1, Season.ALL, ItemTexture.FARMERS_LUNCH.getTexture()),
    SurvivalBurgerRecipe("survival burger recipe", FoodType.SURVIVAL_BURGER, 300, 1, Season.ALL, ItemTexture.SURVIVAL_BURGER.getTexture()),
    DishOTheSeaRecipe("dish o' the sea recipe", FoodType.DISH_O_THE_SEA, 300, 1, Season.ALL, ItemTexture.DISH_O_THE_SEA.getTexture()),
    SeafoamPuddingRecipe("seafoam pudding recipe", FoodType.SEAFOAM_PUDDING, 300, 1, Season.ALL, ItemTexture.SEAFOAM_PUDDING.getTexture()),
    MinerTreatRecipe("Miner's Treat recipe", FoodType.MINERS_TREAT, 300, 1, Season.ALL, ItemTexture.MINERS_TREAT.getTexture());


    private final String name;
    private final int cost;
    private final int dailyLimit;
    private final Season season;
    private final Texture texture;
    private final FoodType recipe;

    SaloonCosts(String name, FoodType recipe, int cost, int dailyLimit, Season season, Texture texture) {
        this.name = name;
        this.recipe = recipe;
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

    public FoodType getRecipe() {
        return recipe;
    }
}
