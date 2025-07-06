package AP.group30.StardewValley.views;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Game;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Maps.Map;
import AP.group30.StardewValley.models.Maps.Tile;
import AP.group30.StardewValley.models.Maps.TileTexture;
import AP.group30.StardewValley.models.Maps.TileTypes;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.models.Users.RegisterQuestions;
import AP.group30.StardewValley.models.Users.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

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
//     float speed = 150f;
//     boolean facingLeft = false;
//     OrthographicCamera camera;


//     // *** Game entities ***
//     private ArrayList<Tree> trees = new ArrayList<>();
//     private ArrayList<Stone> stones = new ArrayList<>();

    private OrthographicCamera camera;
    private Game game;

    private Texture player;
    private Texture house;
    private Texture clock;
    private TextureRegion playerRegion;


    private final Map map;
    private final Tile[][] tiles;
    private Tile currentTile;


    private int[][] grassMap;
    private final Random random = new Random();

    private float x;
    private float y;
    private boolean facingLeft = false;

    public GameScreen() {

//         for (int i = 0; i < map.getTiles().length; i++) {
//             for (int j = 0; j < map.getTiles()[i].length; j++) {
//                 Tile tile = map.getTiles()[i][j];
//                 if (tile.getItem() != null) {
//                     if (tile.getItem().getClass().equals(Tree.class)) {
//                         Tree tree = (Tree) tile.getItem();
//                         trees.add(tree);
//                     } else if (tile.getItem().getClass().equals(Stone.class)) {
//                         Stone stone = (Stone) tile.getItem();
//                         stones.add(stone);
//                     }
//                 }
//             }
//         }
//         player.setX((int)(Gdx.graphics.getWidth() / 2f));
//         player.setY((int)(Gdx.graphics.getHeight() / 2f));
//     }

        game = new Game();
        player = new Texture(Gdx.files.internal("Horse_rider.png"));
        house = new Texture(Gdx.files.internal("Hut.png"));
        clock = new Texture(Gdx.files.internal("Stardew_Valley_Images/Clock/Clock.png"));
        playerRegion = new TextureRegion(player);


        map = new Map(1);
        tiles = map.getTiles();

        x = Gdx.graphics.getWidth() / 2f;
        y = Gdx.graphics.getHeight() / 2f;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        Gdx.input.setInputProcessor(null);
        generateGrassMap();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        handleInput(delta);
        if (Gdx.input.isKeyPressed(Input.Keys.W) && y >= 18 * 32 && y <= 48 * 32) camera.position.y += speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.S) && y < 48 * 32 && y >= 18 * 32) camera.position.y -= speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.A) && (player.getX() >= 26 * 32 && player.getX() <= 54 * 32)) camera.position.x -= speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.D) && player.getX() < 54 * 32 && player.getX() >= 26 * 32) camera.position.x += speed * delta;


        handleInput(delta);

        camera.position.set(x + playerRegion.getRegionWidth() / 2f, y + playerRegion.getRegionHeight() / 2f, 0);
        camera.update();

        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        renderBackground();
        renderMap();
        renderWallsAroundMap();
        renderItems();
        renderHut();
        renderPlayer();
        renderTime();
        batch.end();

        currentTile = getTileUnderPlayer(x, y);
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
        batch.draw(playerRegion, x, y);
    }

    private void renderWallsAroundMap() {
        int tileSize = 32;
        int mapWidth = tiles.length;
        int mapHeight = tiles[0].length;

        for (int i = 0; i < mapWidth; i++) {
            batch.draw(TileTexture.DOWN_WALL.getTexture(), i * tileSize, 0, tileSize, tileSize);
            batch.draw(TileTexture.UP_WALL.getTexture(), i * tileSize, (mapHeight + 1) * tileSize, tileSize, (tileSize * 3));
        }

//         batch.draw(playerRegion, player.getX(), y, playerRegion.getRegionWidth() / 1.5f, playerRegion.getRegionHeight() / 1.5f);
//         batch.end();

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

    private void renderTime(){
        batch.draw(clock,camera.position.x + 650, camera.position.y + 300);
        BitmapFont font = (new Skin(Gdx.files.internal("skin/pixthulhu-ui.json")).getFont("font"));
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
        player.dispose();
        house.dispose();
    }

    private void handleInput(float delta) {
        float nextX = x;
        float nextY = y;
        float speed = 150f;
        float moveAmount = speed * delta;
        float changeX = 0f;
        float changeY = 0f;

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            nextY += moveAmount;
            changeY = player.getHeight();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            nextY -= moveAmount;
        }
//         if (Gdx.input.isKeyPressed(Input.Keys.A) && player.getX() >= 0) {

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {

            if (!facingLeft) {
                flipTexture(true);
                facingLeft = true;
            }
//             player.setX((int)(player.getX() - speed * delta));
            nextX -= moveAmount;

        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            if (facingLeft) {
                flipTexture(false);
                facingLeft = false;
            }
//             player.setX((int)(player.getX() + speed * delta));
            nextX += moveAmount;
            changeX = player.getWidth();
        }

        if (isWalkableTile(nextX, nextY, changeX, changeY)) {
            x = nextX;
            y = nextY;
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
        return tiles[tileX][tileY];
    }

//    private void resolvePlayerCollision(Rectangle player, Rectangle obstacle) {
//        if (player.x < obstacle.x) {
//            // player is to the left of obstacle
//            player.x = obstacle.x - player.width;
//        } else if (player.x > obstacle.x) {
//            // player is to the right of obstacle
//            player.x = obstacle.x + obstacle.width;
//        }
//
//        if (player.y < obstacle.y) {
//            player.y = obstacle.y - player.height;
//        } else if (player.y > obstacle.y) {
//            player.y = obstacle.y + obstacle.height;
//        }
//    }

}
