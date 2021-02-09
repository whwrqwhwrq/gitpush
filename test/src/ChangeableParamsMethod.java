public class ChangeableParamsMethod {
    public static void main(String[] args) {
        int[] ints = new int[]{2,3,4};
        new ChangeableParamsMethod().f(ints, "A", "d", "sad");

    }

    private void f(int[] ints, String... strings) {
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i]);
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

}
