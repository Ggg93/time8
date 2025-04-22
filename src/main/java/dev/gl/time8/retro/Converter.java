package dev.gl.time8.retro;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author gl
 */
public class Converter {

    private static final ZoneId SYSTEM_ZONE_ID = ZoneId.systemDefault();

    public static Date localDateToDate(LocalDate ld) {
        Date date = Date.from(ld.atStartOfDay(SYSTEM_ZONE_ID).toInstant());
        return date;
    }

    public static Date localDateTimeToDate(LocalDateTime ldt) {
        Date date = Date.from(ldt.atZone(SYSTEM_ZONE_ID).toInstant());
        return date;
    }

    public static LocalDate dateToLocalDate(Date date) {
        LocalDate ld = LocalDate.ofInstant(date.toInstant(), SYSTEM_ZONE_ID);
        return ld;
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), SYSTEM_ZONE_ID);
        return ldt;
    }

    public static Calendar localDateToCalendar(LocalDate ld) {
        Date date = localDateToDate(ld);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Calendar localDateTimeToCalendar(LocalDateTime ldt) {
        Calendar calendar = localDateToCalendar(ldt.toLocalDate());
        return calendar;
    }

    public static LocalDateTime calendarToLocalDateTime(Calendar calendar) {
        TimeZone tz = calendar.getTimeZone();
        ZoneId zoneId = tz != null ? tz.toZoneId() : SYSTEM_ZONE_ID;
        LocalDateTime ldt = LocalDateTime.ofInstant(calendar.toInstant(), zoneId);
        return ldt;
    }

    public static LocalDate calendarToLocalDate(Calendar calendar) {
        return calendarToLocalDateTime(calendar).toLocalDate();
    }

}
