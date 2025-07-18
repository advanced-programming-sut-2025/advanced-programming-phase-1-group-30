package AP.group30.StardewValley.models.Items.ArtisanGoods;

import AP.group30.StardewValley.models.Items.Item;

public class ArtisanGood extends Item {
    private final ArtisanGoodType type;

    public ArtisanGood(int count, ArtisanGoodType type) {
        super(count, type.getName(), type.getPrice(), type.getTexture());
        this.type = type;
    }

    public ArtisanGoodType getType() {
        return type;
    }
}
