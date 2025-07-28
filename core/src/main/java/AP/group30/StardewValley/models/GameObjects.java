package AP.group30.StardewValley.models;

import AP.group30.StardewValley.models.Maps.Map;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameObjects {
    int getRenderY();

    void render(SpriteBatch batch);
}
