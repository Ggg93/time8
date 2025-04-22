package dev.gl.time8.local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author gl
 */
public class LocalDateFormatterPatternsTests {

    @Test
    void getFormattedDateTest() {
        assertAll("Some tests for formatter",
                () -> assertEquals("2025-04-22T13:30:00",
                        LocalDateFormatterPatterns.getFormattedDate(LocalDateTime.of(2025, Month.APRIL, 22, 13, 30),
                                DateTimeFormatter.ISO_LOCAL_DATE_TIME)),
                () -> assertEquals("2025-04-22",
                        LocalDateFormatterPatterns.getFormattedDate(LocalDate.of(2025, Month.APRIL, 22),
                                DateTimeFormatter.ISO_LOCAL_DATE)),
                () -> assertEquals("2025-04-22T13:35:00 +03:00",
                        LocalDateFormatterPatterns.getFormattedDate(LocalDateTime.of(2025, Month.APRIL, 22, 13, 35, 0)
                                .atOffset(ZoneOffset.ofHours(3)),
                                LocalDateFormatterPatterns.getFormatter(LocalDateFormatterPatterns.ISO_OFFSET_DATETIME))));
    }
}
