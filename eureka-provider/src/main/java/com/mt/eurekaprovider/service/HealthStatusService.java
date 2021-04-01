package com.mt.eurekaprovider.service;/**
 * Created by 张春海 on 2021/3/14  23:43
 */

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

/**
 *@ClassName HealthStatusService
 *@Description TODO
 *@Author 张春海
 *@Date 2021/3/14 23:43 
 *@Version 1.0 */
@Service
public class HealthStatusService implements HealthIndicator {

    private Boolean status = true;

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public Health health() {
        if (status){
            return new Health.Builder().up().build();
        }
        return new Health.Builder().down().build();
    }

    public String getStatus() {
        return this.status.toString();
    }
}
