package stream;

import pojo.Computer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * forEach:
 * min:
 * max:
 * count:
 * reduce:
 * collect:
 */
public class StreamEndOperation {
    public static void main(String[] args) {
        List<Computer> list = new ArrayList<Computer>();
        list.add(new Computer("联想", 7499));
        list.add(new Computer("华硕", 6999));
        list.add(new Computer("戴尔", 8800));
        list.add(new Computer("惠普", 7999));
        //价格最低的品牌
        Computer computer = list.stream().min((c1, c2) -> c1.getPrice().compareTo(c2.getPrice())).get();
        System.out.println(computer.getBrand());
        //价格最高的品牌
        Computer computer1 = list.stream().max((c1, c2) -> c1.getPrice().compareTo(c2.getPrice())).get();
        System.out.println(computer1.getBrand());
        //个数
        System.out.println(list.stream().count());
        //所有品牌的价格总和
        Integer sum = list.stream().map((c) -> c.getPrice()).reduce((a, b) -> a + b).get();
        System.out.println(sum);
        //获取电脑品牌
        List<String> collect = list.stream().map((c) -> c.getBrand()).collect(Collectors.toList());
        collect.stream().forEach(s -> System.out.print(s+"  "));
    }
}