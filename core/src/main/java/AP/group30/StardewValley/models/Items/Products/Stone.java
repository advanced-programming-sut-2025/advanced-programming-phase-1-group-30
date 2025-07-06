package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.ItemTexture;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Stone extends Item {
    private final Texture texture = GameAssetManager.assetManager.get(GameAssetManager.stone);
    private final float width = texture.getWidth() * 2f, height = texture.getHeight() * 2f;
    private Rectangle rect = new Rectangle();
    public Stone(int count, int x, int y) {
        super(count, "Stone", 10);
        this.x = x;
        this.y = y;
        rect.x = x;
        rect.y = y;
        rect.width = (int)width;
        rect.height = (int)height;
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
