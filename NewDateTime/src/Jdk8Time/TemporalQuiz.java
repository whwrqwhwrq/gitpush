package Jdk8Time;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.Arrays;
import java.util.List;

/**
 *计算任意时间与下一个圣诞节，儿童节，国庆节各相差多少天
 */
public class TemporalQuiz implements TemporalQuery<List<Integer>> {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        List<Integer> list = now.query(new TemporalQuiz());
        list.stream().forEach(period -> System.out.println(period+"天"));
    }

    @Override
    public List<Integer> queryFrom(TemporalAccessor temporal) {
        LocalDate tem = LocalDate.from(temporal);
        LocalDate chrismas = LocalDate.of(tem.getYear(), Month.DECEMBER, 25);
        LocalDate child = LocalDate.of(tem.getYear(), Month.JUNE, 1);
        LocalDate nation = LocalDate.of(tem.getYear(), Month.OCTOBER, 1);
        if (tem.isAfter(chrismas)) {
            chrismas = chrismas.plusYears(1);
        }
        if (tem.isAfter(child)) {
            child = child.plusYears(1);
        }
        if (tem.isAfter(nation)) {
            nation = nation.plusYears(1);
        }
        int between = (int) ChronoUnit.DAYS.between(tem, chrismas);
        int between1 = (int) ChronoUnit.DAYS.between(tem, child);
        int between2 = (int) ChronoUnit.DAYS.between(tem, nation);

        List<Integer> res = Arrays.asList(between, between1, between2);
        return res;
    }
}
