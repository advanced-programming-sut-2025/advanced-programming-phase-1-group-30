package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.Item;
import com.badlogic.gdx.graphics.Texture;

public class Stone extends Item {
    private int x, y;
    private final Texture texture = GameAssetManager.assetManager.get(GameAssetManager.stone);
    private final float width = texture.getWidth() * 2f, height = texture.getHeight() * 2f;
    public Stone(int count, int x, int y) {
        super(count, "Stone", 10, ItemTexture.STONE.getTexture());
        this.x = x;
        this.y = y;
    }

    public void moveRelativeToPlayer(float playerDx, float playerDy) {
        this.x -= playerDx;
        this.y -= playerDy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
