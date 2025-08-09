package AP.group30.Stardewvalley.lwjgl3;

import AP.group30.StardewValley.network.NetworkServer;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;

import java.io.IOException;

public class HeadlessLauncher {
    public static void main(String[] args) {
        int tcpPort  = args.length > 0 ? Integer.parseInt(args[0]) : 54555;
        int udpPort  = args.length > 1 ? Integer.parseInt(args[1]) : 54777;
        String serverId = args.length > 2 ? args[2] : "default";

        HeadlessApplicationConfiguration cfg = new HeadlessApplicationConfiguration();
        NetworkServer server = new NetworkServer();
        try {
            server.start(tcpPort, udpPort, serverId);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Shutdown hook: called on normal termination (SIGTERM) so server.stop() runs.
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutdown hook triggered: stopping server...");
            server.stop();
            // Optionally call Gdx.app.exit() if you started a HeadlessApplication
            try { Thread.sleep(200); } catch (InterruptedException ignored) {}
        }));

        new HeadlessApplication(new HeadlessGame(server), cfg);
    }
}
