package AP.group30.StardewValley.models.Items.IndustrialProducts;

import AP.group30.StardewValley.models.Items.Item;

public class IndustrialProduct extends Item {
    private IndustrialProductType type;

    public IndustrialProduct(int count, IndustrialProductType type) {
        super(count, type.getName() , type.getSellPrice(), type.getTexture());
        this.type = type;
    }

    public IndustrialProductType getType() {
        return type;
    }

    public void setType(IndustrialProductType type) {
        this.type = type;
    }
}
