package single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//懒汉模式
//单例不安全，因为有反射 可以 将类的私有构造器 公有，破坏 单例模式
//枚举 可以防止 反射破坏单例
public class Lazy {
    private static boolean flag = false;
    //构造器私有
    private Lazy() {
        System.out.println(Thread.currentThread().getName()+ "  运行中");
        synchronized (Lazy.class) {
            if (flag == false) {
                flag = true;
            } else {
                throw new RuntimeException("不可使用反射破坏单例");

            }
        }

    }
    private volatile static Lazy lazy;
//获得对象
    //双重检测锁模式 的懒汉式单例  DCL
    public static Lazy getInstance() {
        if (lazy == null) {
            synchronized (Lazy.class) {
                if (lazy == null) {
                    lazy = new Lazy(); //不是原子性操作 第一步分配内存空间，第二步执行构造方法初始化对象
                    //第三步 将对象指向这个空间
                    /*
                    正常顺序是123
                    有可能产生132的 顺序
                    A进程 进行完第一步 第三步
                    B进程 进入执行，判断lazy已不为空，直接return出lazy  ，此时lazy 还没有初始化构造器，会为无效空对象
                    所有要在lazy 前加上volatile关键字 禁止指令重排序优化

                    摘自博客园
                    volatile是一种轻量级的同步机制，它主要有两个特性：一是保证共享变量对所有线程的可见性；
                    二是禁止指令重排序优化。同时需要注意的是，
                    volatile对于单个的共享变量的读/写具有原子性，但是像num++这种复合操作，volatile无法保证其原子性，
                    当然文中也提出了解决方案，就是使用并发包中的原子操作类，通过循环CAS地方式来保证num++操作的原子性。
                     */
                }
            }
        }

        return lazy;
    }
    //测试多线程并发
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (int i = 0; i < 11; i++) {
            Thread thread = new Thread(()->{
                Lazy.getInstance();
            });
            thread.start();
        }
        Constructor<Lazy> declaredConstructor = Lazy.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        Lazy lazy = declaredConstructor.newInstance();//会抛出不可使用反射破坏 单例    的异常
    }
}
