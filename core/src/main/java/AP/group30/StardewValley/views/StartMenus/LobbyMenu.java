package AP.group30.StardewValley.views.StartMenus;

import AP.group30.StardewValley.Main;
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

public class LobbyMenu implements Screen {
    private Stage stage;
    private final Table table;
    private final Label titleLabel;
    private final TextButton creatLobbyButton;
    private final TextButton joinLobbyButton;
    private final TextButton backButton;

    private final TextField lobbyIDField;
    private final TextButton findButton;

    public LobbyMenu(Skin skin) {
        table = new Table(skin);
        titleLabel = new Label("Lobby", skin);
        creatLobbyButton = new TextButton("Creat Lobby", skin);
        joinLobbyButton = new TextButton("Join a Lobby", skin);
        backButton = new TextButton("Back", skin);

        lobbyIDField = new TextField("Lobby ID", skin);
        lobbyIDField.setVisible(false);
        findButton = new TextButton("Find Lobby", skin);
        findButton.setVisible(false);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);

        titleLabel.setColor(Color.BLACK);

        table.add(titleLabel);
        table.row().pad(15);
        table.add(creatLobbyButton);
        table.row().pad(15);
        table.add(joinLobbyButton);
        table.row().pad(15);
        table.add(backButton);
        table.row().pad(15);
        table.add(lobbyIDField);
        table.add(findButton);

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

        lobbyIDField.addListener(new ClickListener() {
            boolean cleared = false;

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    lobbyIDField.setText("");
                    cleared = true;
                }
            }
        });

        lobbyIDField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && lobbyIDField.getText().isEmpty()) {
                    lobbyIDField.setText("Lobby ID");
                }
            }
        });

        creatLobbyButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getMain().setScreen(new PreGameMenu(Main.getMain().skin));
            }
        });

        joinLobbyButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getMain().setScreen(new ProfileMenu(Main.getMain().skin));
            }
        });

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.setCurrentUser(null);
                Main.getMain().setScreen(new LoginMenu(Main.getMain().skin));
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
