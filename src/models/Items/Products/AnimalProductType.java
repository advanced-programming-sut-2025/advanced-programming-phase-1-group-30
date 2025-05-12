package models.Items.Products;

public enum AnimalProductType {
    EGG("Egg", 50),
    BIG_EGG("Big Egg", 95),
    DUCK_EGG("Duck Egg", 95),
    DUCK_FEATHER("Duck Feather", 250),
    FLEECE("Fleece", 340),
    RABBIT_LEG("Rabbit Leg", 565),
    RABBIT_WOOL("Rabbit Wool", 340),
    DINASOUR_EGG("Dinasour Egg", 350),

    MILK("Milk", 125),
    BIG_MILK("Big Milk", 190),
    GOAT_MILK("Goat Milk", 225),
    GOAT_BIG_MILK("Goat Big Milk", 345),
    WOOL("Wool", 340),
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
