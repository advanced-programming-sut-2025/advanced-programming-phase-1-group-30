package AP.group30.StardewValley.network.MessageClasses;

import java.util.HashMap;
import java.util.Map;

public class WorldState {
    // maps playerId → their latest position
    public Map<String, Position> players = new HashMap<>();
    // you can add other entities, e.g. NPCs, items, timeOfDay, etc.

    public static class Position {
        public float x, y;
    }
}
