package single;


//饿汉式  单例模式 初始化类时加载所有资源，可能造成内存的浪费
public class Hungry {
    //可能造成内存的浪费
    private byte[] a = new byte[1024 * 100];
    private byte[] b = new byte[1024 * 100];
    private byte[] c = new byte[1024 * 100];
    private byte[] d = new byte[1024 * 100];
    //构造器私有化
    private Hungry() {

    }
    //以常量的方式定义对象
    private static final Hungry HUNGRY = new Hungry();
    //静态方法，负责返回一个 该类的对象。
    private static Hungry getInstance() {
        return HUNGRY;
    }
}
