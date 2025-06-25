package AP.group30.StardewValley.models.Animals;

import AP.group30.StardewValley.models.Items.Item;

public class Fish extends Item {
    private final FishType type;

    public Fish(int count, FishType type) {
        super(count, type.getDisplayName(), type.getBasePrice());
        this.type = type;
    }

    public FishType getType() {
        return type;
    }
}
