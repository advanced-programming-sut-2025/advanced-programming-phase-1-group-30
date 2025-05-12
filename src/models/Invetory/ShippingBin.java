package models.Invetory;

public class ShippingBin extends Inventory {
    private ShippingBinType type;

    public ShippingBin(ShippingBinType type) {
        this.type = type;
    }

    public ShippingBinType getType() {
        return type;
    }

    public void setType(ShippingBinType type) {
        this.type = type;
    }
}
