package AP.group30.StardewValley.network;

public class ServerPlayer {
    public final String id;        // matches your PlayerJoin.playerId
    public String displayName;
    public String currentMapId;
    public float x, y;

    public ServerPlayer(String id, String displayName, String startMapId, float startX, float startY) {
        this.id = id;
        this.displayName = displayName;
        this.currentMapId = startMapId;
        this.x = startX;
        this.y = startY;
    }
}
