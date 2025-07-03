package AP.group30.StardewValley.views;


import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.Products.Stone;
import AP.group30.StardewValley.models.Items.Products.Tree;
import AP.group30.StardewValley.models.Maps.Map;
import AP.group30.StardewValley.models.Maps.Tile;
import AP.group30.StardewValley.models.Maps.TileTypes;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.Random;


public class GameScreen implements Screen {
    private Stage stage;
    private SpriteBatch batch;
    private InputProcessor gameInputProcessor;
    TextureRegion playerRegion = new TextureRegion(GameAssetManager.assetManager.get("Horse_rider.png", Texture.class));
    Texture house = GameAssetManager.assetManager.get(GameAssetManager.house);
    Texture tree = GameAssetManager.assetManager.get(GameAssetManager.tree);
    Texture stone = GameAssetManager.assetManager.get(GameAssetManager.stone);
    float playerDx = 0, playerDy = 0;
    Map map = new Map(2);
    float x = Gdx.graphics.getWidth() / 2f;
    float y = Gdx.graphics.getHeight() / 2f;
    float speed = 150f;
    boolean facingLeft = false;
    OrthographicCamera camera;


    public GameScreen() {

    }


    @Override
    public void show() {
        batch = new SpriteBatch();
        gameInputProcessor = Gdx.input.getInputProcessor();
        Gdx.input.setInputProcessor(gameInputProcessor);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        handleInput(delta);
        if (Gdx.input.isKeyPressed(Input.Keys.W) && y >= 18 * 32 && y <= 48 * 32) camera.position.y += speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.S) && y < 48 * 32 && y >= 18 * 32) camera.position.y -= speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.A) && (x >= 26 * 32 && x <= 54 * 32)) camera.position.x -= speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.D) && x < 54 * 32 && x >= 26 * 32) camera.position.x += speed * delta;


        batch.begin();
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        for (int i = 0; i < map.getTiles().length; i++) {
            for (int j = 0; j < map.getTiles()[i].length; j++) {
                Tile tile = map.getTiles()[i][j];
                switch (tile.getType()) {
                    case TileTypes.GRASS -> batch.draw(GameAssetManager.assetManager.get(GameAssetManager.grass), tile.getX() * 32, (60 - tile.getY()) * 32, 32, 32);
                    case TileTypes.WATER -> batch.draw(GameAssetManager.assetManager.get(GameAssetManager.water), tile.getX() * 32,(60 - tile.getY()) * 32, 32, 32);
                    default -> batch.draw(GameAssetManager.assetManager.get(GameAssetManager.dirt), tile.getX() * 32, (60 - tile.getY()) * 32, 32, 32);
                }
            }
        }
        for (int i = 0; i < map.getTiles().length; i++) {
            for (int j = 0; j < map.getTiles()[i].length; j++) {
                Tile tile = map.getTiles()[i][j];
                if (tile.getItem() != null) {
                    if (tile.getItem().getClass().equals(Tree.class)) {
//                        Random random = new Random();
//                        int x = random.nextInt(2);
//                        tree = (x == 1) ? GameAssetManager.assetManager.get(GameAssetManager.tree) : GameAssetManager.assetManager.get(GameAssetManager.kaj);
                        batch.draw(tree, tile.getX() * 32, (60 - tile.getY()) * 32, tree.getWidth() * 2f, tree.getHeight() * 2f);
                    } else if (tile.getItem().getClass().equals(Stone.class)) {
                        batch.draw(stone, tile.getX() * 32, (60 - tile.getY()) * 32, stone.getWidth() * 2f, stone.getHeight() * 2f);
                    }
                }
            }
        }
        batch.draw(house, map.getTiles()[60][40].getX() * 32, map.getTiles()[60][40].getY() * 32, house.getWidth() * 3f, house.getHeight() * 3f);
        batch.draw(playerRegion, x, y, playerRegion.getRegionWidth() / 1.5f, playerRegion.getRegionHeight() / 1.5f);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    private void handleInput(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.W) && y < (map.getTiles()[0].length - 1) * 32) {
            y += speed * delta;

        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) && y >= 0) {
            y -= speed * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) && x >= 0) {
            if (!facingLeft) {
                flipTexture(true);
                facingLeft = true;
            }
            x -= speed * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) && x < (map.getTiles().length - 1) * 32) {
            if (facingLeft) {
                flipTexture(false);
                facingLeft = false;
            }
            x += speed * delta;
        }
    }

    private void flipTexture(boolean flipX) {
        if (playerRegion.isFlipX() != flipX) playerRegion.flip(true, false);
    }
}
