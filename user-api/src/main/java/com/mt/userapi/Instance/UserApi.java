package com.mt.userapi.Instance;/**
 * Created by 张春海 on 2021/3/16  10:28
 */

import com.mt.userapi.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@ClassName UserApi
 *@Description TODO
 *@Author 张春海
 *@Date 2021/3/16 10:28 
 *@Version 1.0 */
@RequestMapping("/User")
public interface UserApi {

    /**
     * 工作中有专门一个公工api服务的吗?
     *
     * 查看当前服务状态
     *
     */
    @GetMapping("/alive")
    public String alive();

    @GetMapping("getById")
    public String getById(Integer id);

    @PostMapping("/postPerson")
    public Person postPerson(@RequestBody Person person);
}
