package models.Products;

public enum ForagingMineralType {
    test("test", "", 0);
    
    private final String name;
    private final String description;
    private final int sellPrice;

    private ForagingMineralType(String name, String description, int sellPrice) {
        this.name = name;
        this.description = description;
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getSellPrice() {
        return sellPrice;
    }
}
