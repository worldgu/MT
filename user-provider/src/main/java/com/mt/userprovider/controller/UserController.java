package com.mt.userprovider.controller;/**
 * Created by 张春海 on 2021/3/16  10:36
 */

import com.mt.userapi.Instance.UserApi;
import com.mt.userapi.entity.Person;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *@ClassName UserController
 *@Description TODO
 *@Author 张春海
 *@Date 2021/3/16 10:36 
 *@Version 1.0 */
@RestController
public class UserController implements UserApi {

    @Value("${server.port}")
    String port;

    private AtomicInteger count = new AtomicInteger();

    @Override
    public String alive() {
        try {
            System.out.println("准备睡");
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        int i = count.getAndIncrement();
        System.out.println(port + " 好的  ==== 第 ：" + i + "次调用");

        return "port: "  + port;
    }

    @Override
    public String getById(Integer id) {
        return null;
    }

    @GetMapping("/getMap")
    public Map<Integer, String> getMap(@RequestParam("id") Integer id){

        System.out.println("请求参数为：" + id);
        return Collections.singletonMap(id,"emememe");
    }

    @GetMapping("/getMap2")
    public Map<Integer,String> getMap2(Integer id,String name){
        System.out.println(id);
        return Collections.singletonMap(id,name);
    }

    @GetMapping("/getMap3")
    public Map<Integer,String> getMap3(@RequestParam Map<String, Object> map){

        System.out.println(map);
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()),map.get("name").toString());
    }

    @PostMapping("/postMap")
    public Map<Integer,String> postMap(@RequestParam Map<String, Object> map){

        System.out.println(map);
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()),map.get("name").toString());
    }

    @Override
    public Person postPerson(Person person) {
        System.out.println(ToStringBuilder.reflectionToString(person));
        return null;
    }
}
