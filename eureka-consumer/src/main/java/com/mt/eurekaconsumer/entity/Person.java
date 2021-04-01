package com.mt.eurekaconsumer.entity;/**
 * Created by 张春海 on 2021/3/15  10:49
 */

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *@ClassName Person
 *@Description TODO
 *@Author 张春海
 *@Date 2021/3/15 10:49 
 *@Version 1.0 */
@Getter
@Setter
@EqualsAndHashCode
public class Person {

    private int id;
    private String name;

    public Person(){}

    public Person(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
