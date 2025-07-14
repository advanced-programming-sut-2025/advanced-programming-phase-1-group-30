package AP.group30.StardewValley.views.Hut;

import AP.group30.StardewValley.controllers.GameMenuController;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.Item;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;

public class RefrigeratorScreen {
    private final Stage stage;
    private final Skin skin;
    private final Table table1;
    private final Table table2;
    private boolean visible = false;
    private final Texture backgroundTexture;
    private final Texture backgroundItemTexture;

    private TextButton moveButton;

    private final ArrayList<Image> itemImages = new ArrayList<>();
    private ArrayList<Item> backPackItems = App.getCurrentGame().getCurrentPlayer().getBackPack().getItems();
    private ArrayList<Item> refrigeratorItems = App.getCurrentGame().getCurrentPlayer().getRefrigerator().getItems();
    private Item currentItem = null;

    private final Label errorLabel;

    public RefrigeratorScreen(SpriteBatch batch, Skin skin) {
        this.skin = skin;
        this.stage = new Stage(new ScreenViewport(), batch);

        backgroundTexture = GameAssetManager.assetManager.get(GameAssetManager.refrigerator);
        Drawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundTexture));

        backgroundItemTexture = GameAssetManager.assetManager.get(GameAssetManager.inventoryItem);

        table1 = new Table();
        table1.setVisible(false);
        table1.setBackground(backgroundDrawable);
        table1.setSize(800, 300);
        table1.setPosition(
            (Gdx.graphics.getWidth() - table1.getWidth()) / 2f,
            (Gdx.graphics.getHeight() - table1.getHeight()) / 2f + 200
        );

        table2 = new Table();
        table2.setVisible(false);
        table2.setBackground(backgroundDrawable);
        table2.setSize(800, 300);
        table2.setPosition(
            (Gdx.graphics.getWidth() - table2.getWidth()) / 2f,
            (Gdx.graphics.getHeight() - table2.getHeight()) / 2f - 200
        );

        moveButton = new TextButton("Move", skin);
        moveButton.setPosition(table1.getX() + table1.getWidth() / 2f - moveButton.getWidth() / 2f - 50,
            (table1.getY() + table2.getY() + table2.getHeight()) / 2f - moveButton.getHeight() / 2f);
        moveButton.setVisible(false);
        moveButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                handleMove();
            }
        });

        errorLabel = new Label("", skin);
        errorLabel.setColor(Color.RED);
        errorLabel.setPosition(table1.getX() + table1.getWidth() / 2f + 50,
            (table1.getY() + table2.getY() + table2.getHeight()) / 2f);
        errorLabel.setVisible(false);

        stage.addActor(table1);
        stage.addActor(table2);
        stage.addActor(errorLabel);
        stage.addActor(moveButton);

        refresh();
    }

    public void show() {
        refresh();
        visible = true;
        table1.setVisible(true);
        table2.setVisible(true);
        Gdx.input.setInputProcessor(stage);
    }

    public void hide() {
        visible = false;
        table1.setVisible(false);
        table2.setVisible(false);
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
        for (Image img : itemImages) {
            img.remove();
        }
        stage.dispose();
        backgroundTexture.dispose();
        backgroundItemTexture.dispose();
    }

    private void handleMove() {
        if (currentItem == null) return;

        String result = null;
        if (backPackItems.contains(currentItem)) {
            result = GameMenuController.putRefrigerator(currentItem);
        } else if (refrigeratorItems.contains(currentItem)) {
            result = GameMenuController.pickRefrigerator(currentItem);
        }

        if (result != null) {
            errorLabel.setText(result);
            errorLabel.setVisible(true);
        } else {
            errorLabel.setText("");
            errorLabel.setVisible(false);
            currentItem = null;
            moveButton.setVisible(false);
        }

        refresh();
    }

    private void renderItemsInGrid(float posX, float posY, ArrayList<Item> items) {
        int cellSizeX = 60;
        int cellSizeY1 = 78;
        int cellSizeY2 = 73;
        int cols = 12;

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item != null) {
                int row = i / cols;
                int col = i % cols;

                float x = posX + col * cellSizeX;
                float y = (i < cols * 2) ? posY - row * cellSizeY1 : posY - row * cellSizeY2;

                createItemImage(item, x, y);
            }
        }

        for (Image image : itemImages) {
            stage.addActor(image);
        }
    }

    private void createItemImage(Item item, float x, float y) {
        Texture itemTexture = item.getTexture();
        Image itemImage = new Image(new TextureRegionDrawable(new TextureRegion(itemTexture)));
        itemImage.setSize(45, 45);
        itemImage.setPosition(x, y);

        Table tooltipTable = new Table(skin);
        Drawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundItemTexture));
        tooltipTable.setBackground(backgroundDrawable);
        tooltipTable.pad(10);

        tooltipTable.add(new Label("Name: " + item.getName(), skin)).left().row();
        tooltipTable.add(new Label("Count: " + item.getCount(), skin)).left().row();
        if (item.getPrice() != 0) {
            tooltipTable.add(new Label("Price: " + item.getPrice(), skin)).left();
        }

        Tooltip<Table> tooltip = new Tooltip<>(tooltipTable);
        tooltip.setInstant(true);
        tooltip.setAlways(false);
        itemImage.addListener(tooltip);

        itemImage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float xOffset, float yOffset) {
                if (currentItem != item) {
                    currentItem = item;
                } else {
                    currentItem = null;
                }
                moveButton.setVisible(currentItem != null);

                errorLabel.setText("");
                errorLabel.setVisible(false);

                refresh();
            }
        });

        itemImages.add(itemImage);
    }

    private Image createBorderImage(int width, int height, Color color) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(0, 0, 0, 0);
        pixmap.fill();

        pixmap.setColor(color);
        int thickness = 3;
        pixmap.fillRectangle(0, 0, width, thickness);
        pixmap.fillRectangle(0, height - thickness, width, thickness);
        pixmap.fillRectangle(0, 0, thickness, height);
        pixmap.fillRectangle(width - thickness, 0, thickness, height);

        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return new Image(new TextureRegionDrawable(new TextureRegion(texture)));
    }

    private void refresh() {
        for (Image img : itemImages) {
            img.remove();
        }
        itemImages.clear();

        backPackItems = App.getCurrentGame().getCurrentPlayer().getBackPack().getItems();
        refrigeratorItems = App.getCurrentGame().getCurrentPlayer().getRefrigerator().getItems();

        renderItemsInGrid(table1.getX() + 50, table1.getY() + table1.getHeight() - 100, backPackItems);
        renderItemsInGrid(table2.getX() + 50, table2.getY() + table2.getHeight() - 100, refrigeratorItems);
    }
}

