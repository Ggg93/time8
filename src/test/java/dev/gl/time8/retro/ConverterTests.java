package dev.gl.time8.retro;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gl
 */
public class ConverterTests {
    private static Date currentDate;
    private static Calendar currentCalendar;
    private static LocalDate currentLocalDate;
    private static LocalDateTime currentLocalDateTime;
    
    @BeforeAll
    static void init() {
        
        currentDate = new Date();
        
        currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(currentDate);
        
        currentLocalDate = LocalDate.now();
        currentLocalDateTime = LocalDateTime.now();
    }
    
    @Test
    void localDateToDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date = cal.getTime();
        assertTrue(date.equals(Converter.localDateToDate(currentLocalDate)));
    }
    
    @Test
    void localDateTimeToDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.set(Calendar.MILLISECOND, 0);
        Date date = cal.getTime();
        assertTrue(date.equals(Converter.localDateTimeToDate(currentLocalDateTime.withNano(0))));
    }
    
    @Test
    void dateToLocalDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date = cal.getTime();
        assertTrue(currentLocalDate.equals(Converter.dateToLocalDate(date)));
    }
    
    @Test
    void dateToLocalDateTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.set(Calendar.MILLISECOND, 0);
        Date date = cal.getTime();
        assertTrue(currentLocalDateTime.withNano(0).equals(Converter.dateToLocalDateTime(date)));
    }
    
    @Test
    void localDateToCalendar() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(Converter.localDateToDate(currentLocalDate));
        assertTrue(cal.equals(Converter.localDateToCalendar(currentLocalDate)));
    }
    
    @Test
    void localDateTimeToCalendar() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(Converter.localDateTimeToDate(currentLocalDateTime.withNano(0)));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        assertTrue(cal.equals(Converter.localDateTimeToCalendar(currentLocalDateTime.withNano(0))));
    }
    
    @Test
    void calendarToLocalDateTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        assertTrue(currentLocalDateTime.toLocalDate().atStartOfDay().equals(Converter.calendarToLocalDateTime(cal)));
    }
    
    @Test
    void calendarToLocalDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(Converter.localDateToDate(currentLocalDate));
        assertTrue(currentLocalDate.equals(Converter.calendarToLocalDate(cal)));
    }
}
