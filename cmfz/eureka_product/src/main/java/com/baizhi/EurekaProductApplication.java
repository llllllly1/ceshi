package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient 只支持eureka的注册中心
//@EnableDiscoveryClient 支持所有的注册中心
@EnableDiscoveryClient
public class EurekaProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProductApplication.class, args);
    }

}
