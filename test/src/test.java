import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        A a = new A();

        HashMap<Integer, Integer> map = new HashMap<>();
        a.setMap(map);
        map.put(1, 213113);
        map.put(2,2342424);
        map.put(3, 334);
        map.put(4, 334);
        map.put(5, 334);
        map.put(6, 334);
        map.put(7, 334);
        map.put(8, 334);
        map.put(9, 334);
        map.put(10, 334);

        System.out.println(a.getMap().get(1));
        System.out.println(a.getMap().get(2));
        System.out.println(a.getMap().get(3));
        System.out.println(a.getMap().get(4));
        System.out.println(a.getMap().get(5));
        System.out.println(a.getMap().get(6));
        System.out.println(a.getMap().get(7));
    }
}
