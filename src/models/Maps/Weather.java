package models.Maps;

public enum Weather {
    SUNNY("sunny"),
    RAIN("rainy"),
    STORM("storm"),
    SNOW("snowy");
    public final String name;

    Weather(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
