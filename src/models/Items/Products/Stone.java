package models.Items.Products;

import models.Items.Item;
import models.Maps.Tile;

public class Stone extends Item {
    private final Tile tile;

    public Stone(int count, Tile tile) {
        super(count, "Stone");
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }
}
