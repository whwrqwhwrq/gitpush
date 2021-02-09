import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author:wrq
 * @Date:2020/11/25 15:57
 */
public class CurrentQuarterStartAndEnd {

    public static String getCurrentQuarterStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int curMonth = calendar.get(Calendar.MONTH);
        if (curMonth == 0 || curMonth == 1 || curMonth == 2) {
            calendar.set(Calendar.MONTH, 0);
            calendar.set(Calendar.DAY_OF_MONTH,1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE,0);
            calendar.set(Calendar.SECOND,0);
            calendar.set(Calendar.MILLISECOND,0);
        }
        if (curMonth == 3 || curMonth == 4 || curMonth == 5) {
            calendar.set(Calendar.MONTH, 3);
            calendar.set(Calendar.DAY_OF_MONTH,1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE,0);
            calendar.set(Calendar.SECOND,0);
            calendar.set(Calendar.MILLISECOND,0);
        }
        if (curMonth == 6 || curMonth == 7 || curMonth == 8) {
            calendar.set(Calendar.MONTH, 6);
            calendar.set(Calendar.DAY_OF_MONTH,1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE,0);
            calendar.set(Calendar.SECOND,0);
            calendar.set(Calendar.MILLISECOND,0);
        }
        if (curMonth == 9 || curMonth == 10 || curMonth == 11) {
            calendar.set(Calendar.MONTH, 9);
            calendar.set(Calendar.DAY_OF_MONTH,1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE,0);
            calendar.set(Calendar.SECOND,0);
            calendar.set(Calendar.MILLISECOND,0);
        }

        Date resDate = calendar.getTime();
        return  dateToString(resDate);
    }

    public static String getCurrentQuarterEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int curMonth = calendar.get(Calendar.MONTH);
        if (curMonth == 0 || curMonth == 1 || curMonth == 2) {
            calendar.set(Calendar.MONTH, 4);
            calendar.set(Calendar.DAY_OF_MONTH,1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE,0);
            calendar.set(Calendar.SECOND,0);
            calendar.set(Calendar.MILLISECOND,0);
        }
        if (curMonth == 3 || curMonth == 4 || curMonth == 5) {
            calendar.set(Calendar.MONTH, 6);
            calendar.set(Calendar.DAY_OF_MONTH,1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE,0);
            calendar.set(Calendar.SECOND,0);
            calendar.set(Calendar.MILLISECOND,0);
        }
        if (curMonth == 6 || curMonth == 7 || curMonth == 8) {
            calendar.set(Calendar.MONTH, 9);
            calendar.set(Calendar.DAY_OF_MONTH,1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE,0);
            calendar.set(Calendar.SECOND,0);
            calendar.set(Calendar.MILLISECOND,0);
        }
        if (curMonth == 9 || curMonth == 10 || curMonth == 11) {
            calendar.set(Calendar.YEAR,calendar.get(Calendar.YEAR)+1);
            calendar.set(Calendar.MONTH, 0);
            calendar.set(Calendar.DAY_OF_MONTH,1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE,0);
            calendar.set(Calendar.SECOND,0);
            calendar.set(Calendar.MILLISECOND,0);
        }

        Date resDate = calendar.getTime();
        return  dateToString(resDate);
    }
    private static String dateToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }


    public static void main(String[] args) {
        String currentQuarterStart = CurrentQuarterStartAndEnd.getCurrentQuarterStart(new Date());
        String currentQuarterEnd = CurrentQuarterStartAndEnd.getCurrentQuarterEnd(new Date());

        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR,1999);
        instance.set(Calendar.MONTH,6);
        String currentQuarterStart1 = CurrentQuarterStartAndEnd.getCurrentQuarterStart(instance.getTime());
        String currentQuarterEnd1 = CurrentQuarterStartAndEnd.getCurrentQuarterEnd(instance.getTime());

        System.out.println(currentQuarterStart1);
        System.out.println(currentQuarterEnd1);
        System.out.println(currentQuarterStart+" "+currentQuarterEnd);
        System.out.println(dateToString(Calendar.getInstance().getTime()));
    }
}
