package Models.Products;

import Models.Product;

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
