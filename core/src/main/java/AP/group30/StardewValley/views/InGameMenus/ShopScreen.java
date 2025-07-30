package AP.group30.StardewValley.views.InGameMenus;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.GameMenuController;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Buildings.*;
import AP.group30.StardewValley.models.Game;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProductType;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.Products.ShopProducts.*;
import AP.group30.StardewValley.models.Items.Tools.Tool;
import AP.group30.StardewValley.models.Players.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;
import java.util.Collections;

public class ShopScreen {
    private final Stage stage;
    private final Skin skin;
    private final Table rootTable;
    private Table additionalService;
    private final Label moneyLabel;
    private final Label errorLabel;
    private final ScrollPane scrollPane;
    private final Texture background;
    private final Image backgroundImage;
    private final ArrayList<Item> shopItems;
    private boolean visible = false;
    private Building building;
    private boolean click = false;
    private float carpenterX;
    private float carpenterY;
    private TextField buildingX;
    private TextField buildingY;
    private final Texture backgroundItemTexture;
//    private ArrayList<Item> allItems;
    private ShopProduct selectedProduct = null;
    private TextButton buy;
    private TextField count;
//    private TextButton availableProducts;

    /**
     * @param batch     The SpriteBatch from your GameScreen
     * @param skin      A Skin for buttons/labels
     * @param items     The shop stock, e.g. BlacksmithCosts.values()
     */
    public ShopScreen(SpriteBatch batch, Skin skin, ArrayList<Item> items, ArrayList<Item> notAvailableItems, Building building) {
        this.skin = skin;
        this.stage = new Stage(new ScreenViewport(), batch);
        this.shopItems = items;
        this.background = GameAssetManager.assetManager.get(GameAssetManager.inventoryItem);
        this.backgroundImage = new Image(background);
        this.building = building;
        this.buildingX = new TextField("X coordinate", skin);
        this.buildingY = new TextField("Y coordinate", skin);
        this.buy = new TextButton("Buy", skin);
        this.count = new TextField("", skin);
//        this.availableProducts = new TextButton("Available Products", skin);
//        allItems.addAll(shopItems);
//        allItems.addAll(notAvailableItems);
//        Collections.shuffle(allItems);
        backgroundItemTexture = GameAssetManager.assetManager.get(GameAssetManager.inventoryItem);
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
        rootTable.add(topBar).fillX().padBottom(10).row();

        // Left: Item grid inside ScrollPane
        Table itemsTable = new Table(skin);
        itemsTable.defaults().pad(10);
        for (int i = 0; i < shopItems.size(); i++) {
            ItemsInteface shopItem = shopItems.get(i);
            itemsTable.add(createShopItemCell(shopItem, true)).width(150).height(300);
            itemsTable.row();
        }
        for (int i = 0; i < notAvailableItems.size(); i++) {
            ItemsInteface shopItem = notAvailableItems.get(i);
            itemsTable.add(createShopItemCell(shopItem, false)).width(150).height(300);
            itemsTable.row();
        }
//        if (availableProducts.isChecked()) {
//            for (int i = 0; i < shopItems.size(); i++) {
//                ItemsInteface shopItem = shopItems.get(i);
//                itemsTable.add(createShopItemCell(shopItem, true)).width(150).height(300);
//                itemsTable.row();
//            }
//            for (int i = 0; i < notAvailableItems.size(); i++) {
//                ItemsInteface shopItem = notAvailableItems.get(i);
//                itemsTable.add(createShopItemCell(shopItem, false)).width(150).height(300);
//                itemsTable.row();
//            }
//        } else {
//            for (int i = 0; i < allItems.size(); i++) {
//                Item shopItem = shopItems.get(i);
//                if (shopItem.getCount() == 0) {
//                    itemsTable.add(createShopItemCell(shopItem, false)).width(150).height(300);
//                } else {
//                    itemsTable.add(createShopItemCell(shopItem, true)).width(150).height(300);
//                }
//                itemsTable.row();
//            }
//        }

        scrollPane = new ScrollPane(itemsTable, skin);
        scrollPane.setFadeScrollBars(false);
        rootTable.add(scrollPane).expand().fill();

        // Right: (optional) Could add player inventory or description
        // For now just a placeholder
        if (building instanceof Blacksmith) {
            additionalService = additionalService();
            rootTable.add(additionalService).expand().fill();
        }
        Table leftsideTable = new Table(skin);
        leftsideTable.add(new Label("Select an item to buy", skin)).padLeft(30).padTop(30).row();
        if (building instanceof Carpenter) {
            leftsideTable.add(buildingX).padLeft(30).padTop(20).row();
            leftsideTable.add(buildingY).padLeft(30).padTop(20).row();
            leftsideTable.add(new Label("Hut Coordinates: " + App.getCurrentGame().getHut().getStartX() * 32+ " " + (60 -App.getCurrentGame().getHut().getStartY()) * 32, skin)).padLeft(30).padTop(20);
        }

        if (building instanceof Ranch) {
            buildingX.setText("Animal's Name");
            leftsideTable.add(buildingX).padLeft(30).width(400).row();
        }
        rootTable.add(leftsideTable).right();
        rootTable.add(buy);
        rootTable.add(count);
    }

