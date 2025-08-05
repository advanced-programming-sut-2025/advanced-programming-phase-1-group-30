package AP.group30.StardewValley.views.StartMenus;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.LobbyManagerController;
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

public class PreLobbyMenu implements Screen {
    private Stage stage;
    private final Table table;
    private final Label titleLabel;
    private final TextButton creatLobbyButton;
    private final TextButton joinLobbyButton;
    private final TextButton backButton;

    private final TextField lobbyIDField;
    private final TextButton findButton;

    private final Label errorLabel;

    public PreLobbyMenu(Skin skin) {
        table = new Table(skin);
        titleLabel = new Label("Lobby", skin);
        creatLobbyButton = new TextButton("Creat Lobby", skin);
        joinLobbyButton = new TextButton("Join a Lobby", skin);
        backButton = new TextButton("Back", skin);

        lobbyIDField = new TextField("Lobby ID", skin);
        lobbyIDField.setVisible(false);
        lobbyIDField.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
        findButton = new TextButton("Find Lobby", skin);
        findButton.setVisible(false);

        errorLabel = new Label("Lobby Not Found!", skin);
        errorLabel.setVisible(false);
        errorLabel.setColor(Color.RED);
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
        table.add(lobbyIDField).width(200);
        table.row().pad(15);
        table.add(findButton);
        table.row().pad(15);
        table.add(backButton);
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
                LobbyManagerController.createLobby();
                Main.getMain().setScreen(new LobbyMenu(Main.getMain().skin));
            }
        });

        findButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (LobbyManagerController.findLobby(Integer.parseInt(lobbyIDField.getText()))) {
                    errorLabel.setVisible(false);

                    Main.getMain().setScreen(new LobbyMenu(Main.getMain().skin));
                }
                else
                    errorLabel.setVisible(true);
            }
        });

        joinLobbyButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                creatLobbyButton.setVisible(false);
                joinLobbyButton.setVisible(false);

                lobbyIDField.setVisible(true);
                findButton.setVisible(true);
            }
        });

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getMain().setScreen(new MainMenu(Main.getMain().skin));
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
