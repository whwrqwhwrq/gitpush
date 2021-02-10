package jedar0k;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Author:wrq
 * @Date:2021/2/10 9:41
 */
public class UDPClient01 {
    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket();

        String msg = "发送的一条消息，，，，，，，，，，，，，，，，，";
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length, InetAddress.getByName("127.0.0.1"),10010);

        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
