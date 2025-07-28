package AP.group30.StardewValley.views;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.DateAndWeatherController;
import AP.group30.StardewValley.controllers.GameMenuController;
import AP.group30.StardewValley.models.Animals.*;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Buildings.Barn;
import AP.group30.StardewValley.models.Buildings.Building;
import AP.group30.StardewValley.models.Buildings.Coop;
import AP.group30.StardewValley.models.Buildings.Hut;
import AP.group30.StardewValley.models.Commands.GameMenuCommands;
import AP.group30.StardewValley.models.Game;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.GameObjects;
import AP.group30.StardewValley.models.Items.Products.*;
import AP.group30.StardewValley.models.Items.Products.ForagingSeed;
import AP.group30.StardewValley.models.Items.Products.Stone;
import AP.group30.StardewValley.models.Items.Products.Tree;
import AP.group30.StardewValley.models.Items.Tools.FishingPole;
import AP.group30.StardewValley.models.Items.Tools.Tool;
import AP.group30.StardewValley.models.Maps.*;
import AP.group30.StardewValley.models.Players.Direction;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.views.InGameMenus.*;
import AP.group30.StardewValley.views.InGameMenus.Hut.*;
import AP.group30.StardewValley.views.StartMenus.RegisterMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Timer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.regex.Matcher;

public class GameScreen implements Screen {
    private SpriteBatch batch;
    private Stage stage;
    private Table table;

    // *** Game entities ***
    public static ArrayList<Tree> trees = new ArrayList<>();
    public static ArrayList<Stone> stones = new ArrayList<>();
    public ArrayList<GameObjects> entities = new ArrayList<>();
    private RainBackground rainBackground;

    private OrthographicCamera camera;
    private final Game game;
    private final Player player;
    Texture whitePixelTexture;
    private float stateTime = 0f;


    private final Texture house;
    private final Texture clock;
    private final Texture energyBar;
    private final TextureRegion playerRegion;
    BitmapFont font = GameAssetManager.assetManager.get(GameAssetManager.skin).getFont("font");
    private final ShapeRenderer shapeRenderer = new ShapeRenderer();
    private TextField cheatField;

    private Animation<TextureRegion> lightningAnimation;
    private float lightningTimer = 0.0f;
    private boolean lightningHit = false;
    private Tile lightningTargetTile;
    private float lightningCooldown = 0f;
    private boolean cheatLightning = false;

    private final Map map;
    private final Tile[][] tiles;
    private Tile hutEntryTile = null;


    private int[][] grassMap;
    private final Random random = new Random();

    private float x;
    private float y;
    float speed = 150f;
    private InventoryScreen inventoryScreen;
    private SkillScreen skillScreen;
    private HutScreen hut;
    private CraftingScreen craftingScreen;
    private ArtisanScreen artisanScreen;

    private final BitmapFont info = GameAssetManager.assetManager.get(GameAssetManager.skin).getFont("font");

    private static float toolRotation = 0f;
    private float toolRotationSpeed = 0f;
    private boolean toolAnimating = false;

    private boolean isFishing = false;
    private boolean fiveSecPassed = false;
    private Timer.Task fishingTimer;
    private FishingMiniGame fishingMiniGame;

