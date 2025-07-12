package AP.group30.StardewValley.views.Hut;

import AP.group30.StardewValley.models.GameAssetManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class HutScreen {
    private final Stage stage;
    private final Skin skin;
    private final Table table;
    private boolean visible = false;
    private final Texture backgroundTexture;
    private final Texture backgroundItemTexture;

    private final RefrigeratorScreen refrigerator;
    private final CookingScreen cooking;

    public HutScreen(SpriteBatch batch, Skin skin) {
        this.skin = skin;
        this.stage = new Stage(new ScreenViewport(), batch);

        backgroundTexture = GameAssetManager.assetManager.get(GameAssetManager.insideHouse);
        Drawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundTexture));

        backgroundItemTexture = GameAssetManager.assetManager.get(GameAssetManager.inventoryItem);

        table = new Table();
        table.setVisible(false);
        table.setBackground(backgroundDrawable);
        table.setSize(1000, 900);
        table.setPosition(
            (Gdx.graphics.getWidth() - table.getWidth()) / 2,
            (Gdx.graphics.getHeight() - table.getHeight()) / 2
        );

        stage.addActor(table);

        refrigerator = new RefrigeratorScreen(batch, skin);
        cooking = new CookingScreen(batch, skin);
    }

    public void show() {
        visible = true;
        table.setVisible(true);
        Gdx.input.setInputProcessor(stage);
    }

    public void hide() {
        visible = false;
        table.setVisible(false);
        Gdx.input.setInputProcessor(null);
    }

    public void toggle() {
        if (visible) hide();
        else show();
    }

    public void render() {
        if (visible) {
            stage.act();
            stage.draw();

            if (Gdx.input.isKeyJustPressed(Input.Keys.R)) refrigerator.toggle();
            if (Gdx.input.isKeyJustPressed(Input.Keys.C)) cooking.toggle();

            refrigerator.render();
            cooking.render();
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public void dispose() {
        stage.dispose();
        backgroundTexture.dispose();
    }
}
