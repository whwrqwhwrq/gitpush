package factorymethod;

public class main {
    public static void main(String[] args) {
        Car car = new BenzFactory().getCar();
        Car car1 = new TestlaFactory().getCar();
        Car car2 = new BMWFactory().getCar();
        System.out.println(car.printName());
        System.out.println(car1.printName());
        System.out.println(car2.printName());
    }
}
