package models.Products;

public enum FruitType {
    test("test", 0);
    
    private final String name;
    private final int energy;

    private FruitType(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }
    public String getName() {
        return name;
    }
    public int getEnergy() {
        return energy;
    }
}
