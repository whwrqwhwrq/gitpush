package jedar0k;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author:wrq
 * @Date:2021/2/8 16:16
 */
public class TCPServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket acceptSocket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
                serverSocket = new ServerSocket(10003);
            while (true) {
                acceptSocket = serverSocket.accept();
                inputStream = acceptSocket.getInputStream();
                byteArrayOutputStream = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, len);
                }
                System.out.println(byteArrayOutputStream.toString());

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (acceptSocket != null) {
                    acceptSocket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
