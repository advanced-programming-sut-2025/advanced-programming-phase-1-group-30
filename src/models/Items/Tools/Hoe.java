package models.Items.Tools;

public class Hoe extends Tool {
    private HoeType type;

    public Hoe(int count, HoeType type) {
        super(count, type.getName());
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
}
