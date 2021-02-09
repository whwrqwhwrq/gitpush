package Jdk8Time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomFormat {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd !!!!!!!! HH:mm:ss"));
        System.out.println(format);
    }
}
