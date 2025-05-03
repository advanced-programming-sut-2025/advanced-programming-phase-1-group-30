package models.TimeAndDate;

public class Time {
    private int hour;
    private int minute;
    private int day;
    private Season season;
    private DaysOfWeek dayOfWeek;

    public Time() {
        this.hour = 9;
        this.minute = 0;
        this.day = 1;
        this.season = Season.SPRING;
        this.dayOfWeek = DaysOfWeek.MONDAY;
    }
    
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public int getMinute() {
        return minute;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public Season getSeason() {
        return season;
    }
    public void setSeason(Season season) {
        this.season = season;
    }
    public DaysOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
    public void setDayOfWeek(DaysOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
