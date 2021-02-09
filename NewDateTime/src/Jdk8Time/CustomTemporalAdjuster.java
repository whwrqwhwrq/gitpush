package Jdk8Time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/*
员工发薪日是每月的15日，如果当日是周末，则提前至周五发薪

传入一个日期时间对象，判断是否是15日，不是则修改到15日，如果是周六或周日则改为周五
 */
public class CustomTemporalAdjuster implements TemporalAdjuster {
    public static void main(String[] args) {
        LocalDate now = LocalDate.of(2018, 12, 2);
        CustomTemporalAdjuster customTemporalAdjuster = new CustomTemporalAdjuster();

        LocalDate with = now.with(customTemporalAdjuster);
        System.out.println(with);
    }

    @Override
    public Temporal adjustInto(Temporal temporal) {
//        Temporal是日期时间类的父接口
        LocalDate localDate = LocalDate.from(temporal);
        int payDay;
        int dayOfMonth = localDate.getDayOfMonth();
        if (dayOfMonth != 15) {
            payDay = 15;
        } else {
            payDay = dayOfMonth;
        }
        LocalDate payDate = localDate.withDayOfMonth(payDay);

        DayOfWeek dayOfWeek = payDate.getDayOfWeek();

        if (dayOfWeek == DayOfWeek.SATURDAY) {
            payDate = payDate.minusDays(1);
        }
        if (dayOfWeek == DayOfWeek.SUNDAY) {
            payDate = payDate.minusDays(2);
        }
        return payDate;
    }
}
