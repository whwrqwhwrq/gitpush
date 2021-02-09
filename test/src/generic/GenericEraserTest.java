package generic;
class A <T extends Number>{
    T a;

    public A() {
    }

    public A(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }
}
public class GenericEraserTest {
    public static void main(String[] args) {
        A<Integer> a = new A<>(8);
        Integer a1 = a.getA();
        A aa = a;
        Number a2 = aa.getA(); //此处不能赋给Integer了
    }
}
