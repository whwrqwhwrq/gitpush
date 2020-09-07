import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        A a = new A();

        HashMap<Integer, Integer> map = new HashMap<>();
        a.setMap(map);
        map.put(1, 213113);
        map.put(2,2342424);

        System.out.println(a.getMap().get(1));
    }
}
