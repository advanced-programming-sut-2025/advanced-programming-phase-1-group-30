package models.Animals;

import models.TimeAndDate.Season;

public enum Fish {
    SALMON("Salmon", 75, Season.FALL),
    SARDINE("Sardine", 40, Season.FALL),
    SHAD("Shad", 60, Season.FALL),
    BLUE_DISCUS("Blue Discus", 120, Season.FALL),
    MIDNIGHT_CARP("Midnight Carp", 150, Season.WINTER),
    SQUID("Squid", 80, Season.WINTER),
    TUNA("Tuna", 100, Season.WINTER),
    PERCH("Perch", 55, Season.WINTER),
    FLOUNDER("Flounder", 100, Season.SPRING),
    LIONFISH("Lionfish", 100, Season.SPRING),
    HERRING("Herring", 30, Season.SPRING),
    GHOSTFISH("Ghostfish", 45, Season.SPRING),
    TILAPIA("Tilapia", 75, Season.SUMMER),
    DORADO("Dorado", 100, Season.SUMMER),
    SUNFISH("Sunfish", 30, Season.SUMMER),
    RAINBOW_TROUT("Rainbow Trout", 65, Season.SUMMER),

    // Legendary Fish
    LEGEND("Legend", 5000, Season.SPRING),
    GLACIERFISH("Glacierfish", 1000, Season.WINTER),
    ANGLER("Angler", 900, Season.FALL),
    CRIMSONFISH("Crimsonfish", 1500, Season.SUMMER);

    private final String displayName;
    private final int basePrice;
    private final Season season;

    Fish(String displayName, int basePrice, Season season) {
        this.displayName = displayName;
        this.basePrice = basePrice;
        this.season = season;
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
}
