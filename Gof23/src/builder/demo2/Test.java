package builder.demo2;

public class Test {
    public static void main(String[] args) {
        Worker worker = new Worker();
        System.out.println(worker.getCombo().toString());
        System.out.println(worker.hamburger("香辣鸡腿堡")
                .french_fries("大份薯条")
                .cola("雪碧").getCombo().toString());
    }
}
