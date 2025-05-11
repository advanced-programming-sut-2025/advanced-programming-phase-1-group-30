package models.Items.Products;

import models.Items.Item;

public class CraftingItems extends Item {
    private CraftingRecipe type;

    public CraftingItems(int count, CraftingRecipe type) {
        super(count, type.name());
        this.type = type;
    }

    public CraftingRecipe getType() {
        return type;
    }

    public void setType(CraftingRecipe type) {
        this.type = type;
    }
}
