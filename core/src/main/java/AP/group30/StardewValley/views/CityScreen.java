package AP.group30.StardewValley.views;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.DateAndWeatherController;
import AP.group30.StardewValley.controllers.GameMenuController;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Buildings.Building;
import AP.group30.StardewValley.models.Buildings.Hut;
import AP.group30.StardewValley.models.Game;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.GameObjects;
import AP.group30.StardewValley.models.Items.Products.Crop;
import AP.group30.StardewValley.models.Items.Products.ForagingSeed;
import AP.group30.StardewValley.models.Items.Tools.Tool;
import AP.group30.StardewValley.models.Maps.Map;
import AP.group30.StardewValley.models.Maps.Tile;
import AP.group30.StardewValley.models.Maps.TileTypes;
import AP.group30.StardewValley.models.Maps.Weather;
import AP.group30.StardewValley.models.Players.Direction;
import AP.group30.StardewValley.models.Players.NPC.*;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.models.Players.RemotePlayer;
import AP.group30.StardewValley.network.MessageClasses.MapTransfer;
import AP.group30.StardewValley.network.MessageClasses.PlayerMove;
import AP.group30.StardewValley.views.InGameMenus.Hut.*;
import AP.group30.StardewValley.views.InGameMenus.*;
import AP.group30.StardewValley.views.StartMenus.RegisterMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Random;

public class CityScreen implements Screen {
    private final Map map = App.getCurrentGame().getCityMap();
    private Stage stage;
    private Game game;
    public ArrayList<GameObjects> entities = new ArrayList<>();
    private final Texture clock;
    private final Texture energyBar;
    private final Rectangle playerRect = new Rectangle();
    private final ShapeRenderer shapeRenderer = new ShapeRenderer();
    private final Tile[][] tiles;
    private int[][] grassMap;
    private final Random random = new Random();
    private final Player player;
    private final TextureRegion playerRegion;
    Texture whitePixelTexture;
    BitmapFont font = (new Skin(Gdx.files.internal("skin/pixthulhu-ui.json")).getFont("font"));
    private float stateTime = 0;
    private RainBackground rainBackground;

    private float x;
    private float y;
    float speed = 150f;
    private InventoryScreen inventoryScreen;
    private SkillScreen skillScreen;
    private HutScreen hut;
    private ShopScreen shopScreen;
    private QuestScreen questScreen;
    private ReactionMenu reactionMenu;
    private final SpriteBatch batch;
    private OrthographicCamera camera;

    private float timeSinceLastSend = 0;
    private final float sendInterval = 1/10f;

    public CityScreen(Game game) {
        this.tiles = map.getTiles();
        this.game = App.getCurrentGame();
        player = game.getCurrentPlayer();
        this.game = game;
        clock = GameAssetManager.assetManager.get(GameAssetManager.clock);
        energyBar = GameAssetManager.assetManager.get(GameAssetManager.energyBar);
        Texture playerTexture = GameAssetManager.assetManager.get(GameAssetManager.player21);
        playerRegion = new TextureRegion(playerTexture);
        entities.addAll(game.getBuildings());
        entities.add(player);
        x = Gdx.graphics.getWidth() * 1.2f;
        y = Gdx.graphics.getHeight() * 1.4f;
        playerRect.setPosition(x, y);
        playerRect.setSize(playerTexture.getWidth() * 2f, playerTexture.getHeight() / 2f);
        batch = new SpriteBatch();
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        whitePixelTexture = new Texture(pixmap);
        pixmap.dispose();
    }


    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.zoom = 1f;
        rainBackground = new RainBackground(camera);
        Gdx.input.setInputProcessor(null);
        grassMap = GameScreen.generateGrassMap(tiles, grassMap, random);
        inventoryScreen = new InventoryScreen(batch, Main.getMain().skin);
        skillScreen = new SkillScreen(batch, Main.getMain().skin);
        questScreen = new QuestScreen(batch, Main.getMain().skin);
        reactionMenu = new ReactionMenu(batch, Main.getMain().skin);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateTime += delta;
        player.setStateTime(stateTime);

