package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.TimeAndDate.Season;

public enum JojaMartCosts implements ItemsInteface {
    // --- Permanent Stock ---
    JojaCola("joja cola", 75, Integer.MAX_VALUE, Season.ALL),
    AncientSeed("ancient seed", 500, 1, Season.ALL),
    GrassStarter("grass starter", 125, Integer.MAX_VALUE, Season.ALL),
    Sugar("sugar", 125, Integer.MAX_VALUE, Season.ALL),
    WheatFlour("wheat flour", 125, Integer.MAX_VALUE, Season.ALL),
    Rice("rice", 250, Integer.MAX_VALUE, Season.ALL),

    // --- Spring Stock ---
    ParsnipSeeds("parsnip seeds", 25, 5, Season.SPRING),
    BeanStarter("bean starter", 75, 5, Season.SPRING),
    CauliflowerSeeds("cauliflower seeds", 100, 5, Season.SPRING),
    PotatoSeeds("potato seeds", 62, 5, Season.SPRING),
    StrawberrySeeds("strawberry seeds", 100, 5, Season.SPRING),
    TulipBulb("tulip bulb", 25, 5, Season.SPRING),
    KaleSeeds("kale seeds", 87, 5, Season.SPRING),
    CoffeeBeansSpring("Coffee Beans (Spring)", 200, 1, Season.SPRING),
    CarrotSeeds("carrot seeds", 5, 10, Season.SPRING),
    RhubarbSeeds("rhubarb seeds", 100, 5, Season.SPRING),
    JazzSeeds("jazz seeds", 37, 5, Season.SPRING),

    // --- Summer Stock ---
    TomatoSeeds("tomato seeds", 62, 5, Season.SUMMER),
    PepperSeeds("pepper seeds", 50, 5, Season.SUMMER),
    WheatSeedsSummer("Wheat Seeds (Summer)", 12, 10, Season.SUMMER),
    SummerSquashSeeds("Summer Squash Seeds", 10, 10, Season.SUMMER),
    RadishSeeds("radish seeds", 50, 5, Season.SUMMER),
    MelonSeeds("melon seeds", 100, 5, Season.SUMMER),
    HopsStarter("hops starter", 75, 5, Season.SUMMER),
    PoppySeeds("poppy seeds", 125, 5, Season.SUMMER),
    SpangleSeeds("spangle seeds", 62, 5, Season.SUMMER),
    StarfruitSeeds("starfruit seeds", 400, 5, Season.SUMMER),
    CoffeeBeansSummer("Coffee Beans (Summer)", 200, 1, Season.SUMMER),
    SunflowerSeedsSummer("Sunflower Seeds (Summer)", 125, 5, Season.SUMMER),

    // --- Fall Stock ---
    CornSeeds("corn seeds", 187, 5, Season.FALL),
    EggplantSeeds("eggplant seeds", 25, 5, Season.FALL),
    PumpkinSeeds("pumpkin seeds", 125, 5, Season.FALL),
    BroccoliSeeds("broccoli seeds", 15, 5, Season.FALL),
    AmaranthSeeds("amaranth seeds", 87, 5, Season.FALL),
    GrapeStarter("grape starter", 75, 5, Season.FALL),
    BeetSeeds("beet seeds", 20, 5, Season.FALL),
    YamSeeds("yam seeds", 75, 5, Season.FALL),
    BokChoySeeds("Bok Choy Seeds", 62, 5, Season.FALL),
    CranberrySeeds("cranberry seeds", 300, 5, Season.FALL),
    SunflowerSeedsFall("Sunflower Seeds (Fall)", 125, 5, Season.FALL),
    FairySeeds("fairy seeds", 250, 5, Season.FALL),
    RareSeed("rare seed", 1000, 1, Season.FALL),
    WheatSeedsFall("Wheat Seeds (Fall)", 12, 5, Season.FALL),

    // --- Winter Stock ---
    PowdermelonSeeds("powdermelon seeds", 20, 10, Season.WINTER);

    private final String name;
    private final int cost;
    private final int dailyLimit;
    private final Season season;

    JojaMartCosts(String name, int cost, int dailyLimit, Season season) {
        this.name = name;
        this.cost = cost;
        this.dailyLimit = dailyLimit;
        this.season = season;
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
}
