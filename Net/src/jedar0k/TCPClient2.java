package jedar0k;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author:wrq
 * @Date:2021/2/9 10:56
 */
public class TCPClient2 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 10003);
        File file = new File("src/jedar0k/个人名片.png");
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);

        byte[] buffer = new byte[1024];
        int len;
        while ((len = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer,0,len);
        }

        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        byte[] buffer1 = new byte[1024];
        int len1;
        while ((len1 = inputStream.read(buffer1)) != -1) {
            byteArrayOutputStream.write(buffer1,0,len1);
        }

        if (byteArrayOutputStream.toString().equals("接收完毕，可以断开")){
            byteArrayOutputStream.close();
            inputStream.close();
            outputStream.close();
            fileInputStream.close();
            socket.close();
        }

    }
}
