package AP.group30.StardewValley.views.InGameMenus;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.GameMenuController;
import AP.group30.StardewValley.models.Animals.Animal;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Buildings.Barn;
import AP.group30.StardewValley.models.Buildings.Building;
import AP.group30.StardewValley.models.Buildings.Coop;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Players.Direction;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.views.GameScreen;
import AP.group30.StardewValley.views.StartMenus.RegisterMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public abstract class AnimalScreen implements Screen {
    protected final Stage stage;
    private SpriteBatch batch;
    private Skin skin;
    private final Table table;
    private boolean visible = false;
    private final Texture backgroundTexture;
    private final GameScreen gameScreen = RegisterMenu.gameScreen;
    private Player player = App.getCurrentGame().getCurrentPlayer();
    private float speed = 150f;
    float x = Gdx.graphics.getWidth() / 2f;
    float y = Gdx.graphics.getHeight() / 2f;
    private float stateTime = 0;
    private Building building;
    private InventoryScreen inventoryScreen;
    Vector2 mousePos = new Vector2();

    public AnimalScreen(Skin skin, Texture backgroundTexture, Building building) {
        stage = new Stage();
        this.skin = skin;
        this.batch = new SpriteBatch();
        this.backgroundTexture = backgroundTexture;
        this.table = new Table(skin);
        this.building = building;
        inventoryScreen = new InventoryScreen(batch, Main.getMain().skin);
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

    public void render(float delta) {
        handleInput(delta);

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) inventoryScreen.toggle();

        mousePos.x = Gdx.input.getX();
        mousePos.y = Gdx.graphics.getHeight() - Gdx.input.getY();

        batch.begin();
        batch.draw(GameAssetManager.assetManager.get(GameAssetManager.blackBackground), 0 , 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(backgroundTexture, Gdx.graphics.getWidth() / 4f, Gdx.graphics.getHeight() / 4f,
            Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
        player.render(batch, App.getCurrentGame().getCurrentPlayer().getMap());
        if (building instanceof Coop) {
            for (Animal animal : ((Coop) building).getAnimals()) {
                if (!animal.isOut()) {
                    Rectangle animalBounds = animal.getRect();
                    animal.setHovered(animalBounds.contains(mousePos.x, mousePos.y));
                    animal.update(delta, player.getX(), player.getY());
                    animal.render(batch);
                }
            }
        } else if (building instanceof Barn) {
            for (Animal animal : ((Barn) building).getAnimals()) {
                if (!animal.isOut()) {
                    Rectangle animalBounds = animal.getRect();
                    animal.setHovered(animalBounds.contains(mousePos.x, mousePos.y));
                    animal.update(delta, player.getX(), player.getY());
                    animal.render(batch);
                }
            }
        }

        if (player.getNearbyAnimal() != null) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.C)) {
                player.getNearbyAnimal().pet();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.F)) {
                player.getNearbyAnimal().feed();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
                player.getNearbyAnimal().collectProduct();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.G)) {
                player.getNearbyAnimal().shepherdAnimals();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.X)) {
                GameMenuController.sellAnimal(player.getNearbyAnimal());
            }
        }
        batch.end();
        inventoryScreen.render();
        stage.act();
        stage.draw();
    }

    public abstract void dispose();

    protected abstract void refresh();

    private void handleInput(float delta) {
        float moveAmount = speed * delta;
        stateTime += delta;
        player.setStateTime(stateTime);

        float proposedX = x;
        float proposedY = y;

        boolean moved = false;

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            proposedY += moveAmount;
            if (building instanceof Coop) {
                if (proposedY > 610) {
                    proposedY = 610;
                }
            } else if (building instanceof Barn) {
                if (proposedY > 365 && proposedY < 380 && (proposedX > 485 && proposedX < 710)) {
                    proposedY -= moveAmount;
                } else if (proposedY > 700) proposedY = 700;
            }
            moved = true;
            player.setDirection(Direction.NORTH);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            proposedY -= moveAmount;
            if (building instanceof Coop) {
                if (proposedY < 360) {
                    proposedY = 360;
                }
            } else if (building instanceof Barn) {
                if (proposedY > 560 && proposedY < 575 && (proposedX > 485 && proposedX < 710)) {
                    proposedY += moveAmount;
                } else if (proposedY < 330) proposedY = 330;
            }
            moved = true;
            player.setDirection(Direction.SOUTH);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            proposedX -= moveAmount;
            if (building instanceof Coop) {
                if (proposedX < 500) {
                    proposedX = 500;
                }
            } else if (building instanceof Barn) {
                if (proposedX > 710 && proposedX < 725 && (proposedY < 560 && proposedY > 370)) {
                    proposedX += moveAmount;
                }
                if (proposedX < 490) proposedX = 490;
            }
            if (!player.isFacingLeft()) {
                player.setFacingLeft(true);
            }
            moved = true;
            player.setDirection(Direction.WEST);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            proposedX += moveAmount;
            if (building instanceof Coop) {
                if (proposedX >= 1380) {
                    proposedX = 1380;
                }
            } else if (building instanceof Barn) {
                if (proposedX >= 1380) {
                    proposedX = 1380;
                }
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

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            Main.getMain().setScreen(gameScreen);
        }
    }
}
