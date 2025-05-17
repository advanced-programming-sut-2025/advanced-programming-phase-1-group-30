package models.Invetory;

public class ShippingBin extends Inventory {
    private ShippingBinType type;
    private int x;
    private int y;

    public ShippingBin(ShippingBinType type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public ShippingBinType getType() {
        return type;
    }

    public void setType(ShippingBinType type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
