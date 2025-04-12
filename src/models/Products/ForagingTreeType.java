package models.Products;

import models.enums.Season;

public enum ForagingTreeType {
    test("", null);

    private final String name;
    private final Season season;

    private ForagingTreeType(String name, Season season) {
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
