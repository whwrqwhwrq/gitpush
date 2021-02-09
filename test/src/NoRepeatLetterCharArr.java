import java.util.Random;
import java.util.Scanner;

public class NoRepeatLetterCharArr {
    public static void main(String[] args) {
        System.out.println("请输入生成的大写字母个数：");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if (i > 26) {
            System.out.println("一共只有26个大写字母");
            System.exit(0);
        }
        char[] noRepeatCharArr = getNoRepeatCharArr(i);
        for (char c : noRepeatCharArr) {
            System.out.print(c);
            System.out.print("\t");
        }
    }

    private static char[] getNoRepeatCharArr(int count) {
        char[] chars = new char[count];
        //标识26个大写字母 不重复
        boolean[] flag = new boolean[26];
        for (int i = 0; i < 26; i++) {
            //初始化，数组 中 全为true
            flag[i] = true;
        }


        for (int i = 0; i < count; i++) {
            int anInt = 65 + new Random().nextInt(26);
            char letter = (char) anInt;
            if (i >= 1) {
                while (flag[anInt - 65] == false) {
                    anInt = 65 + new Random().nextInt(26);
                }
                letter = (char) anInt;
            }
            chars[i] = letter;
            flag[anInt - 65] = false;
        }
        
        //输出剩余的大写字母
        System.out.print("剩余的大写字母："+"\t");
        boolean noLeft = true;
        for (int i = 0; i < 26; i++) {
            if (flag[i]) {
                noLeft = false;
                System.out.print((char) (i + 65) + "\t");
            }
        }
        if (noLeft) {
            System.out.print("无");
        }
        System.out.println();
        return chars;
    }
}
