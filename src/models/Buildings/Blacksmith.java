package models.Buildings;

public class Blacksmith extends Building {
    public Blacksmith(int height, int width, int startX, int startY) {
        super(height, width, startX, startY, 9, 16);
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
