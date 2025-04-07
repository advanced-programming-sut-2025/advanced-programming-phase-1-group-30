package Models.Tools;

import Models.Tool;

public class Basket extends Tool {
    private BasketType type;

    public Basket(int count, BasketType type) {
        super(count);
        this.type = type;
    }

    public BasketType getType() {
        return type;
    }

    public void setType(BasketType type) {
        this.type = type;
    }
}
