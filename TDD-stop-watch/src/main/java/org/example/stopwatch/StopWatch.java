package org.example.stopwatch;

import java.security.InvalidParameterException;

public class StopWatch {
    private int minutes;
    private int hours;
    private int days;


    StopWatch() {
        this.minutes = 0;
        this.days = 0;
        this.hours = 0;
    }

    public void addMinutes(int minutes) {
        if(minutes < 0) throw new InvalidParameterException("minutes should be > 0");

        int expectedMinutes = this.minutes + minutes;

        this.minutes = expectedMinutes % 60;

        this.hours = this.hours + expectedMinutes / 60;
    }


    public int getMinutes() {
        return minutes;
    }

    public int getDays() {
        return days;
    }

    public int getHours() {
        return hours;
    }
}
