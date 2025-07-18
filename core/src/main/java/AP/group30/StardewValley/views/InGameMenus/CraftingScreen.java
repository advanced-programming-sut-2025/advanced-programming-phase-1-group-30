package AP.group30.StardewValley.views.InGameMenus;

import AP.group30.StardewValley.controllers.GameMenuController;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProductType;
import AP.group30.StardewValley.models.Items.Item;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.ArrayList;

public class CraftingScreen extends InGameMenuScreen {
    private final TextButton craftingButton;

    private final ArrayList<Image> itemImages = new ArrayList<>();
    private Image borderImage;

    private ArrayList<IndustrialProductType> recipes = App.getCurrentGame().getCurrentPlayer().getCraftingRecipes();
    private IndustrialProductType currentRecipe = null;

    private final Label errorLabel;

    public CraftingScreen(SpriteBatch batch, Skin skin) {
        super(batch, skin, GameAssetManager.crafting, 2, 200);

        craftingButton = new TextButton("Craft", skin);
        craftingButton.setPosition(table.getX() + table.getWidth() / 2f - craftingButton.getWidth() / 2f - 50,
            table.getY() - craftingButton.getHeight());
        craftingButton.setVisible(false);
        craftingButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                handleMove();
            }
        });

        errorLabel = new Label("", skin);
        errorLabel.setColor(Color.RED);
        errorLabel.setPosition(table.getX() + 50 ,
            table.getY() + 70);
        errorLabel.setVisible(false);

        stage.addActor(table);
        stage.addActor(errorLabel);
        stage.addActor(craftingButton);

        refresh();
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
    }

    private void handleMove() {
        if (currentRecipe == null) return;

        String result = GameMenuController.crafting(currentRecipe);

        errorLabel.setText(result);
        errorLabel.setVisible(true);

        refresh();
    }

    private void renderItemsInGrid(float posX, float posY) {
        int cellSizeX = 60;
        int cellSizeY1 = 78;
        int cellSizeY2 = 73;
        int cols = 12;

        for (int i = 0; i < recipes.size(); i++) {
            IndustrialProductType recipe = recipes.get(i);
            if (recipe != null) {
                int row = i / cols;
                int col = i % cols;

                float x = posX + col * cellSizeX;
                float y = (i < cols * 2) ? posY - row * cellSizeY1 : posY - row * cellSizeY2;

                createItemImage(recipe, x, y);
            }
        }

        if (currentRecipe != null && borderImage != null) stage.addActor(borderImage);
        for (Image image : itemImages) {
            stage.addActor(image);
        }
    }

    private void createItemImage(IndustrialProductType recipe, float x, float y) {
        Texture itemTexture = recipe.getTexture();
        Image itemImage = new Image(new TextureRegionDrawable(new TextureRegion(itemTexture)));
        itemImage.setSize(45, 45);
        itemImage.setPosition(x, y);

        if (recipe == currentRecipe) {
            borderImage = createBorderImage(50, 52, Color.BLUE);
            borderImage.setPosition(x - 5, y - 5);
        }

        Table tooltipTable = new Table(skin);
        Drawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundItemTexture));
        tooltipTable.setBackground(backgroundDrawable);
        tooltipTable.pad(10);

        tooltipTable.add(new Label("Name: " + recipe.getName(), skin)).left().row();
        tooltipTable.add(new Label("Ingredient: " + ingredients(recipe), skin)).left().row();

        Tooltip<Table> tooltip = new Tooltip<>(tooltipTable);
        tooltip.setInstant(true);
        tooltip.setAlways(false);
        itemImage.addListener(tooltip);

        itemImage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float xOffset, float yOffset) {
                if (currentRecipe != recipe) {
                    currentRecipe = recipe;
                } else {
                    currentRecipe = null;
                }
                craftingButton.setVisible(currentRecipe != null);

                errorLabel.setText("");
                errorLabel.setVisible(false);

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
        if (borderImage != null) borderImage.remove();

        recipes = App.getCurrentGame().getCurrentPlayer().getCraftingRecipes();

        renderItemsInGrid(table.getX() + 50, table.getY() + table.getHeight() - 100);
    }

    private String ingredients(IndustrialProductType recipe) {
        ArrayList<Item> ingredients = recipe.getIngredients();
        StringBuilder ingredientsText = new StringBuilder();

        for (Item ingredient : ingredients) {
            if (ingredients.getLast().equals(ingredient))
                ingredientsText.append(ingredient.getName()).append(" (x").append(ingredient.getCount()).append(")");
            else
                ingredientsText.append(ingredient.getName()).append(" (x").append(ingredient.getCount()).append(")\n");
        }

        return ingredientsText.toString();
    }
}
