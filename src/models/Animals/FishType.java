package models.Animals;

import models.TimeAndDate.Season;

public enum FishType {
    SALMON("salmon", 75, Season.FALL, false),
    SARDINE("sardine", 40, Season.FALL, false),
    SHAD("shad", 60, Season.FALL, false),
    BLUE_DISCUS("blue discus", 120, Season.FALL, false),
    MIDNIGHT_CARP("midnight carp", 150, Season.WINTER, false),
    SQUID("squid", 80, Season.WINTER, false),
    TUNA("tuna", 100, Season.WINTER, false),
    PERCH("perch", 55, Season.WINTER, false),
    FLOUNDER("flounder", 100, Season.SPRING, false),
    LIONFISH("lionfish", 100, Season.SPRING, false),
    HERRING("herring", 30, Season.SPRING, false),
    GHOSTFISH("ghostfish", 45, Season.SPRING, false),
    TILAPIA("tilapia", 75, Season.SUMMER, false),
    DORADO("dorado", 100, Season.SUMMER, false),
    SUNFISH("sunfish", 30, Season.SUMMER, false),
    RAINBOW_TROUT("rainbow trout", 65, Season.SUMMER, false),

    // Legendary Fish
    LEGEND("legend", 5000, Season.SPRING, true),
    GLACIERFISH("glacierfish", 1000, Season.WINTER, true),
    ANGLER("angler", 900, Season.FALL, true),
    CRIMSONFISH("crimsonfish", 1500, Season.SUMMER, true);

    private final String displayName;
    private final int basePrice;
    private final Season season;
    private final boolean legendary;

    FishType(String displayName, int basePrice, Season season, boolean legendary) {
        this.displayName = displayName;
        this.basePrice = basePrice;
        this.season = season;
        this.legendary = legendary;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    public int getBasePrice() {
        return basePrice;
    }
    public Season getSeason() {
        return season;
    }
    
    public boolean isLegendary() {
        return legendary;
    }
}
