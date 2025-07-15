package AP.group30.StardewValley.views.InGameMenus;

import AP.group30.StardewValley.controllers.GameMenuController;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.Foods.FoodType;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProductType;
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
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;

public class ArtisanScreen {
    private final Stage stage;
    private final Skin skin;
    private final Table table;
    private boolean visible = false;
    private final Texture backgroundTexture;
    private final Texture backgroundItemTexture;

    private TextButton infoButton;

    private final ArrayList<Image> itemImages = new ArrayList<>();
    private Image borderImage;

    private ArrayList<IndustrialProductType> devices = App.getCurrentGame().getCurrentPlayer().getDevices();
    public IndustrialProductType currentDevice = null;

    private DeviceScreen deviceScreen;
    private ArtisanScreen artisanScreen;

    public ArtisanScreen(SpriteBatch batch, Skin skin) {
        this.skin = skin;
        this.stage = new Stage(new ScreenViewport(), batch);

        backgroundTexture = GameAssetManager.assetManager.get(GameAssetManager.refrigerator);
        Drawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundTexture));

        backgroundItemTexture = GameAssetManager.assetManager.get(GameAssetManager.inventoryItem);
        deviceScreen = new DeviceScreen(batch, skin);
        artisanScreen = this;

        table = new Table();
        table.setVisible(false);
        table.setBackground(backgroundDrawable);
        table.setSize(800, 300);
        table.setPosition(
            (Gdx.graphics.getWidth() - table.getWidth()) / 2f,
            (Gdx.graphics.getHeight() - table.getHeight()) / 2f + 200
        );

        infoButton = new TextButton("Products", skin);
        infoButton.setPosition(table.getX() + table.getWidth() / 2f - infoButton.getWidth() / 2f - 50,
            table.getY() - infoButton.getHeight());
        infoButton.setVisible(false);
        infoButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                deviceScreen.show(currentDevice, artisanScreen);
            }
        });

        stage.addActor(table);
        stage.addActor(infoButton);

        refresh();
    }

    public void show() {
        refresh();
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

            deviceScreen.render();
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public void dispose() {
        for (Image img : itemImages) {
            img.remove();
        }
        if (borderImage != null) borderImage.remove();
        stage.dispose();
        backgroundTexture.dispose();
        backgroundItemTexture.dispose();
        deviceScreen.dispose();
    }

    private void renderItemsInGrid(float posX, float posY) {
        int cellSizeX = 60;
        int cellSizeY1 = 78;
        int cellSizeY2 = 73;
        int cols = 12;

        for (int i = 0; i < devices.size(); i++) {
            IndustrialProductType device = devices.get(i);
            if (device != null) {
                int row = i / cols;
                int col = i % cols;

                float x = posX + col * cellSizeX;
                float y = (i < cols * 2) ? posY - row * cellSizeY1 : posY - row * cellSizeY2;

                createItemImage(device, x, y);
            }
        }

        if (currentDevice != null && borderImage != null) stage.addActor(borderImage);
        for (Image image : itemImages) {
            stage.addActor(image);
        }
    }

    private void createItemImage(IndustrialProductType device, float x, float y) {
        Texture itemTexture = device.getTexture();
        Image itemImage = new Image(new TextureRegionDrawable(new TextureRegion(itemTexture)));
        itemImage.setSize(45, 45);
        itemImage.setPosition(x, y);

        if (device == currentDevice) {
            borderImage = createBorderImage(50, 52, Color.BLUE);
            borderImage.setPosition(x - 5, y - 5);
        }

        Table tooltipTable = new Table(skin);
        Drawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundItemTexture));
        tooltipTable.setBackground(backgroundDrawable);
        tooltipTable.pad(10);

        tooltipTable.add(new Label("Name: " + device.getName(), skin)).left().row();
        tooltipTable.add(new Label("Description: " + device.getDescription(), skin)).left().row();

        Tooltip<Table> tooltip = new Tooltip<>(tooltipTable);
        tooltip.setInstant(true);
        tooltip.setAlways(false);
        itemImage.addListener(tooltip);

        itemImage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float xOffset, float yOffset) {
                if (currentDevice != device) {
                    currentDevice = device;
                } else {
                    currentDevice = null;
                }
                infoButton.setVisible(currentDevice != null);

                refresh();
            }
        });

        itemImages.add(itemImage);
    }

    private void refresh() {
        for (Image img : itemImages) {
            img.remove();
        }
        itemImages.clear();
        if (borderImage != null) {
            borderImage.remove();
            borderImage = null;
        }

        devices = App.getCurrentGame().getCurrentPlayer().getDevices();

        renderItemsInGrid(table.getX() + 50, table.getY() + table.getHeight() - 100);
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

        Image border = new Image(new TextureRegionDrawable(new TextureRegion(texture)));
        border.addListener(new ActorGestureListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                texture.dispose();
            }
        });

        return border;
    }


    private String ingredients(FoodType recipe) {
        ArrayList<Item> ingredients = recipe.getIngredients();
        StringBuilder ingredientsText = new StringBuilder();

        for (Item ingredient : ingredients) {
            if (ingredients.getLast().equals(ingredient))
                ingredientsText.append(ingredient.getName() + " (x" + ingredient.getCount() + ")");
            else
                ingredientsText.append(ingredient.getName() + " (x" + ingredient.getCount() + ")\n");
        }

        return ingredientsText.toString();
    }

    public Stage getStage() {
        return stage;
    }
}
