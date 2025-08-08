package AP.group30.StardewValley.network;

import java.util.ArrayList;

public class ServerInfo {
    public String serverId;    // e.g. UUID or lobby name
    public String host;        // IP address
    public int    tcpPort;     // the port clients should connect to
    public int    udpPort;
    public long   lastHeard;   // timestamp in millis of last announcement
    public ArrayList<String> users = new ArrayList<>();
}
