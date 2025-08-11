package AP.group30.StardewValley.views.InGameMenus;

import AP.group30.StardewValley.models.GameAssetManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

abstract public class InGameMenuScreen {
    protected final Stage stage;
    protected final Skin skin;
    protected final Table table;
    protected boolean visible = false;
    protected final Texture backgroundTexture;
    protected final Texture backgroundItemTexture;

    protected final int positionX;
    protected final int positionY;

    protected InGameMenuScreen(SpriteBatch batch, Skin skin, AssetDescriptor<Texture> backgroundAssetDescriptor
                                , int tableHeightDivider, int tableHorizonMove, int widthChanger) {
        this.stage = new Stage(new ScreenViewport(), batch);
        this.skin = skin;
        this.table = new Table();

        backgroundTexture = GameAssetManager.assetManager.get(backgroundAssetDescriptor);
        Drawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundTexture));

        backgroundItemTexture = GameAssetManager.assetManager.get(GameAssetManager.inventoryItem);

        table.setVisible(false);
        table.setBackground(backgroundDrawable);
        table.setSize(800 + widthChanger, (float) 600 / tableHeightDivider);
        table.setPosition(
            (Gdx.graphics.getWidth() - table.getWidth()) / 2f,
            (Gdx.graphics.getHeight() - table.getHeight()) / 2f + tableHorizonMove
        );

        positionX = (int) table.getX() + 85;
        positionY = (int) (table.getY() + table.getHeight()) - 155;

        stage.addActor(table);
    }

    public void show() {
        refresh();

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
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public abstract void dispose();

    protected abstract void refresh();

    protected Image createBorderImage(int width, int height, Color color) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(0, 0, 0, 0);
        pixmap.fill();

        pixmap.setColor(color);
        int thickness = 3;
        pixmap.fillRectangle(0, 0, width, thickness);
        pixmap.fillRectangle(0, height - thickness, width, thickness);
        pixmap.fillRectangle(0, 0, thickness, height);
        pixmap.fillRectangle(width - thickness, 0, thickness, height);

        Texture texture = new Texture(pixmap);
        pixmap.dispose();

        Image border = new Image(new TextureRegionDrawable(new TextureRegion(texture)));
        border.addListener(new ActorGestureListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                texture.dispose();
            }
        });

        return border;
    }
}
