package Jdk8Time;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PlusWithQuiz {
    public static void main(String[] args) {
        LocalDateTime of = LocalDateTime.of(2019, 2, 22, 22, 3, 2);
       //方式一
        Period period = Period.of(3, 2, 1);
        LocalDateTime plus = of.plus(period);
        System.out.println(plus);
        //方式二
        LocalDateTime localDateTime = of.plusYears(3).plusMonths(2).plusDays(1);
        System.out.println(localDateTime);
        //方式三
        LocalDateTime plus1 = of.plus(3, ChronoUnit.YEARS)
                                .plus(2, ChronoUnit.MONTHS)
                                .plus(1, ChronoUnit.DAYS);
        System.out.println(plus1);
    }
}
