import java.util.Calendar;

/**
 * @Author:wrq
 * @Date:2021/2/25 17:38
 */
public class CalendarTestFirstDayOfMonth {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        int month = instance.get(Calendar.MONTH);
        instance.set(Calendar.MONTH, month);
        instance.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(instance.getTime());
    }
}
