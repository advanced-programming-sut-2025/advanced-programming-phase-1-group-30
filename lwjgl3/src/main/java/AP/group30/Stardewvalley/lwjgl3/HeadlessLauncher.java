package AP.group30.Stardewvalley.lwjgl3;

import AP.group30.StardewValley.network.NetworkServer;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;

import java.io.IOException;

public class HeadlessLauncher {
    public static void main(String[] args) {
        HeadlessApplicationConfiguration cfg = new HeadlessApplicationConfiguration();
        // cfg.updatesPerSecond = 30; // optional tick rate

        NetworkServer server = new NetworkServer();
        try {
            server.start(54555, 54777);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // hook it into the libGDX headless loop (so you can schedule tasks in render())
        new HeadlessApplication(new HeadlessGame(server), cfg);
    }
}
