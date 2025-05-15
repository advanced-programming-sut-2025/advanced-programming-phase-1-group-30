package models.Buildings;

import models.Items.ItemsInteface;
import models.TimeAndDate.Season;

public enum JojaMartCosts implements ItemsInteface {
    // --- Permanent Stock ---
    JojaCola("Joja Cola", 75, Integer.MAX_VALUE, Season.ALL),
    AncientSeed("Ancient Seed", 500, 1, Season.ALL),
    GrassStarter("Grass Starter", 125, Integer.MAX_VALUE, Season.ALL),
    Sugar("Sugar", 125, Integer.MAX_VALUE, Season.ALL),
    WheatFlour("Wheat Flour", 125, Integer.MAX_VALUE, Season.ALL),
    Rice("Rice", 250, Integer.MAX_VALUE, Season.ALL),

    // --- Spring Stock ---
    ParsnipSeeds("Parsnip Seeds", 25, 5, Season.SPRING),
    BeanStarter("Bean Starter", 75, 5, Season.SPRING),
    CauliflowerSeeds("Cauliflower Seeds", 100, 5, Season.SPRING),
    PotatoSeeds("Potato Seeds", 62, 5, Season.SPRING),
    StrawberrySeeds("Strawberry Seeds", 100, 5, Season.SPRING),
    TulipBulb("Tulip Bulb", 25, 5, Season.SPRING),
    KaleSeeds("Kale Seeds", 87, 5, Season.SPRING),
    CoffeeBeansSpring("Coffee Beans (Spring)", 200, 1, Season.SPRING),
    CarrotSeeds("Carrot Seeds", 5, 10, Season.SPRING),
    RhubarbSeeds("Rhubarb Seeds", 100, 5, Season.SPRING),
    JazzSeeds("Jazz Seeds", 37, 5, Season.SPRING),

    // --- Summer Stock ---
    TomatoSeeds("Tomato Seeds", 62, 5, Season.SUMMER),
    PepperSeeds("Pepper Seeds", 50, 5, Season.SUMMER),
    WheatSeedsSummer("Wheat Seeds (Summer)", 12, 10, Season.SUMMER),
    SummerSquashSeeds("Summer Squash Seeds", 10, 10, Season.SUMMER),
    RadishSeeds("Radish Seeds", 50, 5, Season.SUMMER),
    MelonSeeds("Melon Seeds", 100, 5, Season.SUMMER),
    HopsStarter("Hops Starter", 75, 5, Season.SUMMER),
    PoppySeeds("Poppy Seeds", 125, 5, Season.SUMMER),
    SpangleSeeds("Spangle Seeds", 62, 5, Season.SUMMER),
    StarfruitSeeds("Starfruit Seeds", 400, 5, Season.SUMMER),
    CoffeeBeansSummer("Coffee Beans (Summer)", 200, 1, Season.SUMMER),
    SunflowerSeedsSummer("Sunflower Seeds (Summer)", 125, 5, Season.SUMMER),

    // --- Fall Stock ---
    CornSeeds("Corn Seeds", 187, 5, Season.FALL),
    EggplantSeeds("Eggplant Seeds", 25, 5, Season.FALL),
    PumpkinSeeds("Pumpkin Seeds", 125, 5, Season.FALL),
    BroccoliSeeds("Broccoli Seeds", 15, 5, Season.FALL),
    AmaranthSeeds("Amaranth Seeds", 87, 5, Season.FALL),
    GrapeStarter("Grape Starter", 75, 5, Season.FALL),
    BeetSeeds("Beet Seeds", 20, 5, Season.FALL),
    YamSeeds("Yam Seeds", 75, 5, Season.FALL),
    BokChoySeeds("Bok Choy Seeds", 62, 5, Season.FALL),
    CranberrySeeds("Cranberry Seeds", 300, 5, Season.FALL),
    SunflowerSeedsFall("Sunflower Seeds (Fall)", 125, 5, Season.FALL),
    FairySeeds("Fairy Seeds", 250, 5, Season.FALL),
    RareSeed("Rare Seed", 1000, 1, Season.FALL),
    WheatSeedsFall("Wheat Seeds (Fall)", 12, 5, Season.FALL),

    // --- Winter Stock ---
    PowdermelonSeeds("Powdermelon Seeds", 20, 10, Season.WINTER);

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
