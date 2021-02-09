import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/*
创建十个线程，将 2020-02-02 02:02:02 转换为Date ，打印到控制台
 */
public class TreadWithDateAndSimpleDateFormat {

    final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {

        for (int i = 0; i <= 9; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(2020,1,2,2,2,2);
                    Date date = calendar.getTime();

                    String dateFormatStr = SIMPLE_DATE_FORMAT.format(date);
                    System.out.println(dateFormatStr);
                }
            }).start();
        }
        for (int i = 0; i <= 9; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        synchronized (SIMPLE_DATE_FORMAT){
                            Date date = SIMPLE_DATE_FORMAT.parse("2020-02-02 02:02:02");
                            System.out.println(date);
                        }

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
    }
}
