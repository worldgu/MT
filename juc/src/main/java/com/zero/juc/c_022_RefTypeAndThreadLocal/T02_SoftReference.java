package com.zero.juc.c_022_RefTypeAndThreadLocal;

import java.lang.ref.SoftReference;

/**
 * @ClassName T02_SoftReference
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/13 20:32
 * @Version 1.0
 */
public class T02_SoftReference {

    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024*1024*10]);
//        m = null;
        System.out.println(m.get());
        System.gc();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(m.get());

        // 再分配一个数组， heap将装不下，这时候系统会垃圾回收，先回收一次，如果不够，会把软引用干掉
        byte[] b = new byte[1042*1024*15];
        System.out.println(m.get());
    }
}
