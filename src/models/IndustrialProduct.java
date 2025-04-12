package models;

import models.IndustrialProducts.IndustrialProductType;

public class IndustrialProduct extends Item{
    private final IndustrialProductType type;

    public IndustrialProduct(int count, IndustrialProductType type) {
        super(count);
        this.type = type;
    }

    public IndustrialProductType getType() {
        return type;
    }
    
}
