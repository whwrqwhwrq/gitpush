import java.util.Calendar;
import java.util.Date;

/**
 * @Author:wrq
 * @Date:2021/2/25 17:38
 */
public class CalendarTestFirstDayOfMonth {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println(instance.getTime());
    }
}
