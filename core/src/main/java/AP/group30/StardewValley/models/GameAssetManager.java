package AP.group30.StardewValley.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameAssetManager {
    public static AssetManager assetManager = new AssetManager();
    public static final AssetDescriptor<Texture> background = new AssetDescriptor<>("menu assets/loading screen.png", Texture.class);
    public static final AssetDescriptor<Texture> nightBackground = new AssetDescriptor<>("menu assets/sebastianRideTiles.png", Texture.class);
    public static final AssetDescriptor<Skin> menuSkin = new AssetDescriptor<>("skin/pixthulhu-ui.json", Skin.class);
    public static final AssetDescriptor<Texture> grass = new AssetDescriptor<>("tile/grass.png", Texture.class);
    public static final AssetDescriptor<Texture> dirt = new AssetDescriptor<>("tile/dirt.png", Texture.class);
    public static final AssetDescriptor<Texture> player = new AssetDescriptor<>("Horse_rider.png", Texture.class);
    public static final AssetDescriptor<Texture> house = new AssetDescriptor<>("Hut.png", Texture.class);
    public static final AssetDescriptor<Texture> water = new AssetDescriptor<>("water.png", Texture.class);
    public static final AssetDescriptor<Texture> river = new AssetDescriptor<>("tile/river.png", Texture.class);
    public static final AssetDescriptor<Texture> leftWall = new AssetDescriptor<>("tile/wall/leftWall.png", Texture.class);
    public static final AssetDescriptor<Texture> rightWall = new AssetDescriptor<>("tile/wall/rightWall.png", Texture.class);
    public static final AssetDescriptor<Texture> upWall = new AssetDescriptor<>("tile/wall/upWall.png", Texture.class);
    public static final AssetDescriptor<Texture> downWall = new AssetDescriptor<>("tile/wall/downWall.png", Texture.class);
    public static final AssetDescriptor<Texture> cornerWall1 = new AssetDescriptor<>("tile/wall/corner1Wall.png", Texture.class);
    public static final AssetDescriptor<Texture> cornerWall2 = new AssetDescriptor<>("tile/wall/corner2Wall.png", Texture.class);
    public static final AssetDescriptor<Texture> outdoorGrass1 = new AssetDescriptor<>("tile/wall/outdoorGrass1.png", Texture.class);
    public static final AssetDescriptor<Texture> outdoorGrass2 = new AssetDescriptor<>("tile/wall/outdoorGrass2.png", Texture.class);
    public static final AssetDescriptor<Texture> outdoorGrass3 = new AssetDescriptor<>("tile/wall/outdoorGrass3.png", Texture.class);
    public static final AssetDescriptor<Texture> outdoorGrass4 = new AssetDescriptor<>("tile/wall/outdoorGrass4.png", Texture.class);
    public static final AssetDescriptor<Texture> clock = new AssetDescriptor<>("Stardew_Valley_Images/Clock/Clock.png", Texture.class);
    public static final AssetDescriptor<Texture> tree = new AssetDescriptor<>("tree.png", Texture.class);
    public static final AssetDescriptor<Texture> kaj = new AssetDescriptor<>("tree_kaj.png", Texture.class);
    public static final AssetDescriptor<Texture> stone = new AssetDescriptor<>("stone.png", Texture.class);
    public static final AssetDescriptor<Texture> ruinedGreenhouse = new AssetDescriptor<>("ruined_greenhouse.png", Texture.class);

    public static final AssetDescriptor<Texture> axe = new AssetDescriptor<>("Stardew_Valley_Images/Tools/Axe/Axe.png", Texture.class);
    public static final AssetDescriptor<Texture> pickaxe = new AssetDescriptor<>("Stardew_Valley_Images/Tools/Pickaxe/Pickaxe.png", Texture.class);
    public static final AssetDescriptor<Texture> scythe = new AssetDescriptor<>("Stardew_Valley_Images/Tools/Scythe/Scythe.png", Texture.class);
    public static final AssetDescriptor<Texture> hoe = new AssetDescriptor<>("Stardew_Valley_Images/Tools/Hoe/Hoe.png", Texture.class);
    public static final AssetDescriptor<Texture> wateringCan = new AssetDescriptor<>("Stardew_Valley_Images/Tools/Watering_Can/Watering_Can.png", Texture.class);
    public static final AssetDescriptor<Texture> trashCan = new AssetDescriptor<>("Stardew_Valley_Images/Tools/Trash_Can_Copper.png", Texture.class);

    public static void queueAsset() {
        assetManager.load(background);
        assetManager.load(nightBackground);
        assetManager.load(grass);
        assetManager.load(dirt);
        assetManager.load(player);
        assetManager.load(house);
        assetManager.load(water);
        assetManager.load(tree);
        assetManager.load(kaj);
        assetManager.load(stone);
        assetManager.load(ruinedGreenhouse);
        assetManager.load(menuSkin);
        assetManager.load(river);
        assetManager.load(leftWall);
        assetManager.load(rightWall);
        assetManager.load(upWall);
        assetManager.load(downWall);
        assetManager.load(cornerWall1);
        assetManager.load(cornerWall2);
        assetManager.load(outdoorGrass1);
        assetManager.load(outdoorGrass2);
        assetManager.load(outdoorGrass3);
        assetManager.load(outdoorGrass4);
        assetManager.load(clock);
        assetManager.load(axe);
        assetManager.load(pickaxe);
        assetManager.load(scythe);
        assetManager.load(hoe);
        assetManager.load(wateringCan);
        assetManager.load(trashCan);
    }
}
