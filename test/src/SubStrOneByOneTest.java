import java.util.ArrayList;
import java.util.Scanner;

public class SubStrOneByOneTest {
    public static void main(String[] args) {
        System.out.println("请输入字符串：");
        Scanner scanner = new Scanner(System.in);
        String strGet = scanner.nextLine();

        ArrayList<Character> resList = new ArrayList<>();

        for (int i = 0; i < strGet.length(); i++) {
            String substring = strGet.substring(i, i + 1);
            char[] chars = substring.toCharArray();
            resList.add(chars[0]);
            System.out.println("已把第" + (i + 1) + "个字符加入集合");
        }
        int count = 1;
        for (Character character : resList) {
            System.out.print("第" + count + "个字符是");
            count++;
            System.out.println(character);
        }
        System.out.println(count);
    }
}
