package AP.group30.StardewValley.views.StartMenus;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.LobbyManagerController;
import AP.group30.StardewValley.models.GameAssetManager;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import AP.group30.StardewValley.models.Lobby;
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

public class PreLobbyMenu implements Screen {
    private Stage stage;
    private Skin skin;
    private final Table table;
    private final Label titleLabel;
    private final TextButton creatLobbyButton;
    private final TextButton joinLobbyButton;
    private final TextButton backButton;

    private ScrollPane lobbyListPane;
    private Table lobbyListTable;
    private Dialog lobbySelectDialog;

    private final Label errorLabel;

    List<ServerInfo> lobbies = Collections.synchronizedList(new ArrayList<>());
    private static boolean listenerStarted = false;


    public PreLobbyMenu(Skin skin) {
        this.skin = skin;
        table = new Table(skin);
        titleLabel = new Label("Lobby", skin);
        creatLobbyButton = new TextButton("Creat Lobby", skin);
        joinLobbyButton = new TextButton("Join a Lobby", skin);
        backButton = new TextButton("Back", skin);

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
        table.add(backButton);
        table.row().pad(15);
        table.add(errorLabel);

        table.center();
        stage.addActor(table);
//        if (!listenerStarted) {
//            startLobbyListener();
//            listenerStarted = true;
//        }

        joinLobbyButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getMain().setScreen(new JoinLobbyMenu(skin));
            }
        });

        creatLobbyButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                LobbyManagerController.createLobby();

                // Add the created lobby to the list manually
                ServerInfo localLobby = new ServerInfo();
                localLobby.serverId = "Hamed's Game"; // Match the serverId in NetworkServer
                localLobby.host = "127.0.0.1";
                localLobby.tcpPort = 54555; // Default TCP port
                localLobby.lastHeard = System.currentTimeMillis();
                synchronized (lobbies) {
                    lobbies.add(localLobby);
                }

                Main.getMain().setScreen(new LobbyMenu(Main.getMain().skin, false));
            }
        });

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getMain().setScreen(new MainMenu(Main.getMain().skin));
            }
        });
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);

        Main.batch.begin();
        Main.batch.draw(GameAssetManager.assetManager.get("menu assets/loading screen.png", Texture.class), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Main.batch.end();

        stage.act();
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

//    private void startLobbyListener() {
//        new Thread(() -> {
//            try (DatagramSocket sock = new DatagramSocket(null)) {
//                sock.setReuseAddress(true);
//                sock.bind(new java.net.InetSocketAddress(8888));
//                sock.setSoTimeout(0);
//
//                byte[] buf = new byte[256];
//                DatagramPacket pack = new DatagramPacket(buf, buf.length);
//                while (true) {
//                    sock.receive(pack);
//                    String s = new String(pack.getData(), 0, pack.getLength(), StandardCharsets.UTF_8);
//                    if (s.startsWith("LOBBY:")) {
//                        String[] parts = s.substring(6).split("\\|");
//                        String id = parts[0];
//                        int port = Integer.parseInt(parts[1].substring(5));
//                        String host = pack.getAddress().getHostAddress();
//
//                        synchronized (lobbies) {
//                            System.out.println("Lobbies size: " + lobbies.size());
//                            Optional<ServerInfo> exists = lobbies.stream()
//                                .filter(si -> si.serverId.equals(id)).findFirst();
//                            if (exists.isPresent()) {
//                                exists.get().lastHeard = System.currentTimeMillis();
//                            } else {
//                                ServerInfo si = new ServerInfo();
//                                si.serverId = id;
//                                si.host = host;
//                                si.tcpPort = port;
//                                si.lastHeard = System.currentTimeMillis();
//                                lobbies.add(si);
//
//                                // Update UI on the main thread
//                                Gdx.app.postRunnable(() -> {
//                                    System.out.println("Discovered lobby: " + id + " at " + host + ":" + port);
//                                    // Instead of adding a button directly, refresh the whole list
//                                    refreshLobbyListUI();
//                                });
//                            }
//                        }
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }, "Lobby-Listener").start();
//    }
}
