package dev.gl.time8.local;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author gl
 */
public class UtilsLocalTime {
    public static LocalTime current() {
        return LocalTime.now();
    }
    
    public static LocalTime create(int hours, int minutes, int seconds) {
        return LocalTime.of(hours, minutes, seconds);
    }
    
    public static LocalTime parseByPattern_HH_mm_ss(String time) {
        return LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME);
    }
    
    public static LocalTime getFutureTime(int amountToAdd, ChronoUnit unit) {
        return LocalTime.now().plus(amountToAdd, unit);
    }
    
    public static LocalTime getPastTime(int amountToSubtract, ChronoUnit unit) {
        return LocalTime.now().minus(amountToSubtract, unit);
    }
    
    public static LocalTime atStartOfDay() {
        return LocalTime.MIN;
    }
    
    public static LocalTime atEndOfDay() {
        return LocalTime.MAX;
    }
    
    public static long getPeriodBetweenTimes(LocalTime from, LocalTime to, ChronoUnit unit) {
        return unit.between(from, to);
    }
}
