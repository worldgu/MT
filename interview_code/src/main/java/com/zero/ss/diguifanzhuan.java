package com.zero.ss;/**
 * Created by 张春海 on 2021/4/7  21:34
 */

/**
 *@ClassName diguifanzhuan
 *@Description TODO
 *@Author 张春海
 *@Date 2021/4/7 21:34 
 *@Version 1.0 */
public class diguifanzhuan {

    public static void main(String[] args) {
        System.out.println(reverse("vetor"));
    }

    public static String reverse (String originStr) {
        if(originStr == null || originStr.length() <= 1){
            return originStr;
        }

        System.out.println("==============");
        System.out.println("1:" + originStr.substring(1));
        System.out.println("2:" + reverse(originStr.substring(1)));
        System.out.println("3:" + originStr.charAt(0));
        return reverse(originStr.substring(1))+originStr.charAt(0);
    }
}
