package com.mt.server;/**
 * Created by 张春海 on 2021/4/9  20:06
 */

import java.net.Socket;
import java.util.Date;

/**
 *@ClassName IOClient
 *@Author 张春海
 *@Date 2021/4/9 20:06 
 *@Version 1.0 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(()->{
            try{
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {

                    }
                }

            } catch(Exception e){

            }
        }).start();
    }
}
