package models.Buildings;

public class Blacksmith extends Buildings {
    public Blacksmith(int lenght, int width, int startX, int startY) {
        super(lenght, width, startX, startY);
    }
    private final int startHour = 9;
    private final int endHour = 16;
}
