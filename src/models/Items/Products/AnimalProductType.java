package models.Items.Products;

public enum AnimalProductType {
    EGG("Egg", 50),
    DUCK_EGG("Duck Egg", 95),
    DUCK_FEATHER("Duck Feather", 250),
    FLEECE("Fleece", 340),
    RABBIT_LEG("Rabbit Leg", 565),
    DINASOUR_EGG("Dinasour Egg", 350),

    MILK("Milk", 125),
    GOAT_MILK("Goat Milk", 225),
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
