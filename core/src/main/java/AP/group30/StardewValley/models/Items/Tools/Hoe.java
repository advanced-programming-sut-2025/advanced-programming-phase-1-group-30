package AP.group30.StardewValley.models.Items.Tools;

public class Hoe extends Tool {
    private HoeType type;

    public Hoe(int count, HoeType type) {
        super(count, type.getName(), type.getTexture());
        this.type = type;
    }

    public HoeType getType() {
        return type;
    }

    public void setType(HoeType type) {
        this.type = type;
    }

    public void upgrade() {
        if(type.name().contains("normal")){
            this.setType(HoeType.COPPER);
        } else if(type.name().contains("copper")){
            this.setType(HoeType.IRON);
        } else if(type.name().contains("iron")){
            this.setType(HoeType.GOLD);
        } else if(type.name().contains("gold")){
            this.setType(HoeType.IRIDIUM);
        }
    }

    public static HoeType getNextHoeType(HoeType hoeType) {
        if (hoeType.equals(HoeType.NORMAL)) {
            return HoeType.COPPER;
        } else if (hoeType.equals(HoeType.COPPER)) {
            return HoeType.IRON;
        } else if (hoeType.equals(HoeType.IRON)) {
            return HoeType.GOLD;
        } else if (hoeType.equals(HoeType.GOLD)) {
            return HoeType.IRIDIUM;
        }
        else return null;
    }
}
