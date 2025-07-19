package AP.group30.StardewValley.models.Items.Tools;

public class Basket extends Tool {
    private BasketType type;
    private int remainingWater;

    public Basket(int count, BasketType type) {
        super(count, type.getName(), type.getTexture());
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

    public static BasketType getNextBasketType(BasketType basketType) {
        if (basketType.equals(BasketType.NORMAL)) {
            return BasketType.COPPER;
        } else if (basketType.equals(BasketType.COPPER)) {
            return BasketType.IRON;
        } else if (basketType.equals(BasketType.IRON)) {
            return BasketType.GOLD;
        } else if (basketType.equals(BasketType.GOLD)) {
            return BasketType.IRIDIUM;
        }
        else return null;
    }
}
