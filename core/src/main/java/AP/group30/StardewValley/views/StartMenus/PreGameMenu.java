package AP.group30.StardewValley.views.StartMenus;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.NewGameController;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Game;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Lobby;
import AP.group30.StardewValley.models.Users.RegisterQuestions;
import AP.group30.StardewValley.models.Users.User;
import AP.group30.StardewValley.network.MessageClasses.MapChanged;
import AP.group30.StardewValley.network.MessageClasses.PlayerJoin;
import AP.group30.StardewValley.network.MessageClasses.Ready;
import AP.group30.StardewValley.network.MessageClasses.StartGame;
import AP.group30.StardewValley.views.CityScreen;
import AP.group30.StardewValley.views.GameScreen;
import AP.group30.StardewValley.views.LoadingScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.concurrent.TimeUnit;

public class PreGameMenu implements Screen {
    private Stage stage;
    private final Table table;
    private final Label titleLabel;
    private final Label numberOfPlayersLabel;
    private final Label mapPlayerLabel;
    private final Label mapPlayer1Label;
    private final Label mapPlayer2Label;
    private final Label mapPlayer3Label;
    private final Label mapPlayer4Label;
    private final SelectBox<String> mapPlayerBox;
    private final TextButton startButton;
    private final TextButton readyButton;
    private final TextButton backButton;
    private static Label errorLabel;
    private Texture background;

    private final Lobby lobby;
    private Process serverProcess;

