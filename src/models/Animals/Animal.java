package models.Animals;

public class Animal {
    private int price;
    private String name;
    private int friendship;
    private boolean fedToday;
    private boolean petToday;
    private boolean productReady;
    private int x;
    private int y;

    public Animal(int price, String name, int friendship, boolean fedToday, boolean petToday, int x, int y) {
        this.price = price;
        this.name = name;
        this.friendship = friendship;
        this.fedToday = fedToday;
        this.petToday = petToday;
        this.productReady = false;
        this.x = x;
        this.y = y;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getFriendship() {
        return friendship;
    }
    public void setFriendship(int friendship) {
        this.friendship = friendship;
    }
    public boolean isFedToday() {
        return fedToday;
    }
    public void setFedToday(boolean fedToday) {
        this.fedToday = fedToday;
    }
    public boolean isPetToday() {
        return petToday;
    }
    public void setPetToday(boolean petToday) {
        this.petToday = petToday;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public boolean isProductReady() {
        return productReady;
    }

    public void setProductReady(boolean productReady) {
        this.productReady = productReady;
    }

    public void produceProduct() {
    }
}
