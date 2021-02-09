package Jdk8Time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class OfLocalizedDate {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        String s = now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        String s1 = now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        String s2 = now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        String s3 = now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        System.out.println(s+"\n"+s1+"\n"+s2+"\n"+s3);
    }
}
