package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.ItemTexture;
import com.badlogic.gdx.graphics.Texture;

public class Stone extends Item {
    private final Texture texture = GameAssetManager.assetManager.get(GameAssetManager.stone);
    private final float width = texture.getWidth() * 2f, height = texture.getHeight() * 2f;
    public Stone(int count) {
        super(count, "Stone", 10, ItemTexture.STONE.getTexture());
    }

    public Texture getTexture() {
        return texture;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
