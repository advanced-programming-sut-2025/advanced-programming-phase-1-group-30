package AP.group30.StardewValley.network.MessageClasses;

/**
 * Sent by a client when the player wants to move from one map to another.
 * The server will remove the player from the old map and place them
 * into the target map, then reply with the new map’s state.
 */
public class MapTransfer {
    /** The unique ID of the player making the transfer. */
    public String playerId;
    /** The mapId of the destination map (e.g. "city", "farm_1234"). */
    public String targetMapId;

    /** Zero-arg constructor required for Kryo serialization. */
    public MapTransfer() { }

    /** Convenience constructor. */
    public MapTransfer(String playerId, String targetMapId) {
        this.playerId = playerId;
        this.targetMapId = targetMapId;
    }
}
