package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.ItemTexture;

public class Stone extends Item {
    public Stone(int count) {
        super(count, "Stone", 10, ItemTexture.STONE.getTexture());
    }
}
