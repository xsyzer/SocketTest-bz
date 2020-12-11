package service.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author xsyz
 * @created 2020-12-11   10:17
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        Socket localhost = new Socket("localhost", 8081);
        //向服务器发送数据
        OutputStream outputStream = localhost.getOutputStream();
        outputStream.write("hello server".getBytes());
        //数据已经写完
        localhost.shutdownOutput();

        InputStream is = localhost.getInputStream();
        int len = 0;
        byte[] b = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while (true) {
            len = is.read(b);
            if (len == -1) {
                break;
            }
            sb.append(new String(b, 0, len));
        }
        System.out.println(sb.toString());
        localhost.shutdownInput();
    }
}
