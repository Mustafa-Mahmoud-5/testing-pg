package org.example.stopwatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;


/*
    DONE: Create a stopwatch that records minutes
    DONE: negative input should be ignored
    DONE: if minutes reached 60 it should increase hours
    if hours reached 24 it should increase days
    days may be increased according to daily working hours

    example: addMinutes(50) => increase minutes by 50..
    if minutes > 60, we increase hours...
    if hours > 24 we increase the days


    For this example, we will have an interface that adds minutes, no hours, no days
* */


public class StopWatchTest {
    @Test
    public void constructing_SHOULD_setMinutesHoursDaysToZero() {
        StopWatch stopWatch = new StopWatch();

        Assertions.assertEquals(0, stopWatch.getMinutes());
        Assertions.assertEquals(0, stopWatch.getHours());
        Assertions.assertEquals(0, stopWatch.getDays());
    }

    @Test
    public void addMinutes_SHOULD_throwInvalidParameterException_WHEN_receiveNegativeParam() {
        // Arrange
        StopWatch stopWatch = new StopWatch();


        // Assert
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            // Act
            stopWatch.addMinutes(-7);
        });
    }


    @Test
    public void addMinutes_SHOULD_increaseHours_WHEN_minutesIsGreaterOrEqual60() {
        // Arrange;
        StopWatch stopWatch = new StopWatch();

        // Act
        stopWatch.addMinutes(125);


        // Assert
        // I do only care about the affect of minutes on hours not days
        Assertions.assertEquals(5, stopWatch.getMinutes());
        Assertions.assertEquals(2, stopWatch.getHours());
    }


    @Test
    public void addMinutes_SHOULD_increaseDays_WHEN_daysIsGreaterOrEqualDailyWorkingHours() {
        // Arrange
        StopWatch stopWatch = new StopWatch();
        int dailyWorkingHours = StopWatch.getDailyWorkingHours();


        // Act

        // make it 2 days, 3 hours, 10 minutes all in minutes
        int minutes = 10;
        int hours = 3*60;
        int days = 2 * dailyWorkingHours * 60;
        stopWatch.addMinutes(minutes+hours+days);

        // Assert
        Assertions.assertEquals(minutes, stopWatch.getMinutes());
        Assertions.assertEquals(3, stopWatch.getHours());
        Assertions.assertEquals(2, stopWatch.getDays());
    }

    @Test
    public void addMinutes_SHOULD_makeCorrectCalculation_WHEN_minutesAreIncreasedOnAnExistingState() {
        // Arrange
        StopWatch stopWatch = new StopWatch(3, 6, 5);

        // Act
        // add 3 hours and 5 minutes
        int minutes = 5;
        int hours = 3 * 60;
        int days = 0;
        stopWatch.addMinutes(minutes+hours+days);

        // Arrange

        Assertions.assertEquals(10, stopWatch.getMinutes());
        Assertions.assertEquals(1, stopWatch.getMinutes());
        Assertions.assertEquals(4, stopWatch.getMinutes());
    }
}
