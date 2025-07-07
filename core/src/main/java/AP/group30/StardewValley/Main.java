package AP.group30.StardewValley;

import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.views.GameMenu;
import AP.group30.StardewValley.views.GameScreen;
import AP.group30.StardewValley.views.LoadingScreen;

import AP.group30.StardewValley.views.RegisterMenu;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/* {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    private static Main main;
    public static SpriteBatch batch;
    public Skin skin;



    @Override
    public void create() {
        main = this;
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));
        main.setScreen(new LoadingScreen(new RegisterMenu(skin), GameAssetManager.background, GameAssetManager.menuSkin
            , GameAssetManager.grass, GameAssetManager.dirt,
            GameAssetManager.player, GameAssetManager.house, GameAssetManager.water, GameAssetManager.nightBackground,
            GameAssetManager.tree, GameAssetManager.kaj, GameAssetManager.stone, GameAssetManager.ruinedGreenhouse));
    }

    public static Main getMain() {
        return main;
    }
}
