package models.Buildings;

public class Saloon extends Building {

    public Saloon(int lenght, int width, int startX, int startY) {
        super(lenght, width, startX, startY);
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
