package models.Items.ArtisanGoods;

import models.Items.Item;

public class ArtisanGood extends Item {
    private final ArtisanGoodType type;

    public ArtisanGood(int count, ArtisanGoodType type) {
        super(count, type.getName(), type.getSellPrice());
        this.type = type;
    }

    public ArtisanGoodType getType() {
        return type;
    }
}
