package jedar0k;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Author:wrq
 * @Date:2021/2/10 9:47
 */
public class UDPClient02 {

    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(10010);
        byte[] bytes = new byte[1024];

        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
        datagramSocket.receive(datagramPacket);

        System.out.println(new String(datagramPacket.getData()));
        System.out.println(datagramPacket.getAddress());
        datagramSocket.close();
    }
}
