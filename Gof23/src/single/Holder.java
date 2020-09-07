package single;
//静态内部类 实现单例
public class Holder {
    //单例模式 ，构造器私有
    private Holder() {
    }

    private static Holder getInstance() {
        return Inner.HOLDER;
    }
    //静态内部类
    public static class Inner{
        private static final Holder HOLDER = new Holder();
    }
}
