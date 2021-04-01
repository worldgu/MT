package com.mt.userconsumer.interpter;/**
 * Created by 张春海 on 2021/3/16  23:01
 */

import com.mt.userapi.entity.Person;
import com.mt.userconsumer.instance.ConsumerApi;
import feign.FeignException;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *@ClassName UserProviderBackFactory
 *@Description TODO
 *@Author 张春海
 *@Date 2021/3/16 23:01 
 *@Version 1.0 */
@Component
public class UserProviderBackFactory implements FallbackFactory<ConsumerApi> {

    @Override
    public ConsumerApi create(Throwable cause) {
        return  new ConsumerApi() {

            @Override
            public String alive() {

                System.out.println(cause);
                if (cause instanceof FeignException.InternalServerError) {
                    return "远程服务 500" + cause.getLocalizedMessage();
                } else {
                    return "oh my god";
                }
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
        };
    }
}
