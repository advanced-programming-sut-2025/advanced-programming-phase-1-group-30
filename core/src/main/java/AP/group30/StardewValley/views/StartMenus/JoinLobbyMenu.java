package AP.group30.StardewValley.views.StartMenus;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Lobby;
import AP.group30.StardewValley.network.MessageClasses.PlayerJoinedLobby;
import AP.group30.StardewValley.network.ServerInfo;
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
import org.json.JSONObject;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class JoinLobbyMenu implements Screen {
    private Stage stage;
    private Skin skin;
    private Table table;
    private ScrollPane lobbyListPane;
    private Table lobbyListTable;
    private Label errorLabel;
    private Thread listenerThread;
    private DatagramSocket listenerSocket;
    private volatile boolean listenerRunning = false;
    private TextField lobbyUniqueID;
    private TextField passwordField;

    private List<ServerInfo> lobbies = Collections.synchronizedList(new ArrayList<>());
    private boolean listenerStarted = false;

    public JoinLobbyMenu(Skin skin) {
        this.skin = skin;
        lobbyUniqueID = new TextField("Lobby ID", skin);
        passwordField = new TextField("Password", skin);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        table = new Table(skin);
        table.setFillParent(true);
        errorLabel = new Label("Enter the password for the private lobby", skin);
        errorLabel.setVisible(false);
        errorLabel.setColor(Color.RED);

        lobbyListTable = new Table(skin);

        lobbyListPane = new ScrollPane(lobbyListTable, skin);
        table.add(new Label("Select a Lobby", skin)).pad(10);
        table.row();
        table.add(lobbyListPane).width(900).height(550).pad(10);
        table.row();
        table.add(errorLabel).pad(10);
        table.row();
        TextButton backButton = new TextButton("Back", skin);
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getMain().setScreen(new PreLobbyMenu(skin));
                stopLobbyListener();
            }
        });
        TextButton refreshButton = new TextButton("Refresh", skin);
        refreshButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                refreshLobbyListUI();
                for (ServerInfo lobby : lobbies) {
                    if (!lobby.isVisible) {
                        if (lobby.uniqueId.equals(lobbyUniqueID.getText())) {
                            lobbyButton(lobby);
                        }
                    }
                }
            }
        });
        table.add(passwordField).width(200).pad(10).row();
        table.add(lobbyUniqueID).width(200).pad(10).row();
        table.add(refreshButton).pad(10).row();
        table.add(backButton).pad(10);

        stage.addActor(table);

        if (!listenerStarted) {
            startLobbyListener();
            listenerStarted = true;
        }
    }

    private void refreshLobbyListUI() {
        lobbyListTable.clear();
        System.out.println("Refreshing lobby list");
        synchronized (lobbies) {
            if (lobbies.isEmpty()) {
                Label noLobbiesLabel = new Label("No lobbies found.", skin);
                lobbyListTable.add(noLobbiesLabel).pad(10);
            } else {
                for (ServerInfo lobby : lobbies) {
                    if (lobby.isVisible) {
                        lobbyButton(lobby);
                    }
                }
            }
        }
    }

    private void lobbyButton(ServerInfo lobby) {
        TextButton lobbyBtn = new TextButton(
            lobby.serverId + "| Online players: " + lobby.users.size() + "| Port:" + lobby.tcpPort + "| " + (lobby.isPrivate ? "Private" : "Open"),
            skin
        );
        lobbyBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (lobby.isPrivate) {
                    if (!passwordField.getText().equals(lobby.password)) {
                        errorLabel.setText("password incorrect");
                        errorLabel.setVisible(true);
                        return;
                    }
                }
                try {
                    Lobby lobby1 = new Lobby(lobby.serverId, lobby.host);
                    for (String user : lobby.users) {
                        lobby1.addUser(user);
                    }
                    App.setCurrentLobby(lobby1);
                    Main.getMain().client.connect(lobby.host, lobby.tcpPort, lobby.udpPort);
                    PlayerJoinedLobby pjl = new PlayerJoinedLobby();
                    pjl.username = App.getCurrentUser().getUsername();
                    pjl.playerId = String.valueOf(Main.getMain().id);
                    Main.getMain().setScreen(new LobbyMenu(Main.getMain().skin, true));
                    Main.getMain().client.send(pjl);
                    stopLobbyListener();
                } catch (Exception e) {
                    errorLabel.setText("Failed to join lobby: " + e.getMessage());
                    errorLabel.setVisible(true);
                }
            }
        });
        lobbyListTable.row();
        lobbyListTable.add(lobbyBtn).width(800).pad(50);
    }

    private void startLobbyListener() {
        if (listenerRunning) return;
        listenerRunning = true;
        listenerThread = new Thread(() -> {
            try (DatagramSocket sock = new DatagramSocket(8888, InetAddress.getByName("0.0.0.0"))) {
                byte[] buf = new byte[512];
                DatagramPacket pack = new DatagramPacket(buf, buf.length);
                while (listenerRunning) {
                    sock.receive(pack);
                    String s = new String(pack.getData(), 0, pack.getLength(), StandardCharsets.UTF_8).trim();
                    System.out.println("Discovery packet: '" + s + "' from " + pack.getAddress());

                    // Try to parse JSON discovery message:
                    try {
                        JSONObject obj = new JSONObject(s);
                        String id = obj.optString("id", "").trim();
                        int tcp = obj.optInt("tcp", -1);
                        int udp = obj.optInt("udp", -1);
                        boolean isPrivate = obj.optBoolean("isPrivate", false);
                        String password = obj.optString("password", "");
                        boolean isVisible = obj.optBoolean("isVisible", true);
                        String uniqueId = obj.optString("uniqueId", "");
                        if (id.isEmpty() || tcp <= 0) continue;

                        String host = pack.getAddress().getHostAddress();

                        synchronized (lobbies) {
                            Optional<ServerInfo> exists = lobbies.stream()
                                .filter(si -> si.tcpPort == tcp).findFirst();
                            if (exists.isPresent()) {
                                ServerInfo existing = exists.get();
                                existing.lastHeard = System.currentTimeMillis();
                                existing.host = host;
                                existing.tcpPort = tcp;
                                existing.udpPort = udp;
                                existing.isPrivate = isPrivate;
                                existing.password = password;
                                existing.isVisible = isVisible;
                                existing.uniqueId = uniqueId;

                                // Update users list
                                existing.users.clear();
                                org.json.JSONArray arr = obj.optJSONArray("players");
                                if (arr != null) {
                                    for (int i = 0; i < arr.length(); i++) {
                                        existing.users.add(arr.optString(i));
                                    }
                                }
                            } else {
                                ServerInfo si = new ServerInfo();
                                si.serverId = id;
                                si.host = host;
                                si.tcpPort = tcp;
                                si.udpPort = udp;
                                si.isPrivate = isPrivate;
                                si.password = password;
                                si.isVisible = isVisible;
                                si.uniqueId = uniqueId;
                                si.lastHeard = System.currentTimeMillis();

                                org.json.JSONArray arr = obj.optJSONArray("players");
                                if (arr != null) {
                                    for (int i = 0; i < arr.length(); i++) {
                                        si.users.add(arr.optString(i));
                                    }
                                }

                                lobbies.add(si);
                                System.out.println("Discovered lobby: " + id + " at " + host + ":" + tcp);
                            }
                        }

                        // Refresh UI safely on main thread
//                        Gdx.app.postRunnable(this::refreshLobbyListUI);

                    } catch (org.json.JSONException je) {
                        System.err.println("Received non-JSON discovery packet, ignoring: " + s);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (listenerSocket != null && !listenerSocket.isClosed()) {
                    listenerSocket.close();
                }
                listenerSocket = null;
                listenerRunning = false;
            }
        }, "Lobby-Listener");
        listenerThread.setDaemon(true);
        listenerThread.start();
    }

    private void stopLobbyListener() {
        listenerRunning = false;
        if (listenerSocket != null && !listenerSocket.isClosed()) {
            listenerSocket.close(); // causes receive() to throw and thread to exit
        }
        if (listenerThread != null && listenerThread.isAlive()) {
            try {
                listenerThread.join(1000); // wait up to 1s
            } catch (InterruptedException ignored) { Thread.currentThread().interrupt(); }
        }
        listenerThread = null;
        listenerSocket = null;
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Main.batch.begin();
        Main.batch.draw(GameAssetManager.assetManager.get("menu assets/loading screen.png", Texture.class), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Main.batch.end();

        lobbyUniqueID.addListener(new ClickListener() {
            boolean cleared = false;
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    lobbyUniqueID.setText("");
                    cleared = true;
                }
            }
        });

        lobbyUniqueID.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && lobbyUniqueID.getText().isEmpty()) {
                    lobbyUniqueID.setText("Lobby ID");
                }
            }
        });

        passwordField.addListener(new ClickListener() {
            boolean cleared = false;
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    passwordField.setText("");
                    cleared = true;
                }
            }
        });

        passwordField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && passwordField.getText().isEmpty()) {
                    passwordField.setText("Password");
                }
            }
        });

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
    }
}
