package interfaceStudy;

public interface PrivateMethodInInterface {
    /**
     * java9支持 接口中 私有方法
     */
//    private static void sout() {
//        System.out.println("接口中的静态方法");
//    }
//
//    private void sout(String s) {
//        System.out.println(s);
//    }
    static void sout() {
        System.out.println("接口中的静态方法");
    }

    /*
    接口中默认方法，相当于给抽象方法加了实现的方法体
     */
    default void printStr(String... strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }


}
