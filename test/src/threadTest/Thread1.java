package threadTest;

public class Thread1 {
    public static void main(String[] args) {
        Thread a = new Thread(new t(), "a");
        a.setDaemon(true);
        String isDaemon = a.isDaemon() ? "是" : "否";
        System.out.println(isDaemon);
        a.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("输出第" + i + "次");
        }
    }

    static class t implements Runnable {

        @Override
        public void run() {
            int i = 200;
            while (i > 0) {
                System.out.println(Thread.currentThread().getName() + " ----- ");
                i--;
            }
        }
    }
}
