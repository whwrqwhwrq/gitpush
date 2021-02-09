import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String strTest = "abc,aaa,oij";

        List<String> strings = Arrays.asList(strTest.split(","));

        String join = String.join(",", strings.stream().distinct().collect(Collectors.toList()));

        System.out.println(join);

        String a = "a";
        boolean b = a.contains("ab");
        System.out.println(b);

        ArrayList<Object> objects = new ArrayList<>();
        System.out.println(objects);


    }
}
