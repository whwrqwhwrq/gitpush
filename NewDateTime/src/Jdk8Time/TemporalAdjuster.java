package Jdk8Time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjuster {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        //将时间修改为当月第一天
        LocalDate with = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(with);

        LocalDate with1 = now.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(with1);

        LocalDate with2 = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(with2);

        LocalDate with3 = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println("下一个周日为" + with3);

        LocalDate with4 = now.with(TemporalAdjusters.previous(DayOfWeek.WEDNESDAY));
        System.out.println("上一个周三为" + with4);
    }
}
