import DateUtil.DateUtil;

import java.util.Calendar;
import java.util.Date;

/*
初始化Calendar对象，封装日期 2030-5-1
 */
public class CalendarUnsafe {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2030, Calendar.MAY, 1);
        Date d = c.getTime();
        String s = DateUtil.toFormatDateString2(d);
        System.out.println(s);
    }
}
