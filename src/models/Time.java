package models;

import models.enums.Season;

public class Time {
    private int hour;
    private int minute;
    private int day;
    private int month;
    private Season season;
    private final Season startSeason = Season.SPRING;
    private DaysOfWeek dayOfWeek;

    public Time(int hour, int minute, int day, int month, Season season, DaysOfWeek dayOfWeek) {
        this.hour = hour;
        this.minute = minute;
        this.day = day;
        this.month = month;
        this.season = season;
        this.dayOfWeek = dayOfWeek;
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
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public Season getSeason() {
        return season;
    }
    public void setSeason(Season season) {
        this.season = season;
    }
    public Season getStartSeason() {
        return startSeason;
    }
    public DaysOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
    public void setDayOfWeek(DaysOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
