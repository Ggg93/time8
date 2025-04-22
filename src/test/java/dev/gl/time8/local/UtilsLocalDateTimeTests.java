package dev.gl.time8.local;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gl
 */
public class UtilsLocalDateTimeTests {
    private static LocalDateTime current;
    
    @BeforeAll
    static void init() {
        current = LocalDateTime.now();
    }
    
    @Test
    void testCreate() {
        assertEquals(current, 
                UtilsLocalDateTime.create(current.getYear(), current.getMonth(), current.getDayOfMonth(), 
                        LocalTime.of(current.getHour(), current.getMinute(), current.getSecond(), current.getNano())));
    }
    
    @Test
    void parseByISOLocalDateTimePattern() {
        assertEquals(current, UtilsLocalDateTime.parseByPattern_yyyy_MM_dd_T_HH_mm_ss(current.toString()));
    }
    
    @Test
    void getFutureDate() {
        assertEquals(current.plusDays(10).withNano(0), 
                UtilsLocalDateTime.getFutureLocalDateTime(10, ChronoUnit.DAYS).withNano(0));
    }
    
    @Test
    void getPastDate() {
        assertEquals(current.minusWeeks(1).withNano(0), 
                UtilsLocalDateTime.getPastLocalDateTime(1, ChronoUnit.WEEKS).withNano(0));
    }
    
    
}
