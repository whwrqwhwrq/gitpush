package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("c");
        list.add("e");
        list.add("n");
        list.add("t");
        list.add("O");
        list.add("S");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::print);
        System.out.println();
//        stream.forEach(s -> System.out.println(s));

        String[] strArr = new String[5];
        for (int i = 0; i < 5; i++) {
            strArr[i] = "a"+i;
        }
        Stream<String> stream1 = Arrays.stream(strArr);
        stream1.forEach(System.out::print);
        System.out.println();

        Stream<String> stream2 = Stream.of(strArr);
        stream2.forEach(System.out::print);
        System.out.println();

        Stream<String> stream3 = Stream.iterate("i", s -> s += "i");
        stream3.limit(100).forEach(System.out::println);

        Stream<Integer> stream4 = Stream.generate(() -> new Random().nextInt(101));
        stream4.limit(22).forEach(System.out::println);

        IntStream intStream = IntStream.of(2, 22, 222, 2222);
        intStream.forEach(System.out::println);

        IntStream intStream1 = IntStream.range(1, 99);
        intStream1.forEach(System.out::print);
        System.out.println();

        IntStream intStream2 = IntStream.rangeClosed(1, 99);
        intStream2.forEach(System.out::print);
    }
}
