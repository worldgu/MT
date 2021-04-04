package com.zero.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName T06_LockSupport
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/12 19:52
 * @Version 1.0
 */
public class T07_LockSupport_WithoutSleep {


    // 添加volatile, 使 t2 能够得到通知
    volatile List lists = new ArrayList<>();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    static Thread t1 = null,t2 = null;

    public static void main(String[] args) {
        T07_LockSupport_WithoutSleep c = new T07_LockSupport_WithoutSleep();

        CountDownLatch latch = new CountDownLatch(1);


        t1 = new Thread(()->{
            System.out.println("t1 启动");
            for (int  i = 0 ; i <10; i++) {
                c.add(new Object());
                System.out.println("add " + i );

                if ( c.size() == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        },"t1");

        t2 = new Thread(()->{
//            System.out.println("t2 启动");
//            if ( c.size() != 5 ) {
                LockSupport.park();
//            }
            System.out.println("t2 结束");
            LockSupport.unpark(t1);
        },"t2");

        t2.start();
        t1.start();




    }
}
