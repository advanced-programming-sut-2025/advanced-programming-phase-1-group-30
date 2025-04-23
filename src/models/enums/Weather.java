package models.enums;

public enum Weather {
    SUNNY("spring"),
    RAIN("spring"),
    STORM("storm"),
    SNOW("snow");
    public final String name;

    Weather(String name) {
        this.name = name;
    }
}
