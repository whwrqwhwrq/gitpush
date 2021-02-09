package Jdk8Time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParseAndFormat {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ISO_DATE);
        String format1 = now.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(format+"\n"+format1);
        LocalDateTime parse = LocalDateTime.parse("20200331232306",DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        System.out.println(parse);
    }
}
