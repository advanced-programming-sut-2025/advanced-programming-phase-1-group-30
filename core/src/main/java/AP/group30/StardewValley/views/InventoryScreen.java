package AP.group30.StardewValley.views;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Players.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;

public class InventoryScreen {
    private Stage stage;
    private Skin skin;
    private Table table;
    private boolean visible = false;
    private Texture backgroundTexture;
    private SpriteBatch batch;

    private final int positionX = 645;
    private final int positionY = 665;

    private ArrayList<Image> itemImages = new ArrayList<>();

    public InventoryScreen(SpriteBatch batch, Skin skin) {
        this.skin = skin;
        this.stage = new Stage(new ScreenViewport(), batch);
        this.batch = batch;

        backgroundTexture = new Texture(Gdx.files.internal("Inventory.png"));
        Drawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundTexture));

        table = new Table();
        table.setVisible(false);
        table.setBackground(backgroundDrawable);
        table.setSize(800, 600);
        table.setPosition(
            (Gdx.graphics.getWidth() - table.getWidth()) / 2,
            (Gdx.graphics.getHeight() - table.getHeight()) / 2
        );

        Player player = App.getCurrentGame().getCurrentPlayer();

        Label info = new Label(player.getUsername() + " Farm", skin);
        info.setPosition(positionX + 300, positionY - 250);
        Label energy = new Label("Current Energy: " + player.getEnergy(), skin);
        energy.setPosition(positionX + 300, positionY - 300);
        Label money = new Label("Current Money: " + player.getMoney(), skin);
        money.setPosition(positionX + 300, positionY - 350);

        stage.addActor(table);
        stage.addActor(info);
        stage.addActor(energy);
        stage.addActor(money);

        renderItemsInGrid();
    }

    public void show() {
        visible = true;
        table.setVisible(true);
        Gdx.input.setInputProcessor(stage);
    }

    public void hide() {
        visible = false;
        table.setVisible(false);
        Gdx.input.setInputProcessor(null);
    }

    public void toggle() {
        if (visible) hide();
        else show();
    }

    public void render() {
        if (visible) {
            stage.act();
            stage.draw();
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public void dispose() {
        stage.dispose();
        backgroundTexture.dispose();
    }

    private void renderItemsInGrid() {
        int cellSizeX = 53;
        int cellSizeY1 = 67;
        int cellSizeY2 = 62;
        int cols = 12;

        ArrayList<Item> items = App.getCurrentGame().getCurrentPlayer().getBackPack().getItems();

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item != null) {
                int row = i / cols;
                int col = i % cols;

                float x = positionX + col * cellSizeX;
                float y;
                if (i < cols * 2) y = positionY - row * cellSizeY1;
                else y = positionY - row * cellSizeY2;

                Image itemImage = new Image(new TextureRegionDrawable(new TextureRegion(item.getTexture())));
                itemImage.setSize(50, 50);
                itemImage.setPosition(x, y);

                Table tooltipTable = new Table(skin);
                tooltipTable.setBackground(createBackground(new Color(0.4f, 0.25f, 0.1f, 0.9f), 200, 100));

                Label nameLabel = new Label("Name: " + item.getName(), skin);
                Label countLabel = new Label("Count: " + item.getCount(), skin);
                Label priceLabel = new Label("Price: " + item.getPrice(), skin);

                tooltipTable.pad(10);
                tooltipTable.add(nameLabel).left().row();
                tooltipTable.add(countLabel).left().row();
                tooltipTable.add(priceLabel).left();

                Tooltip<Table> tooltip = new Tooltip<>(tooltipTable);
                tooltip.setInstant(true);
                tooltip.setAlways(false);

                itemImage.addListener(tooltip);
                stage.addActor(itemImage);
                itemImages.add(itemImage);
            }
        }
    }

    private Drawable createBackground(Color color, int width, int height) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();

        Texture texture = new Texture(pixmap);
        pixmap.dispose();

        return new TextureRegionDrawable(new TextureRegion(texture));
    }
}

