package Jdk8Time;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class PlusTemporalUnit {
    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.of(2012, Month.DECEMBER, 12, 12, 12, 12);
        LocalDateTime plus = localDateTime.plus(1L, ChronoUnit.DECADES);
        System.out.println(plus);
        LocalDateTime localDateTime1 = plus.plusHours(12);
        System.out.println(localDateTime1);
        LocalDateTime plus1 = localDateTime1.plus(1, ChronoUnit.HALF_DAYS);
        System.out.println(plus1);
    }
}
