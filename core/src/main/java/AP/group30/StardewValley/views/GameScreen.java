package AP.group30.StardewValley.views;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.GameMenuController;
import AP.group30.StardewValley.models.Buildings.BlacksmithCosts;
import AP.group30.StardewValley.models.Buildings.Building;
import AP.group30.StardewValley.models.Buildings.Hut;
import AP.group30.StardewValley.models.Game;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.GameObjects;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.Products.Stone;
import AP.group30.StardewValley.models.Items.Products.Tree;
import AP.group30.StardewValley.models.Maps.Map;
import AP.group30.StardewValley.models.Maps.Tile;
import AP.group30.StardewValley.models.Maps.TileTexture;
import AP.group30.StardewValley.models.Maps.TileTypes;
import AP.group30.StardewValley.models.Players.Direction;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.views.Hut.HutScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class GameScreen implements Screen {
    private SpriteBatch batch;


//     // *** Game entities ***
     public static ArrayList<Tree> trees = new ArrayList<>();
     public static ArrayList<Stone> stones = new ArrayList<>();
     public static ArrayList<GameObjects> entities = new ArrayList<>();

    private OrthographicCamera camera;
    private Game game;
    private Player player;
    private Texture playerTexture = GameAssetManager.assetManager.get(GameAssetManager.player21);
    private float stateTime = 0f;
    private boolean isMoving = false;

    private Rectangle playerRect = new Rectangle();
    private Texture house;
    private Texture clock;
    private Texture energyBar;
    private TextureRegion playerRegion;
    BitmapFont font = (new Skin(Gdx.files.internal("skin/pixthulhu-ui.json")).getFont("font"));
    private final ShapeRenderer shapeRenderer = new ShapeRenderer();



    private Map map;
    private final Tile[][] tiles;
    private Tile currentTile;
    private Tile hutEntryTile = null;


    private int[][] grassMap;
    private final Random random = new Random();

    private float x;
    private float y;
    float speed = 150f;

    private InventoryScreen inventoryScreen;
    private SkillScreen skillScreen;
    private HutScreen hut;

    private final BitmapFont info = (Main.getMain().skin).getFont("font");
    private ShopScreen shopScreen;

    public GameScreen(Game game) {
        this.game = game;

        player = game.getCurrentPlayer();
        house = GameAssetManager.assetManager.get(GameAssetManager.house);
        clock = GameAssetManager.assetManager.get(GameAssetManager.clock);
        energyBar = GameAssetManager.assetManager.get(GameAssetManager.energyBar);
        playerRegion = new TextureRegion(playerTexture);

        map = game.getCurrentPlayer().getMap();
        tiles = map.getTiles();
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
                    }
                }
            }
        }
        entities.addAll(game.getBuildings());
        entities.add(player);


        x = Gdx.graphics.getWidth() * 1.2f;
        y = Gdx.graphics.getHeight() * 1.4f;
        playerRect.setPosition(x, y);
        playerRect.setSize(playerTexture.getWidth() * 2f, playerTexture.getHeight() / 2f);
    }

    @Override
    public void show() {
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.zoom = 1f;

        Gdx.input.setInputProcessor(null);
        generateGrassMap();

        inventoryScreen = new InventoryScreen(batch, Main.getMain().skin);
        skillScreen = new SkillScreen(batch, Main.getMain().skin);
        hut = new HutScreen(batch, Main.getMain().skin);
        info.setColor(Color.WHITE);
      
        shopScreen = new ShopScreen(batch, Main.getMain().skin, BlacksmithCosts.values());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateTime += delta;
        player.setStateTime(stateTime);
        isMoving = false;

        if (!inventoryScreen.isVisible() && !skillScreen.isVisible() && !shopScreen.isVisible()) {
            handleInput(delta);
            if (Gdx.input.isKeyPressed(Input.Keys.W)) camera.position.y += speed * delta;
            if (Gdx.input.isKeyPressed(Input.Keys.S)) camera.position.y -= speed * delta;
            if (Gdx.input.isKeyPressed(Input.Keys.A)) camera.position.x -= speed * delta;
            if (Gdx.input.isKeyPressed(Input.Keys.D)) camera.position.x += speed * delta;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.TAB)) shopScreen.toggle();
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) inventoryScreen.toggle();
        if (Gdx.input.isKeyJustPressed(Input.Keys.N)) skillScreen.toggle();

        camera.position.set(x + playerRegion.getRegionWidth() / 2f, y + playerRegion.getRegionHeight() / 2f, 0);
        camera.update();

        batch.setProjectionMatrix(camera.combined);

        entities.sort(Comparator.comparing(GameObjects::getRenderY).reversed());
        batch.begin();
        renderBackground();
        renderWallsAroundMap();
        if (player.isInCity()) {
            renderMap(game.getCityMap());
        } else {
            renderMap(map);
//            renderBuilding(TileTypes.HUT, map, house);
        }
        renderEntities();
        renderEnergyBar();
        renderTime();
        if (!isAnyMenuOpened()) {
            handleInput(delta);
            if (Gdx.input.isKeyPressed(Input.Keys.W)) camera.position.y += speed * delta;
            if (Gdx.input.isKeyPressed(Input.Keys.S)) camera.position.y -= speed * delta;
            if (Gdx.input.isKeyPressed(Input.Keys.A)) camera.position.x -= speed * delta;
            if (Gdx.input.isKeyPressed(Input.Keys.D)) camera.position.x += speed * delta;
        }
        renderPlayer();
        batch.end();

        currentTile = getTileUnderPlayer(x, y);

        if (currentTile.getX() == hutEntryTile.getX() &&
            currentTile.getY() == hutEntryTile.getY() + 1) {
            batch.begin();
            info.draw(batch, "You reached Hut entry!\nPress 'H' to enter!",camera.position.x - 50,camera.position.y + 510);
            batch.end();

            if (Gdx.input.isKeyJustPressed(Input.Keys.H)) hut.toggle();
        }

        inventoryScreen.render();
        skillScreen.render();
        hut.render();
        shopScreen.render();
    }

    private void generateGrassMap() {
        int w = tiles.length + 100;
        int h = tiles[0].length + 100;
        grassMap = new int[w][h];

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                grassMap[i][j] = random.nextInt(4);
            }
        }
    }

    private void renderBackground() {
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

    private void renderEntities() {
        if (player.isInCity()) {
            for (GameObjects g : entities) {
                if (!(g instanceof Tree) && !(g instanceof Stone) && !(g instanceof Hut)) {
                    g.render(batch, game.getCityMap());
                }
            }
        } else {
            for (GameObjects g : entities) {
                if (!(g instanceof Building)) {
                    g.render(batch, map);
                }
                if (g instanceof Hut) {
                    g.render(batch, map);
                }
            }
        }
    }

    private void renderWallsAroundMap() {
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

    private void renderHut() {
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

        batch.draw(house,
            map.getTiles()[startTIleX][startTIleY].getX() * 32,
            map.getTiles()[startTIleX][startTIleY].getY() * 32,
            (endTIleX - startTIleX + 2) * 32,
            (endTIleY - startTIleY + 3) * 32
        );

        hutEntryTile = map.getTiles()[(startTIleX + endTIleX) / 2][60 - startTIleY];
    }

//    private void renderBuilding(TileTypes tileType, Map map1, Texture texture) {
//        int startTIleX = 60;
//        int endTIleX = 65;
//        int startTIleY = 40;
//        int endTIleY = 45;
//        Tile[][] tiles1 = map1.getTiles();
//
//        for (int i = 0; i < tiles1.length; i++) {
//            for (int j = 0; j < tiles1[i].length; j++) {
//                Tile tile = tiles1[i][j];
//                if (tile.getType() == tileType) {
//                    if (tiles1[i-1][j].getType() != tileType) {
//                        if (tiles1[i][j+1].getType() != tileType) {
//                            startTIleX = i;
//                            startTIleY = 60 - j;
//                        }
//                    }
//                    if (tiles1[i+1][j].getType() != tileType) {
//                        if (tiles1[i][j-1].getType() != tileType) {
//                            endTIleX = i;
//                            endTIleY = 60 - j;
//                        }
//                    }
//                }
//            }
//            System.out.println("x: " + startTIleX + ", y: " + startTIleY + ", width: " + (endTIleX - startTIleX) + ", height: " + (startTIleY -endTIleY));
//        }
//
//        batch.draw(texture,
//            map1.getTiles()[startTIleX - 1][startTIleY + 1].getX() * 32,
//            map1.getTiles()[startTIleX][startTIleY].getY() * 32,
//            (endTIleX - startTIleX + 3) * 32,
//            (endTIleY - startTIleY + 4) * 32
//        );
//    }

    private void renderMap(Map map1) {
        Tile[][] tiles = map1.getTiles();
        for (Tile[] value : tiles) {
            for (Tile tile : value) {
                if (tile != null) tile.render(batch);
            }
        }
    }

    private void renderItems() {
        Tile[][] tiles = map.getTiles();
        for (int i = tiles.length - 1; i >= 0; i--) {
            for (int j = 0; j < tiles[i].length; j++) {
                Tile tile = tiles[i][j];
                if (tile.getItem() != null)
                    tile.getItem().renderItem(batch, tile.getX() * 32, (60 - tile.getY()) * 32);
            }
        }
    }

    private void renderEnergyBar() {

        float maxEnergy = player.getMaxEnergy();
        float currentEnergy = player.getEnergy();
        float energyRatio = currentEnergy / maxEnergy;

        float barWidth = energyBar.getWidth();
        float barHeight = energyBar.getHeight();
        float barX = camera.position.x + Gdx.graphics.getWidth() / 2f - barWidth * 1.5f;
        float barY = camera.position.y - barHeight * 3.3f;

        // Calculate filled height
        float filledHeight = barHeight * energyRatio;

        // Determine color
        Color barColor;
        if (energyRatio >= 0.66f) {
            barColor = Color.GREEN;
        } else if (energyRatio >= 0.33f) {
            barColor = Color.ORANGE;
        } else {
            barColor = Color.RED;
        }
        // Draw the energy bar frame (border image)
        batch.draw(energyBar, barX, barY);

        // Disable batch temporarily to use ShapeRenderer
        batch.end();

        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(barColor);
        shapeRenderer.rect(barX + energyBar.getWidth() / 6f, barY + energyBar.getHeight() / 30f, barWidth * 2 / 3f, filledHeight * 3 / 4f); // draw from bottom up
        shapeRenderer.end();

        batch.begin();
    }


    private void renderTime(){
        batch.draw(clock,camera.position.x + Gdx.graphics.getWidth() / 2.96f, camera.position.y + Gdx.graphics.getHeight() / 3.7f);
        font.setColor(Color.BLACK);
        font.draw(batch, String.format("%s %d",game.getCurrentTime().getDayOfWeek(),game.getCurrentTime().getDay()),camera.position.x + 760,camera.position.y + 510);
        font.draw(batch, String.format("%02d : %02d",game.getCurrentTime().getHour(),game.getCurrentTime().getMinute()),camera.position.x +800, camera.position.y + 420);
        //TODO
        font.draw(batch, String.format("5 0 0"),camera.position.x + 720, camera.position.y + 340);
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
        hut.dispose();
        clock.dispose();

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
            if (!player.isInCity()) {
                boolean collides = false;

                if (playerRect.overlaps(game.getHut().getRectangle())) {
                    collides = true;
                }
                for (Tree tree : trees) {
                    if (playerRect.overlaps(tree.getRect())) {
                        collides = true;
                        break;
                    }
                }
                if (!collides) {
                    for (Stone stone : stones) {
                        if (playerRect.overlaps(stone.getRect())) {
                            collides = true;
                            break;
                        }
                    }
                }
                if (!collides) {
                    x = proposedX;
                    y = proposedY;
                }
            } else {
                boolean collides = false;
                for (Building building : game.getBuildings()) {
                    if (playerRect.overlaps(building.getRectangle()) && !(building instanceof Hut)) {
                        collides = true;
                        break;
                    }
                }
                if (!collides) {
                    x = proposedX;
                    y = proposedY;
                }
            }

            playerRect.setPosition(x, y);
            player.setX((int)x);
            player.setY((int)y);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            player.setInCity(!player.isInCity());
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.C) || Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            GameMenuController.toolUse(player.getDirection(), (int)(x), (int)(y + playerRegion.getRegionHeight() / 8f), batch);
        }
    }


    private boolean isWalkableTile(float nextX, float nextY, float changeX, float changeY) {
        int tileSize = 32;

        int tileX = (int)((nextX + changeX) / tileSize);
        int tileY = map.getTiles()[0].length - (int)((nextY + changeY) / tileSize);

        if (tileX >= 0 && tileX < map.getTiles().length &&
            tileY >= 0 && tileY < map.getTiles()[0].length) {

            Tile destinationTile = map.getTiles()[tileX][tileY];
            return destinationTile.isWalkable();
        }

        return false;
    }

    private Tile getTileUnderPlayer(float playerX, float playerY) {
        int tileX = (int)(playerX / 32);
        int tileY = (int)(playerY / 32);
        if (player.isInCity()) {
            return game.getCityMap().getTiles()[tileX][60 - tileY];
        }
        return tiles[tileX][60 - tileY];
    }

    private void resolvePlayerCollision(Rectangle player, Rectangle obstacle) {
        if (player.x < obstacle.x) {
            // player is to the left of obstacle
            player.x = obstacle.x - player.width;
            x = obstacle.x - player.width;
        } else if (player.x > obstacle.x) {
            // player is to the right of obstacle
            player.x = obstacle.x + obstacle.width;
            x = obstacle.x + obstacle.width;
        }

        if (player.y < obstacle.y) {
            player.y = obstacle.y - player.height;
            y = obstacle.y - player.height;
        } else if (player.y > obstacle.y) {
            player.y = obstacle.y + obstacle.height;
            y = obstacle.y + obstacle.height;
        }
    }

    public ArrayList<Tree> getTrees() {
        return trees;
    }

    public ArrayList<Stone> getStones() {
        return stones;
    }

    private boolean isAnyMenuOpened() {
        return inventoryScreen.isVisible() ||
               skillScreen.isVisible() ||
               hut.isVisible() ||
               shopScreen.isVisible();
    }
}
