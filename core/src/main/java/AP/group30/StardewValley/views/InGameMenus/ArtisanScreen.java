package AP.group30.StardewValley.views.InGameMenus;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProductType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.ArrayList;

public class ArtisanScreen extends InGameMenuScreen{
    private final TextButton infoButton;

    private final ArrayList<Image> itemImages = new ArrayList<>();
    private Image borderImage;

    private ArrayList<IndustrialProductType> devices = App.getCurrentGame().getCurrentPlayer().getDevices();
    public IndustrialProductType currentDevice = null;

    private final DeviceScreen deviceScreen;
    private final ArtisanScreen artisanScreen;

    public ArtisanScreen(SpriteBatch batch, Skin skin) {
        super(batch, skin, GameAssetManager.refrigerator, 2, 200);

        deviceScreen = new DeviceScreen(batch, skin);
        artisanScreen = this;

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

    public void render() {
        super.render();
        if (visible) deviceScreen.render();
    }

    @Override
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

    @Override
    protected void refresh() {
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

    public Stage getStage() {
        return stage;
    }
}
