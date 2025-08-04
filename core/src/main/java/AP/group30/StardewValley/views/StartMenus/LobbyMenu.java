package AP.group30.StardewValley.views.StartMenus;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Lobby;
import AP.group30.StardewValley.models.Users.RegisterQuestions;
import AP.group30.StardewValley.models.Users.User;
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

public class LobbyMenu implements Screen {
    private Stage stage;
    private final Table table;
    private final Label titleLabel;
    private final TextButton backButton;
    private final TextButton startGameButton;

    private final TextField userFindField;
    private final TextButton findButton;

    private final Lobby lobby;

    public LobbyMenu(Skin skin) {
        lobby = App.getCurrentLobby();

        table = new Table(skin);
        titleLabel = new Label("Lobby: " + lobby.getLobbyID(), skin);

        backButton = new TextButton("Back", skin);
        startGameButton = new TextButton("Start", skin);
        startGameButton.setVisible(false);

        userFindField = new TextField("Username", skin);
        findButton = new TextButton("Find User", skin);
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

        if (lobby.getUsers().size() > 1) startGameButton.setVisible(true);

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
                //TODO Add the selected user with lobby.addUser(User);
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
