package models.Buildings;

public class JojaMart extends Buildings {

    public JojaMart(int lenght, int width, int startX, int startY) {
        super(lenght, width, startX, startY);
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
