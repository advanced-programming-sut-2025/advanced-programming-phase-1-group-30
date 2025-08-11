package AP.group30.StardewValley.network;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Players.PlayerLeaderboard;
import AP.group30.StardewValley.network.MessageClasses.*;
import AP.group30.StardewValley.views.StartMenus.LobbyMenu;
import AP.group30.StardewValley.views.StartMenus.MainMenu;
import AP.group30.StardewValley.views.StartMenus.PreLobbyMenu;
import com.badlogic.gdx.Gdx;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class NetworkClient {
    private final Client client;

    public NetworkClient() {
        client = new Client();
        Kryo kryo = client.getKryo(); // or client.getKryo()
        client.getKryo().register(Ping.class); // register shared message types
        kryo.register(PlayerJoin.class);
        kryo.register(PlayerJoinedLobby.class);
        kryo.register(LeaveLobby.class);
        kryo.register(PlayerMove.class);
        kryo.register(WorldState.class);
        kryo.register(MapTransfer.class);
        kryo.register(WorldState.Position.class);
        kryo.register(HashMap.class);
        kryo.register(ArrayList.class);
        kryo.register(ServerStop.class);
        kryo.register(StartGame.class);
        kryo.register(MapChanged.class);
        kryo.register(Ready.class);
        kryo.register(LeaderBoardUpdate.class);
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

                if (object instanceof PlayerMove) {
                    PlayerMove pm = (PlayerMove) object;
                    // Update only that one player in your model:
                    App.getCurrentGame().getModel().moveOtherPlayers(pm);
                    return;
                }
                if (object instanceof ServerStop) {
                    Main.getMain().client.close();
                    ((LobbyMenu)Main.getMain().getScreen()).getLabel().setText("Server stopped! Please return to the Main Menu");
                }

                if (object instanceof PlayerJoinedLobby) {
                    PlayerJoinedLobby pjl = (PlayerJoinedLobby) object;
                    if (App.getCurrentLobby() == null) {
                        return;
                    }
                    App.getCurrentLobby().getUsers().clear();

                    // Add to the current lobby’s user list
                    for (String user : pjl.playersInLobby) {
                        App.getCurrentLobby().getUsers().add(user);
                    }
                    if (!App.getCurrentLobby().getUsers().contains(App.getCurrentUser().getUsername())) {
                        App.setCurrentLobby(null);
                        return;
                    }

                    // Update UI if we are in LobbyMenu
                    if (Main.getMain().getScreen() instanceof LobbyMenu) {
                        Gdx.app.postRunnable(() -> {
                            LobbyMenu lm = (LobbyMenu) Main.getMain().getScreen();
                            lm.playerLabels.clear();
                            lm.playerImages.clear();
                            int index = 0;
                            for (String user : pjl.playersInLobby) {
                                lm.addUserToStage(user, index);
                                index++;
                            }
                        });
                    }
                }

                if (object instanceof StartGame) {
                    StartGame sg = (StartGame) object;
                    if (sg.goToPreGame)
                        App.getCurrentLobby().setGoToPreGame(true);
                    else
                        App.getCurrentLobby().setGoToMainGame(true);
                }

                if (object instanceof MapChanged) {
                    MapChanged mc = (MapChanged) object;
                    App.getCurrentLobby().changeMap(App.getCurrentLobby().getUsers().indexOf(mc.username), mc.number);
                }

                if (object instanceof Ready) {
                    Ready r = (Ready) object;
                    App.getCurrentLobby().changeReady(App.getCurrentLobby().getUsers().indexOf(r.username));
                }

                if (object instanceof LeaderBoardUpdate) {
                    LeaderBoardUpdate lbu = (LeaderBoardUpdate) object;

                    if (lbu.send) {
                        if (lbu.receiverUsername.equals(App.getCurrentGame().getCurrentPlayer().getUsername())) {
                            lbu.send = false;
                            lbu.money = App.getCurrentGame().getCurrentPlayer().getMoney();
                            lbu.farming = App.getCurrentGame().getCurrentPlayer().getFarming();
                            lbu.foraging = App.getCurrentGame().getCurrentPlayer().getForaging();
                            lbu.mining = App.getCurrentGame().getCurrentPlayer().getMining();
                            lbu.fishing = App.getCurrentGame().getCurrentPlayer().getFishing();
                            lbu.numberOfQuests = App.getCurrentGame().getCurrentPlayer().getActivatedQuestNPC().size();

                            Main.getMain().client.send(lbu);
                        }
                    } else {
                        if (lbu.senderUsername.equals(App.getCurrentGame().getCurrentPlayer().getUsername())) {
                            PlayerLeaderboard playerLeaderboard = new PlayerLeaderboard(lbu.receiverUsername,
                                lbu.money, lbu.farming, lbu.foraging, lbu.fishing, lbu.mining, lbu.numberOfQuests);
                            App.addPlayerLeaderboard(playerLeaderboard);
                        }
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
