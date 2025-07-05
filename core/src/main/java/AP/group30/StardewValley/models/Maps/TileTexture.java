package AP.group30.StardewValley.models.Maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public enum TileTexture {
    GRASS(new Texture(Gdx.files.internal("tile/grass.png"))),
    DIRT(new Texture(Gdx.files.internal("tile/dirt.png"))),
    RIVER(new Texture(Gdx.files.internal("tile/river.png"))),
    LEFT_WALL(new Texture(Gdx.files.internal("tile/wall/leftWall.png"))),
    RIGHT_WALL(new Texture(Gdx.files.internal("tile/wall/rightWall.png"))),
    UP_WALL(new Texture(Gdx.files.internal("tile/wall/upWall.png"))),
    DOWN_WALL(new Texture(Gdx.files.internal("tile/wall/downWall.png"))),
    CORNER1_WALL(new Texture(Gdx.files.internal("tile/wall/corner1Wall.png"))),
    CORNER2_WALL(new Texture(Gdx.files.internal("tile/wall/corner2Wall.png"))),
    OUTDOOR_GRASS1(new Texture(Gdx.files.internal("tile/wall/outdoorGrass1.png"))),
    OUTDOOR_GRASS2(new Texture(Gdx.files.internal("tile/wall/outdoorGrass2.png"))),
    OUTDOOR_GRASS3(new Texture(Gdx.files.internal("tile/wall/outdoorGrass3.png"))),
    OUTDOOR_GRASS4(new Texture(Gdx.files.internal("tile/wall/outdoorGrass4.png"))),;


    private final Texture TEXTURE;

    TileTexture(Texture texture) {
        this.TEXTURE = texture;
    }

    public Texture getTexture() {
        return TEXTURE;
    }
}
