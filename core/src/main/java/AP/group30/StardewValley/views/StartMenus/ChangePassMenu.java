package AP.group30.StardewValley.views.StartMenus;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.LoginMenuController;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Users.User;
import AP.group30.StardewValley.views.LoadingScreen;
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

public class ChangePassMenu implements Screen {
    private Stage stage;
    private final Table table;
    private final Label titleLabel;
    private final TextField usernameField;
    private final Label questionLabel;
    private final TextField answerField;
    private final TextButton verifyButton;
    private final TextButton changePassButton;
    private static Label errorLabel;
    private final TextField passField;
    private final TextField confirmPassField;
    private Texture background;

    public ChangePassMenu(Skin skin) {
        table = new Table(skin);
        usernameField = new TextField("username", skin);
        questionLabel = new Label("", skin);
        questionLabel.setVisible(false);
        answerField = new TextField("answer", skin);
        answerField.setVisible(false);
        titleLabel = new Label("Verify Menu", skin);
        verifyButton = new TextButton("Search User", skin);
        changePassButton = new TextButton("Change My Password", skin);
        changePassButton.setVisible(false);
        errorLabel = new Label("", skin);
        passField = new TextField("New Password", skin);
        passField.setVisible(false);
        confirmPassField = new TextField("Confirm New Password", skin);
        confirmPassField.setVisible(false);
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
        if (LoadingScreen.time.getHour() <= 11) {
            background = GameAssetManager.assetManager.get(GameAssetManager.background);
        } else {
            background = GameAssetManager.assetManager.get(GameAssetManager.nightBackground);
        }

        titleLabel.setColor(Color.BLACK);
        questionLabel.setColor(Color.BLACK);

        table.add(titleLabel);
        table.row().pad(15);
        table.add(usernameField).width(300);
        table.row().pad(15);
        table.add(questionLabel).width(300);
        table.row().pad(15);
        table.add(answerField).width(300);
        table.row().pad(15);
        table.add(passField).width(300);
        table.row().pad(15);
        table.add(confirmPassField).width(300);
        table.row().pad(15);
        table.add(verifyButton);
        table.row().pad(15);
        table.add(changePassButton);
        table.row().pad(15);
        table.add(errorLabel);

        table.center();
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);

        final boolean[] userVerified = {false};

        Main.batch.begin();
        Main.batch.draw(background,
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

        answerField.addListener(new ClickListener() {
            boolean cleared = false;

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    answerField.setText("");
                    answerField.setPasswordMode(true);
                    cleared = true;
                }
            }
        });

        answerField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && answerField.getText().isEmpty()) {
                    answerField.setText("answer");
                    answerField.setPasswordMode(false);
                }
            }
        });

        passField.addListener(new ClickListener() {
            boolean cleared = false;

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    passField.setText("");
                    cleared = true;
                }
            }
        });

        passField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && passField.getText().isEmpty()) {
                    passField.setText("New Password");
                }
            }
        });

        confirmPassField.addListener(new ClickListener() {
            boolean cleared = false;

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    confirmPassField.setText("");
                    cleared = true;
                }
            }
        });

        confirmPassField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && confirmPassField.getText().isEmpty()) {
                    confirmPassField.setText("Confirm New Password");
                }
            }
        });

        verifyButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!userVerified[0]) {
                    User user = LoginMenuController.userVerify(usernameField.getText());
                    if (user != null) {
                        usernameField.setVisible(false);
                        questionLabel.setVisible(true);
                        answerField.setVisible(true);

                        questionLabel.setText(user.getQuestion().getQuestion());
                        verifyButton.setText("Verify");

                        userVerified[0] = true;
                    }
                }
                else {
                    if (LoginMenuController.answerQuestion(usernameField.getText(), answerField.getText())) {
                        questionLabel.setVisible(false);
                        answerField.setVisible(false);
                        verifyButton.setVisible(false);

                        passField.setVisible(true);
                        confirmPassField.setVisible(true);
                        changePassButton.setVisible(true);
                    }
                }

            }
        });

        changePassButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (LoginMenuController.changePassword(usernameField.getText(), passField.getText(),
                    confirmPassField.getText()))
                    Main.getMain().setScreen(new
                        MainMenu(GameAssetManager.assetManager.get("skin/pixthulhu-ui.json", Skin.class)));
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
