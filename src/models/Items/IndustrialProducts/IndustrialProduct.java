package models.Items.IndustrialProducts;

import models.Items.Item;

public class IndustrialProduct extends Item {
    private IndustrialProductType type;

    public IndustrialProduct(int count, IndustrialProductType type) {
        super(count, type.name(), type.getSellPrice());
        this.type = type;
    }

    public IndustrialProductType getType() {
        return type;
    }

    public void setType(IndustrialProductType type) {
        this.type = type;
    }
}
