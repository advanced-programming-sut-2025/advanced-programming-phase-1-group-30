package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.GameAssetManager;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Tree extends Product {
    private final TreeType type;
    private boolean isHitByThunder;
    private int x, y;
    private final Texture texture = GameAssetManager.assetManager.get(GameAssetManager.tree);
    private final float width = texture.getWidth() * 2f, height = texture.getHeight() * 2f;
    private Rectangle rect = new Rectangle();

    public Tree(int count, TreeType type, int x, int y) {
        super(count, type.getName(), 0);
        this.type = type;
        this.isHitByThunder = false;
        this.x = x;
        this.y = y;
        rect.x = x;
        rect.y = y;
        rect.width = (int)width;
        rect.height = (int)height;
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
