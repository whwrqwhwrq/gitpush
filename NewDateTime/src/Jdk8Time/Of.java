package Jdk8Time;

import java.time.*;

/*
指定时间节点
 */
public class Of {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2333, 3, 3);
        System.out.println(localDate);
        LocalTime localTime = LocalTime.of(20, 0, 8);
        System.out.println(localTime);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime);
        MonthDay monthDay = MonthDay.of(Month.MARCH, 3);
        System.out.println(monthDay);
    }
}
