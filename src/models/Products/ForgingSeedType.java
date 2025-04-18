package models.Products;

import models.enums.Season;

public enum ForgingSeedType {
    test("", null);
    
    private final String name;
    private final Season season;

    private ForgingSeedType(String name, Season season) {
        this.name = name;
        this.season = season;
    }
    
    public String getName() {
        return name;
    }
    public Season getSeason() {
        return season;
    }
}
