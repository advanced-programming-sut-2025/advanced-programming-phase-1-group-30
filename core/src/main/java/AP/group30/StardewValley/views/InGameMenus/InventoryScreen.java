package AP.group30.StardewValley.views.InGameMenus;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Players.Player;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.ArrayList;

public class InventoryScreen extends InGameMenuScreen{
    Label money;
    Label energy;
    Player player = App.getCurrentGame().getCurrentPlayer();

    private final ArrayList<Image> itemImages = new ArrayList<>();
    private Image borderImage;

    private final ArrayList<Item> items = App.getCurrentGame().getCurrentPlayer().getBackPack().getItems();
    private Item currentItem;

    private final DragAndDrop dragAndDrop = new DragAndDrop();

    private final Label errorLabel;

    public InventoryScreen(SpriteBatch batch, Skin skin) {
        super(batch, skin, GameAssetManager.inventoryScreen, 1, 0);

        errorLabel = new Label("You can't sell this Item!", skin);
        errorLabel.setColor(Color.RED);
        errorLabel.setPosition(positionX + 350, positionY - 400);
        errorLabel.setVisible(false);

        Label info = new Label(player.getUsername() + " Farm", skin);
        info.setPosition(positionX + 250, positionY - 250);
        energy = new Label("Current Energy: " + player.getEnergy(), skin);
        energy.setPosition(positionX + 250, positionY - 300);
        money = new Label("Current Money: " + player.getMoney(), skin);
        money.setPosition(positionX + 250, positionY - 350);

        stage.addActor(info);
        stage.addActor(energy);
        stage.addActor(money);
        stage.addActor(errorLabel);

        createTrashCanImage();

        renderItemsInGrid();
    }

    @Override
    public void dispose() {
        stage.dispose();
        backgroundTexture.dispose();
    }

    private void renderItemsInGrid() {
        double cellSizeX = 53.5;
        int cellSizeY1 = 67;
        int cellSizeY2 = 62;
        int cols = 12;

        currentItem = App.getCurrentGame().getCurrentPlayer().getWield();

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
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

        stage.addActor(borderImage);
        for (Image image : itemImages) {
            stage.addActor(image);
        }
    }

    private void createItemImage(Item item, double x, float y) {
        Image itemImage = new Image(new TextureRegionDrawable(new TextureRegion(item.getTexture())));
        itemImage.setSize(45, 45);
        itemImage.setPosition((float) x, y);

        if (item == currentItem) {
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

        Label countLabel = new Label("Count: " + item.getCount(), skin);
        tooltipTable.add(countLabel).left().row();

        if (item.getPrice() != 0) {
            Label priceLabel = new Label("Price: " + item.getPrice(), skin);
            tooltipTable.add(priceLabel).left();
        }

        Tooltip<Table> tooltip = new Tooltip<>(tooltipTable);
        tooltip.setInstant(true);
        tooltip.setAlways(false);

        itemImage.addListener(tooltip);

        itemImage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float xOffset, float yOffset) {
                App.getCurrentGame().getCurrentPlayer().setWield(item);
                refresh();
            }
        });

        itemImages.add(itemImage);

        dragAndDrop.addSource(new DragAndDrop.Source(itemImage) {
            public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {
                DragAndDrop.Payload payload = new DragAndDrop.Payload();
                payload.setObject(item);
                payload.setDragActor(new Image(new TextureRegionDrawable(new TextureRegion(item.getTexture()))));
                return payload;
            }
        });
    }

    @Override
    protected void refresh() {
        for (Image img : itemImages) {
            img.remove();
        }
        money.setText("Current Money: " + player.getMoney());
        energy.setText("Current Energy: " + player.getEnergy());
        itemImages.clear();
        borderImage.remove();
        renderItemsInGrid();
    }

    private void createTrashCanImage() {
        Texture trashTexture = ItemTexture.TRASH_CAN.getTexture();
        Image trashCanImage = new Image(new TextureRegionDrawable(new TextureRegion(trashTexture)));
        trashCanImage.setSize(64, 64);
        trashCanImage.setPosition(positionX + 570, positionY - 370);

        stage.addActor(trashCanImage);

        dragAndDrop.addTarget(new DragAndDrop.Target(trashCanImage) {
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                trashCanImage.setColor(Color.RED);
                return true;
            }

            public void reset(DragAndDrop.Source source, DragAndDrop.Payload payload) {
                trashCanImage.setColor(Color.WHITE);
            }

            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                Item itemToDelete = (Item) payload.getObject();
                if (itemToDelete.getPrice() != 0) {
                    errorLabel.setVisible(false);
                    App.getCurrentGame().getCurrentPlayer().getBackPack().getItems().remove(itemToDelete);
                    if (App.getCurrentGame().getCurrentPlayer().getWield() == itemToDelete) {
                        App.getCurrentGame().getCurrentPlayer().setWield(App.getCurrentGame().getCurrentPlayer().getBackPack().getItems().getFirst());
                    }
                    refresh();
                }
                else errorLabel.setVisible(true);
            }
        });
    }
}

