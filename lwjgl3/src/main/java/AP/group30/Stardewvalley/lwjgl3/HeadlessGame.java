package AP.group30.Stardewvalley.lwjgl3;

import AP.group30.StardewValley.network.NetworkServer;
import com.badlogic.gdx.ApplicationListener;

public class HeadlessGame implements ApplicationListener {
    private final NetworkServer server;
    public HeadlessGame(NetworkServer server) {
        this.server = server;
    }
    @Override public void create() { }
    @Override public void render() {
        // here you could call server.update() if you add such a method,
        // or poll scheduled game‐state ticks.
    }
    @Override public void resize(int width, int height) { }
    @Override public void pause() { }
    @Override public void resume() { }
    @Override public void dispose() {
        server.stop();
    }
}
