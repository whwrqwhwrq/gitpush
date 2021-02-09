package javaBaseLib;

public class RuntimeTest {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.print("最大内存数");
        System.out.println(runtime.totalMemory());
        System.out.print("空闲内存数");
        System.out.println(runtime.freeMemory());
        System.out.print("可用CPU数");
        System.out.println(runtime.availableProcessors());
        System.out.print("可用最大内存数");
        System.out.println(runtime.maxMemory());

    }
}
