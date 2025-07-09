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

    WOOD(GameAssetManager.assetManager.get(GameAssetManager.wood)),
    STONE(GameAssetManager.assetManager.get(GameAssetManager.stones)),

    APRICOT_TREE(GameAssetManager.assetManager.get(GameAssetManager.apricot_tree)),
    CHERRY_TREE(GameAssetManager.assetManager.get(GameAssetManager.cherry_tree)),
    BANANA_TREE(GameAssetManager.assetManager.get(GameAssetManager.banana_tree)),
    MANGO_TREE(GameAssetManager.assetManager.get(GameAssetManager.mango_tree)),
    ORANGE_TREE(GameAssetManager.assetManager.get(GameAssetManager.orange_tree)),
    PEACH_TREE(GameAssetManager.assetManager.get(GameAssetManager.peach_tree)),
    APPLE_TREE(GameAssetManager.assetManager.get(GameAssetManager.apple_tree)),
    POMEGRANATE_TREE(GameAssetManager.assetManager.get(GameAssetManager.pomegranate_tree)),
    OAK_TREE(GameAssetManager.assetManager.get(GameAssetManager.oak_tree)),
    MAPLE_TREE(GameAssetManager.assetManager.get(GameAssetManager.maple_tree)),
    PINE_TREE(GameAssetManager.assetManager.get(GameAssetManager.pine_tree)),
    MAHOGANY_TREE(GameAssetManager.assetManager.get(GameAssetManager.mahogany_tree)),
    MUSHROOM_TREE(GameAssetManager.assetManager.get(GameAssetManager.mushroom_tree)),
    TREE(GameAssetManager.assetManager.get(GameAssetManager.tree)),
    WILD_TREE(GameAssetManager.assetManager.get(GameAssetManager.wild_tree)),
    MYSTIC_TREE(GameAssetManager.assetManager.get(GameAssetManager.mystic_tree)),

    AXE(GameAssetManager.assetManager.get(GameAssetManager.axe)),
    PICKAXE(GameAssetManager.assetManager.get(GameAssetManager.pickaxe)),
    SCYTHE(GameAssetManager.assetManager.get(GameAssetManager.scythe)),
    HOE(GameAssetManager.assetManager.get(GameAssetManager.hoe)),
    WATERING_CAN(GameAssetManager.assetManager.get(GameAssetManager.wateringCan)),
    TRASH_CAN(GameAssetManager.assetManager.get(GameAssetManager.trashCan)),

    FARMING_ICON(GameAssetManager.assetManager.get(GameAssetManager.farmingIcon)),
    FISHING_ICON(GameAssetManager.assetManager.get(GameAssetManager.fishingIcon)),
    FORAGING_ICON(GameAssetManager.assetManager.get(GameAssetManager.foragingIcon)),
    MINING_ICON(GameAssetManager.assetManager.get(GameAssetManager.miningIcon)),

    PLAYER_INFO(GameAssetManager.assetManager.get(GameAssetManager.playerInfo)),
    TAPPER_ICON(GameAssetManager.assetManager.get(GameAssetManager.tapperIcon)),;

    private final Texture TEXTURE;

    ItemTexture(Texture texture) {
        this.TEXTURE = texture;
    }

    public Texture getTexture() {
        return TEXTURE;
    }
}
