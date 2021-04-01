package com.mt.eurekaserivce.listen;/**
 * Created by 张春海 on 2021/3/14  23:08
 */

import com.google.common.base.StandardSystemProperty;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 *@ClassName TestEvent
 *@Description TODO
 *@Author 张春海
 *@Date 2021/3/14 23:08 
 *@Version 1.0 */
@Component
public class TestEvent {

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event){
        //  发邮件短信
        System.out.println("下线：" + event.getServerId());

    }
}
