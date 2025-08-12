package AP.group30.StardewValley.models;

import AP.group30.StardewValley.models.Players.RemotePlayer;
import AP.group30.StardewValley.network.MessageClasses.PlayerMove;
import AP.group30.StardewValley.network.MessageClasses.Vote;
import AP.group30.StardewValley.network.MessageClasses.WorldState;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GameModel {
    private String myPlayerId;
    private Map<String, RemotePlayer> otherPlayers = new HashMap<>();
    private Vote vote;

    public void setMyPlayerId(String id) { this.myPlayerId = id; }

    /** Called when a new City WorldState arrives **/
    public void setCurrentWorldState(WorldState ws) {
        otherPlayers.clear();
        for (var entry : ws.players.entrySet()) {
            String pid = entry.getKey();
            WorldState.Position pos = entry.getValue();
            RemotePlayer rp = new RemotePlayer(pid, entry.getValue().username,pos.x, pos.y);
            otherPlayers.put(pid, rp);
        }
    }

    public void moveOtherPlayers(PlayerMove pm) {
        for (RemotePlayer rp : otherPlayers.values()) {
            if (rp.id.equals(pm.playerId)) {
                rp.x = pm.x;
                rp.y = pm.y;
                System.out.println("Moved remote player: " + pm.playerId + " to (" + pm.x + ", " + pm.y + ")");
                return; // found and updated the player
            }
        }
    }

    public Collection<RemotePlayer> getOtherPlayers() {
        return otherPlayers.values();
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }
}
