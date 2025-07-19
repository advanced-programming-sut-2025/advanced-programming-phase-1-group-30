package AP.group30.StardewValley;

import AP.group30.StardewValley.views.*;

import AP.group30.StardewValley.views.StartMenus.RegisterMenu;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
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
        main.setScreen(new LoadingScreen(new RegisterMenu(skin)));
    }

    public static Main getMain() {
        return main;
    }
}
