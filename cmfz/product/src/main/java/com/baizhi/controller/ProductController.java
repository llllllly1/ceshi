package com.baizhi.controller;

import com.baizhi.dao.CategoryDao;
import com.baizhi.dao.ProductDao;
import com.baizhi.entity.*;
import com.baizhi.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    OrderFeign orderFeign;
    @RequestMapping("showAllProducts")
    public String showAllProducts(HttpSession session){
        List<CategoryVO> categoryVOS = categoryDao.selectAllCategoryVO();
        ProductVO productVO = new ProductVO("200", "success", categoryVOS);
        session.setAttribute("productVO",productVO);
        return "index";
    }
    @RequestMapping("addCart")
    public String addCart(String id,HttpSession session){
        Map<String,Product> cart = (Map) session.getAttribute("cart");
        if (cart==null){
            cart = new HashMap<String,Product>();
            Product product = productDao.selectByPrimaryKey(id);
            product.setCount(1);
            cart.put(id,product);
        }else {
            Product product = cart.get(id);
            if (product==null){
                product = productDao.selectByPrimaryKey(id);
                product.setCount(1);
                cart.put(id,product);
            }else {
                product.setCount(product.getCount()+1);
                cart.put(id,product);
            }
        }
        session.setAttribute("cart",cart);
        return "cart";
    }
    @RequestMapping("createOrder")
    public String createOrder(HttpSession session){
        // OrderDTO 远程调用的返回值
        // OrderVO orderVO 远程调用参数
        // 远程调用
        OrderVO orderVO = new OrderVO();
        orderVO.setName("Rxx");
        orderVO.setAddress("洛阳");
        orderVO.setOpenId("17638343369");
        orderVO.setPhone("17638343369");
        Map<String,Product> cart = (Map) session.getAttribute("cart");
        ArrayList<Product> products = new ArrayList<>();
        for (Product value : cart.values()) {
            products.add(value);
        }
        orderVO.setItems(products);
        orderFeign.addOrder(orderVO);
        return "OK";
    }
    @RequestMapping("productCount")
    @ResponseBody
    public String productCount(String id,Integer count){
        Product product = productDao.selectByPrimaryKey(id);
        product.setProductStock(product.getProductStock()-count);
        System.out.println(product);
        productDao.updateByPrimaryKeySelective(product);
        return "success";
    }
}