    private Table createShopItemCell(ItemsInteface shopItem, boolean available) {
        Player player = App.getCurrentGame().getCurrentPlayer();

        Table cell = new Table(skin);
        // requires a drawable in your skin

        // Icon
        Texture tex = shopItem.getTexture();
        Image img = new Image(tex);
        img.setScaling(Scaling.fit);
        img.setFillParent(false);
        Table tooltipTable = new Table(skin);
        Drawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundItemTexture));
        tooltipTable.setBackground(backgroundDrawable);

        tooltipTable.pad(10);

        Label nameLabel = new Label("Name: " + shopItem.getName(), skin);
        tooltipTable.add(nameLabel).left().row();
        if (shopItem instanceof CarpenterProducts) {
            Label stone = new Label("Required Stone: " + ((CarpenterProducts) shopItem).getType().getStone() + " stones", skin);
            Label wood = new Label("Required Wood: " + ((CarpenterProducts) shopItem).getType().getWood() + " woods", skin);
            tooltipTable.add(stone).left().row();
            tooltipTable.add(wood).left().row();
        } else if (shopItem instanceof RanchProducts) {
            Label dailyLimit = new Label("Daily Limit " + ((RanchProducts) shopItem).getType().getDailyLimit(), skin);
            Label requiredBuilding = null;
            if (((RanchProducts)shopItem).getType().getRequiredBuilding().equals(BuildingsInfo.Coop)) {
                requiredBuilding = switch (((RanchProducts) shopItem).getType().getRequiredBuildingLevel()) {
                    case 1 -> new Label("Required Building: Regular Coop", skin);
                    case 2 -> new Label("Required Building: Big Coop", skin);
                    case 3 -> new Label("Required Building: Deluxe Coop", skin);
                    default -> requiredBuilding;
                };
            } else if (((RanchProducts)shopItem).getType().getRequiredBuilding().equals(BuildingsInfo.Barn)) {
                requiredBuilding = switch (((RanchProducts) shopItem).getType().getRequiredBuildingLevel()) {
                    case 1 -> new Label("Required Building: Regular Barn", skin);
                    case 2 -> new Label("Required Building: Big Barn", skin);
                    case 3 -> new Label("Required Building: Deluxe Barn", skin);
                    default -> requiredBuilding;
                };
            }
            tooltipTable.add(dailyLimit).left().row();
            tooltipTable.add(requiredBuilding).left().row();
        } else if (shopItem instanceof JojaMartProducts) {
            Label season = new Label("Season: " + ((JojaMartProducts)shopItem).getType().getSeason().getName(), skin);
            tooltipTable.add(season).left().row();
        } else if (shopItem instanceof GeneralStoreProducts) {
            Label season = new Label("Season: " + ((GeneralStoreProducts)shopItem).getType().getSeason().getName(), skin);
            Label description = new Label("Description: " + ((GeneralStoreProducts)shopItem).getType().getDescription(), skin);
            tooltipTable.add(season).left().row();
            tooltipTable.add(description).left().row();
        }

        if (shopItem.getPrice() != 0) {
            Label priceLabel = new Label("Price: " + shopItem.getPrice(), skin);
            Label stock;
            boolean unlimited = ((ShopProduct) shopItem).getCount() > 200;
            if (unlimited) stock = new Label("Unlimited stock", skin);
            else stock = new Label("Daily Limit: " + ((ShopProduct)shopItem).getCount(), skin);
            tooltipTable.add(priceLabel).left();
            tooltipTable.add(stock).left().row();
        }
        Tooltip<Table> tooltip = new Tooltip<>(tooltipTable);
        tooltip.setInstant(true);
        tooltip.setAlways(false);
        img.addListener(tooltip);



