package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.GameObjects;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Maps.Map;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Stone extends Item implements GameObjects {
    private final Texture texture = GameAssetManager.assetManager.get(GameAssetManager.stones);
    private final float width = texture.getWidth(), height = texture.getHeight();
    private Rectangle rect = new Rectangle();
    private int x, y;

    public Stone(int count, int x, int y) {
        super(count, "Stone", 10, GameAssetManager.assetManager.get(GameAssetManager.stones));
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

    public Rectangle getRect() {
        return rect;
    }

    public int getRenderY() {
        return y;
    }

    @Override
    public void render(SpriteBatch batch, Map map) {
        batch.draw(texture, x, y, width, height);
    }
}
