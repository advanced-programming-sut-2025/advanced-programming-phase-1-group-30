package AP.group30.StardewValley.network.MessageClasses;

import java.util.ArrayList;

public class PlayerJoinedLobby {
    public String username;
    public String playerId;
    public ArrayList<String> playersInLobby = new ArrayList<>();
}
