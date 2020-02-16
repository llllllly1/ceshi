package com.baizhi.dao;

import com.baizhi.entity.Product;
import com.baizhi.entity.ProductVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProductDao extends Mapper<Product> {
    ProductVO selectAllProductVO();
}
