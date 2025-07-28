package AP.group30.StardewValley.views.InGameMenus;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.GameMenuController;
import AP.group30.StardewValley.models.Animals.Animal;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Buildings.Barn;
import AP.group30.StardewValley.models.Buildings.Building;
import AP.group30.StardewValley.models.Buildings.Coop;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.GameObjects;
import AP.group30.StardewValley.models.Items.Products.ForagingSeed;
import AP.group30.StardewValley.models.Items.Tools.FishingPole;
import AP.group30.StardewValley.models.Items.Tools.Tool;
import AP.group30.StardewValley.models.Maps.Tile;
import AP.group30.StardewValley.models.Maps.TileTypes;
import AP.group30.StardewValley.models.Players.Direction;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.views.GameScreen;
import AP.group30.StardewValley.views.StartMenus.RegisterMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Timer;

import java.io.OutputStream;
import java.util.ArrayList;

public class GreenhouseScreen implements Screen {
    private Stage stage;
    private SpriteBatch batch;
    private Skin skin;
    private Table table;
    private boolean visible = false;
    private Texture backgroundTexture;
    private GameScreen gameScreen;
    private Player player = App.getCurrentGame().getCurrentPlayer();
    private float speed = 150f;
    float x = Gdx.graphics.getWidth() / 2f;
    float y = Gdx.graphics.getHeight() / 2f;
    private float stateTime = 0;
    private InventoryScreen inventoryScreen;
    Vector2 mousePos = new Vector2();
    private Tile[][] tiles = new Tile[12][10];
    public ArrayList<GameObjects> entities = new ArrayList<>();

    public GreenhouseScreen(Skin skin, Texture backgroundTexture, GameScreen gameScreen) {
        stage = new Stage();
        this.skin = skin;
        this.batch = new SpriteBatch();
        this.backgroundTexture = backgroundTexture;
        this.table = new Table(skin);
        inventoryScreen = new InventoryScreen(batch, Main.getMain().skin);
        for (int i = 0; i < 12; i++){
            for (int j = 0; j < 10; j++){
                tiles[i][j] = new Tile(i,j, TileTypes.DIRT, true, false, 0,
                    GameAssetManager.assetManager.get(GameAssetManager.dirt),
                    GameAssetManager.assetManager.get(GameAssetManager.dirt));
            }
        }
        this.gameScreen = gameScreen;
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

    @Override
    public void dispose() {

    }

    public void render(float delta) {
        handleInput(delta);
        RegisterMenu.gameScreen.passTime();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) inventoryScreen.toggle();

        mousePos.x = Gdx.input.getX();
        mousePos.y = Gdx.graphics.getHeight() - Gdx.input.getY();

        batch.begin();
        batch.draw(GameAssetManager.assetManager.get(GameAssetManager.blackBackground), 0 , 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(backgroundTexture, Gdx.graphics.getWidth() / 3f, Gdx.graphics.getHeight() / 7.3f,
            Gdx.graphics.getWidth() / 3f, Gdx.graphics.getHeight()/1.45f);
        for (Tile[] value : tiles) {
            for (Tile tile : value) {
                if (tile != null) tile.render(batch);
            }
        }

        GameScreen.renderEntities(batch, entities);
        player.render(batch);
        gameScreen.updateToolAnimation(delta);
        GameScreen.renderTool(batch, player);
        GameScreen.renderEnergyBar(player, gameScreen.getCamera(), GameAssetManager.assetManager.get(GameAssetManager.energyBar), batch, new ShapeRenderer());
        GameScreen.renderTime(batch, gameScreen.getCamera(), GameAssetManager.assetManager.get(GameAssetManager.clock), gameScreen.getInfo(), gameScreen.getGame());
        batch.end();
        inventoryScreen.render();
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    private void handleInput(float delta) {
        float moveAmount = speed * delta;
        stateTime += delta;
        player.setStateTime(stateTime);

        float proposedX = x;
        float proposedY = y;

        boolean moved = false;

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            proposedY += moveAmount;
            if (proposedY > 650) {
                proposedY = 650;
            }
            moved = true;
            player.setDirection(Direction.NORTH);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            proposedY -= moveAmount;
            if (proposedY < 200) {
                proposedY = 200;
            }
            moved = true;
            player.setDirection(Direction.SOUTH);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            proposedX -= moveAmount;
            if (proposedX < 660){
                proposedX = 660;
            }
            if (!player.isFacingLeft()) {
                player.setFacingLeft(true);
            }
            moved = true;
            player.setDirection(Direction.WEST);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            proposedX += moveAmount;
            if (proposedX >= 1230) {
                proposedX = 1230;
            }
            if (player.isFacingLeft()) {
                player.setFacingLeft(false);
            }
            moved = true;
            player.setDirection(Direction.EAST);
        }

        if (moved) {
            player.setMoving(true);
            x = proposedX;
            y = proposedY;
            player.getPlayerRect().setPosition(x, y);
            player.setX((int) x);
            player.setY((int) y);
            player.setEnergy(player.getEnergy() - 0.1f);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            hide();
            Main.getMain().setScreen(gameScreen);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.C) || Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            if (player.getWield() instanceof Tool) {
                GameMenuController.toolUse(player.getDirection(), (int) ((int) (x) - Gdx.graphics.getWidth() / 2.5f), (int) ((int) (y + 4) - Gdx.graphics.getHeight() / 3.93f), batch, tiles);
                gameScreen.toolAnimation();
            } else if (player.getWield() instanceof ForagingSeed) {
                GameMenuController.plant(player.getWield().getName(), player.getDirection(), tiles);
            } else if (player.getWield().getName().equals("speed-gro") || player.getWield().getName().equals("deluxe retaining soil")) {
                GameMenuController.fertilize(player.getWield().getName(), player.getDirection(), tiles);
            }
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
