package stream;

import pojo.Computer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * filter:过滤
 * limit:限制
 * skip:跳过
 * distinct:去重
 * sorted:排序
 * map:映射成另外一个流
 * parallel:并行
 */
public class StreamMiddleOperation {
    public static void main(String[] args) {
        List<Computer> list = new ArrayList<Computer>();
        list.add(new Computer("联想", 7499));
        list.add(new Computer("华硕", 6999));
        list.add(new Computer("戴尔", 8800));
        list.add(new Computer("惠普", 7999));
        Stream<Computer> stream = list.stream();
        //筛选价格大于七千五的 电脑
        stream.filter(e -> e.getPrice() > 7500).forEach(System.out::println);
        System.out.println("______________");
        //取前三个
        Stream<Computer> stream1 = list.stream();
        stream1.limit(3).forEach(System.out::println);
        System.out.println("______________");

        //跳过两个元素
        list.stream().skip(2).forEach(System.out::println);
        System.out.println("______________");

        //去重
        list.add(new Computer("惠普", 7999));
        list.add(new Computer("惠普", 7999));
        list.add(new Computer("惠普", 7999));
        list.add(new Computer("惠普", 7999));
        list.add(new Computer("惠普", 7999));
        list.stream().distinct().forEach(System.out::println);
        System.out.println("______________");

        //排序
        list.stream().sorted((c1, c2) -> Integer.compare(c1.getPrice(), c2.getPrice())).forEach(System.out::println);
        System.out.println("______________");

        //获取电脑品牌
        List<String> collect = list.stream().map((c) -> c.getBrand()).collect(Collectors.toList());
        collect.stream().forEach(s -> System.out.println(s));
        System.out.println("______________");

        //并行流
        list.parallelStream().forEach(System.out::println);

        ArrayList<String> list1 = new ArrayList<>();
        for (int i = 0; i < 5000000; i++) {
            list1.add(UUID.randomUUID().toString());
        }
        long start = System.currentTimeMillis();
        long count = list1.stream().sorted().count();
        System.out.println(count);
        long end = System.currentTimeMillis();
        System.out.println("串行流用时"+(end - start)+"毫秒");

        long start1 = System.currentTimeMillis();
        long count1 = list1.parallelStream().sorted().count();
        System.out.println(count1);
        long end1 = System.currentTimeMillis();
        System.out.println("并行流用时"+(end1 - start1)+"毫秒");
    }
}
