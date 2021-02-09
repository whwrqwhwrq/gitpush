package jedar0k;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author:wrq
 * @Date:2021/2/9 10:57
 */
public class TCPServer2 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10003);
        Socket socket = serverSocket.accept();

        FileOutputStream fileOutputStream = new FileOutputStream(new File("receive.png"));
        InputStream inputStream = socket.getInputStream();

        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len);
        }
        System.out.println("传输完成");

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("接收完毕，可以断开".getBytes());

        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
