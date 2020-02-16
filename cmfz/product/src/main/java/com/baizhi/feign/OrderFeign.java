package com.baizhi.feign;

import com.baizhi.entity.OrderDTO;
import com.baizhi.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "order")
public interface OrderFeign {
    @RequestMapping("/order/addOrder")
    OrderDTO addOrder(OrderVO orderVO);
}
