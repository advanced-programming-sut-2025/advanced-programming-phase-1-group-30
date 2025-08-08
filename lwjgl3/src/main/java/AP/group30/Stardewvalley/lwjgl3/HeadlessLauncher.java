package AP.group30.Stardewvalley.lwjgl3;

import AP.group30.StardewValley.network.NetworkServer;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;

import java.io.IOException;

public class HeadlessLauncher {
    public static void main(String[] args) {
        int tcpPort  = args.length > 0 ? Integer.parseInt(args[0]) : 54555;
        int udpPort  = args.length > 1 ? Integer.parseInt(args[1]) : 54777;

        HeadlessApplicationConfiguration cfg = new HeadlessApplicationConfiguration();
        NetworkServer server = new NetworkServer();
        try {
            server.start(tcpPort, udpPort);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        new HeadlessApplication(new HeadlessGame(server), cfg);
    }
}
