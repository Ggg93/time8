package dev.gl.time8.zoned;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gl
 */
public class UtilsZonedDateTimeTests {

    @Test
    void availableZonesStringNotEmpty() {
        assertFalse(UtilsZonedDateTime.getAvailableZones().isEmpty());
    }
    
    @Test
    void availableZonesStringContainsSpecificZone() {
        assertTrue(UtilsZonedDateTime.getAvailableZones().contains("Europe/Moscow"));
    }
    
    @Test
    void getZoneIdByName() {
        assertEquals(ZoneId.of("Europe/Zurich"), UtilsZonedDateTime.getZoneByName("Europe/Zurich"));
    }
    
    @Test
    void getZonedDateTime() {
        LocalDateTime current = LocalDateTime.now();
        ZoneId systemZone = ZoneId.systemDefault();
        ZonedDateTime expected = ZonedDateTime.of(current, systemZone);
        assertEquals(expected, UtilsZonedDateTime.getZonedDateTime(current, systemZone));
    }
    
    @Test
    void getOffsetDateTime() {
        LocalDateTime current = LocalDateTime.now();
        int offsetHours = 3;
        OffsetDateTime expected = OffsetDateTime.of(current, ZoneOffset.ofHours(offsetHours));
        assertEquals(expected, UtilsZonedDateTime.getOffsetDateTime(current, offsetHours));
    }

}
