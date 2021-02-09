package javaFrequentlyUsedClass;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            int i1 = random.nextInt(33);
            System.out.println(i1);
        }
    }
}
