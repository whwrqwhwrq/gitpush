import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class NewTimeTest {
    public static void main(String[] args) {
        //使用java8新版本完成OldDateTest类中的操作
        long between = ChronoUnit.DAYS.between(LocalDate.of(1993, 3, 4), LocalDate.now());
        System.out.println(between);
    }
}
