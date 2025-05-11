package models.Buildings;

public class Saloon extends Buildings {

    public Saloon(int height, int width, int startX, int startY) {
        super(height, width, startX, startY);
    }
    private final int startHour = 12;
    private final int endHour = 12;
    
    public int getStartHour() {
        return startHour;
    }
    public int getEndHour() {
        return endHour;
    }
}
