package AP.group30.StardewValley.views;

import AP.group30.StardewValley.controllers.GameMenuController;
import AP.group30.StardewValley.models.GameAssetManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class FishingMiniGame {
    private float greenBarY;
    private final float greenBarX;
    private final float greenBarMinY;
    private final float greenBarMaxY;
    private final float greenBarHeight = 80f;
    private final float greenBarWidth = 40f;
    private final float greenBarSpeed = 200f;

    private float fishY;
    private final float fishX;
    private final float fishSize = 40f;

    private final float progressBarWidth = 20f;
    private final float progressBarHeight;
    private final float progressBarX;
    private final float progressBarY;

    private float fishOscillationTime;
    private float catchProgress;
    private final float progressUpSpeed = 0.25f;
    private final float progressDownSpeed = 0.125f;

    private final ShapeRenderer greenBarShapeRenderer = new ShapeRenderer();
    private final Texture fishTexture;
    private final ShapeRenderer progressBarShapeRenderer = new ShapeRenderer();

    private final Stage stage;
    private final SpriteBatch batch;
    private final Table table;
    private boolean visible = false;

    public FishingMiniGame(SpriteBatch batch, Skin skin) {
        this.stage = new Stage(new ScreenViewport(), batch);
        this.batch = batch;
        this.table = new Table();

        Texture backgroundTexture = GameAssetManager.assetManager.get(GameAssetManager.inventoryItem);
        Drawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundTexture));

        table.setVisible(false);
        table.setBackground(backgroundDrawable);
        table.setSize(40, 500);
        table.setPosition(
            (Gdx.graphics.getWidth() - table.getWidth()) / 2f,
            (Gdx.graphics.getHeight() - table.getHeight()) / 2f
        );

        stage.addActor(table);

        greenBarX = table.getX();
        greenBarMinY = table.getY();
        greenBarMaxY = greenBarMinY + table.getHeight();

        fishX = table.getX() + (table.getWidth() - fishSize) / 2f;
        fishTexture = new Texture(Gdx.files.internal("Fish/Fish.png"));

        progressBarHeight = table.getHeight();
        progressBarX = table.getX() + table.getWidth() + 10f;
        progressBarY = table.getY();
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

    public void render(float delta) {
        if (visible) {
            stage.act();
            stage.draw();

            updateGreenBar(delta);
            updateFish(delta);
            updateStatus(delta);

            drawGreenBar();
            drawFish();
            drawProgressBar();
        }
    }

    private void drawGreenBar() {
        greenBarShapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        greenBarShapeRenderer.setColor(Color.GREEN);

        greenBarShapeRenderer.rect(greenBarX, greenBarY, greenBarWidth, greenBarHeight);
        greenBarShapeRenderer.end();
    }

    private void drawFish() {
        batch.begin();

        batch.draw(fishTexture, fishX, fishY, fishSize, fishSize);
        batch.end();
    }

    private void drawProgressBar() {
        progressBarShapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        progressBarShapeRenderer.setColor(Color.GRAY);
        progressBarShapeRenderer.rect(progressBarX, progressBarY, progressBarWidth, progressBarHeight);

        progressBarShapeRenderer.setColor(Color.GREEN);
        progressBarShapeRenderer.rect(progressBarX, progressBarY, progressBarWidth, progressBarHeight * catchProgress);

        progressBarShapeRenderer.end();
    }

    public boolean isVisible() {
        return visible;
    }

    public void dispose() {
        greenBarShapeRenderer.dispose();
        fishTexture.dispose();
        progressBarShapeRenderer.dispose();
        stage.dispose();
    }

    private void refresh() {
        fishOscillationTime = 0f;
        catchProgress = 0.25f;

        greenBarY = greenBarMinY;
        fishY = greenBarMinY + (greenBarHeight / 2f) - (fishSize / 2f);
    }

    public void updateGreenBar(float delta) {
        if (!visible) return;

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            greenBarY += greenBarSpeed * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            greenBarY -= greenBarSpeed * delta;
        }

        greenBarY = MathUtils.clamp(greenBarY, greenBarMinY, greenBarMaxY - greenBarHeight);
    }

    public void updateFish(float delta) {
        if (!visible) return;

        fishOscillationTime += delta;

        float oscillationRange = greenBarMaxY - greenBarMinY - fishSize;
        float oscillationCenter = greenBarMinY;
        float normalizedSin = (-MathUtils.cos(fishOscillationTime * 0.5f) + 1f) / 2f;
        fishY = oscillationCenter + normalizedSin * oscillationRange;
    }

    public void updateStatus(float delta) {
        if (!visible) return;

        float greenBarTop = greenBarY + greenBarHeight;
        float greenBarBottom = greenBarY;

        float fishTop = fishY + fishSize;
        float fishBottom = fishY;

        boolean fishInsideGreenBar = fishTop <= greenBarTop && fishBottom >= greenBarBottom;

        if (fishInsideGreenBar) {
            catchProgress += progressUpSpeed * delta;
        } else {
            catchProgress -= progressDownSpeed * delta;
        }

        catchProgress = MathUtils.clamp(catchProgress, 0f, 1f);

        if (catchProgress >= 1f) {
            GameMenuController.fishing("");
            hide();
        }

        if (catchProgress <= 0f) {
            hide();
        }
    }
}
