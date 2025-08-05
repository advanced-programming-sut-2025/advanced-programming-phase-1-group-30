package AP.group30.StardewValley.network;

import AP.group30.StardewValley.network.MessageClasses.MapTransfer;
import AP.group30.StardewValley.network.MessageClasses.PlayerJoin;
import AP.group30.StardewValley.network.MessageClasses.PlayerMove;
import AP.group30.StardewValley.network.MessageClasses.WorldState;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NetworkServer {
    private Server server;
    private final GameWorld world = new GameWorld();
    private final Map<Connection, String> connToPlayerId = new HashMap<>();
    private final Map<String, Connection> playerIdToConn = new HashMap<>();
    private int numPlayers = 1;

    public void start(int tcpPort, int udpPort) throws IOException {
        server = new Server();
        Kryo kryo = server.getKryo(); // or client.getKryo()
        server.getKryo().register(Ping.class);
        kryo.register(PlayerJoin.class);
        kryo.register(PlayerMove.class);
        kryo.register(WorldState.class);
        kryo.register(MapTransfer.class);
        kryo.register(WorldState.Position.class);
        kryo.register(HashMap.class);

        // Correct: extend Listener, don’t implement it
        server.addListener(new Listener() {
            @Override
            public void received(Connection connection, Object object) {
                if (object instanceof Ping) {
                    Ping ping = (Ping) object;
                    System.out.println("[Server] got ping: " + ping.text);

                    String playerId = ping.playerId; // e.g. "player1"

                    Ping pong = new Ping();
                    pong.text = "Pong!";
                    pong.playerId = String.valueOf(numPlayers);
                    connection.sendTCP(pong);
                }
                if (object instanceof PlayerJoin) {
                    PlayerJoin pj = (PlayerJoin) object;
                    handlePlayerJoin(connection, pj);
                } else if (object instanceof PlayerMove) {
                    handlePlayerMove(connection, (PlayerMove) object);
                } else if (object instanceof MapTransfer) {
                    System.out.println("Received map transfer for player");
                    handleMapTransfer(connection, (MapTransfer) object);
                }
            }

            @Override
            public void disconnected(Connection connection) {
                String playerId = connToPlayerId.remove(connection); // remove from tracking
                if (playerId != null) {
                    playerIdToConn.remove(playerId); // clean reverse map
                    ServerPlayer player = world.players.remove(playerId);
                    if (player != null) {
                        ServerMap map = world.maps.get(player.currentMapId);
                        if (map != null) {
                            map.removePlayer(playerId); // if you have this method
                        }
                        System.out.println("[Server] Player disconnected: " + playerId);

                        // Optionally, send update to remaining players
                        WorldState state = map.snapshot();
                        for (Connection c : server.getConnections()) {
                            String pid = connToPlayerId.get(c);
                            ServerPlayer p = world.players.get(pid);
                            if (p != null && p.currentMapId.equals(player.currentMapId)) {
                                c.sendTCP(state);
                            }
                        }
                    }
                }
            }
        });

        server.bind(tcpPort, udpPort);
        server.start();
        System.out.println("[Server] listening on TCP/" + tcpPort + " UDP/" + udpPort);
    }

    public void stop() {
        server.stop();
        System.out.println("[Server] stopped.");
    }

    private void handlePlayerJoin(Connection conn, PlayerJoin join) {
        // Create a new farm map and player in world
        String farmId = "farm_" + join.playerId;
        ServerMap farmMap = new ServerMap(farmId);
        world.maps.put(farmId, farmMap);

        connToPlayerId.put(conn, join.playerId);
        playerIdToConn.put(join.playerId, conn);
        ServerPlayer sp = new ServerPlayer(
            join.playerId,
            join.displayName,
            farmId,
            /* startX */ 10,
            /* startY */ 10
        );

        world.players.put(sp.id, sp);
        farmMap.addPlayer(sp.id, sp.displayName,sp.x, sp.y);

        // Send initial snapshot
        conn.sendTCP(farmMap.snapshot());
        numPlayers++;

        System.out.println("received player join: " + join.displayName + " with id " + join.playerId);
    }

    private void handleMapTransfer(Connection connection, MapTransfer msg) {
        // 1) Look up the player
        System.out.println(msg.playerId);
        ServerPlayer player = world.players.get(msg.playerId);
        if (player == null) {
            return;
        }
        System.out.println(msg.playerId);

        // 2) Remove from old map
        ServerMap oldMap = world.maps.get(player.currentMapId);
        if (oldMap != null) {
            oldMap.removePlayer(player.id);
        }

        if (msg.targetMapId.equals("city")) {
            // Special case: city map
            ServerMap cityMap = world.maps.get("city");
            if (cityMap == null) {
                cityMap = new ServerMap("city");
                world.maps.put("city", cityMap);
            }
            // Add player to city map at a default position
            cityMap.addPlayer(player.id, player.displayName,0, 0);
            System.out.println(cityMap.getPlayers().size());
            player.currentMapId = "city";
            WorldState cityState = cityMap.snapshot();

            for (Connection c : server.getConnections()) {
                String otherId = connToPlayerId.get(c);
                if (otherId == null) continue;
                ServerPlayer other = world.players.get(otherId);
                if ("city".equals(other.currentMapId)) {
                    c.sendTCP(cityState);
                }
            }
            System.out.println("sent city map to all players");
            return;
        }

        // 3) Change the player's currentMapId
        player.currentMapId = msg.targetMapId;

        // 4) Add to the new map (create it if necessary)
        ServerMap newMap = world.maps.computeIfAbsent(
            msg.targetMapId,
            id -> new ServerMap(id)
        );
        newMap.addPlayer(player.id, player.displayName,player.x, player.y);

        // 5) Send the full snapshot of the new map back to this client only
        WorldState newMapState = newMap.snapshot();
        connection.sendTCP(newMapState);
        System.out.println("sent new map state to player " + player.id);
    }

    // Handles incoming PlayerMove messages
    private void handlePlayerMove(Connection connection, PlayerMove msg) {
        // 1) Look up the player
        ServerPlayer player = world.players.get(msg.playerId);
        if (player == null) return;  // unknown player

        String mapId = player.currentMapId;
        ServerMap map = world.maps.get(mapId);
        if (map == null) return;     // map not found

        // 2) Optional: enforce passability
//        if (!map.isPassable(msg.x, msg.y)) {
//            // You could send an “illegal move” message back here
//            return;
//        }

        // 3) Update server state
        player.x = msg.x;
        player.y = msg.y;
        map.movePlayer(player.id, player.x, player.y);
        WorldState cityState = map.snapshot();
        for (Connection c : server.getConnections()) {
            String otherId = connToPlayerId.get(c);
            if (otherId != null && "city".equals(world.players.get(otherId).currentMapId)) {
                c.sendTCP(cityState);
            }
        }

        // 4) Broadcast the updated map state to everyone on this map
    }
}
