package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.GameAssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Tree extends Product {
    private final TreeType type;
    private boolean isHitByThunder;
    private final Texture texture = GameAssetManager.assetManager.get(GameAssetManager.tree);
    private final float width = texture.getWidth() * 2f, height = texture.getHeight() * 2f;

    public Tree(int count, TreeType type) {
        super(count, type.getName(), 0, type.getTexture());
        this.type = type;
        this.isHitByThunder = false;
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
}
