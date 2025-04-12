package models.IndustrialProducts;

import java.util.ArrayList;

import models.Item;

public enum IndustrialProductType {
    test("", "", null, "", 0);
    
    private final String name;
    private final String description;
    private final ArrayList<Item> ingredients;
    private final String source;
    private final int sellPrice;

    private IndustrialProductType(String name, String description, ArrayList<Item> ingredients, String source,
            int sellPrice) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.source = source;
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public ArrayList<Item> getIngredients() {
        return ingredients;
    }
    public String getSource() {
        return source;
    }
    public int getSellPrice() {
        return sellPrice;
    }
}
