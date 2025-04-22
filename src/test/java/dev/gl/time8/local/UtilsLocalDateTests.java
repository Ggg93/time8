package dev.gl.time8.local;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author gl
 */
public class UtilsLocalDateTests {

    private static LocalDate current;

    @BeforeAll
    static void init() {
        current = LocalDate.now();
    }

    @Test
    void getLocalDate() {
        assertEquals(LocalDate.now(),
                UtilsLocalDate.getLocalDateByCalendarDay(current.getYear(), current.getMonth(), current.getDayOfMonth()));
    }

    @Test
    void getLocalDateByPattern() {
        assertEquals(LocalDate.now(), UtilsLocalDate.getLocalDateByPattern_yyyy_MM_dd(current.toString()));
    }
    
    @Test
    void getFutureDate() {
        assertEquals(LocalDate.now().plusDays(10), UtilsLocalDate.getFutureDate(10, ChronoUnit.DAYS));
    }
    
    @Test
    void getPastDate() {
        assertEquals(LocalDate.now().minusWeeks(1), UtilsLocalDate.getPastDate(1, ChronoUnit.WEEKS));
    }
    
    @Test
    void getCurrentDayOfWeek() {
        assertEquals(LocalDate.now().getDayOfWeek(), UtilsLocalDate.getCurrentDayOfWeek());
    }
    
    @Test
    void getLengthOfMonth() {
        assertEquals(30, UtilsLocalDate.getLengthOfMonth(Month.APRIL));
    }
    
    @Test
    void getLengthOfYear() {
        assertEquals(365, UtilsLocalDate.getLengthOfYear(2025));
    }
    
    @Test
    void isLeapYear() {
        assertAll("Check leap and regular years",
                () -> assertTrue(UtilsLocalDate.isLeapYear(2020)),
                () -> assertFalse(UtilsLocalDate.isLeapYear(2021)));
    }
    
    @Test
    void isAfter() {
        assertAll("Checks for true and false",
                () -> assertFalse(UtilsLocalDate.isAfter(current.minusDays(1), current)),
                () -> assertTrue(UtilsLocalDate.isAfter(current, current.minusDays(1))));
    }
    
    @Test
    void isBefore() {
        assertAll("Checks for true and false",
                () -> assertTrue(UtilsLocalDate.isBefore(current.minusDays(1), current)),
                () -> assertFalse(UtilsLocalDate.isBefore(current, current.minusDays(1))));
    }
    
    @Test
    void getLocalDateAtStartOfTheDay() {
        assertEquals(current.atStartOfDay(), UtilsLocalDate.convertLocalDateToStartOfTheDay(LocalDate.now()));
    }
    
    @Test
    void adjustLocalDate() {
        assertAll("Test TemporalAdjusters",
                () -> assertEquals(LocalDate.now().minus(LocalDate.now().getDayOfMonth() - 1, ChronoUnit.DAYS), 
                        UtilsLocalDate.adjustLocalDate(current, TemporalAdjusters.firstDayOfMonth())));
    }
    
    @Test
    void getPeriodBetweenDates() {
        assertEquals(1, UtilsLocalDate.getPeriodBetweenDates(current, current.plusDays(1), ChronoUnit.DAYS));
    }

}
