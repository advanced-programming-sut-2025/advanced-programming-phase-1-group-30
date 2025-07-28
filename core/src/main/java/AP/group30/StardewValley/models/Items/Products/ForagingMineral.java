package AP.group30.StardewValley.models.Items.Products;


import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.GameObjects;
import AP.group30.StardewValley.models.Maps.Map;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class ForagingMineral extends Product implements GameObjects {
    private Texture texture;
    private final ForagingMineralType type;
    private float width, height;
    private Rectangle rect = new Rectangle();
    private int x, y;

    public ForagingMineral(int count, ForagingMineralType type, int x, int y, Texture texture) {
        super(count, type.getName(), type.getBaseSellPrice(), type.getTexture());
        this.type = type;
        this.x = x;
        this.y = y;
        this.texture = texture;
        width = 32;
        height = 32;
    }

    public ForagingMineral(int count, ForagingMineralType type) {
        super(count, type.getName(), type.getBaseSellPrice(), type.getTexture());
        this.type = type;
    }

    public ForagingMineralType getType() {
        return type;
    }

    @Override
    public int getRenderY() {
        return y;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(GameAssetManager.assetManager.get(GameAssetManager.stone2), x, y, width, height);
        batch.draw(texture, x, y, width, height);
    }
}
