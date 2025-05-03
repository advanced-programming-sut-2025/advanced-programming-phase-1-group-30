package models.Items.IndustrialProducts;

import models.Items.Item;

public class IndustrialProduct extends Item{
    private final IndustrialProductType type;

    public IndustrialProduct(int count, IndustrialProductType type) {
        super(count, type.getName());
        this.type = type;
    }

    public IndustrialProductType getType() {
        return type;
    }
    
}
