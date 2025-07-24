package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameObjects;
import AP.group30.StardewValley.models.Maps.Map;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Tree extends Product implements GameObjects {
    private final TreeType type;
    private boolean isHitByThunder;
    private Texture texture;
    private Texture summerTexture;
    private Texture springTexture;
    private Texture fallTexture;
    private Texture winterTexture;
    private float width, height;
    private Rectangle rect = new Rectangle();
    private int x, y;

    public Tree(int count, TreeType type, int x, int y) {
        super(count, type.getName(), 0, type.getTexture());
        this.type = type;
        this.isHitByThunder = false;
        this.springTexture = type.getSpringTexture();
        this.fallTexture = type.getFallTexture();
        this.winterTexture = type.getWinterTexture();
        this.summerTexture = type.getSummerTexture();
        width = 90;
        height = 160;
        this.x = x;
        this.y = y;
        rect.x = x + width / 4;
        rect.y = y;
        rect.width = (int)width / 2f;
        rect.height = (int)height / 2f;
    }

    public TreeType getType() {
        return type;
    }

    public boolean isHitByThunder() {
        return isHitByThunder;
    }

    public void HitByThunder() {
        this.isHitByThunder = true;
    }

    public Texture getTexture() {
        return texture;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Rectangle getRect() {
        return rect;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRenderY() {
        return y;
    }

    @Override
    public void render(SpriteBatch batch, Map map) {
        switch (App.getCurrentGame().getCurrentTime().getSeason()) {
            case SPRING -> batch.draw(springTexture, x, y, width, height);
            case SUMMER -> batch.draw(summerTexture, x, y, width, height);
            case FALL -> batch.draw(fallTexture, x, y, width, height);
            case WINTER -> batch.draw(winterTexture, x, y, width, height);
        }
    }
}
