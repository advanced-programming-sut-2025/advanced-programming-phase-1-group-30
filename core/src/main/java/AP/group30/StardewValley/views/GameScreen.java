package AP.group30.StardewValley.views;

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
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class GameScreen implements Screen {
    private Stage stage;
    private SpriteBatch batch;
    private InputProcessor gameInputProcessor;
    Texture grass = new Texture(Gdx.files.internal("grass.png"));
    Texture dirt = new Texture(Gdx.files.internal("dirt.png"));
    Texture player = new Texture(Gdx.files.internal("Horse_rider.png"));
    Texture house = new Texture(Gdx.files.internal("Hut.png"));
    TextureRegion playerRegion = new TextureRegion(player);
    float playerDx = 0, playerDy = 0;
    Map map = new Map(1);
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
        if (Gdx.input.isKeyPressed(Input.Keys.W)) camera.position.y += speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) camera.position.y -= speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) camera.position.x -= speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) camera.position.x += speed * delta;


        batch.begin();
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        for (int i = 0; i < map.getTiles().length; i++) {
            for (int j = 0; j < map.getTiles()[i].length; j++) {
                Tile tile = map.getTiles()[i][j];
                batch.draw(tile.getType().equals(TileTypes.DIRT) ? dirt : grass, tile.getX() * 32, (60 - tile.getY()) * 32, 32, 32);
            }
        }
        batch.draw(house, map.getTiles()[60][40].getX() * 32, map.getTiles()[60][40].getY() * 32, house.getWidth() * 3.5f, house.getHeight() * 3.5f);
        batch.draw(playerRegion, x, y);
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
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            y += speed * delta;

        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            y -= speed * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            if (!facingLeft) {
                flipTexture(true);
                facingLeft = true;
            }
            x -= speed * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
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
