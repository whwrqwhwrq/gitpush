package functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceUse {
    public static void main(String[] args) {
        Consumer<String> consumer = (s) -> System.out.println(String.format("消费了%s元",s));
        consume(consumer,"123");

        Supplier<Integer> supplier = () -> new Random().nextInt(100);
        int[] ints = supply(supplier, 80);
        String s = Arrays.toString(ints);
        System.out.println(s);

        Predicate<String> predicate = (ss) -> ss.equals("avxc");
        boolean b = predicate(predicate, "avxc");
        System.out.println(b);

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        Predicate<Integer> predicate1 = (i) -> i < 5 ;
        List<Integer> integers1 = predicate1(predicate1, integers);
        System.out.println(integers1);

        Function<String, List<String>> function = (string) -> {
            String[] split = string.split(",");
            List<String> strings = Arrays.asList(split);
            return strings;
        };
        List<String> strings = fun(function, "j,e,d,a,r0k");
        System.out.println(strings);
    }

    private static void consume(Consumer<String> consumer, String s) {
        consumer.accept(s);
    }
    private static int[] supply(Supplier<Integer> supplier, int size) {
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = supplier.get();
        }
        return ints;
    }
    private static boolean predicate(Predicate<String> predicate,String s) {
        boolean test = predicate.test(s);
        return test;
    }
    private static List<Integer> predicate1(Predicate<Integer> predicate,List<Integer> list) {
        List<Integer> res = new ArrayList<Integer>();
        for (Integer integer : list) {
            if (predicate.test(integer)) {
                res.add(integer);
            }
        }
        return res;
    }

    private static List<String> fun(Function<String, List<String>> function, String string) {
        return function.apply(string);
    }
}
