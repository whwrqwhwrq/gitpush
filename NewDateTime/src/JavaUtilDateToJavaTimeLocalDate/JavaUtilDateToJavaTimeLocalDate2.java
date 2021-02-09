package JavaUtilDateToJavaTimeLocalDate;

import java.time.LocalDate;
import java.util.Date;

public class JavaUtilDateToJavaTimeLocalDate2 {
    public static void main(String[] args) {
        Date date = new Date();
        long time = date.getTime();
        java.sql.Date date1 = new java.sql.Date(time);
        LocalDate localDate = date1.toLocalDate();
        System.out.println(date);
        System.out.println(date1);
        System.out.println(localDate);
    }
}
