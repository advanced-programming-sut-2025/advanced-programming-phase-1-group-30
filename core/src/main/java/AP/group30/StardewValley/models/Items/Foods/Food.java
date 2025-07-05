package AP.group30.StardewValley.models.Items.Foods;

import AP.group30.StardewValley.models.Items.Item;

public class Food extends Item {
    private final FoodType type;

    public Food(int count, FoodType type) {
        super(count, type.getName(), type.getSellPrice(), type.getTexture());
        this.type = type;
    }

    public FoodType getType() {
        return type;
    }
}
