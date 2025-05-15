package models.Items.Products;

import models.Items.ItemsInteface;
import models.TimeAndDate.Season;

public enum ForagingTreeType implements ItemsInteface {
    ACORNS("acorns", Season.ALL),
    MAPLE_SEEDS("maple seeds", Season.ALL),
    PINE_CONES("pine cones", Season.ALL),
    MAHOGANY_SEEDS("mahogany seeds", Season.ALL),
    MUSHROOM_TREE_SEEDS("mushroom tree seeds", Season.ALL);

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
