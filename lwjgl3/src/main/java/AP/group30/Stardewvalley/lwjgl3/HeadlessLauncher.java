package AP.group30.Stardewvalley.lwjgl3;

import AP.group30.StardewValley.network.NetworkServer;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;

import java.io.IOException;

public class HeadlessLauncher {
    public static void main(String[] args) {
        System.out.println("CHILD CLASSPATH=" + System.getProperty("java.class.path"));
        try { Class.forName("AP.group30.StardewValley.network.ServerPlayer"); System.out.println("ServerPlayer OK"); }
        catch (Throwable t) { t.printStackTrace(); }
        int tcpPort  = args.length > 0 ? Integer.parseInt(args[0]) : 54555;
        int udpPort  = args.length > 1 ? Integer.parseInt(args[1]) : 54777;
        String serverId = args.length > 2 ? args[2] : "default";
        String isPrivateString = args.length > 3 ? args[3] : "false";
        String password = args.length > 4 ? args[4] : "";
        String isVisibleString = args.length > 5 ? args[5] : "true";
        String lobbyUniqueId = args.length > 6 ? args[6] : "1111";
        boolean isPrivate = false;
        if (isPrivateString.equals("true")) {
            isPrivate = true;
        }
        boolean isVisible = true;
        if (isVisibleString.equals("false")) {
            isVisible = false;
        }

        HeadlessApplicationConfiguration cfg = new HeadlessApplicationConfiguration();
        NetworkServer server = new NetworkServer();
        try {
            server.start(tcpPort, udpPort, serverId, isPrivate, password, isVisible, lobbyUniqueId);
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
