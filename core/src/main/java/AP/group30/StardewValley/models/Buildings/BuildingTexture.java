package AP.group30.StardewValley.models.Buildings;

import AP.group30.StardewValley.models.GameAssetManager;
import com.badlogic.gdx.graphics.Texture;

public enum BuildingTexture {
    CARPENTER(GameAssetManager.assetManager.get(GameAssetManager.carpenter)),
    RANCH(GameAssetManager.assetManager.get(GameAssetManager.ranch)),
    SALOON(GameAssetManager.assetManager.get(GameAssetManager.saloon)),
    BLACKSMITH(GameAssetManager.assetManager.get(GameAssetManager.blacksmith)),
    PIERRES(GameAssetManager.assetManager.get(GameAssetManager.pierres)),
    JOJA(GameAssetManager.assetManager.get(GameAssetManager.jojamart)),
    FISH_SHOP(GameAssetManager.assetManager.get(GameAssetManager.fishShop)),
    BARN(GameAssetManager.assetManager.get(GameAssetManager.barn)),
    BIG_BARN(GameAssetManager.assetManager.get(GameAssetManager.bigBarn)),
    DELUXE_BARN(GameAssetManager.assetManager.get(GameAssetManager.deluxeBarn)),
    COOP(GameAssetManager.assetManager.get(GameAssetManager.coop)),
    BIG_COOP(GameAssetManager.assetManager.get(GameAssetManager.bigCoop)),
    DELUXE_COOP(GameAssetManager.assetManager.get(GameAssetManager.deluxeCoop));

    private final Texture texture;

    BuildingTexture(Texture texture) {
        this.texture = texture;
    }

    public Texture getTexture() {
        return texture;
    }
}
