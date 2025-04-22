package dev.gl.time8.local;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;

/**
 *
 * @author gl
 */
public class UtilsLocalDate {
    public static LocalDate currentLocalDate() {
        return LocalDate.now();
    }
    
    public static LocalDate getLocalDateByCalendarDay(int year, Month month, int day) {
        return LocalDate.of(year, month, day);
    }
    
    public static LocalDate getLocalDateByPattern_yyyy_MM_dd(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
    }
    
    public static LocalDate getFutureDate(int amountToAdd, ChronoUnit unit) {
        return LocalDate.now().plus(amountToAdd, unit);
    }
    
    public static LocalDate getPastDate(int amountToSubtract, ChronoUnit unit) {
        return LocalDate.now().minus(amountToSubtract, unit);
    }
    
    public static DayOfWeek getCurrentDayOfWeek() {
        return LocalDate.now().getDayOfWeek();
    }
    
    public static boolean isLeapYear(int year) {
        return LocalDate.ofYearDay(year, 1).isLeapYear();
    }
    
    public static int getLengthOfMonth(Month m) {
        return LocalDate.of(2025, m, 1).lengthOfMonth();
    }
    
    public static int getLengthOfYear(int year) {
        return LocalDate.ofYearDay(year, 1).lengthOfYear();
    }
    
    public static boolean isAfter(LocalDate first, LocalDate second) {
        return first.isAfter(second);
    }
    
    public static boolean isBefore(LocalDate first, LocalDate second) {
        return first.isBefore(second);
    }
    
    public static LocalDateTime convertLocalDateToStartOfTheDay(LocalDate ld) {
        return ld.atStartOfDay();
    }
    
    public static LocalDate adjustLocalDate(LocalDate ld, TemporalAdjuster adjuster) {
        return ld.with(adjuster);
    }
    
    public static long getPeriodBetweenDates(LocalDate from, LocalDate to, ChronoUnit unit) {
        return unit.between(from, to);
    }
}
