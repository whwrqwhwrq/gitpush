package abstractfactory;

public class XiaomiTV implements ITVProduct{
    @Override
    public void start() {
        System.out.println("小米电视启动");
    }

    @Override
    public void shutdown() {
        System.out.println("小米电视关闭");

    }

    @Override
    public void playVideo() {
        System.out.println("小米电视播放视频");

    }

    @Override
    public void connectPS4() {
        System.out.println("小米电视连接PS4");

    }
}
