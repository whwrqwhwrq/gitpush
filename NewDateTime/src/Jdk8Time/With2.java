package Jdk8Time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class With2 {
    public static void main(String[] args) {
        LocalDateTime ldt = getLdt();
        LocalDateTime with = ldt.with(ChronoField.DAY_OF_MONTH, 16);
        System.out.println(with);
    }

    private static LocalDateTime getLdt() {
        return LocalDateTime.now();
    }
}
