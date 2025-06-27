package AP.group30.StardewValley.models.Items.Tools;

public class FishingPole extends Tool {
    private FishingPoleType type;

    public FishingPole(int count, FishingPoleType type) {
        super(count, type.getName());
        this.type = type;
    }

    public FishingPoleType getType() {
        return type;
    }

    public void setType(FishingPoleType type) {
        this.type = type;
    }

}
