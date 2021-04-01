package com.mt.eurekaconsumer.controller;/**
 * Created by 张春海 on 2021/3/15  10:51
 */

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *@ClassName MainOneController
 *@Description TODO
 *@Author 张春海
 *@Date 2021/3/15 10:51 
 *@Version 1.0 */
@RestController
public class MainTwoController {

    //    请求连接事先定义   /User    资源 事先 定义

    /**
     *
     * http://xxx/User
     *
     * http://xxx/User/getuserList   GET
     * http://xxx/users              GET  约定像对于数据的一张表
     * http://xxx/v1/User/getUserList
     *
     * http://xxx/v1/User/deleteById   Get/Post
     *
     * http://xxx/v1/users/1            Get= 获取id=1 的这个用户  Delete请求   = 删除  put = 修改
     * http://xxx/v2/users/1
     *
     * 针对单表  不在重复 crud   SpringData  Rest
     *
     */

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

    @GetMapping("/client6")
    public Object client6(){
        // ribbon 完成客户端的负载均衡，过滤掉Down的节点
        ServiceInstance instance = loadBalancerClient.choose("provider");

        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "HelloWorld/getHi";

        String respStr = restTemplate.getForObject(url,String.class);

        return respStr;
    }


    @GetMapping("client7")
    public Object client7(){

        List<ServiceInstance> instances = discoveryClient.getInstances("provider");

        // 自定义轮询算法

        // 随机
        int nextInt = new Random().nextInt(instances.size());
        AtomicInteger atomicInteger = new AtomicInteger();

        // 轮询
        int i = atomicInteger.getAndIncrement();
        instances.get( i % instances.size() );

        // 权重
        for ( ServiceInstance serviceInstance : instances ) {
//            int quanzhogn  = serviceInstance.getMetadata(); // 权重  1-9
        }


        ServiceInstance instance = instances.get(nextInt);

        // ribbon  完成客户端的负载均衡，过滤掉 down 了的节点
//        ServiceInstance instance = loadBalancerClient.choose("provider");

        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/getHi";
        String respStr = restTemplate.getForObject(url, String.class);

        return respStr;
    }

    @GetMapping("/client8")
    public Object client8() {

        // ribbon  完成客户端的负载均衡，过滤掉down了的节点
        ServiceInstance instance  = loadBalancerClient.choose("provider");

        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/getHi";

        String respStr = restTemplate.getForObject(url,String.class);

        System.out.println(respStr);

        return respStr;
    }


    @GetMapping("/client9")
    public Object client9() {
        // 自动处理URL
        String url ="http://provider/getHi";

        String respStr = restTemplate.getForObject(url, String.class);

        System.out.println(respStr);
        return respStr;
    }


}
