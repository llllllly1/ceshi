package com.baizhi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("product")
public interface ProductFeign {
    @RequestMapping("/product/productCount")
    public String productCount(@RequestParam("id") String id,@RequestParam("count") Integer count);
}
