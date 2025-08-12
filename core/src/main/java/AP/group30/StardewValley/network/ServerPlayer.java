package AP.group30.StardewValley.network;

import com.esotericsoftware.kryonet.Connection;

public class ServerPlayer {
    public final String id;        // matches your PlayerJoin.playerId
    public String displayName;
    public String currentMapId;
    public float x, y;
    public Connection connection;

    public ServerPlayer(String id, String displayName, String startMapId, float startX, float startY, Connection connection) {
        this.id = id;
        this.displayName = displayName;
        this.currentMapId = startMapId;
        this.x = startX;
        this.y = startY;
        this.connection = connection;
    }
}
