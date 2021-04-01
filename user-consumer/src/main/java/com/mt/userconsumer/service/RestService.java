package com.mt.userconsumer.service;/**
 * Created by 张春海 on 2021/3/16  22:48
 */

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *@ClassName RestService
 *@Description TODO
 *@Author 张春海
 *@Date 2021/3/16 22:48 
 *@Version 1.0 */
@Service
public class RestService {

    @Autowired
    RestTemplate template;

    @HystrixCommand(defaultFallback = "back")
    public String alive() {

        String url = "http://user-provider/alive";

        String str = template.getForObject(url, String.class);

        return str;
    }

    public String back() {

        return "失败了";
    }
}
