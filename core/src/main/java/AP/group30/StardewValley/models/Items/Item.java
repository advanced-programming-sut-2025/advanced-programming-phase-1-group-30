package AP.group30.StardewValley.models.Items;

import java.util.ArrayList;

import AP.group30.StardewValley.models.Items.Products.ShopProducts.ShopProduct;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Item implements ItemsInteface {
    private final String name;
    private int count;
    private String quality;
    private double cof;
    private double price;
    private final Texture texture;

    public Item(int count, String name, double price, Texture texture) {
        this.name = name;
        this.count = count;
        this.cof = 1;
        this.price = price;
        this.texture = texture;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void changeCount(int amount) {
        this.count += amount;
    }

    public String getName() {
        return name;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public void setCof(double cof) {
        this.cof = cof;
    }

    public double getCof() {
        return cof;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Texture getTexture() {
        return texture;
    }

    public static Item findItemByName(String name, ArrayList<Item> items) {
        for (Item item : items) {
            if (item.getName().matches(name)) return item;
        }
        return null;
    }

    public static ShopProduct findShopProductByName(String name, ArrayList<ShopProduct> items) {
        for (ShopProduct item : items) {
            if (item.getName().matches(name)) return item;
        }
        return null;
    }

    public void renderItem(SpriteBatch batch, float x, float y, float tileWidth, float tileHeight) {
        batch.draw(texture, x, y, tileWidth, tileHeight);
    }
}
