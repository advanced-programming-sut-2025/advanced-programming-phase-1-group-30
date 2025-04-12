package models.Buildings;

import models.enums.Season;

public enum JojaMartCosts {
    // --- Permanent Stock ---
    JojaCola(75, Integer.MAX_VALUE, Season.ALL),
    AncientSeed(500, 1, Season.ALL),
    GrassStarter(125, Integer.MAX_VALUE, Season.ALL),
    Sugar(125, Integer.MAX_VALUE, Season.ALL),
    WheatFlour(125, Integer.MAX_VALUE, Season.ALL),
    Rice(250, Integer.MAX_VALUE, Season.ALL),

    // --- Spring Stock ---
    ParsnipSeeds(25, 5, Season.SPRING),
    BeanStarter(75, 5, Season.SPRING),
    CauliflowerSeeds(100, 5, Season.SPRING),
    PotatoSeeds(62, 5, Season.SPRING),
    StrawberrySeeds(100, 5, Season.SPRING),
    TulipBulb(25, 5, Season.SPRING),
    KaleSeeds(87, 5, Season.SPRING),
    CoffeeBeansSpring(200, 1, Season.SPRING),
    CarrotSeeds(5, 10, Season.SPRING),
    RhubarbSeeds(100, 5, Season.SPRING),
    JazzSeeds(37, 5, Season.SPRING),

    // --- Summer Stock ---
    TomatoSeeds(62, 5, Season.SUMMER),
    PepperSeeds(50, 5, Season.SUMMER),
    WheatSeedsSummer(12, 10, Season.SUMMER),
    SummerSquashSeeds(10, 10, Season.SUMMER),
    RadishSeeds(50, 5, Season.SUMMER),
    MelonSeeds(100, 5, Season.SUMMER),
    HopsStarter(75, 5, Season.SUMMER),
    PoppySeeds(125, 5, Season.SUMMER),
    SpangleSeeds(62, 5, Season.SUMMER),
    StarfruitSeeds(400, 5, Season.SUMMER),
    CoffeeBeansSummer(200, 1, Season.SUMMER),
    SunflowerSeedsSummer(125, 5, Season.SUMMER),

    // --- Fall Stock ---
    CornSeeds(187, 5, Season.FALL),
    EggplantSeeds(25, 5, Season.FALL),
    PumpkinSeeds(125, 5, Season.FALL),
    BroccoliSeeds(15, 5, Season.FALL),
    AmaranthSeeds(87, 5, Season.FALL),
    GrapeStarter(75, 5, Season.FALL),
    BeetSeeds(20, 5, Season.FALL),
    YamSeeds(75, 5, Season.FALL),
    BokChoySeeds(62, 5, Season.FALL),
    CranberrySeeds(300, 5, Season.FALL),
    SunflowerSeedsFall(125, 5, Season.FALL),
    FairySeeds(250, 5, Season.FALL),
    RareSeed(1000, 1, Season.FALL),
    WheatSeedsFall(12, 5, Season.FALL),

    // --- Winter Stock ---
    PowdermelonSeeds(20, 10, Season.WINTER);

    private final int cost;
    private final int dailyLimit;
    private final Season season;

    JojaMartCosts(int cost, int dailyLimit, Season season) {
        this.cost = cost;
        this.dailyLimit = dailyLimit;
        this.season = season;
    }

    // Getters
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
