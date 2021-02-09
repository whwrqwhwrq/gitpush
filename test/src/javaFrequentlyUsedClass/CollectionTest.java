package javaFrequentlyUsedClass;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionTest {
    public static void main(String[] args) {
        /*
        将map中的互不相同的key 映射成一个set集合
         */
        Map<Object, Object> objectObjectMap = new HashMap<>();
        objectObjectMap.put("1", "1");
        objectObjectMap.put("2", "2");
        objectObjectMap.put("3", "3");
        objectObjectMap.put("4", "4");
        objectObjectMap.put("5", "4");
        System.out.println(objectObjectMap);

        Collection<Object> values = objectObjectMap.values();
        System.out.println(values);
        Set<Object> collect = objectObjectMap.entrySet().stream().map(item -> item.getKey()).collect(Collectors.toSet());
        for (Object o : collect) {
            System.out.print(o);
            System.out.print(" ");
        }
        System.out.println();
         /*
        将set中所有元素添加到List集合中
         */
        HashSet<String> stringSet = new HashSet<>();
        ArrayList<String> stringList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
//            stringSet.add(String.valueOf(new Random(System.currentTimeMillis())
//                    .nextDouble()));
            stringSet.add(String.valueOf(new Random().nextInt(9999)));

        }
        System.out.println(stringSet);
        boolean b = stringList.addAll(stringSet);
        String success = b ? "添加成功" : "添加失败";
        System.out.println(success);
        stringList.stream().forEach(a -> System.out.print(a + "  "));
        System.out.println();
        /*
        用迭代器遍历，尝试修改Set集合中的值
         */
        HashSet<String> stringSet1 = new HashSet<>();
        stringSet1.add("测试1");
        stringSet1.add("测试2");
        stringSet1.add("测试3");
        stringSet1.add("测试4");

        Iterator<String> stringIterator = stringSet1.iterator();
        while (stringIterator.hasNext()) {
            String next = stringIterator.next();
            System.out.println(next);
            if (next.equals("测试1")) {
                stringSet1.remove("测试3");
            }
        }
        for (String s : stringSet1) {
            System.out.println(s);
        }

        /*
        测试Queue的实现类PriorityQueue
         */
        PriorityQueue<Character> charQueue = new PriorityQueue<>();
        for (int i = 0; i < 26; i++) {
            Character character = (char) (i + 97);
            charQueue.offer(character);
        }
        System.out.println(charQueue);
        Character remove = charQueue.remove();
        System.out.println(remove);
        System.out.println(charQueue);
        Character poll = charQueue.poll();
        System.out.println(poll);
        System.out.println(charQueue);

    }



}
