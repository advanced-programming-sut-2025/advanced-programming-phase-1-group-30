package AP.group30.StardewValley.models.Items.Foods;

import java.util.ArrayList;
import java.util.List;

import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import com.badlogic.gdx.graphics.Texture;

public enum FoodType implements ItemsInteface {
    FRIED_EGG("fried egg", new ArrayList<>(List.of(new Item(1, "egg", 0, ItemTexture.WOOD.getTexture()))), 50, "-", "starter", 35, ItemTexture.WOOD.getTexture()),
    BAKED_FISH("baked fish", new ArrayList<>(List.of(new Item(1, "sardine", 0, ItemTexture.WOOD.getTexture()), new Item(1, "salmon", 0, ItemTexture.WOOD.getTexture()), new Item(1, "wheat", 0, ItemTexture.WOOD.getTexture()))), 75, "-", "starter", 100, ItemTexture.WOOD.getTexture()),
    SALAD("salad", new ArrayList<>(List.of(new Item(1, "leek", 0, ItemTexture.WOOD.getTexture()), new Item(1, "dandelion", 0, ItemTexture.WOOD.getTexture()))), 113, "-", "starter", 110, ItemTexture.WOOD.getTexture()),
    OLMELET("olmelet", new ArrayList<>(List.of(new Item(1, "egg", 0, ItemTexture.WOOD.getTexture()), new Item(1, "milk", 0, ItemTexture.WOOD.getTexture()))), 100, "-", "stardrop saloon", 125, ItemTexture.WOOD.getTexture()),
    PUMPKIN_PIE("pumpkin pie", new ArrayList<>(List.of(new Item(1, "pumpkin", 0, ItemTexture.WOOD.getTexture()), new Item(1, "wheat flour", 0, ItemTexture.WOOD.getTexture()), new Item(1, "milk", 0, ItemTexture.WOOD.getTexture()), new Item(1, "sugar", 0, ItemTexture.WOOD.getTexture()))), 225, "-", "stardrop saloon", 385, ItemTexture.WOOD.getTexture()),
    SPAGHETTI("spaghetti", new ArrayList<>(List.of(new Item(1, "wheat flour", 0, ItemTexture.WOOD.getTexture()), new Item(1, "tomato", 0, ItemTexture.WOOD.getTexture()))), 75, "-", "stardrop saloon", 120, ItemTexture.WOOD.getTexture()),
    PIZZA("pizza", new ArrayList<>(List.of(new Item(1, "wheat flour", 0, ItemTexture.WOOD.getTexture()), new Item(1, "tomato", 0, ItemTexture.WOOD.getTexture()), new Item(1, "cheese", 0, ItemTexture.WOOD.getTexture()))), 150, "-", "stardrop saloon", 300, ItemTexture.WOOD.getTexture()),
    TORTILLA("tortilla", new ArrayList<>(List.of(new Item(1, "corn", 0, ItemTexture.WOOD.getTexture()))), 50, "-", "stardrop saloon", 50, ItemTexture.WOOD.getTexture()),
    MAKI_ROLL("maki roll", new ArrayList<>(List.of(new Item(1, "any fish", 0, ItemTexture.WOOD.getTexture()), new Item(1, "rice", 0, ItemTexture.WOOD.getTexture()), new Item(1, "fiber", 0, ItemTexture.WOOD.getTexture()))), 100, "-", "stardrop saloon", 220, ItemTexture.WOOD.getTexture()),
    TRIPLE_SHOT_ESPRESSO("triple shot espresso", new ArrayList<>(List.of(new Item(3, "coffee", 0, ItemTexture.WOOD.getTexture()))), 200, "Max Energy +100 (5 hours)", "stardrop saloon", 450, ItemTexture.WOOD.getTexture()),
    COOKIE("cookie", new ArrayList<>(List.of(new Item(1, "wheat flour", 0, ItemTexture.WOOD.getTexture()), new Item(1, "sugar", 0, ItemTexture.WOOD.getTexture()), new Item(1, "egg", 0, ItemTexture.WOOD.getTexture()))), 90, "-", "stardrop saloon", 140, ItemTexture.WOOD.getTexture()),
    HASH_BROWNS("hash browns", new ArrayList<>(List.of(new Item(1, "potato", 0, ItemTexture.WOOD.getTexture()), new Item(1, "oil", 0, ItemTexture.WOOD.getTexture()))), 90, "Farming (5 hours)", "stardrop saloon", 120, ItemTexture.WOOD.getTexture()),
    PANCAKES("pancakes", new ArrayList<>(List.of(new Item(1, "wheat flour", 0, ItemTexture.WOOD.getTexture()), new Item(1, "egg", 0, ItemTexture.WOOD.getTexture()))), 90, "Foraging (11 hours)", "stardrop saloon", 80, ItemTexture.WOOD.getTexture()),
    FRUIT_SALAD("fruit salad", new ArrayList<>(List.of(new Item(1, "blueberry", 0, ItemTexture.WOOD.getTexture()), new Item(1, "melon", 0, ItemTexture.WOOD.getTexture()), new Item(1, "apricot", 0, ItemTexture.WOOD.getTexture()))), 263, "-", "stardrop saloon", 450, ItemTexture.WOOD.getTexture()),
    RED_PLATE("red plate", new ArrayList<>(List.of(new Item(1, "red cabbage", 0, ItemTexture.WOOD.getTexture()), new Item(1, "radish", 0, ItemTexture.WOOD.getTexture()))), 240, "Max Energy +50 (3 hours)", "stardrop saloon", 400, ItemTexture.WOOD.getTexture()),
    BREAD("bread", new ArrayList<>(List.of(new Item(1, "wheat flour", 0, ItemTexture.WOOD.getTexture()))), 50, "-", "stardrop saloon", 60, ItemTexture.WOOD.getTexture()),
    SALMON_DINNER("salmon dinner", new ArrayList<>(List.of(new Item(1, "salmon", 0, ItemTexture.WOOD.getTexture()), new Item(1, "amaranth", 0, ItemTexture.WOOD.getTexture()), new Item(1, "kale", 0, ItemTexture.WOOD.getTexture()))), 125, "-", "Leah reward", 300, ItemTexture.WOOD.getTexture()),
    VEGETABLE_MEDLEY("vegetable medley", new ArrayList<>(List.of(new Item(1, "tomato", 0, ItemTexture.WOOD.getTexture()), new Item(1, "beet", 0, ItemTexture.WOOD.getTexture()))), 165, "-", "Foraging Level 2", 120, ItemTexture.WOOD.getTexture()),
    FARMERS_LUNCH("farmer's lunch", new ArrayList<>(List.of(new Item(1, "omelet", 0, ItemTexture.WOOD.getTexture()), new Item(1, "parsnip", 0, ItemTexture.WOOD.getTexture()))), 200, "Farming (5 hours)", "Farming level 1", 150, ItemTexture.WOOD.getTexture()),
    SURVIVAL_BURGER("survival burger", new ArrayList<>(List.of(new Item(1, "bread", 0, ItemTexture.WOOD.getTexture()), new Item(1, "carrot", 0, ItemTexture.WOOD.getTexture()), new Item(1, "eggplant", 0, ItemTexture.WOOD.getTexture()))), 125, "Foraging (5 hours)", "Foraging level 3", 180, ItemTexture.WOOD.getTexture()),
    DISH_O_THE_SEA("dish o' the sea", new ArrayList<>(List.of(new Item(2, "sardine", 0, ItemTexture.WOOD.getTexture()), new Item(1, "hash browns", 0, ItemTexture.WOOD.getTexture()))), 150, "Fishing (5 hours)", "Fishing level 2", 220, ItemTexture.WOOD.getTexture()),
    SEAFORM_PUDDING("seaform pudding", new ArrayList<>(List.of(new Item(1, "flounder", 0, ItemTexture.WOOD.getTexture()), new Item(1, "midnight carp", 0, ItemTexture.WOOD.getTexture()))), 175, "Fishing (10 hours)", "Fishing level 3", 300, ItemTexture.WOOD.getTexture()),
    MINERS_TREAT("Miner's Treat", new ArrayList<>(List.of(new Item(2, "carrot", 0, ItemTexture.WOOD.getTexture()), new Item(1, "sugar", 0, ItemTexture.WOOD.getTexture()), new Item(1, "milk", 0, ItemTexture.WOOD.getTexture()))), 125, "Mining (5 hours)", "Mining level 1", 200, ItemTexture.WOOD.getTexture());


    private final String name;
    private final ArrayList<Item> ingredients;
    private final int energy;
    private final String buff;
    private final String source;
    private final int sellPrice;
    private final Texture texture;

    private FoodType(String name, ArrayList<Item> ingredients, int energy, String buff, String source, int sellPrice, Texture texture) {
        this.name = name;
        this.ingredients = ingredients;
        this.energy = energy;
        this.buff = buff;
        this.source = source;
        this.sellPrice = sellPrice;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }
    public ArrayList<Item> getIngredients() {
        return ingredients;
    }
    public int getEnergy() {
        return energy;
    }
    public String getBuff() {
        return buff;
    }
    public String getSource() {
        return source;
    }
    public int getPrice() {
        return sellPrice;
    }
    public Texture getTexture() {
        return texture;
    }

    public static FoodType getrecipeByName(String name) {
        for (FoodType recipe : FoodType.values()) {
            if (recipe.name.equals(name)) return recipe;
        }

        return null;
    }
}
