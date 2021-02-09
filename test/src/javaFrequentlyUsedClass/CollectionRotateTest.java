package javaFrequentlyUsedClass;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionRotateTest {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        Collections.rotate(list, 1);
        System.out.println(list);
        Collections.rotate(list, -2);
        System.out.println(list);
    }

}
