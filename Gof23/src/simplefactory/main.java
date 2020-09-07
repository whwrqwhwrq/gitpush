package simplefactory;

public class main {
    public static void main(String[] args) {
        //没有通过工厂
        Car car = new Testla();
        Car car1 = new Benz();
        System.out.println(car.printName());
        System.out.println(car1.printName());
        //通过工厂
        Car car2 = CarFactory.getCar("Benz");
        Car car3 = CarFactory.getCar("Tesla");
        Car car4 = CarFactory.getBenz();
        Car car5 = CarFactory.getTestla();
        System.out.println(car2.printName());
        System.out.println(car3.printName());
        System.out.println(car4.printName());
        System.out.println(car5.printName());

    }
}
