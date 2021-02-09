import java.util.Scanner;

public class TransferNumberToRmb {
    public static void main(String[] args) {
        System.out.println("请输入一个钱数：");
        Scanner scanner = new Scanner(System.in);
        String rmb = scanner.nextLine();

        System.out.println(rmb);
//        String[] split = rmb.split(".");
        int i = rmb.indexOf(".");

        String integer = rmb.substring(0, i);
        String decimal = rmb.substring(i + 1, rmb.length());
        String str = "";
        String 元 = "";
        String 万 = "";
        String 亿 = "";
        if (integer.length() <= 12 && integer.length() >= 9) {
            元 = integer.substring(integer.length() - 4, integer.length()) + "元";
            万 = integer.substring(integer.length() - 8, integer.length() - 4) + "万";
            亿 = integer.substring(0, integer.length() - 8) + "亿";
            str += 亿 + 万 + 元;
        }
        if (integer.length() <= 8 && integer.length() >= 5) {
            元 = integer.substring(integer.length() - 4, integer.length()) + "元";
            万 = integer.substring(0, integer.length() - 4) + "万";
            str += 亿 + 万 + 元;
        }

        if (integer.length() <= 4) {
            if (integer.equals("0")) {
                str += 亿 + 万 + 元;
            } else {
                元 = integer + "元";
                str += 亿 + 万 + 元;
            }
        }
        if (decimal.length() == 1) {
            str += decimal.substring(0, 1) + "角";
        }
        if (decimal.length() == 2) {
            str += decimal.substring(0, 1) + "角"
                    + decimal.substring(1, 2) + "分";
        }
        System.out.println(str);

    }
}
