import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
//        A a = new A();
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        a.setMap(map);
//        map.put(1, 213113);
//        map.put(2,2342424);
//        map.put(3, 334);
//        map.put(4, 334);
//        System.out.println(a.getMap().get(4));
        String a = "a";
        String b = "b";
        String c = "c";

        ArrayList<Object> li = new ArrayList<>();
        li.add("123");
        li.add("1234");
        li.add("1234545");
        li.add("1236666");
        boolean bool = li.stream().anyMatch(s -> s.equals("123"));
        System.out.println(bool);

        List<String> strings = Arrays.asList("23", "22", "34", "55");
        strings.stream().filter(s -> {return s.startsWith("2");})
            .filter(s -> {
                return s.equals("23");})
            .forEach(s -> {
            System.out.println(s);
        });
    }
}
