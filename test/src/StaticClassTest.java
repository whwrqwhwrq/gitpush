public class StaticClassTest {
    static int a;
    static {
        a = 23;
    }

    private static void output() {
        System.out.println("属于类的静态方法");
    }
    public static void main(String[] args) {
        StaticClassTest staticClassTest = new StaticClassTest();
        StaticClassTest staticClassTest1 = new StaticClassTest();
        System.out.println(StaticClassTest.a);
        StaticClassTest.output();
        staticClassTest.output();
        staticClassTest1.output();
    }
}
