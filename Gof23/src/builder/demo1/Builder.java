package builder.demo1;

public abstract class Builder {
    abstract void combine(); //组装硬件
    abstract void installSystem();//安装系统
    abstract void installDrivers();//安装驱动
    abstract void installSoftware();//安装软件
   //完工
    abstract Computer getComputer();
}
