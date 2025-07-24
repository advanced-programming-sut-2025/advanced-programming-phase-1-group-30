package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.Maps.Map;
import AP.group30.StardewValley.models.Maps.Tile;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GiantCrop extends Crop {
    private Tile[] tiles;
    private boolean checked = false;
    public GiantCrop(int count, CropType type, Tile[] tiles) {
        super(count, type);
        this.tiles = tiles;
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public int getRenderY() {
        return y * 32;
    }
    @Override
    public void render(SpriteBatch batch, Map map) {
        batch.draw(stageTextureMap.get(currentStage), x * 32, y * 32, 32 * 2, 32 * 2);
    }
}
