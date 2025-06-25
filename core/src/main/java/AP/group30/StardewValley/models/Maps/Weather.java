package AP.group30.StardewValley.models.Maps;

public enum Weather {
    SUNNY("sunny"),
    RAIN("rain"),
    STORM("storm"),
    SNOW("snow");
    public final String name;

    Weather(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
