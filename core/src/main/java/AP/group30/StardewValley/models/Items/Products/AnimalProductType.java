package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import com.badlogic.gdx.graphics.Texture;

public enum AnimalProductType implements ItemsInteface {
    EGG("egg", 50, ItemTexture.WOOD.getTexture()),
    BIG_EGG("big egg", 95, ItemTexture.WOOD.getTexture()),
    DUCK_EGG("duck egg", 95, ItemTexture.WOOD.getTexture()),
    DUCK_FEATHER("duck feather", 250, ItemTexture.WOOD.getTexture()),
    FLEECE("fleece", 340, ItemTexture.WOOD.getTexture()),
    RABBIT_LEG("rabbit leg", 565, ItemTexture.WOOD.getTexture()),
    RABBIT_WOOL("rabbit wool", 340, ItemTexture.WOOD.getTexture()),
    DINASOUR_EGG("dinasour egg", 350, ItemTexture.WOOD.getTexture()),

    MILK("milk", 125, ItemTexture.WOOD.getTexture()),
    BIG_MILK("big milk", 190, ItemTexture.WOOD.getTexture()),
    GOAT_MILK("goat milk", 225, ItemTexture.WOOD.getTexture()),
    GOAT_BIG_MILK("goat big milk", 345, ItemTexture.WOOD.getTexture()),
    WOOL("wool", 340, ItemTexture.WOOD.getTexture()),
    TRUFFLE("truffle", 625, ItemTexture.WOOD.getTexture());

    private final String name;
    private final int price;
    private final Texture texture;
    private AnimalProductType(String name, int price, Texture texture) {
        this.name = name;
        this.price = price;
        this.texture = texture;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public Texture getTexture() {
        return texture;
    }
}
