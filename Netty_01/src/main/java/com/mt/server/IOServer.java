package com.mt.server;/**
 * Created by 张春海 on 2021/4/9  19:54
 */

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *@ClassName IOServer
 *@Author 张春海
 *@Date 2021/4/9 19:54 
 *@Version 1.0 */
public class IOServer {

    public static void main(String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(8000);

        new Thread(()->{
            while (true) {
                try {

                    // (1) 阻塞方法获取新的连接
                    Socket socket = serverSocket.accept();

                    // (2) 每一个新的连接都创建一个新的线程，负责读取数据
                    new Thread(()->{
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            // (3) 那字节流方式读取数据
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data,0,len));
                            }
                        } catch (IOException ex) {

                        }
                    }).start();
                } catch (IOException ex) {

                }
            }
        }).start();
    }
}
