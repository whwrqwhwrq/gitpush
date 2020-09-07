//测试类什么时候会 初始化
public class TestClass1 {
    static {
        System.out.println("main类被加载");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        //主动引用
        //S s = new S();
        //通过反射
        //Class.forName("S");
        //通过子类调用父类的静态变量  不会初始化子类
        //System.out.println(S.b);
        //对象数组不会初始化类
        //S[] s = new S[5];
        //常量调用不会初始化类
        //System.out.println(S.A);
    }
}

class F {
    static {
        System.out.println("父类被加载");
    }
    static int b = 1;
}

class S extends F{
    static {
        System.out.println("子类被加载");
        a =  2;
    }
    static int a = 3;
    static final int A = 5;
}