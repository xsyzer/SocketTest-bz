package service.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xsyz
 * @created 2020-12-11   10:13
 */


public class ServerSocketTest {
    public static void main(String[] args) throws IOException {
        //创建服务器
        ServerSocket serverSocket = new ServerSocket(8081);
        System.out.println("服务器启动");
        //让服务器接收客户端
        Socket accept = serverSocket.accept();
        //处理请求数据
        InputStream inputStream = accept.getInputStream();
        StringBuilder sb = new StringBuilder();
        int len = 0;
        byte[] bytes = new byte[1024];
        while (true) {
            len = inputStream.read(bytes);
            if (len == -1) {
                break;
            }
            sb.append(new String(bytes, 0, len));
        }
        System.out.println(sb.toString());
        accept.shutdownInput();
        //服务器响应客户端
        OutputStream os = accept.getOutputStream();
        os.write("收到请求并处理".getBytes());
        accept.shutdownOutput();


    }
}
