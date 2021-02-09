package jedar0k;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {
        java.net.InetAddress address = java.net.InetAddress.getLocalHost();
        System.out.println(address);
        java.net.InetAddress kuangstudy = java.net.InetAddress.getByName("www.kuangstudy.com");
        System.out.println(kuangstudy);
        java.net.InetAddress baidu = java.net.InetAddress.getByName("www.baidu.com");
        System.out.println(baidu);
    }
}
