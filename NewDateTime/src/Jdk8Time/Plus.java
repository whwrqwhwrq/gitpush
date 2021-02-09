package Jdk8Time;

import java.time.LocalDate;
import java.time.Period;

public class Plus {
    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        Period period = Period.of(2, 3, 4);

        LocalDate localDate = now.plus(period);

        System.out.println(localDate);
    }
}
