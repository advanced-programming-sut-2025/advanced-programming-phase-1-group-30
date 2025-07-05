package AP.group30.StardewValley.models.Items.Products;


public class ForagingTree extends Product {
    private final ForagingTreeType type;

    public ForagingTree(int count, ForagingTreeType type) {
        super(count, type.getName(), 0, type.getTexture());
        this.type = type;
    }

    public ForagingTreeType getType() {
        return type;
    }
}
