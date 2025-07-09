package AP.group30.StardewValley.models.Maps;

import AP.group30.StardewValley.models.GameAssetManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public enum TileTexture {
    GRASS(GameAssetManager.assetManager.get(GameAssetManager.grass)),
    DIRT(GameAssetManager.assetManager.get(GameAssetManager.dirt)),
    DIRT_2(GameAssetManager.assetManager.get(GameAssetManager.dirt2)),
    DIRT_3(GameAssetManager.assetManager.get(GameAssetManager.dirt3)),
    DIRT_4(GameAssetManager.assetManager.get(GameAssetManager.dirt4)),
    PLANTABLE(GameAssetManager.assetManager.get(GameAssetManager.plantable)),
    RIVER(GameAssetManager.assetManager.get(GameAssetManager.river)),
    LEFT_WALL(GameAssetManager.assetManager.get(GameAssetManager.leftWall)),
    RIGHT_WALL(GameAssetManager.assetManager.get(GameAssetManager.rightWall)),
    UP_WALL(GameAssetManager.assetManager.get(GameAssetManager.upWall)),
    DOWN_WALL(GameAssetManager.assetManager.get(GameAssetManager.downWall)),
    CORNER1_WALL(GameAssetManager.assetManager.get(GameAssetManager.cornerWall1)),
    CORNER2_WALL(GameAssetManager.assetManager.get(GameAssetManager.cornerWall2)),
    OUTDOOR_GRASS1(GameAssetManager.assetManager.get(GameAssetManager.outdoorGrass1)),
    OUTDOOR_GRASS2(GameAssetManager.assetManager.get(GameAssetManager.outdoorGrass2)),
    OUTDOOR_GRASS3(GameAssetManager.assetManager.get(GameAssetManager.outdoorGrass3)),
    OUTDOOR_GRASS4(GameAssetManager.assetManager.get(GameAssetManager.outdoorGrass4));


    private final Texture TEXTURE;

    TileTexture(Texture texture) {
        this.TEXTURE = texture;
    }

    public Texture getTexture() {
        return TEXTURE;
    }
}
