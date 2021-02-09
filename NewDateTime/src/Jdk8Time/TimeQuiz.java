package Jdk8Time;

import java.time.*;

public class TimeQuiz {
    public static void main(String[] args) {
        //创建当前时间（不带时区）
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // 创建当前时间（只包含年月日）
        LocalDate now1 = LocalDate.now();
        System.out.println(now1);
        // 创建当前时间，并带有时区
        LocalDateTime now2 = LocalDateTime.now();
        ZonedDateTime zonedDateTime = now2.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);
        // 创建2012年12月12日3时3分45秒的日期对象，月份用枚举表示
        LocalDateTime of = LocalDateTime.of(2012, Month.DECEMBER, 12, 3, 3, 45);
        System.out.println(of);
        // 创建2099年1月1日 的日期对象，月份用枚举
        LocalDate of1 = LocalDate.of(2099, Month.JANUARY, 1);
        System.out.println(of1);
        //创建5时34分22秒的时间对象
        LocalTime of2 = LocalTime.of(5, 34, 22);
        System.out.println(of2);
    }
}
