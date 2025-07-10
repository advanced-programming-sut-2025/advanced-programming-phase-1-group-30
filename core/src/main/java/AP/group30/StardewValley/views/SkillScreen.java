package AP.group30.StardewValley.views;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Players.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SkillScreen {
    private final Stage stage;
    private final Skin skin;
    private final Table table;
    private boolean visible = false;
    private final Texture backgroundTexture;
    private final Texture backgroundItemTexture;

    private final int positionX;
    private final int positionY;

    public SkillScreen(SpriteBatch batch, Skin skin) {
        this.skin = skin;
        this.stage = new Stage(new ScreenViewport(), batch);

        backgroundTexture = GameAssetManager.assetManager.get(GameAssetManager.skill);
        Drawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundTexture));

        backgroundItemTexture = GameAssetManager.assetManager.get(GameAssetManager.inventoryItem);

        table = new Table();
        table.setVisible(false);
        table.setBackground(backgroundDrawable);
        table.setSize(800, 300);
        table.setPosition(
            (Gdx.graphics.getWidth() - table.getWidth()) / 2,
            (Gdx.graphics.getHeight() - table.getHeight()) / 2
        );

        positionX = (int) ((Gdx.graphics.getWidth() - table.getWidth()) / 2);
        positionY = (int) ((Gdx.graphics.getHeight() - table.getHeight()) / 2);
        stage.addActor(table);

        createPlayerImage();

        createImage(ItemTexture.FARMING_ICON, positionX + 350, positionY + 220);
        createImage(ItemTexture.FISHING_ICON, positionX + 350, positionY + 160);
        createImage(ItemTexture.FORAGING_ICON, positionX + 350, positionY + 100);
        createImage(ItemTexture.MINING_ICON, positionX + 350, positionY + 40);
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

    private void createImage(ItemTexture item, double x, float y) {
        Image itemImage = new Image(new TextureRegionDrawable(new TextureRegion(item.getTexture())));
        itemImage.setSize(45, 45);
        itemImage.setPosition((float) x, y);

        Table tooltipTable = new Table(skin);
        Drawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundItemTexture));
        tooltipTable.setBackground(backgroundDrawable);

        tooltipTable.pad(10);

        Player player = App.getCurrentGame().getCurrentPlayer();
        String name;
        int amount;
        if (item.equals(ItemTexture.FARMING_ICON)) {
            name = "Farming";
            amount = player.getFarming();
        }
        else if (item.equals(ItemTexture.FORAGING_ICON)) {
            name = "Foraging";
            amount = player.getForaging();
        }
        else if (item.equals(ItemTexture.FISHING_ICON)) {
            name = "Fishing";
            amount = player.getFishing();
        }
        else if (item.equals(ItemTexture.MINING_ICON)) {
            name = "Mining";
            amount = player.getMining();
        }
        else {
            name = "None";
            amount = 0;
        }

        Label nameLabel = new Label("Skill Name: " + name, skin);
        tooltipTable.add(nameLabel).left().row();

        Label countLabel = new Label("Level: " + amount, skin);
        tooltipTable.add(countLabel).left().row();

        Tooltip<Table> tooltip = new Tooltip<>(tooltipTable);
        tooltip.setInstant(true);
        tooltip.setAlways(false);

        itemImage.addListener(tooltip);
        stage.addActor(itemImage);

        for (int i = 1; i <= amount; i++) {
            createTapperImage(x + i * 30 + 25, y + 2);
        }
    }

    private void createPlayerImage() {
        Texture playerTexture = GameAssetManager.assetManager.get(GameAssetManager.playerInfo);
        Image playerImage = new Image(new TextureRegionDrawable(new TextureRegion(playerTexture)));
        playerImage.setPosition(positionX + 55, positionY + 60);

        stage.addActor(playerImage);
    }

    private void createTapperImage(double x, double y) {
        Texture tapperTexture = ItemTexture.TAPPER_ICON.getTexture();
        Image tapperImage = new Image(new TextureRegionDrawable(new TextureRegion(tapperTexture)));
        tapperImage.setSize(40, 40);
        tapperImage.setPosition((float) x, (float) y);

        stage.addActor(tapperImage);
    }
}
