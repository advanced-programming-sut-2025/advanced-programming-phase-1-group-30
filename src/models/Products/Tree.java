package models.Products;

import models.Product;

public class Tree extends Product{
    private final TreeType type;

    public Tree(int count, TreeType type) {
        super(count);
        this.type = type;
    }

    public TreeType getType() {
        return type;
    }
}
