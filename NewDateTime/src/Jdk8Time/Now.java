package Jdk8Time;

import java.time.*;

public class Now {
    public static void main(String[] args) {
        //使用now方法创建Instant对象
        Instant instant = Instant.now();
        //使用now方法创建LocalDate对象
        LocalDate localDate = LocalDate.now();
        //使用now方法创建LocalTime对象
        LocalTime localTime = LocalTime.now();
        //使用now方法创建LocalDateTime对象
        LocalDateTime localDateTime = LocalDateTime.now();
        //使用now方法创建ZonedDateTime对象
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(instant.toString()+"\n"+localDate+"\n"+localTime+"\n"+localDateTime+"\n"+zonedDateTime);
    }
}
