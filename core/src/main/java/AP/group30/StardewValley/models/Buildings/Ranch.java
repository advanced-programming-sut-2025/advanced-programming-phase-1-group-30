package AP.group30.StardewValley.models.Buildings;

public class Ranch extends Building {
    public Ranch(int height, int width, int startX, int startY) {
        super(height, width, startX, startY, 9, 16);
    }
    private final int startHour = 9;
    private final int endHour = 16;
    private RanchCosts ranchItems;

    public RanchCosts getRanchItems() {
        return ranchItems;
    }
    public int getStartHour() {
        return startHour;
    }
    public int getEndHour() {
        return endHour;
    }
}
