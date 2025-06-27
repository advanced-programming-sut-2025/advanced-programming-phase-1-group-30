package AP.group30.StardewValley.views;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.LoginMenuController;
import AP.group30.StardewValley.models.GameAssetManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenu implements Screen {
    private Stage stage;
    private final Table table;
    private final TextField usernameField;
    private final TextField passField;
    private final TextButton loginButton;
    private final Label errorLabel;
    private final Label titleLabel;

    public MainMenu(Skin skin) {
        table = new Table(skin);
        usernameField = new TextField("username", skin);
        passField = new TextField("password", skin);
        passField.setPasswordCharacter('*');
        titleLabel = new Label("Login Menu", skin);
        loginButton = new TextButton("Login", skin);
        errorLabel = new Label("", skin);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        table.add(titleLabel);
        table.row().pad(15);
        table.add(usernameField).width(300);
        table.row().pad(15);
        table.add(passField).width(300);
        table.add(loginButton);
        errorLabel.setColor(Color.RED);
        errorLabel.setVisible(false);
        table.row().pad(10);
        table.add(errorLabel);
        table.setDebug(true);
        table.center();
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);

        int width = Gdx.graphics.getWidth();
        int height = Gdx.graphics.getHeight();

        Main.batch.begin();
        Main.batch.draw(GameAssetManager.assetManager.get("menu assets/loading screen.png", Texture.class), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Main.batch.end();

        usernameField.addListener(new ClickListener() {
            boolean cleared = false;

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    usernameField.setText("");
                    cleared = true;
                }
            }
        });

        usernameField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && usernameField.getText().isEmpty()) {
                    usernameField.setColor(Color.GRAY);
                    usernameField.setText("username");
                    usernameField.setColor(Color.BLACK);
                }
            }
        });

        passField.addListener(new ClickListener() {
            boolean cleared = false;

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    passField.setText("");
                    passField.setPasswordMode(true);
                    cleared = true;
                }
            }
        });

        passField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && passField.getText().isEmpty()) {
                    usernameField.setColor(Color.GRAY);
                    usernameField.setText("password");
                    usernameField.setColor(Color.BLACK);
                    passField.setPasswordMode(false);
                }
            }
        });

        loginButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean result = LoginMenuController.Login(usernameField.getText(), passField.getText(), true);
                if (result) {
                    Main.getMain().setScreen(new MainMenu(GameAssetManager.assetManager.get("skin/pixthulhu-ui.json", Skin.class)));
                }
            }
        });

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
