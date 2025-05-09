package models.TimeAndDate;

public enum Season {
    ALL(0, "xxx"),
    SPRING(1, "Spring"),
    SUMMER(2, "Summer"),
    FALL(3, "Fall"),
    WINTER(4, " Winter");

    private final int number;
    private final String name;
    
    Season(int number, String name) {
        this.number = number;
        this.name = name;
    }
    public int getNumber() {
        return number;
    }
    public String getName() {
        return name;
    }
}
