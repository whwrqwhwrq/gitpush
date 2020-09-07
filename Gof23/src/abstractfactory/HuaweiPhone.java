package abstractfactory;

public class HuaweiPhone implements IMobileProduct{
    @Override
    public void start() {
        System.out.println("华为手机开机");
    }

    @Override
    public void shutdown() {
        System.out.println("华为手机关机");

    }

    @Override
    public void call() {
        System.out.println("用华为手机打电话");

    }

    @Override
    public void playGames() {
        System.out.println("用华为手机玩游戏");

    }
}
