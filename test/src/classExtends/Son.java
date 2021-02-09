package classExtends;

public class Son extends Father {
    public void test() {
        Father father;

    }
    public Son() {
    }

    public Son(String c, String a, String b, String d) {
        super(c, a, b, d);
    }

    public static void main(String[] args) {
        Son son = new Son();
        Father father = new Father();
        System.out.println(father.getA());
//        son.setA("aaa");
        son.setB("bbb");
        son.setC("ccc");
        son.setD("ddd");
        System.out.println();
        System.out.println(son.getA());
        System.out.println(son.getB());
        System.out.println(son.getC());
        System.out.println(son.getD());
    }
}
