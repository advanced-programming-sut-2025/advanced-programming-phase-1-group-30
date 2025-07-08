package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.GameAssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Tree extends Product {
    private final TreeType type;
    private boolean isHitByThunder;
    private Texture texture;
    private float width, height;
    private Rectangle rect = new Rectangle();
    private int x, y;

    public Tree(int count, TreeType type, int x, int y) {
        super(count, type.getName(), 0, type.getTexture());
        this.type = type;
        this.isHitByThunder = false;
        this.texture = type.getTexture();
        width = texture.getWidth();
        height = texture.getHeight();
        this.x = x;
        this.y = y;
        rect.x = x + width / 4;
        rect.y = y;
        rect.width = (int)width / 2f;
        rect.height = (int)height / 2f;
    }

    public TreeType getType() {
        return type;
    }

    public boolean isHitByThunder() {
        return isHitByThunder;
    }

    public void HitByThunder() {
        this.isHitByThunder = true;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
