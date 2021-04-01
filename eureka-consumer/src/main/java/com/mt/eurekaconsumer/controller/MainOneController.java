package com.mt.eurekaconsumer.controller;/**
 * Created by 张春海 on 2021/3/15  10:51
 */

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
/**
 *@ClassName MainOneController
 *@Description TODO
 *@Author 张春海
 *@Date 2021/3/15 10:51 
 *@Version 1.0 */
@RestController
public class MainOneController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    EurekaClient eurekaClient;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/getHi")
    public String getHi(){
        return "HI";
    }

    @GetMapping("/client")
    public String client(){
        List<String> services = discoveryClient.getServices();

        for(String str : services) {
            System.out.println(str);
        }
        return "Hi";
    }

    /**
     * 获取对应的服务列表
     *
     * @return
     */
    @GetMapping("/client2")
    public Object client2(){
        return discoveryClient.getInstances("provider");
    }

    /**
     * 获取对应服务下的接口信息
     * @return
     */
    @GetMapping("/client3")
    public Object client3(){
        List<ServiceInstance> instances = discoveryClient.getInstances("provider");
        for ( ServiceInstance serviceInstance : instances ) {
            System.out.println(ToStringBuilder.reflectionToString(serviceInstance));
        }
        return "xxoo";
    }

    @GetMapping("/client4")
    public Object client4(){

        // 具体的服务
//        List<InstanceInfo> instances = eurekaClient.getInstancesById("localhost:provider:80");

        // 使用服务名，找列表
        List<InstanceInfo> instances = eurekaClient.getInstancesByVipAddress("provider",false);

        for (InstanceInfo ins: instances ) {
            System.out.println(ToStringBuilder.reflectionToString(ins));
        }

        if (instances.size() > 0) {
            // 服务
            InstanceInfo instanceInfo = instances.get(0);

            if ( instanceInfo.getStatus() == InstanceInfo.InstanceStatus.UP) {
                // 拼接服务地址
                String url = "http://" + instanceInfo.getHostName() + ":" + instanceInfo.getPort() + "/getHi";

                System.out.println("Url:" + url);

                RestTemplate restTemplate = new RestTemplate();

                String respStr = restTemplate.getForObject(url , String.class);

                System.out.println("respStr : " + respStr);
            }
        }
        return "ooxx";
    }

    @GetMapping("/client5")
    public Object client5(){

        // ribbon 完成客户端的负载均衡，过滤掉Down了的节点
        ServiceInstance instances = loadBalancerClient.choose("provider");

        String url = "http://" + instances.getHost() + ":" + instances.getPort() + "/getHi";

        RestTemplate restTemplate = new RestTemplate();

        String respStr = restTemplate.getForObject(url,String.class);

        System.out.println("respStr : " + respStr);

        return "xxxxxooooo";
    }



}
