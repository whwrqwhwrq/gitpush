package threadTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WaitAndNotify {
    private volatile static List<String> list = new ArrayList<String>();

    void add(List list) {
        list.add(UUID.randomUUID().toString());
    }

    String getSize(List list) {
        return "集合容量" + String.valueOf(list.size());
    }

    public static void main(String[] args) {
        final WaitAndNotify waitAndNotify = new WaitAndNotify();
        final LocalDateTime now = LocalDateTime.now();

        Thread thread = new Thread(() -> {
            synchronized (now) {
                for (int i = 0; i < 100; i++) {
                    waitAndNotify.add(list);
                    System.out.println(Thread.currentThread().getName() +
                            "于" + now.format(DateTimeFormatter.ISO_DATE_TIME)
                            + "向集合中添加了第" + i + "个元素");
                    if (waitAndNotify.getSize(list).equals("集合容量66")) {
                        now.notify();
                        System.out.println(Thread.currentThread().getName() +
                                "于" + now.format(DateTimeFormatter.ISO_DATE_TIME) + "发出了通知");
                    }
                }
            }

        }, "线程A");

        Thread thread1 = new Thread(() -> {
            synchronized (now) {
                if (!waitAndNotify.getSize(list).equals("集合容量66")) {
                    try {
                        System.out.println(Thread.currentThread().getName() +
                                "于" + now.format(DateTimeFormatter.ISO_DATE_TIME) + "进入");
                        now.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() +
                            "于" + now.format(DateTimeFormatter.ISO_DATE_TIME) + "接收到了通知");
                    throw new RuntimeException();
                }
            }

        }, "线程B");
        thread.start();
        thread1.start();

    }
}
