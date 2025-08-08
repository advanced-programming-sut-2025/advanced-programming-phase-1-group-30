package AP.group30.StardewValley.network;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.network.MessageClasses.*;
import AP.group30.StardewValley.views.StartMenus.LobbyMenu;
import com.badlogic.gdx.Gdx;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class NetworkClient {
    private final Client client;

    public NetworkClient() {
        client = new Client();
        Kryo kryo = client.getKryo(); // or client.getKryo()
        client.getKryo().register(Ping.class); // register shared message types
        kryo.register(PlayerJoin.class);
        kryo.register(PlayerJoinedLobby.class);
        kryo.register(PlayerMove.class);
        kryo.register(WorldState.class);
        kryo.register(MapTransfer.class);
        kryo.register(WorldState.Position.class);
        kryo.register(HashMap.class);
    }

    public void connect(String ip, int tcpPort, int udpPort) throws IOException {
        client.start(); // starts the internal networking threads
        client.connect(5000, ip, tcpPort, udpPort);

        client.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                if (object instanceof Ping) {
                    System.out.println("[Client] got: " + ((Ping) object).text);
                    Main.getMain().id = Integer.parseInt(((Ping) object).playerId);
                }
                if (object instanceof WorldState) {
                    System.out.println("received WorldState from server");
                    WorldState ws = (WorldState) object;
                    // Pass it into your MVC model so GameScreen.render() can draw it:
                    App.getCurrentGame().getModel().setCurrentWorldState(ws);
                    return;
                }

                // 2) (Optional) Incremental player moves
                if (object instanceof PlayerMove) {
                    PlayerMove pm = (PlayerMove) object;
                    // Update only that one player in your model:
                    App.getCurrentGame().getModel().moveOtherPlayers(pm);
                    return;
                }
                if (object instanceof PlayerJoinedLobby) {
                    PlayerJoinedLobby pjl = (PlayerJoinedLobby) object;

                    // Add to the current lobby’s user list
                    App.getCurrentLobby().getUsers().add(pjl.username);

                    // Update UI if we are in LobbyMenu
                    if (Main.getMain().getScreen() instanceof LobbyMenu) {
                        Gdx.app.postRunnable(() -> {
                            LobbyMenu lm = (LobbyMenu) Main.getMain().getScreen();
                            lm.addUserToStage(pjl.username,
                                App.getCurrentLobby().getUsers().size() - 1);
                        });
                    }
                }
            }
        });

        // Send initial test Ping to server
        Ping ping = new Ping();
        ping.text = "Hello Server!";
        client.sendTCP(ping);
    }

    public void update() {
        // not required for KryoNet—it handles polling in its own thread
        // (but you can still call this for future use)
    }

    public void close() {
        client.stop();
    }

    public void send(Object msg) {
        client.sendTCP(msg);
    }
}
