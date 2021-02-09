package threadTest;

public class ClassTest {
    private static final String URL = "www.baidu.com";
    private static final int SPEED_LIMIT = 500;

    public static void main(String[] args) {
        Another another = new Another(URL,SPEED_LIMIT);
        another.download("MB");
    }
}

class Another {
    private String url;
    private int speedLimit;

    public void download(String suffix) {
        System.out.println("正在从"+url+"上以\t"+speedLimit+suffix+"的速度下载");
    }
    public Another() {
    }

    public Another(String url, int speedLimit) {
        this.url = url;
        this.speedLimit = speedLimit;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }
}