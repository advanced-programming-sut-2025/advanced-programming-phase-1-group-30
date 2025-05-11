package models.Buildings;


public class Carpenter extends Building {
    public Carpenter(int height, int width, int startX, int startY) {
        super(height, width, startX, startY);
    }
    private final int startHour = 9;
    private final int endHour = 20;
    
    public int getStartHour() {
        return startHour;
    }
    public int getEndHour() {
        return endHour;
    }
}
