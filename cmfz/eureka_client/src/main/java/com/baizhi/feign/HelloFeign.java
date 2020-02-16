package com.baizhi.feign;

import com.baizhi.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// @FeignClient 作用: 声明Feign实例的相关配置 如实例名称,容错请求等
@FeignClient(name = "eureka-product",fallback = HelloFeignImpl.class)
public interface HelloFeign {
    // @RequestMapping : 指定对应controller方法
    @RequestMapping("/product/hello/hello")
    User hello(User user);
}
