package AP.group30.StardewValley.views;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.models.Game;
import AP.group30.StardewValley.models.GameAssetManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.time.LocalTime;

public class LoadingScreen implements Screen {
    private final Screen nextScreen;
    public static LocalTime time = LocalTime.now();
    private Texture background;

    private final Texture logo = new Texture(Gdx.files.internal("menu assets/PC Computer - Stardew Valley - Logo No Background.png"));
    private Stage stage;
    private ProgressBar progressBar;
    private float delay = 0f;

    public LoadingScreen(Screen nextScreen) {
        this.nextScreen = nextScreen;
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        if (time.getHour() <= 11) {
            background = new Texture(Gdx.files.internal("menu assets/loading screen.png"));
        } else {
            background = new Texture(Gdx.files.internal("menu assets/sebastianRideTiles.png"));
        }

        if (!GameAssetManager.assetManager.isLoaded("skin/pixthulhu-ui.json")) {
            GameAssetManager.assetManager.load("skin/pixthulhu-ui.json", Skin.class);
            GameAssetManager.assetManager.finishLoadingAsset("skin/pixthulhu-ui.json");
        }

        Skin skin = GameAssetManager.assetManager.get("skin/pixthulhu-ui.json", Skin.class);

        Table table = new Table();
        table.setFillParent(true);
        table.setY(Gdx.graphics.getHeight() - Gdx.graphics.getHeight() * 1.25f);
        table.center();
        stage.addActor(table);

        Label loadingLabel = new Label("Loading...", skin);
        progressBar = new ProgressBar(0, 1, 0.01f, false, skin);
        progressBar.setValue(0);
        progressBar.setAnimateDuration(0.25f);

        table.add(loadingLabel).padBottom(20).row();
        table.add(progressBar).width(300).height(20);

        GameAssetManager.queueAsset();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Main.batch.begin();
        Main.batch.draw(background, 0, 0, stage.getWidth(), stage.getHeight());
        Main.batch.draw(logo, stage.getWidth() / 2f - stage.getWidth() / 6f, stage.getHeight() * 2 / 3f - stage.getHeight() / 6f, stage.getWidth() / 3f, stage.getHeight() / 3f);
        Main.batch.end();

        delay += delta;

        if (GameAssetManager.assetManager.update() && delay >= 2) {
            Main.getMain().setScreen(nextScreen);
        } else {
            float progress = GameAssetManager.assetManager.getProgress();
            progressBar.setValue(progress);
        }

        stage.act(delta);
        stage.draw();
    }

    @Override public void resize(int width, int height) { stage.getViewport().update(width, height, true); }
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() { stage.dispose(); }
}

