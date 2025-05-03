package models.TimeAndDate;

public enum DaysOfWeek {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");
    private final String name;
    DaysOfWeek(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}