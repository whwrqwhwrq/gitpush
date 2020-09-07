//类加载内存分析
public class TestClass {
    public static void main(String[] args) {

        A a = new A();
        System.out.println(A.s);
/*
1 加载到内存，会产生一个类对应Class对象
2 链接，链接结束后m = 0
3 初始化
    clinit(){
     System.out.println("执行了静态代码块");
        s = "QAZWSX";
        s = "阿帕奇";
    }
 */
    }
}
class A{
    static {
        //静态代码块
        System.out.println("执行了静态代码块");
        s = "QAZWSX";
    }

    static String s = "阿帕奇";

    public A() {
    }
}