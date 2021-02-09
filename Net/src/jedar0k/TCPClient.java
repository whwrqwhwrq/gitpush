package jedar0k;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author:wrq
 * @Date:2021/2/8 16:16
 */
public class TCPClient {

    public static void main(String[] args) {
        OutputStream outputStream = null;
        Socket socket = null;
        try {
            String a = "Triple";
            InetAddress localhost = InetAddress.getByName("localhost");
            socket = new Socket(localhost, 10003);
            outputStream = socket.getOutputStream();
            outputStream.write(a.getBytes());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
