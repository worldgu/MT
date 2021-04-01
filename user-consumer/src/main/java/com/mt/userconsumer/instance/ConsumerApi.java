package com.mt.userconsumer.instance;

import com.mt.userapi.Instance.UserApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by 张春海 on 2021/3/16  16:05
 *
 * 不结合 eureka ,  就是定义一个Client名字，就用url属性指定，服务器列表， url = "http://ip:port"
 */
@FeignClient(name = "user-provider")
public interface ConsumerApi extends UserApi {

    /**
     * 这里 GexMapping 是给 Feign 看的  get 请求  user-provider/getMap?id={}
     * @RequestParam(“id”) 也是给Feign 看的
     *
     * HttpClient Http协议
     * @param
     * @return
    */
    @GetMapping("/getMap")
    Map<Integer,String> getMap(@RequestParam("id") Integer id);

    @GetMapping("/getMap2")
    Map<Integer,String> getMap2(@RequestParam("id") Integer id,@RequestParam("name") String name);

    @GetMapping("/getMap3")
    Map<Integer,String> getMap3(@RequestParam Map<String,Object> map);

    @PostMapping("/postMap")
    Map<Integer,String> postMap(@RequestParam Map<String,Object> map);
}
