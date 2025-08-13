package AP.group30.StardewValley.views.InGameMenus.Hut;

import AP.group30.StardewValley.models.GameAssetManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
    private final ShippingBinScreen shippingBin;
    private final RadioScreen radioScreen;

    public HutScreen(SpriteBatch batch, Skin skin) {
        this.skin = skin;
        this.stage = new Stage(new ScreenViewport(), batch);

        backgroundTexture = GameAssetManager.assetManager.get(GameAssetManager.insideHouse);
        Drawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundTexture));

        backgroundItemTexture = GameAssetManager.assetManager.get(GameAssetManager.inventoryItem);

        table = new Table();
        table.setVisible(false);
        table.setBackground(backgroundDrawable);
        table.setSize(500, 450);
        table.setPosition(
            (Gdx.graphics.getWidth() - table.getWidth()) / 2,
            (Gdx.graphics.getHeight() - table.getHeight()) / 2
        );

        stage.addActor(table);

        refrigerator = new RefrigeratorScreen(batch, skin);
        cooking = new CookingScreen(batch, skin);
        shippingBin = new ShippingBinScreen(batch, skin);
        radioScreen = new RadioScreen(batch, skin);
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

    public void render(SpriteBatch batch, OrthographicCamera camera) {
        if (visible) {
            batch.begin();
            batch.draw(GameAssetManager.assetManager.get(GameAssetManager.blackBackground), camera.position.x - Gdx.graphics.getWidth() * 1.2f,
                camera.position.y - Gdx.graphics.getHeight() * 1.4f, Gdx.graphics.getWidth() * 2f, Gdx.graphics.getHeight() * 2f);
            batch.end();
            stage.act();
            stage.draw();

            if (Gdx.input.isKeyJustPressed(Input.Keys.R)) refrigerator.toggle();
            if (Gdx.input.isKeyJustPressed(Input.Keys.C)) cooking.toggle();
            if (Gdx.input.isKeyJustPressed(Input.Keys.S)) shippingBin.toggle();
            if (Gdx.input.isKeyJustPressed(Input.Keys.N)) radioScreen.toggle();

            refrigerator.render();
            cooking.render();
            shippingBin.render();
            radioScreen.render();
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
