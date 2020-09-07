package simplefactory;
//简单工厂模式（静态工厂模式）
//弊端：增加 一个类 ，必须修改工厂，不满足开闭原则
//如果要想满足开闭，需要花费较大代价    （工厂方法模式）
public class CarFactory {
    //法一
    public static Car getCar(String car) {
        if (car.equals("Benz")) {
            return new Benz();
        }
        if (car.equals("Tesla")) {
            return new Testla();
        }
        return null;
    }

    //法二
    public static Car getBenz() {
        return new Benz();
    }
    public static Car getTestla() {
        return new Testla();
    }
}
