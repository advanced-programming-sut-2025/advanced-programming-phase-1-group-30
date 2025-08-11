package AP.group30.StardewValley.views.InGameMenus.Hut;

import AP.group30.StardewValley.controllers.GameMenuController;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.Products.CropType;
import AP.group30.StardewValley.views.InGameMenus.InGameMenuScreen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class CraftInfoScreen extends InGameMenuScreen {
    private final TextField nameField;
    private final TextButton showButton;

    private final Label infoLabel;
    private final Label errorLabel;

    private final Image itemImage;

    public CraftInfoScreen(SpriteBatch batch, Skin skin) {
        super(batch, skin, GameAssetManager.inventoryItem, 1, 0, 0);

        showButton = new TextButton("Show", skin);
        showButton.setPosition(table.getX() + table.getWidth() / 2f - showButton.getWidth() / 2f - 100,
            table.getY() - showButton.getHeight() - 30);
        showButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                handleMove();
            }
        });

        nameField = new TextField("", skin);
        nameField.setPosition(table.getX() + table.getWidth() / 2f - showButton.getWidth() / 2f + 100,
            table.getY() - showButton.getHeight() - 30);
        nameField.setSize(showButton.getWidth() + 50, showButton.getHeight());
        stage.addActor(table);

        errorLabel = new Label("", skin);
        errorLabel.setColor(Color.RED);
        errorLabel.setPosition(table.getX() + table.getWidth() / 2f - 150,
            table.getY() - showButton.getHeight() - 60);
        errorLabel.setVisible(false);

        infoLabel = new Label("", skin);
        infoLabel.setColor(Color.WHITE);
        infoLabel.setPosition(table.getX() + table.getWidth() / 2f - 150,
            table.getY() + table.getHeight() / 2f + 40);
        infoLabel.setVisible(false);

        itemImage = new Image(new TextureRegionDrawable(new TextureRegion(ItemTexture.WOOD.getTexture())));
        itemImage.setSize(90, 90);
        itemImage.setPosition(table.getX() + 50, table.getY() + table.getHeight() / 2f - itemImage.getHeight());
        itemImage.setVisible(false);

        stage.addActor(showButton);
        stage.addActor(nameField);
        stage.addActor(errorLabel);
        stage.addActor(infoLabel);
        stage.addActor(itemImage);
    }

    private void handleMove() {
        String result = GameMenuController.craftInfo(itemImage, nameField.getText());

        if (result == null) {
            errorLabel.setText("No craft with given name were found!");
            errorLabel.setVisible(true);
            infoLabel.setVisible(false);
            itemImage.setVisible(false);
        } else {
            infoLabel.setText(result);
            infoLabel.setVisible(true);
            errorLabel.setVisible(false);
            itemImage.setVisible(true);
        }
    }

    @Override
    public void dispose() {
        stage.dispose();
        backgroundTexture.dispose();
    }

    @Override
    protected void refresh() {
        errorLabel.setText("");
        errorLabel.setVisible(false);

        infoLabel.setText("");
        infoLabel.setVisible(false);

        itemImage.setDrawable(new TextureRegionDrawable(new TextureRegion(ItemTexture.WOOD.getTexture())));
        itemImage.setVisible(false);

        nameField.setText("");
    }

    @Override
    public void hide() {
        super.hide();

        refresh();
    }
}
