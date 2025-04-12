package models.ArtisanGoods;

import java.util.ArrayList;

import models.Item;

public enum ArtisanGoodType {
    test("", "", 0, 0, null, 0);

    private final String name;
	private final String description;
	private final int energy;
    private final int processingTime;
    private final ArrayList<Item> ingredients;
    private final int sellPrice;

    private ArtisanGoodType(String name, String description, int energy, int processingTime,
            ArrayList<Item> ingredients, int sellPrice) {
        this.name = name;
        this.description = description;
        this.energy = energy;
        this.processingTime = processingTime;
        this.ingredients = ingredients;
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getEnergy() {
        return energy;
    }
    public int getProcessingTime() {
        return processingTime;
    }
    public ArrayList<Item> getIngredients() {
        return ingredients;
    }
    public int getSellPrice() {
        return sellPrice;
    }
}
