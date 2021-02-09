package Jdk8Time;

import java.time.LocalTime;

public class PlusInLocalTime {
    public static void main(String[] args) {
        LocalTime of = LocalTime.of(12, 12, 12,23);
        LocalTime localTime1 = of.plusNanos(233);
        LocalTime localTime = of.plusSeconds(500);
        LocalTime localTime2 = of.plusMinutes(66);
        LocalTime localTime3 = of.plusHours(6234);
        System.out.println(of);
        System.out.println(localTime1);
        System.out.println(localTime);
        System.out.println(localTime2);
        System.out.println(localTime3);
    }
}
