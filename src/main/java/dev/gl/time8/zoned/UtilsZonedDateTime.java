package dev.gl.time8.zoned;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.stream.Collectors;

/**
 *
 * @author gl
 */
public class UtilsZonedDateTime {

    public static final ZoneId SYSTEM_ZONE = ZoneId.systemDefault();

    public static String getAvailableZones() {
        String s = ZoneId.getAvailableZoneIds().stream()
                .sorted()
                .collect(Collectors.joining(System.lineSeparator()));
        return s;
    }

    /**
     *
     * @param name for example, "Europe/Moscow" or "Europe/Dublin"
     * @return
     */
    public static ZoneId getZoneByName(String name) {
        return ZoneId.of(name);
    }

    public static ZonedDateTime getZonedDateTime(LocalDateTime ldt, ZoneId zone) {
        return ZonedDateTime.of(ldt, zone);
    }

    /**
     * 
     * @param ldt
     * @param hoursOffsetFromGMT from -18 to 18
     * @return 
     */
    public static OffsetDateTime getOffsetDateTime(LocalDateTime ldt, int hoursOffsetFromGMT) {
        return OffsetDateTime.of(ldt, ZoneOffset.ofHours(hoursOffsetFromGMT));
    }
}
