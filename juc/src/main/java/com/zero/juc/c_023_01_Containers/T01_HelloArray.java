package com.zero.juc.c_023_01_Containers;

import java.util.Arrays;

/**
 * @ClassName T01_HelloArray
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/13 21:15
 * @Version 1.0
 */
public class T01_HelloArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        Arrays.stream(a).map(i->i+1).forEach(i->System.out.println(i + " "));
    }
}