//        img.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                errorLabel.setVisible(false);
//                int cost = shopItem.getPrice();
//                if (player.getMoney() < cost) {
//                    errorLabel.setText("Not enough money!");
//                    errorLabel.setVisible(true);
//                    return;
//                }
//
//                if (((ShopProduct)shopItem).getCount() == 0) {
//                    errorLabel.setText("Out of stock!");
//                    errorLabel.setVisible(true);
//                } else {
//
//                    // perform purchase
//                    if (building instanceof Carpenter) {
//                        try {
//                            carpenterX = Integer.parseInt(buildingX.getText());
//                            carpenterY = Integer.parseInt(buildingY.getText());
//                        } catch (NumberFormatException e) {
//                            errorLabel.setText("invalid coordinates");
//                            errorLabel.setVisible(true);
//                        }
//                        boolean success = GameMenuController.build(shopItem.getName(), carpenterX, carpenterY);
//                        if (success) {
//                            player.setMoney(player.getMoney() - cost);
//                        }
//                    } else if (building instanceof Ranch) {
//                        GameMenuController.buyAnimal(shopItem.getName(), buildingX.getText());
//                    } else {
//                        Item inInv = Item.findItemByName(
//                            shopItem.getName(), player.getBackPack().getItems());
//                        if (inInv != null) {
//                            inInv.setCount(inInv.getCount() + 1);
//                        } else {
//                            player.getBackPack().addItem(
//                                new Item(1, shopItem.getName(), shopItem.getPrice(), shopItem.getTexture()));  // assume you have a copy-constructor
//                        }
//                        ((ShopProduct) shopItem).setCount(((ShopProduct) shopItem).getCount() - 1);
//                        player.setMoney(player.getMoney() - cost);
//                    }
//                    App.getCurrentGame().incrementPurchase(shopItem);
//                    refresh(); // updateGreenBar money label (and could updateGreenBar limit display)
//                }
//            }
//        });

        img.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                selectedProduct = (ShopProduct) shopItem; // store reference
                errorLabel.setVisible(false);
                errorLabel.setText("Selected: " + shopItem.getName());
                errorLabel.setVisible(true);
            }
        });

        buy.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                errorLabel.setVisible(false);

                if (selectedProduct == null) {
                    errorLabel.setText("No item selected!");
                    errorLabel.setVisible(true);
                    return;
                }
                int number = 0;
                try {
                    number = Integer.parseInt(count.getText());
                } catch (Exception e) {
                    errorLabel.setText("Invalid number!");
                    errorLabel.setVisible(true);
                    return;
                }

                if (number > selectedProduct.getCount()) {
                    errorLabel.setText("Not enough products available!");
                    errorLabel.setVisible(true);
                    return;
                }

                int cost = selectedProduct.getPrice();
                if (player.getMoney() < cost) {
                    errorLabel.setText("Not enough money!");
                    errorLabel.setVisible(true);
                    return;
                }

                if (selectedProduct.getCount() == 0) {
                    errorLabel.setText("Out of stock!");
                    errorLabel.setVisible(true);
                    return;
                }

                // perform purchase
                if (building instanceof Carpenter) {
                    try {
                        carpenterX = Integer.parseInt(buildingX.getText());
                        carpenterY = Integer.parseInt(buildingY.getText());
                    } catch (NumberFormatException e) {
                        errorLabel.setText("invalid coordinates");
                        errorLabel.setVisible(true);
                    }
                    boolean success = GameMenuController.build(shopItem.getName(), carpenterX, carpenterY);
                    if (success) {
                        player.setMoney(player.getMoney() - cost);
                    }
                } else if (building instanceof Ranch) {
                    GameMenuController.buyAnimal(shopItem.getName(), buildingX.getText());
                } else if (building instanceof Saloon) {
                    addFoodRecipe(cost, shopItem, player);
                } else {
                    if (shopItem.getName().equals("A recipe to make Fish Smoker")) {
                        if (!player.getCraftingRecipes().contains(IndustrialProductType.FISH_SMOKER)) {
                            player.getCraftingRecipes().add(IndustrialProductType.FISH_SMOKER);
                        }
                    } else if (shopItem.getName().equals("dehydrator recipe")) {
                        if (!player.getCraftingRecipes().contains(IndustrialProductType.DEHYDRATOR)) {
                            player.getCraftingRecipes().add(IndustrialProductType.DEHYDRATOR);
                        }
                    } else if (shopItem.getName().equals("grass starter recipe")) {
                        if (!player.getCraftingRecipes().contains(IndustrialProductType.GRASS_STARTER)) {
                            player.getCraftingRecipes().add(IndustrialProductType.GRASS_STARTER);
                        }
                    } else {
                        Item inInv = Item.findItemByName(
                            shopItem.getName(), player.getBackPack().getItems());
                        if (inInv != null) {
                            inInv.setCount(inInv.getCount() + number);
                        } else {
                            player.getBackPack().addItem(
                                new Item(number, shopItem.getName(), shopItem.getPrice(), shopItem.getTexture()));  // assume you have a copy-constructor
                        }
                    }
                    selectedProduct.setCount(selectedProduct.getCount() - number);
                    player.setMoney(player.getMoney() - cost * number);
                }


                App.getCurrentGame().incrementPurchase(selectedProduct);
                selectedProduct = null;
                refresh();
            }
        });


        cell.add(img).size(64).pad(20);

        // Name & cost
        cell.add(new Label(shopItem.getName(), skin)).padTop(4);

        cell.add(new Label("   Cost: " + shopItem.getPrice(), skin)).padTop(2).row();
        if (!available)
            cell.add(new Label("    (Not Available): ", skin)).padTop(4);

        return cell;
    }

    private static void addFoodRecipe(int cost, ItemsInteface shopItem, Player player) {
        assert shopItem instanceof SaloonProducts;
        SaloonCosts itemType = ((SaloonProducts) shopItem).getType();

        ((ShopProduct) shopItem).setCount(((ShopProduct) shopItem).getCount() - 1);
        player.setMoney(player.getMoney() - cost);
        if (itemType.getRecipe() != null) {
            if (!App.getCurrentGame().getCurrentPlayer().getRecipes().contains(itemType.getRecipe()))
                App.getCurrentGame().getCurrentPlayer().addRecipe(itemType.getRecipe());
        } else {
            Item inInv = Item.findItemByName(
                shopItem.getName(), player.getBackPack().getItems());
            if (inInv != null) {
                inInv.setCount(inInv.getCount() + 1);
            } else {
                player.getBackPack().addItem(
                    new Item(1, shopItem.getName(), shopItem.getPrice(), shopItem.getTexture()));  // assume you have a copy-constructor
            }
        }
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

    public boolean render(SpriteBatch batch, OrthographicCamera camera) {
        if (!visible) return false;
        if (click) {
            return false;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            hide();
            return false;
        }
        batch.begin();
        batch.draw(GameAssetManager.assetManager.get(GameAssetManager.blackBackground), camera.position.x - Gdx.graphics.getWidth() / 2f - 50,
            camera.position.y - Gdx.graphics.getHeight() / 2f - 50, Gdx.graphics.getWidth() * 2f, Gdx.graphics.getHeight() * 2f);
        batch.draw(background, camera.position.x - Gdx.graphics.getWidth() / 3f, camera.position.y - Gdx.graphics.getHeight() / 2f, Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight());
        batch.end();
        stage.act();
        stage.draw();
        return true;
    }

    private void refresh() {
        // updateGreenBar money
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

    private Table additionalService() {
        Table table = new Table(skin);
        if (building instanceof Blacksmith) {
            table.add(new Label("Blacksmith Upgrades: ", skin)).left().row();
            for (Item item : App.getCurrentGame().getCurrentPlayer().getBackPack().getItems()) {
                if (item instanceof Tool) {
                    Image img = new Image(item.getTexture());
                    img.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            click = GameMenuController.upgradeTools(item.getName(), errorLabel);
                            if (!click) {
                                errorLabel.setVisible(true);
                            }
                        }
                    });
                    table.add(img).size(64).padTop(20).row();
                    table.add(new Label(item.getName(), skin)).padTop(4).row();
                }
            }
        }
        return table;
    }

    public void setCarpenterY(float carpenterY) {
        this.carpenterY = carpenterY;
    }

    public void setCarpenterX(float carpenterX) {
        this.carpenterX = carpenterX;
    }
}
