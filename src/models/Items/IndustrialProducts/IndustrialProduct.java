package models.Items.IndustrialProducts;

import models.Items.Item;

public class IndustrialProduct extends Item {
    private final CraftingRecipe type;

    public IndustrialProduct(int count, CraftingRecipe type) {
        super(count, type.getName(), type.getSellPrice());
        this.type = type;
    }

    public CraftingRecipe getType() {
        return type;
    }
    
}
