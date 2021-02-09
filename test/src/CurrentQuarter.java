import java.util.Calendar;
import java.util.Date;

public class CurrentQuarter {
    public static void main(String[] args) {

        System.out.println(getTodayStart());
        System.out.println(getTodayEnd());
        System.out.println(getCurrentQuarterStart());
        System.out.println(getCurrentQuarterEnd());

    }

    public static Date getTodayStart() {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR_OF_DAY,0);
        instance.set(Calendar.MINUTE,0);
        instance.set(Calendar.SECOND,0);
        return instance.getTime();
    }
    public static Date getTodayEnd() {
        Calendar instance = Calendar.getInstance();
        instance.setTime(getTodayStart());
        instance.add(Calendar.DAY_OF_MONTH,1);
        return instance.getTime();
    }
    public static Date getCurrentQuarterStart() {
        Calendar instance = Calendar.getInstance();
        instance.setTime(getTodayStart());
        int curMonth = instance.get(Calendar.MONTH);
        if (curMonth >= Calendar.JANUARY && curMonth <= Calendar.MARCH) {
            instance.set(Calendar.MONTH,Calendar.JANUARY);
            instance.set(Calendar.DAY_OF_MONTH,1);
        } else if (curMonth >= Calendar.APRIL && curMonth <= Calendar.JUNE) {
            instance.set(Calendar.MONTH,Calendar.APRIL);
            instance.set(Calendar.DAY_OF_MONTH,1);
        } else if (curMonth >= Calendar.JULY && curMonth <= Calendar.SEPTEMBER) {
            instance.set(Calendar.MONTH,Calendar.JULY);
            instance.set(Calendar.DAY_OF_MONTH,1);
        } else {
            instance.set(Calendar.MONTH,Calendar.OCTOBER);
            instance.set(Calendar.DAY_OF_MONTH,1);
        }
        return instance.getTime();
    }
    public static Date getCurrentQuarterEnd() {
        Calendar instance = Calendar.getInstance();
        instance.setTime(getCurrentQuarterStart());
        instance.add(Calendar.DAY_OF_MONTH,90);
        return instance.getTime();
    }
}
