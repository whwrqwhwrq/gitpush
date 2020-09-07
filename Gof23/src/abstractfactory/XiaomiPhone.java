package abstractfactory;

public class XiaomiPhone implements IMobileProduct{
    @Override
    public void start() {
        System.out.println("小米手机开机");
    }

    @Override
    public void shutdown() {
        System.out.println("小米手机关机");

    }

    @Override
    public void call() {
        System.out.println("用小米手机打电话");

    }

    @Override
    public void playGames() {
        System.out.println("用小米手机玩游戏");

    }

}
