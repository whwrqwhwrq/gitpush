package builder.demo1;
//指挥，负责指挥构建一个工程，工程如何构建由它所决定
public class Director {
    //指挥工人 按照顺序  造电脑
    public Computer build(Builder builder) {
        builder.combine();
        builder.installSystem();
        builder.installDrivers();
        builder.installSoftware();
        return builder.getComputer();
    }
}
