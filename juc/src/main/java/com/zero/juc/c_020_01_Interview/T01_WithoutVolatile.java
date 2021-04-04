package com.zero.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T01_WithoutVolatile
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/12 17:48
 * @Version 1.0
 */
public class T01_WithoutVolatile {

    List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T01_WithoutVolatile c = new T01_WithoutVolatile();

        new Thread(()->{
            for ( int i = 0 ; i < 10 ; i++ ) {
                c.add(new Object());
                System.out.println("add " + i);
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread (()->{
            while(true){
                if (c.size() == 5) {
                    break;
                }
            }
            System.out.println("t2 结束");
        },"t2").start();
    }
}
