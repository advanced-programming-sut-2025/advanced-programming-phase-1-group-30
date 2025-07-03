package AP.group30.StardewValley.views;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.ProfileMenuController;
import AP.group30.StardewValley.controllers.RegisterMenuController;
import AP.group30.StardewValley.models.App;
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
    private final Table table;
    private final TextField usernameField;
    private final TextField newPassField;
    private final TextField confirmPassField;
    private final Label titleLabel;
    private final TextButton applyButton;
    private final TextButton backButton;
    private final TextButton changePassButton;
    private static Label errorInfoLabel;
    private static Label errorPasswordLabel;
    private final TextField emailField;
    private final TextField nicknameField;
    private final CheckBox randomPassBox;
    private boolean randomPassIsChecked = false;
    private final Image infoImage;
    private final TextField oldPassField;
    private final Table tablePassword;
    private final Table infoTable;
    private final Label currentUsernameLabel;
    private final Label currentNicknameLabel;
    private final Label currentEmailLabel;
    private final Label currentGenderLabel;
    private final Label currentMoneyLabel;
    private final Label currentGamesPlayedLabel;
    private Texture background;

    public ProfileMenu(Skin skin) {
        table = new Table(skin);
        infoTable = new Table(skin);
        tablePassword = new Table(skin);
        usernameField = new TextField(String.format(App.getCurrentUser().getUsername()), skin);
        newPassField = new TextField("new password", skin);
        newPassField.setPasswordCharacter('*');
        confirmPassField = new TextField("confirm new password", skin);
        confirmPassField.setPasswordCharacter('*');
        changePassButton = new TextButton("Change Password", skin);
        backButton = new TextButton("Back", skin);
        backButton.setPosition(50 , 50);
        titleLabel = new Label("Profile Menu", skin);
        titleLabel.setColor(Color.BLACK);
        applyButton = new TextButton("Apply", skin);
        emailField = new TextField(String.format(App.getCurrentUser().getEmail()), skin);
        nicknameField = new TextField(String.format(App.getCurrentUser().getNickname()), skin);
        randomPassBox = new CheckBox("Random Password", skin);
        randomPassBox.setPosition(100 ,250);
        errorInfoLabel = new Label("", skin);
        errorPasswordLabel = new Label("", skin);
        infoImage = new Image(new Texture("menu assets/PC Computer - Stardew Valley - Special Orders.png"));
        infoImage.setSize(infoImage.getWidth() * 3, infoImage.getHeight() * 3);
        infoImage.setPosition(1450, 600);
        oldPassField = new TextField("password", skin);
        currentUsernameLabel = new Label(String.format("Username: %s", App.getCurrentUser().getUsername()), skin);
        currentUsernameLabel.setColor(Color.BLACK);
        currentNicknameLabel = new Label(String.format("Nickname: %s", App.getCurrentUser().getNickname()), skin);
        currentNicknameLabel.setColor(Color.BLACK);
        currentEmailLabel = new Label(String.format("Email: %s", App.getCurrentUser().getEmail()), skin);
        currentEmailLabel.setColor(Color.BLACK);
        currentGenderLabel = new Label(String.format("Gender: %s", App.getCurrentUser().getGender()), skin);
        currentGenderLabel.setColor(Color.BLACK);
        currentMoneyLabel = new Label(String.format("Max Money: %s", App.getCurrentUser().getMaxMoney()), skin);
        currentMoneyLabel.setColor(Color.BLACK);
        currentGamesPlayedLabel = new Label(String.format("Games Played: %s", App.getCurrentUser().getNumOfGames()), skin);
        currentGamesPlayedLabel.setColor(Color.BLACK);
    }

    public static void printResultInfo(String result) {
        errorInfoLabel.setText(result);
    }
    public static void printResultPassword(String result) {
        errorPasswordLabel.setText(result);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        stage.addActor(infoImage);
        if (LoadingScreen.time.getHour() <= 11) {
            background = GameAssetManager.assetManager.get(GameAssetManager.background);
        } else {
            background = GameAssetManager.assetManager.get(GameAssetManager.nightBackground);
        }

        infoTable.setFillParent(true);
        tablePassword.setFillParent(true);
        table.setFillParent(true);

        infoTable.setPosition(700, 300);
        tablePassword.setPosition(-500, 0);
        table.setPosition(150,0);

        infoTable.add(titleLabel);
        infoTable.row().pad(10);
        infoTable.add(currentUsernameLabel);
        infoTable.row().pad(10);
        infoTable.add(currentNicknameLabel);
        infoTable.row().pad(10);
        infoTable.add(currentEmailLabel);
        infoTable.row().pad(10);
        infoTable.add(currentGenderLabel);
        infoTable.row().pad(10);
        infoTable.add(currentMoneyLabel);
        infoTable.row().pad(10);
        infoTable.add(currentGamesPlayedLabel);
        infoTable.row().pad(10);

        tablePassword.add(oldPassField).width(300);
        tablePassword.row().pad(15);
        tablePassword.add(newPassField).width(300);
        tablePassword.row().pad(15);
        tablePassword.add(confirmPassField).width(300);
        tablePassword.row().pad(15);
        tablePassword.add(errorInfoLabel);
        tablePassword.row().pad(15);
        tablePassword.add(changePassButton);

        table.add(usernameField).width(300);
        table.row().pad(15);
        table.add(emailField).width(300);
        table.row().pad(15);
        table.add(nicknameField).width(300);
        table.row().pad(15);
        table.add(applyButton);
        table.row().pad(10);
        table.add(errorInfoLabel);
        table.center();

        errorPasswordLabel.setColor(Color.RED);
        errorInfoLabel.setColor(Color.RED);

        stage.addActor(infoTable);
        stage.addActor(tablePassword);
        stage.addActor(table);
        stage.addActor(randomPassBox);
        stage.addActor(backButton);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);

        Main.batch.begin();
        Main.batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Main.batch.end();

        newPassField.addListener(new ClickListener() {
            boolean cleared = false;

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    newPassField.setText("");
                    newPassField.setPasswordMode(true);
                    cleared = true;
                }
            }
        });

        newPassField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && newPassField.getText().isEmpty()) {
                    newPassField.setText("password");
                    newPassField.setPasswordMode(false);
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

        oldPassField.addListener(new ClickListener() {
            boolean cleared = false;

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    oldPassField.setText("");
                    cleared = true;
                }
            }
        });

        oldPassField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && oldPassField.getText().isEmpty()) {
                    oldPassField.setText("answer");
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
                    usernameField.setText(String.format(App.getCurrentUser().getUsername()));
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
                    emailField.setText(String.format(App.getCurrentUser().getEmail()));
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
                    nicknameField.setText(String.format(App.getCurrentUser().getNickname()));
                }
            }
        });

        if (randomPassBox.isChecked() && !randomPassIsChecked) {
            newPassField.setText(RegisterMenuController.RandomPasswordGenerator());
            newPassField.setPasswordMode(false);
            confirmPassField.setText(newPassField.getText());
            confirmPassField.setPasswordMode(false);
            randomPassIsChecked = true;
        }
        if (!randomPassBox.isChecked() && randomPassIsChecked) {
            randomPassIsChecked = false;
        }

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getMain().setScreen(new
                    MainMenu(GameAssetManager.assetManager.get("skin/pixthulhu-ui.json", Skin.class)));
            }
        });

        applyButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ProfileMenuController.changeInfo(usernameField.getText(), emailField.getText(),
                    nicknameField.getText());

                currentUsernameLabel.setText(String.format("Username: %s", App.getCurrentUser().getUsername()));
                currentNicknameLabel.setText(String.format("Nickname: %s", App.getCurrentUser().getNickname()));
                currentEmailLabel.setText(String.format("Email: %s", App.getCurrentUser().getEmail()));

                usernameField.setText(String.format(App.getCurrentUser().getUsername()));
                emailField.setText(String.format(App.getCurrentUser().getEmail()));
                nicknameField.setText(String.format(App.getCurrentUser().getNickname()));
            }
        });

        changePassButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ProfileMenuController.changePass(oldPassField.getText(), newPassField.getMessageText(),
                    confirmPassField.getText());
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
