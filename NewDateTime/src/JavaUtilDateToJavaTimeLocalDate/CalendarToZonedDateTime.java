package JavaUtilDateToJavaTimeLocalDate;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.TimeZone;

public class CalendarToZonedDateTime {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Instant instant = calendar.toInstant();
        TimeZone timeZone = calendar.getTimeZone();
        ZoneId zoneId = timeZone.toZoneId();
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zoneId);
        System.out.println(calendar);
        System.out.println(zonedDateTime);
    }
}
