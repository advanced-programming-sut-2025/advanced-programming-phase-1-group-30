package AP.group30.StardewValley.models.Inventory;

public class BackPack extends Inventory {
    private BackPackType type;

    public BackPack(BackPackType type) {
        this.type = type;
    }

    public BackPackType getType() {
        return type;
    }

    public void setType(BackPackType type) {
        this.type = type;
    }
}
