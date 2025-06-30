package AP.group30.StardewValley.views;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.LoginMenuController;
import AP.group30.StardewValley.models.GameAssetManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetDescriptor;
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

public class LoginMenu implements Screen {
    private Stage stage;
    private final Table table;
    private final Label titleLabel;
    private final TextField usernameField;
    private final TextField passField;
    private final TextButton loginButton;
    private final TextButton gotoRegisterMenuButton;
    private final TextButton forgotPassButton;
    private static Label errorLabel;
    private final CheckBox stayLoggedInBox;

    public LoginMenu(Skin skin) {
        table = new Table(skin);
        usernameField = new TextField("username", skin);
        passField = new TextField("password", skin);
        passField.setPasswordCharacter('*');
        titleLabel = new Label("Login Menu", skin);
        loginButton = new TextButton("Login", skin);
        gotoRegisterMenuButton = new TextButton("Goto Register Menu", skin);
        forgotPassButton = new TextButton("Forgot My Password", skin);
        errorLabel = new Label("", skin);
        stayLoggedInBox = new CheckBox("Stay Logged in", skin);
    }

    public static void printResult(String message) {
        errorLabel.setVisible(true);
        errorLabel.setText(message);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);

        errorLabel.setColor(Color.RED);
        errorLabel.setVisible(false);

        titleLabel.setColor(Color.BLACK);

        table.add(titleLabel);
        table.row().pad(15);
        table.add(usernameField).width(300);
        table.row().pad(15);
        table.add(passField).width(300);
        table.row().pad(15);
        table.add(loginButton);
        table.row().pad(15);
        table.add(forgotPassButton);
        table.row().pad(15);
        table.add(gotoRegisterMenuButton);
        table.row().pad(15);
        table.add(stayLoggedInBox);
        table.row().pad(15);
        table.add(errorLabel);

        table.center();
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);

        Main.batch.begin();
        Main.batch.draw(GameAssetManager.assetManager.get("menu assets/loading screen.png", Texture.class),
                0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
                    usernameField.setText("username");
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
                    passField.setText("password");
                    passField.setPasswordMode(false);
                }
            }
        });

        loginButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean result = LoginMenuController.Login(usernameField.getText(), passField.getText(),
                        stayLoggedInBox.isChecked());
                if (result) {
                    Main.getMain().setScreen(new
                            MainMenu(GameAssetManager.assetManager.get("skin/pixthulhu-ui.json",
                            Skin.class)));
                }
            }
        });

        gotoRegisterMenuButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getMain().setScreen(new LoadingScreen(new RegisterMenu(), Main.getBackground(), Main.getMenuSkin()));
            }
        });

        forgotPassButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getMain().setScreen(new
                        ChangePassMenu(GameAssetManager.assetManager.get("skin/pixthulhu-ui.json",
                        Skin.class)));
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
