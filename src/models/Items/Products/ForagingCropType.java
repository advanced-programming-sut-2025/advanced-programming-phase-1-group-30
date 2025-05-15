package models.Items.Products;

import models.Items.ItemsInteface;
import models.TimeAndDate.Season;

public enum ForagingCropType implements ItemsInteface {
    COMMON_MUSHROOM("common mushroom", Season.ALL, 40, 38),
    DAFFODIL("daffodil", Season.SPRING, 30, 0),
    DANDELION("dandelion", Season.SPRING, 40, 25),
    LEEK("leek", Season.SPRING, 60, 40),
    MOREL("morel", Season.SPRING, 150, 20),
    SALMONBERRY("salmonberry", Season.SPRING, 5, 25),
    SPRING_ONION("spring onion", Season.SPRING, 8, 13),
    WILD_HORSERADISH("wild horseradish", Season.SPRING, 50, 13),
    FIDDLEHEAD_FERN("fiddlehead fern", Season.SUMMER, 90, 25),
    GRAPE("grape", Season.SUMMER, 80, 38),
    RED_MUSHROOM("red mushroom", Season.SUMMER, 75, -50),
    SPICE_BERRY("spice berry", Season.SUMMER, 80, 25),
    SWEET_PEA("sweet pea", Season.SUMMER, 50, 0),
    BLACKBERRY("blackberry", Season.FALL, 25, 25),
    CHANTERELLE("chanterelle", Season.FALL, 160, 75),
    HAZELNUT("hazelnut", Season.FALL, 40, 38),
    PURPLE_MUSHROOM("purple mushroom", Season.FALL, 90, 30),
    WILD_PLUM("wild plum", Season.FALL, 80, 25),
    CROCUS("crocus", Season.WINTER, 60, 0),
    CRYSTAL_FRUIT("crystal fruit", Season.WINTER, 150, 63),
    HOLLY("holly", Season.WINTER, 80, -37),
    SNOW_YAM("snow yam", Season.WINTER, 100, 30),
    WINTER_ROOT("winter root", Season.WINTER, 70, 25);

    private final String name;
    private final Season season;
    private final int baseSellPrice;
    private final int energy;

    private ForagingCropType(String name, Season season, int baseSellPrice, int energy) {
        this.name = name;
        this.season = season;
        this.baseSellPrice = baseSellPrice;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }
    public Season getSeason() {
        return season;
    }
    public int getBaseSellPrice() {
        return baseSellPrice;
    }
    public int getEnergy() {
        return energy;
    }
}
