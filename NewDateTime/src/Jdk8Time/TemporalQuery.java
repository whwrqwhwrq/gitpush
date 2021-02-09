package Jdk8Time;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
/*
* 当前日期距离下一个劳动节的 天数*/
public class TemporalQuery implements java.time.temporal.TemporalQuery<Long> {
    @Override
    public Long queryFrom(TemporalAccessor temporal) {
        LocalDate now = LocalDate.from(temporal);
        LocalDate ldj = LocalDate.of(now.getYear(), Month.MAY, 1);
        if (now.isAfter(ldj)) {
            ldj = LocalDate.of(now.getYear()+1, Month.MAY, 1);
        }
        long between = ChronoUnit.DAYS.between(now, ldj);

        return between;
    }

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        Long between = now.query(new TemporalQuery());
        System.out.println(between);

    }
}
