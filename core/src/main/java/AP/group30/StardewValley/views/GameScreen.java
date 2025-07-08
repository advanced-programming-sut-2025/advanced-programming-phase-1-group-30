package AP.group30.StardewValley.views;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.GameMenuController;
import AP.group30.StardewValley.models.Game;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.Products.Stone;
import AP.group30.StardewValley.models.Items.Products.Tree;
import AP.group30.StardewValley.models.Maps.Map;
import AP.group30.StardewValley.models.Maps.Tile;
import AP.group30.StardewValley.models.Maps.TileTexture;
import AP.group30.StardewValley.models.Maps.TileTypes;
import AP.group30.StardewValley.models.Players.Direction;
import AP.group30.StardewValley.models.Players.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.ArrayList;
import java.util.Random;

public class GameScreen implements Screen {
    private SpriteBatch batch;

//     private InputProcessor gameInputProcessor;
//     Player player;
//     TextureRegion playerRegion = new TextureRegion(GameAssetManager.assetManager.get("Horse_rider.png", Texture.class));
//     Texture house = GameAssetManager.assetManager.get(GameAssetManager.house);
//     Texture ruinedGreenhouse = GameAssetManager.assetManager.get(GameAssetManager.ruinedGreenhouse);
//     float playerDx = 0, playerDy = 0;
//     Map map = new Map(2);
//     float x = Gdx.graphics.getWidth() / 2f;
//     float y = Gdx.graphics.getHeight() / 2f;
//     OrthographicCamera camera;


//     // *** Game entities ***
     public static ArrayList<Tree> trees = new ArrayList<>();
     public static ArrayList<Stone> stones = new ArrayList<>();

    private OrthographicCamera camera;
    private Game game;
    private Player player;

    private Texture playerTexture;
    private Rectangle playerRect = new Rectangle();
    private Texture house;
    private Texture clock;
    private TextureRegion playerRegion;
    BitmapFont font = (new Skin(Gdx.files.internal("skin/pixthulhu-ui.json")).getFont("font"));


    private final Map map;
    private final Tile[][] tiles;
    private Tile currentTile;


    private int[][] grassMap;
    private final Random random = new Random();

    private float x;
    private float y;
    float speed = 150f;
    private boolean facingLeft = false;

    private InventoryScreen inventoryScreen;

    public GameScreen(Game game) {
        this.game = game;
//         player.setX((int)(Gdx.graphics.getWidth() / 2f));
//         player.setY((int)(Gdx.graphics.getHeight() / 2f));
//     }

        player = game.getCurrentPlayer();
        playerTexture = GameAssetManager.assetManager.get(GameAssetManager.player);
        house = GameAssetManager.assetManager.get(GameAssetManager.house);
        clock = GameAssetManager.assetManager.get(GameAssetManager.clock);
        playerRegion = new TextureRegion(playerTexture);

        map = game.getCurrentPlayer().getMap();
        tiles = map.getTiles();
        for (int i = 0; i < map.getTiles().length; i++) {
            for (int j = 0; j < map.getTiles()[i].length; j++) {
                Tile tile = map.getTiles()[i][j];
                if (tile.getItem() != null) {
                    if (tile.getItem().getClass().equals(Tree.class)) {
                        Tree tree = (Tree) tile.getItem();
                        trees.add(tree);
                    } else if (tile.getItem().getClass().equals(Stone.class)) {
                        Stone stone = (Stone) tile.getItem();
                        stones.add(stone);
                    }
                }
            }
        }

        x = Gdx.graphics.getWidth() + 100;
        y = Gdx.graphics.getHeight() + 450;
        playerRect.setPosition(x, y);
        playerRect.setSize(playerTexture.getWidth() / 2f, playerTexture.getHeight() / 4f);
    }

    @Override
    public void show() {
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        Gdx.input.setInputProcessor(null);
        generateGrassMap();

        inventoryScreen = new InventoryScreen(batch, Main.getMain().skin);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            inventoryScreen.toggle();
        }

        camera.position.set(x + playerRegion.getRegionWidth() / 2f, y + playerRegion.getRegionHeight() / 2f, 0);
        camera.update();

        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        renderBackground();
        renderMap();
        renderWallsAroundMap();
//        renderItems();
        renderTreeAndStone();
        renderHut();
        renderPlayer();
        renderTime();
        batch.end();
        if (!inventoryScreen.isVisible()) {
            handleInput(delta);
            if (Gdx.input.isKeyPressed(Input.Keys.W)) camera.position.y += speed * delta;
            if (Gdx.input.isKeyPressed(Input.Keys.S)) camera.position.y -= speed * delta;
            if (Gdx.input.isKeyPressed(Input.Keys.A)) camera.position.x -= speed * delta;
            if (Gdx.input.isKeyPressed(Input.Keys.D)) camera.position.x += speed * delta;
        }

        inventoryScreen.render();
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

    private void renderPlayer() {
        batch.draw(playerRegion, x, y, playerRegion.getRegionWidth() / 2f, playerRegion.getRegionHeight() / 2f);
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
    }

    private void renderMap() {
        Tile[][] tiles = map.getTiles();
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

    private void renderTreeAndStone() {
        for (Tree tree : trees) {
            batch.draw(tree.getTexture(), tree.getX(), tree.getY(), tree.getWidth(), tree.getHeight());
        }
        for (Stone stone : stones) {
            batch.draw(stone.getTexture(), stone.getX(), stone.getY(), stone.getWidth(), stone.getHeight());
        }
    }

    private void renderTime(){
        batch.draw(clock,camera.position.x + 650, camera.position.y + 300);
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
        playerTexture.dispose();
        house.dispose();
        inventoryScreen.dispose();
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
            if (!facingLeft) {
                flipTexture(true);
                facingLeft = true;
            }
            moved = true;
            player.setDirection(Direction.WEST);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            proposedX += moveAmount;
            if (facingLeft) {
                flipTexture(false);
                facingLeft = false;
            }
            moved = true;
            player.setDirection(Direction.EAST);
        }

        if (moved) {
            Tile tile = getTileUnderPlayer(proposedX, proposedY);
            if (tile.getType().equals(TileTypes.WATER)) {
                return;
            }

            playerRect.setPosition(proposedX, proposedY);

            boolean collides = false;
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
            playerRect.setPosition(x, y);
            player.setX((int)x);
            player.setY((int)y);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.C) || Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            GameMenuController.toolUse(player.getDirection(), (int)x, (int)y, batch);
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

    private void flipTexture(boolean flipX) {
        if (playerRegion.isFlipX() != flipX) {
            playerRegion.flip(true, false);
        }
    }

    private Tile getTileUnderPlayer(float playerX, float playerY) {
        int tileX = (int)(playerX / 32);
        int tileY = (int)(playerY / 32);
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
}
