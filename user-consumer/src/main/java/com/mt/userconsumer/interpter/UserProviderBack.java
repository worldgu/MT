package com.mt.userconsumer.interpter;/**
 * Created by 张春海 on 2021/3/16  22:59
 */

import com.mt.userapi.entity.Person;
import com.mt.userconsumer.instance.ConsumerApi;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *@ClassName UserProviderBack
 *@Description TODO
 *@Author 张春海
 *@Date 2021/3/16 22:59 
 *@Version 1.0 */
//@Component
public class UserProviderBack implements ConsumerApi {

    @Override
    public String alive() {

        return "降级了";
    }

    @Override
    public String getById(Integer id) {
        return null;
    }

    @Override
    public Person postPerson(Person person) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap(Integer id) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap2(Integer id, String name) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap3(Map<String, Object> map) {
        return null;
    }

    @Override
    public Map<Integer, String> postMap(Map<String, Object> map) {
        return null;
    }


}
