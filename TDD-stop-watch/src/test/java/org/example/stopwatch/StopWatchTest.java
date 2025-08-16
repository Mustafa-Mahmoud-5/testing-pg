package org.example.stopwatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;


/*
    DONE: Create a stopwatch that records minutes
    DONE: negative input should be ignored
    if minutes reached 60 it should increase hours
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
}
