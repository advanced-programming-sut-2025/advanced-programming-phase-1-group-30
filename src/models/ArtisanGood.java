package models;

import models.ArtisanGoods.ArtisanGoodType;

public class ArtisanGood extends Item {
    private final ArtisanGoodType type;

    public ArtisanGood(int count, ArtisanGoodType type) {
        super(count);
        this.type = type;
    }

    public ArtisanGoodType getType() {
        return type;
    }
}
