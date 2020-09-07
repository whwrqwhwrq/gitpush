package builder.demo1;

//工人负责 建造生产
public class Worker extends Builder {
    private Computer computer;

    public Worker() {
        computer = new Computer();
    }

    @Override
    void combine() {
        computer.setCombine("硬件");
        System.out.println("硬件");
    }

    @Override
    void installSystem() {
        computer.setInstallSystem("系统");
        System.out.println("系统");
    }

    @Override
    void installDrivers() {
        computer.setInstallDrivers("驱动");
        System.out.println("驱动");
    }

    @Override
    void installSoftware() {
        computer.setInstallSoftware("软件");
        System.out.println("软件");
    }

    @Override
    Computer getComputer() {
        return computer;
    }
}
