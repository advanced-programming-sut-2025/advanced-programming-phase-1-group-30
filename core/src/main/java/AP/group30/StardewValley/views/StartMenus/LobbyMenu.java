package AP.group30.StardewValley.views.StartMenus;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.LobbyManagerController;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Lobby;
import AP.group30.StardewValley.models.Users.RegisterQuestions;
import AP.group30.StardewValley.models.Users.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LobbyMenu implements Screen {
    private Stage stage;
    private final Table table;
    private final Label titleLabel;
    private final TextButton backButton;
    private final TextButton startGameButton;

    private final TextField userFindField;
    private final TextButton findButton;

    private final Label errorLabel;
    private final Lobby lobby;

    private final Map<String, Image> playerImages = new HashMap<>();
    private final Map<String, Label> playerLabels = new HashMap<>();
    private final ArrayList<Texture> playerTextures = new ArrayList<>();

    private Animation<TextureRegion> playerAnimation;
    private float stateTime = 0;

    private final Skin skin;

    public LobbyMenu(Skin skin) {
        this.skin = skin;
        lobby = App.getCurrentLobby();

        table = new Table(skin);
        titleLabel = new Label("Lobby: " + lobby.getLobbyID(), skin);

        backButton = new TextButton("Back", skin);
        startGameButton = new TextButton("Start", skin);
        startGameButton.setVisible(false);

        userFindField = new TextField("Username", skin);
        findButton = new TextButton("Find User", skin);

        errorLabel = new Label("", skin);
        errorLabel.setVisible(false);
        errorLabel.setColor(Color.RED);

        loadPlayerAnimation();
    }

    private void loadPlayerAnimation() {
        Texture t1 = new Texture(Gdx.files.internal("Lobby/1.png"));
        Texture t2 = new Texture(Gdx.files.internal("Lobby/2.png"));
        Texture t3 = new Texture(Gdx.files.internal("Lobby/3.png"));
        Texture t4 = new Texture(Gdx.files.internal("Lobby/4.png"));

        playerTextures.add(t1);
        playerTextures.add(t2);
        playerTextures.add(t3);
        playerTextures.add(t4);

        playerAnimation = new Animation<>(
            0.2f,
            new TextureRegion(t1),
            new TextureRegion(t2),
            new TextureRegion(t3),
            new TextureRegion(t4)
        );
        playerAnimation.setPlayMode(Animation.PlayMode.LOOP);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);

        titleLabel.setColor(Color.BLACK);

        table.add(titleLabel);
        table.row().pad(15);
        table.add(userFindField).width(300);
        table.add(findButton);
        table.row().pad(15);
        table.add(backButton);
        table.row().pad(15);
        table.add(startGameButton);
        table.row().pad(15);
        table.add(errorLabel);

        table.center();
        stage.addActor(table);

        if (!App.getCurrentUser().equals(App.getCurrentLobby().getAdmin())) {
            userFindField.setVisible(false);
            findButton.setVisible(false);
        }

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.setCurrentLobby(null);
                Main.getMain().setScreen(new MainMenu(Main.getMain().skin));
            }
        });

        startGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getMain().setScreen(new PreGameMenu(Main.getMain().skin, lobby));
            }
        });

        findButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                int result = LobbyManagerController.addUser(userFindField.getText());

                if (result == 0) {
                    errorLabel.setVisible(true);
                    errorLabel.setText("User not found!");
                } else if (result == 1) {
                    errorLabel.setVisible(true);
                    errorLabel.setText("You Can't Choose Yourself!");
                } else if (result == 2) {
                    errorLabel.setVisible(true);
                    errorLabel.setText("User Already in Game!");
                } else if (result == 3) {
                    errorLabel.setVisible(true);
                    errorLabel.setText("User Already Exists!");
                } else if (result == 4) {
                    errorLabel.setVisible(false);
                    errorLabel.setText("");

                    List<User> users = lobby.getUsers();
                    User newUser = users.getLast();
                    addUserToStage(newUser, users.size() - 1);
                }
            }
        });

        int index = 0;
        for (User user : lobby.getUsers()) {
            Label nameLabel = new Label(user.getUsername(), skin);
            nameLabel.setColor(Color.WHITE);

            Image animImage = new Image(playerAnimation.getKeyFrame(0));

            Table playerTable = new Table();
            playerTable.add(nameLabel).padBottom(5).row();
            playerTable.add(animImage).size(128, 128);

            float x = 600 + (index * 250);
            float y = 200;

            playerTable.setPosition(x, y);
            playerTable.setTransform(true);
            stage.addActor(playerTable);

            playerImages.put(user.getUsername(), animImage);
            playerLabels.put(user.getUsername(), nameLabel);

            index++;
        }
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);

        Main.batch.begin();
        Main.batch.draw(GameAssetManager.assetManager.get("menu assets/loading screen.png", Texture.class), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Main.batch.end();

        stateTime += delta;

        for (Map.Entry<String, Image> entry : playerImages.entrySet()) {
            TextureRegion frame = playerAnimation.getKeyFrame(stateTime, true);
            entry.getValue().setDrawable(new TextureRegionDrawable(frame));
        }

        if (lobby.getUsers().size() > 1) startGameButton.setVisible(true);
        if (lobby.getUsers().size() > 3) {
            findButton.setVisible(false);
            userFindField.setVisible(false);
        }

        userFindField.addListener(new ClickListener() {
            boolean cleared = false;

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    userFindField.setText("");
                    cleared = true;
                }
            }
        });

        userFindField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && userFindField.getText().isEmpty()) {
                    userFindField.setText("Username");
                }
            }
        });

        stage.act(delta);
        stage.draw();
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
        for (Texture t : playerTextures) {
            t.dispose();
        }
    }

    private void addUserToStage(User user, int index) {
        Label nameLabel = new Label(user.getUsername(), skin);
        nameLabel.setColor(Color.WHITE);

        Image animImage = new Image(playerAnimation.getKeyFrame(0));

        Table playerTable = new Table();
        playerTable.add(nameLabel).padBottom(5).row();
        playerTable.add(animImage).size(128, 128);

        float x = 600 + (index * 250);
        float y = 200;

        playerTable.setPosition(x, y);
        playerTable.setTransform(true);
        stage.addActor(playerTable);

        playerImages.put(user.getUsername(), animImage);
        playerLabels.put(user.getUsername(), nameLabel);
    }
}
