package Jdk8Time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/*
时区信息获取
 */
public class TimeZone {
    public static void main(String[] args) {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        for (String availableZoneId : availableZoneIds) {
            System.out.println(availableZoneId);
        }

        availableZoneIds.forEach(System.out::println);

        availableZoneIds.forEach(availableZoneId -> {
            System.out.println(availableZoneId);
        });
        //默认时区
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("当前默认时区"+zoneId);

        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zonedDateTime1 = zonedDateTime.withZoneSameInstant(ZoneId.of("Europe/Athens"));
        ZonedDateTime zonedDateTime2 = zonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));

        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);

    }
}
