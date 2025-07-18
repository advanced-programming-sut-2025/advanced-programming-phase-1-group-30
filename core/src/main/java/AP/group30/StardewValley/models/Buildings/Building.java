package AP.group30.StardewValley.models.Buildings;

import java.util.ArrayList;

import AP.group30.StardewValley.models.GameObjects;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Maps.Map;
import AP.group30.StardewValley.models.Maps.Tile;
import AP.group30.StardewValley.models.Maps.TileTypes;
import AP.group30.StardewValley.models.Players.NPC.Leah;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Building implements GameObjects {

    private int height;
    private int width;
    private int startX;
    private int startY;
    private Rectangle rectangle;
    private TileTypes tileType;

    private final int startHour;
    private final int endHour;
    private Texture texture;

    private ArrayList<Item> items;

    public Building(int height, int width, int startX, int startY, int startHour, int endHour, TileTypes tileType, Texture texture) {
        this.height = height;
        this.width = width;
        this.startX = startX;
        this.startY = startY;
        this.rectangle = new Rectangle(startX * 32, startY * 32, width * 32, height * 32);
        this.tileType = tileType;
        this.startHour = startHour;
        this.endHour = endHour;
        this.texture = texture;

        this.items = new ArrayList<>();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public void addItem(Item item) {
        this.items.add(item);
    }
    public void removeItem(Item item) {
        this.items.remove(item);
    }
    public void removeItems() {
        this.items = new ArrayList<>();
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    @Override
    public int getRenderY() {
        return startY * 32;
    }

    @Override
    public void render(SpriteBatch batch, Map map) {
        int startTIleX = 60;
        int endTIleX = 65;
        int startTIleY = 40;
        int endTIleY = 45;
        Tile[][] tiles1 = map.getTiles();

        for (int i = 0; i < tiles1.length; i++) {
            for (int j = 0; j < tiles1[i].length; j++) {
                Tile tile = tiles1[i][j];
                if (tile.getType() == tileType) {
                    if (tiles1[i-1][j].getType() != tileType) {
                        if (tiles1[i][j+1].getType() != tileType) {
                            startTIleX = i;
                            startTIleY = 60 - j;
                        }
                    }
                    if (tiles1[i+1][j].getType() != tileType) {
                        if (tiles1[i][j-1].getType() != tileType) {
                            endTIleX = i;
                            endTIleY = 60 - j;
                        }
                    }
                }
            }
        }

        batch.draw(texture,
            map.getTiles()[startTIleX - 1][startTIleY + 1].getX() * 32,
            map.getTiles()[startTIleX][startTIleY].getY() * 32,
            (endTIleX - startTIleX + 3) * 32,
            (endTIleY - startTIleY + 4) * 32
        );

    }
}
