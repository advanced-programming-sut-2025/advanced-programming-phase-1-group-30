package models.Buildings;

public class Blacksmith extends Buildings {
    public Blacksmith(int height, int width, int startX, int startY) {
        super(height, width, startX, startY);
    }
    private final int startHour = 9;
    private final int endHour = 16;
    
    public int getStartHour() {
        return startHour;
    }
    public int getEndHour() {
        return endHour;
    }
}
