import java.text.DecimalFormat;

/**
 * @Author:wrq
 * @Date:2021/3/1 14:27
 */
public class DoubleDecimal {
    public static void main(String[] args) {
        int a = 123;
        DecimalFormat df = new DecimalFormat("0.0000");
        String format = df.format(a);
        System.out.println(format);
    }
}
