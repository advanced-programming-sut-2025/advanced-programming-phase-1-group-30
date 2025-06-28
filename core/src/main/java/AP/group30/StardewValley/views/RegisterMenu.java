package AP.group30.StardewValley.views;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.MaintainerController;
import AP.group30.StardewValley.controllers.RegisterMenuController;
import AP.group30.StardewValley.models.Commands.RegisterMenuCommands;
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
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class RegisterMenu implements Screen {
    private Stage stage;
    private Table table;
    private TextField usernameField;
    private TextField passField;
    private TextField confirmPassField;
    private Label label;
    private Label question;
    private TextField answerField;
    private TextButton button;
    private Label errorLabel;
    private TextField emailField;
    private TextField nicknameField;
    private SelectBox<String> genderBox;
    private CheckBox randomPassBox;
    private String randomPass = null;
    private boolean randomPassIsChecked = false;
    private Skin skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));

    public RegisterMenu() {
        table = new Table(skin);
        usernameField = new TextField("username", skin);
        passField = new TextField("password", skin);
        confirmPassField = new TextField("confirm password", skin);
        passField.setPasswordCharacter('*');
        confirmPassField.setPasswordCharacter('*');
        label = new Label("Register Menu", skin);
        button = new TextButton("Sign Up", skin);
        emailField = new TextField("email", skin);
        nicknameField = new TextField("nickname", skin);
        genderBox = new SelectBox<>(skin);
        genderBox.setItems("Male", "Female");
        randomPassBox = new CheckBox("Random Password", skin);
        question = new Label("What is your favorite farm animal?", skin);
        question.setColor(Color.BLACK);
        answerField = new TextField("answer", skin);
        errorLabel = new Label("", skin);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        table.add(label);
        table.row().pad(15);
        table.add(usernameField).width(300);
        table.row().pad(15);
        table.add(passField).width(300);
        table.add(randomPassBox).left().padLeft(10);
        stage.addActor(randomPassBox);
        table.row().pad(15);
        table.add(confirmPassField).width(300);
        table.row().pad(15);
        table.add(emailField).width(300);
        table.row().pad(15);
        table.add(nicknameField).width(300);
        table.row().pad(15);
        table.add(question);
        table.row().pad(15);
        table.add(answerField).width(300);
        table.row().pad(15);
        table.add(genderBox).width(300);
        table.row().pad(15);
        table.add(button);
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

        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                int result = RegisterMenuController.register(button, usernameField, passField, confirmPassField,
                    emailField, nicknameField, errorLabel, genderBox.getSelected(), answerField);
                if (result == 1) {
                    Main.getMain().setScreen(new LoginMenu(skin));
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
