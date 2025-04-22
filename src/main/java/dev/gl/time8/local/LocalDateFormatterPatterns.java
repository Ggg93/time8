package dev.gl.time8.local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author gl
 */
public class LocalDateFormatterPatterns {

    public static final String ISO_LOCAL_DATE = "yyyy-MM-dd"; // 2011-12-03
    public static final String ISO_LOCAL_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss"; // 2011-12-03T10:15:30
    public static final String ISO_OFFSET_DATETIME = "yyyy-MM-dd'T'HH:mm:ss XXX"; // 2011-12-03T10:15:30 +01:00

    public static DateTimeFormatter getFormatter(String pattern) {
        return DateTimeFormatter.ofPattern(pattern);
    }

    public static String getFormattedDate(LocalDateTime ldt, DateTimeFormatter formatter) {
        return ldt.format(formatter);
    }
    
    public static String getFormattedDate(LocalDate ld, DateTimeFormatter formatter) {
        return ld.format(formatter);
    }
    
    public static String getFormattedDate(OffsetDateTime odt, DateTimeFormatter formatter) {
        return odt.format(formatter);
    }

}
