package AP.group30.StardewValley.network;

import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.network.MessageClasses.PlayerJoin;
import AP.group30.StardewValley.network.MessageClasses.WorldState;

import java.util.HashMap;
import java.util.Map;

public class GameWorld {
    Map<String, ServerMap> maps = new HashMap<>(); // mapId → GameMap
    Map<String, ServerPlayer> players = new HashMap<>(); // playerId → Player

    public GameWorld() {
        // Create city map
        maps.put("city", new ServerMap("city"));

        // Per-player farm maps will be added as players join
    }

    public void addPlayer(PlayerJoin join) {
        String farmMapId = "farm_" + join.playerId;
        ServerMap farm = new ServerMap(farmMapId);
        maps.put(farmMapId, farm);

        ServerPlayer p = new ServerPlayer(join.playerId, join.displayName, farmMapId, 0, 0);
        players.put(join.playerId, p);

        maps.get(farmMapId).addPlayer(p.id, p.displayName,0, 0);
    }

    public void movePlayer(String playerId, float x, float y) {
        ServerPlayer p = players.get(playerId);
        p.x = x; p.y = y;
    }

    public void transferPlayerToMap(String playerId, String newMapId) {
        ServerPlayer p = players.get(playerId);
        ServerMap oldMap = maps.get(p.currentMapId);
        ServerMap newMap = maps.get(newMapId);

        oldMap.removePlayer(playerId);
        newMap.addPlayer(p.id, p.displayName,0, 0);
        p.currentMapId = newMapId;
    }

    public WorldState getMapState(String mapId) {
        return maps.get(mapId).snapshot();
    }
}
