package JavaUtilDateToJavaTimeLocalDate;

import java.time.LocalDateTime;
import java.util.Calendar;

public class CalendarToLocalDateTime {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        LocalDateTime localDateTime = LocalDateTime.of(year, month + 1, day,hour, minute, second);
        System.out.println(localDateTime);
    }
}
