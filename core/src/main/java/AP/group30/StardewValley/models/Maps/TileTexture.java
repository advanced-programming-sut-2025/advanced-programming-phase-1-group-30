package AP.group30.StardewValley.models.Maps;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.TimeAndDate.Season;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import javax.swing.*;

public enum TileTexture {
    GRASS(GameAssetManager.assetManager.get(GameAssetManager.grass), GameAssetManager.assetManager.get(GameAssetManager.winterDirt)),
    DIRT(GameAssetManager.assetManager.get(GameAssetManager.dirt), GameAssetManager.assetManager.get(GameAssetManager.winterDirt)),
    DIRT_2(GameAssetManager.assetManager.get(GameAssetManager.dirt2), GameAssetManager.assetManager.get(GameAssetManager.winterDirt2)),
    DIRT_3(GameAssetManager.assetManager.get(GameAssetManager.dirt3), GameAssetManager.assetManager.get(GameAssetManager.winterDirt3)),
    DIRT_4(GameAssetManager.assetManager.get(GameAssetManager.dirt4), GameAssetManager.assetManager.get(GameAssetManager.winterDirt)),
    PLANTABLE(GameAssetManager.assetManager.get(GameAssetManager.plantable), GameAssetManager.assetManager.get(GameAssetManager.plantable)),
    WATERED(GameAssetManager.assetManager.get(GameAssetManager.wateredTile), GameAssetManager.assetManager.get(GameAssetManager.wateredTile)),
    RIVER(GameAssetManager.assetManager.get(GameAssetManager.river), GameAssetManager.assetManager.get(GameAssetManager.river)),
    LEFT_WALL(GameAssetManager.assetManager.get(GameAssetManager.leftWall), GameAssetManager.assetManager.get(GameAssetManager.leftWall)),
    RIGHT_WALL(GameAssetManager.assetManager.get(GameAssetManager.rightWall), GameAssetManager.assetManager.get(GameAssetManager.rightWall)),
    UP_WALL(GameAssetManager.assetManager.get(GameAssetManager.upWall), GameAssetManager.assetManager.get(GameAssetManager.upWall)),
    DOWN_WALL(GameAssetManager.assetManager.get(GameAssetManager.downWall), GameAssetManager.assetManager.get(GameAssetManager.downWall)),
    CORNER1_WALL(GameAssetManager.assetManager.get(GameAssetManager.cornerWall1), GameAssetManager.assetManager.get(GameAssetManager.cornerWall1)),
    CORNER2_WALL(GameAssetManager.assetManager.get(GameAssetManager.cornerWall2), GameAssetManager.assetManager.get(GameAssetManager.cornerWall2)),
    OUTDOOR_GRASS1(GameAssetManager.assetManager.get(GameAssetManager.outdoorGrass1), GameAssetManager.assetManager.get(GameAssetManager.outdoorGrass1)),
    OUTDOOR_GRASS2(GameAssetManager.assetManager.get(GameAssetManager.outdoorGrass2), GameAssetManager.assetManager.get(GameAssetManager.outdoorGrass2)),
    OUTDOOR_GRASS3(GameAssetManager.assetManager.get(GameAssetManager.outdoorGrass3), GameAssetManager.assetManager.get(GameAssetManager.outdoorGrass3)),
    OUTDOOR_GRASS4(GameAssetManager.assetManager.get(GameAssetManager.outdoorGrass4), GameAssetManager.assetManager.get(GameAssetManager.outdoorGrass4)),;


    private final Texture texture;
    private final Texture winterTexture;

    TileTexture(Texture texture, Texture winterTexture) {
        this.texture = texture;
        this.winterTexture = winterTexture;
    }

//    public Texture getTexture() {
//        if (App.getCurrentGame().getCurrentTime().getSeason().equals(Season.WINTER)) {
//            return winterTexture;
//        } else {
//            return texture;
//        }
//    }
    public Texture getTexture() {
        return texture;
    }

    public Texture getWinterTexture() {
        return winterTexture;
    }
}
