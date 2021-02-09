public class RecursionTest {
    public static void main(String[] args) {
        int i = f(13);
        System.out.println(i);
    }

    private static int f(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 4;
        } else {
            return 2 * f(n - 1) + f(n - 2);
        }
    }
}