        if (Gdx.input.isKeyJustPressed(Input.Keys.E) && !reactionMenu.isVisible()) inventoryScreen.toggle();
        RegisterMenu.gameScreen.passTime();
        if (Gdx.input.isKeyJustPressed(Input.Keys.Z) && !reactionMenu.isVisible()) skillScreen.toggle();

        camera.position.set(x + playerRegion.getRegionWidth() / 2f, y + playerRegion.getRegionHeight() / 2f, 0);
        camera.update();

        batch.setProjectionMatrix(camera.combined);

        entities.sort(Comparator.comparing(GameObjects::getRenderY).reversed());

        if (Gdx.input.isKeyJustPressed(Input.Keys.O) && !reactionMenu.isVisible()) {
            if (shopScreen == null) {
                shopScreen = findShopScreen();
                if (shopScreen != null) {
                    shopScreen.show();
                }
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE) &&  shopScreen != null && shopScreen.isVisible()) {
            shopScreen.hide();
            shopScreen.dispose();
            shopScreen = null;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE) && reactionMenu.isVisible()) {
            if (reactionMenu != null) {
                reactionMenu.toggle();
            }
        }

        batch.begin();
        GameScreen.renderBackground(camera, grassMap, batch);
        GameScreen.renderWallsAroundMap(tiles, batch);
        GameScreen.renderMap(batch, map);
        GameScreen.renderEntities(batch, entities);
        renderNPCs(batch, stateTime, delta);
        for (RemotePlayer p : game.getModel().getOtherPlayers()) {
            if (p.username.equals(App.getCurrentUser().getUsername())) continue;
            p.render(batch);
            if (p.getReactionTime() > 0f) {
                p.decreaseReactionTimer(delta);
                p.renderReaction(batch);
            }
        }
        if (game.getCurrentTime().getHour() >= 18) {
            batch.setColor(0, 0, 0, 0.6f);
            batch.draw(whitePixelTexture, camera.position.x - Gdx.graphics.getWidth() / 2f - 50, camera.position.y - Gdx.graphics.getHeight() / 2f - 50, Gdx.graphics.getWidth() * 1.2f, Gdx.graphics.getHeight() * 1.2f);
            batch.setColor(Color.WHITE);
        }
        if (!isAnyMenuOpened()) {
            handleInput(delta);
            if (Gdx.input.isKeyPressed(Input.Keys.W)) camera.position.y += speed * delta;
            if (Gdx.input.isKeyPressed(Input.Keys.S)) camera.position.y -= speed * delta;
            if (Gdx.input.isKeyPressed(Input.Keys.A)) camera.position.x -= speed * delta;
            if (Gdx.input.isKeyPressed(Input.Keys.D)) camera.position.x += speed * delta;
        }

        Vector3 mousePos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(mousePos);
        for(NPC npc: game.getNPCs()){
            Rectangle bounds = npc.getRectangle();
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT) && bounds.contains(mousePos.x, mousePos.y)
                || npc.getDialogueTimer() > 0){
                npc.showDialog(batch, font, camera);
                if (npc.getDialogueTimer() > 0) {
                    npc.decreaseDialogueTimer(delta);
                }
            } else if(Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT) && bounds.contains(mousePos.x, mousePos.y)){
                questScreen.setCurrentNPC(npc);
                questScreen.toggle();
            }
        }
        if (App.getCurrentGame().getCurrentWeather().equals(Weather.RAIN)) {
            rainBackground.updateAndRender(delta, batch);
        } else if (App.getCurrentGame().getCurrentWeather().equals(Weather.STORM)) {
            rainBackground.updateAndRender(delta, batch);
            batch.setColor(0, 0, 0, 0.6f);
            batch.draw(whitePixelTexture, camera.position.x - Gdx.graphics.getWidth() / 2f - 50, camera.position.y - Gdx.graphics.getHeight() / 2f - 50, Gdx.graphics.getWidth() * 1.2f, Gdx.graphics.getHeight() * 1.2f);
            batch.setColor(Color.WHITE);
        }
        GameScreen.renderEnergyBar(player, camera, energyBar, batch, shapeRenderer);
        GameScreen.renderTime(batch, camera, clock, font, game);
        if (Gdx.input.isKeyPressed(Input.Keys.TAB)) {
            drawOtherPlayersList(font, batch, camera);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.M) && !reactionMenu.isVisible()) {
            reactionMenu.toggle();
        }

        if (player.getReactionTime() > 0f) {
            player.decreaseReactionTimer(delta);
            player.renderReaction(batch);
        }
        batch.end();

        inventoryScreen.render();
        skillScreen.render();
        questScreen.render();
        reactionMenu.render();
        if (shopScreen != null) {
            if (!shopScreen.render(batch, camera)) {
                shopScreen.hide();
                shopScreen.dispose();
                shopScreen = null;
            }
        }
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
        questScreen.dispose();
        reactionMenu.dispose();
    }

    private void handleInput(float delta) {
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
            if (tile.getType().equals(TileTypes.WATER)) {
                return;
            }

            playerRect.setPosition(proposedX, proposedY);
            boolean collides = false;
            for (Building building : game.getBuildings()) {
                if (playerRect.overlaps(building.getRectangle()) && !(building instanceof Hut)) {
                    collides = true;
                    break;
                }
            }
            if(!collides){
                for(NPC npc: game.getNPCs()){
                    if (playerRect.overlaps(npc.getRectangle())) {
                        collides = true;
                        break;
                    }
                }
            }


            if (!collides) {
                x = proposedX;
                y = proposedY;
            }

//            playerRect.setPosition(x, y);
//            player.setX((int)x);
//            player.setY((int)y);
            player.setX((int)proposedX);
            player.setY((int)proposedY);
            playerRect.setPosition(x, y);
            timeSinceLastSend += delta;


            if ((proposedX != player.getX() || proposedY != player.getY()) && timeSinceLastSend >= sendInterval) {
                PlayerMove pm = new PlayerMove();
                pm.playerId = String.valueOf(Main.getMain().id);
                pm.x = proposedX;
                pm.y = proposedY;
                App.getNetworkClient().send(pm);
                timeSinceLastSend = 0;
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            player.setInCity(false);
            MapTransfer mapTransfer = new MapTransfer();
            mapTransfer.targetMapId = "farm" + Main.getMain().id;
            mapTransfer.playerId = String.valueOf(Main.getMain().id);
            Main.getMain().client.send(mapTransfer);
            Main.getMain().setScreen(RegisterMenu.gameScreen);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.C) || Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            if (player.getWield() instanceof Tool) {
                GameMenuController.toolUse(player.getDirection(), (int) (x), (int) (y + playerRegion.getRegionHeight() / 8f), batch, tiles);
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            DateAndWeatherController.cheatAdvanceTime("10");
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
        if (shopScreen != null) {
            if (shopScreen.isVisible()) {
                return true;
            }
        }
        return inventoryScreen.isVisible() ||
            skillScreen.isVisible() ||
            questScreen.isVisible() ||
            reactionMenu.isVisible();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    private ShopScreen findShopScreen() {
        ShopScreen shopScreen = null;
        Skin skin = GameAssetManager.assetManager.get(GameAssetManager.menuSkin);
        for (Building building : game.getBuildings()) {
            if (playerRect.overlaps(shopRect(building))) {
                if (game.getCurrentTime().getHour() >= building.getStartHour() && game.getCurrentTime().getHour() <= building.getEndHour()) {
                    shopScreen = new ShopScreen(batch, skin, building.getItems(), building.getNotAvailableItems(), building);
                } else {
                    System.out.println("Shop is closed! return at " + building.getStartHour());
                }
            }
        }
        return shopScreen;
    }

    private Rectangle shopRect(Building building) {
        Rectangle shopRect = new Rectangle();
        shopRect.x = building.getRectangle().x - 32;
        shopRect.y = building.getRectangle().y - 32;
        shopRect.width = building.getRectangle().width;
        shopRect.height = building.getRectangle().height;
        return shopRect;
    }

    static void renderNPCs(SpriteBatch batch, float stateTime, float delta) {
        Leah.render(batch, stateTime);
        if (Leah.reactionTimer > 0) {
            Leah.reactionTimer -= delta;
        }
        Harvey.render(batch, stateTime);
        if (Harvey.reactionTimer > 0) {
            Harvey.reactionTimer -= delta;
        }
        Robin.render(batch, stateTime);
        if (Robin.reactionTimer > 0) {
            Robin.reactionTimer -= delta;
        }
        Sebastian.render(batch, stateTime);
        if (Sebastian.reactionTimer > 0) {
            Sebastian.reactionTimer -= delta;
        }
        Abigail.render(batch, stateTime);
        if (Abigail.reactionTimer > 0) {
            Abigail.reactionTimer -= delta;
        }
    }

    public static void drawOtherPlayersList(BitmapFont font, SpriteBatch batch, OrthographicCamera camera) {
        Collection<RemotePlayer> others = App.getCurrentGame().getModel().getOtherPlayers();
        int count = others.size();
        int padding = 15;
        int lineHeight = 20;
        int boxWidth = 200;
        int boxHeight = padding * 2 + count * lineHeight;
        int x = 10;
        int y = Gdx.graphics.getHeight() - 10;


        font.setColor(Color.WHITE);
        int textX = x + padding;
        int textY = -padding - lineHeight + (int)font.getLineHeight();
        for (RemotePlayer p : others) {
            String username = p.username;
            font.draw(batch, String.format("%s", username), camera.position.x + padding - Gdx.graphics.getWidth() / 2f,camera.position.y + Gdx.graphics.getHeight() / 2.53f - textY);
            textY -= lineHeight;
        }
        font.setColor(Color.BLACK);
    }

    public static void showReaction(Player thisPlayer, String text) {
        Texture reactionTexture;

        switch (text){
            case "happy":
                reactionTexture = GameAssetManager.assetManager.get(GameAssetManager.happyEmote);
                break;
            case "sad":
                reactionTexture = GameAssetManager.assetManager.get(GameAssetManager.sadEmote);
                break;
            case "angry":
                reactionTexture = GameAssetManager.assetManager.get(GameAssetManager.angryEmote);
                break;
            case "heart":
                reactionTexture = GameAssetManager.assetManager.get(GameAssetManager.heartEmote);
                break;
            case "yes":
                reactionTexture = GameAssetManager.assetManager.get(GameAssetManager.yesEmote);
                break;
            case "no":
                reactionTexture = GameAssetManager.assetManager.get(GameAssetManager.noEmote);
                break;
            default:
                reactionTexture = GameAssetManager.assetManager.get(GameAssetManager.chat);
                thisPlayer.setChat(text);
        }

        thisPlayer.setReactionTexture(reactionTexture);
        thisPlayer.setReactionTime(3f);
    }

    public static void showReaction(RemotePlayer thisPlayer, String text) {
        Texture reactionTexture;

        switch (text){
            case "happy":
                reactionTexture = GameAssetManager.assetManager.get(GameAssetManager.happyEmote);
                break;
            case "sad":
                reactionTexture = GameAssetManager.assetManager.get(GameAssetManager.sadEmote);
                break;
            case "angry":
                reactionTexture = GameAssetManager.assetManager.get(GameAssetManager.angryEmote);
                break;
            case "heart":
                reactionTexture = GameAssetManager.assetManager.get(GameAssetManager.heartEmote);
                break;
            case "yes":
                reactionTexture = GameAssetManager.assetManager.get(GameAssetManager.yesEmote);
                break;
            case "no":
                reactionTexture = GameAssetManager.assetManager.get(GameAssetManager.noEmote);
                break;
            default:
                reactionTexture = GameAssetManager.assetManager.get(GameAssetManager.chat);
                thisPlayer.setChat(text);
        }

        thisPlayer.setReactionTexture(reactionTexture);
        thisPlayer.setReactionTime(3f);
    }
}
