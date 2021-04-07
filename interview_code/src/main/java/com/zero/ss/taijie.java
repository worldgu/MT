package com.zero.ss;/**
 * Created by 张春海 on 2021/4/7  22:17
 */

/**
 *@ClassName taijie
 *@Description TODO
 *@Author 张春海
 *@Date 2021/4/7 22:17 
 *@Version 1.0 */
public class taijie {

    public static void main(String[] args) {
        int i = countWays(9);
        System.out.println(i);
    }

    private static int countWays(int i) {

        if (i<0) {
            return 0;
        } else if (i==0){
            return 1;
        } else {
            return countWays(i-1)+countWays(i-2)+countWays(i-3);
        }
    }
}
