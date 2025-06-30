package AP.group30.StardewValley;

import AP.group30.StardewValley.views.LoadingScreen;

import AP.group30.StardewValley.views.RegisterMenu;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/* {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    private static Main main;
    public static SpriteBatch batch;
    private static final AssetDescriptor<Texture> background = new AssetDescriptor<>("menu assets/loading screen.png", Texture.class);
    private static final AssetDescriptor<Skin> menuSkin = new AssetDescriptor<>("skin/pixthulhu-ui.json", Skin.class);


    @Override
    public void create() {
        main = this;
        batch = new SpriteBatch();
        main.setScreen(new LoadingScreen(new RegisterMenu(), background, menuSkin));
    }

    public static Main getMain() {
        return main;
    }
    public static AssetDescriptor<Texture> getBackground() {
        return background;
    }
    public static AssetDescriptor<Skin> getMenuSkin() {
        return menuSkin;
    }
}
