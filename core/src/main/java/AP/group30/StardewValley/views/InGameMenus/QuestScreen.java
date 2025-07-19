package AP.group30.StardewValley.views.InGameMenus;

import AP.group30.StardewValley.controllers.GameMenuController;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Players.NPC.NPC;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class QuestScreen {
    private Stage stage;
    private Skin skin;
    private Table table1;
    private boolean visible = false;
    private Texture backgroundTexture;

    private NPC currentNPC;
    private Label errorLabel;
    private Label favoriteGifts;

    private Table table2;
    private TextField giftTextField;
    private TextButton giftButton;

    private Table heartContainer;

    private Label tableInfo;
    private Table quest1;
    private Image status1;
    private Label state1;
    private TextButton finishButton1;

    private Table quest2;
    private Image status2;
    private Label state2;
    private TextButton finishButton2;

    private Table quest3;
    private Image status3;
    private Label state3;
    private TextButton finishButton3;

    public QuestScreen(SpriteBatch batch, Skin skin) {
        this.skin = skin;
        this.stage = new Stage(new ScreenViewport(), batch);

        backgroundTexture = GameAssetManager.assetManager.get(GameAssetManager.gift);
        Drawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundTexture));

        table1 = new Table();
        table1.setVisible(false);
        table1.setBackground(backgroundDrawable);
        table1.setSize(1920, 1080);
        table1.setPosition(
            (Gdx.graphics.getWidth() - table1.getWidth()) / 2f,
            (Gdx.graphics.getHeight() - table1.getHeight()) / 2f
        );

        table2 = new Table();
        table2.setVisible(false);
        table2.setPosition(
            (Gdx.graphics.getWidth() - table2.getWidth()) / 2.9f,
            (Gdx.graphics.getHeight() - table2.getHeight()) / 1.7f
        );
        giftTextField = new TextField("",skin);
        giftButton = new TextButton("gift", skin);
        giftButton.setPosition(table2.getX() / 1.5f, table1.getY());
        table2.add(giftTextField).width(200).height(80);
        table2.row().pad(20);
        table2.add(giftButton).width(120).height(90);

        giftButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                handleMove();
            }
        });

        errorLabel = new Label("", skin);
        errorLabel.setColor(Color.RED);
        errorLabel.setPosition((Gdx.graphics.getWidth() - table2.getWidth()) / 2.3f,
            (Gdx.graphics.getHeight() - table2.getHeight()) / 3.3f);
        errorLabel.setVisible(false);

        favoriteGifts = new Label("", skin);
        favoriteGifts.setPosition((Gdx.graphics.getWidth() - table2.getWidth()) / 3.6f,
            (Gdx.graphics.getHeight() - table2.getHeight()) / 2.3f);
        favoriteGifts.setVisible(false);

        heartContainer = new Table();
        heartContainer.setVisible(false);
        heartContainer.align(Align.left);

        heartContainer.setPosition(
            Gdx.graphics.getWidth() / 3.15f,
            Gdx.graphics.getHeight()  / 3.06f
        );

        tableInfo = new Label("Status       Request       Reward", skin);
        tableInfo.setPosition(Gdx.graphics.getWidth() / 2.25f,
            Gdx.graphics.getHeight() / 1.6f);
        tableInfo.setVisible(false);
        tableInfo.setColor(Color.BLACK);

        quest1 = new Table();
        quest1.setVisible(false);
        quest1.align(Align.left);
        status1 = new Image();
        state1 = new Label("", skin);
        state1.setColor(Color.BLACK);
        finishButton1 = new TextButton("finish", skin);
        finishButton1.setVisible(false);
        quest1.add(status1).width(80).height(80).pad(10);
        quest1.add(state1).pad(20);
        quest1.add(finishButton1).width(150).height(80);
        quest1.setPosition(Gdx.graphics.getWidth() / 2.3f, Gdx.graphics.getHeight() / 1.8f );
        finishButton1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                errorLabel.setText(currentNPC.quest1());
                errorLabel.setVisible(true);
                refresh();
            }
        });


        quest2 = new Table();
        quest2.setVisible(false);
        quest2.align(Align.left);
        status2 = new Image();
        state2 = new Label("", skin);
        state2.setColor(Color.BLACK);
        finishButton2 = new TextButton("finish", skin);
        finishButton2.setVisible(false);
        quest2.add(status2).width(80).height(80).pad(10);
        quest2.add(state2).pad(20);
        quest2.add(finishButton2).width(150).height(80);
        quest2.setPosition(Gdx.graphics.getWidth() / 2.3f, Gdx.graphics.getHeight() / 2.15f);
        finishButton2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                errorLabel.setText(currentNPC.quest2());
                errorLabel.setVisible(true);
                refresh();
            }
        });

        quest3 = new Table();
        quest3.setVisible(false);
        quest3.align(Align.left);
        status3 = new Image();
        state3 = new Label("", skin);
        state3.setColor(Color.BLACK);
        finishButton3 = new TextButton("finish", skin);
        finishButton3.setVisible(false);
        quest3.add(status3).width(80).height(80).pad(10);
        quest3.add(state3).pad(20);
        quest3.add(finishButton3).width(150).height(80);
        quest3.setPosition(Gdx.graphics.getWidth() / 2.3f, Gdx.graphics.getHeight() / 2.7f);
        finishButton3.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                errorLabel.setText(currentNPC.quest3());
                errorLabel.setVisible(true);
                refresh();
            }
        });


        stage.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                // Only handle if quest screen is visible
                if (!table1.isVisible()) {
                    return false;
                }

                if (x < 480 || x > 1430 ||
                    y < 300 || y > 820) {
                    toggle();
                    return true;
                }
                return false;
            }
        });

        stage.addActor(table1);
        stage.addActor(table2);
        stage.addActor(errorLabel);
        stage.addActor(favoriteGifts);
        stage.addActor(heartContainer);
        stage.addActor(tableInfo);
        stage.addActor(quest1);
        stage.addActor(quest2);
        stage.addActor(quest3);
    }

    public void show() {
        refresh();
        favoriteGifts.setVisible(true);
        favoriteGifts.setText(currentNPC.getName() + "'s favorites\n" + "1- "
            +  currentNPC.getFavoriteGifts().get(0) + "\n" + "2- " +
            currentNPC.getFavoriteGifts().get(1) + "\n" + "3- " +
            currentNPC.getFavoriteGifts().get(2));
        errorLabel.setVisible(false);
        visible = true;
        table1.setVisible(true);
        table2.setVisible(true);
        tableInfo.setVisible(true);
        heartContainer.setVisible(true);
        state1.setText(GameMenuController.questInfo(currentNPC, 1));
        state2.setText(GameMenuController.questInfo(currentNPC, 2));
        state3.setText(GameMenuController.questInfo(currentNPC, 3));
        quest1.setVisible(true);
        quest2.setVisible(true);
        quest3.setVisible(true);
        Gdx.input.setInputProcessor(stage);
    }

    public void render() {
        if (visible) {
            stage.act();
            stage.draw();
        }
    }

    public void hide() {
        visible = false;
        table1.setVisible(false);
        table2.setVisible(false);
        tableInfo.setVisible(false);
        heartContainer.setVisible(false);
        Gdx.input.setInputProcessor(null);
    }

    public void toggle() {
        if (visible) hide();
        else show();
    }

    public void dispose() {
        stage.dispose();
        backgroundTexture.dispose();
    }

    public void refresh() {
        updateHeartDisplay();
        updateQuestDisplay();
    }

    private void updateHeartDisplay() {
        if (currentNPC == null) return;

        heartContainer.clear();

        int friendshipLevel = App.getCurrentGame().getCurrentPlayer().getFriendshipsNPC().get(currentNPC);
        int fullHearts = friendshipLevel / 200;

        for (int i = 0; i < fullHearts; i++) {
            Image heartImage = new Image(new TextureRegionDrawable(new TextureRegion(
                GameAssetManager.assetManager.get(GameAssetManager.heart))));
            heartContainer.add(heartImage).size(36, 40).pad(2);
        }
    }

    private void updateQuestDisplay() {
        if(currentNPC.isQuest1()){
            status1.setDrawable(new TextureRegionDrawable(new TextureRegion(
                GameAssetManager.assetManager.get(GameAssetManager.questCompleted))));
            finishButton1.setVisible(false);
        } else if(App.getCurrentGame().getCurrentPlayer().getActivatedQuestNPC().get(currentNPC).contains(1)) {
            status1.setDrawable(new TextureRegionDrawable(new TextureRegion(
                GameAssetManager.assetManager.get(GameAssetManager.questTodo))));
            finishButton1.setVisible(true);
        } else {
            status1.setDrawable(new TextureRegionDrawable(new TextureRegion(
                GameAssetManager.assetManager.get(GameAssetManager.questUnavailable))));
            finishButton1.setVisible(false);
        }

        if(currentNPC.isQuest2()){
            status2.setDrawable(new TextureRegionDrawable(new TextureRegion(
                GameAssetManager.assetManager.get(GameAssetManager.questCompleted))));
            finishButton2.setVisible(false);
        } else if(App.getCurrentGame().getCurrentPlayer().getActivatedQuestNPC().get(currentNPC).contains(2)) {
            status2.setDrawable(new TextureRegionDrawable(new TextureRegion(
                GameAssetManager.assetManager.get(GameAssetManager.questTodo))));
            finishButton2.setVisible(true);
        } else {
            status2.setDrawable(new TextureRegionDrawable(new TextureRegion(
                GameAssetManager.assetManager.get(GameAssetManager.questUnavailable))));
            finishButton2.setVisible(false);
        }

        if(currentNPC.isQuest3()){
            status3.setDrawable(new TextureRegionDrawable(new TextureRegion(
                GameAssetManager.assetManager.get(GameAssetManager.questCompleted))));
            finishButton3.setVisible(false);
        } else if(App.getCurrentGame().getCurrentPlayer().getActivatedQuestNPC().get(currentNPC).contains(3)) {
            status3.setDrawable(new TextureRegionDrawable(new TextureRegion(
                GameAssetManager.assetManager.get(GameAssetManager.questTodo))));
            finishButton3.setVisible(true);
        } else {
            status3.setDrawable(new TextureRegionDrawable(new TextureRegion(
                GameAssetManager.assetManager.get(GameAssetManager.questUnavailable))));
            finishButton3.setVisible(false);
        }
    }


    private void handleMove() {
        errorLabel.setText(GameMenuController.giftNPC(currentNPC.getName(),giftTextField.getText()));
        errorLabel.setVisible(true);
    }

    public NPC getCurrentNPC() {
        return currentNPC;
    }

    public void setCurrentNPC(NPC currentNPC) {
        this.currentNPC = currentNPC;
    }

    public boolean isVisible() {
        return visible;
    }
}
