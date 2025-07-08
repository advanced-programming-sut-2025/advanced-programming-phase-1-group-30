package AP.group30.StardewValley.models.Items;

import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.Products.ForagingSeedType;
import AP.group30.StardewValley.models.Items.Products.FruitType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Arrays;

public enum ItemTexture {
    WOOD(new Texture(Gdx.files.internal("item/resource/Wood.png"))),

    STONE(new Texture(Gdx.files.internal("item/resource/Stone.png"))),

    APRICOT_TREE(new Texture(Gdx.files.internal("tree/Apricot.png"))),
    CHERRY_TREE(new Texture(Gdx.files.internal("tree/Cherry.png"))),
    BANANA_TREE(new Texture(Gdx.files.internal("tree/Banana.png"))),
    MANGO_TREE(new Texture(Gdx.files.internal("tree/Mango.png"))),
    ORANGE_TREE(new Texture(Gdx.files.internal("tree/Orange.png"))),
    PEACH_TREE(new Texture(Gdx.files.internal("tree/Peach.png"))),
    APPLE_TREE(new Texture(Gdx.files.internal("tree/Apple.png"))),
    POMEGRANATE_TREE(new Texture(Gdx.files.internal("tree/Pomegranate.png"))),
    OAK_TREE(new Texture(Gdx.files.internal("tree/Oak.png"))),
    MAPLE_TREE(new Texture(Gdx.files.internal("tree/Maple.png"))),
    PINE_TREE(new Texture(Gdx.files.internal("tree/Pine.png"))),
    MAHOGANY_TREE(new Texture(Gdx.files.internal("tree/Mahogany.png"))),
    MUSHROOM_TREE(new Texture(Gdx.files.internal("tree/Mushroom.png"))),
    WILD_TREE(new Texture(Gdx.files.internal("tree/Wild.png"))),
    MYSTIC_TREE(new Texture(Gdx.files.internal("tree/Mystic.png"))),

    AXE(GameAssetManager.assetManager.get(GameAssetManager.axe)),
    PICKAXE(GameAssetManager.assetManager.get(GameAssetManager.pickaxe)),
    SCYTHE(GameAssetManager.assetManager.get(GameAssetManager.scythe)),
    HOE(GameAssetManager.assetManager.get(GameAssetManager.hoe)),
    WATERING_CAN(GameAssetManager.assetManager.get(GameAssetManager.wateringCan)),
    TRASH_CAN(GameAssetManager.assetManager.get(GameAssetManager.trashCan)),;

    private final Texture TEXTURE;

    ItemTexture(Texture texture) {
        this.TEXTURE = texture;
    }

    public Texture getTexture() {
        return TEXTURE;
    }
}
