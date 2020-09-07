import java.util.Properties;

//类加载器
public class TestClass2 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的 父类加载器 ，即扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取 扩展类加载器的  父类加载器，即为根加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类 是由哪个 类加载器加载的
        Class<?> testClass2 = Class.forName("TestClass2");
        System.out.println(testClass2.getClassLoader());

        //测试JDK内部类 是由哪个 类加载器加载的
        Class<?> testClass3 = Class.forName("java.lang.Object");
        System.out.println(testClass3.getClassLoader());

        //获得系统类加载器可以加载的路径
        Properties properties = System.getProperties();
        System.out.println(properties);

    }
}
