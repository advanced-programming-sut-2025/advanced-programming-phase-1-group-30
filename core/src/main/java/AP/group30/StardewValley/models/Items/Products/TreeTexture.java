package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.GameAssetManager;
import com.badlogic.gdx.graphics.Texture;

public enum TreeTexture {
    APRICOT_TREE(GameAssetManager.assetManager.get(GameAssetManager.apricot_tree), GameAssetManager.assetManager.get(GameAssetManager.apricot_tree),
        GameAssetManager.assetManager.get(GameAssetManager.apricot_tree), GameAssetManager.assetManager.get(GameAssetManager.apricot_tree)),
    CHERRY_TREE(GameAssetManager.assetManager.get(GameAssetManager.cherry_tree), GameAssetManager.assetManager.get(GameAssetManager.cherry_tree),
        GameAssetManager.assetManager.get(GameAssetManager.cherry_tree), GameAssetManager.assetManager.get(GameAssetManager.cherry_tree)),
    BANANA_TREE(GameAssetManager.assetManager.get(GameAssetManager.banana_tree), GameAssetManager.assetManager.get(GameAssetManager.banana_tree),
        GameAssetManager.assetManager.get(GameAssetManager.banana_tree), GameAssetManager.assetManager.get(GameAssetManager.banana_tree)),
    MANGO_TREE(GameAssetManager.assetManager.get(GameAssetManager.mango_tree), GameAssetManager.assetManager.get(GameAssetManager.mango_tree),
        GameAssetManager.assetManager.get(GameAssetManager.mango_tree), GameAssetManager.assetManager.get(GameAssetManager.mango_tree)),
    ORANGE_TREE(GameAssetManager.assetManager.get(GameAssetManager.orange_tree), GameAssetManager.assetManager.get(GameAssetManager.orange_tree),
        GameAssetManager.assetManager.get(GameAssetManager.orange_tree), GameAssetManager.assetManager.get(GameAssetManager.orange_tree)),
    PEACH_TREE(GameAssetManager.assetManager.get(GameAssetManager.peach_tree), GameAssetManager.assetManager.get(GameAssetManager.peach_tree),
        GameAssetManager.assetManager.get(GameAssetManager.peach_tree), GameAssetManager.assetManager.get(GameAssetManager.peach_tree)),
    APPLE_TREE(GameAssetManager.assetManager.get(GameAssetManager.apple_tree), GameAssetManager.assetManager.get(GameAssetManager.apple_tree),
        GameAssetManager.assetManager.get(GameAssetManager.apple_tree), GameAssetManager.assetManager.get(GameAssetManager.apple_tree)),
    POMEGRANATE_TREE(GameAssetManager.assetManager.get(GameAssetManager.pomegranate_tree), GameAssetManager.assetManager.get(GameAssetManager.pomegranate_tree),
        GameAssetManager.assetManager.get(GameAssetManager.pomegranate_tree), GameAssetManager.assetManager.get(GameAssetManager.pomegranate_tree)),
    OAK_TREE(GameAssetManager.assetManager.get(GameAssetManager.tree10), GameAssetManager.assetManager.get(GameAssetManager.tree11),
        GameAssetManager.assetManager.get(GameAssetManager.tree12), GameAssetManager.assetManager.get(GameAssetManager.tree13)),
    MAPLE_TREE(GameAssetManager.assetManager.get(GameAssetManager.tree10), GameAssetManager.assetManager.get(GameAssetManager.tree11),
        GameAssetManager.assetManager.get(GameAssetManager.tree12), GameAssetManager.assetManager.get(GameAssetManager.tree13)),
    PINE_TREE(GameAssetManager.assetManager.get(GameAssetManager.tree20), GameAssetManager.assetManager.get(GameAssetManager.tree21),
        GameAssetManager.assetManager.get(GameAssetManager.tree22), GameAssetManager.assetManager.get(GameAssetManager.tree23)),
    MAHOGANY_TREE(GameAssetManager.assetManager.get(GameAssetManager.mahogany_tree), GameAssetManager.assetManager.get(GameAssetManager.mahogany_tree),
        GameAssetManager.assetManager.get(GameAssetManager.mahogany_tree), GameAssetManager.assetManager.get(GameAssetManager.mahogany_tree)),
    MUSHROOM_TREE(GameAssetManager.assetManager.get(GameAssetManager.mushroom_tree), GameAssetManager.assetManager.get(GameAssetManager.mushroom_tree),
        GameAssetManager.assetManager.get(GameAssetManager.mushroom_tree), GameAssetManager.assetManager.get(GameAssetManager.mushroom_tree)),
    TREE(GameAssetManager.assetManager.get(GameAssetManager.tree00), GameAssetManager.assetManager.get(GameAssetManager.tree01),
        GameAssetManager.assetManager.get(GameAssetManager.tree02), GameAssetManager.assetManager.get(GameAssetManager.tree03)),
    WILD_TREE(GameAssetManager.assetManager.get(GameAssetManager.wild_tree), GameAssetManager.assetManager.get(GameAssetManager.wild_tree),
        GameAssetManager.assetManager.get(GameAssetManager.wild_tree), GameAssetManager.assetManager.get(GameAssetManager.wild_tree)),
    MYSTIC_TREE(GameAssetManager.assetManager.get(GameAssetManager.mystic_tree), GameAssetManager.assetManager.get(GameAssetManager.mystic_tree),
        GameAssetManager.assetManager.get(GameAssetManager.mystic_tree), GameAssetManager.assetManager.get(GameAssetManager.mystic_tree));


    private final Texture springTexture;
    private final Texture summerTexture;
    private final Texture fallTexture;
    private final Texture winterTexture;

    TreeTexture(Texture springTexture, Texture summerTexture, Texture fallTexture, Texture winterTexture ) {
        this.springTexture = springTexture;
        this.summerTexture = summerTexture;
        this.fallTexture = fallTexture;
        this.winterTexture = winterTexture;
    }

    public Texture getSpringTexture() {
        return springTexture;
    }

    public Texture getSummerTexture() {
        return summerTexture;
    }

    public Texture getFallTexture() {
        return fallTexture;
    }

    public Texture getWinterTexture() {
        return winterTexture;
    }
}
