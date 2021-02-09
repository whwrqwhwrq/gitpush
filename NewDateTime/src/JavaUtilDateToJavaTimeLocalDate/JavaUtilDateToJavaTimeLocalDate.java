package JavaUtilDateToJavaTimeLocalDate;

import java.sql.Timestamp;
import java.time.*;
import java.util.Date;

public class JavaUtilDateToJavaTimeLocalDate {
    public static void main(String[] args) {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Shanghai"));
        LocalDate localDate = zonedDateTime.toLocalDate();
        System.out.println(date);
        System.out.println(localDate);
        System.out.println("-------------------------------------------");
        java.sql.Date date1 = new java.sql.Date(System.currentTimeMillis());
        LocalDate localDate1 = date1.toLocalDate();
        System.out.println(date1);
        System.out.println(localDate1);
        System.out.println("-------------------------------------------");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        System.out.println(timestamp);
        System.out.println(localDateTime);

    }
}
