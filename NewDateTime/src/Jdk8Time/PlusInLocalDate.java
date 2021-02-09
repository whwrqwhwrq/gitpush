package Jdk8Time;

import java.time.LocalDate;
import java.time.Month;

public class PlusInLocalDate {
    public static void main(String[] args) {
        LocalDate of = LocalDate.of(2020, Month.JUNE, 23);
        //增加天数后，生成 新对象
        LocalDate localDate = of.plusDays(22);
        LocalDate localDate1 = of.plusWeeks(2);
        LocalDate localDate2 = of.plusMonths(2);
        LocalDate localDate3 = of.plusYears(2);
        System.out.println(of+"\n"+localDate+"\n"+localDate1+"\n"+localDate2+"\n"+localDate3);
        System.out.println(of.hashCode());
        System.out.println(localDate.hashCode());
        System.out.println(localDate.hashCode() == of.hashCode());
    }
}
