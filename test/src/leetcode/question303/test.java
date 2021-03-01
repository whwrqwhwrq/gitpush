package leetcode.question303;

/**
 * @Author:wrq
 * @Date:2021/3/1 11:24
 */
public class test {
    private String s;

    public test(int a) {
        int v = a + (int) (Math.random() * 10000);
        s = Integer.toString(v);
    }

    public static void main(String[] args) {
        test test = new test(333);
        System.out.println(test.s);

    }
}
