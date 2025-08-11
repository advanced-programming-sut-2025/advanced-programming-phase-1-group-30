package AP.group30.StardewValley.views.InGameMenus;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Game;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.network.MessageClasses.MapTransfer;
import AP.group30.StardewValley.network.MessageClasses.Reaction;
import AP.group30.StardewValley.views.CityScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import org.w3c.dom.Text;

import java.util.SortedMap;

public class ReactionMenu implements Screen {
    private Skin skin;
    private Stage stage;
    private boolean visible = false;
    private Table emotes;
    private Table table1;
    private Table table2;
    private Texture backgroundTexture;
    private SpriteBatch batch;
    private ImageButton happyButton;
    private ImageButton sadButton;
    private ImageButton angryButton;
    private ImageButton heartButton;
    private ImageButton yesButton;
    private ImageButton noButton;
    private TextField chat;
    private TextButton sendButton;
    private Label errorLabel;

    public ReactionMenu(SpriteBatch batch, Skin skin) {
        this.skin = skin;
        this.batch = batch;

        this.stage = new Stage(new ScreenViewport(), batch);

        backgroundTexture = GameAssetManager.assetManager.get(GameAssetManager.reaction);
        Texture happy = GameAssetManager.assetManager.get(GameAssetManager.happyEmote);
        Texture sad = GameAssetManager.assetManager.get(GameAssetManager.sadEmote);
        Texture angry = GameAssetManager.assetManager.get(GameAssetManager.angryEmote);
        Texture heart = GameAssetManager.assetManager.get(GameAssetManager.heartEmote);
        Texture yes = GameAssetManager.assetManager.get(GameAssetManager.yesEmote);
        Texture no = GameAssetManager.assetManager.get(GameAssetManager.noEmote);

        table1 = new Table();
        table1.setVisible(false);
        table1.setBackground(new TextureRegionDrawable(new TextureRegion(backgroundTexture)));
        table1.setSize(600, 600);
        table1.setPosition(
            (Gdx.graphics.getWidth() - backgroundTexture.getWidth()) / 2.3f,
            (Gdx.graphics.getHeight() - backgroundTexture.getHeight()) / 2.2f
        );
        stage.addActor(table1);


        happyButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(happy)));
        happyButton.getImage().setScaling(Scaling.fit);
        happyButton.getImageCell().size(50, 50);
        sadButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(sad)));
        sadButton.getImage().setScaling(Scaling.fit);
        sadButton.getImageCell().size(50, 50);
        angryButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(angry)));
        angryButton.getImage().setScaling(Scaling.fit);
        angryButton.getImageCell().size(50, 50);
        heartButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(heart)));
        heartButton.getImage().setScaling(Scaling.fit);
        heartButton.getImageCell().size(50, 50);
        yesButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(yes)));
        yesButton.getImage().setScaling(Scaling.fit);
        yesButton.getImageCell().size(50, 50);
        noButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(no)));
        noButton.getImage().setScaling(Scaling.fit);
        noButton.getImageCell().size(50, 50);



        emotes = new Table();
        emotes.setVisible(false);
        emotes.setPosition((stage.getWidth() - backgroundTexture.getWidth()) / 2.1f,
            stage.getHeight()/ 1.8f);
        emotes.add(happyButton).pad(20);
        emotes.row();
        emotes.add(sadButton).pad(20);
        emotes.row();
        emotes.add(heartButton).pad(20);
        emotes.row();
        emotes.add(angryButton).pad(20);
        emotes.row();
        emotes.add(yesButton).pad(20);
        emotes.row();
        emotes.add(noButton).pad(20);

        stage.addActor(emotes);

        if (happyButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                toggle();
                CityScreen.showReaction(App.getCurrentGame().getCurrentPlayer(), "happy");
                Reaction r = new Reaction();
                r.playerId    = String.valueOf(Main.getMain().id);
                r.reaction = "happy";
                App.getNetworkClient().send(r);
            }
        }));
        if (sadButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                toggle();
                CityScreen.showReaction(App.getCurrentGame().getCurrentPlayer(), "sad");
                Reaction r = new Reaction();
                r.playerId    = String.valueOf(Main.getMain().id);
                r.reaction = "sad";
                App.getNetworkClient().send(r);
            }
        }));
        if (heartButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                toggle();
                CityScreen.showReaction(App.getCurrentGame().getCurrentPlayer(), "heart");
                Reaction r = new Reaction();
                r.playerId    = String.valueOf(Main.getMain().id);
                r.reaction = "heart";
                App.getNetworkClient().send(r);
            }
        }));
        if (angryButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                toggle();
                CityScreen.showReaction(App.getCurrentGame().getCurrentPlayer(), "angry");
                Reaction r = new Reaction();
                r.playerId    = String.valueOf(Main.getMain().id);
                r.reaction = "angry";
                App.getNetworkClient().send(r);
            }
        }));
        if (yesButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                toggle();
                CityScreen.showReaction(App.getCurrentGame().getCurrentPlayer(), "yes");
                Reaction r = new Reaction();
                r.playerId    = String.valueOf(Main.getMain().id);
                r.reaction = "yes";
                App.getNetworkClient().send(r);
            }
        }));
        if (noButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                toggle();
                CityScreen.showReaction(App.getCurrentGame().getCurrentPlayer(), "no");
                Reaction r = new Reaction();
                r.playerId    = String.valueOf(Main.getMain().id);
                r.reaction = "no";
                App.getNetworkClient().send(r);
            }
        }));


        table2 = new Table();
        table2.setVisible(false);
        table2.setPosition((stage.getWidth()) / 1.8f,
            stage.getHeight()/ 1.8f);
        chat = new TextField("", skin);
        table2.add(chat).width(300).pad(20);
        table2.row();
        sendButton = new TextButton("Send", skin);
        table2.add(sendButton).pad(50);
        table2.row();
        errorLabel = new Label("", skin);
        errorLabel.setVisible(false);
        table2.add(errorLabel).pad(20);
        stage.addActor(table2);

        if (sendButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (chat.getText().length() > 10) {
                    errorLabel.setVisible(true);
                    errorLabel.setColor(Color.RED);
                    errorLabel.setText("Too long!");
                } else if (chat.getText().isEmpty()) {
                    errorLabel.setVisible(true);
                    errorLabel.setColor(Color.RED);
                    errorLabel.setText("It can't be empty");
                } else {
                    toggle();
                    CityScreen.showReaction(App.getCurrentGame().getCurrentPlayer(), chat.getText());
                    Reaction r = new Reaction();
                    r.playerId    = String.valueOf(Main.getMain().id);
                    r.reaction = chat.getText();
                    App.getNetworkClient().send(r);
                }
            }
        }));
    }

    @Override
    public void show() {
        visible = true;
        table1.setVisible(true);
        emotes.setVisible(true);
        table2.setVisible(true);
        errorLabel.setVisible(false);
        chat.setText("");
        Gdx.input.setInputProcessor(stage);
    }


    public void render() {
        if (visible) {
            stage.act();
            stage.draw();
        }
    }

    @Override
    public void render(float v) {

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        visible = false;
        emotes.setVisible(false);
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        stage.dispose();
        backgroundTexture.dispose();
    }

    public void toggle() {
        System.out.println("tol");
        if (visible) hide();
        else show();
    }

    public boolean isVisible() {
        return visible;
    }
}
