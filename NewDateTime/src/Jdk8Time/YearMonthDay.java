package Jdk8Time;

import java.time.*;

public class YearMonthDay {
    public static void main(String[] args) {
        Year year = Year.now();
        YearMonth yearMonth1 = YearMonth.now();
        MonthDay monthDay = MonthDay.now();
        System.out.println(year+"\n"+yearMonth1+"\n"+monthDay);

        Month month = Month.of(6);
        YearMonth yearMonth = year.atMonth(month);
        LocalDate localDate = yearMonth.atDay(3);

        System.out.println(localDate);

        System.out.println(yearMonth.toString());
    }
}
