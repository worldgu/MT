package com.mt.eurekaprovider.entity;/**
 * Created by 张春海 on 2021/3/14  23:48
 */

import lombok.Getter;
import lombok.Setter;

/**
 *@ClassName Person
 *@Description TODO
 *@Author 张春海
 *@Date 2021/3/14 23:48 
 *@Version 1.0 */
@Getter
@Setter
public class Person {

    private int id;
    private String name;

    public Person(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
