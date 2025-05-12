package models.Items.Products;

import models.Maps.Tile;

public class Tree extends Product{
    private final TreeType type;
    private boolean isHitByThunder;

    public Tree(int count, TreeType type) {
        super(count, type.getName());
        this.type = type;
        this.isHitByThunder = false;
    }

    public TreeType getType() {
        return type;
    }

    public boolean isHitByThunder() {
        return isHitByThunder;
    }

    public void HitByThunder() {
        this.isHitByThunder = true;
    }
}
