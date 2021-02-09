public class ArrTest {
    public static void main(String[] args) {
        String[] strings= new String[6];
        strings[2] = "字符串";
        int[] ints = new int[4];
        ints[1] = 3;
        ints[0] = 3;
        System.out.println(ints.length);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }
}
