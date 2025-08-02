package AP.group30.StardewValley.network;

import AP.group30.StardewValley.network.MessageClasses.WorldState;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServerMap {
    public final String mapId;
    // Only track players (and maybe dynamic entities) on this map
    private final Map<String, WorldState.Position> players = new ConcurrentHashMap<>();
    public boolean isPossible = false;

    public ServerMap(String mapId) {
        this.mapId = mapId;
    }

    public void addPlayer(String playerId, float startX, float startY) {
        WorldState.Position pos = new WorldState.Position();
        pos.x = startX; pos.y = startY;
        players.put(playerId, pos);
    }

    public void removePlayer(String playerId) {
        players.remove(playerId);
    }

    public void movePlayer(String playerId, float x, float y) {
        WorldState.Position pos = players.get(playerId);
        if (pos != null) {
            pos.x = x;
            pos.y = y;
        }
    }

    /**
     * Returns the minimal state the client needs to render this map:
     * just every player’s position.
     */
    public WorldState snapshot() {
        WorldState ws = new WorldState();
        ws.players.putAll(players);
        return ws;
    }

    /**
     * (Optional) If you want server to enforce collisions:
     * load your JSON once here (but don’t keep full Tile objects).
     */
    // private final boolean[][] passable;
    // public void loadCollisionGrid(...) { … }
    // public boolean isPassable(float x, float y) { … }

    public Map<String, WorldState.Position> getPlayers() {
        return players;
    }
}
