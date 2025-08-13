package AP.group30.StardewValley.views.StartMenus;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.GameMenuController;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Game;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Lobby;
import AP.group30.StardewValley.models.Users.RegisterQuestions;
import AP.group30.StardewValley.models.Users.User;
import AP.group30.StardewValley.network.MessageClasses.LeaveLobby;
import AP.group30.StardewValley.network.MessageClasses.StartGame;
import AP.group30.StardewValley.network.MessageClasses.PlayerJoinedLobby;
import AP.group30.StardewValley.views.CityScreen;
import AP.group30.StardewValley.views.GameScreen;
import AP.group30.StardewValley.views.LoadingScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static AP.group30.StardewValley.views.StartMenus.RegisterMenu.gameScreen;

public class LobbyMenu implements Screen {
    private Stage stage;
    private final Table table;
    private final Label titleLabel;
    private final TextButton backButton;
    private final TextButton startGameButton;
    private final TextButton loadButton;
    private final Map<String, Table> playerTables = new HashMap<>();

    private final TextField TCPField;
    private final TextField UDPField;
    private final TextField lobbyNameField;
    private final CheckBox privateLobby;
    private final CheckBox visible;
    private final TextField lobbyPassword;
    private final TextButton createButton;
    int uniqueId;

    private final Label errorLabel;
    private final Lobby lobby;

    public Map<String, Image> playerImages = new HashMap<>();
    public Map<String, Label> playerLabels = new HashMap<>();
    private final ArrayList<Texture> playerTextures = new ArrayList<>();

    private Animation<TextureRegion> playerAnimation;
    private float stateTime = 0;

    private final Skin skin;

    private boolean waitingForPlayers = false;
    private Process serverProcess; // Store server process

    public LobbyMenu(Skin skin, boolean client) {
        this.skin = skin;
        lobby = App.getCurrentLobby();

        table = new Table(skin);
        titleLabel = new Label(lobby.getLobbyID(), skin);

        backButton = new TextButton("Back", skin);
        startGameButton = new TextButton("Start", skin);
        startGameButton.setVisible(false);
        loadButton = new TextButton("Load", skin);
        loadButton.setVisible(false);

        TCPField = new TextField("TCP", skin);
        UDPField = new TextField("UDP", skin);
        lobbyNameField = new TextField("LobbyID", skin);
        privateLobby = new CheckBox("Private Lobby", skin);
        visible = new CheckBox("Invisible", skin);
        lobbyPassword = new TextField("Password", skin);
        createButton = new TextButton("Create Lobby", skin);

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
        table.add(TCPField).width(180);
        table.add(UDPField).width(180);
        table.add(lobbyNameField).width(250);
        table.row().pad(15);
        table.add(privateLobby);
        table.add(lobbyPassword).width(250);
        table.add(visible);
        table.add(createButton);
        table.row().pad(15);
        table.add(backButton);
        table.row().pad(15);
        table.add(startGameButton);
        table.add(loadButton);
        table.row().pad(15);
        table.add(errorLabel);

        table.center();
        stage.addActor(table);

        lobbyPassword.setVisible(false);

        if (!App.getCurrentUser().getUsername().equals(App.getCurrentLobby().getAdmin())) {
            TCPField.setVisible(false);
            UDPField.setVisible(false);
            lobbyNameField.setVisible(false);
            createButton.setVisible(false);
            privateLobby.setVisible(false);
            visible.setVisible(false);
            lobbyPassword.setVisible(false);
        }

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                LeaveLobby leaveLobby = new LeaveLobby();
                leaveLobby.username = App.getCurrentUser().getUsername();
                leaveLobby.id = String.valueOf(Main.getMain().id);
                Main.getMain().client.send(leaveLobby);
                stopServer();
                Main.getMain().setScreen(new MainMenu(Main.getMain().skin));
            }
        });

        startGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.getCurrentLobby().setGoToPreGame(true);
                StartGame start = new StartGame();
                start.goToPreGame = true;
                Main.getMain().client.send(start);
            }
        });

        loadButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Game game = null;
                try {
                    game = GameMenuController.loadGame();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                App.setCurrentGame(game);
                RegisterMenu.gameScreen = new GameScreen(game);
                RegisterMenu.cityScreen = new CityScreen(game);
                Main.getMain().setScreen(new LoadingScreen(gameScreen));
            }
        });

        createButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String tcpPort = TCPField.getText();
                String udpPort = UDPField.getText();
                String lobbyName = lobbyNameField.getText();
                boolean isPrivate = privateLobby.isChecked();
                String password = lobbyPassword.getText();
                boolean isVisible = !visible.isChecked();
                uniqueId = MathUtils.random(9000) + 1000;

