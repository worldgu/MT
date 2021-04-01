package com.mt.eurekaconsumer.interceptor;/**
 * Created by 张春海 on 2021/3/15  10:46
 */

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 *@ClassName LoggingClientHttpRequestInterceptor
 *@Description TODO
 *@Author 张春海
 *@Date 2021/3/15 10:46 
 *@Version 1.0 */
public class LoggingClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

        System.out.println("拦截成功");
        System.out.println(httpRequest.getURI());
//
        ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest,bytes);
        System.out.println(response.getHeaders());

        return response;
    }
}
