package com.mt.eurekaconsumer.controller;/**
 * Created by 张春海 on 2021/3/15  10:51
 */

import com.mt.eurekaconsumer.entity.Person;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *@ClassName MainOneController
 *@Description TODO
 *@Author 张春海
 *@Date 2021/3/15 10:51 
 *@Version 1.0 */
@RestController
public class MainThreeController {


    /**
     * 手动负载均衡
     */
    @Autowired
    DiscoveryClient discoveryClient;

    EurekaClient eurekaClient;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/client10")
    public Object client10() {
        // 自动处理URL
        String url ="http://provider/getHi";

        String respStr = restTemplate.getForObject(url, String.class);

        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);

        System.out.println("entity: " + entity);

        System.out.println(respStr);
        return respStr;
    }

    @GetMapping("/client11")
    public Object client11() {
        // 自动处理URL
        String url ="http://provider/getMap";

        Map<String,String> respStr = restTemplate.getForObject(url, Map.class);

        System.out.println(respStr);
        return respStr;
    }

    @GetMapping("/client12")
    public Object client12() {
        // 自动处理URL
        String url ="http://provider/getObj";

        Person Object = restTemplate.getForObject(url, Person.class);

        System.out.println(Object);
        return Object;
    }

    @GetMapping("/client13")
    public Object client13() {
        // 自动处理URL
        String url ="http://provider/getObj2?name={1}";

        Person object = restTemplate.getForObject(url, Person.class,"zhangchunhai");

        System.out.println(object);
        return object;
    }

    @GetMapping("/client14")
    public Object client14() {
        // 自动处理URL
        String url ="http://provider/getObj2?name={name}";

        Map<String,String> map = Collections.singletonMap("name","xiaoxiao");

        Person object = restTemplate.getForObject(url, Person.class,map);

        System.out.println(object);
        return object;
    }

    @GetMapping("/client15")
    public Object client15(HttpServletResponse response) throws Exception{
        // 自动处理URL
        String url ="http://provider/postLocation";

        Map<String,String> map = Collections.singletonMap("name","mumuda");

        URI location = restTemplate.postForLocation(url, map,Person.class);

        response.sendRedirect(location.toURL().toString());

        System.out.println(location);
        return location;
    }


}
