package AP.group30.StardewValley.models.Players;

public enum Skills {
    TEST(0);

    private final int level;

    private Skills(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
