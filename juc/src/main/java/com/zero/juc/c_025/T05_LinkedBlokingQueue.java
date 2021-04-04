package com.zero.juc.c_025;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T05_LinkedBlokingQueue
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/15 21:59
 * @Version 1.0
 */
public class T05_LinkedBlokingQueue {

    static BlockingQueue<String> strs = new LinkedBlockingDeque<>();

    static Random r = new Random();

    public static void main(String[] args) {

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    strs.put("a" +i); // 如果满了就会等待，阻塞住
                    TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"p1").start();

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                for (;;) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " take - " + strs.take()); // 如果空了就会等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"c" + i).start();
        }

    }
}
