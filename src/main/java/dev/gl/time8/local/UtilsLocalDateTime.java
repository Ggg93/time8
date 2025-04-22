package dev.gl.time8.local;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author gl
 */
public class UtilsLocalDateTime {

    public static LocalDateTime current() {
        return LocalDateTime.now();
    }
    
    public static LocalDateTime create(int year, Month month, int dayOfMonth, LocalTime lt) {
        return LocalDateTime.of(year, month, dayOfMonth, lt.getHour(), lt.getMinute(), lt.getSecond(), lt.getNano());
    }
   
    /**
     * 
     * @param datetime in pattern like '2011-12-03T10:15:30'
     * @return 
     */
    public static LocalDateTime parseByPattern_yyyy_MM_dd_T_HH_mm_ss(String datetime) {
        return LocalDateTime.parse(datetime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
    
    public static LocalDateTime getFutureLocalDateTime(int amountToAdd, ChronoUnit unit) {
        return LocalDateTime.now().plus(amountToAdd, unit);
    }
    
    public static LocalDateTime getPastLocalDateTime(int amountToSubtract, ChronoUnit unit) {
        return LocalDateTime.now().minus(amountToSubtract, unit);
    }

}
