package com.mt.eurekaprovider.controller;/**
 * Created by 张春海 on 2021/3/14  23:54
 */

import com.mt.eurekaprovider.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

/**
 *@ClassName MainController
 *@Description TODO
 *@Author 张春海
 *@Date 2021/3/14 23:54 
 *@Version 1.0 */
@RestController
public class MainController {

    @Value("${server.port}")
    String port;

    @GetMapping("/getHi")
    public String getHi(){
        return "Hi! 我的port: " + port;
    }

    @GetMapping("/getMap")
    public Map<String,String> getMap(){
        return Collections.singletonMap("id","100");
    }

    @GetMapping("/getObj")
    public Person getObj(){
        Person person = new Person(100,"xiao66");
        return person;
    }

    @GetMapping("/getObj2")
    public Person getObj2(String name) {
        Person person = new Person(100, name);
        return person;
    }

    @PostMapping("/postLocation")
    public URI postParam(@RequestBody Person person, HttpServletResponse response) throws Exception {

        URI uri = new URI("http://www.baidu.com/s?wd=" + person.getName().trim());

        response.addHeader("Location", uri.toString());

        return uri;
    }




}