    public GameScreen(Game game) {
        this.game = game;
        stage = new Stage();
        table = new Table(GameAssetManager.assetManager.get(GameAssetManager.skin));
        player = game.getCurrentPlayer();
        house = GameAssetManager.assetManager.get(GameAssetManager.house);
        clock = GameAssetManager.assetManager.get(GameAssetManager.clock);
        energyBar = GameAssetManager.assetManager.get(GameAssetManager.energyBar);
        Texture playerTexture = GameAssetManager.assetManager.get(GameAssetManager.player21);
        playerRegion = new TextureRegion(playerTexture);
        lightningAnimation = new Animation<>(0.1f, GameAssetManager.getFront("lightning"));

        map = game.getCurrentPlayer().getMap();
        tiles = map.getTiles();
        findEntities();

        entities.add(player);
        entities.add(game.getHut());
        entities.add(game.getGreenHouse());

        x = Gdx.graphics.getWidth() * 1.2f;
        y = Gdx.graphics.getHeight() * 1.4f;
        player.getPlayerRect().setPosition(x, y);
        player.getPlayerRect().setSize(playerTexture.getWidth() * 2f, playerTexture.getHeight() / 2f);

        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        whitePixelTexture = new Texture(pixmap);
        pixmap.dispose();

        info.setColor(Color.BLACK);

//        Barn coop = new Barn(4, 6, 1800 / 32, 60 - 288 / 32, 12, "deluxe");
//        player.getMap().getBuildings().add(coop);
//        player.getMap().getBarns().add(coop);
//        Cow chicken = new Cow(1500, "X", 0, false, false, 0, 0);
//        coop.getAnimals().add(chicken);
//        Pig duck = new Pig(1500, "X", 0, false, false, 0, 0);
//        coop.getAnimals().add(duck);
//        Goat dinosaur = new Goat(1500, "X", 0, false, false, 0, 0);
//        coop.getAnimals().add(dinosaur);
//        Sheep dinosaurx = new Sheep(1500, "X", 0, false, false, 0, 0);
//        coop.getAnimals().add(dinosaur);
//        chicken.setBarn(coop);
//        dinosaurx.setBarn(coop);
//        duck.setBarn(coop);
//        dinosaur.setBarn(coop);
//        player.getAnimals().add(chicken);
//        player.getAnimals().add(dinosaurx);
//        player.getAnimals().add(duck);
//        player.getAnimals().add(dinosaur);
//        entities.add(coop);

        cheatField = new TextField("", GameAssetManager.assetManager.get(GameAssetManager.menuSkin));
        cheatField.setVisible(false);
    }

