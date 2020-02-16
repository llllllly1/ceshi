package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.feign.HelloFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("test")
@RestController
public class TestController {
    //@Autowired
            // 通过负载均衡客户端获取动态IP地址实现调用
    //LoadBalancerClient loadBalancerClient;
//    @Autowired
//    RestTemplate restTemplate;
    @Autowired
    HelloFeign helloFeign;
    @RequestMapping("test")

    public User test(User user){
        // serviceId : 实例名称
        //ServiceInstance eureka_product = loadBalancerClient.choose("eureka_product");
//        System.out.println(eureka_product.getHost());
//        System.out.println(eureka_product.getUri());
//        RestTemplate restTemplate = new RestTemplate();
        // 有简易API的HttpClient 作用: 发送http请求
        // url: 需要调用的http路径 class:返回值的类对象
        // getForObject 发送get请求 返回值信息为Object
        // 问题 : url写死 无法实现负载均衡
        //String str = restTemplate.getForObject( "http://eureka-product/hello/hello?name="+name, String.class);
        User userByFeign = helloFeign.hello(user);
        return userByFeign;
    }

}
