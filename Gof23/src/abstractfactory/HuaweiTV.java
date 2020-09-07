package abstractfactory;

public class HuaweiTV implements ITVProduct{
    @Override
    public void start() {
        System.out.println("华为电视启动");
    }

    @Override
    public void shutdown() {
        System.out.println("华为电视关闭");

    }

    @Override
    public void playVideo() {
        System.out.println("华为电视播放视频");

    }

    @Override
    public void connectPS4() {
        System.out.println("华为电视连接PS4");

    }
}