    @Override
    public void show() {
        batch = new SpriteBatch();

        table.add(cheatField).width(600);
        table.setPosition(table.getX(), table.getY() - Gdx.graphics.getHeight() / 2.3f);
        table.setFillParent(true);
        stage.addActor(table);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.zoom = 1f;
        rainBackground = new RainBackground(camera);

        Gdx.input.setInputProcessor(null);
        grassMap = generateGrassMap(tiles, grassMap, random);

        makeInGameMenus();
        findHut();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateTime += delta;
        player.setStateTime(stateTime);

        camera.position.set(x + playerRegion.getRegionWidth() / 2f, y + playerRegion.getRegionHeight() / 2f, 0);
        camera.update();
        if (!(stage.getKeyboardFocus() instanceof TextField)) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.O)) {
                Building building = findBuilding();
                if (building instanceof Coop) {
                    Main.getMain().setScreen(new CoopScreen(GameAssetManager.assetManager.get(GameAssetManager.menuSkin), GameAssetManager.assetManager.get(GameAssetManager.coopInterior), building));
                } else if (building instanceof Barn) {
                    Main.getMain().setScreen(new BarnScreen(GameAssetManager.assetManager.get(GameAssetManager.menuSkin), GameAssetManager.assetManager.get(GameAssetManager.barnInterior), building));
                }
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.T)) {
            if (!cheatField.isVisible()) {
                Gdx.input.setInputProcessor(stage);
                stage.setKeyboardFocus(cheatField);
                cheatField.setVisible(!cheatField.isVisible());
                cheatField.setText("");
            }
        }
        if (cheatField.isVisible()) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
                cheatField.setVisible(false);
                stage.setKeyboardFocus(null);
                Gdx.input.setInputProcessor(null);
            }
            Matcher matcher;
            if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
                if (cheatField.getText().equals("cheat thor")) {
                    cheatLightning = true;
                }
                matcher = GameMenuCommands.ENERGY_SET.regexMatcher(cheatField.getText());
                if (matcher.matches()) {
                    cheatField.setText("Cheat Code Activated!");
                    GameMenuController.cheatEnergySet(matcher.group("value"));
                }
                matcher = GameMenuCommands.CHEAT_DATE.regexMatcher(cheatField.getText());
                if (matcher.matches()) {
                    cheatField.setText("Cheat Code Activated!");
                    DateAndWeatherController.cheatAdvanceDate(matcher.group("X"));
                }
                matcher = GameMenuCommands.CHEAT_TIME.regexMatcher(cheatField.getText());
                if (matcher.matches()) {
                    cheatField.setText("Cheat Code Activated!");
                    DateAndWeatherController.cheatAdvanceTime(matcher.group("X"));
                }
                matcher = GameMenuCommands.CheatWeather.regexMatcher(cheatField.getText());
                if (matcher.matches()) {
                    cheatField.setText("Cheat Code Activated!");
                    DateAndWeatherController.cheatWeatherSet(matcher.group("type"));
                }
                matcher = GameMenuCommands.CHEAT_ADD_DOLLARS.regexMatcher(cheatField.getText());
                if (matcher.matches()) {
                    try {
                        cheatField.setText("Cheat Code Activated!");
                        GameMenuController.cheatAddMoney(Integer.parseInt(matcher.group("count")));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format in cheat command: " + matcher.group("count"));
                    }
                }
                matcher = GameMenuCommands.CHEAT_SET_FRIENDSHIP.regexMatcher(cheatField.getText());
                if (matcher.matches()) {
                    cheatField.setText("Cheat Code Activated!");
                    GameMenuController.cheatSetFriendship(matcher.group("animalName"), matcher.group("amount"));
                }
            }
        }

        batch.setProjectionMatrix(camera.combined);

        entities.sort(Comparator.comparing(GameObjects::getRenderY).reversed());

        batch.begin();

        renderBackground(camera, grassMap, batch);
        renderWallsAroundMap(tiles, batch);
        renderMap(batch, map);
        renderEntities(batch, map, entities);

        for (Animal animal : player.getAnimals()) {
            if (animal.isOut()) {
                animal.update(delta, player.getX(), player.getY());
                animal.render(batch);
            }
        }
        if (player.getNearbyAnimal() != null) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.G)) {
                player.getNearbyAnimal().shepherdAnimals();
            }
        }

        if (game.getCurrentTime().getHour() >= 18) {
            batch.setColor(0, 0, 0, 0.6f);
            batch.draw(whitePixelTexture, camera.position.x - Gdx.graphics.getWidth() / 2f - 50, camera.position.y - Gdx.graphics.getHeight() / 2f - 50, Gdx.graphics.getWidth() * 1.2f, Gdx.graphics.getHeight() * 1.2f);
            batch.setColor(Color.WHITE);
        }

        renderLightning(delta);

        if (isFishing && fiveSecPassed && !fishingMiniGame.isVisible()) isFishing = false;
        if (Gdx.input.isKeyJustPressed(Input.Keys.Q) && isFishing) {
            isFishing = false;
            fiveSecPassed = false;
            fishingMiniGame.hide();

            if (fishingTimer != null) {
                fishingTimer.cancel();
                fishingTimer = null;
            }
        }
        if (!isFishing && !(stage.getKeyboardFocus() instanceof TextField)) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.E) && openMenu(inventoryScreen)) inventoryScreen.toggle();
            if (Gdx.input.isKeyJustPressed(Input.Keys.N) && openMenu(skillScreen)) skillScreen.toggle();
            if (Gdx.input.isKeyJustPressed(Input.Keys.B) && openMenu(craftingScreen)) craftingScreen.toggle();
            if (Gdx.input.isKeyJustPressed(Input.Keys.I) && openMenu(artisanScreen)) artisanScreen.toggle();
            if (!isAnyMenuOpened()) {
                handleInput(delta);
                if (Gdx.input.isKeyPressed(Input.Keys.W)) camera.position.y += speed * delta;
                if (Gdx.input.isKeyPressed(Input.Keys.S)) camera.position.y -= speed * delta;
                if (Gdx.input.isKeyPressed(Input.Keys.A)) camera.position.x -= speed * delta;
                if (Gdx.input.isKeyPressed(Input.Keys.D)) camera.position.x += speed * delta;
            }
        }
        updateToolAnimation(delta);
        if (App.getCurrentGame().getCurrentWeather().equals(Weather.RAIN)) {
            rainBackground.updateAndRender(delta, batch);
        } else if (App.getCurrentGame().getCurrentWeather().equals(Weather.STORM)) {
            rainBackground.updateAndRender(delta, batch);
            batch.setColor(0, 0, 0, 0.6f);
            batch.draw(whitePixelTexture, camera.position.x - Gdx.graphics.getWidth() / 2f - 50, camera.position.y - Gdx.graphics.getHeight() / 2f - 50, Gdx.graphics.getWidth() * 1.2f, Gdx.graphics.getHeight() * 1.2f);
            batch.setColor(Color.WHITE);
        }
        renderEnergyBar(player, camera, energyBar, batch, shapeRenderer);
        renderTime(batch, camera, clock, font, game);
        batch.end();

        Tile currentTile = getTileUnderPlayer(x, y);

        if (currentTile.getX() == hutEntryTile.getX() &&
            currentTile.getY() == hutEntryTile.getY() + 1) {
            batch.begin();
            info.draw(batch, "You reached Hut entry!\nPress 'H' to enter!",camera.position.x - 50,camera.position.y + 510);
            batch.end();

            if (Gdx.input.isKeyJustPressed(Input.Keys.H)) hut.toggle();
        }

        inventoryScreen.render();
        skillScreen.render();
        craftingScreen.render();
        hut.render(batch, camera);
        artisanScreen.render();
        fishingMiniGame.render(delta);

        if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
            System.out.println(entities.size());
        }

        stage.act(delta);
        stage.draw();
    }

    private void renderLightning(float delta) {
        if (!game.getCurrentWeather().equals(Weather.STORM) && !cheatLightning) return;

        lightningCooldown -= delta;

        // Try triggering lightning (if not currently striking and cooldown passed)
        if (!lightningHit && lightningCooldown <= 0f) {
            int triggerChance = MathUtils.random(200); // 1 in 200 chance
            if (triggerChance == 1 || cheatLightning) {
                if (cheatLightning) {
                    lightningTargetTile = map.getTiles()[player.getX() / 32][60 - player.getY() / 32];
                } else {
                    lightningTargetTile = map.getTiles()[MathUtils.random(79)][MathUtils.random(59)];
                }
                DateAndWeatherController.cheatThor(lightningTargetTile);
                lightningHit = true;
                lightningTimer = 0f;
                lightningCooldown = 3f; // Wait 3 seconds before trying again
            }
        }

        // Draw the lightning if active
        if (lightningHit && lightningTargetTile != null) {
            lightningTimer += delta;
            TextureRegion lightningFrame = lightningAnimation.getKeyFrame(lightningTimer);
            float drawX = lightningTargetTile.getX() * 32;
            float drawY = (60 - lightningTargetTile.getY()) * 32;

            batch.draw(lightningFrame, drawX, drawY,
                lightningFrame.getRegionWidth() * 2f, lightningFrame.getRegionHeight() * 4f);

            if (lightningTimer >= lightningAnimation.getAnimationDuration()) {
                lightningHit = false;
                cheatLightning = false;
            }
        }
    }

    static int[][] generateGrassMap(Tile[][] tiles, int[][] grassMap, Random random) {
        int w = tiles.length + 100;
        int h = tiles[0].length + 100;
        grassMap = new int[w][h];

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                grassMap[i][j] = random.nextInt(4);
            }
        }
        return grassMap;
    }

    static void renderBackground(OrthographicCamera camera, int[][] grassMap, SpriteBatch batch) {
        int tileSize = 32;
        int offset = 50;

        int minX = (int)(camera.position.x - camera.viewportWidth / 2) / tileSize - 1;
        int maxX = (int)(camera.position.x + camera.viewportWidth / 2) / tileSize + 1;
        int minY = (int)(camera.position.y - camera.viewportHeight / 2) / tileSize - 1;
        int maxY = (int)(camera.position.y + camera.viewportHeight / 2) / tileSize + 1;

        for (int i = minX; i < maxX; i++) {
            for (int j = minY; j < maxY; j++) {
                int ix = i + offset;
                int jy = j + offset;

                Texture tex = switch (grassMap[ix][jy]) {
                    case 0 -> TileTexture.OUTDOOR_GRASS1.getTexture();
                    case 1 -> TileTexture.OUTDOOR_GRASS2.getTexture();
                    case 2 -> TileTexture.OUTDOOR_GRASS3.getTexture();
                    default -> TileTexture.OUTDOOR_GRASS4.getTexture();
                };
                batch.draw(tex, i * tileSize, j * tileSize, tileSize, tileSize);
            }
        }
    }

    static void renderEntities(SpriteBatch batch, Map map, ArrayList<GameObjects> entities) {
        Player player = App.getCurrentGame().getCurrentPlayer();

        for (GameObjects gameObjects : entities) {
            renderObject(batch, map, gameObjects, player);
        }
    }

    private static void renderObject(SpriteBatch batch, Map map, GameObjects gameObjects, Player player) {
        if (gameObjects instanceof Player) {
            if (player.getDirection() == Direction.NORTH) {
                float currentX = player.getX() + 5;
                float currentY = player.getY() + 20;

                batch.draw(player.getWield().getTexture(), currentX, currentY, 32, 32);
            }
        }
        gameObjects.render(batch, map);
        if (gameObjects instanceof Player) {
            if (player.getDirection() == Direction.EAST) {
                Texture itemTexture = player.getWield().getTexture();
                float currentX = player.getX() + 10;
                float currentY = player.getY() + 20;
                float originX = 10;
                float originY = 5;

                batch.draw(itemTexture, currentX, currentY, originX, originY, 32, 32, 1f, 1f, -toolRotation, 0, 0, itemTexture.getWidth(), itemTexture.getHeight(), false, false);
            }
            if (player.getDirection() == Direction.WEST) {
                Texture itemTexture = player.getWield().getTexture();
                float currentX = player.getX() - 10;
                float currentY = player.getY() + 20;
                float originX = 20;
                float originY = 5;

                batch.draw(player.getWield().getTexture(), currentX, currentY, originX, originY, 32, 32, 1f, 1f, toolRotation, 0, 0, itemTexture.getWidth(), itemTexture.getHeight(), true, false);
            }
            if (player.getDirection() == Direction.SOUTH) {
                float currentX = player.getX() + 5;
                float currentY = player.getY() + 20;

                batch.draw(player.getWield().getTexture(), currentX, currentY, 32, 32);
            }
        }
    }


    static void renderWallsAroundMap(Tile[][] tiles, SpriteBatch batch) {
        int tileSize = 32;
        int mapWidth = tiles.length;
        int mapHeight = tiles[0].length;

        for (int i = 0; i < mapWidth; i++) {
            batch.draw(TileTexture.DOWN_WALL.getTexture(), i * tileSize, 0, tileSize, tileSize);
            batch.draw(TileTexture.UP_WALL.getTexture(), i * tileSize, (mapHeight + 1) * tileSize, tileSize, (tileSize * 3));
        }

        for (int j = 1; j < mapHeight + 3; j++) {
            batch.draw(TileTexture.LEFT_WALL.getTexture(), -1 * tileSize, j * tileSize, tileSize, tileSize);
            batch.draw(TileTexture.RIGHT_WALL.getTexture(), mapWidth * tileSize, j * tileSize, tileSize, tileSize);
        }

        batch.draw(TileTexture.CORNER1_WALL.getTexture(), -1 * tileSize, 63 * tileSize, tileSize, tileSize);
        batch.draw(TileTexture.CORNER2_WALL.getTexture(), 80 * tileSize, 63 * tileSize, tileSize, tileSize);
    }

    private void findHut() {
        int startTIleX = 60;
        int endTIleX = 65;
        int startTIleY = 40;
        int endTIleY = 45;

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                Tile tile = tiles[i][j];
                if (tile.getType() == TileTypes.HUT) {
                    if (tiles[i-1][j].getType() != TileTypes.HUT) {
                        if (tiles[i][j+1].getType() != TileTypes.HUT) {
                            startTIleX = i;
                            startTIleY = 60 - j;
                        }
                    }
                    if (tiles[i+1][j].getType() != TileTypes.HUT) {
                        if (tiles[i][j-1].getType() != TileTypes.HUT) {
                            endTIleX = i;
                            endTIleY = 60 - j;
                        }
                    }
                }
            }
        }

        hutEntryTile = map.getTiles()[(startTIleX + endTIleX) / 2 + 1][58 - startTIleY];
    }

    static void renderMap(SpriteBatch batch, Map map1) {
        Tile[][] tiles = map1.getTiles();
        for (Tile[] value : tiles) {
            for (Tile tile : value) {
                if (tile != null) tile.render(batch);
            }
        }
    }

    static void renderEnergyBar(Player player, OrthographicCamera camera, Texture energyBar, SpriteBatch batch, ShapeRenderer shapeRenderer) {

        float maxEnergy = player.getMaxEnergy();
        float currentEnergy = player.getEnergy();
        float energyRatio = currentEnergy / maxEnergy;

        float barWidth = energyBar.getWidth();
        float barHeight = energyBar.getHeight();
        float barX = camera.position.x + Gdx.graphics.getWidth() / 2f - barWidth * 1.5f;
        float barY = camera.position.y - barHeight * 3.3f;

        float filledHeight = barHeight * energyRatio;

        Color barColor;
        if (energyRatio >= 0.66f) {
            barColor = Color.GREEN;
        } else if (energyRatio >= 0.33f) {
            barColor = Color.ORANGE;
        } else {
            barColor = Color.RED;
        }
        batch.draw(energyBar, barX, barY);

        batch.end();

        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(barColor);
        shapeRenderer.rect(barX + energyBar.getWidth() / 6f, barY + energyBar.getHeight() / 30f, barWidth * 2 / 3f, filledHeight * 3 / 4f); // draw from bottom up
        shapeRenderer.end();

        batch.begin();
    }


    static void renderTime(SpriteBatch batch, OrthographicCamera camera, Texture clock, BitmapFont font, Game game) {
        batch.draw(clock,camera.position.x + Gdx.graphics.getWidth() / 2.96f, camera.position.y + Gdx.graphics.getHeight() / 3.7f);
        font.setColor(Color.BLACK);
        font.draw(batch, String.format("%s %d",game.getCurrentTime().getDayOfWeek(),game.getCurrentTime().getDay()),camera.position.x + 760,camera.position.y + 510);
        font.draw(batch, String.format("%02d : %02d",game.getCurrentTime().getHour(),game.getCurrentTime().getMinute()),camera.position.x +800, camera.position.y + 420);
        //TODO
        font.draw(batch, "5 0 0",camera.position.x + 720, camera.position.y + 340);
    }


    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
    }

    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();
        house.dispose();
        inventoryScreen.dispose();
        skillScreen.dispose();
        craftingScreen.dispose();
        hut.dispose();
        clock.dispose();
        artisanScreen.dispose();
        fishingMiniGame.dispose();
    }

    private void handleInput(float delta) {
        if (stage.getKeyboardFocus() instanceof TextField) return;
        float moveAmount = speed * delta;

        float proposedX = x;
        float proposedY = y;

        boolean moved = false;

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            proposedY += moveAmount;
            moved = true;
            player.setDirection(Direction.NORTH);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            proposedY -= moveAmount;
            moved = true;
            player.setDirection(Direction.SOUTH);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            proposedX -= moveAmount;
            if (!player.isFacingLeft()) {
                player.setFacingLeft(true);
            }
            moved = true;
            player.setDirection(Direction.WEST);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            proposedX += moveAmount;
            if (player.isFacingLeft()) {
                player.setFacingLeft(false);
            }
            moved = true;
            player.setDirection(Direction.EAST);
        }

        if (moved) {
            player.setMoving(true);
            Tile tile = getTileUnderPlayer(proposedX, proposedY);
            if (tile.getType().equals(TileTypes.WATER) || (tile.getType().equals(TileTypes.QUARRY) && tile.getItem() instanceof ForagingMineral)) {
                return;
            }

            player.getPlayerRect().setPosition(proposedX, proposedY);
            boolean collides = false;
            if (!player.isInCity()) {

                if (player.getPlayerRect().overlaps(game.getHut().getRectangle())) {
                    collides = true;
                }

                if (player.getPlayerRect().overlaps(game.getGreenHouse().getRectangle())) {
                    collides = true;
                }

                for (Tree tree : trees) {
                    if (player.getPlayerRect().overlaps(tree.getRect())) {
                        collides = true;
                        break;
                    }
                }
                if (!collides) {
                    for (Stone stone : stones) {
                        if (player.getPlayerRect().overlaps(stone.getRect())) {
                            collides = true;
                            break;
                        }
                    }
                }
                if (!collides) {
                    for (Building building : player.getMap().getCoops()) {
                        if (player.getPlayerRect().overlaps(building.getRectangle())) {
                            collides = true;
                            break;
                        }
                    }
                    for (Building building : player.getMap().getBarns()) {
                        if (player.getPlayerRect().overlaps(building.getRectangle())) {
                            collides = true;
                            break;
                        }
                    }
                }
                if (!collides) {
                    for (Building building : player.getMap().getBuildings()) {
                        if (player.getPlayerRect().overlaps(building.getRectangle()) && !(building instanceof Hut)) {
                            collides = true;
                            break;
                        }
                    }
                }
            }
            if (!collides) {
                x = proposedX;
                y = proposedY;
            }

            player.getPlayerRect().setPosition(x, y);
            player.setX((int)x);
            player.setY((int)y);
            player.setEnergy(player.getEnergy() - 0.1f);
        }

        if (player.getX() > tiles[78][55].getX() * 32 && player.getY() > tiles[78][55].getY() * 32) {
            player.setInCity(true);
            RegisterMenu.cityScreen.setPosition(game.getCityMap().getTiles()[3][55].getX() * 32, game.getCityMap().getTiles()[3][55].getY() * 32);

            Main.getMain().setScreen(RegisterMenu.cityScreen);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.C) || Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            if (player.getWield() instanceof Tool) {
                if (player.getWield() instanceof FishingPole && hasWaterNeighbour()) {
                    isFishing = true;
                    fiveSecPassed = false;

                    if (fishingTimer != null) fishingTimer.cancel();
                    fishingTimer = new Timer.Task() {
                        @Override
                        public void run() {
                            fiveSecPassed = true;
                            fishingMiniGame.show();
                        }
                    };
                    Timer.schedule(fishingTimer, 5);
                }

                GameMenuController.toolUse(player.getDirection(), (int) (x), (int) (y + playerRegion.getRegionHeight() / 8f), batch);
                toolAnimation();
            } else if (player.getWield() instanceof ForagingSeed) {
                GameMenuController.plant(player.getWield().getName(), player.getDirection());
            } else if (player.getWield().getName().equals("speed-gro") || player.getWield().getName().equals("deluxe retaining soil")) {
                GameMenuController.fertilize(player.getWield().getName(), player.getDirection());
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            DateAndWeatherController.cheatAdvanceTime("10");
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.G)) {
            game.getGreenHouse().buildGreenhouse();
        }
    }

    private boolean hasWaterNeighbour() {
        Tile[][] tiles = player.getMap().getTiles();
        Tile tile = getTileUnderPlayer(x, y);
        int x = tile.getX();
        int y = tile.getY();

        try {
            return tiles[x+1][y].getType().equals(TileTypes.WATER) ||
                   tiles[x-1][y].getType().equals(TileTypes.WATER) ||
                   tiles[x][y+1].getType().equals(TileTypes.WATER) ||
                   tiles[x][y-1].getType().equals(TileTypes.WATER);
        } catch (Exception e) {
            return false;
        }
    }

    private void toolAnimation() {
        if (toolAnimating) return;

        toolAnimating = true;
        toolRotationSpeed = 600f;
    }

    private void updateToolAnimation(float delta) {
        if (toolAnimating) {
            toolRotation += toolRotationSpeed * delta;

            if (toolRotationSpeed >= 0 && toolRotation >= 45f) {
                if (isFishing) toolRotationSpeed = 0f;
                else toolRotationSpeed = -600f;

                toolRotation = 45f;
            }

            if (toolRotationSpeed < 0 && toolRotation <= 0f) {
                toolRotation = 0f;
                toolRotationSpeed = 0f;
                toolAnimating = false;
            }
        }
    }

    private Tile getTileUnderPlayer(float playerX, float playerY) {
        int tileX = (int)(playerX / 32);
        int tileY = (int)(playerY / 32);
        if (player.isInCity()) {
            return game.getCityMap().getTiles()[tileX][60 - tileY];
        }
        return tiles[tileX][60 - tileY];
    }

    private boolean isAnyMenuOpened() {
        return inventoryScreen.isVisible() ||
               skillScreen.isVisible() ||
               hut.isVisible() ||
               craftingScreen.isVisible() ||
               artisanScreen.isVisible();
    }

    private boolean openMenu(InGameMenuScreen menuScreen) {
        if (menuScreen.isVisible()) return true;

        return !artisanScreen.isVisible() &&
            !inventoryScreen.isVisible() &&
            !craftingScreen.isVisible() &&
            !skillScreen.isVisible();
    }

    private void findEntities() {
        for (int i = map.getTiles().length - 1; i >= 0; i--) {
            for (int j = 0; j < map.getTiles()[i].length; j++) {
                Tile tile = map.getTiles()[i][j];
                if (tile.getItem() != null) {
                    if (tile.getItem().getClass().equals(Tree.class)) {
                        Tree tree = (Tree) tile.getItem();
                        trees.add(tree);
                        entities.add(tree);
                    } else if (tile.getItem().getClass().equals(Stone.class)) {
                        Stone stone = (Stone) tile.getItem();
                        stones.add(stone);
                        entities.add(stone);
                    } else if (tile.getItem() instanceof ForagingMineral) {
                        entities.add((ForagingMineral)tile.getItem());
                    }
                }
            }
        }
    }

    public ArrayList<GameObjects> getEntities() {
        return entities;
    }

    private void makeInGameMenus() {
        inventoryScreen = new InventoryScreen(batch, Main.getMain().skin);
        skillScreen = new SkillScreen(batch, Main.getMain().skin);
        craftingScreen = new CraftingScreen(batch, Main.getMain().skin);
        hut = new HutScreen(batch, Main.getMain().skin);
        artisanScreen = new ArtisanScreen(batch, Main.getMain().skin);
        fishingMiniGame = new FishingMiniGame(batch, Main.getMain().skin);
    }

    private Building findBuilding() {
        for (Building building : player.getMap().getBuildings()) {
            if (player.getPlayerRect().overlaps(buildingRect(building))) {
                return building;
            }
        }
        return null;
    }

    private Rectangle buildingRect(Building building) {
        Rectangle shopRect = new Rectangle();
        shopRect.x = building.getRectangle().x - 32;
        shopRect.y = building.getRectangle().y - 32;
        shopRect.width = building.getRectangle().width;
        shopRect.height = building.getRectangle().height;
        return shopRect;
    }

    // True for rain and false for snow
    private void renderRain(boolean rainOrSnow, float delta) {
        Texture rain = rainOrSnow ? GameAssetManager.assetManager.get(GameAssetManager.rain) : GameAssetManager.assetManager.get(GameAssetManager.snow);

    }
}