    public PreGameMenu(Skin skin, Lobby theLobby, Process theServerProcess) {
        table = new Table(skin);
        titleLabel = new Label("PreGame Menu", skin);
        lobby = theLobby;
        numberOfPlayersLabel = new Label("Number Of Players: " + lobby.getUsers().size(), skin);
        mapPlayerLabel = new Label("Your Map :", skin);
        mapPlayer1Label = new Label("Player1 Map :", skin);
        mapPlayer2Label = new Label("Player2 Map :", skin);
        mapPlayer3Label = new Label("Player3 Map :", skin);
        mapPlayer4Label = new Label("Player4 Map :", skin);
        mapPlayerBox = new SelectBox<>(skin);
        mapPlayerBox.setItems("1", "2", "3", "4");
        startButton = new TextButton("Start", skin);
        readyButton = new TextButton("Ready", skin);
        backButton = new TextButton("Back", skin);
        errorLabel = new Label("", skin);

        serverProcess = theServerProcess;
        if (lobby.getUsers().contains("127.0.0.1")) lobby.removeUser("127.0.0.1");
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
        if (LoadingScreen.time.getHour() <= 11) {
            background = GameAssetManager.assetManager.get(GameAssetManager.background);
        } else {
            background = GameAssetManager.assetManager.get(GameAssetManager.nightBackground);
        }

        errorLabel.setColor(Color.RED);
        errorLabel.setVisible(false);

        mapPlayer3Label.setVisible(false);
        mapPlayer4Label.setVisible(false);

        titleLabel.setColor(Color.BLACK);
        numberOfPlayersLabel.setColor(Color.BLACK);
        mapPlayerLabel.setColor(Color.BLACK);
        mapPlayer1Label.setColor(Color.BLACK);
        mapPlayer2Label.setColor(Color.BLACK);
        mapPlayer3Label.setColor(Color.BLACK);
        mapPlayer4Label.setColor(Color.BLACK);

        startButton.setVisible(false);
        if (lobby.getAdmin().equals(App.getCurrentUser().getUsername())) readyButton.setVisible(false);

        table.add(titleLabel);
        table.row().pad(15);
        table.add(numberOfPlayersLabel).width(200);
        table.row().pad(15);
        table.add(mapPlayerLabel).width(200);
        table.add(mapPlayerBox).width(100);
        table.row().pad(45);
        table.add(mapPlayer1Label).width(200);
        table.row().pad(15);
        table.add(mapPlayer2Label).width(200);
        table.row().pad(15);
        table.add(mapPlayer3Label).width(200);
        table.row().pad(15);
        table.add(mapPlayer4Label).width(200);
        table.row().pad(15);
        table.add(startButton);
        table.row().pad(15);
        table.add(readyButton);
        table.row().pad(15);
        table.add(backButton);
        table.row().pad(15);
        table.add(errorLabel);

        table.center();
        stage.addActor(table);

        mapPlayerBox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                MapChanged mapChanged = new MapChanged();
                mapChanged.username = App.getCurrentUser().getUsername();
                mapChanged.number = Integer.parseInt(mapPlayerBox.getSelected());
                Main.getMain().client.send(mapChanged);
            }
        });

        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.getCurrentLobby().setGoToMainGame(true);
                StartGame start = new StartGame();
                start.goToPreGame = false;
                Main.getMain().client.send(start);
            }
        });

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                stopServer();
                App.setCurrentLobby(null);
                Main.getMain().setScreen(new MainMenu(Main.getMain().skin));
            }
        });

        readyButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Ready ready = new Ready();
                ready.username = App.getCurrentUser().getUsername();
                Main.getMain().client.send(ready);

                readyButton.setVisible(false);
                mapPlayerLabel.setVisible(false);
                mapPlayerBox.setVisible(false);
            }
        });
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);

        Main.batch.begin();
        Main.batch.draw(background,
            0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Main.batch.end();

        if (lobby.getUsers().size() == 2) {
            mapPlayer2Label.setVisible(true);
            mapPlayer3Label.setVisible(false);
            mapPlayer4Label.setVisible(false);
        } else if (lobby.getUsers().size() == 3) {
            mapPlayer2Label.setVisible(true);
            mapPlayer3Label.setVisible(true);
            mapPlayer4Label.setVisible(false);
        } else if (lobby.getUsers().size() == 4) {
            mapPlayer2Label.setVisible(true);
            mapPlayer3Label.setVisible(true);
            mapPlayer4Label.setVisible(true);
        }

        boolean allReady = true;

        mapPlayer1Label.setText(lobby.getUsers().get(0) + "'s Map :" + lobby.getMaps().get(0) + " (Ready)");
        if (lobby.getUsers().size() > 1) {
            mapPlayer2Label.setText(lobby.getUsers().get(1) + "'s Map :" + lobby.getMaps().get(1));
            if (lobby.getReadies().get(1))
                mapPlayer2Label.setText(lobby.getUsers().get(1) + "'s Map :" + lobby.getMaps().get(1) + " (Ready)");

            if (!lobby.getReadies().get(1)) allReady = false;
        }
        if (lobby.getUsers().size() > 2) {
            mapPlayer3Label.setText(lobby.getUsers().get(2) + "'s Map :" + lobby.getMaps().get(2));
            if (lobby.getReadies().get(2))
                mapPlayer3Label.setText(lobby.getUsers().get(2) + "'s Map :" + lobby.getMaps().get(2) + " (Ready)");

            if (!lobby.getReadies().get(2)) allReady = false;
        }
        if (lobby.getUsers().size() > 3) {
            mapPlayer4Label.setText(lobby.getUsers().get(3) + "'s Map :" + lobby.getMaps().get(3));
            if (lobby.getReadies().get(3))
                mapPlayer4Label.setText(lobby.getUsers().get(3) + "'s Map :" + lobby.getMaps().get(3) + " (Ready)");

            if (!lobby.getReadies().get(3)) allReady = false;
        }

        if (lobby.getAdmin().equals(App.getCurrentUser().getUsername()) && allReady) startButton.setVisible(true);

        stage.act(delta);
        stage.draw();

        if (lobby.isGoToMainGame()) {
            User user1 = new User(lobby.getUsers().get(0), "1", "1", "1", RegisterQuestions.Your_Best_Friend, "1", "male");
            User user2 = null;
            User user3 = null;
            User user4 = null;

            if (lobby.getUsers().size() > 1) {
                user2 = new User(lobby.getUsers().get(1), "1", "1", "1", RegisterQuestions.Your_Best_Friend, "1", "male");
            }
            if (lobby.getUsers().size() > 2) {
                user3 = new User(lobby.getUsers().get(2), "1", "1", "1", RegisterQuestions.Your_Best_Friend, "1", "male");
            }
            if (lobby.getUsers().size() > 3) {
                user4 = new User(lobby.getUsers().get(3), "1", "1", "1", RegisterQuestions.Your_Best_Friend, "1", "male");
            }

            Game game = NewGameController.NewGame(lobby.getUsers().size(), user1, user2, user3, user4, lobby.getMaps().get(0), lobby.getMaps().get(1), lobby.getMaps().get(2), lobby.getMaps().get(3));
            PlayerJoin playerJoin = new PlayerJoin();
            playerJoin.playerId = String.valueOf(Main.getMain().id);
            playerJoin.displayName = game.getCurrentPlayer().getUsername();

            game.getModel().setMyPlayerId(String.valueOf(Main.getMain().id));

            RegisterMenu.gameScreen = new GameScreen(game);
            RegisterMenu.cityScreen = new CityScreen(game);
            Main.getMain().setScreen(new LoadingScreen(RegisterMenu.gameScreen));
            App.getNetworkClient().send(playerJoin);
        }
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
        if (serverProcess != null && serverProcess.isAlive()) {
            serverProcess.destroy();
        }
    }

    private void stopServer() {
        if (serverProcess == null) return;
        if (serverProcess.isAlive()) {
            serverProcess.destroy(); // sends SIGTERM on Unix
            try {
                boolean exited = serverProcess.waitFor(2, TimeUnit.SECONDS);
                if (!exited && serverProcess.isAlive()) {
                    serverProcess.destroyForcibly();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        serverProcess = null;
    }
}
