package models.Items.Products;

import models.Items.Item;
import models.Items.IndustrialProducts.CraftingRecipe;

public class CraftingItems extends Item {
    private CraftingRecipe type;

    public CraftingItems(int count, CraftingRecipe type) {
        super(count, type.name(), type.getSellPrice());
        this.type = type;
    }

    public CraftingRecipe getType() {
        return type;
    }

    public void setType(CraftingRecipe type) {
        this.type = type;
    }
}
