package models.Buildings;

public class GeneralStore extends Buildings {
    public GeneralStore(int height, int width, int startX, int startY) {
        super(height, width, startX, startY);
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
