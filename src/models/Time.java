package models;

import models.enums.Season;

public class Time {
    private int hour;
    private int minute;
    private int day;
    private int month;
    private Season season;
    private final Season startSeason = season.SPRING;
    private DaysOfWeek dayOfWeek;
}
