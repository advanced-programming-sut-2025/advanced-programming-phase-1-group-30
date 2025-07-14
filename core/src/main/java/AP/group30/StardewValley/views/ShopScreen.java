package AP.group30.StardewValley.views;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Game;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Players.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;

public class ShopScreen {
    private final Stage stage;
    private final Skin skin;
    private final Table rootTable;
    private final Label moneyLabel;
    private final Label errorLabel;
    private final ScrollPane scrollPane;
    private final Texture background;
    private final ArrayList<Item> shopItems;
    private boolean visible = false;

    /**
     * @param batch     The SpriteBatch from your GameScreen
     * @param skin      A Skin for buttons/labels
     * @param items     The shop stock, e.g. BlacksmithCosts.values()
     */
    public ShopScreen(SpriteBatch batch, Skin skin, ArrayList<Item> items) {
        this.skin = skin;
        this.stage = new Stage(new ScreenViewport(), batch);
        this.shopItems = items;
        this.background = GameAssetManager.assetManager.get(GameAssetManager.inventoryItem);

        // Root table
        rootTable = new Table(skin);
        rootTable.setFillParent(true);
        rootTable.pad(20);
        stage.addActor(rootTable);

        // Top: Money + error
        moneyLabel = new Label("", skin);
        errorLabel = new Label("", skin);
        errorLabel.setColor(Color.RED);
        errorLabel.setVisible(false);

        Table topBar = new Table(skin);
        topBar.add(new Label("Money: ", skin)).left();
        topBar.add(moneyLabel).left().padRight(40);
        topBar.add(errorLabel).left();
        rootTable.add(topBar).colspan(2).expandX().fillX().padBottom(10).row();

        // Left: Item grid inside ScrollPane
        Table itemsTable = new Table(skin);
        itemsTable.defaults().pad(10);
        for (int i = 0; i < shopItems.size(); i++) {
            ItemsInteface shopItem = shopItems.get(i);
            itemsTable.add(createShopItemCell(shopItem)).width(150).height(300);
            itemsTable.row();
        }

        scrollPane = new ScrollPane(itemsTable, skin);
        scrollPane.setFadeScrollBars(false);
        rootTable.add(scrollPane).expand().fill();

        // Right: (optional) Could add player inventory or description
        // For now just a placeholder
        rootTable.add(new Label("Select an item to buy", skin)).padLeft(30);
    }

    private Table createShopItemCell(ItemsInteface shopItem) {
        Player player = App.getCurrentGame().getCurrentPlayer();

        Table cell = new Table(skin);

//        cell.background(); // requires a drawable in your skin

        // Icon
        Texture tex = shopItem.getTexture();
        Image img = new Image(tex);
        img.setScaling(Scaling.fit);
        img.setFillParent(false);
        img.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                errorLabel.setVisible(false);
                int cost = (int)shopItem.getPrice();
                if (player.getMoney() < cost) {
                    errorLabel.setText("Not enough money!");
                    errorLabel.setVisible(true);
                    return;
                }
                // check daily limit
//                long boughtToday = App.getCurrentGame()
//                    .getDailyShopCounter().get(shopItem);
//                if (boughtToday >= shopItem.getDailyLimit()) {
//                    errorLabel.setText("Reached daily limit!");
//                    errorLabel.setVisible(true);
//                    return;
//                }
                // perform purchase
                player.setMoney(player.getMoney() - cost);
                Item inInv = Item.findItemByName(
                    shopItem.getName(), player.getBackPack().getItems());
                if (inInv != null) {
                    inInv.setCount(inInv.getCount() + 1);
                } else {
                    player.getBackPack().addItem(
                        new Item(1, shopItem.getName(), shopItem.getPrice(), shopItem.getTexture()));  // assume you have a copy-constructor
                }
                App.getCurrentGame().incrementPurchase(shopItem);
                refresh(); // update money label (and could update limit display)
            }
        });
        cell.add(img).size(64);

        // Name & cost
        cell.add(new Label(shopItem.getName(), skin)).padTop(4);

        cell.add(new Label("Cost: " + shopItem.getPrice(), skin)).padTop(2).row();

        // Buy button
//        TextButton buy = new TextButton("Buy", skin);
//        buy.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                errorLabel.setVisible(false);
//                int cost = (int)shopItem.getPrice();
//                if (player.getMoney() < cost) {
//                    errorLabel.setText("Not enough money!");
//                    errorLabel.setVisible(true);
//                    return;
//                }
//                // check daily limit
////                long boughtToday = App.getCurrentGame()
////                    .getDailyShopCounter().get(shopItem);
////                if (boughtToday >= shopItem.getDailyLimit()) {
////                    errorLabel.setText("Reached daily limit!");
////                    errorLabel.setVisible(true);
////                    return;
////                }
//                // perform purchase
//                player.setMoney(player.getMoney() - cost);
//                Item inInv = Item.findItemByName(
//                    shopItem.getName(), player.getBackPack().getItems());
//                if (inInv != null) {
//                    inInv.setCount(inInv.getCount() + 1);
//                } else {
//                    player.getBackPack().addItem(
//                        new Item(1, shopItem.getName(), shopItem.getPrice(), shopItem.getTexture()));  // assume you have a copy-constructor
//                }
//                App.getCurrentGame().incrementPurchase(shopItem);
//                refresh(); // update money label (and could update limit display)
//            }
//        });
//        cell.add(buy).padTop(6).row();

        return cell;
    }

    public void toggle() {
        if (visible) hide();
        else show();
    }

    public void show() {
        refresh();
        visible = true;
        Gdx.input.setInputProcessor(stage);
    }

    public void hide() {
        visible = false;
        Gdx.input.setInputProcessor(null);
    }

    public void render(SpriteBatch batch, OrthographicCamera camera) {
        if (!visible) return;
        batch.begin();
        batch.draw(GameAssetManager.assetManager.get(GameAssetManager.blackBackground), camera.position.y - Gdx.graphics.getWidth() / 2f,
            camera.position.y - Gdx.graphics.getHeight() / 2f, Gdx.graphics.getWidth() * 2f, Gdx.graphics.getHeight());
        batch.draw(background, camera.position.x - Gdx.graphics.getWidth() / 6f, camera.position.y - Gdx.graphics.getHeight() / 2f, Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight());
        batch.end();
        stage.act();
        stage.draw();
    }

    private void refresh() {
        // update money
        moneyLabel.setText(String.valueOf(
            App.getCurrentGame().getCurrentPlayer().getMoney()));
        errorLabel.setVisible(false);
    }

    public boolean isVisible() {
        return visible;
    }

    public void dispose() {
        stage.dispose();
    }
}
