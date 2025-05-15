package models.Items.Products;

import models.Items.ItemsInteface;
import models.TimeAndDate.Season;

public enum ForagingTreeType implements ItemsInteface {
    ACORNS("Acorns", Season.ALL),
    MAPLE_SEEDS("Maple Seeds", Season.ALL),
    PINE_CONES("Pine Cones", Season.ALL),
    MAHOGANY_SEEDS("Mahogany Seeds", Season.ALL),
    MUSHROOM_TREE_SEEDS("Mushroom Tree Seeds", Season.ALL);

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
