package AP.group30.StardewValley.views.InGameMenus;

import AP.group30.StardewValley.controllers.GameMenuController;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.ArtisanGoods.ArtisanGoodType;
import AP.group30.StardewValley.models.Items.ArtisanGoods.ArtisanItemProsses;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProductType;
import AP.group30.StardewValley.models.Items.Item;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;

public class DeviceScreen {
    private final Stage stage;
    private final Skin skin;
    private final Table table;
    private boolean visible = false;
    private final Texture backgroundTexture;
    private final Texture backgroundItemTexture;

    private final int positionX = 645;
    private final int positionY = 670;

    private final ArrayList<Image> itemImages = new ArrayList<>();
    private Image borderImage;
    private TextButton makeButton;
    private TextButton exitButton;
    private TextButton claimButton;

    private final ArrayList<ArtisanGoodType> items = new ArrayList<>();
    private ArtisanGoodType currentItem;

    private final Label errorLabel;
    private final Label infoLabel;
    private IndustrialProductType device;
    private ArtisanScreen artisanScreen;

    private boolean itemInProses;
    private ArtisanItemProsses artisanGood;
    private Texture prosesBar;
    private final ShapeRenderer shapeRenderer = new ShapeRenderer();
    private Label itemLabel;

    public DeviceScreen(SpriteBatch batch, Skin skin) {
        this.skin = skin;
        this.stage = new Stage(new ScreenViewport(), batch);

        backgroundTexture = GameAssetManager.assetManager.get(GameAssetManager.inventoryScreen);
        Drawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundTexture));
        prosesBar = GameAssetManager.assetManager.get(GameAssetManager.energyBar);

        backgroundItemTexture = GameAssetManager.assetManager.get(GameAssetManager.inventoryItem);

        table = new Table();
        table.setVisible(false);
        table.setBackground(backgroundDrawable);
        table.setSize(800, 600);
        table.setPosition(
            (Gdx.graphics.getWidth() - table.getWidth()) / 2,
            (Gdx.graphics.getHeight() - table.getHeight()) / 2
        );

        errorLabel = new Label("", skin);
        errorLabel.setColor(Color.RED);
        errorLabel.setPosition(positionX + 350, positionY - 400);
        errorLabel.setVisible(false);

        infoLabel = new Label("Ingredients:", skin);
        infoLabel.setPosition(positionX + 250, positionY - 250);

        makeButton = new TextButton("Cook", skin);
        makeButton.setPosition(table.getX() + table.getWidth() / 2f - makeButton.getWidth() / 2f + 100,
            table.getY() - makeButton.getHeight());
        makeButton.setVisible(false);
        makeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                handleMove();
            }
        });

        claimButton = new TextButton("Claim", skin);
        claimButton.setPosition(table.getX() + table.getWidth() / 2f - claimButton.getWidth() / 2f + 100,
            table.getY() - claimButton.getHeight());
        claimButton.setVisible(false);
        claimButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                claim();
            }
        });

        exitButton = new TextButton("Exit", skin);
        exitButton.setPosition(table.getX() + table.getWidth() / 2f - exitButton.getWidth() / 2f - 100,
            table.getY() - exitButton.getHeight());
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hide();
            }
        });

        itemLabel = new Label("", skin);
        itemLabel.setVisible(false);

        stage.addActor(table);
        stage.addActor(infoLabel);
        stage.addActor(errorLabel);
        stage.addActor(makeButton);
        stage.addActor(exitButton);
        stage.addActor(claimButton);
        stage.addActor(itemLabel);

        renderItemsInGrid();
    }

    private void claim() {
        GameMenuController.artisanGet(artisanGood);
        show(device, artisanScreen);
    }

    public void show(IndustrialProductType type, ArtisanScreen screen) {
        device = type;
        artisanScreen = screen;
        itemInProses = false;

        currentItem = null;
        artisanGood = null;
        itemLabel.setVisible(false);
        claimButton.setVisible(false);
        makeButton.setVisible(false);

        infoLabel.setText("Ingredients:");
        infoLabel.setVisible(true);
        errorLabel.setText("");
        errorLabel.setVisible(false);

        findArtisanGoods(type);
        for (ArtisanItemProsses artisanItemProsses : App.getCurrentGame().getCurrentPlayer().getArtisanItemsProsses()) {
            if (items.contains(artisanItemProsses.getArtisanGood().getType())) {
                itemInProses = true;
                artisanGood = artisanItemProsses;
                break;
            }
        }

        if (itemInProses) infoLabel.setVisible(false);

        refresh();

        visible = true;
        table.setVisible(true);
        Gdx.input.setInputProcessor(stage);
    }

    public void hide() {
        visible = false;
        table.setVisible(false);
        Gdx.input.setInputProcessor(artisanScreen.getStage());
    }

    public void render() {
        if (visible) {
            stage.act();
            stage.draw();

            if (itemInProses) renderProsesBar();
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
        double cellSizeX = 53.5;
        int cellSizeY1 = 67;
        int cellSizeY2 = 62;
        int cols = 12;

        for (int i = 0; i < items.size(); i++) {
            ArtisanGoodType item = items.get(i);
            if (item != null) {
                int row = i / cols;
                int col = i % cols;

                double x = positionX + col * cellSizeX;
                float y;
                if (i < cols * 2) y = positionY - row * cellSizeY1;
                else y = positionY - row * cellSizeY2;

                createItemImage(item, x, y);
            }
        }

        if (borderImage != null) stage.addActor(borderImage);
        for (Image image : itemImages) {
            stage.addActor(image);
        }
    }

    private void createItemImage(ArtisanGoodType item, double x, float y) {
        Image itemImage = new Image(new TextureRegionDrawable(new TextureRegion(item.getTexture())));
        itemImage.setSize(45, 45);
        itemImage.setPosition((float) x, y);

        if (!itemInProses && item == currentItem) {
            Image border = createBorderImage(50, 52, Color.BLUE);
            border.setPosition((float) (x - 5), y - 5);
            borderImage = border;
        }

        Table tooltipTable = new Table(skin);
        Drawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundItemTexture));
        tooltipTable.setBackground(backgroundDrawable);

        tooltipTable.pad(10);

        Label nameLabel = new Label("Name: " + item.getName(), skin);
        tooltipTable.add(nameLabel).left().row();

        Label priceLabel = new Label("Price: " + item.getPrice(), skin);
        tooltipTable.add(priceLabel).left();

        Tooltip<Table> tooltip = new Tooltip<>(tooltipTable);
        tooltip.setInstant(true);
        tooltip.setAlways(false);

        itemImage.addListener(tooltip);

        if (!itemInProses) {
            itemImage.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float xOffset, float yOffset) {
                    if (currentItem != item) {
                        currentItem = item;
                        infoLabel.setText("Ingredients:\n" + ingredients(item));
                        if (ingredients(item).isEmpty()) infoLabel.setText("Ingredients:\nNOTHING!");
                    } else {
                        currentItem = null;
                        infoLabel.setText("Ingredients:");
                    }
                    makeButton.setVisible(currentItem != null);

                    errorLabel.setText("");
                    errorLabel.setVisible(false);

                    refresh();
                }
            });
        }

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

        renderItemsInGrid();
    }

    private void findArtisanGoods(IndustrialProductType device) {
        items.clear();
        for (ArtisanGoodType artisanGood : ArtisanGoodType.values()) {
            if (artisanGood.getSource().equals(device)) {
                items.add(artisanGood);
            }
        }
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

    private void handleMove() {
        if (currentItem == null) return;

        String result = GameMenuController.artisanUse(currentItem);

        if (result != null && !result.isEmpty()) {
            errorLabel.setText(result);
            errorLabel.setVisible(true);
        } else {
            show(device, artisanScreen);
        }

        refresh();
    }


    private String ingredients(ArtisanGoodType recipe) {
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

    private void renderProsesBar() {
        float maxTime = artisanGood.getArtisanGood().getType().getProcessingTime();
        float currentTime = maxTime - artisanGood.getRemainingTime();
        float timeRatio = MathUtils.clamp(currentTime / maxTime, 0f, 1f);

        float barWidth = 300f;
        float barHeight = 25f;
        float barX = positionX + 300;
        float barY = positionY - 300;

        itemLabel.setVisible(true);
        itemLabel.setText("Item In Proses: " + artisanGood.getArtisanGood().getName());
        itemLabel.setPosition(barX, barY + 45);
        Gdx.gl.glEnable(GL20.GL_BLEND);

        shapeRenderer.setProjectionMatrix(stage.getCamera().combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(Color.DARK_GRAY);
        shapeRenderer.rect(barX, barY, barWidth, barHeight);

        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rect(barX, barY, barWidth * timeRatio, barHeight);

        shapeRenderer.end();
        Gdx.gl.glDisable(GL20.GL_BLEND);

        if (timeRatio == 1) {
            claimButton.setVisible(true);
            itemLabel.setText(artisanGood.getArtisanGood().getName() + " is ready!");
        }
    }
}
