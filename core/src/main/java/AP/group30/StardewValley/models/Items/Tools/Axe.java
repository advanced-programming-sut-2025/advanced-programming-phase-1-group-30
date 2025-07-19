package AP.group30.StardewValley.models.Items.Tools;

public class Axe extends Tool {
    private AxeType type;

    public Axe(int count, AxeType type) {
        super(count, type.getName(), type.getTexture());
        this.type = type;
    }

    public AxeType getType() {
        return type;
    }

    public void setType(AxeType type) {
        this.type = type;
    }

    public void upgrade() {
        if(type.name().contains("normal")){
            this.setType(AxeType.COPPER);
        } else if(type.name().contains("copper")){
            this.setType(AxeType.IRON);
        } else if(type.name().contains("iron")){
            this.setType(AxeType.GOLD);
        } else if(type.name().contains("gold")){
            this.setType(AxeType.IRIDIUM);
        }
    }

    public static AxeType getNextAxeType(AxeType axeType) {
        if (axeType.equals(AxeType.NORMAL)) {
            return AxeType.COPPER;
        } else if (axeType.equals(AxeType.COPPER)) {
            return AxeType.IRON;
        } else if (axeType.equals(AxeType.IRON)) {
            return AxeType.GOLD;
        } else if (axeType.equals(AxeType.GOLD)) {
            return AxeType.IRIDIUM;
        }
        else return null;
    }
}
