package models;

public class Animal {
    private int price;
    private String name;
    private int friendship;

    public Animal(int price, String name, int friendship) {
        this.price = price;
        this.name = name;
        this.friendship = friendship;
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
}
