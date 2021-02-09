import java.util.Scanner;

public class GenerateCharArrarr {
    public static void main(String[] args) {
        System.out.println("请输入方阵阶数：");
        Scanner sc = new Scanner(System.in);
        int rc = sc.nextInt();
        char[][] letterChars = generateCharArrarr(rc);
        for (char[] chars : letterChars) {
            for (char letter : chars) {
                System.out.print(letter);
            }
            System.out.println();
        }
    }

    private static char[][] generateCharArrarr(int rc) {
        char[][] letterChars = new char[rc][rc];
        //由于高级for循环的 遍历变量为临时遍历，所以只能用来读，不能向数组赋值
        for (int j = 0; j < letterChars.length; j++) {
            for (int i = 0; i < letterChars[j].length; i++) {
                int anInt = 97 + (j * rc) + i;
                letterChars[j][i] = (char) anInt;
            }
        }

        return letterChars;
    }
}
