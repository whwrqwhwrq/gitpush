package Jdk8Time;

import java.time.LocalDateTime;

public class With1 {
    public static void main(String[] args) {
        LocalDateTime ldt = getLdt();
        LocalDateTime localDateTime = ldt.withHour(8).withDayOfMonth(22);
        System.out.println(localDateTime);

    }

    private static LocalDateTime getLdt() {
        return LocalDateTime.now();
    }
}
