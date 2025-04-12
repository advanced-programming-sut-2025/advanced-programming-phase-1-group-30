package models.Products;

public enum AnimalProductType {
    test("", 0);
    
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
