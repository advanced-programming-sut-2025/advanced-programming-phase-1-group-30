package AP.group30.StardewValley.models.Items.Products;

public class Tree extends Product {
    private final TreeType type;
    private boolean isHitByThunder;

    public Tree(int count, TreeType type) {
        super(count, type.getName(), 0, type.getTexture());
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
