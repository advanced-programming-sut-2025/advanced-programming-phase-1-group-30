package AP.group30.StardewValley.views;

import AP.group30.StardewValley.models.GameAssetManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RainBackground {

    public static final int DEFAULT_SPEED = 100;
    public static final int ACCELERATION = 100;
    public static final int GOAL_REACH_SPEED = 1000;



    Texture background;
    float y1, y2;
    int speed;   // pixels per second
    int goalSpeed;
    float imageScale = 1f;
    boolean speedFixed;
    OrthographicCamera camera;

    public RainBackground(OrthographicCamera camera) {
        background = GameAssetManager.assetManager.get(GameAssetManager.rain);
        this.camera = camera;
        y1 = camera.position.y - Gdx.graphics.getHeight() / 2f;
        y2 = Gdx.graphics.getHeight() + camera.position.y - Gdx.graphics.getHeight() / 2f;
        speedFixed = false;
        speed = 300;
        goalSpeed = GOAL_REACH_SPEED;
    }

    public void updateAndRender(float delta, SpriteBatch batch) {
        camera.update();

        y1 -= speed * delta;
        y2 -= speed * delta;

        float bottomOfScreen = camera.position.y - Gdx.graphics.getHeight() / 2f;

        // recycle image when it goes out of screen
        if (y1 + Gdx.graphics.getHeight() * imageScale <= bottomOfScreen) {
            y1 = y2 + Gdx.graphics.getHeight() * imageScale;
        }
        if (y2 + Gdx.graphics.getHeight() * imageScale <= bottomOfScreen) {
            y2 = y1 + Gdx.graphics.getHeight() * imageScale;
        }

        batch.draw(background, camera.position.x - Gdx.graphics.getWidth() / 2f, y1, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() * imageScale);
        batch.draw(background, camera.position.x - Gdx.graphics.getWidth() / 2f, y2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() * imageScale);
    }


    public void resize(int width, int height) {
        imageScale = Gdx.graphics.getWidth() / (float) width;
    }

    public void setSpeedFixed(boolean speedFixed) {
        this.speedFixed = speedFixed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
