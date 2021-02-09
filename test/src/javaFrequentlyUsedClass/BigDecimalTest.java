package javaFrequentlyUsedClass;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal double1 = BigDecimal.valueOf(112.3232321);
        BigDecimal double2 = BigDecimal.valueOf(11.32327868321);

        System.out.println(double1.add(double2).doubleValue());
    }
}
