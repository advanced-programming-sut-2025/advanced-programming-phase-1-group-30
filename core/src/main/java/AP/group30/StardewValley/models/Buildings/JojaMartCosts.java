package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.TimeAndDate.Season;
import com.badlogic.gdx.graphics.Texture;

public enum JojaMartCosts implements ItemsInteface {
    // --- Permanent Stock ---
    JojaCola("joja cola", 75, Integer.MAX_VALUE, Season.ALL, ItemTexture.WOOD.getTexture()),
    AncientSeed("ancient seed", 500, 1, Season.ALL, ItemTexture.WOOD.getTexture()),
    GrassStarter("grass starter", 125, Integer.MAX_VALUE, Season.ALL, ItemTexture.WOOD.getTexture()),
    Sugar("sugar", 125, Integer.MAX_VALUE, Season.ALL, ItemTexture.WOOD.getTexture()),
    WheatFlour("wheat flour", 125, Integer.MAX_VALUE, Season.ALL, ItemTexture.WOOD.getTexture()),
    Rice("rice", 250, Integer.MAX_VALUE, Season.ALL, ItemTexture.WOOD.getTexture()),

    // --- Spring Stock ---
    ParsnipSeeds("parsnip seeds", 25, 5, Season.SPRING, ItemTexture.WOOD.getTexture()),
    BeanStarter("bean starter", 75, 5, Season.SPRING, ItemTexture.WOOD.getTexture()),
    CauliflowerSeeds("cauliflower seeds", 100, 5, Season.SPRING, ItemTexture.WOOD.getTexture()),
    PotatoSeeds("potato seeds", 62, 5, Season.SPRING, ItemTexture.WOOD.getTexture()),
    StrawberrySeeds("strawberry seeds", 100, 5, Season.SPRING, ItemTexture.WOOD.getTexture()),
    TulipBulb("tulip bulb", 25, 5, Season.SPRING, ItemTexture.WOOD.getTexture()),
    KaleSeeds("kale seeds", 87, 5, Season.SPRING, ItemTexture.WOOD.getTexture()),
    CoffeeBeansSpring("Coffee Beans (Spring)", 200, 1, Season.SPRING, ItemTexture.WOOD.getTexture()),
    CarrotSeeds("carrot seeds", 5, 10, Season.SPRING, ItemTexture.WOOD.getTexture()),
    RhubarbSeeds("rhubarb seeds", 100, 5, Season.SPRING, ItemTexture.WOOD.getTexture()),
    JazzSeeds("jazz seeds", 37, 5, Season.SPRING, ItemTexture.WOOD.getTexture()),

    // --- Summer Stock ---
    TomatoSeeds("tomato seeds", 62, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    PepperSeeds("pepper seeds", 50, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    WheatSeedsSummer("Wheat Seeds (Summer)", 12, 10, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    SummerSquashSeeds("Summer Squash Seeds", 10, 10, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    RadishSeeds("radish seeds", 50, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    MelonSeeds("melon seeds", 100, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    HopsStarter("hops starter", 75, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    PoppySeeds("poppy seeds", 125, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    SpangleSeeds("spangle seeds", 62, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    StarfruitSeeds("starfruit seeds", 400, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    CoffeeBeansSummer("Coffee Beans (Summer)", 200, 1, Season.SUMMER, ItemTexture.WOOD.getTexture()),
    SunflowerSeedsSummer("Sunflower Seeds (Summer)", 125, 5, Season.SUMMER, ItemTexture.WOOD.getTexture()),

    // --- Fall Stock ---
    CornSeeds("corn seeds", 187, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    EggplantSeeds("eggplant seeds", 25, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    PumpkinSeeds("pumpkin seeds", 125, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    BroccoliSeeds("broccoli seeds", 15, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    AmaranthSeeds("amaranth seeds", 87, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    GrapeStarter("grape starter", 75, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    BeetSeeds("beet seeds", 20, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    YamSeeds("yam seeds", 75, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    BokChoySeeds("Bok Choy Seeds", 62, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    CranberrySeeds("cranberry seeds", 300, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    SunflowerSeedsFall("Sunflower Seeds (Fall)", 125, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    FairySeeds("fairy seeds", 250, 5, Season.FALL, ItemTexture.WOOD.getTexture()),
    RareSeed("rare seed", 1000, 1, Season.FALL, ItemTexture.WOOD.getTexture()),
    WheatSeedsFall("Wheat Seeds (Fall)", 12, 5, Season.FALL, ItemTexture.WOOD.getTexture()),

    // --- Winter Stock ---
    PowdermelonSeeds("powdermelon seeds", 20, 10, Season.WINTER, ItemTexture.WOOD.getTexture());

    private final String name;
    private final int cost;
    private final int dailyLimit;
    private final Season season;
    private final Texture texture;

    JojaMartCosts(String name, int cost, int dailyLimit, Season season, Texture texture) {
        this.name = name;
        this.cost = cost;
        this.dailyLimit = dailyLimit;
        this.season = season;
        this.texture = texture;
    }

    // Getters
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

    public Texture getTexture() {
        return texture;
    }
}
