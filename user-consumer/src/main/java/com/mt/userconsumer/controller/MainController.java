package com.mt.userconsumer.controller;/**
 * Created by 张春海 on 2021/3/16  16:14
 */

import com.mt.userapi.entity.Person;
import com.mt.userconsumer.instance.ConsumerApi;
import com.mt.userconsumer.service.RestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *@ClassName MainController
 *@Description TODO
 *@Author 张春海
 *@Date 2021/3/16 16:14 
 *@Version 1.0 */
@RestController
public class MainController {

    @Autowired
    ConsumerApi consumerApi;

    @Autowired
    RestService rest;

    @GetMapping("/alive2")
    @HystrixCommand(defaultFallback = "back")
    public String alive2(){
        return rest.alive();
    }

    public String back () {
        return "失败了1";
    }

    @GetMapping("/alive")
    public String alive() {
        /**
         * URL 不能变
         *
         * jar
         * 文档
         */
        return consumerApi.alive();
    }

    /**
     * 降级
     *
     * 隔离
     *
     * 熔断
     *
     * 自己写
     *
     * try {
     *
     *     1. 发起向服务方的请求
     *          1.1判断链接超时
     *             -> 这次请求   记录到服务里
     *          http 请求  线程消耗
     *
     *
     *          map(URI,线程数)
     *          线程池(线程数)
     *        阈值   阈值
     *
     *        技术 连续失败次数  达到阈值
     *        count ++;
     *
     *      if ( count == 10) {
     *          new romdom == 1 按时间
     *          发请求
     *
     *          throw exception;
     *      }
     *
     *          请求/不请求/半请求
     *          开    关    半开
     *
     *      if ( 当前线程满了 ) {
     *          throw exception
     *      }
     *
     *
     *          1.2  尝试向启发服务发起请求
     *
     *          注解
     *
     *
     *     2. 还是没成功
     * } catch (Exception e) {
     *     1. 避免返回不友好的错误信息
     *
     *     2. return 另外一个东西  写到 MQ 里面  admin 发个邮件
     *        return "客官稍后再来"
     * }
     *
     *      Hystrix  干的就是这个事儿
     *
     */

    @GetMapping("/map")
    public Map<Integer,String> map(Integer id){

        System.out.println(id);

        return consumerApi.getMap(id);
    }

    @GetMapping("/map2")
    public Map<Integer,String> map2(Integer id,String name){

        System.out.println(id);

        return consumerApi.getMap2(id,name);
    }

    @GetMapping("/map3")
    public Map<Integer,String> map3(@RequestParam Map<String,Object> map){

        HashMap<String,Object> map1 = new HashMap<>(2);

        map1.put("id",2000);
        map1.put("name","凯");
        System.out.println(map1.toString());

        return consumerApi.getMap3(map1);
    }

    @GetMapping("/map4")
    public Map<Integer,String> map4(@RequestParam Map<String,Object> map){

        System.out.println(map.toString());

        return consumerApi.postMap(map);
    }

    @GetMapping("/postPerson")
    public Person postPerson(@RequestParam Map<String, Object> map){

        System.out.println(map);

        Person person = new Person();
        person.setId(Integer.parseInt(map.get("id").toString()));
        person.setName("xxoo");

        return consumerApi.postPerson(person);
    }



}
