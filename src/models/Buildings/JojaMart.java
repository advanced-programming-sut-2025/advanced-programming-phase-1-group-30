package models.Buildings;

public class JojaMart extends Building {

    public JojaMart(int height, int width, int startX, int startY) {
        super(height, width, startX, startY);
    }
    private final int startHour = 9;
    private final int endHour = 23;
    
    public int getStartHour() {
        return startHour;
    }
    public int getEndHour() {
        return endHour;
    }
}
