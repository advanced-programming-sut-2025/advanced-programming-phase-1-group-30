package AP.group30.StardewValley.views;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.RegisterMenuController;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Users.RegisterQuestions;
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

public class RegisterMenu implements Screen {
    private Stage stage;
    private final Table table;
    private final TextField usernameField;
    private final TextField passField;
    private final TextField confirmPassField;
    private final Label titleLabel;
    private final SelectBox<String> questionBox;
    private final TextField answerField;
    private final TextButton signupButton;
    private final TextButton goToLoginButton;
    private static Label errorLabel;
    private final TextField emailField;
    private final TextField nicknameField;
    private final SelectBox<String> genderBox;
    private final CheckBox randomPassBox;
    private boolean randomPassIsChecked = false;

    public RegisterMenu() {
        Skin skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));
        table = new Table(skin);
        usernameField = new TextField("username", skin);
        passField = new TextField("password", skin);
        confirmPassField = new TextField("confirm password", skin);
        passField.setPasswordCharacter('*');
        confirmPassField.setPasswordCharacter('*');
        titleLabel = new Label("Register Menu", skin);
        signupButton = new TextButton("Sign Up", skin);
        goToLoginButton = new TextButton("Go to Login Menu", skin);
        emailField = new TextField("email", skin);
        nicknameField = new TextField("nickname", skin);
        genderBox = new SelectBox<>(skin);
        genderBox.setItems("Male", "Female");
        randomPassBox = new CheckBox("Random Password", skin);
        questionBox = new SelectBox<>(skin);
        questionBox.setItems(RegisterQuestions.getQuestions());
        answerField = new TextField("answer", skin);
        errorLabel = new Label("", skin);
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
        table.row().pad(10);
        table.add(usernameField).width(300);
        table.row().pad(10);
        table.add(passField).width(300);
        table.add(randomPassBox).left().padLeft(10);
        stage.addActor(randomPassBox);
        table.row().pad(10);
        table.add(confirmPassField).width(300);
        table.row().pad(10);
        table.add(emailField).width(300);
        table.row().pad(10);
        table.add(nicknameField).width(300);
        table.row().pad(10);
        table.add(questionBox).width(300);
        table.row().pad(10);
        table.add(answerField).width(300);
        table.row().pad(10);
        table.add(genderBox).width(300);
        table.row().pad(10);
        table.add(signupButton);
        table.row().pad(10);
        table.add(goToLoginButton);
        table.row().pad(10);
        table.add(errorLabel);

        table.center();
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);

        Main.batch.begin();
        Main.batch.draw(GameAssetManager.assetManager.get("menu assets/loading screen.png", Texture.class), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Main.batch.end();

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

        emailField.addListener(new ClickListener() {
            boolean cleared = false;

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    emailField.setText("");
                    cleared = true;
                }
            }
        });

        emailField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && emailField.getText().isEmpty()) {
                    emailField.setText("email");
                }
            }
        });

        answerField.addListener(new ClickListener() {
            boolean cleared = false;

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    answerField.setText("");
                    cleared = true;
                }
            }
        });

        answerField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && answerField.getText().isEmpty()) {
                    answerField.setText("answer");
                }
            }
        });

        nicknameField.addListener(new ClickListener() {
            boolean cleared = false;

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    nicknameField.setText("");
                    cleared = true;
                }
            }
        });

        nicknameField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && nicknameField.getText().isEmpty()) {
                    nicknameField.setText("nickname");
                }
            }
        });

        confirmPassField.addListener(new ClickListener() {
            boolean cleared = false;

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    confirmPassField.setText("");
                    confirmPassField.setPasswordMode(true);
                    cleared = true;
                }
            }
        });

        confirmPassField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && confirmPassField.getText().isEmpty()) {
                    confirmPassField.setText("confirm password");
                    confirmPassField.setPasswordMode(false);
                }
            }
        });

        if (randomPassBox.isChecked() && !randomPassIsChecked) {
            passField.setText(RegisterMenuController.RandomPasswordGenerator());
            passField.setPasswordMode(false);
            confirmPassField.setText(passField.getText());
            confirmPassField.setPasswordMode(false);
            randomPassIsChecked = true;
        }
        if (!randomPassBox.isChecked() && randomPassIsChecked) {
            randomPassIsChecked = false;
        }

        signupButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                int result = RegisterMenuController.register(usernameField.getText(), passField.getText(),
                        confirmPassField.getText(), emailField.getText(), nicknameField.getText(),
                        genderBox.getSelected(), answerField.getText(), questionBox.getSelected());
                if (result == 1) {
                    Main.getMain().setScreen(new
                            LoginMenu(GameAssetManager.assetManager.get("skin/pixthulhu-ui.json",
                            Skin.class)));
                }
            }
        });

        goToLoginButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getMain().setScreen(new
                    LoginMenu(GameAssetManager.assetManager.get("skin/pixthulhu-ui.json",
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
//    @Override
//    public void check(String command, Scanner scanner) {
//        Matcher matcher;
//
//        matcher = RegisterMenuCommands.MENU_ENTER.regexMatcher(command);
//        if (matcher.matches()) {
//            String menuName = matcher.group("menuName");
//
//            RegisterMenuController.ChangeMenu(menuName);
//            return;
//        }
//        matcher = RegisterMenuCommands.LOADMAP.regexMatcher(command);
//        if (matcher.matches()) {
//            MaintainerController.loadMap();
//            return;
//        }
//
//        matcher = RegisterMenuCommands.MENU_EXIT.regexMatcher(command);
//        if (matcher.matches()) {
//            RegisterMenuController.Exit();
//            return;
//        }
//
//        matcher = RegisterMenuCommands.SHOW_CURRENT_MENU.regexMatcher(command);
//        if (matcher.matches()) {
//            RegisterMenuController.ShowCurrentMenu();
//            return;
//        }
//
//        matcher = RegisterMenuCommands.REGISTER.regexMatcher(command);
//        if (matcher.matches()) {
//            RegisterMenuController.register(matcher, scanner);
//            return;
//        }
//        System.out.println("Invalid command");
//    }

}