//                File projectRoot = new File("/home/hamed/University/StardewValley");
                File projectRoot = new File("D:\\Amir\\University\\Term_2\\Advanced_Programming\\Project\\advanced-programming-phase-1-group-30");
                String wrapper = System.getProperty("os.name").toLowerCase().contains("win") ? "gradlew.bat" : "gradlew";
                ProcessBuilder pb = new ProcessBuilder(
                    new File(projectRoot, wrapper).getAbsolutePath(),
                    ":lwjgl3:runHeadless",
                    "--args=" + tcpPort + " " + udpPort + " " + lobbyName + " " + isPrivate + " " + password + " " + isVisible + " " + uniqueId
                );
                pb.directory(projectRoot);
                pb.inheritIO(); // prints server output in console
                try {
                    serverProcess = pb.start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                titleLabel.setText(lobbyNameField.getText() + " (ID: " + uniqueId + ")");
                // Add a shutdown hook in parent too — in case parent is killed, try to stop child
                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    if (serverProcess != null && serverProcess.isAlive()) {
                        serverProcess.destroy();
                        try {
                            serverProcess.waitFor(2, TimeUnit.SECONDS);
                        } catch (InterruptedException ignored) {
                            Thread.currentThread().interrupt();
                        }
                        if (serverProcess.isAlive()) serverProcess.destroyForcibly();
                    }
                }));
                // Show waiting message
                errorLabel.setText("Starting server...");
                errorLabel.setVisible(true);

                // Hide create button and fields
                createButton.setVisible(false);
                TCPField.setVisible(false);
                UDPField.setVisible(false);
                privateLobby.setVisible(false);
                lobbyNameField.setVisible(false);
                lobbyPassword.setVisible(false);
                visible.setVisible(false);
                lobbyPassword.setVisible(false);

                // Wait for server to start, then connect client
                new Thread(() -> {
                    int tcp = Integer.parseInt(tcpPort);
                    int udp = Integer.parseInt(udpPort);
                    boolean connected = false;
                    int retries = 0;
                    while (!connected && retries < 20) { // Try for ~4 seconds
                        try {
                            Thread.sleep(800);
                            Main.getMain().client.connect("127.0.0.1", tcp, udp);
                            Thread.sleep(800);
                            connected = true;
                            PlayerJoinedLobby pjl = new PlayerJoinedLobby();
                            pjl.username = App.getCurrentUser().getUsername();
                            pjl.playerId = String.valueOf(Main.getMain().id);
                            Main.getMain().client.send(pjl);
                        } catch (IOException ex) {
                            retries++;
                        } catch (InterruptedException ie) {
                            break;
                        }
                    }
                    if (connected) {
                        App.setNetworkClient(Main.getMain().client);
                        Gdx.app.postRunnable(() -> {
                            errorLabel.setText("Waiting for other players to join...");
                            waitingForPlayers = true;
                        });
                    } else {
                        Gdx.app.postRunnable(() -> {
                            errorLabel.setText("Failed to connect to server.");
                        });
                    }
                }).start();
            }
        });
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

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        if (privateLobby.isChecked()) {
            lobbyPassword.setVisible(true);
        } else {
            lobbyPassword.setVisible(false);
        }

        Main.batch.begin();
        Main.batch.draw(GameAssetManager.assetManager.get("menu assets/loading screen.png", Texture.class), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Main.batch.end();

        stateTime += delta;

        for (Map.Entry<String, Image> entry : playerImages.entrySet()) {
            TextureRegion frame = playerAnimation.getKeyFrame(stateTime, true);
            entry.getValue().setDrawable(new TextureRegionDrawable(frame));
        }

        if (lobby.getUsers().size() > 1 && lobby.getAdmin().equals(App.getCurrentUser().getUsername())) {
            startGameButton.setVisible(true);
            loadButton.setVisible(true);
        }
        if (lobby.getUsers().size() > 3) {
            createButton.setVisible(false);
            TCPField.setVisible(false);
            UDPField.setVisible(false);
            privateLobby.setVisible(false);
            visible.setVisible(false);
            lobbyPassword.setVisible(false);
        }
        if (App.getCurrentLobby().isGoToPreGame())
            Main.getMain().setScreen(new PreGameMenu(Main.getMain().skin, lobby, serverProcess));

        TCPField.addListener(new ClickListener() {
            boolean cleared = false;
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    TCPField.setText("");
                    cleared = true;
                }
            }
        });

        UDPField.addListener(new ClickListener() {
            boolean cleared = false;
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    UDPField.setText("");
                    cleared = true;
                }
            }
        });

        lobbyNameField.addListener(new ClickListener() {
            boolean cleared = false;
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    lobbyNameField.setText("");
                    cleared = true;
                }
            }
        });

        lobbyPassword.addListener(new ClickListener() {
            boolean cleared = false;
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    lobbyPassword.setText("");
                    cleared = true;
                }
            }
        });

        TCPField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && TCPField.getText().isEmpty()) {
                    TCPField.setText("TCP");
                }
            }
        });

        UDPField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && UDPField.getText().isEmpty()) {
                    UDPField.setText("UDP");
                }
            }
        });

        lobbyNameField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && lobbyNameField.getText().isEmpty()) {
                    lobbyNameField.setText("LobbyID");
                }
            }
        });

        lobbyPassword.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && lobbyPassword.getText().isEmpty()) {
                    lobbyPassword.setText("Password");
                }
            }
        });

        if (waitingForPlayers) {
            // Optionally update waiting message or check for player count
            if (lobby.getUsers().size() > 1) {
                errorLabel.setVisible(false);
                startGameButton.setVisible(true);
                loadButton.setVisible(true);
                waitingForPlayers = false;
            }
        }

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
        // Kill server process if running
        if (serverProcess != null && serverProcess.isAlive()) {
            serverProcess.destroy();
        }
    }

    public void addUserToStage(String user, int index) {
        for (String u : playerTables.keySet()) {
            if (!lobby.getUsers().contains(u)) {
                playerTables.get(u).setVisible(false);
            }
        }
        Label nameLabel = new Label(user, skin);
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

        playerImages.put(user, animImage);
        playerLabels.put(user, nameLabel);
        playerTables.put(user, playerTable);
    }

    public Label getLabel() {
        return errorLabel;
    }
}
