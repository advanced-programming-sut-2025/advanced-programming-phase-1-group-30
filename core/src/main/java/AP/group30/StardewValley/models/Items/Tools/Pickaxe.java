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
}
