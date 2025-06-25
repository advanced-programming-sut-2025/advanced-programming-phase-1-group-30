package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.Items.ItemsInteface;

public enum AnimalProductType implements ItemsInteface {
    EGG("egg", 50),
    BIG_EGG("big egg", 95),
    DUCK_EGG("duck egg", 95),
    DUCK_FEATHER("duck feather", 250),
    FLEECE("fleece", 340),
    RABBIT_LEG("rabbit leg", 565),
    RABBIT_WOOL("rabbit wool", 340),
    DINASOUR_EGG("dinasour egg", 350),

    MILK("milk", 125),
    BIG_MILK("big milk", 190),
    GOAT_MILK("goat milk", 225),
    GOAT_BIG_MILK("goat big milk", 345),
    WOOL("wool", 340),
    TRUFFLE("truffle", 625);

    private final String name;
    private final int price;
    private AnimalProductType(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
}
