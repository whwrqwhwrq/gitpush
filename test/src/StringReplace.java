import java.util.UUID;

/**
 * @Author:wrq
 * @Date:2021/2/18 16:09
 */
public class StringReplace {
    public static void main(String[] args) {
        String str = "aaaaaaaaaaa";
        String head = str.substring(0, 3);
        String tail = str.substring(7, 11);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(head).append("****").append(tail);
        System.out.println(stringBuilder.toString());

        System.out.println(UUID.randomUUID());
    }
}
