import java.util.Calendar;
import java.util.Date;

public class OldDateTest {
    public static void main(String[] args) {
        Date date = new Date();
        long currentTime = date.getTime();

        Calendar ca = Calendar.getInstance();
        ca.set(1997,9,1);
        Date birth = ca.getTime();

        long birthTime = birth.getTime();

        long l = (currentTime - birthTime) / 1000 / (24 * 60 * 60);

        System.out.println(l);
        System.out.println("________________________________");
        try {
            Date nullDate = null;
            System.out.println(nullDate.after(birth));
        } catch (NullPointerException npe) {
            System.out.println("空指针异常");
            System.out.println(npe.getMessage());
            npe.printStackTrace();
        }

    }
}
