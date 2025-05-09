package models.Items.Products;

import models.Items.Item;
import models.Maps.Tile;

public class Product extends Item{
    private final Tile tile;

    public Product(int count, String name, Tile tile) {
        super(count, name);
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }
}
