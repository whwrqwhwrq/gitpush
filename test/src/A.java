import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class A {
    private volatile static List<String> list = new ArrayList<String>();

    void add(List list) {
        list.add(UUID.randomUUID().toString());
    }

    String getSize(List list) {
        return "集合容量" + String.valueOf(list.size());
    }

    public static void main(String[] args) {
        A a = new A();
        for (int i = 0; i < 500; i++) {
            a.add(list);
            System.out.println(list.get(i));
        }
        System.out.println(a.getSize(list));
    }
}
