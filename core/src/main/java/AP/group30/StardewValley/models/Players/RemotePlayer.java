package AP.group30.StardewValley.models.Players;

import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.GameObjects;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RemotePlayer implements GameObjects {
    public Texture region;
    public final String id;
    public float x, y;
    public RemotePlayer(String id, float x, float y) {
        this.id = id; this.x = x; this.y = y;
        region = GameAssetManager.assetManager.get(GameAssetManager.player00);
    }

    @Override
    public int getRenderY() {
        return (int)y;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(region, x, y, region.getWidth() * 2f , region.getHeight() * 2f);
    }
}
