package org.example.stopwatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/*
    Create a stopwatch that records minutes
    negative input should be ignored
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
}
