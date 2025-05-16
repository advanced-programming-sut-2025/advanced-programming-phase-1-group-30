package models.Buildings;

public class GeneralStore extends Building {
    public GeneralStore(int height, int width, int startX, int startY) {
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
