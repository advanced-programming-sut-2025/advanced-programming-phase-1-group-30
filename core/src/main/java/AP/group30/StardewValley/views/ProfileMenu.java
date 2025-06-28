package AP.group30.StardewValley.views;

import java.util.Scanner;
import java.util.regex.Matcher;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.ProfileMenuController;
import AP.group30.StardewValley.controllers.RegisterMenuController;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Commands.ProfileMenuCommands;
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

public class ProfileMenu implements Screen {
    private Stage stage;
    private Table table;
    private TextField usernameField;
    private TextField passField;
    private TextField confirmPassField;
    private Label label;
    private TextButton button;
    private TextButton backButton;
    private TextButton changePassButton;
    private Label errorLabel;
    private Label errorPassword;
    private TextField emailField;
    private TextField nicknameField;
    private CheckBox randomPassBox;
    private String randomPass = null;
    private boolean randomPassIsChecked = false;
    private Skin skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));
    private Image infoImage;
    private TextField oldPass;
    private Table tablePassword;
    private Table infoTable;
    private Label currentUsername;
    private Label currentNickname;
    private Label currentEmail;
    private Label currentGender;
    private Label currentMoney;
    private Label currentGamesPlayed;

    public ProfileMenu() {
        table = new Table(skin);
        infoTable = new Table(skin);
        tablePassword = new Table(skin);
        usernameField = new TextField(String.format(App.getCurrentUser().getUsername()), skin);
        passField = new TextField("password", skin);
        passField.setPasswordCharacter('*');
        confirmPassField = new TextField("confirm password", skin);
        confirmPassField.setPasswordCharacter('*');
        changePassButton = new TextButton("Change Password", skin);
        backButton = new TextButton("Back", skin);
        backButton.setPosition(50 , 50);
        label = new Label("Profile Menu", skin);
        label.setColor(Color.BLACK);
        button = new TextButton("Apply", skin);
        emailField = new TextField(String.format(App.getCurrentUser().getEmail()), skin);
        nicknameField = new TextField(String.format(App.getCurrentUser().getNickname()), skin);
        randomPassBox = new CheckBox("Random Password", skin);
        randomPassBox.setPosition(100 ,250);
        errorLabel = new Label("", skin);
        errorPassword = new Label("", skin);
        infoImage = new Image(new Texture("menu assets/PC Computer - Stardew Valley - Special Orders.png"));
        infoImage.setSize(infoImage.getWidth() * 3, infoImage.getHeight() * 3);
        infoImage.setPosition(1450, 600);
        oldPass = new TextField("answer", skin);
        currentUsername = new Label(String.format("Username: %s", App.getCurrentUser().getUsername()), skin);
        currentUsername.setColor(Color.BLACK);
        currentNickname = new Label(String.format("Nickname: %s", App.getCurrentUser().getNickname()), skin);
        currentNickname.setColor(Color.BLACK);
        currentEmail = new Label(String.format("Email: %s", App.getCurrentUser().getEmail()), skin);
        currentEmail.setColor(Color.BLACK);
        currentGender = new Label(String.format("Gender: %s", App.getCurrentUser().getGender()), skin);
        currentGender.setColor(Color.BLACK);
        currentMoney = new Label(String.format("Max Money: %s", App.getCurrentUser().getMaxMoney()), skin);
        currentMoney.setColor(Color.BLACK);
        currentGamesPlayed = new Label(String.format("Games Played: %s", App.getCurrentUser().getNumOfGames()), skin);
        currentGamesPlayed.setColor(Color.BLACK);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        stage.addActor(infoImage);

        infoTable.setFillParent(true);
        infoTable.setPosition(700, 300);
        infoTable.add(label);
        infoTable.row().pad(10);
        infoTable.add(currentUsername);
        infoTable.row().pad(10);
        infoTable.add(currentNickname);
        infoTable.row().pad(10);
        infoTable.add(currentEmail);
        infoTable.row().pad(10);
        infoTable.add(currentGender);
        infoTable.row().pad(10);
        infoTable.add(currentMoney);
        infoTable.row().pad(10);
        infoTable.add(currentGamesPlayed);
        infoTable.row().pad(10);
        stage.addActor(infoTable);

        tablePassword.setFillParent(true);
        tablePassword.setPosition(-500, 0);
        tablePassword.add(oldPass).width(300);
        tablePassword.row().pad(15);
        tablePassword.add(passField).width(300);
        tablePassword.row().pad(15);
        tablePassword.add(confirmPassField).width(300);
        errorPassword.setColor(Color.RED);
        errorPassword.setVisible(false);
        tablePassword.row().pad(15);
        tablePassword.add(errorLabel);
        tablePassword.row().pad(15);
        tablePassword.add(changePassButton);
        stage.addActor(tablePassword);




        table.setFillParent(true);
        table.setPosition(150,0);
        table.add(usernameField).width(300);
        table.row().pad(15);
        table.add(emailField).width(300);
        table.row().pad(15);
        table.add(nicknameField).width(300);
        table.row().pad(15);
        table.add(button);
        errorLabel.setColor(Color.RED);
        errorLabel.setVisible(false);
        table.row().pad(10);
        table.add(errorLabel);
        table.setDebug(true);
        table.center();
        stage.addActor(table);
        stage.addActor(randomPassBox);
        stage.addActor(backButton);
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

        oldPass.addListener(new ClickListener() {
            boolean cleared = false;

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    oldPass.setText("");
                    cleared = true;
                }
            }
        });

        oldPass.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && oldPass.getText().isEmpty()) {
                    oldPass.setText("answer");
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

        ProfileMenuController.checkButton(button, backButton, changePassButton, errorPassword, errorLabel, passField,
            oldPass, confirmPassField, usernameField, emailField, nicknameField);

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
//        matcher = ProfileMenuCommands.CHANGE_USERNAME.regexMatcher(command);
//        if (matcher.matches()) {
//            String username = matcher.group("username");
//
//            ProfileMenuController.ChangeUsername(username);
//            return;
//        }
//
//        matcher = ProfileMenuCommands.CHANGE_NICKNAME.regexMatcher(command);
//        if (matcher.matches()) {
//            String nickname = matcher.group("nickname");
//
//            ProfileMenuController.ChangeNickname(nickname);
//            return;
//        }
//
//        matcher = ProfileMenuCommands.CHANGE_EMAIL.regexMatcher(command);
//        if (matcher.matches()) {
//            String email = matcher.group("email");
//
//            ProfileMenuController.ChangeEmail(email);
//            return;
//        }
//
//        matcher = ProfileMenuCommands.CHANGE_PASSWORD.regexMatcher(command);
//        if (matcher.matches()) {
//            String newPassword = matcher.group("newPassword");
//            String oldPassword = matcher.group("oldPassword");
//
//            ProfileMenuController.ChangePassword(newPassword, oldPassword);
//            return;
//        }
//
//        matcher = ProfileMenuCommands.USER_INFO.regexMatcher(command);
//        if (matcher.matches()) {
//            ProfileMenuController.UserInfo();
//            return;
//        }
//        System.out.println("Invalid command");
//    }
}
