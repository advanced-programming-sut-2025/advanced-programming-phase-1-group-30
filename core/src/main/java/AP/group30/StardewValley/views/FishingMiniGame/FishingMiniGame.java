package AP.group30.StardewValley.views.FishingMiniGame;

import AP.group30.StardewValley.controllers.GameMenuController;
import AP.group30.StardewValley.models.Animals.Fish;
import AP.group30.StardewValley.models.Animals.FishType;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.Tools.FishingPole;
import AP.group30.StardewValley.models.Players.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class FishingMiniGame {
    private float greenBarY;
    private final float greenBarX;
    private final float greenBarMinY;
    private final float greenBarMaxY;
    private final float greenBarHeight = 100f;
    private final float greenBarWidth = 40f;
    private final float greenBarSpeed = 300f;

    private float fishY;
    private final float fishX;
    private final float fishSize = 40f;

    private final float progressBarWidth = 20f;
    private final float progressBarHeight;
    private final float progressBarX;
    private final float progressBarY;

    private float catchProgress;
    private final float progressUpSpeed = 0.25f;
    private final float progressDownSpeed = 0.125f;

    private final ShapeRenderer greenBarShapeRenderer = new ShapeRenderer();
    private Texture fishTexture;
    private Fish fish;
    private final ShapeRenderer progressBarShapeRenderer = new ShapeRenderer();

    private final Stage stage;
    private final SpriteBatch batch;
    private final Table table;
    private boolean visible = false;

    private boolean perfect = true;

    private FishState fishState = new FishState();
    private FishBrainTimed fishBrain = new FishBrainTimed(fishState);

    public FishingMiniGame(SpriteBatch batch) {
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

        progressBarHeight = table.getHeight();
        progressBarX = table.getX() + table.getWidth() + 10f;
        progressBarY = table.getY();

        fishState.minY = greenBarMinY;
        fishState.maxY = greenBarMaxY;
        fishState.size = fishSize;
        fishState.y = greenBarMinY;
    }

    public void show() {
        refresh();

        findFish();

        visible = true;
        table.setVisible(true);
        Gdx.input.setInputProcessor(stage);
    }

    private void findFish() {
        fish = GameMenuController.fishing();

        if (fish.getType().isLegendary()) fishTexture = new Texture(Gdx.files.internal("Fish/LegendFish.png"));
        else fishTexture = new Texture(Gdx.files.internal("Fish/Fish.png"));
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

            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) fishTexture = fish.getTexture();
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
        catchProgress = 0.25f;

        greenBarY = greenBarMinY;
        fishY = greenBarMinY + (greenBarHeight / 2f) - (fishSize / 2f);

        perfect = true;
        fishState.time = 0f;
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

        fishBrain.update(delta);

        if (fishState.y > greenBarMinY && fishState.y < greenBarMaxY)
            fishY = fishState.y;
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
            perfect = false;
        }

        catchProgress = MathUtils.clamp(catchProgress, 0f, 1f);

        if (catchProgress >= 1f) {
            fishing();
            if (perfect) upgradeFish();

            hide();
        }

        if (catchProgress <= 0f) {
            hide();
        }
    }

    private void fishing() {
        Player player = App.getCurrentGame().getCurrentPlayer();

        if (player.getBackPack().getItems().size() + 1 > player.getBackPack().getType().getCapacity()) {
            return;
        }

        boolean exists = false;
        for (Item item : player.getBackPack().getItems()) {
            if (item.getName().equals(fish.getName())) {
                item.setCount(item.getCount() + 1);
                exists = true;
            }
        }
        if (!exists) App.getCurrentGame().getCurrentPlayer().getBackPack().addItem(fish);

        FishingPole fishingPole = (FishingPole) player.getWield();
        App.getCurrentGame().getCurrentPlayer().changeEnergy(-1 * fishingPole.getType().getEnergyUsed());
        App.getCurrentGame().getCurrentPlayer().increaseFishing(5);
    }

    private void upgradeFish() {
        try {
            Fish fish = (Fish) App.getCurrentGame().getCurrentPlayer().getBackPack().getItems().getLast();
            if (fish.getCof() == 1) fish.setCof(1.25);
            else if (fish.getCof() == 1.25) fish.setCof(1.5);
            else if (fish.getCof() == 1.5) fish.setCof(2);
        } catch (Exception ignored) {}
    }
}
