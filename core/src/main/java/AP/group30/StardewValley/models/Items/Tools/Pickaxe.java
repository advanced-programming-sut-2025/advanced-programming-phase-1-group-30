package AP.group30.StardewValley.models.Items.Tools;

public class Pickaxe extends Tool{
    private PickaxeType type;

    public Pickaxe(int count, PickaxeType type) {
        super(count, type.getName(), type.getTexture());
        this.type = type;
    }

    public PickaxeType getType() {
        return type;
    }

    public void setType(PickaxeType type) {
        this.type = type;
    }

    public void upgrade() {
        if(type.name().contains("normal")){
            this.setType(PickaxeType.COPPER);
        } else if(type.name().contains("copper")){
            this.setType(PickaxeType.IRON);
        } else if(type.name().contains("iron")){
            this.setType(PickaxeType.GOLD);
        } else if(type.name().contains("gold")){
            this.setType(PickaxeType.IRIDIUM);
        }
    }

    public static PickaxeType getNextPickaxeType(PickaxeType pickaxeType) {
        if (pickaxeType.equals(PickaxeType.NORMAL)) {
            return PickaxeType.COPPER;
        } else if (pickaxeType.equals(PickaxeType.COPPER)) {
            return PickaxeType.IRON;
        } else if (pickaxeType.equals(PickaxeType.IRON)) {
            return PickaxeType.GOLD;
        } else if (pickaxeType.equals(PickaxeType.GOLD)) {
            return PickaxeType.IRIDIUM;
        }
        else return null;
    }
}
