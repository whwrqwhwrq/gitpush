package leetcode.question1491;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @Author:wrq
 * @Date:2021/3/1 14:31
 */
public class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        salary[0] = 0;
        salary[salary.length - 1] = 0;
        int sum = Arrays.stream(salary).sum();
        double avr = (double) sum / (salary.length - 2);
        BigDecimal bigDecimal = new BigDecimal(avr);
        bigDecimal.setScale(4, BigDecimal.ROUND_DOWN);
        double v = bigDecimal.doubleValue();
        return v;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{5000,1000,2000,3000};
        double average = new Solution().average(ints);
        System.out.println(average);
    }
}
