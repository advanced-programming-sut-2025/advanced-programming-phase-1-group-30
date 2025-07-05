package AP.group30.StardewValley.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameAssetManager {
    public static AssetManager assetManager = new AssetManager();
    public static final AssetDescriptor<Texture> background = new AssetDescriptor<>("menu assets/loading screen.png", Texture.class);
    public static final AssetDescriptor<Texture> nightBackground = new AssetDescriptor<>("menu assets/sebastianRideTiles.png", Texture.class);
    public static final AssetDescriptor<Skin> menuSkin = new AssetDescriptor<>("skin/pixthulhu-ui.json", Skin.class);
    public static final AssetDescriptor<Texture> grass = new AssetDescriptor<>("grass.png", Texture.class);
    public static final AssetDescriptor<Texture> dirt = new AssetDescriptor<>("dirt.png", Texture.class);
    public static final AssetDescriptor<Texture> player = new AssetDescriptor<>("Horse_rider.png", Texture.class);
    public static final AssetDescriptor<Texture> house = new AssetDescriptor<>("Hut.png", Texture.class);
    public static final AssetDescriptor<Texture> water = new AssetDescriptor<>("water.png", Texture.class);
    public static final AssetDescriptor<Texture> tree = new AssetDescriptor<>("tree.png", Texture.class);
    public static final AssetDescriptor<Texture> kaj = new AssetDescriptor<>("tree_kaj.png", Texture.class);
    public static final AssetDescriptor<Texture> stone = new AssetDescriptor<>("stone.png", Texture.class);
    public static final AssetDescriptor<Texture> ruinedGreenhouse = new AssetDescriptor<>("ruined_greenhouse.png", Texture.class);
}
