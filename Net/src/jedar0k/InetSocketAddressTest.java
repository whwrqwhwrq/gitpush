package jedar0k;

import java.net.InetSocketAddress;

/**
 * @Author:wrq
 * @Date:2021/2/8 15:39
 */
public class InetSocketAddressTest {

    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 8080);

        System.out.println(inetSocketAddress.getAddress());
        System.out.println(inetSocketAddress.getHostName());
        System.out.println(inetSocketAddress.getPort());
        System.out.println(inetSocketAddress.getHostString());
        System.out.println(inetSocketAddress.toString());

        System.out.println(inetSocketAddress);
    }
}
