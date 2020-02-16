package com.baizhi.controller;

import com.baizhi.dao.OrderItemDao;
import com.baizhi.dao.OrderMasterDao;
import com.baizhi.entity.*;
import com.baizhi.feign.ProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderMasterDao orderMasterDao;
    @Autowired
    OrderItemDao orderItemDao;
    @Autowired
    ProductFeign productFeign;
    @RequestMapping("addOrder")
    @ResponseBody
    public OrderDTO addOrder(@RequestBody OrderVO orderVO){
        // 生产订单
        // 创建订单的整体过程
        OrderMaster orderMaster = new OrderMaster();
        String orderId = UUID.randomUUID().toString();
        orderMaster.setOrderId(orderId);
        orderMaster.setBuyerAddress(orderVO.getAddress());
        orderMaster.setBuyerIphone(orderVO.getPhone());
        orderMaster.setBuyerName(orderVO.getName());
        orderMaster.setBuyerOpenid(orderVO.getOpenId());
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());
        Double am = 0.0;
        List<Product> items= orderVO.getItems();
        for (Object value : items) {
            Product product = (Product)value;
            am += product.getCount() * product.getProductPrice();
        }
        orderMaster.setOrderAmount(am);
        orderMaster.setOrderStatus("0");
        orderMaster.setPayStatus("1");
        orderMasterDao.insert(orderMaster);
        // 创建订单项入库
        // 如果严格安装接口文档编写 需要进行远程调用查询商品信息
        for (Object value : items) {
            Product product = (Product)value;
            OrderItem orderItem = new OrderItem();
            orderItem.setCreateTime(new Date());
            orderItem.setDetailId(UUID.randomUUID().toString());
            orderItem.setOrderId(orderId);
            orderItem.setUpdateTime(new Date());
            orderItem.setProductIcon(product.getProductIcon());
            orderItem.setProductName(product.getProductName());
            orderItem.setProductPrice(product.getProductPrice());
            orderItem.setProductId(product.getProductId());
            orderItem.setProductQuantity(product.getCount());
            orderItemDao.insert(orderItem);
            // 需要进行远程调用
            productFeign.productCount(product.getProductId(),product.getCount());
        }
        OrderDTO success = new OrderDTO("200", "success", orderId);
        return success;
    }
}
