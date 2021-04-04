package com.zero.juc.c_020;

import java.util.concurrent.Exchanger;

/**
 * @ClassName T12_TestExchanger
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/12 17:08
 * @Version 1.0
 */
public class T12_TestExchanger {

    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main (String[] args) {
        new Thread(()->{
            String s = "T1";

            try {
                s = exchanger.exchange(s);

            } catch ( InterruptedException ex ) {
                ex.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "  " + s);
        },"t1").start();


        new Thread(()->{
            String s ="T2";

            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "   " + s);
        },"t2").start();
    }

}
