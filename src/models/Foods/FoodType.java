package models.Foods;

import java.util.ArrayList;

import models.Item;

public enum FoodType {
    test("", null, 0, "", "", 0);
    
    private final String name;
    private final ArrayList<Item> ingredients;
    private final int energy;
    private final String buff;
    private final String source;
    private final int sellPrice;

    private FoodType(String name, ArrayList<Item> ingredients, int energy, String buff, String source, int sellPrice) {
        this.name = name;
        this.ingredients = ingredients;
        this.energy = energy;
        this.buff = buff;
        this.source = source;
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
    }
    public ArrayList<Item> getIngredients() {
        return ingredients;
    }
    public int getEnergy() {
        return energy;
    }
    public String getBuff() {
        return buff;
    }
    public String getSource() {
        return source;
    }
    public int getSellPrice() {
        return sellPrice;
    }
}
