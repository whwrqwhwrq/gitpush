package DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String toFormatDateString1(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);

    }
    public static String toFormatDateString2(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);

    }
}
