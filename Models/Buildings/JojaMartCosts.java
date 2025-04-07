package Models.Buildings;

public enum JojaMartCosts {
    // --- Permanent Stock ---
    JojaCola(75, Integer.MAX_VALUE, Season.All),
    AncientSeed(500, 1, Season.All),
    GrassStarter(125, Integer.MAX_VALUE, Season.All),
    Sugar(125, Integer.MAX_VALUE, Season.All),
    WheatFlour(125, Integer.MAX_VALUE, Season.All),
    Rice(250, Integer.MAX_VALUE, Season.All),

    // --- Spring Stock ---
    ParsnipSeeds(25, 5, Season.Spring),
    BeanStarter(75, 5, Season.Spring),
    CauliflowerSeeds(100, 5, Season.Spring),
    PotatoSeeds(62, 5, Season.Spring),
    StrawberrySeeds(100, 5, Season.Spring),
    TulipBulb(25, 5, Season.Spring),
    KaleSeeds(87, 5, Season.Spring),
    CoffeeBeansSpring(200, 1, Season.Spring),
    CarrotSeeds(5, 10, Season.Spring),
    RhubarbSeeds(100, 5, Season.Spring),
    JazzSeeds(37, 5, Season.Spring),

    // --- Summer Stock ---
    TomatoSeeds(62, 5, Season.Summer),
    PepperSeeds(50, 5, Season.Summer),
    WheatSeedsSummer(12, 10, Season.Summer),
    SummerSquashSeeds(10, 10, Season.Summer),
    RadishSeeds(50, 5, Season.Summer),
    MelonSeeds(100, 5, Season.Summer),
    HopsStarter(75, 5, Season.Summer),
    PoppySeeds(125, 5, Season.Summer),
    SpangleSeeds(62, 5, Season.Summer),
    StarfruitSeeds(400, 5, Season.Summer),
    CoffeeBeansSummer(200, 1, Season.Summer),
    SunflowerSeedsSummer(125, 5, Season.Summer),

    // --- Fall Stock ---
    CornSeeds(187, 5, Season.Fall),
    EggplantSeeds(25, 5, Season.Fall),
    PumpkinSeeds(125, 5, Season.Fall),
    BroccoliSeeds(15, 5, Season.Fall),
    AmaranthSeeds(87, 5, Season.Fall),
    GrapeStarter(75, 5, Season.Fall),
    BeetSeeds(20, 5, Season.Fall),
    YamSeeds(75, 5, Season.Fall),
    BokChoySeeds(62, 5, Season.Fall),
    CranberrySeeds(300, 5, Season.Fall),
    SunflowerSeedsFall(125, 5, Season.Fall),
    FairySeeds(250, 5, Season.Fall),
    RareSeed(1000, 1, Season.Fall),
    WheatSeedsFall(12, 5, Season.Fall),

    // --- Winter Stock ---
    PowdermelonSeeds(20, 10, Season.Winter);

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
