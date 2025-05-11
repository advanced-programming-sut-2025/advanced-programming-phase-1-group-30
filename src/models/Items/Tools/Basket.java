package models.Items.Tools;

public class Basket extends Tool {
    private BasketType type;
    private int remainingWater;

    public Basket(int count, BasketType type) {
        super(count, type.getName());
        this.type = type;
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
}
