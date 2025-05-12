package models.Items.Products;


public class AnimalProduct extends Product{
    private final AnimalProductType type;

    public AnimalProduct(int count, AnimalProductType type) {
        super(count, type.getName(), type.getPrice());
        this.type = type;
    }

    public AnimalProductType getType() {
        return type;
    }
}
