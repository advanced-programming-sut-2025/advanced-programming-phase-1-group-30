package models.Items.Tools;

public class Basket extends Tool {
    private BasketType type;
    private int remainingWater;

    public Basket(int count, BasketType type) {
        super(count, type.getName());
        this.type = type;
        this.remainingWater = type.getCapacity();
    }

    public BasketType getType() {
        return type;
    }

    public void setType(BasketType type) {
        this.type = type;
    }

    public void setRemainingWater(int remainingWater) {
        this.remainingWater = remainingWater;
    }

    public int getRemainingWater() {
        return remainingWater;
    }

    public void upgrade() {
        if(type.name().contains("normal")){
            this.setType(BasketType.COPPER);
        } else if(type.name().contains("copper")){
            this.setType(BasketType.IRON);
        } else if(type.name().contains("iron")){
            this.setType(BasketType.GOLD);
        } else if(type.name().contains("gold")){
            this.setType(BasketType.IRIDIUM);
        }
    }
}
