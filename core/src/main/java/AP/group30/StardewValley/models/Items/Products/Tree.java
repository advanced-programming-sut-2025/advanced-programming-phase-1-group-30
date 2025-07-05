package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.GameAssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Tree extends Product {
    private final TreeType type;
    private boolean isHitByThunder;
    private int x, y;
    private final Texture texture = GameAssetManager.assetManager.get(GameAssetManager.tree);
    private final float width = texture.getWidth() * 2f, height = texture.getHeight() * 2f;

    public Tree(int count, TreeType type, int x, int y) {
        super(count, type.getName(), 0, type.getTexture());
        this.type = type;
        this.isHitByThunder = false;
        this.x = x;
        this.y = y;
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
