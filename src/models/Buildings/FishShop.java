package models.Buildings;

public class FishShop extends Building {
    public FishShop(int height, int width, int startX, int startY) {
        super(height, width, startX, startY, 9, 17);
    }
    private final int startHour = 9;
    private final int endHour = 17;
    
    public int getStartHour() {
        return startHour;
    }
    public int getEndHour() {
        return endHour;
    }
}
