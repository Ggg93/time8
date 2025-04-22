package dev.gl.time8.local;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gl
 */
public class UtilsLocalTimeTests {
    private static LocalTime current;
    
    @BeforeAll
    static void init() {
        current = LocalTime.now();
    }
    
    @Test
    void create() {
        assertEquals(LocalTime.of(0, 30, 0), UtilsLocalTime.create(0, 30, 0));
    }
    
    @Test
    void parseByPattern() {
        assertEquals(current, UtilsLocalTime.parseByPattern_HH_mm_ss(current.toString()));
    }
    
    @Test
    void getFutureTime() {
        assertEquals(current.plusHours(1).withNano(0), 
                UtilsLocalTime.getFutureTime(1, ChronoUnit.HOURS).withNano(0));
    }
    
    @Test
    void getPastTime() {
        assertEquals(current.minusMinutes(15).withNano(0), 
                UtilsLocalTime.getPastTime(15, ChronoUnit.MINUTES).withNano(0));
    }
    
    @Test
    void getStartOfTheDay() {
        assertEquals(LocalTime.MIN, UtilsLocalTime.atStartOfDay());
    }
    
    @Test
    void getEndOfTheDay() {
        assertEquals(LocalTime.MAX, UtilsLocalTime.atEndOfDay());
    }
    
    @Test
    void getPeriodBetweenTimes() {
        assertEquals(10, UtilsLocalTime.getPeriodBetweenTimes(current, current.plus(10, ChronoUnit.MINUTES), ChronoUnit.MINUTES));
    }
}
